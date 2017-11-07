/**
 */
package co.edu.javeriana.isml.isml.util;

import co.edu.javeriana.isml.isml.Action;
import co.edu.javeriana.isml.isml.ActionCall;
import co.edu.javeriana.isml.isml.Actor;
import co.edu.javeriana.isml.isml.Assignment;
import co.edu.javeriana.isml.isml.Attribute;
import co.edu.javeriana.isml.isml.BinaryOperator;
import co.edu.javeriana.isml.isml.BoolValue;
import co.edu.javeriana.isml.isml.Caller;
import co.edu.javeriana.isml.isml.CompositeElement;
import co.edu.javeriana.isml.isml.CompositeMethodStatement;
import co.edu.javeriana.isml.isml.CompositeTypeSpecification;
import co.edu.javeriana.isml.isml.CompositeViewStatement;
import co.edu.javeriana.isml.isml.Conditional;
import co.edu.javeriana.isml.isml.Constraint;
import co.edu.javeriana.isml.isml.ConstraintInstance;
import co.edu.javeriana.isml.isml.Controller;
import co.edu.javeriana.isml.isml.DTO;
import co.edu.javeriana.isml.isml.Element;
import co.edu.javeriana.isml.isml.Entity;
import co.edu.javeriana.isml.isml.EnumItem;
import co.edu.javeriana.isml.isml.Expression;
import co.edu.javeriana.isml.isml.Feature;
import co.edu.javeriana.isml.isml.FloatValue;
import co.edu.javeriana.isml.isml.For;
import co.edu.javeriana.isml.isml.ForView;
import co.edu.javeriana.isml.isml.Function;
import co.edu.javeriana.isml.isml.GenericTypeSpecification;
import co.edu.javeriana.isml.isml.If;
import co.edu.javeriana.isml.isml.IfView;
import co.edu.javeriana.isml.isml.Import;
import co.edu.javeriana.isml.isml.InformationSystem;
import co.edu.javeriana.isml.isml.Instance;
import co.edu.javeriana.isml.isml.IntValue;
import co.edu.javeriana.isml.isml.Interface;
import co.edu.javeriana.isml.isml.IsmlPackage;
import co.edu.javeriana.isml.isml.Iteration;
import co.edu.javeriana.isml.isml.LiteralValue;
import co.edu.javeriana.isml.isml.Method;
import co.edu.javeriana.isml.isml.MethodCall;
import co.edu.javeriana.isml.isml.MethodStatement;
import co.edu.javeriana.isml.isml.NamedElement;
import co.edu.javeriana.isml.isml.NamedViewBlock;
import co.edu.javeriana.isml.isml.NullValue;
import co.edu.javeriana.isml.isml.Operator;
import co.edu.javeriana.isml.isml.Page;
import co.edu.javeriana.isml.isml.Parameter;
import co.edu.javeriana.isml.isml.ParameterizedReference;
import co.edu.javeriana.isml.isml.ParameterizedType;
import co.edu.javeriana.isml.isml.Primitive;
import co.edu.javeriana.isml.isml.Reference;
import co.edu.javeriana.isml.isml.Resource;
import co.edu.javeriana.isml.isml.ResourceAssignment;
import co.edu.javeriana.isml.isml.ResourceBundle;
import co.edu.javeriana.isml.isml.ResourceReference;
import co.edu.javeriana.isml.isml.Return;
import co.edu.javeriana.isml.isml.Service;
import co.edu.javeriana.isml.isml.Show;
import co.edu.javeriana.isml.isml.Statement;
import co.edu.javeriana.isml.isml.StringValue;
import co.edu.javeriana.isml.isml.Struct;
import co.edu.javeriana.isml.isml.StructInstance;
import co.edu.javeriana.isml.isml.Type;
import co.edu.javeriana.isml.isml.TypeSpecification;
import co.edu.javeriana.isml.isml.TypedElement;
import co.edu.javeriana.isml.isml.UnaryOperator;
import co.edu.javeriana.isml.isml.Variable;
import co.edu.javeriana.isml.isml.VariableReference;
import co.edu.javeriana.isml.isml.VariableTypeElement;
import co.edu.javeriana.isml.isml.View;
import co.edu.javeriana.isml.isml.ViewInstance;
import co.edu.javeriana.isml.isml.ViewStatement;
import co.edu.javeriana.isml.isml.While;
import co.edu.javeriana.isml.isml.Widget;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see co.edu.javeriana.isml.isml.IsmlPackage
 * @generated
 */
public class IsmlAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static IsmlPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsmlAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = IsmlPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object)
	{
		if (object == modelPackage)
		{
			return true;
		}
		if (object instanceof EObject)
		{
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IsmlSwitch<Adapter> modelSwitch =
		new IsmlSwitch<Adapter>()
		{
			@Override
			public Adapter casePackage(co.edu.javeriana.isml.isml.Package object)
			{
				return createPackageAdapter();
			}
			@Override
			public Adapter caseInformationSystem(InformationSystem object)
			{
				return createInformationSystemAdapter();
			}
			@Override
			public Adapter caseImport(Import object)
			{
				return createImportAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object)
			{
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseType(Type object)
			{
				return createTypeAdapter();
			}
			@Override
			public Adapter caseTypedElement(TypedElement object)
			{
				return createTypedElementAdapter();
			}
			@Override
			public Adapter caseVariableTypeElement(VariableTypeElement object)
			{
				return createVariableTypeElementAdapter();
			}
			@Override
			public Adapter caseFeature(Feature object)
			{
				return createFeatureAdapter();
			}
			@Override
			public Adapter caseAttribute(Attribute object)
			{
				return createAttributeAdapter();
			}
			@Override
			public Adapter caseParameter(Parameter object)
			{
				return createParameterAdapter();
			}
			@Override
			public Adapter caseVariable(Variable object)
			{
				return createVariableAdapter();
			}
			@Override
			public Adapter caseResource(Resource object)
			{
				return createResourceAdapter();
			}
			@Override
			public Adapter caseTypeSpecification(TypeSpecification object)
			{
				return createTypeSpecificationAdapter();
			}
			@Override
			public Adapter casePrimitive(Primitive object)
			{
				return createPrimitiveAdapter();
			}
			@Override
			public Adapter caseConstraint(Constraint object)
			{
				return createConstraintAdapter();
			}
			@Override
			public Adapter caseFunction(Function object)
			{
				return createFunctionAdapter();
			}
			@Override
			public Adapter caseMethod(Method object)
			{
				return createMethodAdapter();
			}
			@Override
			public Adapter caseEntity(Entity object)
			{
				return createEntityAdapter();
			}
			@Override
			public Adapter caseActor(Actor object)
			{
				return createActorAdapter();
			}
			@Override
			public Adapter caseController(Controller object)
			{
				return createControllerAdapter();
			}
			@Override
			public Adapter caseView(View object)
			{
				return createViewAdapter();
			}
			@Override
			public Adapter caseStatement(Statement object)
			{
				return createStatementAdapter();
			}
			@Override
			public Adapter caseMethodStatement(MethodStatement object)
			{
				return createMethodStatementAdapter();
			}
			@Override
			public Adapter caseCompositeViewStatement(CompositeViewStatement object)
			{
				return createCompositeViewStatementAdapter();
			}
			@Override
			public Adapter caseFor(For object)
			{
				return createForAdapter();
			}
			@Override
			public Adapter caseIteration(Iteration object)
			{
				return createIterationAdapter();
			}
			@Override
			public Adapter caseForView(ForView object)
			{
				return createForViewAdapter();
			}
			@Override
			public <T extends NamedElement> Adapter caseReference(Reference<T> object)
			{
				return createReferenceAdapter();
			}
			@Override
			public <T extends NamedElement> Adapter caseParameterizedReference(ParameterizedReference<T> object)
			{
				return createParameterizedReferenceAdapter();
			}
			@Override
			public Adapter caseMethodCall(MethodCall object)
			{
				return createMethodCallAdapter();
			}
			@Override
			public Adapter caseActionCall(ActionCall object)
			{
				return createActionCallAdapter();
			}
			@Override
			public Adapter caseVariableReference(VariableReference object)
			{
				return createVariableReferenceAdapter();
			}
			@Override
			public Adapter caseExpression(Expression object)
			{
				return createExpressionAdapter();
			}
			@Override
			public Adapter caseIf(If object)
			{
				return createIfAdapter();
			}
			@Override
			public Adapter caseIfView(IfView object)
			{
				return createIfViewAdapter();
			}
			@Override
			public Adapter caseConditional(Conditional object)
			{
				return createConditionalAdapter();
			}
			@Override
			public Adapter caseWhile(While object)
			{
				return createWhileAdapter();
			}
			@Override
			public Adapter caseReturn(Return object)
			{
				return createReturnAdapter();
			}
			@Override
			public Adapter caseInstance(Instance object)
			{
				return createInstanceAdapter();
			}
			@Override
			public Adapter caseCaller(Caller object)
			{
				return createCallerAdapter();
			}
			@Override
			public Adapter caseViewInstance(ViewInstance object)
			{
				return createViewInstanceAdapter();
			}
			@Override
			public Adapter caseStructInstance(StructInstance object)
			{
				return createStructInstanceAdapter();
			}
			@Override
			public Adapter caseShow(Show object)
			{
				return createShowAdapter();
			}
			@Override
			public Adapter caseOperator(Operator object)
			{
				return createOperatorAdapter();
			}
			@Override
			public Adapter caseBinaryOperator(BinaryOperator object)
			{
				return createBinaryOperatorAdapter();
			}
			@Override
			public Adapter caseUnaryOperator(UnaryOperator object)
			{
				return createUnaryOperatorAdapter();
			}
			@Override
			public Adapter caseAssignment(Assignment object)
			{
				return createAssignmentAdapter();
			}
			@Override
			public Adapter caseWidget(Widget object)
			{
				return createWidgetAdapter();
			}
			@Override
			public Adapter casePage(Page object)
			{
				return createPageAdapter();
			}
			@Override
			public Adapter caseResourceBundle(ResourceBundle object)
			{
				return createResourceBundleAdapter();
			}
			@Override
			public Adapter caseConstraintInstance(ConstraintInstance object)
			{
				return createConstraintInstanceAdapter();
			}
			@Override
			public Adapter caseInterface(Interface object)
			{
				return createInterfaceAdapter();
			}
			@Override
			public Adapter caseService(Service object)
			{
				return createServiceAdapter();
			}
			@Override
			public Adapter caseAction(Action object)
			{
				return createActionAdapter();
			}
			@Override
			public Adapter caseLiteralValue(LiteralValue object)
			{
				return createLiteralValueAdapter();
			}
			@Override
			public Adapter caseIntValue(IntValue object)
			{
				return createIntValueAdapter();
			}
			@Override
			public Adapter caseFloatValue(FloatValue object)
			{
				return createFloatValueAdapter();
			}
			@Override
			public Adapter caseBoolValue(BoolValue object)
			{
				return createBoolValueAdapter();
			}
			@Override
			public Adapter caseStringValue(StringValue object)
			{
				return createStringValueAdapter();
			}
			@Override
			public Adapter caseNullValue(NullValue object)
			{
				return createNullValueAdapter();
			}
			@Override
			public Adapter caseResourceReference(ResourceReference object)
			{
				return createResourceReferenceAdapter();
			}
			@Override
			public Adapter caseGenericTypeSpecification(GenericTypeSpecification object)
			{
				return createGenericTypeSpecificationAdapter();
			}
			@Override
			public Adapter caseParameterizedType(ParameterizedType object)
			{
				return createParameterizedTypeAdapter();
			}
			@Override
			public Adapter caseEnum(co.edu.javeriana.isml.isml.Enum object)
			{
				return createEnumAdapter();
			}
			@Override
			public Adapter caseEnumItem(EnumItem object)
			{
				return createEnumItemAdapter();
			}
			@Override
			public Adapter caseResourceAssignment(ResourceAssignment object)
			{
				return createResourceAssignmentAdapter();
			}
			@Override
			public Adapter caseDTO(DTO object)
			{
				return createDTOAdapter();
			}
			@Override
			public Adapter caseStruct(Struct object)
			{
				return createStructAdapter();
			}
			@Override
			public Adapter caseNamedViewBlock(NamedViewBlock object)
			{
				return createNamedViewBlockAdapter();
			}
			@Override
			public Adapter caseCompositeMethodStatement(CompositeMethodStatement object)
			{
				return createCompositeMethodStatementAdapter();
			}
			@Override
			public <T extends Element> Adapter caseCompositeElement(CompositeElement<T> object)
			{
				return createCompositeElementAdapter();
			}
			@Override
			public Adapter caseViewStatement(ViewStatement object)
			{
				return createViewStatementAdapter();
			}
			@Override
			public Adapter caseElement(Element object)
			{
				return createElementAdapter();
			}
			@Override
			public <T extends Element> Adapter caseCompositeTypeSpecification(CompositeTypeSpecification<T> object)
			{
				return createCompositeTypeSpecificationAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object)
			{
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target)
	{
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Package <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Package
	 * @generated
	 */
	public Adapter createPackageAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.InformationSystem <em>Information System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.InformationSystem
	 * @generated
	 */
	public Adapter createInformationSystemAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Import <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Import
	 * @generated
	 */
	public Adapter createImportAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Type
	 * @generated
	 */
	public Adapter createTypeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.TypedElement
	 * @generated
	 */
	public Adapter createTypedElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.VariableTypeElement <em>Variable Type Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.VariableTypeElement
	 * @generated
	 */
	public Adapter createVariableTypeElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Feature
	 * @generated
	 */
	public Adapter createFeatureAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Attribute
	 * @generated
	 */
	public Adapter createAttributeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Variable
	 * @generated
	 */
	public Adapter createVariableAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Resource
	 * @generated
	 */
	public Adapter createResourceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.TypeSpecification <em>Type Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.TypeSpecification
	 * @generated
	 */
	public Adapter createTypeSpecificationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Primitive <em>Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Primitive
	 * @generated
	 */
	public Adapter createPrimitiveAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Constraint
	 * @generated
	 */
	public Adapter createConstraintAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Function
	 * @generated
	 */
	public Adapter createFunctionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Method <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Method
	 * @generated
	 */
	public Adapter createMethodAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Entity
	 * @generated
	 */
	public Adapter createEntityAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Actor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Actor
	 * @generated
	 */
	public Adapter createActorAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Controller <em>Controller</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Controller
	 * @generated
	 */
	public Adapter createControllerAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.View <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.View
	 * @generated
	 */
	public Adapter createViewAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Statement
	 * @generated
	 */
	public Adapter createStatementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.MethodStatement <em>Method Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.MethodStatement
	 * @generated
	 */
	public Adapter createMethodStatementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.CompositeViewStatement <em>Composite View Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.CompositeViewStatement
	 * @generated
	 */
	public Adapter createCompositeViewStatementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.For <em>For</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.For
	 * @generated
	 */
	public Adapter createForAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Iteration <em>Iteration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Iteration
	 * @generated
	 */
	public Adapter createIterationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.ForView <em>For View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.ForView
	 * @generated
	 */
	public Adapter createForViewAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Reference
	 * @generated
	 */
	public Adapter createReferenceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.ParameterizedReference <em>Parameterized Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.ParameterizedReference
	 * @generated
	 */
	public Adapter createParameterizedReferenceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.MethodCall <em>Method Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.MethodCall
	 * @generated
	 */
	public Adapter createMethodCallAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.ActionCall <em>Action Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.ActionCall
	 * @generated
	 */
	public Adapter createActionCallAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.VariableReference <em>Variable Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.VariableReference
	 * @generated
	 */
	public Adapter createVariableReferenceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Expression
	 * @generated
	 */
	public Adapter createExpressionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.If <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.If
	 * @generated
	 */
	public Adapter createIfAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.IfView <em>If View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.IfView
	 * @generated
	 */
	public Adapter createIfViewAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Conditional <em>Conditional</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Conditional
	 * @generated
	 */
	public Adapter createConditionalAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.While <em>While</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.While
	 * @generated
	 */
	public Adapter createWhileAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Return <em>Return</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Return
	 * @generated
	 */
	public Adapter createReturnAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Instance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Instance
	 * @generated
	 */
	public Adapter createInstanceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Caller <em>Caller</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Caller
	 * @generated
	 */
	public Adapter createCallerAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.ViewInstance <em>View Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.ViewInstance
	 * @generated
	 */
	public Adapter createViewInstanceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.StructInstance <em>Struct Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.StructInstance
	 * @generated
	 */
	public Adapter createStructInstanceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Show <em>Show</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Show
	 * @generated
	 */
	public Adapter createShowAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Operator
	 * @generated
	 */
	public Adapter createOperatorAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.BinaryOperator <em>Binary Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.BinaryOperator
	 * @generated
	 */
	public Adapter createBinaryOperatorAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.UnaryOperator <em>Unary Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.UnaryOperator
	 * @generated
	 */
	public Adapter createUnaryOperatorAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Assignment
	 * @generated
	 */
	public Adapter createAssignmentAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Widget <em>Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Widget
	 * @generated
	 */
	public Adapter createWidgetAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Page <em>Page</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Page
	 * @generated
	 */
	public Adapter createPageAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.ResourceBundle <em>Resource Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.ResourceBundle
	 * @generated
	 */
	public Adapter createResourceBundleAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.ConstraintInstance <em>Constraint Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.ConstraintInstance
	 * @generated
	 */
	public Adapter createConstraintInstanceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Interface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Interface
	 * @generated
	 */
	public Adapter createInterfaceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Service
	 * @generated
	 */
	public Adapter createServiceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Action
	 * @generated
	 */
	public Adapter createActionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.LiteralValue <em>Literal Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.LiteralValue
	 * @generated
	 */
	public Adapter createLiteralValueAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.IntValue <em>Int Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.IntValue
	 * @generated
	 */
	public Adapter createIntValueAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.FloatValue <em>Float Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.FloatValue
	 * @generated
	 */
	public Adapter createFloatValueAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.BoolValue <em>Bool Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.BoolValue
	 * @generated
	 */
	public Adapter createBoolValueAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.StringValue <em>String Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.StringValue
	 * @generated
	 */
	public Adapter createStringValueAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.NullValue <em>Null Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.NullValue
	 * @generated
	 */
	public Adapter createNullValueAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.ResourceReference <em>Resource Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.ResourceReference
	 * @generated
	 */
	public Adapter createResourceReferenceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.GenericTypeSpecification <em>Generic Type Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.GenericTypeSpecification
	 * @generated
	 */
	public Adapter createGenericTypeSpecificationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.ParameterizedType <em>Parameterized Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.ParameterizedType
	 * @generated
	 */
	public Adapter createParameterizedTypeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Enum <em>Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Enum
	 * @generated
	 */
	public Adapter createEnumAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.EnumItem <em>Enum Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.EnumItem
	 * @generated
	 */
	public Adapter createEnumItemAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.ResourceAssignment <em>Resource Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.ResourceAssignment
	 * @generated
	 */
	public Adapter createResourceAssignmentAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.DTO <em>DTO</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.DTO
	 * @generated
	 */
	public Adapter createDTOAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Struct <em>Struct</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Struct
	 * @generated
	 */
	public Adapter createStructAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.NamedViewBlock <em>Named View Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.NamedViewBlock
	 * @generated
	 */
	public Adapter createNamedViewBlockAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.CompositeMethodStatement <em>Composite Method Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.CompositeMethodStatement
	 * @generated
	 */
	public Adapter createCompositeMethodStatementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.CompositeElement <em>Composite Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.CompositeElement
	 * @generated
	 */
	public Adapter createCompositeElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.ViewStatement <em>View Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.ViewStatement
	 * @generated
	 */
	public Adapter createViewStatementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.Element
	 * @generated
	 */
	public Adapter createElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link co.edu.javeriana.isml.isml.CompositeTypeSpecification <em>Composite Type Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see co.edu.javeriana.isml.isml.CompositeTypeSpecification
	 * @generated
	 */
	public Adapter createCompositeTypeSpecificationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter()
	{
		return null;
	}

} //IsmlAdapterFactory
