package backend.entities;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;


		

		
@XmlRootElement
@Entity
public  class InscripcionE implements Serializable {
	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The unique id for the entity
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id = null;
	
		
	@ManyToOne
		
	/**
	 * The alumno for the InscripcionE
	 */
	private AlumnoE alumno;
	@ManyToOne
		
	/**
	 * The asignatura for the InscripcionE
	 */
	private AsignaturaE asignatura;
	
	public InscripcionE(){
	}
	
	public InscripcionE(Long id,AlumnoE alumno,AsignaturaE asignatura){
		setId(id);
		setAlumno(alumno);
		setAsignatura(asignatura);
	}

	
	
	
	
	
	
	
	
	/**
	 * Returns the current value for the attibute alumno
	 *
	 * @return current instance for alumno attribute
	 */
	public AlumnoE getAlumno(){
		return alumno;
	}
	
	/**
	 * Sets the value for the attribute alumno
	 * @param alumno The value to set
	 */
	public void setAlumno(AlumnoE alumno){
		this.alumno=alumno;
	}
	
	
	
	
	/**
	 * Returns the current value for the attibute asignatura
	 *
	 * @return current instance for asignatura attribute
	 */
	public AsignaturaE getAsignatura(){
		return asignatura;
	}
	
	/**
	 * Sets the value for the attribute asignatura
	 * @param asignatura The value to set
	 */
	public void setAsignatura(AsignaturaE asignatura){
		this.asignatura=asignatura;
	}
	

	public Long getId() {
		return id;
	}
	
	/**
	 * Sets the value for the unique id
	 * @param id The value to set
	 */
	public void setId(final Long id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof InscripcionE)) {
			return false;
		}
		final InscripcionE other = (InscripcionE) obj;
		if (id == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!id.equals(other.getId())) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}	
	
	@Override
	public String toString() {
		return "backend.entities.InscripcionE [ id=" + id + " ]";
	}
}
