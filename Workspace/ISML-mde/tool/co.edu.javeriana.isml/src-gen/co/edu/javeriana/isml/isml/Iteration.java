/**
 */
package co.edu.javeriana.isml.isml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iteration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link co.edu.javeriana.isml.isml.Iteration#getVariable <em>Variable</em>}</li>
 *   <li>{@link co.edu.javeriana.isml.isml.Iteration#getCollection <em>Collection</em>}</li>
 * </ul>
 *
 * @see co.edu.javeriana.isml.isml.IsmlPackage#getIteration()
 * @model abstract="true"
 * @generated
 */
public interface Iteration extends EObject
{
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference.
	 * @see #setVariable(Variable)
	 * @see co.edu.javeriana.isml.isml.IsmlPackage#getIteration_Variable()
	 * @model containment="true"
	 * @generated
	 */
	Variable getVariable();

	/**
	 * Sets the value of the '{@link co.edu.javeriana.isml.isml.Iteration#getVariable <em>Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' containment reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Collection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collection</em>' containment reference.
	 * @see #setCollection(Reference)
	 * @see co.edu.javeriana.isml.isml.IsmlPackage#getIteration_Collection()
	 * @model containment="true"
	 * @generated
	 */
	Reference getCollection();

	/**
	 * Sets the value of the '{@link co.edu.javeriana.isml.isml.Iteration#getCollection <em>Collection</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collection</em>' containment reference.
	 * @see #getCollection()
	 * @generated
	 */
	void setCollection(Reference value);

} // Iteration
