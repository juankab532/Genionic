import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Persistence } from "../../providers/persistence/persistence";
import { Http } from '@angular/http';
import { CameraService } from "../../providers/camera-service/camera-service";
import { MapService } from "../../providers/map-service/map-service";

import { AsignaturaE } from '../asignatura/asignaturae';
import { AlumnoE } from '../alumno/alumnoe';
import { InscripcionE } from './inscripcione';

@IonicPage()
@Component({
  selector: 'page-inscripcionv',
  templateUrl: 'inscripcionv.html',
})
export class InscripcioncPage {
	
	persistence:Persistence;
	persistenceA:Persistence;
	lista:any;
	asignaturas:any=[];
	seleccionada:AsignaturaE;
	cargar:AlumnoE;
	
	constructor(public navCtrl		: NavController, 
				public navParams	: NavParams,
				public cam			: CameraService,
				public mapService   : MapService,
				public http			: Http
				) {
		/*Asigna la Persistencia*/
		this.persistence= new Persistence(http);
		this.persistenceA= new Persistence(http);
		/*Asigna la ruta del servicio a la persistencia*/
		this.persistence.service='inscripcionc';
		this.persistenceA.service='asignaturac';
				
		this.cargar=this.navParams.get('cargar');
	
	}
		  	
	//Metodos		  
	ionViewDidLoad(){
		var query:string="select c from InscripcionE c where alumno_id=" + this.cargar.id + ""
		this.persistence.execute(query).then((r)=>{this.lista=r; }).catch(error =>{alert(error)});
		this.persistenceA.findAll().then((r)=>{this.asignaturas=r; }).catch(error =>{alert(error)});
	}
	ionViewWillLoad(){
		this.seleccionada = new AsignaturaE
	}
	retirar(eliminar:InscripcionE){
		this.persistence.remove(eliminar).then((r)=>{return this.navCtrl.push(InscripcioncPage, {cargar:this.cargar});}).catch(error =>{alert(error)});
	}
	inscribir(asignaturaG:AsignaturaE){
		var inscripcionS:InscripcionE=new InscripcionE
		inscripcionS.alumno = this.cargar
		inscripcionS.asignatura = asignaturaG
		this.persistence.create(inscripcionS).then((r)=>{return this.navCtrl.push(InscripcioncPage, {cargar:this.cargar});}).catch(error =>{alert(error)});
	}
}
