package co.edu.javeriana.generator.genionic.generators

import co.edu.javeriana.generator.genionic.GenionicGenerator
import co.edu.javeriana.isml.generator.common.SimpleGenerator
import co.edu.javeriana.generator.genionic.templates.CssTemplate
import co.edu.javeriana.isml.isml.Page

class CssGenerator extends SimpleGenerator<Page> {
	
	override getOutputConfigurationName() {
		GenionicGenerator.CSS
	}
	
	override protected getFileName(Page e) {
		return e.name.toLowerCase.subSequence(0,e.name.length-1)+"/"+e.name.toLowerCase + ".scss"
		//return e.eContainer?.fullyQualifiedName.toString("/").toLowerCase + "/" + e.name + ".scss"
	}
	override getTemplate() {
		return new CssTemplate 
	}
	

	
}