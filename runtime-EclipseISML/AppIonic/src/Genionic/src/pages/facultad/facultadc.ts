import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Persistence } from "../../providers/persistence/persistence";
import { Http } from '@angular/http';
import { CameraService } from "../../providers/camera-service/camera-service";
import { MapService } from "../../providers/map-service/map-service";

import { FacultadE } from './facultade';
import { EditarfacultadcPage } from '../editarfacultad/editarfacultadc';
import { CrearfacultadcPage } from '../crearfacultad/crearfacultadc';

@IonicPage()
@Component({
  selector: 'page-facultadv',
  templateUrl: 'facultadv.html',
})
export class FacultadcPage {
	
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
		this.persistence.service='facultadc';
				
		this.lista=this.navParams.get('lista');
	
	}
		  	
	//Metodos		  
	ionViewDidLoad(){
		this.persistence.findAll().then((r)=>{this.lista=r; }).catch(error =>{alert(error)});
	}
	editar(editar:FacultadE){
		return this.navCtrl.push(EditarfacultadcPage, {editar:editar});
	}
	eliminar(eliminar:FacultadE){
		this.persistence.remove(eliminar).then((r)=>{return this.navCtrl.push(FacultadcPage, {lista:this.lista});}).catch(error =>{alert(error)});
	}
	crear(){
		var nuevaFacultad:FacultadE=new FacultadE
		return this.navCtrl.push(CrearfacultadcPage, {nuevaFacultad:nuevaFacultad});
	}
}
