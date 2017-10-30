package co.edu.javeriana.generator.genionic.templates;

import co.edu.javeriana.generator.genionic.templates.ControllerTemplate;
import co.edu.javeriana.isml.isml.Action;
import co.edu.javeriana.isml.isml.ActionCall;
import co.edu.javeriana.isml.isml.Attribute;
import co.edu.javeriana.isml.isml.BoolValue;
import co.edu.javeriana.isml.isml.Entity;
import co.edu.javeriana.isml.isml.Expression;
import co.edu.javeriana.isml.isml.FloatValue;
import co.edu.javeriana.isml.isml.IntValue;
import co.edu.javeriana.isml.isml.Method;
import co.edu.javeriana.isml.isml.MethodCall;
import co.edu.javeriana.isml.isml.NamedElement;
import co.edu.javeriana.isml.isml.NullValue;
import co.edu.javeriana.isml.isml.Parameter;
import co.edu.javeriana.isml.isml.ParameterizedReference;
import co.edu.javeriana.isml.isml.Reference;
import co.edu.javeriana.isml.isml.Service;
import co.edu.javeriana.isml.isml.Show;
import co.edu.javeriana.isml.isml.StringValue;
import co.edu.javeriana.isml.isml.TypeSpecification;
import co.edu.javeriana.isml.isml.Variable;
import co.edu.javeriana.isml.isml.VariableReference;
import co.edu.javeriana.isml.isml.VariableTypeElement;
import co.edu.javeriana.isml.isml.ViewInstance;
import co.edu.javeriana.isml.isml.impl.IntValueImpl;
import co.edu.javeriana.isml.scoping.IsmlModelNavigation;
import co.edu.javeriana.isml.validation.TypeChecker;
import com.google.common.base.CaseFormat;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ExtraGenionic {
  @Inject
  @Extension
  private IsmlModelNavigation _ismlModelNavigation;
  
  @Inject
  @Extension
  private TypeChecker _typeChecker;
  
  private ControllerTemplate controllerTemplate;
  
  public ControllerTemplate setControllerTemplate(final ControllerTemplate ct) {
    return this.controllerTemplate = ct;
  }
  
  public CharSequence getValue(final Expression e) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (e instanceof BoolValue) {
      _matched=true;
      _switchResult = ((BoolValue)e).getLiteral().toString();
    }
    if (!_matched) {
      if (e instanceof FloatValue) {
        _matched=true;
        _switchResult = ((FloatValue)e).getLiteral().toString();
      }
    }
    if (!_matched) {
      if (e instanceof IntValueImpl) {
        _matched=true;
        _switchResult = ((IntValueImpl)e).getLiteral().toString();
      }
    }
    if (!_matched) {
      if (e instanceof IntValue) {
        _matched=true;
        _switchResult = ((IntValue)e).getLiteral().toString();
      }
    }
    if (!_matched) {
      if (e instanceof NullValue) {
        _matched=true;
        _switchResult = "undefined";
      }
    }
    if (!_matched) {
      if (e instanceof StringValue) {
        _matched=true;
        String _string = ((StringValue)e).getLiteral().toString();
        String _plus = ("\"" + _string);
        _switchResult = (_plus + "\"");
      }
    }
    if (!_matched) {
      if (e instanceof MethodCall) {
        _matched=true;
        _switchResult = "call";
      }
    }
    if (!_matched) {
      if (e instanceof VariableReference) {
        _matched=true;
        CharSequence _xifexpression = null;
        boolean _hasTail = this.hasTail(((Reference)e));
        if (_hasTail) {
          _xifexpression = this.generateTailedElement(((VariableReference)e));
        } else {
          _xifexpression = ((VariableReference)e).getReferencedElement().getName();
        }
        _switchResult = _xifexpression;
      }
    }
    if (!_matched) {
      _switchResult = e.toString();
    }
    return _switchResult;
  }
  
  public boolean hasTail(final Reference r) {
    Reference _tail = r.getTail();
    boolean _notEquals = (!Objects.equal(_tail, null));
    if (_notEquals) {
      return true;
    } else {
      return false;
    }
  }
  
  public CharSequence generateTailedElement(final VariableReference vr) {
    String accumulate = "";
    if ((((vr.getReferencedElement() instanceof Attribute) || (vr.getReferencedElement() instanceof Method)) || (vr.getReferencedElement().getType().getReferencedElement() instanceof Service))) {
      String _accumulate = accumulate;
      accumulate = (_accumulate + "this.");
    }
    String str = this.generateReferencedElement(vr).toString();
    String _accumulate_1 = accumulate;
    accumulate = (_accumulate_1 + str);
    Reference<? extends NamedElement> current = vr.getTail();
    while ((!Objects.equal(current, null))) {
      {
        String _accumulate_2 = accumulate;
        CharSequence _generateReferencedElement = this.generateReferencedElement(current);
        String _plus = ("." + _generateReferencedElement);
        accumulate = (_accumulate_2 + _plus);
        current = current.getTail();
      }
    }
    return accumulate;
  }
  
  public CharSequence generateReferencedElement(final Reference reference) {
    CharSequence _switchResult = null;
    NamedElement _referencedElement = reference.getReferencedElement();
    boolean _matched = false;
    if (_referencedElement instanceof Attribute) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      String _name = reference.getReferencedElement().getName();
      _builder.append(_name);
      _switchResult = _builder;
    }
    if (!_matched) {
      if (_referencedElement instanceof Variable) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _name = reference.getReferencedElement().getName();
        _builder.append(_name);
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (_referencedElement instanceof Parameter) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _name = reference.getReferencedElement().getName();
        _builder.append(_name);
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (_referencedElement instanceof Method) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _name = reference.getReferencedElement().getName();
        _builder.append(_name);
        _builder.append("(");
        CharSequence _parameters = this.getParameters(((ParameterizedReference) reference));
        _builder.append(_parameters);
        _builder.append(")");
        CharSequence _addComplements = this.addComplements(reference);
        _builder.append(_addComplements);
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      _switchResult = reference.toString();
    }
    return _switchResult;
  }
  
  /**
   * Adiciona elementos al metodo
   */
  public CharSequence addComplements(final Reference reference) {
    Action action = this._ismlModelNavigation.getActionRecursivelly(reference);
    Iterable<Show> allShow = this._ismlModelNavigation.getShowStatements(action);
    String lastShow = "";
    for (final Show e : allShow) {
      if ((e instanceof Show)) {
        this.controllerTemplate.lastShowMethod = e;
        final Expression expression = e.getExpression();
        if ((expression instanceof ViewInstance)) {
          String _firstUpper = StringExtensions.toFirstUpper(this._ismlModelNavigation.getTypeSpecification(((ViewInstance)expression).getType()).getName().toLowerCase());
          int _length = this._ismlModelNavigation.getTypeSpecification(((ViewInstance)expression).getType()).getName().length();
          int _minus = (_length - 1);
          String _substring = _firstUpper.substring(0, _minus);
          String _plus = ("return this.navCtrl.push(" + _substring);
          String _plus_1 = (_plus + "cPage, ");
          CharSequence _generateArray = this.generateArray(((ViewInstance)expression));
          String _plus_2 = (_plus_1 + _generateArray);
          String _plus_3 = (_plus_2 + ");");
          lastShow = _plus_3;
        }
      }
    }
    String str = "";
    final String[] options = { "remove", "create", "find", "save" };
    int _size = ((List<String>)Conversions.doWrapArray(options)).size();
    ExclusiveRange _greaterThanDoubleDot = new ExclusiveRange(_size, 0, false);
    for (final Integer i : _greaterThanDoubleDot) {
      boolean _equals = reference.getReferencedElement().getName().toLowerCase().equals(options[(i).intValue()]);
      if (_equals) {
        str = ((".then((r)=>{" + lastShow) + "}).catch(error =>{alert(error)});");
      }
    }
    return str;
  }
  
  public CharSequence getParameters(final ParameterizedReference<?> reference) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _size = reference.getParameters().size();
      boolean _notEquals = (_size != 0);
      if (_notEquals) {
        {
          EList<Expression> _parameters = reference.getParameters();
          boolean _hasElements = false;
          for(final Expression param : _parameters) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",", "");
            }
            CharSequence _value = this.getValue(param);
            _builder.append(_value);
          }
        }
      }
    }
    return _builder;
  }
  
  public String toSnakeCase(final String string) {
    return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, string);
  }
  
  public String toKebabCase(final String string) {
    return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_HYPHEN, string);
  }
  
  public CharSequence valueTemplateForEntities(final Expression e) {
    if ((e instanceof VariableReference)) {
      TypeSpecification _referencedElement = ((VariableReference)e).getReferencedElement().getType().getReferencedElement();
      if ((_referencedElement instanceof Entity)) {
        StringConcatenation _builder = new StringConcatenation();
        {
          boolean _hasTail = this.hasTail(((Reference)e));
          if (_hasTail) {
            CharSequence _generateTailedElement = this.generateTailedElement(((VariableReference)e));
            _builder.append(_generateTailedElement);
          } else {
            String _name = ((VariableReference)e).getReferencedElement().getName();
            _builder.append(_name);
          }
        }
        _builder.append(".id");
        return _builder;
      }
    }
    return this.getValue(e);
  }
  
  public CharSequence generateParametersActionCall(final ActionCall call) {
    StringConcatenation _builder = new StringConcatenation();
    String generatedParameters = _builder.toString();
    int _size = call.getParameters().size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      StringConcatenation _builder_1 = new StringConcatenation();
      {
        EList<Expression> _parameters = call.getParameters();
        for(final Expression param : _parameters) {
          _builder_1.append("{{");
          CharSequence _valueTemplateForEntities = this.valueTemplateForEntities(param);
          _builder_1.append(_valueTemplateForEntities);
          _builder_1.append("}}");
        }
      }
      generatedParameters = _builder_1.toString();
    }
    return generatedParameters;
  }
  
  /**
   * Obtiene los parametros enviados a una vista
   */
  public CharSequence generateArray(final ViewInstance instance) {
    String accumulate = "";
    String string = "";
    int _size = instance.getParameters().size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        Expression valor = instance.getParameters().get((i).intValue());
        CharSequence name = this.getValue(valor);
        if ((name instanceof String)) {
          if (((!((String)name).equalsIgnoreCase("undefined")) && (!StringExtensions.isNullOrEmpty(((String)name))))) {
            String _accumulate = accumulate;
            CharSequence _typeParameter = this.typeParameter(valor);
            String _plus = ((((String)name) + ":") + _typeParameter);
            String _plus_1 = (_plus + "");
            String _plus_2 = (_plus_1 + ((String)name));
            String _plus_3 = (_plus_2 + ", ");
            accumulate = (_accumulate + _plus_3);
          }
        }
      }
    }
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(accumulate);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      int _length = accumulate.length();
      int _minus = (_length - 2);
      accumulate = accumulate.substring(0, _minus);
    }
    string = (("{" + accumulate) + "}");
    return string;
  }
  
  /**
   * Identifica si es un atributo de la clase o si es una variable del método
   */
  public CharSequence typeParameter(final Expression e) {
    CharSequence _xblockexpression = null;
    {
      String type = "";
      if ((e instanceof VariableReference)) {
        TypeSpecification _referencedElement = ((VariableReference)e).getReferencedElement().getType().getReferencedElement();
        boolean _matched = false;
        if (_referencedElement instanceof Service) {
          _matched=true;
          type = "this.";
        }
        if (!_matched) {
          if (_referencedElement instanceof Attribute) {
            _matched=true;
            type = "this.";
          }
        }
        if (!_matched) {
          VariableTypeElement _referencedElement_1 = ((VariableReference)e).getReferencedElement();
          boolean _matched_1 = false;
          if (_referencedElement_1 instanceof Attribute) {
            _matched_1=true;
            type = "this.";
          }
          if (!_matched_1) {
            if (_referencedElement_1 instanceof Service) {
              _matched_1=true;
              type = "this.";
            }
          }
          if (!_matched_1) {
            type = "";
          }
        }
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(type);
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence generateType(final String t) {
    String type = "";
    if (t != null) {
      switch (t) {
        case "String":
          type = "string";
          break;
        case "Integer":
          type = "number";
          break;
        case "Boolean":
          type = "boolean";
          break;
        case "Long":
          type = "number";
          break;
        case "Array":
          type = "any=[]";
          break;
        case "Any":
          type = "any";
          break;
        case "List":
          type = "any";
          break;
        case "BytesArray":
          type = "string";
          break;
        default:
          type = t;
          break;
      }
    } else {
      type = t;
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(type);
    return _builder;
  }
}
