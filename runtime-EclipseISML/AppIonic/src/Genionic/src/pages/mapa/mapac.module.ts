import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { MapacPage } from './mapac';

@NgModule({
  declarations: [
    MapacPage,
  ],
  imports: [
    IonicPageModule.forChild(MapacPage),
  ],
  exports: [
    MapacPage
  ]
})
export class MapacPageModule {}

