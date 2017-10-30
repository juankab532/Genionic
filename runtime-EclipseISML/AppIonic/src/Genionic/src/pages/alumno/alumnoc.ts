import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Persistence } from "../../providers/persistence/persistence";
import { Http } from '@angular/http';
import { CameraService } from "../../providers/camera-service/camera-service";
import { MapService } from "../../providers/map-service/map-service";

import { AlumnoE } from './alumnoe';
import { EditaralumnocPage } from '../editaralumno/editaralumnoc';
import { CrearalumnocPage } from '../crearalumno/crearalumnoc';
import { InscripcioncPage } from '../inscripcion/inscripcionc';

@IonicPage()
@Component({
  selector: 'page-alumnov',
  templateUrl: 'alumnov.html',
})
export class AlumnocPage {
	
	persistence:Persistence;
	lista:any=[];
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
				
		this.lista=this.navParams.get('lista');
	
	}
		  	
	//Metodos		  
	ionViewDidLoad(){
		this.persistence.findAll().then((r)=>{this.lista=r; }).catch(error =>{alert(error)});
	}
	editar(editar:AlumnoE){
		return this.navCtrl.push(EditaralumnocPage, {editar:editar});
	}
	eliminar(eliminar:AlumnoE){
		this.persistence.remove(eliminar).then((r)=>{return this.navCtrl.push(AlumnocPage, {lista:this.lista});}).catch(error =>{alert(error)});
	}
	crear(){
		var nuevoAlumno:AlumnoE=new AlumnoE
		return this.navCtrl.push(CrearalumnocPage, {nuevoAlumno:nuevoAlumno});
	}
	asignaturas(cargar:AlumnoE){
		return this.navCtrl.push(InscripcioncPage, {cargar:cargar});
	}
}
