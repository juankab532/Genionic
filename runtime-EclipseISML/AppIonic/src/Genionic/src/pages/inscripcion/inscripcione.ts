import { AlumnoE } from '../alumno/alumnoe';
import { AsignaturaE } from '../asignatura/asignaturae';
export class InscripcionE{
	id:number;
	alumno:AlumnoE= new AlumnoE;
	asignatura:AsignaturaE= new AsignaturaE;
	getId(){
	  return this.id;
	}
	setId(valor){
	  this.id=valor;
	}
	getAlumno(){
	  return this.alumno;
	}
	setAlumno(valor){
	  this.alumno=valor;
	}
	getAsignatura(){
	  return this.asignatura;
	}
	setAsignatura(valor){
	  this.asignatura=valor;
	}
}

