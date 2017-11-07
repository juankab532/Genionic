/**
 */
package co.edu.javeriana.isml.isml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link co.edu.javeriana.isml.isml.Function#getParameters <em>Parameters</em>}</li>
 *   <li>{@link co.edu.javeriana.isml.isml.Function#isNative <em>Native</em>}</li>
 *   <li>{@link co.edu.javeriana.isml.isml.Function#getGenericTypeParameters <em>Generic Type Parameters</em>}</li>
 * </ul>
 *
 * @see co.edu.javeriana.isml.isml.IsmlPackage#getFunction()
 * @model abstract="true"
 * @generated
 */
public interface Function extends NamedElement
{
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link co.edu.javeriana.isml.isml.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see co.edu.javeriana.isml.isml.IsmlPackage#getFunction_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Native</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Native</em>' attribute.
	 * @see #setNative(boolean)
	 * @see co.edu.javeriana.isml.isml.IsmlPackage#getFunction_Native()
	 * @model
	 * @generated
	 */
	boolean isNative();

	/**
	 * Sets the value of the '{@link co.edu.javeriana.isml.isml.Function#isNative <em>Native</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Native</em>' attribute.
	 * @see #isNative()
	 * @generated
	 */
	void setNative(boolean value);

	/**
	 * Returns the value of the '<em><b>Generic Type Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link co.edu.javeriana.isml.isml.GenericTypeSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generic Type Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generic Type Parameters</em>' containment reference list.
	 * @see co.edu.javeriana.isml.isml.IsmlPackage#getFunction_GenericTypeParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<GenericTypeSpecification> getGenericTypeParameters();

} // Function
