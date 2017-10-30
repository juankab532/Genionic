package co.edu.javeriana.generator.genionic.templates

import co.edu.javeriana.isml.isml.Attribute
import co.edu.javeriana.isml.isml.BoolValue
import co.edu.javeriana.isml.isml.Expression
import co.edu.javeriana.isml.isml.FloatValue
import co.edu.javeriana.isml.isml.IntValue
import co.edu.javeriana.isml.isml.MethodCall
import co.edu.javeriana.isml.isml.NullValue
import co.edu.javeriana.isml.isml.Parameter
import co.edu.javeriana.isml.isml.ParameterizedReference
import co.edu.javeriana.isml.isml.Reference
import co.edu.javeriana.isml.isml.StringValue
import co.edu.javeriana.isml.isml.Variable
import co.edu.javeriana.isml.isml.VariableReference
import com.google.common.base.CaseFormat
import co.edu.javeriana.isml.isml.Method
import co.edu.javeriana.isml.isml.ActionCall
import co.edu.javeriana.isml.isml.Entity
import co.edu.javeriana.isml.validation.TypeChecker
import co.edu.javeriana.isml.isml.Service
import co.edu.javeriana.isml.scoping.IsmlModelNavigation
import com.google.inject.Inject
import co.edu.javeriana.isml.isml.Show
import co.edu.javeriana.isml.isml.ViewInstance
import co.edu.javeriana.isml.isml.impl.IntValueImpl

class ExtraGenionic {
	@Inject extension IsmlModelNavigation
	@Inject extension TypeChecker
	
	ControllerTemplate controllerTemplate;
	
	def setControllerTemplate(ControllerTemplate ct){
		this.controllerTemplate=ct;
	}
	
	def CharSequence getValue(Expression e){
		switch e{
			BoolValue		: e.literal.toString
			FloatValue		: e.literal.toString
			IntValueImpl	: e.literal.toString 
			IntValue		: e.literal.toString
			NullValue		: "undefined"
			StringValue		: '"'+e.literal.toString+'"'
			MethodCall		: "call"
			VariableReference: if (hasTail(e)) generateTailedElement(e) else e.referencedElement.name
			default: e.toString
		}
	}
		
	def boolean hasTail(Reference r){
		if(r.tail!=null) return true
		else return false
	}
	
	def CharSequence generateTailedElement(VariableReference vr) {
		var accumulate= ""
		if(vr.referencedElement instanceof Attribute || vr.referencedElement instanceof Method || vr.referencedElement.type.referencedElement instanceof Service){
			accumulate+="this."
		}
		//accumulate+="this."
		var str= generateReferencedElement(vr).toString
		accumulate += str
		var current = vr.tail
		while(current!=null){
			accumulate += "." + generateReferencedElement(current)
			current = current.tail
		}
		return accumulate
	}
	
	def CharSequence generateReferencedElement(Reference reference) {
		switch reference.referencedElement{
			Attribute:'''«reference.referencedElement.name»''' 
			Variable:'''«reference.referencedElement.name»'''
			Parameter:'''«reference.referencedElement.name»'''
			Method:'''«reference.referencedElement.name»(«getParameters(reference as ParameterizedReference)»)«addComplements(reference)»'''
			default: reference.toString 
		}
	}
	/*Adiciona elementos al metodo */
	def CharSequence addComplements(Reference reference){
		
		var action=reference.actionRecursivelly;
		var allShow=action.getShowStatements;
		
		var String lastShow="";
		for(e: allShow){
			if(e instanceof Show){ 
				this.controllerTemplate.lastShowMethod=e;
				val expression = e.expression;
				if(expression instanceof ViewInstance){
					lastShow="return this.navCtrl.push("+expression.type.typeSpecification.name.toLowerCase.toFirstUpper.substring(0,expression.type.typeSpecification.name.length-1)+"cPage, "+generateArray(expression)+");"
				}		
			}
		}
		
		
		var str="";
		val String[] options = #['remove','create','find','save'];
		
		
		for (i : options.size >.. 0) {
			if(reference.referencedElement.name.toLowerCase.equals(options.get(i))){
				str=".then((r)=>{"+lastShow+"}).catch(error =>{alert(error)});"; 
			}
		}
		return str;
	}
	
	def CharSequence getParameters(ParameterizedReference<?> reference) '''«IF reference.parameters.size!=0»«FOR param: reference.parameters SEPARATOR ','»«param.getValue»«ENDFOR»«ENDIF»'''
	
	def toSnakeCase(String string) {
		CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, string)
	}
	def toKebabCase(String string){
		CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_HYPHEN, string)
	}
	
	def CharSequence valueTemplateForEntities(Expression e){ 
		if(e instanceof VariableReference){
			if(e.referencedElement.type.referencedElement instanceof Entity){
				return '''«IF hasTail(e)»«generateTailedElement(e)»«ELSE»«e.referencedElement.name»«ENDIF».id'''
			}
		}
		return getValue(e)
	}
	

	def CharSequence generateParametersActionCall(ActionCall call) {
			var generatedParameters= ''''''
			if(call.parameters.size>0){
				generatedParameters='''«FOR param: call.parameters»{{«valueTemplateForEntities(param)»}}«ENDFOR»'''
			}
			return generatedParameters
	}
	
	/*Obtiene los parametros enviados a una vista */
	def CharSequence generateArray(ViewInstance instance){
		var accumulate= ""
		var string= ""
		for(i : 0..<instance.parameters.size){ 
			var valor=instance.parameters.get(i);
			var name=getValue(valor);
			if(name instanceof String)
				if(!name.equalsIgnoreCase("undefined") && !name.nullOrEmpty)
					accumulate +=name+':'+typeParameter(valor)+""+name + ", "
		}
		if(!accumulate.nullOrEmpty)
		accumulate = accumulate.substring(0, accumulate.length()-2)
		string= "{" +  accumulate + "}"
		return string 
	} 	

	/*Identifica si es un atributo de la clase o si es una variable del método */
	def CharSequence typeParameter(Expression e){
		var type="";
		if(e instanceof VariableReference){
			switch e.referencedElement.type.referencedElement{
				Service		:type="this."
				Attribute	:type="this."
				default: switch e.referencedElement{
							Attribute	:type="this."
							Service		:type="this."
							default		: type=""
						 }
			} 
		}
		'''«type»'''
	}
	
	def CharSequence generateType(String t){
		var type="";
		switch(t){
			case 'String'	: type="string" 
			case 'Integer'	: type="number"
			case 'Boolean'	: type="boolean"
			case 'Long'		: type="number"
			case 'Array'    : type="any=[]"
			case 'Any'    	: type="any"
			case 'List'    	: type="any"
			case 'BytesArray': type="string"
			default : type=t
		}
		return '''«type»''';
	}



}
	
	
	