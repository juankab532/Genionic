package co.edu.javeriana.generator.genionic.backend.templates

import co.edu.javeriana.isml.generator.common.SimpleTemplate
import co.edu.javeriana.isml.isml.Attribute
import co.edu.javeriana.isml.isml.Entity
import co.edu.javeriana.isml.isml.GenericTypeSpecification
import co.edu.javeriana.isml.isml.Method
import co.edu.javeriana.isml.isml.ParameterizedType
import co.edu.javeriana.isml.isml.Primitive
import co.edu.javeriana.isml.isml.Service
import co.edu.javeriana.isml.isml.TypeSpecification
import co.edu.javeriana.isml.scoping.IsmlModelNavigation
import co.edu.javeriana.isml.validation.TypeChecker
import com.google.inject.Inject
import java.util.HashMap
import java.util.Map
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName
import co.edu.javeriana.isml.isml.Type
import co.edu.javeriana.isml.isml.Function

class ServiceTemplate extends SimpleTemplate<Service> {

	@Inject extension IQualifiedNameProvider
	@Inject extension IsmlModelNavigation
	@Inject extension TypeChecker

	/**
	 * Metodo que retorna la implementación de los servicios
	 * 
	 */
	override def CharSequence template(Service service) '''
		package «service.eContainer?.fullyQualifiedName.toLowerCase».impl;				
		
		«FOR entity : getNeededImportsInMethods(service).entrySet»
			import «entity.value.fullyQualifiedName»;
		«ENDFOR»
		«FOR parent : service.superTypes»
			«FOR entity : getNeededImportsInMethods(parent.typeSpecification).entrySet»
				import «entity.value.fullyQualifiedName»;
			«ENDFOR»
		«ENDFOR»
			
		import java.util.*;
		import java.io.Serializable;
		import javax.ejb.Stateless;
		import javax.persistence.EntityManager;
		import javax.persistence.PersistenceContext;
		import javax.persistence.Query;
		import common.services.Persistence;
		import backend.entities.*;
		 
		import «service.eContainer?.fullyQualifiedName.toLowerCase».interfaces.«service.name.toFirstUpper»;
		
		
		/**
		 * This class represents an EJB named «service.name.toFirstUpper»Impl
		 */
		@Stateless
		public class «service.name.toFirstUpper»Impl«IF !service.genericTypeParameters.isEmpty»<«FOR param:service.genericTypeParameters SEPARATOR ','»«param.name»«ENDFOR»>«ENDIF» «IF !service.superTypes.empty»extends «service.superTypes.get(0).typeSpecification.name.toFirstUpper»«IF service.superTypes.get(0).typeSpecification instanceof Service»«IF service.superTypes.get(0)instanceof ParameterizedType»<«FOR param: (service.superTypes.get(0)as ParameterizedType).typeParameters SEPARATOR ','»«param.writeType(true)»«ENDFOR»>«ENDIF»«ENDIF»«ENDIF» implements «service.name.toFirstUpper»«IF !service.genericTypeParameters.isEmpty»<«FOR param:service.genericTypeParameters SEPARATOR ','»«param.name»«ENDFOR»>«ENDIF»,Serializable{
			
		   @PersistenceContext
		    private EntityManager entityManager;
			
			protected  EntityManager getEntityManager() {
				return entityManager;
			}
			
			«FOR gen:service.genericTypeParameters»
				/**
				 * Class Object represented by "«gen.name»" class parameter
				 */
				private Class<«gen.name»> clazz«gen.name»Object;
			«ENDFOR»
			«FOR type : service.superTypes»	
				«FOR attr : type.typeSpecification.features»
					«IF attr instanceof Attribute»
						/**
						 * The attribute «attr.name.toFirstLower»
						 */
						private «attr.type.writeType(true)» «attr.name.toFirstLower»;
					«ENDIF»
				«ENDFOR»
			«ENDFOR»
			
			«FOR attr : service.features»
				«IF attr instanceof Attribute»
					/**
					 * The attribute «attr.name.toFirstLower»
					 */
					private «attr.type.writeType(true)» «attr.name.toFirstLower»;
				«ENDIF»
			«ENDFOR»
			
			«IF !service.genericTypeParameters.isEmpty»
			/**
			 * Service default constructor for Generic types
			 *
			 «FOR gen:service.genericTypeParameters»
			 * @param clazz«gen.name»Object It's the generic clazz for '«gen.name»' generic parameter 
			«ENDFOR»
			 */
			public «service.name.toFirstUpper»Imp(«FOR gen:service.genericTypeParameters SEPARATOR ','»Class<«gen.name»> clazz«gen.name»Object«ENDFOR»){
				«FOR gen:service.genericTypeParameters»				
				this.clazz«gen.name»Object=clazz«gen.name»Object;
				«ENDFOR»
			}
			«ENDIF»
			
			/**
			 * Service default constructor
			 */
			public «service.name.toFirstUpper»Impl(){
				«FOR superType:service.superTypes»
				«IF superType instanceof ParameterizedType»
				super(«FOR param:superType.typeParameters SEPARATOR ','»«param.writeType(true)».class«ENDFOR»);
				«ENDIF»
				«ENDFOR»
			}
			
			«FOR type : service.superTypes»	
				«FOR feature : type.typeSpecification.features»
					«IF feature instanceof Method»					
					/**
					 * This method executes the proper actions for «feature.name»
					 «FOR param:feature.parameters»
					 * @param «param.name.toFirstLower» Parameter from type «param.type.typeSpecification.name.toFirstUpper»
					 «ENDFOR»
					 «IF feature.type!=null && !feature.type.typeSpecification.name.equalsIgnoreCase("Void")»
					 * @return Some «service.getReplacedType(feature.type).writeType(true)» object
					 «ENDIF»
					 */
					«IF feature.type.typeSpecification.name.equalsIgnoreCase("void") &&feature.isComplexObjectPresentInParameters && feature.parameters.size!=1»
					@Override
					public «service.getReplacedType(feature.type).writeType(true)» «feature.name»(«FOR param:feature.parameters SEPARATOR ','»«service.getReplacedType(param.type).writeType(true)» «param.name.toFirstLower»«ENDFOR»){
						«IF !feature.type.typeSpecification.name.equalsIgnoreCase("Void")»
							return super.«feature.name»(«FOR parameter : feature.parameters SEPARATOR ','»«parameter.name.toFirstLower»«ENDFOR»);
						«ELSE»
							super.«feature.name»(«FOR parameter : feature.parameters SEPARATOR ','»«parameter.name.toFirstLower»«ENDFOR»);	
						«ENDIF»
					}					
		
					«ELSE»
					@Override
					public «service.getReplacedType(feature.type).writeType(true)» «feature.name»(«FOR parameter : feature.parameters SEPARATOR ','»«IF feature.type.typeSpecification.name.equalsIgnoreCase("void") && feature.parameters.size!=1»String «parameter.name.toFirstLower»«ELSE»«service.getReplacedType(parameter.type).writeType(true)» «parameter.name.toFirstLower»«ENDIF»«ENDFOR»){
						«IF !feature.type.typeSpecification.name.equalsIgnoreCase("Void")»
							return super.«feature.name»(«FOR parameter : feature.parameters SEPARATOR ','»«parameter.name.toFirstLower»«ENDFOR»);
						«ELSE»
							super.«feature.name»(«FOR parameter : feature.parameters SEPARATOR ','»«parameter.name.toFirstLower»«ENDFOR»);	
						«ENDIF»
					}
					«ENDIF»
					«ELSE»
					«IF feature instanceof Attribute»
						/**
						 * Returns the current value for the attribute «feature.name»
						 *
						 * @return Some «service.getReplacedType(feature.type).writeType(true)» object
						 */
						@Override
						public «service.getReplacedType(feature.type).writeType(true)» get«feature.name.toFirstUpper»(){
							return «feature.name.toFirstLower»;
						}
						
						/**
						 * Sets the value for the attribute «feature.name»
						 *
						 * @param «feature.name.toFirstLower» The value to set
						 */
						@Override
						public void set«feature.name.toFirstUpper»(«service.getReplacedType(feature.type).writeType(true)» «feature.name.toFirstLower»){
							this.«feature.name.toFirstLower»=«feature.name.toFirstLower»;
						}
					«ENDIF»
					«ENDIF»
				«ENDFOR»
			«ENDFOR»
			
			«FOR feature : service.features»
				«IF feature instanceof Method»
					/**
					 * This method executes the proper actions for «feature.name»
					 «FOR param:feature.parameters»
					 * @param «param.name.toFirstLower» Parameter from type «param.type.typeSpecification.name.toFirstUpper»
					 «ENDFOR»
					 «IF feature.type!=null && !feature.type.typeSpecification.name.equalsIgnoreCase("Void")»
					 * @return Some «service.getReplacedType(feature.type).writeType(true)» object
					 «ENDIF»
					 */
					«IF feature.type.typeSpecification.name.equalsIgnoreCase("void") &&feature.isComplexObjectPresentInParameters && feature.parameters.size!=1»
					@Override
					public «service.getReplacedType(feature.type).writeType(true)» «feature.name»(«FOR param:feature.parameters SEPARATOR ','»«service.getReplacedType(param.type).writeType(true)» «param.name.toFirstLower»«ENDFOR»){
						«IF !feature.type.typeSpecification.name.equalsIgnoreCase("Void")»
							return null;
						«ENDIF»
					}
					/**
					 * This method executes the proper actions for «feature.name»
					 «FOR param:feature.parameters»
					 * @param «param.name.toFirstLower» Parameter from type «param.type.typeSpecification.name.toFirstUpper»
					 «ENDFOR»
					 «IF feature.type!=null && !feature.type.typeSpecification.name.equalsIgnoreCase("Void")»
					 * @return Some «service.getReplacedType(feature.type).writeType(true)» object
					 «ENDIF»
					 */
					@Override
					public «service.getReplacedType(feature.type).writeType(true)» «feature.name»REST(«FOR parameter : feature.parameters SEPARATOR ','»«IF feature.type.typeSpecification.name.equalsIgnoreCase("void") && feature.parameters.size!=1»String «parameter.name.toFirstLower»«ELSE»«service.getReplacedType(parameter.type).writeType(true)» «parameter.name.toFirstLower»«ENDIF»«ENDFOR») throws JSONException, JsonParseException, JsonMappingException, IOException{
						«FOR param:feature.parameters»
						«service.getReplacedType(param.type).writeType(true)» «param.name»Var=«IF param.type.typeSpecification instanceof Primitive && !param.type.isCollection»«IF param.type.typeSpecification.name.equalsIgnoreCase("String")»«param.name»«ELSE»«service.getReplacedType(param.type).writeType(true)».parse«service.getReplacedType(param.type).writeType(true)»(«param.name»)«ENDIF»«ELSE»«IF param.type.isCollection»(«service.getReplacedType(param.type).writeType(true)»)JSONConverterUtil.convertFromJSONArray(«service.getReplacedType((param.type as ParameterizedType).typeParameters.get(0)).writeType(true)».class,«param.name»)«ELSE»JSONConverterUtil.convertFromJSONObject(«service.getReplacedType(param.type).writeType(true)».class,«param.name»)«ENDIF»«ENDIF»;
						«ENDFOR»
						this.«feature.name»(«FOR param:feature.parameters SEPARATOR ','»«param.name.toFirstLower»Var«ENDFOR»);
					}
					«ELSE»
					@Override
					public «service.getReplacedType(feature.type).writeType(true)» «feature.name»(«FOR parameter : feature.parameters SEPARATOR ','»«IF feature.type.typeSpecification.name.equalsIgnoreCase("void") && feature.parameters.size!=1»String «parameter.name.toFirstLower»«ELSE»«service.getReplacedType(parameter.type).writeType(true)» «parameter.name.toFirstLower»«ENDIF»«ENDFOR»){
						«IF !feature.type.typeSpecification.name.equalsIgnoreCase("Void")»
							return null;
						«ENDIF»
					}
					«ENDIF»
				«ELSE»
					«IF feature instanceof Attribute»
						/**
						 * Returns the current value for the attribute «feature.name»
						 *
						 * @return Some «service.getReplacedType(feature.type).writeType(true)» object
						 */
						@Override
						public «service.getReplacedType(feature.type).writeType(true)» get«feature.name.toFirstUpper»(){
							return «feature.name.toFirstLower»;
						}
						
						/**
						 * Sets the value for the attribute «feature.name»
						 *
						 * @param «feature.name.toFirstLower» The value to set
						 */
						@Override
						public void set«feature.name.toFirstUpper»(«service.getReplacedType(feature.type).writeType(true)» «feature.name.toFirstLower»){
							this.«feature.name.toFirstLower»=«feature.name.toFirstLower»;
						}
					«ENDIF»
				«ENDIF»
			«ENDFOR»		
		}	
		
			
	'''
/**
 * 
 * 
 */
	def Map<QualifiedName,TypeSpecification> getNeededImportsInMethods(TypeSpecification service) {
		var Map<QualifiedName,TypeSpecification> imports = new HashMap
		for (feature : service.features) {
			if (!feature.type.isCollection) {
				if (feature.type != null && !feature.type.typeSpecification.eContainer.fullyQualifiedName.equals(
					service.eContainer.fullyQualifiedName)) {
					if (!(feature.type.typeSpecification instanceof Primitive)) {
						if (!(feature.type.typeSpecification instanceof GenericTypeSpecification)){
							if(!imports.containsKey(feature.type.typeSpecification.fullyQualifiedName)){
								imports.put(feature.type.typeSpecification.fullyQualifiedName,feature.type.typeSpecification)					
							}						
						}
					}
				}			
			}else {
				if (feature.type instanceof ParameterizedType) {
					if (feature.type != null && !(feature.type as ParameterizedType).typeParameters.get(0).
						typeSpecification.eContainer.fullyQualifiedName.equals(service.eContainer.fullyQualifiedName)) {
						if (!((feature.type as ParameterizedType).typeParameters.get(0).typeSpecification instanceof Primitive)) {
							if (!((feature.type as ParameterizedType).typeParameters.get(0).typeSpecification instanceof GenericTypeSpecification)){
								if(!imports.containsKey((feature.type as ParameterizedType).typeParameters.get(0).typeSpecification.fullyQualifiedName)){
									imports.put((feature.type as ParameterizedType).typeParameters.get(0).typeSpecification.fullyQualifiedName,
										(feature.type as ParameterizedType).typeParameters.get(0).typeSpecification)
									
								}							
							}
						}
					}
				}
			}
			if (feature instanceof Method) {				
				for (param : feature.parameters) {					
					if (!param.type.isCollection) {
						if (!param.type.typeSpecification.eContainer.fullyQualifiedName.equals(
							service.eContainer.fullyQualifiedName)) {
							if (!(param.type.typeSpecification instanceof Primitive)) {
								if (!(param.type.typeSpecification instanceof GenericTypeSpecification)) {
									if(!imports.containsKey(param.type.typeSpecification.fullyQualifiedName)){
										imports.put(param.type.typeSpecification.fullyQualifiedName,param.type.typeSpecification)							
									}								
								}
							}
						}						
					} else {
						if (param.type instanceof ParameterizedType) {
							if (!(param.type as ParameterizedType).typeParameters.get(0).typeSpecification.eContainer.
								fullyQualifiedName.equals(service.eContainer.fullyQualifiedName)) {
								if (!((param.type as ParameterizedType).typeParameters.get(0).typeSpecification instanceof Primitive)) {
									if (!((param.type as ParameterizedType).typeParameters.get(0).typeSpecification instanceof GenericTypeSpecification)) {
										if(!imports.containsKey((param.type as ParameterizedType).typeParameters.get(0).typeSpecification.fullyQualifiedName)){
											imports.put((param.type as ParameterizedType).typeParameters.get(0).typeSpecification.fullyQualifiedName,
												(param.type as ParameterizedType).typeParameters.get(0).typeSpecification as Entity)											
										}									
									}
								}
							}
						}
					}									
				}
				if(feature.body!=null){
					for(stmnt:feature.body){
						isNeededImportInBody(stmnt.eAllContents.toList,imports,service)
					}				
				}
			}
		}
		return imports
	}
	
	def boolean isComplexObjectPresentInParameters(Method feature){
		for(param:feature.parameters){
			if(!(param.type.typeSpecification instanceof Primitive)|| param.type.isCollection){
				return true
			}
		}
		return false
	}
	def String writeType(Type type, boolean complete) {
		var String typeString = ""

			switch (type.typeSpecification.name) {
				case "Any": 	typeString = "Object"
				case "Type": 	typeString = type.classValue
				case "Void": 	typeString = "void"
				case "Null": 	typeString = "null"
				case "Integer": typeString = "Long"
				case "Array": 	typeString = "List"
				default: 		typeString = type.typeString
			}
		return typeString;
	}
	
	
}