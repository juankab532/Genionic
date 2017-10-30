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
  selector: 'page-crearasignaturav',
  templateUrl: 'crearasignaturav.html',
})
export class CrearasignaturacPage {
	
	persistence:Persistence;
	persistenceF:Persistence;
	nuevaAsignatura:AsignaturaE;
	lista:any=[];
	estado:any=[];
	
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
				
		this.nuevaAsignatura=this.navParams.get('nuevaAsignatura');
	
	}
		  	
	//Metodos		  
	ionViewDidLoad(){
		this.persistenceF.findAll().then((r)=>{this.lista=r; }).catch(error =>{alert(error)});
	}
	guardar(asignatura:AsignaturaE){
		this.persistence.create(asignatura).then((r)=>{return this.navCtrl.push(AsignaturacPage, {});}).catch(error =>{alert(error)});
	}
	cancelar(){
		return this.navCtrl.push(AsignaturacPage, {});
	}
	crear(){
		return this.navCtrl.push(CrearasignaturacPage, {nuevaAsignatura:this.nuevaAsignatura});
	}
}
