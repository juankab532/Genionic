/**
 */
package co.edu.javeriana.isml.isml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link co.edu.javeriana.isml.isml.ViewInstance#getActionCall <em>Action Call</em>}</li>
 * </ul>
 *
 * @see co.edu.javeriana.isml.isml.IsmlPackage#getViewInstance()
 * @model
 * @generated
 */
public interface ViewInstance extends Instance, CompositeViewStatement
{
	/**
	 * Returns the value of the '<em><b>Action Call</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Call</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Call</em>' containment reference.
	 * @see #setActionCall(ActionCall)
	 * @see co.edu.javeriana.isml.isml.IsmlPackage#getViewInstance_ActionCall()
	 * @model containment="true"
	 * @generated
	 */
	ActionCall getActionCall();

	/**
	 * Sets the value of the '{@link co.edu.javeriana.isml.isml.ViewInstance#getActionCall <em>Action Call</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Call</em>' containment reference.
	 * @see #getActionCall()
	 * @generated
	 */
	void setActionCall(ActionCall value);

} // ViewInstance
