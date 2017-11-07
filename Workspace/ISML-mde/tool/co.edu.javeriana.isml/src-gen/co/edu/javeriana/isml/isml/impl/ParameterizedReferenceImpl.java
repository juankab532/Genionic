/**
 */
package co.edu.javeriana.isml.isml.impl;

import co.edu.javeriana.isml.isml.Element;
import co.edu.javeriana.isml.isml.Expression;
import co.edu.javeriana.isml.isml.IsmlPackage;
import co.edu.javeriana.isml.isml.MethodStatement;
import co.edu.javeriana.isml.isml.NamedElement;
import co.edu.javeriana.isml.isml.ParameterizedReference;
import co.edu.javeriana.isml.isml.Reference;
import co.edu.javeriana.isml.isml.Statement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameterized Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link co.edu.javeriana.isml.isml.impl.ParameterizedReferenceImpl#getTail <em>Tail</em>}</li>
 *   <li>{@link co.edu.javeriana.isml.isml.impl.ParameterizedReferenceImpl#getReferencedElement <em>Referenced Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ParameterizedReferenceImpl<T extends NamedElement> extends CallerImpl implements ParameterizedReference<T>
{
	/**
	 * The cached value of the '{@link #getTail() <em>Tail</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTail()
	 * @generated
	 * @ordered
	 */
	protected Reference<? extends NamedElement> tail;

	/**
	 * The cached value of the '{@link #getReferencedElement() <em>Referenced Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedElement()
	 * @generated
	 * @ordered
	 */
	protected T referencedElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterizedReferenceImpl()
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
		return IsmlPackage.Literals.PARAMETERIZED_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reference<? extends NamedElement> getTail()
	{
		return tail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTail(Reference<? extends NamedElement> newTail, NotificationChain msgs)
	{
		Reference<? extends NamedElement> oldTail = tail;
		tail = newTail;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IsmlPackage.PARAMETERIZED_REFERENCE__TAIL, oldTail, newTail);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTail(Reference<? extends NamedElement> newTail)
	{
		if (newTail != tail)
		{
			NotificationChain msgs = null;
			if (tail != null)
				msgs = ((InternalEObject)tail).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IsmlPackage.PARAMETERIZED_REFERENCE__TAIL, null, msgs);
			if (newTail != null)
				msgs = ((InternalEObject)newTail).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IsmlPackage.PARAMETERIZED_REFERENCE__TAIL, null, msgs);
			msgs = basicSetTail(newTail, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IsmlPackage.PARAMETERIZED_REFERENCE__TAIL, newTail, newTail));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public T getReferencedElement()
	{
		if (referencedElement != null && referencedElement.eIsProxy())
		{
			InternalEObject oldReferencedElement = (InternalEObject)referencedElement;
			referencedElement = (T)eResolveProxy(oldReferencedElement);
			if (referencedElement != oldReferencedElement)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IsmlPackage.PARAMETERIZED_REFERENCE__REFERENCED_ELEMENT, oldReferencedElement, referencedElement));
			}
		}
		return referencedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public T basicGetReferencedElement()
	{
		return referencedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedElement(T newReferencedElement)
	{
		T oldReferencedElement = referencedElement;
		referencedElement = newReferencedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IsmlPackage.PARAMETERIZED_REFERENCE__REFERENCED_ELEMENT, oldReferencedElement, referencedElement));
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
			case IsmlPackage.PARAMETERIZED_REFERENCE__TAIL:
				return basicSetTail(null, msgs);
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
			case IsmlPackage.PARAMETERIZED_REFERENCE__TAIL:
				return getTail();
			case IsmlPackage.PARAMETERIZED_REFERENCE__REFERENCED_ELEMENT:
				if (resolve) return getReferencedElement();
				return basicGetReferencedElement();
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
			case IsmlPackage.PARAMETERIZED_REFERENCE__TAIL:
				setTail((Reference<? extends NamedElement>)newValue);
				return;
			case IsmlPackage.PARAMETERIZED_REFERENCE__REFERENCED_ELEMENT:
				setReferencedElement((T)newValue);
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
			case IsmlPackage.PARAMETERIZED_REFERENCE__TAIL:
				setTail((Reference<? extends NamedElement>)null);
				return;
			case IsmlPackage.PARAMETERIZED_REFERENCE__REFERENCED_ELEMENT:
				setReferencedElement((T)null);
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
			case IsmlPackage.PARAMETERIZED_REFERENCE__TAIL:
				return tail != null;
			case IsmlPackage.PARAMETERIZED_REFERENCE__REFERENCED_ELEMENT:
				return referencedElement != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == Expression.class)
		{
			switch (derivedFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == Element.class)
		{
			switch (derivedFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == Statement.class)
		{
			switch (derivedFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == MethodStatement.class)
		{
			switch (derivedFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == Reference.class)
		{
			switch (derivedFeatureID)
			{
				case IsmlPackage.PARAMETERIZED_REFERENCE__TAIL: return IsmlPackage.REFERENCE__TAIL;
				case IsmlPackage.PARAMETERIZED_REFERENCE__REFERENCED_ELEMENT: return IsmlPackage.REFERENCE__REFERENCED_ELEMENT;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
	{
		if (baseClass == Expression.class)
		{
			switch (baseFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == Element.class)
		{
			switch (baseFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == Statement.class)
		{
			switch (baseFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == MethodStatement.class)
		{
			switch (baseFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == Reference.class)
		{
			switch (baseFeatureID)
			{
				case IsmlPackage.REFERENCE__TAIL: return IsmlPackage.PARAMETERIZED_REFERENCE__TAIL;
				case IsmlPackage.REFERENCE__REFERENCED_ELEMENT: return IsmlPackage.PARAMETERIZED_REFERENCE__REFERENCED_ELEMENT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //ParameterizedReferenceImpl
