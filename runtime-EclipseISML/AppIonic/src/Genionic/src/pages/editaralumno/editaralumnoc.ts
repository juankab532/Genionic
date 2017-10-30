import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Persistence } from "../../providers/persistence/persistence";
import { Http } from '@angular/http';
import { CameraService } from "../../providers/camera-service/camera-service";
import { MapService } from "../../providers/map-service/map-service";

import { AlumnoE } from '../alumno/alumnoe';
import { AlumnocPage } from '../alumno/alumnoc';

@IonicPage()
@Component({
  selector: 'page-editaralumnov',
  templateUrl: 'editaralumnov.html',
})
export class EditaralumnocPage {
	
	persistence:Persistence;
	editar:AlumnoE;
	
	constructor(public navCtrl		: NavController, 
				public navParams	: NavParams,
				public cam			: CameraService,
				public mapService   : MapService,
				public http			: Http
				) {
		/*Asigna la Persistencia*/
		this.persistence= new Persistence(http);
		/*Asigna la ruta del servicio a la persistencia*/
		this.persistence.service='alumnoc';
				
		this.editar=this.navParams.get('editar');
	
	}
		  	
	//Metodos		  
	guardar(editar:AlumnoE){
		this.persistence.save(editar).then((r)=>{return this.navCtrl.push(AlumnocPage, {});}).catch(error =>{alert(error)});
	}
	cancelar(){
		return this.navCtrl.push(AlumnocPage, {});
	}
	editarAsignatura(){
		return this.navCtrl.push(EditaralumnocPage, {editar:this.editar});
	}
}
