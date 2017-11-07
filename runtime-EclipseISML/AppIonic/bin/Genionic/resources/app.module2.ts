import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { Camera } from '@ionic-native/camera';
import { HttpModule } from '@angular/http';

import { MyApp } from './app.component';
import { DezeerServiceProvider } from '../providers/dezeer-service/dezeer-service';
import { InicioPage } from '../pages/inicio/inicio';
import { PerfilesPage } from '../pages/perfiles/perfiles';
import { ContactoPage } from '../pages/contacto/contacto';
import { AcercaPage } from '../pages/acerca/acerca';
import { PlayListPage } from '../pages/play-list/play-list';
import { CancionesPage } from '../pages/canciones/canciones';
import { MapaPage } from '../pages/mapa/mapa';
import { CameraPage } from '../pages/camera/camera';
import { PruebaPage } from '../pages/prueba/prueba';
import { AsignaturacPage } from '../pages/asignatura/asignaturac';



@NgModule({ 
  declarations: [
    MyApp,
    InicioPage,
    PerfilesPage,
    ContactoPage,
    AcercaPage,
    PlayListPage,
    CancionesPage,
    MapaPage,
    CameraPage,
    PruebaPage,
    AsignaturacPage
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
    PerfilesPage,
    ContactoPage,
    AcercaPage,
    PlayListPage,
    CancionesPage,
    MapaPage,
    CameraPage,
    PruebaPage,
    AsignaturacPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    DezeerServiceProvider,
    Camera
  ]
})
export class AppModule {}
