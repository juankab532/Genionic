package co.edu.javeriana.generator.genionic.generators

import java.util.List
import co.edu.javeriana.generator.genionic.GenionicGenerator
import co.edu.javeriana.isml.isml.Controller
import co.edu.javeriana.isml.generator.common.SimpleGenerator
import co.edu.javeriana.generator.genionic.templates.Conf1Template

class Conf1Generator extends SimpleGenerator<List<Controller>> {
	
	override getOutputConfigurationName() {
		GenionicGenerator.CONF1
	}
	
	override protected getFileName(List<Controller> e) {
		return "app.module.ts"
	}
	override getTemplate() {
		return new Conf1Template
	}
}