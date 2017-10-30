package co.edu.javeriana.generator.genionic.templates

import co.edu.javeriana.isml.generator.common.SimpleTemplate

import co.edu.javeriana.isml.isml.Controller

class ModuleTemplate extends SimpleTemplate<Controller> { 
	
	override protected template(Controller c) '''
		import { NgModule } from '@angular/core';
		import { IonicPageModule } from 'ionic-angular';
		import { «c.name.toLowerCase.toFirstUpper»Page } from './«c.name.toLowerCase»';
		
		@NgModule({
		  declarations: [
		    «c.name.toLowerCase.toFirstUpper»Page,
		  ],
		  imports: [
		    IonicPageModule.forChild(«c.name.toLowerCase.toFirstUpper»Page),
		  ],
		  exports: [
		    «c.name.toLowerCase.toFirstUpper»Page
		  ]
		})
		export class «c.name.toLowerCase.toFirstUpper»PageModule {}
		
	'''
	override preprocess(Controller c) {
		
	}
	
}