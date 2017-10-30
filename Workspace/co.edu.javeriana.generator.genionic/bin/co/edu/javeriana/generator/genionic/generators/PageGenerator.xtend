package co.edu.javeriana.generator.genionic.generators

import co.edu.javeriana.isml.generator.common.SimpleGenerator
import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import co.edu.javeriana.isml.isml.Page
import co.edu.javeriana.generator.genionic.GenionicGenerator
import co.edu.javeriana.generator.genionic.templates.PageTemplate

class PageGenerator extends SimpleGenerator<Page> { 
	
	@Inject extension IQualifiedNameProvider
	
	override getOutputConfigurationName() {
		GenionicGenerator.VIEWS
	}
	
	override protected getFileName(Page e) {
		return e.name.toLowerCase.subSequence(0,e.name.length-1)+"/"+e.name.toLowerCase + ".html"
		//return e.eContainer?.fullyQualifiedName.toString("/").toLowerCase + "/" + e.name.toLowerCase + ".html"
	}
	
	override getTemplate() {
		return new PageTemplate
	}
	

}
