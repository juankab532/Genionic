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
  selector: 'page-crearalumnov',
  templateUrl: 'crearalumnov.html',
})
export class CrearalumnocPage {
	
	persistence:Persistence;
	nuevoAlumno:AlumnoE;
	imagen:any;
	
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
				
		this.nuevoAlumno=this.navParams.get('nuevoAlumno');
	
	}
		  	
	//Metodos		  
	guardar(alumno:AlumnoE){
		this.persistence.create(alumno).then((r)=>{return this.navCtrl.push(AlumnocPage, {});}).catch(error =>{alert(error)});
	}
	cancelar(){
		return this.navCtrl.push(AlumnocPage, {});
	}
	crear(){
		return this.navCtrl.push(CrearalumnocPage, {nuevoAlumno:this.nuevoAlumno});
	}
	getPicture(){
		this.cam.takePicture().then((r)=>{this.nuevoAlumno.foto=r+'';}).catch(error =>{alert(error);});
	}
}
