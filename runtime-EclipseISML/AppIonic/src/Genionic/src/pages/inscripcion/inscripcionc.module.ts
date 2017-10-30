import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { InscripcioncPage } from './inscripcionc';

@NgModule({
  declarations: [
    InscripcioncPage,
  ],
  imports: [
    IonicPageModule.forChild(InscripcioncPage),
  ],
  exports: [
    InscripcioncPage
  ]
})
export class InscripcioncPageModule {}

