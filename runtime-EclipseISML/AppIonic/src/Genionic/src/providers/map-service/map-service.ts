import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Geolocation } from '@ionic-native/geolocation';
import 'rxjs/add/operator/map';

/*
  Generated class for the MapService provider.

  See https://angular.io/docs/ts/latest/guide/dependency-injection.html
  for more info on providers and Angular DI.
*/
@Injectable()
export class MapService {
  map:any;
  constructor(public http: Http,public geolocation:Geolocation) {
    console.log('Hello MapService Provider');
  }


  getMap(mapElement,zoom){
    mapElement=document.getElementById(mapElement);


    this.geolocation.getCurrentPosition().then((resp) => {

        var latLng= new google.maps.LatLng(resp.coords.latitude,resp.coords.longitude);
    
        let mapOptions={
          center:latLng,
          zoom:zoom,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        this.map= new google.maps.Map(mapElement,mapOptions);
        
        //Creación del Market
        let marker = new google.maps.Marker({
          icon: 'http://maps.google.com/mapfiles/ms/icons/green-dot.png',
          position: latLng,
          map: this.map,
          draggable: true
        });
        
        //Listener del Market
        marker.addListener('dragend', function(e) {
          //Mensaje del market
          var infowindow = new google.maps.InfoWindow({content: 'Latitud:'+e.latLng.lat()+' Longitud:'+e.latLng.lng()});
          infowindow.open(this.map, marker);
        });
 
    }).catch((error) => {
      console.log(error);
      alert(error);
    });
  }

}
