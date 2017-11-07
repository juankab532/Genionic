/**
 */
package co.edu.javeriana.isml.isml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link co.edu.javeriana.isml.isml.Attribute#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link co.edu.javeriana.isml.isml.Attribute#getConstraints <em>Constraints</em>}</li>
 * </ul>
 *
 * @see co.edu.javeriana.isml.isml.IsmlPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends VariableTypeElement, Feature
{
	/**
	 * Returns the value of the '<em><b>Opposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opposite</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opposite</em>' reference.
	 * @see #setOpposite(Attribute)
	 * @see co.edu.javeriana.isml.isml.IsmlPackage#getAttribute_Opposite()
	 * @model
	 * @generated
	 */
	Attribute getOpposite();

	/**
	 * Sets the value of the '{@link co.edu.javeriana.isml.isml.Attribute#getOpposite <em>Opposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opposite</em>' reference.
	 * @see #getOpposite()
	 * @generated
	 */
	void setOpposite(Attribute value);

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link co.edu.javeriana.isml.isml.ConstraintInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see co.edu.javeriana.isml.isml.IsmlPackage#getAttribute_Constraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstraintInstance> getConstraints();

} // Attribute
