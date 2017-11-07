import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

import {CancionesPage} from "../canciones/canciones";
import { DezeerServiceProvider } from "../../providers/dezeer-service/dezeer-service";

@IonicPage()
@Component({
  selector: 'page-play-list',
  templateUrl: 'play-list.html',
})
export class PlayListPage {
  user:any;
  public playlists:any;
  constructor(public navCtrl: NavController, public navParams: NavParams, 
      public ds:DezeerServiceProvider) {
      this.user=this.navParams.get("user");
      this.playlists=[];
  }

  ionViewDidLoad() {
    
    this.ds.getUserPlaylists(this.user.id).subscribe(datos=>{
        this.playlists=datos.data;
    });
  }
  goToCanciones(playlist){
      this.navCtrl.push(CancionesPage,{playlist:playlist});
  }

}
