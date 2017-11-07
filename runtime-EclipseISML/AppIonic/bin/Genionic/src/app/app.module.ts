import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { Camera } from '@ionic-native/camera';
import { HttpModule } from '@angular/http';
import { Persistence } from '../providers/persistence/persistence';
import { CameraService } from '../providers/camera-service/camera-service'; 

import { MyApp } from './app.component';
import { InicioPage } from '../pages/inicio/inicio';

import { AsignaturacPage } from '../pages/asignatura/asignaturac';
import { EditarasignaturacPage } from '../pages/editarasignatura/editarasignaturac';



@NgModule({ 
  declarations: [
    MyApp,
    InicioPage,
  		AsignaturacPage,
  		EditarasignaturacPage,
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
  		EditarasignaturacPage,
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    Persistence,
    CameraService,
    Camera
  ]
})
export class AppModule {}
