import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { PlayListPage } from "../play-list/play-list";
import { DezeerServiceProvider } from "../../providers/dezeer-service/dezeer-service";

@IonicPage()
@Component({
  selector: 'page-perfiles',
  templateUrl: 'perfiles.html',
})
export class PerfilesPage {
  public users:any;
  constructor(
      public navCtrl: NavController, 
      public navParams: NavParams, 
      public ds:DezeerServiceProvider) {
      this.users=[];
  }

  ionViewDidLoad() {
    this.ds.getUsers().subscribe(usersIDs=>{
        usersIDs.map(userID=>{
            this.ds.getUserDetail(userID).subscribe(user=>{
                this.users.push(user);
            });
        });
    });
  }
  goToPlayList(user){
    //Lamar una vista y enviar parametro
    this.navCtrl.push(PlayListPage,{user:user});
  
  }
}
