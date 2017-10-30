import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { FacultadcPage } from './facultadc';

@NgModule({
  declarations: [
    FacultadcPage,
  ],
  imports: [
    IonicPageModule.forChild(FacultadcPage),
  ],
  exports: [
    FacultadcPage
  ]
})
export class FacultadcPageModule {}

