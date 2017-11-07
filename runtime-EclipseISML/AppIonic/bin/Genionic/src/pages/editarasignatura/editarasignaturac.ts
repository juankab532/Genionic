import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Persistence } from "../../providers/persistence/persistence";
import { CameraService } from "../../providers/camera-service/camera-service";

import { AsignaturaE } from '../asignatura/asignaturae';
import { AsignaturacPage } from '../asignatura/asignaturac';

@IonicPage()
@Component({
  selector: 'page-editarasignaturav',
  templateUrl: 'editarasignaturav.html',
})
export class EditarasignaturacPage {
	
	editar:AsignaturaE;
	
	constructor(public navCtrl		: NavController, 
				public navParams	: NavParams,
				public cam			: CameraService,
				public persistence	: Persistence) {
					
		this.editar=this.navParams.get('editar');
	
	}
		  	
	//Metodos		  
	guardar(asignatura:AsignaturaE){
		this.editar=asignatura
		this.persistence.save(asignatura).then((r)=>{return this.navCtrl.push(AsignaturacPage, {});}).catch(error =>{alert(error)});
		return this.navCtrl.push(AsignaturacPage, {});
	}
	cancelar(){
		return this.navCtrl.push(AsignaturacPage, {});
	}
	editarAsignatura(){
		return this.navCtrl.push(EditarasignaturacPage, {editar:this.editar});
	}
}
