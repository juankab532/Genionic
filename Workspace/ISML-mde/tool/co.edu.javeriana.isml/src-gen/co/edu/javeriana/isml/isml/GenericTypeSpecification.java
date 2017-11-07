/**
 */
package co.edu.javeriana.isml.isml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generic Type Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link co.edu.javeriana.isml.isml.GenericTypeSpecification#getSuperType <em>Super Type</em>}</li>
 * </ul>
 *
 * @see co.edu.javeriana.isml.isml.IsmlPackage#getGenericTypeSpecification()
 * @model
 * @generated
 */
public interface GenericTypeSpecification extends TypeSpecification
{
	/**
	 * Returns the value of the '<em><b>Super Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Type</em>' containment reference.
	 * @see #setSuperType(Type)
	 * @see co.edu.javeriana.isml.isml.IsmlPackage#getGenericTypeSpecification_SuperType()
	 * @model containment="true"
	 * @generated
	 */
	Type getSuperType();

	/**
	 * Sets the value of the '{@link co.edu.javeriana.isml.isml.GenericTypeSpecification#getSuperType <em>Super Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Type</em>' containment reference.
	 * @see #getSuperType()
	 * @generated
	 */
	void setSuperType(Type value);

} // GenericTypeSpecification
