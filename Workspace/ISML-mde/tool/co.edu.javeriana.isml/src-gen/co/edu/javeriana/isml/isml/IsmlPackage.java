/**
 */
package co.edu.javeriana.isml.isml;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see co.edu.javeriana.isml.isml.IsmlFactory
 * @model kind="package"
 * @generated
 */
public interface IsmlPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "isml";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.javeriana.edu.co/isml/Isml";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Isml";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	IsmlPackage eINSTANCE = co.edu.javeriana.isml.isml.impl.IsmlPackageImpl.init();

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.ElementImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 72;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.NamedElementImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.CompositeElementImpl <em>Composite Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.CompositeElementImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getCompositeElement()
	 * @generated
	 */
	int COMPOSITE_ELEMENT = 70;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ELEMENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ELEMENT__BODY = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Has Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ELEMENT__HAS_BODY = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Composite Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ELEMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.PackageImpl <em>Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.PackageImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getPackage()
	 * @generated
	 */
	int PACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__NAME = COMPOSITE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__BODY = COMPOSITE_ELEMENT__BODY;

	/**
	 * The feature id for the '<em><b>Has Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__HAS_BODY = COMPOSITE_ELEMENT__HAS_BODY;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__IMPORTS = COMPOSITE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FEATURE_COUNT = COMPOSITE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.InformationSystemImpl <em>Information System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.InformationSystemImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getInformationSystem()
	 * @generated
	 */
	int INFORMATION_SYSTEM = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION_SYSTEM__NAME = COMPOSITE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION_SYSTEM__BODY = COMPOSITE_ELEMENT__BODY;

	/**
	 * The feature id for the '<em><b>Has Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION_SYSTEM__HAS_BODY = COMPOSITE_ELEMENT__HAS_BODY;

	/**
	 * The number of structural features of the '<em>Information System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION_SYSTEM_FEATURE_COUNT = COMPOSITE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.ImportImpl <em>Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.ImportImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getImport()
	 * @generated
	 */
	int IMPORT = 2;

	/**
	 * The feature id for the '<em><b>Imported Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__IMPORTED_PACKAGE = 0;

	/**
	 * The number of structural features of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.ExpressionImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 32;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.TypeImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 4;

	/**
	 * The feature id for the '<em><b>Tail</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__TAIL = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referenced Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__REFERENCED_ELEMENT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.TypedElementImpl <em>Typed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.TypedElementImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getTypedElement()
	 * @generated
	 */
	int TYPED_ELEMENT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Typed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.VariableTypeElementImpl <em>Variable Type Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.VariableTypeElementImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getVariableTypeElement()
	 * @generated
	 */
	int VARIABLE_TYPE_ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE_ELEMENT__NAME = TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE_ELEMENT__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE_ELEMENT__VALUE = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Type Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_TYPE_ELEMENT_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.FeatureImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__NAME = TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.AttributeImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = VARIABLE_TYPE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__TYPE = VARIABLE_TYPE_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__VALUE = VARIABLE_TYPE_ELEMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Opposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__OPPOSITE = VARIABLE_TYPE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__CONSTRAINTS = VARIABLE_TYPE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = VARIABLE_TYPE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.ParameterImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = VARIABLE_TYPE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = VARIABLE_TYPE_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__VALUE = VARIABLE_TYPE_ELEMENT__VALUE;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = VARIABLE_TYPE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.VariableImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = VARIABLE_TYPE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__TYPE = VARIABLE_TYPE_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__VALUE = VARIABLE_TYPE_ELEMENT__VALUE;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = VARIABLE_TYPE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.ResourceImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NAME = TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.FunctionImpl <em>Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.FunctionImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getFunction()
	 * @generated
	 */
	int FUNCTION = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__PARAMETERS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__NATIVE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Generic Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__GENERIC_TYPE_PARAMETERS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.TypeSpecificationImpl <em>Type Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.TypeSpecificationImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getTypeSpecification()
	 * @generated
	 */
	int TYPE_SPECIFICATION = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SPECIFICATION__NAME = FUNCTION__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SPECIFICATION__PARAMETERS = FUNCTION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SPECIFICATION__NATIVE = FUNCTION__NATIVE;

	/**
	 * The feature id for the '<em><b>Generic Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SPECIFICATION__GENERIC_TYPE_PARAMETERS = FUNCTION__GENERIC_TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SPECIFICATION__SUPER_TYPES = FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SPECIFICATION__ABSTRACT = FUNCTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SPECIFICATION_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.PrimitiveImpl <em>Primitive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.PrimitiveImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getPrimitive()
	 * @generated
	 */
	int PRIMITIVE = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE__NAME = TYPE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE__PARAMETERS = TYPE_SPECIFICATION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE__NATIVE = TYPE_SPECIFICATION__NATIVE;

	/**
	 * The feature id for the '<em><b>Generic Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE__GENERIC_TYPE_PARAMETERS = TYPE_SPECIFICATION__GENERIC_TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE__SUPER_TYPES = TYPE_SPECIFICATION__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE__ABSTRACT = TYPE_SPECIFICATION__ABSTRACT;

	/**
	 * The number of structural features of the '<em>Primitive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_FEATURE_COUNT = TYPE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.ConstraintImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__NAME = TYPE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__PARAMETERS = TYPE_SPECIFICATION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__NATIVE = TYPE_SPECIFICATION__NATIVE;

	/**
	 * The feature id for the '<em><b>Generic Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__GENERIC_TYPE_PARAMETERS = TYPE_SPECIFICATION__GENERIC_TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__SUPER_TYPES = TYPE_SPECIFICATION__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__ABSTRACT = TYPE_SPECIFICATION__ABSTRACT;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = TYPE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.MethodImpl <em>Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.MethodImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getMethod()
	 * @generated
	 */
	int METHOD = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__NAME = FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__TYPE = FEATURE__TYPE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__PARAMETERS = FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__NATIVE = FEATURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Generic Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__GENERIC_TYPE_PARAMETERS = FEATURE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__BODY = FEATURE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Has Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__HAS_BODY = FEATURE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_FEATURE_COUNT = FEATURE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.CompositeTypeSpecificationImpl <em>Composite Type Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.CompositeTypeSpecificationImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getCompositeTypeSpecification()
	 * @generated
	 */
	int COMPOSITE_TYPE_SPECIFICATION = 73;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TYPE_SPECIFICATION__NAME = COMPOSITE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TYPE_SPECIFICATION__BODY = COMPOSITE_ELEMENT__BODY;

	/**
	 * The feature id for the '<em><b>Has Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TYPE_SPECIFICATION__HAS_BODY = COMPOSITE_ELEMENT__HAS_BODY;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TYPE_SPECIFICATION__PARAMETERS = COMPOSITE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TYPE_SPECIFICATION__NATIVE = COMPOSITE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Generic Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TYPE_SPECIFICATION__GENERIC_TYPE_PARAMETERS = COMPOSITE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TYPE_SPECIFICATION__SUPER_TYPES = COMPOSITE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TYPE_SPECIFICATION__ABSTRACT = COMPOSITE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Composite Type Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TYPE_SPECIFICATION_FEATURE_COUNT = COMPOSITE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.StructImpl <em>Struct</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.StructImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getStruct()
	 * @generated
	 */
	int STRUCT = 67;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT__NAME = COMPOSITE_TYPE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT__BODY = COMPOSITE_TYPE_SPECIFICATION__BODY;

	/**
	 * The feature id for the '<em><b>Has Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT__HAS_BODY = COMPOSITE_TYPE_SPECIFICATION__HAS_BODY;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT__PARAMETERS = COMPOSITE_TYPE_SPECIFICATION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT__NATIVE = COMPOSITE_TYPE_SPECIFICATION__NATIVE;

	/**
	 * The feature id for the '<em><b>Generic Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT__GENERIC_TYPE_PARAMETERS = COMPOSITE_TYPE_SPECIFICATION__GENERIC_TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT__SUPER_TYPES = COMPOSITE_TYPE_SPECIFICATION__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT__ABSTRACT = COMPOSITE_TYPE_SPECIFICATION__ABSTRACT;

	/**
	 * The number of structural features of the '<em>Struct</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT_FEATURE_COUNT = COMPOSITE_TYPE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.EntityImpl <em>Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.EntityImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getEntity()
	 * @generated
	 */
	int ENTITY = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__NAME = STRUCT__NAME;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__BODY = STRUCT__BODY;

	/**
	 * The feature id for the '<em><b>Has Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__HAS_BODY = STRUCT__HAS_BODY;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__PARAMETERS = STRUCT__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__NATIVE = STRUCT__NATIVE;

	/**
	 * The feature id for the '<em><b>Generic Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__GENERIC_TYPE_PARAMETERS = STRUCT__GENERIC_TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__SUPER_TYPES = STRUCT__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__ABSTRACT = STRUCT__ABSTRACT;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FEATURE_COUNT = STRUCT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.ActorImpl <em>Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.ActorImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getActor()
	 * @generated
	 */
	int ACTOR = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__NAME = ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__BODY = ENTITY__BODY;

	/**
	 * The feature id for the '<em><b>Has Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__HAS_BODY = ENTITY__HAS_BODY;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__PARAMETERS = ENTITY__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__NATIVE = ENTITY__NATIVE;

	/**
	 * The feature id for the '<em><b>Generic Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__GENERIC_TYPE_PARAMETERS = ENTITY__GENERIC_TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__SUPER_TYPES = ENTITY__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__ABSTRACT = ENTITY__ABSTRACT;

	/**
	 * The number of structural features of the '<em>Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.ControllerImpl <em>Controller</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.ControllerImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getController()
	 * @generated
	 */
	int CONTROLLER = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROLLER__NAME = COMPOSITE_TYPE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROLLER__BODY = COMPOSITE_TYPE_SPECIFICATION__BODY;

	/**
	 * The feature id for the '<em><b>Has Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROLLER__HAS_BODY = COMPOSITE_TYPE_SPECIFICATION__HAS_BODY;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROLLER__PARAMETERS = COMPOSITE_TYPE_SPECIFICATION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROLLER__NATIVE = COMPOSITE_TYPE_SPECIFICATION__NATIVE;

	/**
	 * The feature id for the '<em><b>Generic Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROLLER__GENERIC_TYPE_PARAMETERS = COMPOSITE_TYPE_SPECIFICATION__GENERIC_TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROLLER__SUPER_TYPES = COMPOSITE_TYPE_SPECIFICATION__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROLLER__ABSTRACT = COMPOSITE_TYPE_SPECIFICATION__ABSTRACT;

	/**
	 * The number of structural features of the '<em>Controller</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROLLER_FEATURE_COUNT = COMPOSITE_TYPE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.ViewImpl <em>View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.ViewImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getView()
	 * @generated
	 */
	int VIEW = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__NAME = COMPOSITE_TYPE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__BODY = COMPOSITE_TYPE_SPECIFICATION__BODY;

	/**
	 * The feature id for the '<em><b>Has Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__HAS_BODY = COMPOSITE_TYPE_SPECIFICATION__HAS_BODY;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__PARAMETERS = COMPOSITE_TYPE_SPECIFICATION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__NATIVE = COMPOSITE_TYPE_SPECIFICATION__NATIVE;

	/**
	 * The feature id for the '<em><b>Generic Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__GENERIC_TYPE_PARAMETERS = COMPOSITE_TYPE_SPECIFICATION__GENERIC_TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__SUPER_TYPES = COMPOSITE_TYPE_SPECIFICATION__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__ABSTRACT = COMPOSITE_TYPE_SPECIFICATION__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Controller</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__CONTROLLER = COMPOSITE_TYPE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_FEATURE_COUNT = COMPOSITE_TYPE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.StatementImpl <em>Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.StatementImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getStatement()
	 * @generated
	 */
	int STATEMENT = 21;

	/**
	 * The number of structural features of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.MethodStatementImpl <em>Method Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.MethodStatementImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getMethodStatement()
	 * @generated
	 */
	int METHOD_STATEMENT = 22;

	/**
	 * The number of structural features of the '<em>Method Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.CompositeViewStatementImpl <em>Composite View Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.CompositeViewStatementImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getCompositeViewStatement()
	 * @generated
	 */
	int COMPOSITE_VIEW_STATEMENT = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_VIEW_STATEMENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_VIEW_STATEMENT__BODY = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Has Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_VIEW_STATEMENT__HAS_BODY = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Composite View Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_VIEW_STATEMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.ForImpl <em>For</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.ForImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getFor()
	 * @generated
	 */
	int FOR = 24;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR__NAME = METHOD_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR__BODY = METHOD_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Has Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR__HAS_BODY = METHOD_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR__VARIABLE = METHOD_STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Collection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR__COLLECTION = METHOD_STATEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>For</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_FEATURE_COUNT = METHOD_STATEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.IterationImpl <em>Iteration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.IterationImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getIteration()
	 * @generated
	 */
	int ITERATION = 25;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__VARIABLE = 0;

	/**
	 * The feature id for the '<em><b>Collection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION__COLLECTION = 1;

	/**
	 * The number of structural features of the '<em>Iteration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.ForViewImpl <em>For View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.ForViewImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getForView()
	 * @generated
	 */
	int FOR_VIEW = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_VIEW__NAME = COMPOSITE_VIEW_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_VIEW__BODY = COMPOSITE_VIEW_STATEMENT__BODY;

	/**
	 * The feature id for the '<em><b>Has Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_VIEW__HAS_BODY = COMPOSITE_VIEW_STATEMENT__HAS_BODY;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_VIEW__VARIABLE = COMPOSITE_VIEW_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Collection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_VIEW__COLLECTION = COMPOSITE_VIEW_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>For View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_VIEW_FEATURE_COUNT = COMPOSITE_VIEW_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.ReferenceImpl <em>Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.ReferenceImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getReference()
	 * @generated
	 */
	int REFERENCE = 27;

	/**
	 * The feature id for the '<em><b>Tail</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__TAIL = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referenced Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__REFERENCED_ELEMENT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.CallerImpl <em>Caller</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.CallerImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getCaller()
	 * @generated
	 */
	int CALLER = 39;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLER__PARAMETERS = 0;

	/**
	 * The number of structural features of the '<em>Caller</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.ParameterizedReferenceImpl <em>Parameterized Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.ParameterizedReferenceImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getParameterizedReference()
	 * @generated
	 */
	int PARAMETERIZED_REFERENCE = 28;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_REFERENCE__PARAMETERS = CALLER__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Tail</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_REFERENCE__TAIL = CALLER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referenced Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_REFERENCE__REFERENCED_ELEMENT = CALLER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Parameterized Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_REFERENCE_FEATURE_COUNT = CALLER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.MethodCallImpl <em>Method Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.MethodCallImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getMethodCall()
	 * @generated
	 */
	int METHOD_CALL = 29;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL__PARAMETERS = PARAMETERIZED_REFERENCE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Tail</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL__TAIL = PARAMETERIZED_REFERENCE__TAIL;

	/**
	 * The feature id for the '<em><b>Referenced Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL__REFERENCED_ELEMENT = PARAMETERIZED_REFERENCE__REFERENCED_ELEMENT;

	/**
	 * The number of structural features of the '<em>Method Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL_FEATURE_COUNT = PARAMETERIZED_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.ActionCallImpl <em>Action Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.ActionCallImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getActionCall()
	 * @generated
	 */
	int ACTION_CALL = 30;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_CALL__PARAMETERS = PARAMETERIZED_REFERENCE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Tail</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_CALL__TAIL = PARAMETERIZED_REFERENCE__TAIL;

	/**
	 * The feature id for the '<em><b>Referenced Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_CALL__REFERENCED_ELEMENT = PARAMETERIZED_REFERENCE__REFERENCED_ELEMENT;

	/**
	 * The number of structural features of the '<em>Action Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_CALL_FEATURE_COUNT = PARAMETERIZED_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.VariableReferenceImpl <em>Variable Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.VariableReferenceImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getVariableReference()
	 * @generated
	 */
	int VARIABLE_REFERENCE = 31;

	/**
	 * The feature id for the '<em><b>Tail</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE__TAIL = REFERENCE__TAIL;

	/**
	 * The feature id for the '<em><b>Referenced Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE__REFERENCED_ELEMENT = REFERENCE__REFERENCED_ELEMENT;

	/**
	 * The number of structural features of the '<em>Variable Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE_FEATURE_COUNT = REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.ConditionalImpl <em>Conditional</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.ConditionalImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getConditional()
	 * @generated
	 */
	int CONDITIONAL = 35;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL__CONDITION = 0;

	/**
	 * The number of structural features of the '<em>Conditional</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.IfImpl <em>If</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.IfImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getIf()
	 * @generated
	 */
	int IF = 33;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__CONDITION = CONDITIONAL__CONDITION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__NAME = CONDITIONAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__BODY = CONDITIONAL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Has Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__HAS_BODY = CONDITIONAL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Else Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__ELSE_BODY = CONDITIONAL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>If</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_FEATURE_COUNT = CONDITIONAL_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.IfViewImpl <em>If View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.IfViewImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getIfView()
	 * @generated
	 */
	int IF_VIEW = 34;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_VIEW__CONDITION = CONDITIONAL__CONDITION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_VIEW__NAME = CONDITIONAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_VIEW__BODY = CONDITIONAL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Has Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_VIEW__HAS_BODY = CONDITIONAL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>If View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_VIEW_FEATURE_COUNT = CONDITIONAL_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.WhileImpl <em>While</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.WhileImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getWhile()
	 * @generated
	 */
	int WHILE = 36;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE__CONDITION = CONDITIONAL__CONDITION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE__NAME = CONDITIONAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE__BODY = CONDITIONAL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Has Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE__HAS_BODY = CONDITIONAL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>While</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_FEATURE_COUNT = CONDITIONAL_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.ReturnImpl <em>Return</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.ReturnImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getReturn()
	 * @generated
	 */
	int RETURN = 37;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN__EXPRESSION = METHOD_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Return</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_FEATURE_COUNT = METHOD_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.InstanceImpl <em>Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.InstanceImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getInstance()
	 * @generated
	 */
	int INSTANCE = 38;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE__PARAMETERS = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE__NAME = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE__TYPE = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.ViewInstanceImpl <em>View Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.ViewInstanceImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getViewInstance()
	 * @generated
	 */
	int VIEW_INSTANCE = 40;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_INSTANCE__PARAMETERS = INSTANCE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_INSTANCE__NAME = INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_INSTANCE__TYPE = INSTANCE__TYPE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_INSTANCE__BODY = INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Has Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_INSTANCE__HAS_BODY = INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Action Call</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_INSTANCE__ACTION_CALL = INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>View Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_INSTANCE_FEATURE_COUNT = INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.StructInstanceImpl <em>Struct Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.StructInstanceImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getStructInstance()
	 * @generated
	 */
	int STRUCT_INSTANCE = 41;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT_INSTANCE__PARAMETERS = INSTANCE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT_INSTANCE__NAME = INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT_INSTANCE__TYPE = INSTANCE__TYPE;

	/**
	 * The number of structural features of the '<em>Struct Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT_INSTANCE_FEATURE_COUNT = INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.ShowImpl <em>Show</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.ShowImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getShow()
	 * @generated
	 */
	int SHOW = 42;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW__EXPRESSION = METHOD_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Show</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHOW_FEATURE_COUNT = METHOD_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.OperatorImpl <em>Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.OperatorImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getOperator()
	 * @generated
	 */
	int OPERATOR = 43;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__SYMBOL = 0;

	/**
	 * The number of structural features of the '<em>Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.BinaryOperatorImpl <em>Binary Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.BinaryOperatorImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getBinaryOperator()
	 * @generated
	 */
	int BINARY_OPERATOR = 44;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR__SYMBOL = OPERATOR__SYMBOL;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR__LEFT = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR__RIGHT = OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binary Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.UnaryOperatorImpl <em>Unary Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.UnaryOperatorImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getUnaryOperator()
	 * @generated
	 */
	int UNARY_OPERATOR = 45;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR__SYMBOL = OPERATOR__SYMBOL;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR__EXPRESSION = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unary Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.AssignmentImpl <em>Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.AssignmentImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getAssignment()
	 * @generated
	 */
	int ASSIGNMENT = 46;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__SYMBOL = BINARY_OPERATOR__SYMBOL;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__LEFT = BINARY_OPERATOR__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__RIGHT = BINARY_OPERATOR__RIGHT;

	/**
	 * The number of structural features of the '<em>Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_FEATURE_COUNT = BINARY_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.WidgetImpl <em>Widget</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.WidgetImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getWidget()
	 * @generated
	 */
	int WIDGET = 47;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__NAME = VIEW__NAME;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__BODY = VIEW__BODY;

	/**
	 * The feature id for the '<em><b>Has Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__HAS_BODY = VIEW__HAS_BODY;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__PARAMETERS = VIEW__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__NATIVE = VIEW__NATIVE;

	/**
	 * The feature id for the '<em><b>Generic Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__GENERIC_TYPE_PARAMETERS = VIEW__GENERIC_TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__SUPER_TYPES = VIEW__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__ABSTRACT = VIEW__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Controller</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__CONTROLLER = VIEW__CONTROLLER;

	/**
	 * The number of structural features of the '<em>Widget</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_FEATURE_COUNT = VIEW_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.PageImpl <em>Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.PageImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getPage()
	 * @generated
	 */
	int PAGE = 48;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__NAME = VIEW__NAME;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__BODY = VIEW__BODY;

	/**
	 * The feature id for the '<em><b>Has Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__HAS_BODY = VIEW__HAS_BODY;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__PARAMETERS = VIEW__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__NATIVE = VIEW__NATIVE;

	/**
	 * The feature id for the '<em><b>Generic Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__GENERIC_TYPE_PARAMETERS = VIEW__GENERIC_TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__SUPER_TYPES = VIEW__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__ABSTRACT = VIEW__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Controller</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__CONTROLLER = VIEW__CONTROLLER;

	/**
	 * The number of structural features of the '<em>Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_FEATURE_COUNT = VIEW_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.ResourceBundleImpl <em>Resource Bundle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.ResourceBundleImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getResourceBundle()
	 * @generated
	 */
	int RESOURCE_BUNDLE = 49;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_BUNDLE__NAME = COMPOSITE_TYPE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_BUNDLE__BODY = COMPOSITE_TYPE_SPECIFICATION__BODY;

	/**
	 * The feature id for the '<em><b>Has Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_BUNDLE__HAS_BODY = COMPOSITE_TYPE_SPECIFICATION__HAS_BODY;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_BUNDLE__PARAMETERS = COMPOSITE_TYPE_SPECIFICATION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_BUNDLE__NATIVE = COMPOSITE_TYPE_SPECIFICATION__NATIVE;

	/**
	 * The feature id for the '<em><b>Generic Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_BUNDLE__GENERIC_TYPE_PARAMETERS = COMPOSITE_TYPE_SPECIFICATION__GENERIC_TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_BUNDLE__SUPER_TYPES = COMPOSITE_TYPE_SPECIFICATION__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_BUNDLE__ABSTRACT = COMPOSITE_TYPE_SPECIFICATION__ABSTRACT;

	/**
	 * The number of structural features of the '<em>Resource Bundle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_BUNDLE_FEATURE_COUNT = COMPOSITE_TYPE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.ConstraintInstanceImpl <em>Constraint Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.ConstraintInstanceImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getConstraintInstance()
	 * @generated
	 */
	int CONSTRAINT_INSTANCE = 50;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_INSTANCE__PARAMETERS = INSTANCE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_INSTANCE__NAME = INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_INSTANCE__TYPE = INSTANCE__TYPE;

	/**
	 * The number of structural features of the '<em>Constraint Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_INSTANCE_FEATURE_COUNT = INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.InterfaceImpl <em>Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.InterfaceImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getInterface()
	 * @generated
	 */
	int INTERFACE = 51;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__NAME = COMPOSITE_TYPE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__BODY = COMPOSITE_TYPE_SPECIFICATION__BODY;

	/**
	 * The feature id for the '<em><b>Has Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__HAS_BODY = COMPOSITE_TYPE_SPECIFICATION__HAS_BODY;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__PARAMETERS = COMPOSITE_TYPE_SPECIFICATION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__NATIVE = COMPOSITE_TYPE_SPECIFICATION__NATIVE;

	/**
	 * The feature id for the '<em><b>Generic Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__GENERIC_TYPE_PARAMETERS = COMPOSITE_TYPE_SPECIFICATION__GENERIC_TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__SUPER_TYPES = COMPOSITE_TYPE_SPECIFICATION__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__ABSTRACT = COMPOSITE_TYPE_SPECIFICATION__ABSTRACT;

	/**
	 * The number of structural features of the '<em>Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_FEATURE_COUNT = COMPOSITE_TYPE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.ServiceImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 52;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__NAME = INTERFACE__NAME;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__BODY = INTERFACE__BODY;

	/**
	 * The feature id for the '<em><b>Has Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__HAS_BODY = INTERFACE__HAS_BODY;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__PARAMETERS = INTERFACE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__NATIVE = INTERFACE__NATIVE;

	/**
	 * The feature id for the '<em><b>Generic Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__GENERIC_TYPE_PARAMETERS = INTERFACE__GENERIC_TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__SUPER_TYPES = INTERFACE__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__ABSTRACT = INTERFACE__ABSTRACT;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.ActionImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 53;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__NAME = FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__TYPE = FEATURE__TYPE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__PARAMETERS = FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__NATIVE = FEATURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Generic Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__GENERIC_TYPE_PARAMETERS = FEATURE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__BODY = FEATURE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Has Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__HAS_BODY = FEATURE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__DEFAULT = FEATURE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = FEATURE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.LiteralValueImpl <em>Literal Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.LiteralValueImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getLiteralValue()
	 * @generated
	 */
	int LITERAL_VALUE = 54;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_VALUE__LITERAL = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Literal Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_VALUE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.IntValueImpl <em>Int Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.IntValueImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getIntValue()
	 * @generated
	 */
	int INT_VALUE = 55;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_VALUE__LITERAL = LITERAL_VALUE__LITERAL;

	/**
	 * The number of structural features of the '<em>Int Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_VALUE_FEATURE_COUNT = LITERAL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.FloatValueImpl <em>Float Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.FloatValueImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getFloatValue()
	 * @generated
	 */
	int FLOAT_VALUE = 56;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_VALUE__LITERAL = LITERAL_VALUE__LITERAL;

	/**
	 * The number of structural features of the '<em>Float Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOAT_VALUE_FEATURE_COUNT = LITERAL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.BoolValueImpl <em>Bool Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.BoolValueImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getBoolValue()
	 * @generated
	 */
	int BOOL_VALUE = 57;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_VALUE__LITERAL = LITERAL_VALUE__LITERAL;

	/**
	 * The number of structural features of the '<em>Bool Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_VALUE_FEATURE_COUNT = LITERAL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.StringValueImpl <em>String Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.StringValueImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getStringValue()
	 * @generated
	 */
	int STRING_VALUE = 58;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE__LITERAL = LITERAL_VALUE__LITERAL;

	/**
	 * The number of structural features of the '<em>String Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_FEATURE_COUNT = LITERAL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.NullValueImpl <em>Null Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.NullValueImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getNullValue()
	 * @generated
	 */
	int NULL_VALUE = 59;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_VALUE__LITERAL = LITERAL_VALUE__LITERAL;

	/**
	 * The number of structural features of the '<em>Null Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_VALUE_FEATURE_COUNT = LITERAL_VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.ResourceReferenceImpl <em>Resource Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.ResourceReferenceImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getResourceReference()
	 * @generated
	 */
	int RESOURCE_REFERENCE = 60;

	/**
	 * The feature id for the '<em><b>Tail</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REFERENCE__TAIL = REFERENCE__TAIL;

	/**
	 * The feature id for the '<em><b>Referenced Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REFERENCE__REFERENCED_ELEMENT = REFERENCE__REFERENCED_ELEMENT;

	/**
	 * The number of structural features of the '<em>Resource Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_REFERENCE_FEATURE_COUNT = REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.GenericTypeSpecificationImpl <em>Generic Type Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.GenericTypeSpecificationImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getGenericTypeSpecification()
	 * @generated
	 */
	int GENERIC_TYPE_SPECIFICATION = 61;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE_SPECIFICATION__NAME = TYPE_SPECIFICATION__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE_SPECIFICATION__PARAMETERS = TYPE_SPECIFICATION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE_SPECIFICATION__NATIVE = TYPE_SPECIFICATION__NATIVE;

	/**
	 * The feature id for the '<em><b>Generic Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE_SPECIFICATION__GENERIC_TYPE_PARAMETERS = TYPE_SPECIFICATION__GENERIC_TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE_SPECIFICATION__SUPER_TYPES = TYPE_SPECIFICATION__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE_SPECIFICATION__ABSTRACT = TYPE_SPECIFICATION__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Super Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE_SPECIFICATION__SUPER_TYPE = TYPE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Generic Type Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_TYPE_SPECIFICATION_FEATURE_COUNT = TYPE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.ParameterizedTypeImpl <em>Parameterized Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.ParameterizedTypeImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getParameterizedType()
	 * @generated
	 */
	int PARAMETERIZED_TYPE = 62;

	/**
	 * The feature id for the '<em><b>Tail</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE__TAIL = TYPE__TAIL;

	/**
	 * The feature id for the '<em><b>Referenced Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE__REFERENCED_ELEMENT = TYPE__REFERENCED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE__TYPE_PARAMETERS = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameterized Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.EnumImpl <em>Enum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.EnumImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getEnum()
	 * @generated
	 */
	int ENUM = 63;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM__NAME = STRUCT__NAME;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM__BODY = STRUCT__BODY;

	/**
	 * The feature id for the '<em><b>Has Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM__HAS_BODY = STRUCT__HAS_BODY;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM__PARAMETERS = STRUCT__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM__NATIVE = STRUCT__NATIVE;

	/**
	 * The feature id for the '<em><b>Generic Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM__GENERIC_TYPE_PARAMETERS = STRUCT__GENERIC_TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM__SUPER_TYPES = STRUCT__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM__ABSTRACT = STRUCT__ABSTRACT;

	/**
	 * The number of structural features of the '<em>Enum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_FEATURE_COUNT = STRUCT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.EnumItemImpl <em>Enum Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.EnumItemImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getEnumItem()
	 * @generated
	 */
	int ENUM_ITEM = 64;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_ITEM__NAME = FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_ITEM__TYPE = FEATURE__TYPE;

	/**
	 * The number of structural features of the '<em>Enum Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_ITEM_FEATURE_COUNT = FEATURE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.ResourceAssignmentImpl <em>Resource Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.ResourceAssignmentImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getResourceAssignment()
	 * @generated
	 */
	int RESOURCE_ASSIGNMENT = 65;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ASSIGNMENT__SYMBOL = ASSIGNMENT__SYMBOL;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ASSIGNMENT__LEFT = ASSIGNMENT__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ASSIGNMENT__RIGHT = ASSIGNMENT__RIGHT;

	/**
	 * The number of structural features of the '<em>Resource Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_ASSIGNMENT_FEATURE_COUNT = ASSIGNMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.DTOImpl <em>DTO</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.DTOImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getDTO()
	 * @generated
	 */
	int DTO = 66;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO__NAME = STRUCT__NAME;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO__BODY = STRUCT__BODY;

	/**
	 * The feature id for the '<em><b>Has Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO__HAS_BODY = STRUCT__HAS_BODY;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO__PARAMETERS = STRUCT__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO__NATIVE = STRUCT__NATIVE;

	/**
	 * The feature id for the '<em><b>Generic Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO__GENERIC_TYPE_PARAMETERS = STRUCT__GENERIC_TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO__SUPER_TYPES = STRUCT__SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO__ABSTRACT = STRUCT__ABSTRACT;

	/**
	 * The number of structural features of the '<em>DTO</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DTO_FEATURE_COUNT = STRUCT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.NamedViewBlockImpl <em>Named View Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.NamedViewBlockImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getNamedViewBlock()
	 * @generated
	 */
	int NAMED_VIEW_BLOCK = 68;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_VIEW_BLOCK__NAME = COMPOSITE_VIEW_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_VIEW_BLOCK__BODY = COMPOSITE_VIEW_STATEMENT__BODY;

	/**
	 * The feature id for the '<em><b>Has Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_VIEW_BLOCK__HAS_BODY = COMPOSITE_VIEW_STATEMENT__HAS_BODY;

	/**
	 * The number of structural features of the '<em>Named View Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_VIEW_BLOCK_FEATURE_COUNT = COMPOSITE_VIEW_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.CompositeMethodStatementImpl <em>Composite Method Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.CompositeMethodStatementImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getCompositeMethodStatement()
	 * @generated
	 */
	int COMPOSITE_METHOD_STATEMENT = 69;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_METHOD_STATEMENT__NAME = METHOD_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_METHOD_STATEMENT__BODY = METHOD_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Has Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_METHOD_STATEMENT__HAS_BODY = METHOD_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Composite Method Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_METHOD_STATEMENT_FEATURE_COUNT = METHOD_STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link co.edu.javeriana.isml.isml.impl.ViewStatementImpl <em>View Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see co.edu.javeriana.isml.isml.impl.ViewStatementImpl
	 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getViewStatement()
	 * @generated
	 */
	int VIEW_STATEMENT = 71;

	/**
	 * The number of structural features of the '<em>View Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Package <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package</em>'.
	 * @see co.edu.javeriana.isml.isml.Package
	 * @generated
	 */
	EClass getPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link co.edu.javeriana.isml.isml.Package#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see co.edu.javeriana.isml.isml.Package#getImports()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_Imports();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.InformationSystem <em>Information System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Information System</em>'.
	 * @see co.edu.javeriana.isml.isml.InformationSystem
	 * @generated
	 */
	EClass getInformationSystem();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Import <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import</em>'.
	 * @see co.edu.javeriana.isml.isml.Import
	 * @generated
	 */
	EClass getImport();

	/**
	 * Returns the meta object for the reference '{@link co.edu.javeriana.isml.isml.Import#getImportedPackage <em>Imported Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Imported Package</em>'.
	 * @see co.edu.javeriana.isml.isml.Import#getImportedPackage()
	 * @see #getImport()
	 * @generated
	 */
	EReference getImport_ImportedPackage();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see co.edu.javeriana.isml.isml.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link co.edu.javeriana.isml.isml.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see co.edu.javeriana.isml.isml.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see co.edu.javeriana.isml.isml.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Element</em>'.
	 * @see co.edu.javeriana.isml.isml.TypedElement
	 * @generated
	 */
	EClass getTypedElement();

	/**
	 * Returns the meta object for the containment reference '{@link co.edu.javeriana.isml.isml.TypedElement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see co.edu.javeriana.isml.isml.TypedElement#getType()
	 * @see #getTypedElement()
	 * @generated
	 */
	EReference getTypedElement_Type();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.VariableTypeElement <em>Variable Type Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Type Element</em>'.
	 * @see co.edu.javeriana.isml.isml.VariableTypeElement
	 * @generated
	 */
	EClass getVariableTypeElement();

	/**
	 * Returns the meta object for the containment reference '{@link co.edu.javeriana.isml.isml.VariableTypeElement#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see co.edu.javeriana.isml.isml.VariableTypeElement#getValue()
	 * @see #getVariableTypeElement()
	 * @generated
	 */
	EReference getVariableTypeElement_Value();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see co.edu.javeriana.isml.isml.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see co.edu.javeriana.isml.isml.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the reference '{@link co.edu.javeriana.isml.isml.Attribute#getOpposite <em>Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Opposite</em>'.
	 * @see co.edu.javeriana.isml.isml.Attribute#getOpposite()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_Opposite();

	/**
	 * Returns the meta object for the containment reference list '{@link co.edu.javeriana.isml.isml.Attribute#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see co.edu.javeriana.isml.isml.Attribute#getConstraints()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_Constraints();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see co.edu.javeriana.isml.isml.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see co.edu.javeriana.isml.isml.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see co.edu.javeriana.isml.isml.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.TypeSpecification <em>Type Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Specification</em>'.
	 * @see co.edu.javeriana.isml.isml.TypeSpecification
	 * @generated
	 */
	EClass getTypeSpecification();

	/**
	 * Returns the meta object for the containment reference list '{@link co.edu.javeriana.isml.isml.TypeSpecification#getSuperTypes <em>Super Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Super Types</em>'.
	 * @see co.edu.javeriana.isml.isml.TypeSpecification#getSuperTypes()
	 * @see #getTypeSpecification()
	 * @generated
	 */
	EReference getTypeSpecification_SuperTypes();

	/**
	 * Returns the meta object for the attribute '{@link co.edu.javeriana.isml.isml.TypeSpecification#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see co.edu.javeriana.isml.isml.TypeSpecification#isAbstract()
	 * @see #getTypeSpecification()
	 * @generated
	 */
	EAttribute getTypeSpecification_Abstract();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Primitive <em>Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive</em>'.
	 * @see co.edu.javeriana.isml.isml.Primitive
	 * @generated
	 */
	EClass getPrimitive();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see co.edu.javeriana.isml.isml.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function</em>'.
	 * @see co.edu.javeriana.isml.isml.Function
	 * @generated
	 */
	EClass getFunction();

	/**
	 * Returns the meta object for the containment reference list '{@link co.edu.javeriana.isml.isml.Function#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see co.edu.javeriana.isml.isml.Function#getParameters()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Parameters();

	/**
	 * Returns the meta object for the attribute '{@link co.edu.javeriana.isml.isml.Function#isNative <em>Native</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Native</em>'.
	 * @see co.edu.javeriana.isml.isml.Function#isNative()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_Native();

	/**
	 * Returns the meta object for the containment reference list '{@link co.edu.javeriana.isml.isml.Function#getGenericTypeParameters <em>Generic Type Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Generic Type Parameters</em>'.
	 * @see co.edu.javeriana.isml.isml.Function#getGenericTypeParameters()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_GenericTypeParameters();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Method <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method</em>'.
	 * @see co.edu.javeriana.isml.isml.Method
	 * @generated
	 */
	EClass getMethod();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see co.edu.javeriana.isml.isml.Entity
	 * @generated
	 */
	EClass getEntity();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Actor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor</em>'.
	 * @see co.edu.javeriana.isml.isml.Actor
	 * @generated
	 */
	EClass getActor();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Controller <em>Controller</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Controller</em>'.
	 * @see co.edu.javeriana.isml.isml.Controller
	 * @generated
	 */
	EClass getController();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.View <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View</em>'.
	 * @see co.edu.javeriana.isml.isml.View
	 * @generated
	 */
	EClass getView();

	/**
	 * Returns the meta object for the reference '{@link co.edu.javeriana.isml.isml.View#getController <em>Controller</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Controller</em>'.
	 * @see co.edu.javeriana.isml.isml.View#getController()
	 * @see #getView()
	 * @generated
	 */
	EReference getView_Controller();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement</em>'.
	 * @see co.edu.javeriana.isml.isml.Statement
	 * @generated
	 */
	EClass getStatement();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.MethodStatement <em>Method Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method Statement</em>'.
	 * @see co.edu.javeriana.isml.isml.MethodStatement
	 * @generated
	 */
	EClass getMethodStatement();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.CompositeViewStatement <em>Composite View Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite View Statement</em>'.
	 * @see co.edu.javeriana.isml.isml.CompositeViewStatement
	 * @generated
	 */
	EClass getCompositeViewStatement();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.For <em>For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For</em>'.
	 * @see co.edu.javeriana.isml.isml.For
	 * @generated
	 */
	EClass getFor();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Iteration <em>Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iteration</em>'.
	 * @see co.edu.javeriana.isml.isml.Iteration
	 * @generated
	 */
	EClass getIteration();

	/**
	 * Returns the meta object for the containment reference '{@link co.edu.javeriana.isml.isml.Iteration#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable</em>'.
	 * @see co.edu.javeriana.isml.isml.Iteration#getVariable()
	 * @see #getIteration()
	 * @generated
	 */
	EReference getIteration_Variable();

	/**
	 * Returns the meta object for the containment reference '{@link co.edu.javeriana.isml.isml.Iteration#getCollection <em>Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Collection</em>'.
	 * @see co.edu.javeriana.isml.isml.Iteration#getCollection()
	 * @see #getIteration()
	 * @generated
	 */
	EReference getIteration_Collection();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.ForView <em>For View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For View</em>'.
	 * @see co.edu.javeriana.isml.isml.ForView
	 * @generated
	 */
	EClass getForView();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference</em>'.
	 * @see co.edu.javeriana.isml.isml.Reference
	 * @generated
	 */
	EClass getReference();

	/**
	 * Returns the meta object for the containment reference '{@link co.edu.javeriana.isml.isml.Reference#getTail <em>Tail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Tail</em>'.
	 * @see co.edu.javeriana.isml.isml.Reference#getTail()
	 * @see #getReference()
	 * @generated
	 */
	EReference getReference_Tail();

	/**
	 * Returns the meta object for the reference '{@link co.edu.javeriana.isml.isml.Reference#getReferencedElement <em>Referenced Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referenced Element</em>'.
	 * @see co.edu.javeriana.isml.isml.Reference#getReferencedElement()
	 * @see #getReference()
	 * @generated
	 */
	EReference getReference_ReferencedElement();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.ParameterizedReference <em>Parameterized Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameterized Reference</em>'.
	 * @see co.edu.javeriana.isml.isml.ParameterizedReference
	 * @generated
	 */
	EClass getParameterizedReference();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.MethodCall <em>Method Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method Call</em>'.
	 * @see co.edu.javeriana.isml.isml.MethodCall
	 * @generated
	 */
	EClass getMethodCall();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.ActionCall <em>Action Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Call</em>'.
	 * @see co.edu.javeriana.isml.isml.ActionCall
	 * @generated
	 */
	EClass getActionCall();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.VariableReference <em>Variable Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Reference</em>'.
	 * @see co.edu.javeriana.isml.isml.VariableReference
	 * @generated
	 */
	EClass getVariableReference();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see co.edu.javeriana.isml.isml.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.If <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If</em>'.
	 * @see co.edu.javeriana.isml.isml.If
	 * @generated
	 */
	EClass getIf();

	/**
	 * Returns the meta object for the containment reference list '{@link co.edu.javeriana.isml.isml.If#getElseBody <em>Else Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Else Body</em>'.
	 * @see co.edu.javeriana.isml.isml.If#getElseBody()
	 * @see #getIf()
	 * @generated
	 */
	EReference getIf_ElseBody();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.IfView <em>If View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If View</em>'.
	 * @see co.edu.javeriana.isml.isml.IfView
	 * @generated
	 */
	EClass getIfView();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Conditional <em>Conditional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conditional</em>'.
	 * @see co.edu.javeriana.isml.isml.Conditional
	 * @generated
	 */
	EClass getConditional();

	/**
	 * Returns the meta object for the containment reference '{@link co.edu.javeriana.isml.isml.Conditional#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see co.edu.javeriana.isml.isml.Conditional#getCondition()
	 * @see #getConditional()
	 * @generated
	 */
	EReference getConditional_Condition();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.While <em>While</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>While</em>'.
	 * @see co.edu.javeriana.isml.isml.While
	 * @generated
	 */
	EClass getWhile();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Return <em>Return</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Return</em>'.
	 * @see co.edu.javeriana.isml.isml.Return
	 * @generated
	 */
	EClass getReturn();

	/**
	 * Returns the meta object for the containment reference '{@link co.edu.javeriana.isml.isml.Return#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see co.edu.javeriana.isml.isml.Return#getExpression()
	 * @see #getReturn()
	 * @generated
	 */
	EReference getReturn_Expression();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Instance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance</em>'.
	 * @see co.edu.javeriana.isml.isml.Instance
	 * @generated
	 */
	EClass getInstance();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Caller <em>Caller</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Caller</em>'.
	 * @see co.edu.javeriana.isml.isml.Caller
	 * @generated
	 */
	EClass getCaller();

	/**
	 * Returns the meta object for the containment reference list '{@link co.edu.javeriana.isml.isml.Caller#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see co.edu.javeriana.isml.isml.Caller#getParameters()
	 * @see #getCaller()
	 * @generated
	 */
	EReference getCaller_Parameters();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.ViewInstance <em>View Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View Instance</em>'.
	 * @see co.edu.javeriana.isml.isml.ViewInstance
	 * @generated
	 */
	EClass getViewInstance();

	/**
	 * Returns the meta object for the containment reference '{@link co.edu.javeriana.isml.isml.ViewInstance#getActionCall <em>Action Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Action Call</em>'.
	 * @see co.edu.javeriana.isml.isml.ViewInstance#getActionCall()
	 * @see #getViewInstance()
	 * @generated
	 */
	EReference getViewInstance_ActionCall();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.StructInstance <em>Struct Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Struct Instance</em>'.
	 * @see co.edu.javeriana.isml.isml.StructInstance
	 * @generated
	 */
	EClass getStructInstance();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Show <em>Show</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Show</em>'.
	 * @see co.edu.javeriana.isml.isml.Show
	 * @generated
	 */
	EClass getShow();

	/**
	 * Returns the meta object for the containment reference '{@link co.edu.javeriana.isml.isml.Show#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see co.edu.javeriana.isml.isml.Show#getExpression()
	 * @see #getShow()
	 * @generated
	 */
	EReference getShow_Expression();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator</em>'.
	 * @see co.edu.javeriana.isml.isml.Operator
	 * @generated
	 */
	EClass getOperator();

	/**
	 * Returns the meta object for the attribute '{@link co.edu.javeriana.isml.isml.Operator#getSymbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbol</em>'.
	 * @see co.edu.javeriana.isml.isml.Operator#getSymbol()
	 * @see #getOperator()
	 * @generated
	 */
	EAttribute getOperator_Symbol();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.BinaryOperator <em>Binary Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Operator</em>'.
	 * @see co.edu.javeriana.isml.isml.BinaryOperator
	 * @generated
	 */
	EClass getBinaryOperator();

	/**
	 * Returns the meta object for the containment reference '{@link co.edu.javeriana.isml.isml.BinaryOperator#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see co.edu.javeriana.isml.isml.BinaryOperator#getLeft()
	 * @see #getBinaryOperator()
	 * @generated
	 */
	EReference getBinaryOperator_Left();

	/**
	 * Returns the meta object for the containment reference '{@link co.edu.javeriana.isml.isml.BinaryOperator#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see co.edu.javeriana.isml.isml.BinaryOperator#getRight()
	 * @see #getBinaryOperator()
	 * @generated
	 */
	EReference getBinaryOperator_Right();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.UnaryOperator <em>Unary Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Operator</em>'.
	 * @see co.edu.javeriana.isml.isml.UnaryOperator
	 * @generated
	 */
	EClass getUnaryOperator();

	/**
	 * Returns the meta object for the containment reference '{@link co.edu.javeriana.isml.isml.UnaryOperator#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see co.edu.javeriana.isml.isml.UnaryOperator#getExpression()
	 * @see #getUnaryOperator()
	 * @generated
	 */
	EReference getUnaryOperator_Expression();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment</em>'.
	 * @see co.edu.javeriana.isml.isml.Assignment
	 * @generated
	 */
	EClass getAssignment();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Widget <em>Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Widget</em>'.
	 * @see co.edu.javeriana.isml.isml.Widget
	 * @generated
	 */
	EClass getWidget();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Page <em>Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page</em>'.
	 * @see co.edu.javeriana.isml.isml.Page
	 * @generated
	 */
	EClass getPage();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.ResourceBundle <em>Resource Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Bundle</em>'.
	 * @see co.edu.javeriana.isml.isml.ResourceBundle
	 * @generated
	 */
	EClass getResourceBundle();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.ConstraintInstance <em>Constraint Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint Instance</em>'.
	 * @see co.edu.javeriana.isml.isml.ConstraintInstance
	 * @generated
	 */
	EClass getConstraintInstance();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Interface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface</em>'.
	 * @see co.edu.javeriana.isml.isml.Interface
	 * @generated
	 */
	EClass getInterface();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see co.edu.javeriana.isml.isml.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see co.edu.javeriana.isml.isml.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for the attribute '{@link co.edu.javeriana.isml.isml.Action#isDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see co.edu.javeriana.isml.isml.Action#isDefault()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_Default();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.LiteralValue <em>Literal Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Value</em>'.
	 * @see co.edu.javeriana.isml.isml.LiteralValue
	 * @generated
	 */
	EClass getLiteralValue();

	/**
	 * Returns the meta object for the attribute '{@link co.edu.javeriana.isml.isml.LiteralValue#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Literal</em>'.
	 * @see co.edu.javeriana.isml.isml.LiteralValue#getLiteral()
	 * @see #getLiteralValue()
	 * @generated
	 */
	EAttribute getLiteralValue_Literal();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.IntValue <em>Int Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Value</em>'.
	 * @see co.edu.javeriana.isml.isml.IntValue
	 * @generated
	 */
	EClass getIntValue();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.FloatValue <em>Float Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Float Value</em>'.
	 * @see co.edu.javeriana.isml.isml.FloatValue
	 * @generated
	 */
	EClass getFloatValue();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.BoolValue <em>Bool Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bool Value</em>'.
	 * @see co.edu.javeriana.isml.isml.BoolValue
	 * @generated
	 */
	EClass getBoolValue();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.StringValue <em>String Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Value</em>'.
	 * @see co.edu.javeriana.isml.isml.StringValue
	 * @generated
	 */
	EClass getStringValue();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.NullValue <em>Null Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Null Value</em>'.
	 * @see co.edu.javeriana.isml.isml.NullValue
	 * @generated
	 */
	EClass getNullValue();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.ResourceReference <em>Resource Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Reference</em>'.
	 * @see co.edu.javeriana.isml.isml.ResourceReference
	 * @generated
	 */
	EClass getResourceReference();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.GenericTypeSpecification <em>Generic Type Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generic Type Specification</em>'.
	 * @see co.edu.javeriana.isml.isml.GenericTypeSpecification
	 * @generated
	 */
	EClass getGenericTypeSpecification();

	/**
	 * Returns the meta object for the containment reference '{@link co.edu.javeriana.isml.isml.GenericTypeSpecification#getSuperType <em>Super Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Super Type</em>'.
	 * @see co.edu.javeriana.isml.isml.GenericTypeSpecification#getSuperType()
	 * @see #getGenericTypeSpecification()
	 * @generated
	 */
	EReference getGenericTypeSpecification_SuperType();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.ParameterizedType <em>Parameterized Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameterized Type</em>'.
	 * @see co.edu.javeriana.isml.isml.ParameterizedType
	 * @generated
	 */
	EClass getParameterizedType();

	/**
	 * Returns the meta object for the containment reference list '{@link co.edu.javeriana.isml.isml.ParameterizedType#getTypeParameters <em>Type Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Parameters</em>'.
	 * @see co.edu.javeriana.isml.isml.ParameterizedType#getTypeParameters()
	 * @see #getParameterizedType()
	 * @generated
	 */
	EReference getParameterizedType_TypeParameters();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Enum <em>Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum</em>'.
	 * @see co.edu.javeriana.isml.isml.Enum
	 * @generated
	 */
	EClass getEnum();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.EnumItem <em>Enum Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Item</em>'.
	 * @see co.edu.javeriana.isml.isml.EnumItem
	 * @generated
	 */
	EClass getEnumItem();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.ResourceAssignment <em>Resource Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Assignment</em>'.
	 * @see co.edu.javeriana.isml.isml.ResourceAssignment
	 * @generated
	 */
	EClass getResourceAssignment();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.DTO <em>DTO</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DTO</em>'.
	 * @see co.edu.javeriana.isml.isml.DTO
	 * @generated
	 */
	EClass getDTO();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Struct <em>Struct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Struct</em>'.
	 * @see co.edu.javeriana.isml.isml.Struct
	 * @generated
	 */
	EClass getStruct();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.NamedViewBlock <em>Named View Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named View Block</em>'.
	 * @see co.edu.javeriana.isml.isml.NamedViewBlock
	 * @generated
	 */
	EClass getNamedViewBlock();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.CompositeMethodStatement <em>Composite Method Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Method Statement</em>'.
	 * @see co.edu.javeriana.isml.isml.CompositeMethodStatement
	 * @generated
	 */
	EClass getCompositeMethodStatement();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.CompositeElement <em>Composite Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Element</em>'.
	 * @see co.edu.javeriana.isml.isml.CompositeElement
	 * @generated
	 */
	EClass getCompositeElement();

	/**
	 * Returns the meta object for the containment reference list '{@link co.edu.javeriana.isml.isml.CompositeElement#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Body</em>'.
	 * @see co.edu.javeriana.isml.isml.CompositeElement#getBody()
	 * @see #getCompositeElement()
	 * @generated
	 */
	EReference getCompositeElement_Body();

	/**
	 * Returns the meta object for the attribute '{@link co.edu.javeriana.isml.isml.CompositeElement#isHasBody <em>Has Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Body</em>'.
	 * @see co.edu.javeriana.isml.isml.CompositeElement#isHasBody()
	 * @see #getCompositeElement()
	 * @generated
	 */
	EAttribute getCompositeElement_HasBody();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.ViewStatement <em>View Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View Statement</em>'.
	 * @see co.edu.javeriana.isml.isml.ViewStatement
	 * @generated
	 */
	EClass getViewStatement();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see co.edu.javeriana.isml.isml.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for class '{@link co.edu.javeriana.isml.isml.CompositeTypeSpecification <em>Composite Type Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Type Specification</em>'.
	 * @see co.edu.javeriana.isml.isml.CompositeTypeSpecification
	 * @generated
	 */
	EClass getCompositeTypeSpecification();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	IsmlFactory getIsmlFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.PackageImpl <em>Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.PackageImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getPackage()
		 * @generated
		 */
		EClass PACKAGE = eINSTANCE.getPackage();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__IMPORTS = eINSTANCE.getPackage_Imports();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.InformationSystemImpl <em>Information System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.InformationSystemImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getInformationSystem()
		 * @generated
		 */
		EClass INFORMATION_SYSTEM = eINSTANCE.getInformationSystem();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.ImportImpl <em>Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.ImportImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getImport()
		 * @generated
		 */
		EClass IMPORT = eINSTANCE.getImport();

		/**
		 * The meta object literal for the '<em><b>Imported Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORT__IMPORTED_PACKAGE = eINSTANCE.getImport_ImportedPackage();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.NamedElementImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.TypeImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.TypedElementImpl <em>Typed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.TypedElementImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getTypedElement()
		 * @generated
		 */
		EClass TYPED_ELEMENT = eINSTANCE.getTypedElement();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_ELEMENT__TYPE = eINSTANCE.getTypedElement_Type();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.VariableTypeElementImpl <em>Variable Type Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.VariableTypeElementImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getVariableTypeElement()
		 * @generated
		 */
		EClass VARIABLE_TYPE_ELEMENT = eINSTANCE.getVariableTypeElement();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_TYPE_ELEMENT__VALUE = eINSTANCE.getVariableTypeElement_Value();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.FeatureImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.AttributeImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Opposite</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__OPPOSITE = eINSTANCE.getAttribute_Opposite();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__CONSTRAINTS = eINSTANCE.getAttribute_Constraints();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.ParameterImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.VariableImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.ResourceImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.TypeSpecificationImpl <em>Type Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.TypeSpecificationImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getTypeSpecification()
		 * @generated
		 */
		EClass TYPE_SPECIFICATION = eINSTANCE.getTypeSpecification();

		/**
		 * The meta object literal for the '<em><b>Super Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_SPECIFICATION__SUPER_TYPES = eINSTANCE.getTypeSpecification_SuperTypes();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_SPECIFICATION__ABSTRACT = eINSTANCE.getTypeSpecification_Abstract();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.PrimitiveImpl <em>Primitive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.PrimitiveImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getPrimitive()
		 * @generated
		 */
		EClass PRIMITIVE = eINSTANCE.getPrimitive();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.ConstraintImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.FunctionImpl <em>Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.FunctionImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getFunction()
		 * @generated
		 */
		EClass FUNCTION = eINSTANCE.getFunction();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__PARAMETERS = eINSTANCE.getFunction_Parameters();

		/**
		 * The meta object literal for the '<em><b>Native</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__NATIVE = eINSTANCE.getFunction_Native();

		/**
		 * The meta object literal for the '<em><b>Generic Type Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__GENERIC_TYPE_PARAMETERS = eINSTANCE.getFunction_GenericTypeParameters();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.MethodImpl <em>Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.MethodImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getMethod()
		 * @generated
		 */
		EClass METHOD = eINSTANCE.getMethod();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.EntityImpl <em>Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.EntityImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.ActorImpl <em>Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.ActorImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getActor()
		 * @generated
		 */
		EClass ACTOR = eINSTANCE.getActor();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.ControllerImpl <em>Controller</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.ControllerImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getController()
		 * @generated
		 */
		EClass CONTROLLER = eINSTANCE.getController();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.ViewImpl <em>View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.ViewImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getView()
		 * @generated
		 */
		EClass VIEW = eINSTANCE.getView();

		/**
		 * The meta object literal for the '<em><b>Controller</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW__CONTROLLER = eINSTANCE.getView_Controller();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.StatementImpl <em>Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.StatementImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getStatement()
		 * @generated
		 */
		EClass STATEMENT = eINSTANCE.getStatement();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.MethodStatementImpl <em>Method Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.MethodStatementImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getMethodStatement()
		 * @generated
		 */
		EClass METHOD_STATEMENT = eINSTANCE.getMethodStatement();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.CompositeViewStatementImpl <em>Composite View Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.CompositeViewStatementImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getCompositeViewStatement()
		 * @generated
		 */
		EClass COMPOSITE_VIEW_STATEMENT = eINSTANCE.getCompositeViewStatement();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.ForImpl <em>For</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.ForImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getFor()
		 * @generated
		 */
		EClass FOR = eINSTANCE.getFor();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.IterationImpl <em>Iteration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.IterationImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getIteration()
		 * @generated
		 */
		EClass ITERATION = eINSTANCE.getIteration();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATION__VARIABLE = eINSTANCE.getIteration_Variable();

		/**
		 * The meta object literal for the '<em><b>Collection</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATION__COLLECTION = eINSTANCE.getIteration_Collection();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.ForViewImpl <em>For View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.ForViewImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getForView()
		 * @generated
		 */
		EClass FOR_VIEW = eINSTANCE.getForView();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.ReferenceImpl <em>Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.ReferenceImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getReference()
		 * @generated
		 */
		EClass REFERENCE = eINSTANCE.getReference();

		/**
		 * The meta object literal for the '<em><b>Tail</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE__TAIL = eINSTANCE.getReference_Tail();

		/**
		 * The meta object literal for the '<em><b>Referenced Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE__REFERENCED_ELEMENT = eINSTANCE.getReference_ReferencedElement();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.ParameterizedReferenceImpl <em>Parameterized Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.ParameterizedReferenceImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getParameterizedReference()
		 * @generated
		 */
		EClass PARAMETERIZED_REFERENCE = eINSTANCE.getParameterizedReference();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.MethodCallImpl <em>Method Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.MethodCallImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getMethodCall()
		 * @generated
		 */
		EClass METHOD_CALL = eINSTANCE.getMethodCall();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.ActionCallImpl <em>Action Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.ActionCallImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getActionCall()
		 * @generated
		 */
		EClass ACTION_CALL = eINSTANCE.getActionCall();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.VariableReferenceImpl <em>Variable Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.VariableReferenceImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getVariableReference()
		 * @generated
		 */
		EClass VARIABLE_REFERENCE = eINSTANCE.getVariableReference();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.ExpressionImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.IfImpl <em>If</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.IfImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getIf()
		 * @generated
		 */
		EClass IF = eINSTANCE.getIf();

		/**
		 * The meta object literal for the '<em><b>Else Body</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF__ELSE_BODY = eINSTANCE.getIf_ElseBody();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.IfViewImpl <em>If View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.IfViewImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getIfView()
		 * @generated
		 */
		EClass IF_VIEW = eINSTANCE.getIfView();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.ConditionalImpl <em>Conditional</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.ConditionalImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getConditional()
		 * @generated
		 */
		EClass CONDITIONAL = eINSTANCE.getConditional();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL__CONDITION = eINSTANCE.getConditional_Condition();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.WhileImpl <em>While</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.WhileImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getWhile()
		 * @generated
		 */
		EClass WHILE = eINSTANCE.getWhile();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.ReturnImpl <em>Return</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.ReturnImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getReturn()
		 * @generated
		 */
		EClass RETURN = eINSTANCE.getReturn();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RETURN__EXPRESSION = eINSTANCE.getReturn_Expression();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.InstanceImpl <em>Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.InstanceImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getInstance()
		 * @generated
		 */
		EClass INSTANCE = eINSTANCE.getInstance();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.CallerImpl <em>Caller</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.CallerImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getCaller()
		 * @generated
		 */
		EClass CALLER = eINSTANCE.getCaller();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALLER__PARAMETERS = eINSTANCE.getCaller_Parameters();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.ViewInstanceImpl <em>View Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.ViewInstanceImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getViewInstance()
		 * @generated
		 */
		EClass VIEW_INSTANCE = eINSTANCE.getViewInstance();

		/**
		 * The meta object literal for the '<em><b>Action Call</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW_INSTANCE__ACTION_CALL = eINSTANCE.getViewInstance_ActionCall();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.StructInstanceImpl <em>Struct Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.StructInstanceImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getStructInstance()
		 * @generated
		 */
		EClass STRUCT_INSTANCE = eINSTANCE.getStructInstance();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.ShowImpl <em>Show</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.ShowImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getShow()
		 * @generated
		 */
		EClass SHOW = eINSTANCE.getShow();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHOW__EXPRESSION = eINSTANCE.getShow_Expression();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.OperatorImpl <em>Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.OperatorImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getOperator()
		 * @generated
		 */
		EClass OPERATOR = eINSTANCE.getOperator();

		/**
		 * The meta object literal for the '<em><b>Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATOR__SYMBOL = eINSTANCE.getOperator_Symbol();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.BinaryOperatorImpl <em>Binary Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.BinaryOperatorImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getBinaryOperator()
		 * @generated
		 */
		EClass BINARY_OPERATOR = eINSTANCE.getBinaryOperator();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_OPERATOR__LEFT = eINSTANCE.getBinaryOperator_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_OPERATOR__RIGHT = eINSTANCE.getBinaryOperator_Right();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.UnaryOperatorImpl <em>Unary Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.UnaryOperatorImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getUnaryOperator()
		 * @generated
		 */
		EClass UNARY_OPERATOR = eINSTANCE.getUnaryOperator();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_OPERATOR__EXPRESSION = eINSTANCE.getUnaryOperator_Expression();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.AssignmentImpl <em>Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.AssignmentImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getAssignment()
		 * @generated
		 */
		EClass ASSIGNMENT = eINSTANCE.getAssignment();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.WidgetImpl <em>Widget</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.WidgetImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getWidget()
		 * @generated
		 */
		EClass WIDGET = eINSTANCE.getWidget();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.PageImpl <em>Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.PageImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getPage()
		 * @generated
		 */
		EClass PAGE = eINSTANCE.getPage();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.ResourceBundleImpl <em>Resource Bundle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.ResourceBundleImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getResourceBundle()
		 * @generated
		 */
		EClass RESOURCE_BUNDLE = eINSTANCE.getResourceBundle();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.ConstraintInstanceImpl <em>Constraint Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.ConstraintInstanceImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getConstraintInstance()
		 * @generated
		 */
		EClass CONSTRAINT_INSTANCE = eINSTANCE.getConstraintInstance();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.InterfaceImpl <em>Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.InterfaceImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getInterface()
		 * @generated
		 */
		EClass INTERFACE = eINSTANCE.getInterface();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.ServiceImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getService()
		 * @generated
		 */
		EClass SERVICE = eINSTANCE.getService();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.ActionImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__DEFAULT = eINSTANCE.getAction_Default();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.LiteralValueImpl <em>Literal Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.LiteralValueImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getLiteralValue()
		 * @generated
		 */
		EClass LITERAL_VALUE = eINSTANCE.getLiteralValue();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_VALUE__LITERAL = eINSTANCE.getLiteralValue_Literal();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.IntValueImpl <em>Int Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.IntValueImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getIntValue()
		 * @generated
		 */
		EClass INT_VALUE = eINSTANCE.getIntValue();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.FloatValueImpl <em>Float Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.FloatValueImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getFloatValue()
		 * @generated
		 */
		EClass FLOAT_VALUE = eINSTANCE.getFloatValue();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.BoolValueImpl <em>Bool Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.BoolValueImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getBoolValue()
		 * @generated
		 */
		EClass BOOL_VALUE = eINSTANCE.getBoolValue();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.StringValueImpl <em>String Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.StringValueImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getStringValue()
		 * @generated
		 */
		EClass STRING_VALUE = eINSTANCE.getStringValue();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.NullValueImpl <em>Null Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.NullValueImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getNullValue()
		 * @generated
		 */
		EClass NULL_VALUE = eINSTANCE.getNullValue();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.ResourceReferenceImpl <em>Resource Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.ResourceReferenceImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getResourceReference()
		 * @generated
		 */
		EClass RESOURCE_REFERENCE = eINSTANCE.getResourceReference();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.GenericTypeSpecificationImpl <em>Generic Type Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.GenericTypeSpecificationImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getGenericTypeSpecification()
		 * @generated
		 */
		EClass GENERIC_TYPE_SPECIFICATION = eINSTANCE.getGenericTypeSpecification();

		/**
		 * The meta object literal for the '<em><b>Super Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERIC_TYPE_SPECIFICATION__SUPER_TYPE = eINSTANCE.getGenericTypeSpecification_SuperType();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.ParameterizedTypeImpl <em>Parameterized Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.ParameterizedTypeImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getParameterizedType()
		 * @generated
		 */
		EClass PARAMETERIZED_TYPE = eINSTANCE.getParameterizedType();

		/**
		 * The meta object literal for the '<em><b>Type Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETERIZED_TYPE__TYPE_PARAMETERS = eINSTANCE.getParameterizedType_TypeParameters();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.EnumImpl <em>Enum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.EnumImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getEnum()
		 * @generated
		 */
		EClass ENUM = eINSTANCE.getEnum();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.EnumItemImpl <em>Enum Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.EnumItemImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getEnumItem()
		 * @generated
		 */
		EClass ENUM_ITEM = eINSTANCE.getEnumItem();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.ResourceAssignmentImpl <em>Resource Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.ResourceAssignmentImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getResourceAssignment()
		 * @generated
		 */
		EClass RESOURCE_ASSIGNMENT = eINSTANCE.getResourceAssignment();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.DTOImpl <em>DTO</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.DTOImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getDTO()
		 * @generated
		 */
		EClass DTO = eINSTANCE.getDTO();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.StructImpl <em>Struct</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.StructImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getStruct()
		 * @generated
		 */
		EClass STRUCT = eINSTANCE.getStruct();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.NamedViewBlockImpl <em>Named View Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.NamedViewBlockImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getNamedViewBlock()
		 * @generated
		 */
		EClass NAMED_VIEW_BLOCK = eINSTANCE.getNamedViewBlock();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.CompositeMethodStatementImpl <em>Composite Method Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.CompositeMethodStatementImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getCompositeMethodStatement()
		 * @generated
		 */
		EClass COMPOSITE_METHOD_STATEMENT = eINSTANCE.getCompositeMethodStatement();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.CompositeElementImpl <em>Composite Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.CompositeElementImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getCompositeElement()
		 * @generated
		 */
		EClass COMPOSITE_ELEMENT = eINSTANCE.getCompositeElement();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_ELEMENT__BODY = eINSTANCE.getCompositeElement_Body();

		/**
		 * The meta object literal for the '<em><b>Has Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITE_ELEMENT__HAS_BODY = eINSTANCE.getCompositeElement_HasBody();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.ViewStatementImpl <em>View Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.ViewStatementImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getViewStatement()
		 * @generated
		 */
		EClass VIEW_STATEMENT = eINSTANCE.getViewStatement();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.ElementImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '{@link co.edu.javeriana.isml.isml.impl.CompositeTypeSpecificationImpl <em>Composite Type Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see co.edu.javeriana.isml.isml.impl.CompositeTypeSpecificationImpl
		 * @see co.edu.javeriana.isml.isml.impl.IsmlPackageImpl#getCompositeTypeSpecification()
		 * @generated
		 */
		EClass COMPOSITE_TYPE_SPECIFICATION = eINSTANCE.getCompositeTypeSpecification();

	}

} //IsmlPackage
