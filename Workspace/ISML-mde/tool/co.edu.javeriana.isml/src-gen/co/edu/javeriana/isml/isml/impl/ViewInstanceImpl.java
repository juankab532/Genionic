/**
 */
package co.edu.javeriana.isml.isml.impl;

import co.edu.javeriana.isml.isml.ActionCall;
import co.edu.javeriana.isml.isml.CompositeElement;
import co.edu.javeriana.isml.isml.CompositeViewStatement;
import co.edu.javeriana.isml.isml.IsmlPackage;
import co.edu.javeriana.isml.isml.Statement;
import co.edu.javeriana.isml.isml.ViewInstance;
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
 * An implementation of the model object '<em><b>View Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link co.edu.javeriana.isml.isml.impl.ViewInstanceImpl#getBody <em>Body</em>}</li>
 *   <li>{@link co.edu.javeriana.isml.isml.impl.ViewInstanceImpl#isHasBody <em>Has Body</em>}</li>
 *   <li>{@link co.edu.javeriana.isml.isml.impl.ViewInstanceImpl#getActionCall <em>Action Call</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ViewInstanceImpl extends InstanceImpl implements ViewInstance
{
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
	 * The cached value of the '{@link #getActionCall() <em>Action Call</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActionCall()
	 * @generated
	 * @ordered
	 */
	protected ActionCall actionCall;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewInstanceImpl()
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
		return IsmlPackage.Literals.VIEW_INSTANCE;
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
			body = new EObjectContainmentEList<ViewStatement>(ViewStatement.class, this, IsmlPackage.VIEW_INSTANCE__BODY);
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
			eNotify(new ENotificationImpl(this, Notification.SET, IsmlPackage.VIEW_INSTANCE__HAS_BODY, oldHasBody, hasBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionCall getActionCall()
	{
		return actionCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetActionCall(ActionCall newActionCall, NotificationChain msgs)
	{
		ActionCall oldActionCall = actionCall;
		actionCall = newActionCall;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IsmlPackage.VIEW_INSTANCE__ACTION_CALL, oldActionCall, newActionCall);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActionCall(ActionCall newActionCall)
	{
		if (newActionCall != actionCall)
		{
			NotificationChain msgs = null;
			if (actionCall != null)
				msgs = ((InternalEObject)actionCall).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IsmlPackage.VIEW_INSTANCE__ACTION_CALL, null, msgs);
			if (newActionCall != null)
				msgs = ((InternalEObject)newActionCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IsmlPackage.VIEW_INSTANCE__ACTION_CALL, null, msgs);
			msgs = basicSetActionCall(newActionCall, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IsmlPackage.VIEW_INSTANCE__ACTION_CALL, newActionCall, newActionCall));
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
			case IsmlPackage.VIEW_INSTANCE__BODY:
				return ((InternalEList<?>)getBody()).basicRemove(otherEnd, msgs);
			case IsmlPackage.VIEW_INSTANCE__ACTION_CALL:
				return basicSetActionCall(null, msgs);
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
			case IsmlPackage.VIEW_INSTANCE__BODY:
				return getBody();
			case IsmlPackage.VIEW_INSTANCE__HAS_BODY:
				return isHasBody();
			case IsmlPackage.VIEW_INSTANCE__ACTION_CALL:
				return getActionCall();
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
			case IsmlPackage.VIEW_INSTANCE__BODY:
				getBody().clear();
				getBody().addAll((Collection<? extends ViewStatement>)newValue);
				return;
			case IsmlPackage.VIEW_INSTANCE__HAS_BODY:
				setHasBody((Boolean)newValue);
				return;
			case IsmlPackage.VIEW_INSTANCE__ACTION_CALL:
				setActionCall((ActionCall)newValue);
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
			case IsmlPackage.VIEW_INSTANCE__BODY:
				getBody().clear();
				return;
			case IsmlPackage.VIEW_INSTANCE__HAS_BODY:
				setHasBody(HAS_BODY_EDEFAULT);
				return;
			case IsmlPackage.VIEW_INSTANCE__ACTION_CALL:
				setActionCall((ActionCall)null);
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
			case IsmlPackage.VIEW_INSTANCE__BODY:
				return body != null && !body.isEmpty();
			case IsmlPackage.VIEW_INSTANCE__HAS_BODY:
				return hasBody != HAS_BODY_EDEFAULT;
			case IsmlPackage.VIEW_INSTANCE__ACTION_CALL:
				return actionCall != null;
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
				case IsmlPackage.VIEW_INSTANCE__BODY: return IsmlPackage.COMPOSITE_ELEMENT__BODY;
				case IsmlPackage.VIEW_INSTANCE__HAS_BODY: return IsmlPackage.COMPOSITE_ELEMENT__HAS_BODY;
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
				case IsmlPackage.COMPOSITE_ELEMENT__BODY: return IsmlPackage.VIEW_INSTANCE__BODY;
				case IsmlPackage.COMPOSITE_ELEMENT__HAS_BODY: return IsmlPackage.VIEW_INSTANCE__HAS_BODY;
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
		result.append(" (hasBody: ");
		result.append(hasBody);
		result.append(')');
		return result.toString();
	}

} //ViewInstanceImpl
