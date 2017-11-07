import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

/*
  Generated class for the PersistenceProvider provider.

  See https://angular.io/docs/ts/latest/guide/dependency-injection.html
  for more info on providers and Angular DI.
*/
@Injectable()
export class Persistence {
  header :any = { "headers": {"Content-Type": "application/json"} };
  constructor(public http: Http) {
    console.log('Hello PersistenceProvider Provider');
  }
  findAll(){   
    return new Promise((resolve, reject) => {
        var peticion:any=this.http.post('http://127.0.0.1/api.php',{"accion":'fillall','entity':''}).map( res => res.json());    
        peticion.subscribe(valor=>{resolve(valor);},err =>reject(err)); 
    });
  }
  remove(entidad:any){   
    return new Promise((resolve, reject) => {
      var peticion:any=this.http.post('http://127.0.0.1/api.php',{"accion":'remove','entity':'','datos':entidad}).map( res => res.json());    
      peticion.subscribe(valor=>{resolve(valor);},err =>reject(err)); 
    });
  }
  save(entidad:any){
    return new Promise((resolve, reject) => {
      var peticion:any=this.http.post('http://127.0.0.1/api.php',{"accion":'save','entity':'','datos':entidad},this.header).map( res => res.json());    
      peticion.subscribe(valor=>{resolve(valor);},err =>reject(err));  
    });
  }
}
