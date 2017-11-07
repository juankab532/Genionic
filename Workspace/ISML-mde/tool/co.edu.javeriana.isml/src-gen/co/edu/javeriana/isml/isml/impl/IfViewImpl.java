/**
 */
package co.edu.javeriana.isml.isml.impl;

import co.edu.javeriana.isml.isml.CompositeElement;
import co.edu.javeriana.isml.isml.CompositeViewStatement;
import co.edu.javeriana.isml.isml.Element;
import co.edu.javeriana.isml.isml.IfView;
import co.edu.javeriana.isml.isml.IsmlPackage;
import co.edu.javeriana.isml.isml.NamedElement;
import co.edu.javeriana.isml.isml.Statement;
import co.edu.javeriana.isml.isml.ViewStatement;

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
 * An implementation of the model object '<em><b>If View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link co.edu.javeriana.isml.isml.impl.IfViewImpl#getName <em>Name</em>}</li>
 *   <li>{@link co.edu.javeriana.isml.isml.impl.IfViewImpl#getBody <em>Body</em>}</li>
 *   <li>{@link co.edu.javeriana.isml.isml.impl.IfViewImpl#isHasBody <em>Has Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfViewImpl extends ConditionalImpl implements IfView
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected EList<ViewStatement> body;

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
	protected IfViewImpl()
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
		return IsmlPackage.Literals.IF_VIEW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IsmlPackage.IF_VIEW__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ViewStatement> getBody()
	{
		if (body == null)
		{
			body = new EObjectContainmentEList<ViewStatement>(ViewStatement.class, this, IsmlPackage.IF_VIEW__BODY);
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
			eNotify(new ENotificationImpl(this, Notification.SET, IsmlPackage.IF_VIEW__HAS_BODY, oldHasBody, hasBody));
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
			case IsmlPackage.IF_VIEW__BODY:
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
			case IsmlPackage.IF_VIEW__NAME:
				return getName();
			case IsmlPackage.IF_VIEW__BODY:
				return getBody();
			case IsmlPackage.IF_VIEW__HAS_BODY:
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
			case IsmlPackage.IF_VIEW__NAME:
				setName((String)newValue);
				return;
			case IsmlPackage.IF_VIEW__BODY:
				getBody().clear();
				getBody().addAll((Collection<? extends ViewStatement>)newValue);
				return;
			case IsmlPackage.IF_VIEW__HAS_BODY:
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
			case IsmlPackage.IF_VIEW__NAME:
				setName(NAME_EDEFAULT);
				return;
			case IsmlPackage.IF_VIEW__BODY:
				getBody().clear();
				return;
			case IsmlPackage.IF_VIEW__HAS_BODY:
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
			case IsmlPackage.IF_VIEW__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case IsmlPackage.IF_VIEW__BODY:
				return body != null && !body.isEmpty();
			case IsmlPackage.IF_VIEW__HAS_BODY:
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == Element.class)
		{
			switch (derivedFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == NamedElement.class)
		{
			switch (derivedFeatureID)
			{
				case IsmlPackage.IF_VIEW__NAME: return IsmlPackage.NAMED_ELEMENT__NAME;
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
		if (baseClass == ViewStatement.class)
		{
			switch (derivedFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == CompositeElement.class)
		{
			switch (derivedFeatureID)
			{
				case IsmlPackage.IF_VIEW__BODY: return IsmlPackage.COMPOSITE_ELEMENT__BODY;
				case IsmlPackage.IF_VIEW__HAS_BODY: return IsmlPackage.COMPOSITE_ELEMENT__HAS_BODY;
				default: return -1;
			}
		}
		if (baseClass == CompositeViewStatement.class)
		{
			switch (derivedFeatureID)
			{
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
		if (baseClass == Element.class)
		{
			switch (baseFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == NamedElement.class)
		{
			switch (baseFeatureID)
			{
				case IsmlPackage.NAMED_ELEMENT__NAME: return IsmlPackage.IF_VIEW__NAME;
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
		if (baseClass == ViewStatement.class)
		{
			switch (baseFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == CompositeElement.class)
		{
			switch (baseFeatureID)
			{
				case IsmlPackage.COMPOSITE_ELEMENT__BODY: return IsmlPackage.IF_VIEW__BODY;
				case IsmlPackage.COMPOSITE_ELEMENT__HAS_BODY: return IsmlPackage.IF_VIEW__HAS_BODY;
				default: return -1;
			}
		}
		if (baseClass == CompositeViewStatement.class)
		{
			switch (baseFeatureID)
			{
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", hasBody: ");
		result.append(hasBody);
		result.append(')');
		return result.toString();
	}

} //IfViewImpl
