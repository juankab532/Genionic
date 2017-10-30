import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Persistence } from "../../providers/persistence/persistence";
import { Http } from '@angular/http';
import { CameraService } from "../../providers/camera-service/camera-service";
import { MapService } from "../../providers/map-service/map-service";


@IonicPage()
@Component({
  selector: 'page-mapav',
  templateUrl: 'mapav.html',
})
export class MapacPage {
	
	
	constructor(public navCtrl		: NavController, 
				public navParams	: NavParams,
				public cam			: CameraService,
				public mapService   : MapService,
				public http			: Http
				) {
		/*Asigna la Persistencia*/
		/*Asigna la ruta del servicio a la persistencia*/
				
	
	}
		  	
	//Metodos		  
	ionViewDidLoad(){
		this.mapService.getMap("map",15)
	}
}
