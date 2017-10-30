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
  public service:String;
  constructor(public http: Http) {
    console.log('Hello PersistenceProvider Provider');
  }
  setService(s:String){
    this.service=s;
  }
  findAll(){   
    return new Promise((resolve, reject) => {
        var peticion:any=this.http.get('http://localhost:8080/backend/'+this.service+'/findAll').map( res => res.json());    
        peticion.subscribe(valor=>{resolve(valor);},err =>reject(err)); 
    });
  }
  remove(entidad:any){   
    return new Promise((resolve, reject) => {
      var peticion:any=this.http.post('http://localhost:8080/backend/'+this.service+'/remove',entidad,this.header).map( res => res.json());    
      peticion.subscribe(valor=>{resolve(valor);},err =>reject(err)); 
    });
  }
  save(entidad:any){
    return new Promise((resolve, reject) => {
      var peticion:any=this.http.post('http://localhost:8080/backend/'+this.service+'/save',entidad,this.header).map( res => res.json());    
      peticion.subscribe(valor=>{resolve(valor);},err =>reject(err));  
    });
  }
  create(entidad:any){
    return new Promise((resolve, reject) => {
      var peticion:any=this.http.post('http://localhost:8080/backend/'+this.service+'/create',entidad,this.header).map( res => res.json());    
      peticion.subscribe(valor=>{resolve(valor);},err =>reject(err));  
    });
  }

  execute(expresion:String){
    return new Promise((resolve, reject) => {
      var peticion:any=this.http.get('http://localhost:8080/backend/'+this.service+'/execute/'+expresion,this.header).map( res => res.json());    
      peticion.subscribe(valor=>{resolve(valor);},err =>reject(err));  
    });
  }
}
