package co.edu.javeriana.generator.genionic.templates

import co.edu.javeriana.isml.generator.common.SimpleTemplate
import co.edu.javeriana.isml.isml.Entity
import co.edu.javeriana.isml.isml.Attribute
import co.edu.javeriana.isml.scoping.IsmlModelNavigation
import com.google.inject.Inject
import java.util.List
import java.util.ArrayList
import co.edu.javeriana.isml.validation.TypeChecker

class ModelTemplate extends SimpleTemplate<Entity>  { 
	List<String> relatedEntities = new ArrayList<String>();
	
	@Inject extension IsmlModelNavigation 
	@Inject extension ExtraGenionic
	@Inject extension TypeChecker
	
	override protected CharSequence template(Entity e)  '''
		«FOR elm: relatedEntities»
			import { «elm» } from '../«elm.toLowerCase.substring(0,elm.length-1)»/«elm.toLowerCase»';
		«ENDFOR»
		export class «e.name.toFirstUpper»{
			«FOR Attribute attributes : e.attributes»
				«IF(attributes.type.typeSpecification instanceof Entity)»
					«attributes.name»:«generateType(attributes.type.typeSpecification.name)»= new «generateType(attributes.type.typeSpecification.name)»;
				«ELSE»
					«attributes.name»:«generateType(attributes.type.typeSpecification.name)»;
				«ENDIF»
			«ENDFOR»
			«FOR Attribute attributes : e.attributes»
			      get«attributes.name.toFirstUpper»(){
			        return this.«attributes.name»;
			      }
			      set«attributes.name.toFirstUpper»(valor){
			        this.«attributes.name»=valor;
			      }
			«ENDFOR»
		}
		
	'''

	override preprocess(Entity e) {
		
		for(Attribute attributes : e.attributes){
			if(attributes.type.typeSpecification instanceof Entity){
				relatedEntities.add(attributes.type.typeSpecification.name);
			}
		}
		
	}
	
	
}