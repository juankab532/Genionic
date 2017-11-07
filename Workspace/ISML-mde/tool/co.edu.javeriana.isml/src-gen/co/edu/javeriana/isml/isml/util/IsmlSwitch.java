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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see co.edu.javeriana.isml.isml.IsmlPackage
 * @generated
 */
public class IsmlSwitch<T1> extends Switch<T1>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static IsmlPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsmlSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = IsmlPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage)
	{
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T1 doSwitch(int classifierID, EObject theEObject)
	{
		switch (classifierID)
		{
			case IsmlPackage.PACKAGE:
			{
				co.edu.javeriana.isml.isml.Package package_ = (co.edu.javeriana.isml.isml.Package)theEObject;
				T1 result = casePackage(package_);
				if (result == null) result = caseCompositeElement(package_);
				if (result == null) result = caseNamedElement(package_);
				if (result == null) result = caseElement(package_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.INFORMATION_SYSTEM:
			{
				InformationSystem informationSystem = (InformationSystem)theEObject;
				T1 result = caseInformationSystem(informationSystem);
				if (result == null) result = caseCompositeElement(informationSystem);
				if (result == null) result = caseNamedElement(informationSystem);
				if (result == null) result = caseElement(informationSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.IMPORT:
			{
				Import import_ = (Import)theEObject;
				T1 result = caseImport(import_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.NAMED_ELEMENT:
			{
				NamedElement namedElement = (NamedElement)theEObject;
				T1 result = caseNamedElement(namedElement);
				if (result == null) result = caseElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.TYPE:
			{
				Type type = (Type)theEObject;
				T1 result = caseType(type);
				if (result == null) result = caseReference(type);
				if (result == null) result = caseExpression(type);
				if (result == null) result = caseMethodStatement(type);
				if (result == null) result = caseStatement(type);
				if (result == null) result = caseElement(type);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.TYPED_ELEMENT:
			{
				TypedElement typedElement = (TypedElement)theEObject;
				T1 result = caseTypedElement(typedElement);
				if (result == null) result = caseNamedElement(typedElement);
				if (result == null) result = caseElement(typedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.VARIABLE_TYPE_ELEMENT:
			{
				VariableTypeElement variableTypeElement = (VariableTypeElement)theEObject;
				T1 result = caseVariableTypeElement(variableTypeElement);
				if (result == null) result = caseTypedElement(variableTypeElement);
				if (result == null) result = caseNamedElement(variableTypeElement);
				if (result == null) result = caseElement(variableTypeElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.FEATURE:
			{
				Feature feature = (Feature)theEObject;
				T1 result = caseFeature(feature);
				if (result == null) result = caseTypedElement(feature);
				if (result == null) result = caseStatement(feature);
				if (result == null) result = caseNamedElement(feature);
				if (result == null) result = caseElement(feature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.ATTRIBUTE:
			{
				Attribute attribute = (Attribute)theEObject;
				T1 result = caseAttribute(attribute);
				if (result == null) result = caseVariableTypeElement(attribute);
				if (result == null) result = caseFeature(attribute);
				if (result == null) result = caseTypedElement(attribute);
				if (result == null) result = caseStatement(attribute);
				if (result == null) result = caseNamedElement(attribute);
				if (result == null) result = caseElement(attribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.PARAMETER:
			{
				Parameter parameter = (Parameter)theEObject;
				T1 result = caseParameter(parameter);
				if (result == null) result = caseVariableTypeElement(parameter);
				if (result == null) result = caseTypedElement(parameter);
				if (result == null) result = caseNamedElement(parameter);
				if (result == null) result = caseElement(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.VARIABLE:
			{
				Variable variable = (Variable)theEObject;
				T1 result = caseVariable(variable);
				if (result == null) result = caseVariableTypeElement(variable);
				if (result == null) result = caseMethodStatement(variable);
				if (result == null) result = caseTypedElement(variable);
				if (result == null) result = caseStatement(variable);
				if (result == null) result = caseNamedElement(variable);
				if (result == null) result = caseElement(variable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.RESOURCE:
			{
				Resource resource = (Resource)theEObject;
				T1 result = caseResource(resource);
				if (result == null) result = caseTypedElement(resource);
				if (result == null) result = caseNamedElement(resource);
				if (result == null) result = caseElement(resource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.TYPE_SPECIFICATION:
			{
				TypeSpecification typeSpecification = (TypeSpecification)theEObject;
				T1 result = caseTypeSpecification(typeSpecification);
				if (result == null) result = caseFunction(typeSpecification);
				if (result == null) result = caseNamedElement(typeSpecification);
				if (result == null) result = caseElement(typeSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.PRIMITIVE:
			{
				Primitive primitive = (Primitive)theEObject;
				T1 result = casePrimitive(primitive);
				if (result == null) result = caseTypeSpecification(primitive);
				if (result == null) result = caseFunction(primitive);
				if (result == null) result = caseNamedElement(primitive);
				if (result == null) result = caseElement(primitive);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.CONSTRAINT:
			{
				Constraint constraint = (Constraint)theEObject;
				T1 result = caseConstraint(constraint);
				if (result == null) result = caseTypeSpecification(constraint);
				if (result == null) result = caseFunction(constraint);
				if (result == null) result = caseNamedElement(constraint);
				if (result == null) result = caseElement(constraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.FUNCTION:
			{
				Function function = (Function)theEObject;
				T1 result = caseFunction(function);
				if (result == null) result = caseNamedElement(function);
				if (result == null) result = caseElement(function);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.METHOD:
			{
				Method method = (Method)theEObject;
				T1 result = caseMethod(method);
				if (result == null) result = caseFeature(method);
				if (result == null) result = caseFunction(method);
				if (result == null) result = caseCompositeElement(method);
				if (result == null) result = caseTypedElement(method);
				if (result == null) result = caseStatement(method);
				if (result == null) result = caseNamedElement(method);
				if (result == null) result = caseElement(method);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.ENTITY:
			{
				Entity entity = (Entity)theEObject;
				T1 result = caseEntity(entity);
				if (result == null) result = caseStruct(entity);
				if (result == null) result = caseCompositeTypeSpecification(entity);
				if (result == null) result = caseCompositeElement(entity);
				if (result == null) result = caseTypeSpecification(entity);
				if (result == null) result = caseFunction(entity);
				if (result == null) result = caseNamedElement(entity);
				if (result == null) result = caseElement(entity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.ACTOR:
			{
				Actor actor = (Actor)theEObject;
				T1 result = caseActor(actor);
				if (result == null) result = caseEntity(actor);
				if (result == null) result = caseStruct(actor);
				if (result == null) result = caseCompositeTypeSpecification(actor);
				if (result == null) result = caseCompositeElement(actor);
				if (result == null) result = caseTypeSpecification(actor);
				if (result == null) result = caseFunction(actor);
				if (result == null) result = caseNamedElement(actor);
				if (result == null) result = caseElement(actor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.CONTROLLER:
			{
				Controller controller = (Controller)theEObject;
				T1 result = caseController(controller);
				if (result == null) result = caseCompositeTypeSpecification(controller);
				if (result == null) result = caseCompositeElement(controller);
				if (result == null) result = caseTypeSpecification(controller);
				if (result == null) result = caseFunction(controller);
				if (result == null) result = caseNamedElement(controller);
				if (result == null) result = caseElement(controller);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.VIEW:
			{
				View view = (View)theEObject;
				T1 result = caseView(view);
				if (result == null) result = caseCompositeTypeSpecification(view);
				if (result == null) result = caseCompositeElement(view);
				if (result == null) result = caseTypeSpecification(view);
				if (result == null) result = caseFunction(view);
				if (result == null) result = caseNamedElement(view);
				if (result == null) result = caseElement(view);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.STATEMENT:
			{
				Statement statement = (Statement)theEObject;
				T1 result = caseStatement(statement);
				if (result == null) result = caseElement(statement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.METHOD_STATEMENT:
			{
				MethodStatement methodStatement = (MethodStatement)theEObject;
				T1 result = caseMethodStatement(methodStatement);
				if (result == null) result = caseStatement(methodStatement);
				if (result == null) result = caseElement(methodStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.COMPOSITE_VIEW_STATEMENT:
			{
				CompositeViewStatement compositeViewStatement = (CompositeViewStatement)theEObject;
				T1 result = caseCompositeViewStatement(compositeViewStatement);
				if (result == null) result = caseViewStatement(compositeViewStatement);
				if (result == null) result = caseCompositeElement(compositeViewStatement);
				if (result == null) result = caseNamedElement(compositeViewStatement);
				if (result == null) result = caseStatement(compositeViewStatement);
				if (result == null) result = caseElement(compositeViewStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.FOR:
			{
				For for_ = (For)theEObject;
				T1 result = caseFor(for_);
				if (result == null) result = caseCompositeMethodStatement(for_);
				if (result == null) result = caseIteration(for_);
				if (result == null) result = caseMethodStatement(for_);
				if (result == null) result = caseStatement(for_);
				if (result == null) result = caseCompositeElement(for_);
				if (result == null) result = caseNamedElement(for_);
				if (result == null) result = caseElement(for_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.ITERATION:
			{
				Iteration iteration = (Iteration)theEObject;
				T1 result = caseIteration(iteration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.FOR_VIEW:
			{
				ForView forView = (ForView)theEObject;
				T1 result = caseForView(forView);
				if (result == null) result = caseCompositeViewStatement(forView);
				if (result == null) result = caseIteration(forView);
				if (result == null) result = caseViewStatement(forView);
				if (result == null) result = caseCompositeElement(forView);
				if (result == null) result = caseNamedElement(forView);
				if (result == null) result = caseStatement(forView);
				if (result == null) result = caseElement(forView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.REFERENCE:
			{
				Reference<?> reference = (Reference<?>)theEObject;
				T1 result = caseReference(reference);
				if (result == null) result = caseExpression(reference);
				if (result == null) result = caseMethodStatement(reference);
				if (result == null) result = caseStatement(reference);
				if (result == null) result = caseElement(reference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.PARAMETERIZED_REFERENCE:
			{
				ParameterizedReference<?> parameterizedReference = (ParameterizedReference<?>)theEObject;
				T1 result = caseParameterizedReference(parameterizedReference);
				if (result == null) result = caseCaller(parameterizedReference);
				if (result == null) result = caseReference(parameterizedReference);
				if (result == null) result = caseExpression(parameterizedReference);
				if (result == null) result = caseMethodStatement(parameterizedReference);
				if (result == null) result = caseStatement(parameterizedReference);
				if (result == null) result = caseElement(parameterizedReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.METHOD_CALL:
			{
				MethodCall methodCall = (MethodCall)theEObject;
				T1 result = caseMethodCall(methodCall);
				if (result == null) result = caseParameterizedReference(methodCall);
				if (result == null) result = caseCaller(methodCall);
				if (result == null) result = caseReference(methodCall);
				if (result == null) result = caseExpression(methodCall);
				if (result == null) result = caseMethodStatement(methodCall);
				if (result == null) result = caseStatement(methodCall);
				if (result == null) result = caseElement(methodCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.ACTION_CALL:
			{
				ActionCall actionCall = (ActionCall)theEObject;
				T1 result = caseActionCall(actionCall);
				if (result == null) result = caseParameterizedReference(actionCall);
				if (result == null) result = caseCaller(actionCall);
				if (result == null) result = caseReference(actionCall);
				if (result == null) result = caseExpression(actionCall);
				if (result == null) result = caseMethodStatement(actionCall);
				if (result == null) result = caseStatement(actionCall);
				if (result == null) result = caseElement(actionCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.VARIABLE_REFERENCE:
			{
				VariableReference variableReference = (VariableReference)theEObject;
				T1 result = caseVariableReference(variableReference);
				if (result == null) result = caseReference(variableReference);
				if (result == null) result = caseExpression(variableReference);
				if (result == null) result = caseMethodStatement(variableReference);
				if (result == null) result = caseStatement(variableReference);
				if (result == null) result = caseElement(variableReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.EXPRESSION:
			{
				Expression expression = (Expression)theEObject;
				T1 result = caseExpression(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.IF:
			{
				If if_ = (If)theEObject;
				T1 result = caseIf(if_);
				if (result == null) result = caseConditional(if_);
				if (result == null) result = caseCompositeMethodStatement(if_);
				if (result == null) result = caseMethodStatement(if_);
				if (result == null) result = caseCompositeElement(if_);
				if (result == null) result = caseStatement(if_);
				if (result == null) result = caseNamedElement(if_);
				if (result == null) result = caseElement(if_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.IF_VIEW:
			{
				IfView ifView = (IfView)theEObject;
				T1 result = caseIfView(ifView);
				if (result == null) result = caseConditional(ifView);
				if (result == null) result = caseCompositeViewStatement(ifView);
				if (result == null) result = caseViewStatement(ifView);
				if (result == null) result = caseCompositeElement(ifView);
				if (result == null) result = caseNamedElement(ifView);
				if (result == null) result = caseStatement(ifView);
				if (result == null) result = caseElement(ifView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.CONDITIONAL:
			{
				Conditional conditional = (Conditional)theEObject;
				T1 result = caseConditional(conditional);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.WHILE:
			{
				While while_ = (While)theEObject;
				T1 result = caseWhile(while_);
				if (result == null) result = caseConditional(while_);
				if (result == null) result = caseCompositeMethodStatement(while_);
				if (result == null) result = caseMethodStatement(while_);
				if (result == null) result = caseCompositeElement(while_);
				if (result == null) result = caseStatement(while_);
				if (result == null) result = caseNamedElement(while_);
				if (result == null) result = caseElement(while_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.RETURN:
			{
				Return return_ = (Return)theEObject;
				T1 result = caseReturn(return_);
				if (result == null) result = caseMethodStatement(return_);
				if (result == null) result = caseStatement(return_);
				if (result == null) result = caseElement(return_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.INSTANCE:
			{
				Instance instance = (Instance)theEObject;
				T1 result = caseInstance(instance);
				if (result == null) result = caseExpression(instance);
				if (result == null) result = caseCaller(instance);
				if (result == null) result = caseTypedElement(instance);
				if (result == null) result = caseNamedElement(instance);
				if (result == null) result = caseElement(instance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.CALLER:
			{
				Caller caller = (Caller)theEObject;
				T1 result = caseCaller(caller);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.VIEW_INSTANCE:
			{
				ViewInstance viewInstance = (ViewInstance)theEObject;
				T1 result = caseViewInstance(viewInstance);
				if (result == null) result = caseInstance(viewInstance);
				if (result == null) result = caseCompositeViewStatement(viewInstance);
				if (result == null) result = caseExpression(viewInstance);
				if (result == null) result = caseCaller(viewInstance);
				if (result == null) result = caseTypedElement(viewInstance);
				if (result == null) result = caseViewStatement(viewInstance);
				if (result == null) result = caseCompositeElement(viewInstance);
				if (result == null) result = caseNamedElement(viewInstance);
				if (result == null) result = caseStatement(viewInstance);
				if (result == null) result = caseElement(viewInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.STRUCT_INSTANCE:
			{
				StructInstance structInstance = (StructInstance)theEObject;
				T1 result = caseStructInstance(structInstance);
				if (result == null) result = caseInstance(structInstance);
				if (result == null) result = caseExpression(structInstance);
				if (result == null) result = caseCaller(structInstance);
				if (result == null) result = caseTypedElement(structInstance);
				if (result == null) result = caseNamedElement(structInstance);
				if (result == null) result = caseElement(structInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.SHOW:
			{
				Show show = (Show)theEObject;
				T1 result = caseShow(show);
				if (result == null) result = caseMethodStatement(show);
				if (result == null) result = caseStatement(show);
				if (result == null) result = caseElement(show);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.OPERATOR:
			{
				Operator operator = (Operator)theEObject;
				T1 result = caseOperator(operator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.BINARY_OPERATOR:
			{
				BinaryOperator binaryOperator = (BinaryOperator)theEObject;
				T1 result = caseBinaryOperator(binaryOperator);
				if (result == null) result = caseOperator(binaryOperator);
				if (result == null) result = caseExpression(binaryOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.UNARY_OPERATOR:
			{
				UnaryOperator unaryOperator = (UnaryOperator)theEObject;
				T1 result = caseUnaryOperator(unaryOperator);
				if (result == null) result = caseOperator(unaryOperator);
				if (result == null) result = caseExpression(unaryOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.ASSIGNMENT:
			{
				Assignment assignment = (Assignment)theEObject;
				T1 result = caseAssignment(assignment);
				if (result == null) result = caseBinaryOperator(assignment);
				if (result == null) result = caseMethodStatement(assignment);
				if (result == null) result = caseOperator(assignment);
				if (result == null) result = caseExpression(assignment);
				if (result == null) result = caseStatement(assignment);
				if (result == null) result = caseElement(assignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.WIDGET:
			{
				Widget widget = (Widget)theEObject;
				T1 result = caseWidget(widget);
				if (result == null) result = caseView(widget);
				if (result == null) result = caseCompositeTypeSpecification(widget);
				if (result == null) result = caseCompositeElement(widget);
				if (result == null) result = caseTypeSpecification(widget);
				if (result == null) result = caseFunction(widget);
				if (result == null) result = caseNamedElement(widget);
				if (result == null) result = caseElement(widget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.PAGE:
			{
				Page page = (Page)theEObject;
				T1 result = casePage(page);
				if (result == null) result = caseView(page);
				if (result == null) result = caseCompositeTypeSpecification(page);
				if (result == null) result = caseCompositeElement(page);
				if (result == null) result = caseTypeSpecification(page);
				if (result == null) result = caseFunction(page);
				if (result == null) result = caseNamedElement(page);
				if (result == null) result = caseElement(page);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.RESOURCE_BUNDLE:
			{
				ResourceBundle resourceBundle = (ResourceBundle)theEObject;
				T1 result = caseResourceBundle(resourceBundle);
				if (result == null) result = caseCompositeTypeSpecification(resourceBundle);
				if (result == null) result = caseCompositeElement(resourceBundle);
				if (result == null) result = caseTypeSpecification(resourceBundle);
				if (result == null) result = caseFunction(resourceBundle);
				if (result == null) result = caseNamedElement(resourceBundle);
				if (result == null) result = caseElement(resourceBundle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.CONSTRAINT_INSTANCE:
			{
				ConstraintInstance constraintInstance = (ConstraintInstance)theEObject;
				T1 result = caseConstraintInstance(constraintInstance);
				if (result == null) result = caseInstance(constraintInstance);
				if (result == null) result = caseExpression(constraintInstance);
				if (result == null) result = caseCaller(constraintInstance);
				if (result == null) result = caseTypedElement(constraintInstance);
				if (result == null) result = caseNamedElement(constraintInstance);
				if (result == null) result = caseElement(constraintInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.INTERFACE:
			{
				Interface interface_ = (Interface)theEObject;
				T1 result = caseInterface(interface_);
				if (result == null) result = caseCompositeTypeSpecification(interface_);
				if (result == null) result = caseCompositeElement(interface_);
				if (result == null) result = caseTypeSpecification(interface_);
				if (result == null) result = caseFunction(interface_);
				if (result == null) result = caseNamedElement(interface_);
				if (result == null) result = caseElement(interface_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.SERVICE:
			{
				Service service = (Service)theEObject;
				T1 result = caseService(service);
				if (result == null) result = caseInterface(service);
				if (result == null) result = caseCompositeTypeSpecification(service);
				if (result == null) result = caseCompositeElement(service);
				if (result == null) result = caseTypeSpecification(service);
				if (result == null) result = caseFunction(service);
				if (result == null) result = caseNamedElement(service);
				if (result == null) result = caseElement(service);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.ACTION:
			{
				Action action = (Action)theEObject;
				T1 result = caseAction(action);
				if (result == null) result = caseFeature(action);
				if (result == null) result = caseFunction(action);
				if (result == null) result = caseCompositeElement(action);
				if (result == null) result = caseTypedElement(action);
				if (result == null) result = caseStatement(action);
				if (result == null) result = caseNamedElement(action);
				if (result == null) result = caseElement(action);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.LITERAL_VALUE:
			{
				LiteralValue literalValue = (LiteralValue)theEObject;
				T1 result = caseLiteralValue(literalValue);
				if (result == null) result = caseExpression(literalValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.INT_VALUE:
			{
				IntValue intValue = (IntValue)theEObject;
				T1 result = caseIntValue(intValue);
				if (result == null) result = caseLiteralValue(intValue);
				if (result == null) result = caseExpression(intValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.FLOAT_VALUE:
			{
				FloatValue floatValue = (FloatValue)theEObject;
				T1 result = caseFloatValue(floatValue);
				if (result == null) result = caseLiteralValue(floatValue);
				if (result == null) result = caseExpression(floatValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.BOOL_VALUE:
			{
				BoolValue boolValue = (BoolValue)theEObject;
				T1 result = caseBoolValue(boolValue);
				if (result == null) result = caseLiteralValue(boolValue);
				if (result == null) result = caseExpression(boolValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.STRING_VALUE:
			{
				StringValue stringValue = (StringValue)theEObject;
				T1 result = caseStringValue(stringValue);
				if (result == null) result = caseLiteralValue(stringValue);
				if (result == null) result = caseExpression(stringValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.NULL_VALUE:
			{
				NullValue nullValue = (NullValue)theEObject;
				T1 result = caseNullValue(nullValue);
				if (result == null) result = caseLiteralValue(nullValue);
				if (result == null) result = caseExpression(nullValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.RESOURCE_REFERENCE:
			{
				ResourceReference resourceReference = (ResourceReference)theEObject;
				T1 result = caseResourceReference(resourceReference);
				if (result == null) result = caseReference(resourceReference);
				if (result == null) result = caseExpression(resourceReference);
				if (result == null) result = caseMethodStatement(resourceReference);
				if (result == null) result = caseStatement(resourceReference);
				if (result == null) result = caseElement(resourceReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.GENERIC_TYPE_SPECIFICATION:
			{
				GenericTypeSpecification genericTypeSpecification = (GenericTypeSpecification)theEObject;
				T1 result = caseGenericTypeSpecification(genericTypeSpecification);
				if (result == null) result = caseTypeSpecification(genericTypeSpecification);
				if (result == null) result = caseFunction(genericTypeSpecification);
				if (result == null) result = caseNamedElement(genericTypeSpecification);
				if (result == null) result = caseElement(genericTypeSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.PARAMETERIZED_TYPE:
			{
				ParameterizedType parameterizedType = (ParameterizedType)theEObject;
				T1 result = caseParameterizedType(parameterizedType);
				if (result == null) result = caseType(parameterizedType);
				if (result == null) result = caseReference(parameterizedType);
				if (result == null) result = caseExpression(parameterizedType);
				if (result == null) result = caseMethodStatement(parameterizedType);
				if (result == null) result = caseStatement(parameterizedType);
				if (result == null) result = caseElement(parameterizedType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.ENUM:
			{
				co.edu.javeriana.isml.isml.Enum enum_ = (co.edu.javeriana.isml.isml.Enum)theEObject;
				T1 result = caseEnum(enum_);
				if (result == null) result = caseStruct(enum_);
				if (result == null) result = caseCompositeTypeSpecification(enum_);
				if (result == null) result = caseCompositeElement(enum_);
				if (result == null) result = caseTypeSpecification(enum_);
				if (result == null) result = caseFunction(enum_);
				if (result == null) result = caseNamedElement(enum_);
				if (result == null) result = caseElement(enum_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.ENUM_ITEM:
			{
				EnumItem enumItem = (EnumItem)theEObject;
				T1 result = caseEnumItem(enumItem);
				if (result == null) result = caseFeature(enumItem);
				if (result == null) result = caseTypedElement(enumItem);
				if (result == null) result = caseStatement(enumItem);
				if (result == null) result = caseNamedElement(enumItem);
				if (result == null) result = caseElement(enumItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.RESOURCE_ASSIGNMENT:
			{
				ResourceAssignment resourceAssignment = (ResourceAssignment)theEObject;
				T1 result = caseResourceAssignment(resourceAssignment);
				if (result == null) result = caseAssignment(resourceAssignment);
				if (result == null) result = caseBinaryOperator(resourceAssignment);
				if (result == null) result = caseMethodStatement(resourceAssignment);
				if (result == null) result = caseOperator(resourceAssignment);
				if (result == null) result = caseExpression(resourceAssignment);
				if (result == null) result = caseStatement(resourceAssignment);
				if (result == null) result = caseElement(resourceAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.DTO:
			{
				DTO dto = (DTO)theEObject;
				T1 result = caseDTO(dto);
				if (result == null) result = caseStruct(dto);
				if (result == null) result = caseCompositeTypeSpecification(dto);
				if (result == null) result = caseCompositeElement(dto);
				if (result == null) result = caseTypeSpecification(dto);
				if (result == null) result = caseFunction(dto);
				if (result == null) result = caseNamedElement(dto);
				if (result == null) result = caseElement(dto);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.STRUCT:
			{
				Struct struct = (Struct)theEObject;
				T1 result = caseStruct(struct);
				if (result == null) result = caseCompositeTypeSpecification(struct);
				if (result == null) result = caseCompositeElement(struct);
				if (result == null) result = caseTypeSpecification(struct);
				if (result == null) result = caseFunction(struct);
				if (result == null) result = caseNamedElement(struct);
				if (result == null) result = caseElement(struct);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.NAMED_VIEW_BLOCK:
			{
				NamedViewBlock namedViewBlock = (NamedViewBlock)theEObject;
				T1 result = caseNamedViewBlock(namedViewBlock);
				if (result == null) result = caseCompositeViewStatement(namedViewBlock);
				if (result == null) result = caseViewStatement(namedViewBlock);
				if (result == null) result = caseCompositeElement(namedViewBlock);
				if (result == null) result = caseNamedElement(namedViewBlock);
				if (result == null) result = caseStatement(namedViewBlock);
				if (result == null) result = caseElement(namedViewBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.COMPOSITE_METHOD_STATEMENT:
			{
				CompositeMethodStatement compositeMethodStatement = (CompositeMethodStatement)theEObject;
				T1 result = caseCompositeMethodStatement(compositeMethodStatement);
				if (result == null) result = caseMethodStatement(compositeMethodStatement);
				if (result == null) result = caseCompositeElement(compositeMethodStatement);
				if (result == null) result = caseStatement(compositeMethodStatement);
				if (result == null) result = caseNamedElement(compositeMethodStatement);
				if (result == null) result = caseElement(compositeMethodStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.COMPOSITE_ELEMENT:
			{
				CompositeElement<?> compositeElement = (CompositeElement<?>)theEObject;
				T1 result = caseCompositeElement(compositeElement);
				if (result == null) result = caseNamedElement(compositeElement);
				if (result == null) result = caseElement(compositeElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.VIEW_STATEMENT:
			{
				ViewStatement viewStatement = (ViewStatement)theEObject;
				T1 result = caseViewStatement(viewStatement);
				if (result == null) result = caseStatement(viewStatement);
				if (result == null) result = caseElement(viewStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.ELEMENT:
			{
				Element element = (Element)theEObject;
				T1 result = caseElement(element);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case IsmlPackage.COMPOSITE_TYPE_SPECIFICATION:
			{
				CompositeTypeSpecification<?> compositeTypeSpecification = (CompositeTypeSpecification<?>)theEObject;
				T1 result = caseCompositeTypeSpecification(compositeTypeSpecification);
				if (result == null) result = caseCompositeElement(compositeTypeSpecification);
				if (result == null) result = caseTypeSpecification(compositeTypeSpecification);
				if (result == null) result = caseFunction(compositeTypeSpecification);
				if (result == null) result = caseNamedElement(compositeTypeSpecification);
				if (result == null) result = caseElement(compositeTypeSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePackage(co.edu.javeriana.isml.isml.Package object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Information System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Information System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseInformationSystem(InformationSystem object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Import</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseImport(Import object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNamedElement(NamedElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseType(Type object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTypedElement(TypedElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Type Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Type Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseVariableTypeElement(VariableTypeElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFeature(Feature object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAttribute(Attribute object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseParameter(Parameter object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseVariable(Variable object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseResource(Resource object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTypeSpecification(TypeSpecification object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePrimitive(Primitive object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseConstraint(Constraint object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFunction(Function object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMethod(Method object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEntity(Entity object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseActor(Actor object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Controller</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Controller</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseController(Controller object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseView(View object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStatement(Statement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMethodStatement(MethodStatement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite View Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite View Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCompositeViewStatement(CompositeViewStatement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFor(For object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iteration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iteration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIteration(Iteration object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseForView(ForView object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends NamedElement> T1 caseReference(Reference<T> object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameterized Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameterized Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends NamedElement> T1 caseParameterizedReference(ParameterizedReference<T> object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMethodCall(MethodCall object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseActionCall(ActionCall object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseVariableReference(VariableReference object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseExpression(Expression object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIf(If object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIfView(IfView object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conditional</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conditional</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseConditional(Conditional object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>While</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>While</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseWhile(While object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Return</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Return</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseReturn(Return object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseInstance(Instance object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Caller</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Caller</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCaller(Caller object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>View Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>View Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseViewInstance(ViewInstance object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Struct Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Struct Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStructInstance(StructInstance object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Show</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Show</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseShow(Show object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseOperator(Operator object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBinaryOperator(BinaryOperator object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseUnaryOperator(UnaryOperator object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAssignment(Assignment object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Widget</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Widget</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseWidget(Widget object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Page</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Page</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePage(Page object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Bundle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Bundle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseResourceBundle(ResourceBundle object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseConstraintInstance(ConstraintInstance object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseInterface(Interface object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseService(Service object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAction(Action object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLiteralValue(LiteralValue object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIntValue(IntValue object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Float Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Float Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFloatValue(FloatValue object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bool Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bool Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBoolValue(BoolValue object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStringValue(StringValue object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Null Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Null Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNullValue(NullValue object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseResourceReference(ResourceReference object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generic Type Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic Type Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseGenericTypeSpecification(GenericTypeSpecification object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameterized Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameterized Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseParameterizedType(ParameterizedType object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEnum(co.edu.javeriana.isml.isml.Enum object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEnumItem(EnumItem object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseResourceAssignment(ResourceAssignment object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DTO</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DTO</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDTO(DTO object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Struct</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Struct</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStruct(Struct object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named View Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named View Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseNamedViewBlock(NamedViewBlock object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Method Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Method Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCompositeMethodStatement(CompositeMethodStatement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Element> T1 caseCompositeElement(CompositeElement<T> object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>View Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>View Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseViewStatement(ViewStatement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseElement(Element object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Type Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Type Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Element> T1 caseCompositeTypeSpecification(CompositeTypeSpecification<T> object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T1 defaultCase(EObject object)
	{
		return null;
	}

} //IsmlSwitch
