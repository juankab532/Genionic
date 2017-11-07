/**
 */
package co.edu.javeriana.isml.isml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link co.edu.javeriana.isml.isml.TypeSpecification#getSuperTypes <em>Super Types</em>}</li>
 *   <li>{@link co.edu.javeriana.isml.isml.TypeSpecification#isAbstract <em>Abstract</em>}</li>
 * </ul>
 *
 * @see co.edu.javeriana.isml.isml.IsmlPackage#getTypeSpecification()
 * @model abstract="true"
 * @generated
 */
public interface TypeSpecification extends Function, NamedElement
{
	/**
	 * Returns the value of the '<em><b>Super Types</b></em>' containment reference list.
	 * The list contents are of type {@link co.edu.javeriana.isml.isml.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Types</em>' containment reference list.
	 * @see co.edu.javeriana.isml.isml.IsmlPackage#getTypeSpecification_SuperTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Type> getSuperTypes();

	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #setAbstract(boolean)
	 * @see co.edu.javeriana.isml.isml.IsmlPackage#getTypeSpecification_Abstract()
	 * @model
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link co.edu.javeriana.isml.isml.TypeSpecification#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

} // TypeSpecification
