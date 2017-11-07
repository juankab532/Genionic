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

import { CrearfacultadcPage } from '../pages/crearfacultad/crearfacultadc';
import { EditarasignaturacPage } from '../pages/editarasignatura/editarasignaturac';
import { CrearasignaturacPage } from '../pages/crearasignatura/crearasignaturac';
import { CrearalumnocPage } from '../pages/crearalumno/crearalumnoc';
import { MapacPage } from '../pages/mapa/mapac';
import { EditaralumnocPage } from '../pages/editaralumno/editaralumnoc';
import { FacultadcPage } from '../pages/facultad/facultadc';
import { AsignaturacPage } from '../pages/asignatura/asignaturac';
import { AlumnocPage } from '../pages/alumno/alumnoc';
import { EditarfacultadcPage } from '../pages/editarfacultad/editarfacultadc';
import { InscripcioncPage } from '../pages/inscripcion/inscripcionc';



@NgModule({ 
  declarations: [
    MyApp,
    InicioPage,
  		CrearfacultadcPage,
  		EditarasignaturacPage,
  		CrearasignaturacPage,
  		CrearalumnocPage,
  		MapacPage,
  		EditaralumnocPage,
  		FacultadcPage,
  		AsignaturacPage,
  		AlumnocPage,
  		EditarfacultadcPage,
  		InscripcioncPage,
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
  		CrearfacultadcPage,
  		EditarasignaturacPage,
  		CrearasignaturacPage,
  		CrearalumnocPage,
  		MapacPage,
  		EditaralumnocPage,
  		FacultadcPage,
  		AsignaturacPage,
  		AlumnocPage,
  		EditarfacultadcPage,
  		InscripcioncPage,
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
