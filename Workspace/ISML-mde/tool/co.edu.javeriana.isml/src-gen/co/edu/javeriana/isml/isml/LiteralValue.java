/**
 */
package co.edu.javeriana.isml.isml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link co.edu.javeriana.isml.isml.LiteralValue#getLiteral <em>Literal</em>}</li>
 * </ul>
 *
 * @see co.edu.javeriana.isml.isml.IsmlPackage#getLiteralValue()
 * @model
 * @generated
 */
public interface LiteralValue extends Expression
{
	/**
	 * Returns the value of the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal</em>' attribute.
	 * @see #setLiteral(Object)
	 * @see co.edu.javeriana.isml.isml.IsmlPackage#getLiteralValue_Literal()
	 * @model
	 * @generated
	 */
	Object getLiteral();

	/**
	 * Sets the value of the '{@link co.edu.javeriana.isml.isml.LiteralValue#getLiteral <em>Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal</em>' attribute.
	 * @see #getLiteral()
	 * @generated
	 */
	void setLiteral(Object value);

} // LiteralValue
