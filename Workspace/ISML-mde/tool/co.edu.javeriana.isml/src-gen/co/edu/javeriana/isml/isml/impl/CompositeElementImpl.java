/**
 */
package co.edu.javeriana.isml.isml.impl;

import co.edu.javeriana.isml.isml.CompositeElement;
import co.edu.javeriana.isml.isml.Element;
import co.edu.javeriana.isml.isml.IsmlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link co.edu.javeriana.isml.isml.impl.CompositeElementImpl#getBody <em>Body</em>}</li>
 *   <li>{@link co.edu.javeriana.isml.isml.impl.CompositeElementImpl#isHasBody <em>Has Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class CompositeElementImpl<T extends Element> extends NamedElementImpl implements CompositeElement<T>
{
	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected EList<T> body;

	/**
	 * The default value of the '{@link #isHasBody() <em>Has Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasBody()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_BODY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasBody() <em>Has Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasBody()
	 * @generated
	 * @ordered
	 */
	protected boolean hasBody = HAS_BODY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeElementImpl()
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
		return IsmlPackage.Literals.COMPOSITE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<T> getBody()
	{
		if (body == null)
		{
			body = new EObjectContainmentEList<T>(Element.class, this, IsmlPackage.COMPOSITE_ELEMENT__BODY);
		}
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasBody()
	{
		return hasBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasBody(boolean newHasBody)
	{
		boolean oldHasBody = hasBody;
		hasBody = newHasBody;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IsmlPackage.COMPOSITE_ELEMENT__HAS_BODY, oldHasBody, hasBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case IsmlPackage.COMPOSITE_ELEMENT__BODY:
				return ((InternalEList<?>)getBody()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case IsmlPackage.COMPOSITE_ELEMENT__BODY:
				return getBody();
			case IsmlPackage.COMPOSITE_ELEMENT__HAS_BODY:
				return isHasBody();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case IsmlPackage.COMPOSITE_ELEMENT__BODY:
				getBody().clear();
				getBody().addAll((Collection<? extends T>)newValue);
				return;
			case IsmlPackage.COMPOSITE_ELEMENT__HAS_BODY:
				setHasBody((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case IsmlPackage.COMPOSITE_ELEMENT__BODY:
				getBody().clear();
				return;
			case IsmlPackage.COMPOSITE_ELEMENT__HAS_BODY:
				setHasBody(HAS_BODY_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case IsmlPackage.COMPOSITE_ELEMENT__BODY:
				return body != null && !body.isEmpty();
			case IsmlPackage.COMPOSITE_ELEMENT__HAS_BODY:
				return hasBody != HAS_BODY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (hasBody: ");
		result.append(hasBody);
		result.append(')');
		return result.toString();
	}

} //CompositeElementImpl
