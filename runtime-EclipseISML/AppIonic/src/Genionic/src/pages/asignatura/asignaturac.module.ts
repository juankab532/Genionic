import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { AsignaturacPage } from './asignaturac';

@NgModule({
  declarations: [
    AsignaturacPage,
  ],
  imports: [
    IonicPageModule.forChild(AsignaturacPage),
  ],
  exports: [
    AsignaturacPage
  ]
})
export class AsignaturacPageModule {}

