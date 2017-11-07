/**
 */
package co.edu.javeriana.isml.isml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link co.edu.javeriana.isml.isml.If#getElseBody <em>Else Body</em>}</li>
 * </ul>
 *
 * @see co.edu.javeriana.isml.isml.IsmlPackage#getIf()
 * @model
 * @generated
 */
public interface If extends Conditional, CompositeMethodStatement
{
	/**
	 * Returns the value of the '<em><b>Else Body</b></em>' containment reference list.
	 * The list contents are of type {@link co.edu.javeriana.isml.isml.MethodStatement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else Body</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else Body</em>' containment reference list.
	 * @see co.edu.javeriana.isml.isml.IsmlPackage#getIf_ElseBody()
	 * @model containment="true"
	 * @generated
	 */
	EList<MethodStatement> getElseBody();

} // If
