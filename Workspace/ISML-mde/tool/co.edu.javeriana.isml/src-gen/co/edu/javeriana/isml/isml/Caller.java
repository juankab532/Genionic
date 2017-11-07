/**
 */
package co.edu.javeriana.isml.isml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Caller</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link co.edu.javeriana.isml.isml.Caller#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see co.edu.javeriana.isml.isml.IsmlPackage#getCaller()
 * @model abstract="true"
 * @generated
 */
public interface Caller extends EObject
{
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link co.edu.javeriana.isml.isml.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see co.edu.javeriana.isml.isml.IsmlPackage#getCaller_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getParameters();

} // Caller
