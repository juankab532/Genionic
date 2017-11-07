/**
 */
package co.edu.javeriana.isml.isml.impl;

import co.edu.javeriana.isml.isml.CompositeElement;
import co.edu.javeriana.isml.isml.Function;
import co.edu.javeriana.isml.isml.GenericTypeSpecification;
import co.edu.javeriana.isml.isml.IsmlPackage;
import co.edu.javeriana.isml.isml.Method;
import co.edu.javeriana.isml.isml.MethodStatement;
import co.edu.javeriana.isml.isml.Parameter;

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
 * An implementation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link co.edu.javeriana.isml.isml.impl.MethodImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link co.edu.javeriana.isml.isml.impl.MethodImpl#isNative <em>Native</em>}</li>
 *   <li>{@link co.edu.javeriana.isml.isml.impl.MethodImpl#getGenericTypeParameters <em>Generic Type Parameters</em>}</li>
 *   <li>{@link co.edu.javeriana.isml.isml.impl.MethodImpl#getBody <em>Body</em>}</li>
 *   <li>{@link co.edu.javeriana.isml.isml.impl.MethodImpl#isHasBody <em>Has Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MethodImpl extends FeatureImpl implements Method
{
	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameters;

	/**
	 * The default value of the '{@link #isNative() <em>Native</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNative()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NATIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNative() <em>Native</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNative()
	 * @generated
	 * @ordered
	 */
	protected boolean native_ = NATIVE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGenericTypeParameters() <em>Generic Type Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenericTypeParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<GenericTypeSpecification> genericTypeParameters;

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected EList<MethodStatement> body;

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
	protected MethodImpl()
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
		return IsmlPackage.Literals.METHOD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameters()
	{
		if (parameters == null)
		{
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, IsmlPackage.METHOD__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNative()
	{
		return native_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNative(boolean newNative)
	{
		boolean oldNative = native_;
		native_ = newNative;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IsmlPackage.METHOD__NATIVE, oldNative, native_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenericTypeSpecification> getGenericTypeParameters()
	{
		if (genericTypeParameters == null)
		{
			genericTypeParameters = new EObjectContainmentEList<GenericTypeSpecification>(GenericTypeSpecification.class, this, IsmlPackage.METHOD__GENERIC_TYPE_PARAMETERS);
		}
		return genericTypeParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MethodStatement> getBody()
	{
		if (body == null)
		{
			body = new EObjectContainmentEList<MethodStatement>(MethodStatement.class, this, IsmlPackage.METHOD__BODY);
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
			eNotify(new ENotificationImpl(this, Notification.SET, IsmlPackage.METHOD__HAS_BODY, oldHasBody, hasBody));
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
			case IsmlPackage.METHOD__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case IsmlPackage.METHOD__GENERIC_TYPE_PARAMETERS:
				return ((InternalEList<?>)getGenericTypeParameters()).basicRemove(otherEnd, msgs);
			case IsmlPackage.METHOD__BODY:
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
			case IsmlPackage.METHOD__PARAMETERS:
				return getParameters();
			case IsmlPackage.METHOD__NATIVE:
				return isNative();
			case IsmlPackage.METHOD__GENERIC_TYPE_PARAMETERS:
				return getGenericTypeParameters();
			case IsmlPackage.METHOD__BODY:
				return getBody();
			case IsmlPackage.METHOD__HAS_BODY:
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
			case IsmlPackage.METHOD__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case IsmlPackage.METHOD__NATIVE:
				setNative((Boolean)newValue);
				return;
			case IsmlPackage.METHOD__GENERIC_TYPE_PARAMETERS:
				getGenericTypeParameters().clear();
				getGenericTypeParameters().addAll((Collection<? extends GenericTypeSpecification>)newValue);
				return;
			case IsmlPackage.METHOD__BODY:
				getBody().clear();
				getBody().addAll((Collection<? extends MethodStatement>)newValue);
				return;
			case IsmlPackage.METHOD__HAS_BODY:
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
			case IsmlPackage.METHOD__PARAMETERS:
				getParameters().clear();
				return;
			case IsmlPackage.METHOD__NATIVE:
				setNative(NATIVE_EDEFAULT);
				return;
			case IsmlPackage.METHOD__GENERIC_TYPE_PARAMETERS:
				getGenericTypeParameters().clear();
				return;
			case IsmlPackage.METHOD__BODY:
				getBody().clear();
				return;
			case IsmlPackage.METHOD__HAS_BODY:
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
			case IsmlPackage.METHOD__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case IsmlPackage.METHOD__NATIVE:
				return native_ != NATIVE_EDEFAULT;
			case IsmlPackage.METHOD__GENERIC_TYPE_PARAMETERS:
				return genericTypeParameters != null && !genericTypeParameters.isEmpty();
			case IsmlPackage.METHOD__BODY:
				return body != null && !body.isEmpty();
			case IsmlPackage.METHOD__HAS_BODY:
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
		if (baseClass == Function.class)
		{
			switch (derivedFeatureID)
			{
				case IsmlPackage.METHOD__PARAMETERS: return IsmlPackage.FUNCTION__PARAMETERS;
				case IsmlPackage.METHOD__NATIVE: return IsmlPackage.FUNCTION__NATIVE;
				case IsmlPackage.METHOD__GENERIC_TYPE_PARAMETERS: return IsmlPackage.FUNCTION__GENERIC_TYPE_PARAMETERS;
				default: return -1;
			}
		}
		if (baseClass == CompositeElement.class)
		{
			switch (derivedFeatureID)
			{
				case IsmlPackage.METHOD__BODY: return IsmlPackage.COMPOSITE_ELEMENT__BODY;
				case IsmlPackage.METHOD__HAS_BODY: return IsmlPackage.COMPOSITE_ELEMENT__HAS_BODY;
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
		if (baseClass == Function.class)
		{
			switch (baseFeatureID)
			{
				case IsmlPackage.FUNCTION__PARAMETERS: return IsmlPackage.METHOD__PARAMETERS;
				case IsmlPackage.FUNCTION__NATIVE: return IsmlPackage.METHOD__NATIVE;
				case IsmlPackage.FUNCTION__GENERIC_TYPE_PARAMETERS: return IsmlPackage.METHOD__GENERIC_TYPE_PARAMETERS;
				default: return -1;
			}
		}
		if (baseClass == CompositeElement.class)
		{
			switch (baseFeatureID)
			{
				case IsmlPackage.COMPOSITE_ELEMENT__BODY: return IsmlPackage.METHOD__BODY;
				case IsmlPackage.COMPOSITE_ELEMENT__HAS_BODY: return IsmlPackage.METHOD__HAS_BODY;
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
		result.append(" (native: ");
		result.append(native_);
		result.append(", hasBody: ");
		result.append(hasBody);
		result.append(')');
		return result.toString();
	}

} //MethodImpl
