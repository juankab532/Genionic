package co.edu.javeriana.generator.genionic.backend.generators

import co.edu.javeriana.generator.genionic.backend.BackendGenerator
import co.edu.javeriana.generator.genionic.backend.templates.ServiceTemplate
import co.edu.javeriana.isml.generator.common.SimpleGenerator
import co.edu.javeriana.isml.isml.Service
import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider

class ServiceGenerator extends SimpleGenerator<Service> {
	@Inject extension IQualifiedNameProvider

	override getFileName(Service e) {
		return e.eContainer?.fullyQualifiedName.toString("/").toLowerCase + "/"+ "impl" +"/" +e.name.toFirstUpper +"Impl"+ ".java"
	}

	override getOutputConfigurationName() {
		BackendGenerator.SERVICE_IMPL
	}
	
	override getTemplate() {
		return new ServiceTemplate
	}

}