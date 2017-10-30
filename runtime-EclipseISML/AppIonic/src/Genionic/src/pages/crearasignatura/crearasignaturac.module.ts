import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { CrearasignaturacPage } from './crearasignaturac';

@NgModule({
  declarations: [
    CrearasignaturacPage,
  ],
  imports: [
    IonicPageModule.forChild(CrearasignaturacPage),
  ],
  exports: [
    CrearasignaturacPage
  ]
})
export class CrearasignaturacPageModule {}

