import { Component, ViewChild } from '@angular/core';
import { Platform, Nav } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

import { InicioPage } from '../pages/inicio/inicio';

import { MapacPage } from '../pages/mapa/mapac';
import { FacultadcPage } from '../pages/facultad/facultadc';
import { AsignaturacPage } from '../pages/asignatura/asignaturac';
import { AlumnocPage } from '../pages/alumno/alumnoc';

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
 			  {titulo:"Mapa",component:MapacPage,icon:"map"},
 			  {titulo:"Gestionar Facultad",component:FacultadcPage,icon:"albums"},
 			  {titulo:"Gestionar Asignatura",component:AsignaturacPage,icon:"book"},
 			  {titulo:"Gestionar Alumno",component:AlumnocPage,icon:"person"},
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
