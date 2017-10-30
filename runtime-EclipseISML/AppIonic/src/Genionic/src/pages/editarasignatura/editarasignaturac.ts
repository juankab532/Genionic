import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Persistence } from "../../providers/persistence/persistence";
import { Http } from '@angular/http';
import { CameraService } from "../../providers/camera-service/camera-service";
import { MapService } from "../../providers/map-service/map-service";

import { AsignaturaE } from '../asignatura/asignaturae';
import { AsignaturacPage } from '../asignatura/asignaturac';

@IonicPage()
@Component({
  selector: 'page-editarasignaturav',
  templateUrl: 'editarasignaturav.html',
})
export class EditarasignaturacPage {
	
	persistence:Persistence;
	persistenceF:Persistence;
	lista:any=[];
	editar:AsignaturaE;
	
	constructor(public navCtrl		: NavController, 
				public navParams	: NavParams,
				public cam			: CameraService,
				public mapService   : MapService,
				public http			: Http
				) {
		/*Asigna la Persistencia*/
		this.persistence= new Persistence(http);
		this.persistenceF= new Persistence(http);
		/*Asigna la ruta del servicio a la persistencia*/
		this.persistence.service='asignaturac';
		this.persistenceF.service='facultadc';
				
		this.editar=this.navParams.get('editar');
	
	}
		  	
	//Metodos		  
	ionViewDidLoad(){
		this.persistenceF.findAll().then((r)=>{this.lista=r; }).catch(error =>{alert(error)});
	}
	guardar(asignatura:AsignaturaE){
		this.editar = asignatura
		this.persistence.save(asignatura).then((r)=>{return this.navCtrl.push(AsignaturacPage, {});}).catch(error =>{alert(error)});
	}
	cancelar(){
		return this.navCtrl.push(AsignaturacPage, {});
	}
	editarAsignatura(){
		return this.navCtrl.push(EditarasignaturacPage, {editar:this.editar});
	}
}
