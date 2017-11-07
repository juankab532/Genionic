import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';


@Injectable()
export class DezeerServiceProvider {
  public deezerAPI:String;
  constructor(public http: Http) {
    this.deezerAPI="/deezerAPI"; //Pruebas en el pc 
    //this.deezerAPI="http://api.deezer.com"; //En el movil
    console.log('Hello DezeerServiceProvider Provider');
  }

  getUsers(){  
    return this.http.get('https://api.myjson.com/bins/mcjrb')
    .map( res => res.json()); //retorna el observable
    /*.subscribe(usuarios=>{
        usuarios.map(userID=>{
            this.getUserDetail(userID);
        });
    });*/
  }

  getUserDetail(userID){
    return this.http.get(this.deezerAPI+'/user/'+userID)
    .map( res => res.json());
    /*.subscribe(data=>{
        console.log(data);
    });*/
  }
  getUserPlaylists(userID){
    return this.http.get(this.deezerAPI+'/user/'+userID+'/playlists')
    .map( res => res.json());
  }

  getPlaylistsSongs(playlist){
    return this.http.get(this.deezerAPI+'/playlist/'+playlist+'/tracks')
    .map( res => res.json());
  }

}
