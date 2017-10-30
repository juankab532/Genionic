export class AlumnoE{
	id:number;
	documento:string;
	nombres:string;
	apellidos:string;
	direccion:string;
	telefono:string;
	foto:string;
	getId(){
	  return this.id;
	}
	setId(valor){
	  this.id=valor;
	}
	getDocumento(){
	  return this.documento;
	}
	setDocumento(valor){
	  this.documento=valor;
	}
	getNombres(){
	  return this.nombres;
	}
	setNombres(valor){
	  this.nombres=valor;
	}
	getApellidos(){
	  return this.apellidos;
	}
	setApellidos(valor){
	  this.apellidos=valor;
	}
	getDireccion(){
	  return this.direccion;
	}
	setDireccion(valor){
	  this.direccion=valor;
	}
	getTelefono(){
	  return this.telefono;
	}
	setTelefono(valor){
	  this.telefono=valor;
	}
	getFoto(){
	  return this.foto;
	}
	setFoto(valor){
	  this.foto=valor;
	}
}

