package co.edu.javeriana.generator.genionic.generators

import co.edu.javeriana.generator.genionic.GenionicGenerator
import co.edu.javeriana.isml.isml.Controller
import co.edu.javeriana.isml.generator.common.SimpleGenerator
import java.util.List
import co.edu.javeriana.generator.genionic.templates.ComponentTemplate

class ComponentGenerator extends SimpleGenerator<List<Controller>>  {
	
	override getOutputConfigurationName() {
		GenionicGenerator.COMPONENT;
	}
	
	override protected getFileName(List<Controller> e) {
		return "app.component.ts"
	}
	override getTemplate() {
		return new ComponentTemplate
	}
	

	
}