import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { AlumnocPage } from './alumnoc';

@NgModule({
  declarations: [
    AlumnocPage,
  ],
  imports: [
    IonicPageModule.forChild(AlumnocPage),
  ],
  exports: [
    AlumnocPage
  ]
})
export class AlumnocPageModule {}

