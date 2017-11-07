/**
 */
package co.edu.javeriana.isml.isml.impl;

import co.edu.javeriana.isml.isml.CompositeTypeSpecification;
import co.edu.javeriana.isml.isml.Element;
import co.edu.javeriana.isml.isml.Function;
import co.edu.javeriana.isml.isml.GenericTypeSpecification;
import co.edu.javeriana.isml.isml.IsmlPackage;
import co.edu.javeriana.isml.isml.Parameter;
import co.edu.javeriana.isml.isml.Type;
import co.edu.javeriana.isml.isml.TypeSpecification;

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
 * An implementation of the model object '<em><b>Composite Type Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link co.edu.javeriana.isml.isml.impl.CompositeTypeSpecificationImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link co.edu.javeriana.isml.isml.impl.CompositeTypeSpecificationImpl#isNative <em>Native</em>}</li>
 *   <li>{@link co.edu.javeriana.isml.isml.impl.CompositeTypeSpecificationImpl#getGenericTypeParameters <em>Generic Type Parameters</em>}</li>
 *   <li>{@link co.edu.javeriana.isml.isml.impl.CompositeTypeSpecificationImpl#getSuperTypes <em>Super Types</em>}</li>
 *   <li>{@link co.edu.javeriana.isml.isml.impl.CompositeTypeSpecificationImpl#isAbstract <em>Abstract</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class CompositeTypeSpecificationImpl<T extends Element> extends CompositeElementImpl<T> implements CompositeTypeSpecification<T>
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
	 * The cached value of the '{@link #getSuperTypes() <em>Super Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<Type> superTypes;

	/**
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeTypeSpecificationImpl()
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
		return IsmlPackage.Literals.COMPOSITE_TYPE_SPECIFICATION;
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
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__PARAMETERS);
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
			eNotify(new ENotificationImpl(this, Notification.SET, IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__NATIVE, oldNative, native_));
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
			genericTypeParameters = new EObjectContainmentEList<GenericTypeSpecification>(GenericTypeSpecification.class, this, IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__GENERIC_TYPE_PARAMETERS);
		}
		return genericTypeParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Type> getSuperTypes()
	{
		if (superTypes == null)
		{
			superTypes = new EObjectContainmentEList<Type>(Type.class, this, IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__SUPER_TYPES);
		}
		return superTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstract()
	{
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstract(boolean newAbstract)
	{
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__ABSTRACT, oldAbstract, abstract_));
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
			case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__GENERIC_TYPE_PARAMETERS:
				return ((InternalEList<?>)getGenericTypeParameters()).basicRemove(otherEnd, msgs);
			case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__SUPER_TYPES:
				return ((InternalEList<?>)getSuperTypes()).basicRemove(otherEnd, msgs);
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
			case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__PARAMETERS:
				return getParameters();
			case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__NATIVE:
				return isNative();
			case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__GENERIC_TYPE_PARAMETERS:
				return getGenericTypeParameters();
			case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__SUPER_TYPES:
				return getSuperTypes();
			case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__ABSTRACT:
				return isAbstract();
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
			case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__NATIVE:
				setNative((Boolean)newValue);
				return;
			case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__GENERIC_TYPE_PARAMETERS:
				getGenericTypeParameters().clear();
				getGenericTypeParameters().addAll((Collection<? extends GenericTypeSpecification>)newValue);
				return;
			case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__SUPER_TYPES:
				getSuperTypes().clear();
				getSuperTypes().addAll((Collection<? extends Type>)newValue);
				return;
			case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__ABSTRACT:
				setAbstract((Boolean)newValue);
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
			case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__PARAMETERS:
				getParameters().clear();
				return;
			case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__NATIVE:
				setNative(NATIVE_EDEFAULT);
				return;
			case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__GENERIC_TYPE_PARAMETERS:
				getGenericTypeParameters().clear();
				return;
			case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__SUPER_TYPES:
				getSuperTypes().clear();
				return;
			case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
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
			case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__NATIVE:
				return native_ != NATIVE_EDEFAULT;
			case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__GENERIC_TYPE_PARAMETERS:
				return genericTypeParameters != null && !genericTypeParameters.isEmpty();
			case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__SUPER_TYPES:
				return superTypes != null && !superTypes.isEmpty();
			case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
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
				case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__PARAMETERS: return IsmlPackage.FUNCTION__PARAMETERS;
				case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__NATIVE: return IsmlPackage.FUNCTION__NATIVE;
				case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__GENERIC_TYPE_PARAMETERS: return IsmlPackage.FUNCTION__GENERIC_TYPE_PARAMETERS;
				default: return -1;
			}
		}
		if (baseClass == TypeSpecification.class)
		{
			switch (derivedFeatureID)
			{
				case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__SUPER_TYPES: return IsmlPackage.TYPE_SPECIFICATION__SUPER_TYPES;
				case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__ABSTRACT: return IsmlPackage.TYPE_SPECIFICATION__ABSTRACT;
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
				case IsmlPackage.FUNCTION__PARAMETERS: return IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__PARAMETERS;
				case IsmlPackage.FUNCTION__NATIVE: return IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__NATIVE;
				case IsmlPackage.FUNCTION__GENERIC_TYPE_PARAMETERS: return IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__GENERIC_TYPE_PARAMETERS;
				default: return -1;
			}
		}
		if (baseClass == TypeSpecification.class)
		{
			switch (baseFeatureID)
			{
				case IsmlPackage.TYPE_SPECIFICATION__SUPER_TYPES: return IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__SUPER_TYPES;
				case IsmlPackage.TYPE_SPECIFICATION__ABSTRACT: return IsmlPackage.COMPOSITE_TYPE_SPECIFICATION__ABSTRACT;
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
		result.append(", abstract: ");
		result.append(abstract_);
		result.append(')');
		return result.toString();
	}

} //CompositeTypeSpecificationImpl
