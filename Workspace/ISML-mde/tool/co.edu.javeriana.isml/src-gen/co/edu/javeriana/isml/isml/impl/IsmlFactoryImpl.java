/**
 */
package co.edu.javeriana.isml.isml.impl;

import co.edu.javeriana.isml.isml.Action;
import co.edu.javeriana.isml.isml.ActionCall;
import co.edu.javeriana.isml.isml.Actor;
import co.edu.javeriana.isml.isml.Assignment;
import co.edu.javeriana.isml.isml.Attribute;
import co.edu.javeriana.isml.isml.BinaryOperator;
import co.edu.javeriana.isml.isml.BoolValue;
import co.edu.javeriana.isml.isml.Constraint;
import co.edu.javeriana.isml.isml.ConstraintInstance;
import co.edu.javeriana.isml.isml.Controller;
import co.edu.javeriana.isml.isml.DTO;
import co.edu.javeriana.isml.isml.Entity;
import co.edu.javeriana.isml.isml.EnumItem;
import co.edu.javeriana.isml.isml.FloatValue;
import co.edu.javeriana.isml.isml.For;
import co.edu.javeriana.isml.isml.ForView;
import co.edu.javeriana.isml.isml.GenericTypeSpecification;
import co.edu.javeriana.isml.isml.If;
import co.edu.javeriana.isml.isml.IfView;
import co.edu.javeriana.isml.isml.Import;
import co.edu.javeriana.isml.isml.InformationSystem;
import co.edu.javeriana.isml.isml.IntValue;
import co.edu.javeriana.isml.isml.Interface;
import co.edu.javeriana.isml.isml.IsmlFactory;
import co.edu.javeriana.isml.isml.IsmlPackage;
import co.edu.javeriana.isml.isml.LiteralValue;
import co.edu.javeriana.isml.isml.Method;
import co.edu.javeriana.isml.isml.MethodCall;
import co.edu.javeriana.isml.isml.NamedViewBlock;
import co.edu.javeriana.isml.isml.NullValue;
import co.edu.javeriana.isml.isml.Page;
import co.edu.javeriana.isml.isml.Parameter;
import co.edu.javeriana.isml.isml.ParameterizedType;
import co.edu.javeriana.isml.isml.Primitive;
import co.edu.javeriana.isml.isml.Resource;
import co.edu.javeriana.isml.isml.ResourceAssignment;
import co.edu.javeriana.isml.isml.ResourceBundle;
import co.edu.javeriana.isml.isml.ResourceReference;
import co.edu.javeriana.isml.isml.Return;
import co.edu.javeriana.isml.isml.Service;
import co.edu.javeriana.isml.isml.Show;
import co.edu.javeriana.isml.isml.StringValue;
import co.edu.javeriana.isml.isml.StructInstance;
import co.edu.javeriana.isml.isml.Type;
import co.edu.javeriana.isml.isml.TypedElement;
import co.edu.javeriana.isml.isml.UnaryOperator;
import co.edu.javeriana.isml.isml.Variable;
import co.edu.javeriana.isml.isml.VariableReference;
import co.edu.javeriana.isml.isml.ViewInstance;
import co.edu.javeriana.isml.isml.While;
import co.edu.javeriana.isml.isml.Widget;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IsmlFactoryImpl extends EFactoryImpl implements IsmlFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IsmlFactory init()
	{
		try
		{
			IsmlFactory theIsmlFactory = (IsmlFactory)EPackage.Registry.INSTANCE.getEFactory(IsmlPackage.eNS_URI);
			if (theIsmlFactory != null)
			{
				return theIsmlFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new IsmlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsmlFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case IsmlPackage.PACKAGE: return createPackage();
			case IsmlPackage.INFORMATION_SYSTEM: return createInformationSystem();
			case IsmlPackage.IMPORT: return createImport();
			case IsmlPackage.TYPE: return createType();
			case IsmlPackage.TYPED_ELEMENT: return createTypedElement();
			case IsmlPackage.ATTRIBUTE: return createAttribute();
			case IsmlPackage.PARAMETER: return createParameter();
			case IsmlPackage.VARIABLE: return createVariable();
			case IsmlPackage.RESOURCE: return createResource();
			case IsmlPackage.PRIMITIVE: return createPrimitive();
			case IsmlPackage.CONSTRAINT: return createConstraint();
			case IsmlPackage.METHOD: return createMethod();
			case IsmlPackage.ENTITY: return createEntity();
			case IsmlPackage.ACTOR: return createActor();
			case IsmlPackage.CONTROLLER: return createController();
			case IsmlPackage.FOR: return createFor();
			case IsmlPackage.FOR_VIEW: return createForView();
			case IsmlPackage.METHOD_CALL: return createMethodCall();
			case IsmlPackage.ACTION_CALL: return createActionCall();
			case IsmlPackage.VARIABLE_REFERENCE: return createVariableReference();
			case IsmlPackage.IF: return createIf();
			case IsmlPackage.IF_VIEW: return createIfView();
			case IsmlPackage.WHILE: return createWhile();
			case IsmlPackage.RETURN: return createReturn();
			case IsmlPackage.VIEW_INSTANCE: return createViewInstance();
			case IsmlPackage.STRUCT_INSTANCE: return createStructInstance();
			case IsmlPackage.SHOW: return createShow();
			case IsmlPackage.BINARY_OPERATOR: return createBinaryOperator();
			case IsmlPackage.UNARY_OPERATOR: return createUnaryOperator();
			case IsmlPackage.ASSIGNMENT: return createAssignment();
			case IsmlPackage.WIDGET: return createWidget();
			case IsmlPackage.PAGE: return createPage();
			case IsmlPackage.RESOURCE_BUNDLE: return createResourceBundle();
			case IsmlPackage.CONSTRAINT_INSTANCE: return createConstraintInstance();
			case IsmlPackage.INTERFACE: return createInterface();
			case IsmlPackage.SERVICE: return createService();
			case IsmlPackage.ACTION: return createAction();
			case IsmlPackage.LITERAL_VALUE: return createLiteralValue();
			case IsmlPackage.INT_VALUE: return createIntValue();
			case IsmlPackage.FLOAT_VALUE: return createFloatValue();
			case IsmlPackage.BOOL_VALUE: return createBoolValue();
			case IsmlPackage.STRING_VALUE: return createStringValue();
			case IsmlPackage.NULL_VALUE: return createNullValue();
			case IsmlPackage.RESOURCE_REFERENCE: return createResourceReference();
			case IsmlPackage.GENERIC_TYPE_SPECIFICATION: return createGenericTypeSpecification();
			case IsmlPackage.PARAMETERIZED_TYPE: return createParameterizedType();
			case IsmlPackage.ENUM: return createEnum();
			case IsmlPackage.ENUM_ITEM: return createEnumItem();
			case IsmlPackage.RESOURCE_ASSIGNMENT: return createResourceAssignment();
			case IsmlPackage.DTO: return createDTO();
			case IsmlPackage.NAMED_VIEW_BLOCK: return createNamedViewBlock();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public co.edu.javeriana.isml.isml.Package createPackage()
	{
		PackageImpl package_ = new PackageImpl();
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InformationSystem createInformationSystem()
	{
		InformationSystemImpl informationSystem = new InformationSystemImpl();
		return informationSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Import createImport()
	{
		ImportImpl import_ = new ImportImpl();
		return import_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type createType()
	{
		TypeImpl type = new TypeImpl();
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedElement createTypedElement()
	{
		TypedElementImpl typedElement = new TypedElementImpl();
		return typedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute createAttribute()
	{
		AttributeImpl attribute = new AttributeImpl();
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter()
	{
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable createVariable()
	{
		VariableImpl variable = new VariableImpl();
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource createResource()
	{
		ResourceImpl resource = new ResourceImpl();
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Primitive createPrimitive()
	{
		PrimitiveImpl primitive = new PrimitiveImpl();
		return primitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint createConstraint()
	{
		ConstraintImpl constraint = new ConstraintImpl();
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Method createMethod()
	{
		MethodImpl method = new MethodImpl();
		return method;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity createEntity()
	{
		EntityImpl entity = new EntityImpl();
		return entity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor createActor()
	{
		ActorImpl actor = new ActorImpl();
		return actor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Controller createController()
	{
		ControllerImpl controller = new ControllerImpl();
		return controller;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public For createFor()
	{
		ForImpl for_ = new ForImpl();
		return for_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForView createForView()
	{
		ForViewImpl forView = new ForViewImpl();
		return forView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodCall createMethodCall()
	{
		MethodCallImpl methodCall = new MethodCallImpl();
		return methodCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionCall createActionCall()
	{
		ActionCallImpl actionCall = new ActionCallImpl();
		return actionCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableReference createVariableReference()
	{
		VariableReferenceImpl variableReference = new VariableReferenceImpl();
		return variableReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public If createIf()
	{
		IfImpl if_ = new IfImpl();
		return if_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfView createIfView()
	{
		IfViewImpl ifView = new IfViewImpl();
		return ifView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public While createWhile()
	{
		WhileImpl while_ = new WhileImpl();
		return while_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Return createReturn()
	{
		ReturnImpl return_ = new ReturnImpl();
		return return_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewInstance createViewInstance()
	{
		ViewInstanceImpl viewInstance = new ViewInstanceImpl();
		return viewInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructInstance createStructInstance()
	{
		StructInstanceImpl structInstance = new StructInstanceImpl();
		return structInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Show createShow()
	{
		ShowImpl show = new ShowImpl();
		return show;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryOperator createBinaryOperator()
	{
		BinaryOperatorImpl binaryOperator = new BinaryOperatorImpl();
		return binaryOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryOperator createUnaryOperator()
	{
		UnaryOperatorImpl unaryOperator = new UnaryOperatorImpl();
		return unaryOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assignment createAssignment()
	{
		AssignmentImpl assignment = new AssignmentImpl();
		return assignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Widget createWidget()
	{
		WidgetImpl widget = new WidgetImpl();
		return widget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Page createPage()
	{
		PageImpl page = new PageImpl();
		return page;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceBundle createResourceBundle()
	{
		ResourceBundleImpl resourceBundle = new ResourceBundleImpl();
		return resourceBundle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintInstance createConstraintInstance()
	{
		ConstraintInstanceImpl constraintInstance = new ConstraintInstanceImpl();
		return constraintInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface createInterface()
	{
		InterfaceImpl interface_ = new InterfaceImpl();
		return interface_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Service createService()
	{
		ServiceImpl service = new ServiceImpl();
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action createAction()
	{
		ActionImpl action = new ActionImpl();
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralValue createLiteralValue()
	{
		LiteralValueImpl literalValue = new LiteralValueImpl();
		return literalValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntValue createIntValue()
	{
		IntValueImpl intValue = new IntValueImpl();
		return intValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FloatValue createFloatValue()
	{
		FloatValueImpl floatValue = new FloatValueImpl();
		return floatValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoolValue createBoolValue()
	{
		BoolValueImpl boolValue = new BoolValueImpl();
		return boolValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringValue createStringValue()
	{
		StringValueImpl stringValue = new StringValueImpl();
		return stringValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NullValue createNullValue()
	{
		NullValueImpl nullValue = new NullValueImpl();
		return nullValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceReference createResourceReference()
	{
		ResourceReferenceImpl resourceReference = new ResourceReferenceImpl();
		return resourceReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericTypeSpecification createGenericTypeSpecification()
	{
		GenericTypeSpecificationImpl genericTypeSpecification = new GenericTypeSpecificationImpl();
		return genericTypeSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterizedType createParameterizedType()
	{
		ParameterizedTypeImpl parameterizedType = new ParameterizedTypeImpl();
		return parameterizedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public co.edu.javeriana.isml.isml.Enum createEnum()
	{
		EnumImpl enum_ = new EnumImpl();
		return enum_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumItem createEnumItem()
	{
		EnumItemImpl enumItem = new EnumItemImpl();
		return enumItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceAssignment createResourceAssignment()
	{
		ResourceAssignmentImpl resourceAssignment = new ResourceAssignmentImpl();
		return resourceAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DTO createDTO()
	{
		DTOImpl dto = new DTOImpl();
		return dto;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedViewBlock createNamedViewBlock()
	{
		NamedViewBlockImpl namedViewBlock = new NamedViewBlockImpl();
		return namedViewBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsmlPackage getIsmlPackage()
	{
		return (IsmlPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static IsmlPackage getPackage()
	{
		return IsmlPackage.eINSTANCE;
	}

} //IsmlFactoryImpl
