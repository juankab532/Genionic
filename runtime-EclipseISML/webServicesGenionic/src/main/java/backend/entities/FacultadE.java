package backend.entities;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;


		

		
@XmlRootElement
@Entity
public  class FacultadE implements Serializable {
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
	 * The nombre for the FacultadE
	 */
	private String nombre;
	
	public FacultadE(){
	}
	
	public FacultadE(Long id,String nombre){
		setId(id);
		setNombre(nombre);
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
		if (!(obj instanceof FacultadE)) {
			return false;
		}
		final FacultadE other = (FacultadE) obj;
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
		return "backend.entities.FacultadE [ id=" + id + " ]";
	}
}
