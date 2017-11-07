package backend.entities;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;


		

		
@XmlRootElement
@Entity
public  class AlumnoE implements Serializable {
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
	 * The documento for the AlumnoE
	 */
	private String documento;
		
	/**
	 * The nombres for the AlumnoE
	 */
	private String nombres;
		
	/**
	 * The apellidos for the AlumnoE
	 */
	private String apellidos;
		
	/**
	 * The direccion for the AlumnoE
	 */
	private String direccion;
		
	/**
	 * The telefono for the AlumnoE
	 */
	private String telefono;
		
	/**
	 * The foto for the AlumnoE
	 */
	@Column(columnDefinition = "TEXT")	
	private String foto;
	
	public AlumnoE(){
	}
	
	public AlumnoE(Long id,String documento,String nombres,String apellidos,String direccion,String telefono,String foto){
		setId(id);
		setDocumento(documento);
		setNombres(nombres);
		setApellidos(apellidos);
		setDireccion(direccion);
		setTelefono(telefono);
		setFoto(foto);
	}

	
	
	
	
	
	
	
	
	/**
	 * Returns the current value for the attibute documento
	 *
	 * @return current instance for documento attribute
	 */
	public String getDocumento(){
		return documento;
	}
	
	/**
	 * Sets the value for the attribute documento
	 * @param documento The value to set
	 */
	public void setDocumento(String documento){
		this.documento=documento;
	}
	
	
	
	
	/**
	 * Returns the current value for the attibute nombres
	 *
	 * @return current instance for nombres attribute
	 */
	public String getNombres(){
		return nombres;
	}
	
	/**
	 * Sets the value for the attribute nombres
	 * @param nombres The value to set
	 */
	public void setNombres(String nombres){
		this.nombres=nombres;
	}
	
	
	
	
	/**
	 * Returns the current value for the attibute apellidos
	 *
	 * @return current instance for apellidos attribute
	 */
	public String getApellidos(){
		return apellidos;
	}
	
	/**
	 * Sets the value for the attribute apellidos
	 * @param apellidos The value to set
	 */
	public void setApellidos(String apellidos){
		this.apellidos=apellidos;
	}
	
	
	
	
	/**
	 * Returns the current value for the attibute direccion
	 *
	 * @return current instance for direccion attribute
	 */
	public String getDireccion(){
		return direccion;
	}
	
	/**
	 * Sets the value for the attribute direccion
	 * @param direccion The value to set
	 */
	public void setDireccion(String direccion){
		this.direccion=direccion;
	}
	
	
	
	
	/**
	 * Returns the current value for the attibute telefono
	 *
	 * @return current instance for telefono attribute
	 */
	public String getTelefono(){
		return telefono;
	}
	
	/**
	 * Sets the value for the attribute telefono
	 * @param telefono The value to set
	 */
	public void setTelefono(String telefono){
		this.telefono=telefono;
	}
	
	
	
	
	/**
	 * Returns the current value for the attibute foto
	 *
	 * @return current instance for foto attribute
	 */
	public String getFoto(){
		return foto;
	}
	
	/**
	 * Sets the value for the attribute foto
	 * @param foto The value to set
	 */
	public void setFoto(String foto){
		this.foto=foto;
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
		if (!(obj instanceof AlumnoE)) {
			return false;
		}
		final AlumnoE other = (AlumnoE) obj;
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
		return "backend.entities.AlumnoE [ id=" + id + " ]";
	}
}
