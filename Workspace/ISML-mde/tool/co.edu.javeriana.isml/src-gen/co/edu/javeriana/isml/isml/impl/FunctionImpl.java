/**
 */
package co.edu.javeriana.isml.isml.impl;

import co.edu.javeriana.isml.isml.Function;
import co.edu.javeriana.isml.isml.GenericTypeSpecification;
import co.edu.javeriana.isml.isml.IsmlPackage;
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
 * An implementation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link co.edu.javeriana.isml.isml.impl.FunctionImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link co.edu.javeriana.isml.isml.impl.FunctionImpl#isNative <em>Native</em>}</li>
 *   <li>{@link co.edu.javeriana.isml.isml.impl.FunctionImpl#getGenericTypeParameters <em>Generic Type Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class FunctionImpl extends NamedElementImpl implements Function
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionImpl()
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
		return IsmlPackage.Literals.FUNCTION;
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
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, IsmlPackage.FUNCTION__PARAMETERS);
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
			eNotify(new ENotificationImpl(this, Notification.SET, IsmlPackage.FUNCTION__NATIVE, oldNative, native_));
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
			genericTypeParameters = new EObjectContainmentEList<GenericTypeSpecification>(GenericTypeSpecification.class, this, IsmlPackage.FUNCTION__GENERIC_TYPE_PARAMETERS);
		}
		return genericTypeParameters;
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
			case IsmlPackage.FUNCTION__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case IsmlPackage.FUNCTION__GENERIC_TYPE_PARAMETERS:
				return ((InternalEList<?>)getGenericTypeParameters()).basicRemove(otherEnd, msgs);
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
			case IsmlPackage.FUNCTION__PARAMETERS:
				return getParameters();
			case IsmlPackage.FUNCTION__NATIVE:
				return isNative();
			case IsmlPackage.FUNCTION__GENERIC_TYPE_PARAMETERS:
				return getGenericTypeParameters();
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
			case IsmlPackage.FUNCTION__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case IsmlPackage.FUNCTION__NATIVE:
				setNative((Boolean)newValue);
				return;
			case IsmlPackage.FUNCTION__GENERIC_TYPE_PARAMETERS:
				getGenericTypeParameters().clear();
				getGenericTypeParameters().addAll((Collection<? extends GenericTypeSpecification>)newValue);
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
			case IsmlPackage.FUNCTION__PARAMETERS:
				getParameters().clear();
				return;
			case IsmlPackage.FUNCTION__NATIVE:
				setNative(NATIVE_EDEFAULT);
				return;
			case IsmlPackage.FUNCTION__GENERIC_TYPE_PARAMETERS:
				getGenericTypeParameters().clear();
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
			case IsmlPackage.FUNCTION__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case IsmlPackage.FUNCTION__NATIVE:
				return native_ != NATIVE_EDEFAULT;
			case IsmlPackage.FUNCTION__GENERIC_TYPE_PARAMETERS:
				return genericTypeParameters != null && !genericTypeParameters.isEmpty();
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
		result.append(" (native: ");
		result.append(native_);
		result.append(')');
		return result.toString();
	}

} //FunctionImpl
