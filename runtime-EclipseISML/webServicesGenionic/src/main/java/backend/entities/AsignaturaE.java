package backend.entities;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;


		

		
@XmlRootElement
@Entity
public  class AsignaturaE implements Serializable {
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
	
		
		
	/**
	 * The codigo for the AsignaturaE
	 */
	private String codigo;
		
	/**
	 * The nombre for the AsignaturaE
	 */
	private String nombre;
		
	/**
	 * The descripcion for the AsignaturaE
	 */
	private String descripcion;
		
	/**
	 * The semestre for the AsignaturaE
	 */
	private Long semestre;
		
	/**
	 * The estado for the AsignaturaE
	 */
	private String estado;
	@ManyToOne
		
	/**
	 * The facultad for the AsignaturaE
	 */
	private FacultadE facultad;
	
	public AsignaturaE(){
	}
	
	public AsignaturaE(Long id,String codigo,String nombre,String descripcion,Long semestre,String estado,FacultadE facultad){
		setId(id);
		setCodigo(codigo);
		setNombre(nombre);
		setDescripcion(descripcion);
		setSemestre(semestre);
		setEstado(estado);
		setFacultad(facultad);
	}

	
	
	
	
	
	
	
	
	/**
	 * Returns the current value for the attibute codigo
	 *
	 * @return current instance for codigo attribute
	 */
	public String getCodigo(){
		return codigo;
	}
	
	/**
	 * Sets the value for the attribute codigo
	 * @param codigo The value to set
	 */
	public void setCodigo(String codigo){
		this.codigo=codigo;
	}
	
	
	
	
	/**
	 * Returns the current value for the attibute nombre
	 *
	 * @return current instance for nombre attribute
	 */
	public String getNombre(){
		return nombre;
	}
	
	/**
	 * Sets the value for the attribute nombre
	 * @param nombre The value to set
	 */
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	
	
	
	/**
	 * Returns the current value for the attibute descripcion
	 *
	 * @return current instance for descripcion attribute
	 */
	public String getDescripcion(){
		return descripcion;
	}
	
	/**
	 * Sets the value for the attribute descripcion
	 * @param descripcion The value to set
	 */
	public void setDescripcion(String descripcion){
		this.descripcion=descripcion;
	}
	
	
	
	
	/**
	 * Returns the current value for the attibute semestre
	 *
	 * @return current instance for semestre attribute
	 */
	public Long getSemestre(){
		return semestre;
	}
	
	/**
	 * Sets the value for the attribute semestre
	 * @param semestre The value to set
	 */
	public void setSemestre(Long semestre){
		this.semestre=semestre;
	}
	
	
	
	
	/**
	 * Returns the current value for the attibute estado
	 *
	 * @return current instance for estado attribute
	 */
	public String getEstado(){
		return estado;
	}
	
	/**
	 * Sets the value for the attribute estado
	 * @param estado The value to set
	 */
	public void setEstado(String estado){
		this.estado=estado;
	}
	
	
	
	
	/**
	 * Returns the current value for the attibute facultad
	 *
	 * @return current instance for facultad attribute
	 */
	public FacultadE getFacultad(){
		return facultad;
	}
	
	/**
	 * Sets the value for the attribute facultad
	 * @param facultad The value to set
	 */
	public void setFacultad(FacultadE facultad){
		this.facultad=facultad;
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
		if (!(obj instanceof AsignaturaE)) {
			return false;
		}
		final AsignaturaE other = (AsignaturaE) obj;
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
		return "backend.entities.AsignaturaE [ id=" + id + " ]";
	}
}
