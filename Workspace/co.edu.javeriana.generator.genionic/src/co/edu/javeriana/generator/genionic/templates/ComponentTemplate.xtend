package co.edu.javeriana.generator.genionic.templates

import co.edu.javeriana.isml.generator.common.SimpleTemplate
import java.util.List
import co.edu.javeriana.isml.isml.Controller
import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import co.edu.javeriana.isml.isml.Page
import java.util.Set
import java.util.LinkedHashSet
import co.edu.javeriana.isml.scoping.IsmlModelNavigation
import co.edu.javeriana.isml.isml.ViewStatement
import org.eclipse.emf.common.util.EList
import co.edu.javeriana.isml.isml.ViewInstance
import java.util.ArrayList

class ComponentTemplate extends SimpleTemplate<List<Controller>>  { 
	@Inject extension IQualifiedNameProvider
	@Inject extension IsmlModelNavigation
	@Inject extension ExtraGenionic
	
	Set<Page> relatedPages = new LinkedHashSet<Page>;
	List<String> elementsMenu = new ArrayList<String>();
	List<String> pages = new ArrayList<String>();
	override protected template(List<Controller> e) '''
		import { Component, ViewChild } from '@angular/core';
		import { Platform, Nav } from 'ionic-angular';
		import { StatusBar } from '@ionic-native/status-bar';
		import { SplashScreen } from '@ionic-native/splash-screen';
		
		import { InicioPage } from '../pages/inicio/inicio';
		
		«FOR ctrl: pages»
			import { «ctrl.toLowerCase.toFirstUpper»Page } from '../pages/«ctrl.toLowerCase.substring(0,ctrl.length-1)»/«ctrl.toLowerCase»';
		«ENDFOR»
		
		@Component({
		  templateUrl: 'app.html'
		})
		export class MyApp {
		  @ViewChild('NAV') nav: Nav;
		  public rootPage:any;
		  public pages:Array<{titulo:string,component:any,icon:string}>;
		
		  constructor(platform: Platform, statusBar: StatusBar, splashScreen: SplashScreen) {
		    this.rootPage=InicioPage;
		    this.pages=[
		      {titulo:'Inicio',         component:InicioPage        ,icon:'home'},
 			  «FOR itemMenu: elementsMenu»
 			  	«itemMenu.toString»
 			  «ENDFOR»
		    ];
		    platform.ready().then(() => {
		      // Okay, so the platform is ready and our plugins are available.
		      // Here you can do any higher level native things you might need.
		      statusBar.styleDefault();
		      splashScreen.hide(); 
		    });
		  }
		
		  goToPage(page){
		    this.nav.setRoot(page);
		  }
		
		}
	'''
	override preprocess(List<Controller> c) {
		for(ctr: c){
			for(Page p: getControlledPages(ctr)){
				if(p.hasBody){
					widgetTemplate(p.body)
				}
			}
		}
		
	}
	/**
	* Método para obtener las partes de cada componente de tipo block
	*/
	def  widgetTemplate(EList<ViewStatement> partBlock){
		if (partBlock != null){
			for (part : partBlock){
				if(part instanceof ViewInstance){
					if (part.type.typeSpecification.typeSpecificationString.equalsIgnoreCase("ExtendedMenu")){
						var c=part.parameters.get(0).containerController;
						pages.add(c.name);
						elementsMenu.add("{titulo:"+part.parameters.get(0).getValue+",component:"+c.name.toLowerCase.toFirstUpper+"Page,icon:"+part.parameters.get(1).getValue+"},");
					}
				}	
			}
		}
			
	}
	
	 
}