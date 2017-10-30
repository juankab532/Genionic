import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { CrearalumnocPage } from './crearalumnoc';

@NgModule({
  declarations: [
    CrearalumnocPage,
  ],
  imports: [
    IonicPageModule.forChild(CrearalumnocPage),
  ],
  exports: [
    CrearalumnocPage
  ]
})
export class CrearalumnocPageModule {}

