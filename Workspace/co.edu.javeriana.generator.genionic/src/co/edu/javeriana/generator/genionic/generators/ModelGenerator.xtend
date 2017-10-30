package co.edu.javeriana.generator.genionic.generators

import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import co.edu.javeriana.generator.genionic.GenionicGenerator
import co.edu.javeriana.isml.generator.common.SimpleGenerator

import co.edu.javeriana.isml.isml.Entity
import co.edu.javeriana.generator.genionic.templates.ModelTemplate

class ModelGenerator extends SimpleGenerator<Entity> {
	@Inject extension IQualifiedNameProvider
	
	override getOutputConfigurationName() {
		GenionicGenerator.CONTROLLERS
	}
	
	override protected getFileName(Entity e) {
		return e.name.toLowerCase.subSequence(0,e.name.length-1)+"/"+e.name.toLowerCase + ".ts"
		//return e.eContainer?.fullyQualifiedName.toString("/").toLowerCase + "/" + e.name.toLowerCase + "Entity.ts"
	}
	override getTemplate() {
		return new ModelTemplate
	}
	

	
}