/**
 */
package co.edu.javeriana.isml.isml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link co.edu.javeriana.isml.isml.Reference#getTail <em>Tail</em>}</li>
 *   <li>{@link co.edu.javeriana.isml.isml.Reference#getReferencedElement <em>Referenced Element</em>}</li>
 * </ul>
 *
 * @see co.edu.javeriana.isml.isml.IsmlPackage#getReference()
 * @model abstract="true"
 * @generated
 */
public interface Reference<T extends NamedElement> extends Expression, MethodStatement
{
	/**
	 * Returns the value of the '<em><b>Tail</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tail</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tail</em>' containment reference.
	 * @see #setTail(Reference)
	 * @see co.edu.javeriana.isml.isml.IsmlPackage#getReference_Tail()
	 * @model containment="true"
	 * @generated
	 */
	Reference<? extends NamedElement> getTail();

	/**
	 * Sets the value of the '{@link co.edu.javeriana.isml.isml.Reference#getTail <em>Tail</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tail</em>' containment reference.
	 * @see #getTail()
	 * @generated
	 */
	void setTail(Reference<? extends NamedElement> value);

	/**
	 * Returns the value of the '<em><b>Referenced Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Element</em>' reference.
	 * @see #setReferencedElement(NamedElement)
	 * @see co.edu.javeriana.isml.isml.IsmlPackage#getReference_ReferencedElement()
	 * @model
	 * @generated
	 */
	T getReferencedElement();

	/**
	 * Sets the value of the '{@link co.edu.javeriana.isml.isml.Reference#getReferencedElement <em>Referenced Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Element</em>' reference.
	 * @see #getReferencedElement()
	 * @generated
	 */
	void setReferencedElement(T value);

} // Reference
