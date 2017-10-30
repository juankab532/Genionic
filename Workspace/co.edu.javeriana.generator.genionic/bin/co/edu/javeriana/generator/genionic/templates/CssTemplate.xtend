package co.edu.javeriana.generator.genionic.templates

import co.edu.javeriana.isml.generator.common.SimpleTemplate
import co.edu.javeriana.isml.isml.Page

class CssTemplate extends SimpleTemplate<Page> { 
	
	override protected template(Page c) '''
		page-«c.name.toLowerCase» {
		}
	'''
	override preprocess(Page e) {
		
	}
	 
}