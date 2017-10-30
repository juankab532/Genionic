import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Persistence } from "../../providers/persistence/persistence";
import { Http } from '@angular/http';
import { CameraService } from "../../providers/camera-service/camera-service";
import { MapService } from "../../providers/map-service/map-service";

import { FacultadE } from '../facultad/facultade';
import { FacultadcPage } from '../facultad/facultadc';

@IonicPage()
@Component({
  selector: 'page-crearfacultadv',
  templateUrl: 'crearfacultadv.html',
})
export class CrearfacultadcPage {
	
	persistence:Persistence;
	nuevaFacultad:FacultadE;
	
	constructor(public navCtrl		: NavController, 
				public navParams	: NavParams,
				public cam			: CameraService,
				public mapService   : MapService,
				public http			: Http
				) {
		/*Asigna la Persistencia*/
		this.persistence= new Persistence(http);
		/*Asigna la ruta del servicio a la persistencia*/
		this.persistence.service='facultadc';
				
		this.nuevaFacultad=this.navParams.get('nuevaFacultad');
	
	}
		  	
	//Metodos		  
	guardar(facultad:FacultadE){
		this.persistence.create(facultad).then((r)=>{return this.navCtrl.push(FacultadcPage, {});}).catch(error =>{alert(error)});
	}
	cancelar(){
		return this.navCtrl.push(FacultadcPage, {});
	}
	crear(){
		return this.navCtrl.push(CrearfacultadcPage, {nuevaFacultad:this.nuevaFacultad});
	}
}
