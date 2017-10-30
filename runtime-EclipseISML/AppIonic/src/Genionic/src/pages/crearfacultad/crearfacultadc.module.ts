import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { CrearfacultadcPage } from './crearfacultadc';

@NgModule({
  declarations: [
    CrearfacultadcPage,
  ],
  imports: [
    IonicPageModule.forChild(CrearfacultadcPage),
  ],
  exports: [
    CrearfacultadcPage
  ]
})
export class CrearfacultadcPageModule {}

