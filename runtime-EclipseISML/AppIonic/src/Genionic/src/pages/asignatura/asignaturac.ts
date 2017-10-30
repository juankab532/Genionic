import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Persistence } from "../../providers/persistence/persistence";
import { Http } from '@angular/http';
import { CameraService } from "../../providers/camera-service/camera-service";
import { MapService } from "../../providers/map-service/map-service";

import { AsignaturaE } from './asignaturae';
import { EditarasignaturacPage } from '../editarasignatura/editarasignaturac';
import { CrearasignaturacPage } from '../crearasignatura/crearasignaturac';

@IonicPage()
@Component({
  selector: 'page-asignaturav',
  templateUrl: 'asignaturav.html',
})
export class AsignaturacPage {
	
	persistence:Persistence;
	lista:any=[];
	
	constructor(public navCtrl		: NavController, 
				public navParams	: NavParams,
				public cam			: CameraService,
				public mapService   : MapService,
				public http			: Http
				) {
		/*Asigna la Persistencia*/
		this.persistence= new Persistence(http);
		/*Asigna la ruta del servicio a la persistencia*/
		this.persistence.service='asignaturac';
				
		this.lista=this.navParams.get('lista');
	
	}
		  	
	//Metodos		  
	ionViewDidLoad(){
		this.persistence.findAll().then((r)=>{this.lista=r; }).catch(error =>{alert(error)});
	}
	editar(editar:AsignaturaE){
		return this.navCtrl.push(EditarasignaturacPage, {editar:editar});
	}
	eliminar(eliminar:AsignaturaE){
		this.persistence.remove(eliminar).then((r)=>{return this.navCtrl.push(AsignaturacPage, {lista:this.lista});}).catch(error =>{alert(error)});
	}
	crear(){
		var nuevaAsignatura:AsignaturaE=new AsignaturaE
		return this.navCtrl.push(CrearasignaturacPage, {nuevaAsignatura:nuevaAsignatura});
	}
}
