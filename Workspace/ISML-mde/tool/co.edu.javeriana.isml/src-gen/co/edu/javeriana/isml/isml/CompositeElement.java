/**
 */
package co.edu.javeriana.isml.isml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link co.edu.javeriana.isml.isml.CompositeElement#getBody <em>Body</em>}</li>
 *   <li>{@link co.edu.javeriana.isml.isml.CompositeElement#isHasBody <em>Has Body</em>}</li>
 * </ul>
 *
 * @see co.edu.javeriana.isml.isml.IsmlPackage#getCompositeElement()
 * @model abstract="true"
 * @generated
 */
public interface CompositeElement<T extends Element> extends NamedElement
{
	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference list.
	 * @see co.edu.javeriana.isml.isml.IsmlPackage#getCompositeElement_Body()
	 * @model containment="true"
	 * @generated
	 */
	EList<T> getBody();

	/**
	 * Returns the value of the '<em><b>Has Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Body</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Body</em>' attribute.
	 * @see #setHasBody(boolean)
	 * @see co.edu.javeriana.isml.isml.IsmlPackage#getCompositeElement_HasBody()
	 * @model
	 * @generated
	 */
	boolean isHasBody();

	/**
	 * Sets the value of the '{@link co.edu.javeriana.isml.isml.CompositeElement#isHasBody <em>Has Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Body</em>' attribute.
	 * @see #isHasBody()
	 * @generated
	 */
	void setHasBody(boolean value);

} // CompositeElement
