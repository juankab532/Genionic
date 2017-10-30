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
  selector: 'page-editarfacultadv',
  templateUrl: 'editarfacultadv.html',
})
export class EditarfacultadcPage {
	
	persistence:Persistence;
	editar:FacultadE;
	
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
				
		this.editar=this.navParams.get('editar');
	
	}
		  	
	//Metodos		  
	guardar(editar:FacultadE){
		this.persistence.save(editar).then((r)=>{return this.navCtrl.push(FacultadcPage, {});}).catch(error =>{alert(error)});
	}
	cancelar(){
		return this.navCtrl.push(FacultadcPage, {});
	}
	editarAsignatura(){
		return this.navCtrl.push(EditarfacultadcPage, {editar:this.editar});
	}
}
