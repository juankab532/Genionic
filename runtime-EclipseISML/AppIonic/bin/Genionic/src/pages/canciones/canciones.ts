import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

import { DezeerServiceProvider } from "../../providers/dezeer-service/dezeer-service";

@IonicPage()
@Component({
  selector: 'page-canciones',
  templateUrl: 'canciones.html',
})
export class CancionesPage {
  public playlist:any;
  public canciones:any;
  constructor(public navCtrl: NavController, public navParams: NavParams,
  public ds:DezeerServiceProvider
  ) {
      this.playlist=this.navParams.get("playlist");
      this.canciones=[];
  }

  ionViewDidLoad() {
    this.ds.getPlaylistsSongs(this.playlist.id).subscribe(datos=>{
        this.canciones=datos.data;
    });
    console.log(this.canciones);
  }

}
