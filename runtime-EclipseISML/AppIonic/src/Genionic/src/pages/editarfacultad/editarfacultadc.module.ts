import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { EditarfacultadcPage } from './editarfacultadc';

@NgModule({
  declarations: [
    EditarfacultadcPage,
  ],
  imports: [
    IonicPageModule.forChild(EditarfacultadcPage),
  ],
  exports: [
    EditarfacultadcPage
  ]
})
export class EditarfacultadcPageModule {}

