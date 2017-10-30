package co.edu.javeriana.generator.genionic.backend.generators

import co.edu.javeriana.generator.genionic.backend.BackendGenerator
import co.edu.javeriana.generator.genionic.backend.templates.EntityTemplate
import co.edu.javeriana.isml.generator.common.SimpleGenerator
import co.edu.javeriana.isml.isml.Entity
import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider

class EntityGenerator extends SimpleGenerator<Entity> {
	@Inject extension IQualifiedNameProvider

	override getFileName(Entity e) {
		return e.eContainer?.fullyQualifiedName.toString("/").toLowerCase + "/" + e.name + ".java"
	}

	override getOutputConfigurationName() {
		BackendGenerator.ENTITIES
	}
	
	override getTemplate() {
		return new EntityTemplate 

	}

}