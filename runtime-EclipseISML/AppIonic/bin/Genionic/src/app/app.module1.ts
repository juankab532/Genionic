import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { Camera } from '@ionic-native/camera';
import { HttpModule } from '@angular/http';
import { GoogleMaps} from '@ionic-native/google-maps';
import { Geolocation } from '@ionic-native/geolocation'; 

import { MyApp } from './app.component';
import { DezeerServiceProvider } from '../providers/dezeer-service/dezeer-service';
import { InicioPage } from '../pages/inicio/inicio';

import { AsignaturacPage } from '../pages/asignatura/asignaturac';



@NgModule({ 
  declarations: [
    MyApp,
    InicioPage,
  		AsignaturacPage,
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
  		AsignaturacPage,
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    DezeerServiceProvider,
    Camera,
    GoogleMaps, 
    Geolocation
  ]
})
export class AppModule {}
