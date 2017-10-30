import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { EditaralumnocPage } from './editaralumnoc';

@NgModule({
  declarations: [
    EditaralumnocPage,
  ],
  imports: [
    IonicPageModule.forChild(EditaralumnocPage),
  ],
  exports: [
    EditaralumnocPage
  ]
})
export class EditaralumnocPageModule {}

