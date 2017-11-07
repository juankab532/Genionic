package co.edu.javeriana.generator.genionic.backend.templates;

import co.edu.javeriana.generator.genionic.backend.templates.ExpressionTemplate;
import co.edu.javeriana.isml.isml.Action;
import co.edu.javeriana.isml.isml.ActionCall;
import co.edu.javeriana.isml.isml.Assignment;
import co.edu.javeriana.isml.isml.Attribute;
import co.edu.javeriana.isml.isml.Controller;
import co.edu.javeriana.isml.isml.Entity;
import co.edu.javeriana.isml.isml.EnumItem;
import co.edu.javeriana.isml.isml.Expression;
import co.edu.javeriana.isml.isml.GenericTypeSpecification;
import co.edu.javeriana.isml.isml.MethodCall;
import co.edu.javeriana.isml.isml.NamedElement;
import co.edu.javeriana.isml.isml.Parameter;
import co.edu.javeriana.isml.isml.ParameterizedType;
import co.edu.javeriana.isml.isml.Reference;
import co.edu.javeriana.isml.isml.ResourceReference;
import co.edu.javeriana.isml.isml.Show;
import co.edu.javeriana.isml.isml.Type;
import co.edu.javeriana.isml.isml.TypeSpecification;
import co.edu.javeriana.isml.isml.VariableReference;
import co.edu.javeriana.isml.isml.VariableTypeElement;
import co.edu.javeriana.isml.isml.ViewInstance;
import co.edu.javeriana.isml.scoping.IsmlModelNavigation;
import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.Map;
import javax.inject.Inject;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Clase para utilidades de las plantillas
 */
@SuppressWarnings("all")
public class ReferenceTemplate {
  @Inject
  @Extension
  private IsmlModelNavigation _ismlModelNavigation;
  
  @Inject
  @Extension
  private ExpressionTemplate _expressionTemplate;
  
  protected CharSequence _writeReference(final MethodCall reference) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = this._ismlModelNavigation.getMethod(reference).getName();
    _builder.append(_name);
    _builder.append("(");
    {
      EList<Expression> _parameters = reference.getParameters();
      boolean _hasElements = false;
      for(final Expression parameter : _parameters) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "");
        }
        CharSequence _writeExpression = this._expressionTemplate.writeExpression(parameter);
        _builder.append(_writeExpression);
      }
    }
    _builder.append(")");
    return _builder;
  }
  
  protected CharSequence _writeReference(final ActionCall reference) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Controller _findAncestor = this._ismlModelNavigation.<ActionCall, Controller>findAncestor(reference, Controller.class);
      boolean _notEquals = (!Objects.equal(_findAncestor, null));
      if (_notEquals) {
        _builder.append("return ");
      }
    }
    {
      EObject _eContainer = this._ismlModelNavigation.getAction(reference).eContainer();
      Controller _findAncestor_1 = this._ismlModelNavigation.<ActionCall, Controller>findAncestor(reference, Controller.class);
      boolean _equals = ((Controller) _eContainer).getName().equals(((Controller) _findAncestor_1).getName());
      boolean _not = (!_equals);
      if (_not) {
        EObject _eContainer_1 = this._ismlModelNavigation.getAction(reference).eContainer();
        String _firstLower = StringExtensions.toFirstLower(((Controller) _eContainer_1).getName());
        _builder.append(_firstLower);
        _builder.append(".");
      }
    }
    String _name = this._ismlModelNavigation.getAction(reference).getName();
    _builder.append(_name);
    _builder.append("(");
    {
      EList<Expression> _validateParameterForActionCall = this._ismlModelNavigation.validateParameterForActionCall(reference);
      boolean _hasElements = false;
      for(final Expression parameter : _validateParameterForActionCall) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "");
        }
        CharSequence _writeExpression = this._expressionTemplate.writeExpression(parameter);
        _builder.append(_writeExpression);
      }
    }
    _builder.append(")");
    return _builder;
  }
  
  protected CharSequence _writeReference(final ResourceReference reference) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"#{messages[\'");
    String _substring = reference.getReferencedElement().getName().substring(1);
    _builder.append(_substring);
    _builder.append("\']}\"");
    return _builder;
  }
  
  public ViewInstance getViewInstanceIfExists(final EObject object) {
    EObject returnObject = null;
    EObject tmpObject = object;
    while (((!Objects.equal(tmpObject, null)) && Objects.equal(returnObject, null))) {
      {
        if (((((!Objects.equal(tmpObject.eContainer(), null)) && (tmpObject.eContainer() instanceof ViewInstance)) && (!Objects.equal(tmpObject.eContainer().eContainer(), null))) && (!(tmpObject.eContainer().eContainer() instanceof Show)))) {
          returnObject = tmpObject.eContainer();
        }
        tmpObject = tmpObject.eContainer();
      }
    }
    return ((ViewInstance) returnObject);
  }
  
  protected CharSequence _writeReference(final VariableReference reference) {
    String str = reference.getReferencedElement().getName();
    EObject show = reference.eContainer().eContainer();
    VariableTypeElement _referencedElement = reference.getReferencedElement();
    if ((_referencedElement instanceof Attribute)) {
      VariableTypeElement _referencedElement_1 = reference.getReferencedElement();
      Attribute attr = ((Attribute) _referencedElement_1);
      if (((attr.eContainer() instanceof TypeSpecification) && Objects.equal(this.getViewInstanceIfExists(reference), null))) {
        String _firstUpper = StringExtensions.toFirstUpper(reference.getReferencedElement().getName());
        String _plus = ("get" + _firstUpper);
        String _plus_1 = (_plus + "()");
        str = _plus_1;
      }
      EObject _eContainer = reference.eContainer().eContainer();
      if ((_eContainer instanceof Assignment)) {
        EObject _eContainer_1 = reference.eContainer().eContainer();
        Assignment assignment = ((Assignment) _eContainer_1);
        Expression _left = assignment.getLeft();
        EObject _eContainer_2 = reference.eContainer();
        boolean _equals = ((VariableReference) _left).getReferencedElement().getName().equals(
          ((VariableReference) _eContainer_2).getReferencedElement().getName());
        if (_equals) {
          String _firstUpper_1 = StringExtensions.toFirstUpper(reference.getReferencedElement().getName());
          String _plus_2 = ("set" + _firstUpper_1);
          str = _plus_2;
        } else {
          Expression _right = assignment.getRight();
          EObject _eContainer_3 = reference.eContainer();
          boolean _equals_1 = ((VariableReference) _right).getReferencedElement().getName().equals(
            ((VariableReference) _eContainer_3).getReferencedElement().getName());
          if (_equals_1) {
            String _firstUpper_2 = StringExtensions.toFirstUpper(reference.getReferencedElement().getName());
            String _plus_3 = ("get" + _firstUpper_2);
            String _plus_4 = (_plus_3 + "()");
            str = _plus_4;
          }
        }
      }
    } else {
      VariableTypeElement _referencedElement_2 = reference.getReferencedElement();
      if ((_referencedElement_2 instanceof EnumItem)) {
        str = reference.getReferencedElement().getName().toUpperCase();
      }
    }
    if ((show instanceof Show)) {
      Parameter param = null;
      Expression _expression = ((Show)show).getExpression();
      EList<Parameter> _parameters = this._ismlModelNavigation.getTypeSpecification(((ViewInstance) _expression).getType()).getParameters();
      for (final Parameter methodParam : _parameters) {
        if ((this._ismlModelNavigation.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(reference.getReferencedElement().getType())).equals(
          this._ismlModelNavigation.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(methodParam.getType()))) || (!Objects.equal(reference.getTail(), null)))) {
          boolean _evaluateReference = this.evaluateReference(reference);
          if (_evaluateReference) {
            param = methodParam;
          }
          boolean _equals_2 = Objects.equal(param, null);
          if (_equals_2) {
            Reference<? extends NamedElement> _tail = reference.getTail();
            boolean _notEquals = (!Objects.equal(_tail, null));
            if (_notEquals) {
              param = methodParam;
            }
          }
        }
      }
      boolean _notEquals_1 = (!Objects.equal(param, null));
      if (_notEquals_1) {
        String cast = "";
        EList<Object> retData = this.evaluateToCastShowParameter(param, reference);
        Object _get = retData.get(0);
        if ((((Boolean) _get)).booleanValue()) {
          String _string = retData.get(1).toString();
          String _plus_5 = ("(" + _string);
          String _plus_6 = (_plus_5 + ")");
          cast = _plus_6;
        }
        String _name = param.getName();
        String _plus_7 = ("this." + _name);
        String _plus_8 = (_plus_7 + "=");
        String _plus_9 = (_plus_8 + cast);
        String _plus_10 = (_plus_9 + str);
        str = _plus_10;
      } else {
        return "";
      }
    }
    Reference<? extends NamedElement> r = reference.getTail();
    while ((!Objects.equal(r, null))) {
      {
        String _str = str;
        CharSequence _writeReference = this.writeReference(r);
        String _plus_11 = ("." + _writeReference);
        str = (_str + _plus_11);
        r = r.getTail();
      }
    }
    return str;
  }
  
  protected CharSequence _writeReference(final Type reference) {
    String text = null;
    if (((reference.getReferencedElement() instanceof Entity) && Objects.equal(reference.getTail(), null))) {
      String _firstUpper = StringExtensions.toFirstUpper(reference.getReferencedElement().getName());
      String _plus = (_firstUpper + ".class");
      text = _plus;
    } else {
      text = StringExtensions.toFirstUpper(reference.getReferencedElement().getName());
      Reference<? extends NamedElement> _tail = reference.getTail();
      boolean _notEquals = (!Objects.equal(_tail, null));
      if (_notEquals) {
        String _text = text;
        CharSequence _writeReference = this.writeReference(reference.getTail());
        String _plus_1 = ("." + _writeReference);
        text = (_text + _plus_1);
      }
    }
    return text;
  }
  
  public boolean evaluateReference(final Reference parameter) {
    boolean pass = true;
    NamedElement _referencedElement = parameter.getReferencedElement();
    if ((_referencedElement instanceof Parameter)) {
      Action _actionIfExists = this.getActionIfExists(parameter);
      boolean _notEquals = (!Objects.equal(_actionIfExists, null));
      if (_notEquals) {
        Controller controller = this._ismlModelNavigation.getControllerIfExists(parameter.eContainer());
        Object _get = this._ismlModelNavigation.getNeededAttributes(controller).get("neededAttributes");
        Map<String, Type> attributesMap = ((Map<String, Type>) _get);
        if ((attributesMap.containsKey(((Parameter) parameter.getReferencedElement()).getName()) && Objects.equal(parameter.getTail(), null))) {
          pass = false;
        }
      }
    }
    return pass;
  }
  
  public Action getActionIfExists(final EObject o) {
    Action a = null;
    EObject tmp = o;
    while (((!Objects.equal(tmp, null)) && Objects.equal(a, null))) {
      {
        if (((!Objects.equal(tmp.eContainer(), null)) && (tmp.eContainer() instanceof Action))) {
          EObject _eContainer = tmp.eContainer();
          a = ((Action) _eContainer);
        }
        tmp = tmp.eContainer();
      }
    }
    return a;
  }
  
  public EList<Object> evaluateToCastShowParameter(final Parameter param, final Reference reference) {
    boolean doCast = false;
    Controller _findAncestor = this._ismlModelNavigation.<Reference, Controller>findAncestor(reference, Controller.class);
    Object _get = this._ismlModelNavigation.getNeededAttributes(((Controller) _findAncestor)).get("neededAttributes");
    Map<String, Type> neededAttributes = ((Map<String, Type>) _get);
    Type tailType = this._ismlModelNavigation.getTailType(reference);
    EList<Object> returnData = new BasicEList<Object>();
    String castText = "";
    doCast = ((!this.isDescendentOf(tailType, this._ismlModelNavigation.getTypeSpecification(param.getType()))) && (!this._ismlModelNavigation.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(tailType)).equalsIgnoreCase(this._ismlModelNavigation.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(neededAttributes.get(param.getName()))))));
    if (doCast) {
      if (((tailType instanceof ParameterizedType) && (neededAttributes.get(param.getName()) instanceof ParameterizedType))) {
        Type _get_1 = neededAttributes.get(param.getName());
        boolean _equalsIgnoreCase = this._ismlModelNavigation.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(((ParameterizedType) tailType).getTypeParameters().get(0))).equalsIgnoreCase(this._ismlModelNavigation.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(((ParameterizedType) _get_1).getTypeParameters().get(0))));
        boolean _not = (!_equalsIgnoreCase);
        doCast = _not;
        if (doCast) {
          castText = this._ismlModelNavigation.writeType(tailType, false);
        }
      }
    }
    if ((doCast && castText.equals(""))) {
      TypeSpecification _typeSpecification = this._ismlModelNavigation.getTypeSpecification(tailType);
      if ((_typeSpecification instanceof GenericTypeSpecification)) {
        doCast = false;
      } else {
        castText = this._ismlModelNavigation.writeType(tailType, true);
      }
    }
    returnData.add(Boolean.valueOf(doCast));
    returnData.add(castText);
    return returnData;
  }
  
  public boolean isDescendentOf(final Type type, final TypeSpecification ts) {
    EList<Type> _superTypes = this._ismlModelNavigation.getTypeSpecification(type).getSuperTypes();
    for (final Type superType : _superTypes) {
      boolean _equalsIgnoreCase = this._ismlModelNavigation.getTypeSpecification(superType).getName().equalsIgnoreCase(ts.getName());
      if (_equalsIgnoreCase) {
        return true;
      }
    }
    return false;
  }
  
  public CharSequence writeReference(final Reference<? extends NamedElement> reference) {
    if (reference instanceof ActionCall) {
      return _writeReference((ActionCall)reference);
    } else if (reference instanceof MethodCall) {
      return _writeReference((MethodCall)reference);
    } else if (reference instanceof ResourceReference) {
      return _writeReference((ResourceReference)reference);
    } else if (reference instanceof Type) {
      return _writeReference((Type)reference);
    } else if (reference instanceof VariableReference) {
      return _writeReference((VariableReference)reference);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(reference).toString());
    }
  }
}
