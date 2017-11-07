/**
 */
package co.edu.javeriana.isml.isml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link co.edu.javeriana.isml.isml.Import#getImportedPackage <em>Imported Package</em>}</li>
 * </ul>
 *
 * @see co.edu.javeriana.isml.isml.IsmlPackage#getImport()
 * @model
 * @generated
 */
public interface Import extends EObject
{
	/**
	 * Returns the value of the '<em><b>Imported Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Package</em>' reference.
	 * @see #setImportedPackage(co.edu.javeriana.isml.isml.Package)
	 * @see co.edu.javeriana.isml.isml.IsmlPackage#getImport_ImportedPackage()
	 * @model
	 * @generated
	 */
	co.edu.javeriana.isml.isml.Package getImportedPackage();

	/**
	 * Sets the value of the '{@link co.edu.javeriana.isml.isml.Import#getImportedPackage <em>Imported Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imported Package</em>' reference.
	 * @see #getImportedPackage()
	 * @generated
	 */
	void setImportedPackage(co.edu.javeriana.isml.isml.Package value);

} // Import
