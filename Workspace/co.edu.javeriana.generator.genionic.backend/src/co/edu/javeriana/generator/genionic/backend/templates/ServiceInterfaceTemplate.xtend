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

class ServiceInterfaceTemplate extends SimpleTemplate<Service> {

	@Inject extension IQualifiedNameProvider
	@Inject extension IsmlModelNavigation
	@Inject extension TypeChecker
	 
	override def CharSequence template(Service service) '''
		package «service.eContainer?.fullyQualifiedName.toLowerCase».interfaces;		
		
		import java.util.*;
		import javax.ejb.Local; 
		import javax.ws.rs.*;		
		import javax.ws.rs.core.*;
		import javax.persistence.Query;
		import backend.entities.*;
		«FOR superType:service.superTypes»
		import «superType.typeSpecification.fullyQualifiedName»;
		«ENDFOR»
		
		/**
		 * This interface represents the local instance for the «service.name.toFirstUpper»Bean EJB 
		 */
		@Local
		@Path("/«service.name.toFirstLower»")
		public interface «service.name.toFirstUpper»{
			
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
					public «service.getReplacedType(feature.type).writeType(true)» «feature.name»(«FOR param:feature.parameters SEPARATOR ','»«service.getReplacedType(param.type).writeType(true)» «param.name.toFirstLower»«ENDFOR»);
					
					«ELSE»
					«IF feature.type.typeSpecification.name.equalsIgnoreCase("void")»					
					@POST
					@Consumes(MediaType.APPLICATION_JSON)
					«ELSE»
					@GET
					@Produces(MediaType.APPLICATION_JSON)
					«ENDIF»	
					@Path("/«feature.name»«IF !feature.isComplexObjectPresentInParameters»«FOR param:feature.parameters »«IF !feature.type.typeSpecification.name.equalsIgnoreCase("void") || (param.type.typeSpecification instanceof Primitive && !param.type.isCollection)»/{«param.name»}«ENDIF»«ENDFOR»«ENDIF»")					
					public «service.getReplacedType(feature.type).writeType(true)» «feature.name»(«FOR parameter : feature.parameters SEPARATOR ','»«IF !feature.type.typeSpecification.name.equalsIgnoreCase("void")»@PathParam("«parameter.name.toFirstLower»")«ELSE»«IF feature.type.typeSpecification.name.equalsIgnoreCase("void") && parameter.type.typeSpecification instanceof Primitive && !parameter.type.isCollection && feature.parameters.size==1»@PathParam("«parameter.name.toFirstLower»")«ELSE»«IF feature.type.typeSpecification.name.equalsIgnoreCase("void") && feature.parameters.size!=1»@QueryParam("«parameter.name.toFirstLower»")«ENDIF»«ENDIF»«ENDIF»«IF feature.type.typeSpecification.name.equalsIgnoreCase("void") && feature.parameters.size!=1»String «parameter.name.toFirstLower»«ELSE»«service.getReplacedType(parameter.type).writeType(true)» «parameter.name.toFirstLower»«ENDIF»«ENDFOR»);
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
					public «service.getReplacedType(feature.type).writeType(true)» «feature.name»(«FOR param:feature.parameters SEPARATOR ','»«service.getReplacedType(feature.type).writeType(true)» «service.name.toFirstLower»«ENDFOR»);
					
					/**
					 * This method executes the proper actions for «feature.name»
					 «FOR param:feature.parameters»
					 * @param «param.name.toFirstLower» Parameter from type «param.type.typeSpecification.name.toFirstUpper»
					 «ENDFOR»
					 «IF feature.type!=null && !feature.type.typeSpecification.name.equalsIgnoreCase("Void")»
					 * @return Some «service.getReplacedType(feature.type).writeType(true)» object
					 «ENDIF»
					 */
					«IF feature.type.typeSpecification.name.equalsIgnoreCase("void")»					
					@POST
					@Consumes(MediaType.APPLICATION_JSON)
					«ELSE»
					@GET
					@Produces(MediaType.APPLICATION_JSON)
					«ENDIF»	
					@Path("/«feature.name»«IF !feature.isComplexObjectPresentInParameters»«FOR param:feature.parameters »«IF !feature.type.typeSpecification.name.equalsIgnoreCase("void") || (param.type.typeSpecification instanceof Primitive && !param.type.isCollection)»/{«param.name»}«ENDIF»«ENDFOR»«ENDIF»")					
					public «service.getReplacedType(feature.type).writeType(true)» «feature.name»(«FOR parameter : feature.parameters SEPARATOR ','»«IF !feature.type.typeSpecification.name.equalsIgnoreCase("void")»@PathParam("«parameter.name.toFirstLower»")«ELSE»«IF feature.type.typeSpecification.name.equalsIgnoreCase("void") && parameter.type.typeSpecification instanceof Primitive && !parameter.type.isCollection && feature.parameters.size==1»@PathParam("«parameter.name.toFirstLower»")«ELSE»«IF feature.type.typeSpecification.name.equalsIgnoreCase("void") && feature.parameters.size!=1»@QueryParam("«parameter.name.toFirstLower»")«ENDIF»«ENDIF»«ENDIF»«IF feature.type.typeSpecification.name.equalsIgnoreCase("void") && feature.parameters.size!=1»String «parameter.name.toFirstLower»«ELSE»«service.getReplacedType(parameter.type).writeType(true)» «parameter.name.toFirstLower»«ENDIF»«ENDFOR»);
					«ELSE»
					«IF feature.type.typeSpecification.name.equalsIgnoreCase("void")»					
					@POST
					@Consumes(MediaType.APPLICATION_JSON)
					«ELSE»
					@GET
					@Produces(MediaType.APPLICATION_JSON)
					«ENDIF»	
					@Path("/«feature.name»«IF !feature.isComplexObjectPresentInParameters»«FOR param:feature.parameters »«IF !feature.type.typeSpecification.name.equalsIgnoreCase("void") || (param.type.typeSpecification instanceof Primitive && !param.type.isCollection)»/{«param.name»}«ENDIF»«ENDFOR»«ENDIF»")					
					public «service.getReplacedType(feature.type).writeType(true)» «feature.name»(«FOR parameter : feature.parameters SEPARATOR ','»«IF !feature.type.typeSpecification.name.equalsIgnoreCase("void")»@PathParam("«parameter.name.toFirstLower»")«ELSE»«IF feature.type.typeSpecification.name.equalsIgnoreCase("void") && parameter.type.typeSpecification instanceof Primitive && !parameter.type.isCollection && feature.parameters.size==1»@PathParam("«parameter.name.toFirstLower»")«ELSE»«IF feature.type.typeSpecification.name.equalsIgnoreCase("void") && feature.parameters.size!=1»@QueryParam("«parameter.name.toFirstLower»")«ENDIF»«ENDIF»«ENDIF»«IF feature.type.typeSpecification.name.equalsIgnoreCase("void") && feature.parameters.size!=1»String «parameter.name.toFirstLower»«ELSE»«service.getReplacedType(parameter.type).writeType(true)» «parameter.name.toFirstLower»«ENDIF»«ENDFOR»);
					«ENDIF»
				«ELSE»
					«IF feature instanceof Attribute»
						/**
						 * Returns the current value for the attribute «feature.name»
						 *
						 * @return Some «service.getReplacedType(feature.type).writeType(true)» object
						 */
						public «service.getReplacedType(feature.type).writeType(true)» get«feature.name.toFirstUpper»();
						
						/**
						 * Sets the value for the attribute «feature.name»
						 *
						 * @param «feature.name.toFirstLower» The value to set
						 */
						public void set«feature.name.toFirstUpper»(«service.getReplacedType(feature.type).writeType(true)» «feature.name.toFirstLower»);
					«ENDIF»
				«ENDIF»				
			«ENDFOR»	
		}	
		
			
	'''
	
 /**
  * 
  *
  *  Metodo que obtiene las dependencias necesarias de los servicios 
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
	
	def boolean hasComplexMethod(Service service){
		for(feature:service.features.filter(Method)){
			if( feature.type.typeSpecification.name.equalsIgnoreCase("void") &&feature.isComplexObjectPresentInParameters && feature.parameters.size!=1){
				return true
			}
		}
		for(superType:service.superTypes){
			for(feature:superType.typeSpecification.features.filter(Method)){
				if( feature.type.typeSpecification.name.equalsIgnoreCase("void") &&feature.isComplexObjectPresentInParameters && feature.parameters.size!=1){
					return true
				}
			}	
		}
		return false
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