package co.edu.javeriana.generator.genionic.generators

import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import co.edu.javeriana.isml.isml.Page
import co.edu.javeriana.generator.genionic.GenionicGenerator
import co.edu.javeriana.isml.isml.Controller
import co.edu.javeriana.isml.generator.common.SimpleGenerator
import co.edu.javeriana.generator.genionic.templates.ControllerTemplate

class ControllerGenerator extends SimpleGenerator<Controller> {
	@Inject extension IQualifiedNameProvider
	
	override getOutputConfigurationName() {
		GenionicGenerator.CONTROLLERS
	}
	
	override protected getFileName(Controller e) {
		return e.name.toLowerCase.subSequence(0,e.name.length-1)+"/"+e.name.toLowerCase + ".ts"
		//return e.eContainer?.fullyQualifiedName.toString("/").toLowerCase + "/" + e.name + ".ts"
	}
	override getTemplate() {
		return new ControllerTemplate
	}
	
}