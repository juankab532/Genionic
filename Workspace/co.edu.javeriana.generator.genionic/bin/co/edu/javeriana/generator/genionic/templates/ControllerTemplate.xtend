package co.edu.javeriana.generator.genionic.templates

import co.edu.javeriana.isml.generator.common.SimpleTemplate
import com.google.inject.Inject
import co.edu.javeriana.isml.isml.Controller
import co.edu.javeriana.isml.isml.Parameter

import co.edu.javeriana.isml.isml.Show
import co.edu.javeriana.isml.isml.ActionCall
import co.edu.javeriana.isml.isml.Return
import co.edu.javeriana.isml.isml.If
import co.edu.javeriana.isml.isml.While
import co.edu.javeriana.isml.isml.For
import co.edu.javeriana.isml.scoping.IsmlModelNavigation
import co.edu.javeriana.isml.isml.Action
import java.util.List
import co.edu.javeriana.isml.isml.MethodStatement
import co.edu.javeriana.isml.isml.ViewInstance
import co.edu.javeriana.isml.isml.Variable
import co.edu.javeriana.isml.isml.VariableReference
import co.edu.javeriana.isml.isml.Type

import co.edu.javeriana.isml.isml.MethodCall
import co.edu.javeriana.isml.isml.ResourceReference
import co.edu.javeriana.isml.isml.Assignment

import co.edu.javeriana.isml.isml.Attribute
import co.edu.javeriana.isml.isml.StringValue

import java.util.Map
import java.util.HashMap
import java.util.Map.Entry
import java.util.HashSet
import java.util.Iterator
import co.edu.javeriana.isml.isml.Entity
import co.edu.javeriana.isml.isml.Service
import java.util.LinkedHashSet
import java.util.Set
import co.edu.javeriana.isml.isml.TypedElement
import co.edu.javeriana.isml.isml.NamedElement
import java.util.ArrayList
import co.edu.javeriana.isml.isml.Page
import co.edu.javeriana.isml.isml.ParameterizedType
import co.edu.javeriana.isml.isml.BinaryOperator
import co.edu.javeriana.isml.isml.StructInstance
import co.edu.javeriana.isml.isml.impl.IntValueImpl

class ControllerTemplate extends SimpleTemplate<Controller> {  
	@Inject extension IsmlModelNavigation
	@Inject extension ExtraGenionic
	var Controller ctrl;
	var List<MethodStatement>  elementsMethod;
	var HashSet<String> valueSet = new HashSet<String>();
	
	List<TypedElement> imports= new ArrayList<TypedElement>
	Set<Entity> entities= new LinkedHashSet<Entity>
	Set<Service> services = new LinkedHashSet<Service>
	Set<Page> calledPages = new LinkedHashSet<Page>
	Set<Page> relatedPages = new LinkedHashSet<Page>
	public Show lastShowMethod;
	
	override preprocess(Controller c) {
		setControllerTemplate(this);
		this.ctrl=c;
		val descendants = c.eAllContents.filter(TypedElement).toList
		imports.addAll(descendants) 
		for(desc: descendants){
			val NamedElement e= desc.type?.typeSpecification
			
			if(e instanceof Entity)			entities.add(e)
			else if(e instanceof Service)	services.add(e)
			else if(e instanceof Page) 		calledPages.add(e)
			
		}
		for(Page p: getControlledPages(c)){
			relatedPages.add(p);
		}
	}
	
	
	override protected template(Controller c) '''
		import { Component } from '@angular/core';
		import { IonicPage, NavController, NavParams } from 'ionic-angular';
		import { Persistence } from "../../providers/persistence/persistence";
		import { Http } from '@angular/http';
		import { CameraService } from "../../providers/camera-service/camera-service";
		import { MapService } from "../../providers/map-service/map-service";
		
		«FOR elm: entities»
			«IF elm.name.equalsIgnoreCase(c.name.toLowerCase.toFirstUpper.subSequence(0,c.name.length-1)+"E")»
				import { «elm.name» } from './«elm.name.toLowerCase»';
			«ELSE»
				import { «elm.name» } from '../«elm.name.toLowerCase.substring(0,elm.name.length-1)»/«elm.name.toLowerCase»';
			«ENDIF»
		«ENDFOR»
		«FOR elm: calledPages»
			«IF !elm.name.equalsIgnoreCase(c.name.toLowerCase.toFirstUpper.subSequence(0,c.name.length-1)+"V")»
				import { «elm.name.toLowerCase.toFirstUpper.substring(0,elm.name.length-1)»cPage } from '../«elm.name.toLowerCase.substring(0,elm.name.length-1)»/«elm.name.toLowerCase.substring(0,elm.name.length-1)»c';
			«ENDIF»	
		«ENDFOR»
		
		@IonicPage()
		@Component({
		  selector: 'page-«c.name.toLowerCase.substring(0,c.name.length-1)+"v"»',
		  templateUrl: '«c.name.toLowerCase.substring(0,c.name.length-1)+"v"».html',
		})
		export class «c.name.toLowerCase.toFirstUpper»Page {
			
			«FOR attr: c.body.filter(Attribute)»
				«IF !attr.type.typeSpecification.name.equalsIgnoreCase("CameraService") && !attr.type.typeSpecification.name.equalsIgnoreCase("MapService")»
					«attr.name»:«generateType(attr.type.typeSpecification.name)»;
				«ENDIF»
			«ENDFOR»
			
			constructor(public navCtrl		: NavController, 
						public navParams	: NavParams,
						public cam			: CameraService,
						public mapService   : MapService,
						public http			: Http
						) {
				/*Asigna la Persistencia*/
				«FOR attr: c.body.filter(Attribute)»
					«IF attr.type.typeSpecification.name.equalsIgnoreCase("Persistence")»
						this.«attr.name»= new «generateType(attr.type.typeSpecification.name)»(http);
					«ENDIF»
				«ENDFOR»
				/*Asigna la ruta del servicio a la persistencia*/
				«FOR attr: c.body.filter(Attribute)»
						«IF attr.type.typeSpecification.name.equalsIgnoreCase("Persistence")»
						  «var typeEntity=attr.type»«IF (typeEntity instanceof ParameterizedType)»this.«attr.name».service='«typeEntity.typeParameters.get(0).typeSpecification.name.toLowerCase.substring(0,typeEntity.typeParameters.get(0).typeSpecification.name.length-1)»c';«ENDIF»
						«ENDIF»
				«ENDFOR»
						
				«FOR func: c.actions»
					«getParametersController(func)»
				«ENDFOR»	
			
			}
				  	
			//Metodos		  
			«FOR func: c.actions»
			«generateFunction(func)»
			«ENDFOR»	
		}
	'''
	/*Obtiene los parametros enviados a la vista */
	def CharSequence getParametersController(Action a){
		val ab=a.body;

		
		var txt="";
		for(element: ab){ 
			if(element instanceof Show){
				
				val expression = element.expression;
				if(expression instanceof ViewInstance){
					if(expression.type.typeSpecification.name.equalsIgnoreCase(this.ctrl.name.toLowerCase.toFirstUpper.subSequence(0,this.ctrl.name.length-1)+"V")){
						for(p : expression.parameters){
							if (this.valueSet.add(p.getValue.toString)) {
								txt+= typeParameter(p)+""+p.getValue+"=this.navParams.get('"+p.getValue+"');";						
							} 
						}
					}
				}
			}			
		}
		
		return txt;
	}
	/*Genera un método*/
	def CharSequence generateFunction(Action action)'''
		«action.name»(«IF action.parameters.size >0»«getParameters(action)»«ENDIF»){
			«generateBody(action.body)»
		}
	'''
	/*Recorre cada uno de los elementos  de un método */
	def CharSequence generateBody(List<MethodStatement> lms){
		this.elementsMethod=lms;
		this.lastShowMethod=null; 
	'''
		«FOR sentence: lms»
			«IF lastShowMethod != sentence»
				«generateMethodStatement(sentence)»
			«ENDIF»
		«ENDFOR»
	'''}
	
	def dispatch generateMethodStatement(Show show){
		val expression = show.expression;
		var txt="";
		switch(expression){
			ViewInstance:txt="return this.navCtrl.push("+expression.type.typeSpecification.name.toLowerCase.toFirstUpper.substring(0,expression.type.typeSpecification.name.length-1)+"cPage, "+generateArray(expression)+");"
			default:txt=""
		}
		return txt;
	}
	def dispatch CharSequence generateMethodStatement(Variable variable){
		if(!variable.type.typeSpecification.name.contains("Service")){
			val tipo=variable.value;
			'''var «variable.name»:«generateType(variable.type.typeSpecification.name)»=«IF(tipo!=null && tipo instanceof StringValue)»«variable.getValue.getValue»«ELSEIF(tipo!=null && variable.getValue instanceof VariableReference)»«getValue(variable.getValue as VariableReference)»«variable.getValue.getValue»«ELSEIF(tipo instanceof BinaryOperator)»«generateMethodStatement(tipo)»«ELSEIF(tipo instanceof StructInstance)»«generateMethodStatement(tipo)»«ELSEIF(tipo instanceof IntValueImpl)»«generateMethodStatement(tipo)»«ELSE»«tipo.toString»«ENDIF»'''
		}
	}
	def dispatch CharSequence generateMethodStatement(VariableReference vr)
	'''«IF (vr.tail != null)»«vr.getValue»«ELSE»«vr.typeParameter»«vr.getValue»«ENDIF»'''
	
	def dispatch CharSequence generateMethodStatement(Type type){return ''''''}
	
	def dispatch CharSequence generateMethodStatement(ResourceReference resref){return ''''''}
	
	def dispatch CharSequence generateMethodStatement(MethodCall mcst){''' «mcst.method.name»(«FOR parameter : mcst.parameters SEPARATOR ','»«parameter.typeParameter»«generateMethodStatement(parameter)»«ENDFOR»)'''}
	
	def dispatch CharSequence generateMethodStatement(ActionCall acst)'''return this.«acst.action.name»(«IF acst.action.parameters.size !=0», «getParameters(acst.action)»«ENDIF»)'''
	
	def dispatch CharSequence generateMethodStatement(While whilest){return ''''''}
	
	def dispatch CharSequence generateMethodStatement(For forst)'''
		for(«forst.collection.getValue» of «forst.variable.generateMethodStatement»){
			«generateBody(forst.body)»
		}
	'''
	
	def dispatch CharSequence generateMethodStatement(If ifst)'''
		if(«ifst.condition.value»){
			«generateBody(ifst.body)»
		}
	'''
	def dispatch CharSequence generateMethodStatement(Return returnst){return ''''''}
	
	def dispatch CharSequence generateMethodStatement(Assignment assign){
		val texto=extendAssignment(assign);
		if(texto.length>0){
			'''«texto»'''
		}else{
			'''«generateMethodStatement(assign.left)» «writeSymbol(assign.symbol)» «generateMethodStatement(assign.right)»'''
		}	 
	} 
	
	def dispatch CharSequence generateMethodStatement(BinaryOperator expression) '''«generateMethodStatement(expression.left)» «writeSymbol(expression.symbol)» «generateMethodStatement(expression.right)»''' 
	
	def dispatch CharSequence generateMethodStatement(StringValue expression) '''«expression.getValue»''' 
	
	def dispatch CharSequence generateMethodStatement(StructInstance expression) '''new «expression.type.typeSpecification.name»'''  
	
	def dispatch CharSequence generateMethodStatement(IntValueImpl expresion)'''«expresion.literal»'''
	
	/**
	 * Este método escribe el equivalente en java de los símbolos (Operadores Binarios)
	 * utilizados en el lenguaje ISML
	*/
	def CharSequence writeSymbol(String symbol) {
		if (symbol.equals("and")) {
			return "&&"
		} else if (symbol.equals("or")) {
			return "||"
		} else if (symbol.equals("not")) {
			return "!"
		} else {
			return symbol 
		}
	}
	
	
	
	/*Genere el código especifico para Ionic para la persistencia y los plugins del celular */
	def CharSequence extendAssignment(Assignment assign){
		val operadorLeft	=assign.left.getValue.toString;
		val operadorRight	=assign.right.getValue.toString;	
		
		var str="";
		val String[] options = #['findall','execute'];
		
		for (i : options.size >.. 0) {
			if(operadorLeft.toLowerCase.contains(options.get(i)) || operadorRight.toLowerCase.contains(options.get(i))){
				var String lastShow="";
				//Obtiene la ultima vista del metodo para hacer su llamado en el callback
				for(e: this.elementsMethod){if(e instanceof Show){this.lastShowMethod=e; lastShow=""+generateMethodStatement(e);}}
				str=""+generateMethodStatement(assign.right as VariableReference)+".then((r)=>{"+typeParameter(assign.left)+assign.left.getValue+"=r; "+lastShow+"}).catch(error =>{alert(error)});"; 
			}
		}
		if(operadorLeft.toLowerCase.contains('takepicture') || operadorRight.toLowerCase.contains('takepicture')){
			
			var String lastShow="";
			//Obtiene la ultima vista del metodo para hacer su llamado en el callback
			for(e: this.elementsMethod){if(e instanceof Show){this.lastShowMethod=e; lastShow=""+generateMethodStatement(e);}}
			str=""+generateMethodStatement(assign.right as VariableReference)+".then((r)=>{"+assign.left.getValue+"=r+'';"+lastShow+"}).catch(error =>{alert(error);});"; 
		
		}
				
		return str;
	}
	
	
	def CharSequence getParameters(Action action) 
	'''«IF action.parameters.size !=0»«FOR param: action.parameters SEPARATOR ','»«generateParams(param)»«ENDFOR»«ELSE»«ENDIF»'''
	
	def CharSequence generateParams(Parameter p){
		return '''«p.name»:«generateType(p.type.typeSpecification.name)»'''
	}
	

	def Map<String, String>  removeTheFirstNameDuplicates (Map<String, String> map) {
	    var Iterator<Entry<String, String>> iter = map.entrySet().iterator();
	    var HashSet<String> valueSet = new HashSet<String>();
	    while (iter.hasNext()) {
	        var Entry<String, String> next = iter.next();
	        if (!valueSet.add(next.getValue())) {
	            iter.remove();
	        }
	    }
	    return map;
	}
	
	
}