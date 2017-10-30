import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { EditarasignaturacPage } from './editarasignaturac';

@NgModule({
  declarations: [
    EditarasignaturacPage,
  ],
  imports: [
    IonicPageModule.forChild(EditarasignaturacPage),
  ],
  exports: [
    EditarasignaturacPage
  ]
})
export class EditarasignaturacPageModule {}

