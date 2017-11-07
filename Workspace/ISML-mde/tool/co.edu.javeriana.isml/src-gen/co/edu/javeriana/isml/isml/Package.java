/**
 */
package co.edu.javeriana.isml.isml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link co.edu.javeriana.isml.isml.Package#getImports <em>Imports</em>}</li>
 * </ul>
 *
 * @see co.edu.javeriana.isml.isml.IsmlPackage#getPackage()
 * @model
 * @generated
 */
public interface Package extends CompositeElement<NamedElement>
{
	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link co.edu.javeriana.isml.isml.Import}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see co.edu.javeriana.isml.isml.IsmlPackage#getPackage_Imports()
	 * @model containment="true"
	 * @generated
	 */
	EList<Import> getImports();

} // Package
