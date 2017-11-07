/**
 */
package co.edu.javeriana.isml.isml.impl;

import co.edu.javeriana.isml.isml.InformationSystem;
import co.edu.javeriana.isml.isml.IsmlPackage;
import co.edu.javeriana.isml.isml.NamedElement;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Information System</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class InformationSystemImpl extends CompositeElementImpl<NamedElement> implements InformationSystem
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InformationSystemImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return IsmlPackage.Literals.INFORMATION_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific element type known in this context.
	 * @generated
	 */
	@Override
	public EList<NamedElement> getBody()
	{
		if (body == null)
		{
			body = new EObjectContainmentEList<NamedElement>(NamedElement.class, this, IsmlPackage.INFORMATION_SYSTEM__BODY);
		}
		return body;
	}

} //InformationSystemImpl
