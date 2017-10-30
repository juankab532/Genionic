package co.edu.javeriana.generator.genionic.templates

import co.edu.javeriana.isml.generator.common.SimpleTemplate

import java.util.List
import co.edu.javeriana.isml.isml.Controller
import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider

class Conf1Template extends SimpleTemplate<List<Controller>>  { 
	@Inject extension IQualifiedNameProvider
	override protected template(List<Controller> e) '''
		import { BrowserModule } from '@angular/platform-browser';
		import { ErrorHandler, NgModule } from '@angular/core';
		import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
		import { SplashScreen } from '@ionic-native/splash-screen';
		import { StatusBar } from '@ionic-native/status-bar';
		import { Camera } from '@ionic-native/camera';
		import { Geolocation } from '@ionic-native/geolocation';
		import { HttpModule } from '@angular/http';
		import { Persistence } from '../providers/persistence/persistence';
		import { CameraService } from '../providers/camera-service/camera-service'; 
		import { MapService } from "../providers/map-service/map-service";
		
		import { MyApp } from './app.component';
		import { InicioPage } from '../pages/inicio/inicio';

		«FOR ctrl: e»
		«IF !ctrl.name.equals("DefaultPageDispatcher") && ctrl.eContainer?.fullyQualifiedName.toString.endsWith("controllers")»
		import { «ctrl.name.toLowerCase.toFirstUpper»Page } from '../pages/«ctrl.name.toLowerCase.substring(0,ctrl.name.length-1)»/«ctrl.name.toLowerCase»';
		«ENDIF»
		«ENDFOR»
		
		
		
		@NgModule({ 
		  declarations: [
		    MyApp,
		    InicioPage,
  		«FOR ctrl: e»
  		«IF !ctrl.name.equals("DefaultPageDispatcher") && ctrl.eContainer?.fullyQualifiedName.toString.endsWith("controllers")»
  		    «ctrl.name.toLowerCase.toFirstUpper»Page,
  		«ENDIF»
  		«ENDFOR»
		  ],
		  imports: [
		    BrowserModule,
		    HttpModule,
		    IonicModule.forRoot(MyApp)
		  ],
		  bootstrap: [IonicApp],
		  entryComponents: [
		    MyApp,
		    InicioPage,
  		«FOR ctrl: e»
  		«IF !ctrl.name.equals("DefaultPageDispatcher") && ctrl.eContainer?.fullyQualifiedName.toString.endsWith("controllers")»
  		    «ctrl.name.toLowerCase.toFirstUpper»Page,
  		«ENDIF»
  		«ENDFOR»
		  ],
		  providers: [
		    StatusBar,
		    SplashScreen,
		    {provide: ErrorHandler, useClass: IonicErrorHandler},
		    Persistence,
		    CameraService,
		    MapService,
		    Camera,
		    Geolocation
		  ]
		})
		export class AppModule {}
	'''
	override preprocess(List<Controller> e) {
		
	} 
	 
}