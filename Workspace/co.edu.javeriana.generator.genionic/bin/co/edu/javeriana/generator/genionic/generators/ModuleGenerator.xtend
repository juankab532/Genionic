package co.edu.javeriana.generator.genionic.generators

import co.edu.javeriana.generator.genionic.GenionicGenerator
import co.edu.javeriana.isml.generator.common.SimpleGenerator
import co.edu.javeriana.generator.genionic.templates.ModuleTemplate
import co.edu.javeriana.isml.isml.Controller

class ModuleGenerator extends SimpleGenerator<Controller> {
	
	override getOutputConfigurationName() {
		GenionicGenerator.MODULES
	}
	
	override protected getFileName(Controller e) {
		return e.name.toLowerCase.subSequence(0,e.name.length-1)+"/"+e.name.toLowerCase + ".module.ts"
		//return e.eContainer?.fullyQualifiedName.toString("/").toLowerCase + "/" + e.name + ".module.ts"
	}
	override getTemplate() {
		return new ModuleTemplate 
	}
	

	
}