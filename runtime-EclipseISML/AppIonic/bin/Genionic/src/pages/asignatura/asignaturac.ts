import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Persistence } from "../../providers/persistence/persistence";
import { CameraService } from "../../providers/camera-service/camera-service";

import { AsignaturaE } from './asignaturae';
import { EditarasignaturacPage } from '../editarasignatura/editarasignaturac';

@IonicPage()
@Component({
  selector: 'page-asignaturav',
  templateUrl: 'asignaturav.html',
})
export class AsignaturacPage {
	
	lista:any=[];
	imagen:any;
	
	constructor(public navCtrl		: NavController, 
				public navParams	: NavParams,
				public cam			: CameraService,
				public persistence	: Persistence) {
					
		this.lista=this.navParams.get('lista');this.imagen=this.navParams.get('imagen');
	
	}
		  	
	//Metodos		  
	ionViewDidLoad(){
		this.persistence.findAll()
		.then((r)=>{this.lista=r}).catch(error =>{alert(error)});
	}
	getPicture(){
		this.cam.takePicture()
		.then((r)=>{this.imagen=r;return this.navCtrl.push(AsignaturacPage, {lista:this.lista, imagen:this.imagen});}).catch(error =>{alert(error);});
		return this.navCtrl.push(AsignaturacPage, {lista:this.lista, imagen:this.imagen});
	}
	editar(editar:AsignaturaE){
		return this.navCtrl.push(EditarasignaturacPage, {editar:editar});
	}
	eliminar(eliminar:AsignaturaE){
		this.persistence.remove(eliminar).then((r)=>{return this.navCtrl.push(AsignaturacPage, {lista:this.lista, imagen:this.imagen});}).catch(error =>{alert(error)});
		return this.navCtrl.push(AsignaturacPage, {lista:this.lista, imagen:this.imagen});
	}
}
