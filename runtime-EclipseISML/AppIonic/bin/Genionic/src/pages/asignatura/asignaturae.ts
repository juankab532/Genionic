export class AsignaturaE{
	id:number;
	codigo:string;
	nombre:string;
	descripcion:string;
	semestre:number;
	estado:string;
	facultad:number;
	getId(){
	  return this.id;
	}
	setId(valor){
	  this.id=valor;
	}
	getCodigo(){
	  return this.codigo;
	}
	setCodigo(valor){
	  this.codigo=valor;
	}
	getNombre(){
	  return this.nombre;
	}
	setNombre(valor){
	  this.nombre=valor;
	}
	getDescripcion(){
	  return this.descripcion;
	}
	setDescripcion(valor){
	  this.descripcion=valor;
	}
	getSemestre(){
	  return this.semestre;
	}
	setSemestre(valor){
	  this.semestre=valor;
	}
	getEstado(){
	  return this.estado;
	}
	setEstado(valor){
	  this.estado=valor;
	}
	getFacultad(){
	  return this.facultad;
	}
	setFacultad(valor){
	  this.facultad=valor;
	}
}

