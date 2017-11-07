package co.edu.javeriana.isml.validation;

import co.edu.javeriana.isml.isml.Assignment;
import co.edu.javeriana.isml.isml.Caller;
import co.edu.javeriana.isml.isml.CompositeElement;
import co.edu.javeriana.isml.isml.Entity;
import co.edu.javeriana.isml.isml.Expression;
import co.edu.javeriana.isml.isml.Function;
import co.edu.javeriana.isml.isml.Instance;
import co.edu.javeriana.isml.isml.IsmlPackage;
import co.edu.javeriana.isml.isml.NamedElement;
import co.edu.javeriana.isml.isml.Parameter;
import co.edu.javeriana.isml.isml.ParameterizedReference;
import co.edu.javeriana.isml.isml.ParameterizedType;
import co.edu.javeriana.isml.isml.Reference;
import co.edu.javeriana.isml.isml.Type;
import co.edu.javeriana.isml.isml.TypeSpecification;
import co.edu.javeriana.isml.isml.Variable;
import co.edu.javeriana.isml.isml.ViewStatement;
import co.edu.javeriana.isml.isml.Widget;
import co.edu.javeriana.isml.scoping.IsmlModelNavigation;
import co.edu.javeriana.isml.validation.AbstractIsmlValidator;
import co.edu.javeriana.isml.validation.Generics;
import co.edu.javeriana.isml.validation.NamesAreUniqueValidator;
import co.edu.javeriana.isml.validation.TypeChecker;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * Custom validation rules.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
@ComposedChecks(validators = { NamesAreUniqueValidator.class })
@SuppressWarnings("all")
public class IsmlValidator extends AbstractIsmlValidator {
  @Inject
  @Extension
  private TypeChecker typeChecker;
  
  @Inject
  @Extension
  private IsmlModelNavigation _ismlModelNavigation;
  
  @Inject
  @Extension
  private Generics _generics;
  
  @Check
  public void instanceParametersMustMatchTypeArguments(final Instance instance) {
    final TypeSpecification typeSpecification = this._ismlModelNavigation.getTypeSpecification(instance.getType());
    this.checkParameters(instance, typeSpecification, IsmlPackage.Literals.TYPED_ELEMENT__TYPE);
    if ((typeSpecification instanceof Widget)) {
      this.checkBlockParameters(((CompositeElement<ViewStatement>) instance), 
        ((CompositeElement<ViewStatement>) typeSpecification));
    }
  }
  
  @Check
  public void functionCallParametersMustMatchFunctionArguments(final Reference<?> caller) {
    final NamedElement callee = caller.getReferencedElement();
    if (((caller instanceof ParameterizedReference<?>) && (callee instanceof Function))) {
      this.checkParameters(((Caller) caller), ((Function) callee), 
        caller.eClass().getEStructuralFeature("referencedElement"));
    }
  }
  
  public void checkBlockParameters(final CompositeElement<ViewStatement> instance, final CompositeElement<ViewStatement> widget) {
    try {
      try {
        boolean _and = false;
        if (!(widget.isHasBody() && (!instance.isHasBody()))) {
          _and = false;
        } else {
          EList<ViewStatement> _body = instance.getBody();
          int _size = 0;
          if (_body!=null) {
            _size=_body.size();
          }
          boolean _equals = (_size == 0);
          _and = _equals;
        }
        if (_and) {
          this.error("This widget must have a body", instance, IsmlPackage.Literals.COMPOSITE_ELEMENT__BODY);
          return;
        }
        EList<ViewStatement> _body_1 = widget.getBody();
        int _size_1 = 0;
        if (_body_1!=null) {
          _size_1=_body_1.size();
        }
        final int widgetBodySize = _size_1;
        EList<ViewStatement> _body_2 = instance.getBody();
        int _size_2 = 0;
        if (_body_2!=null) {
          _size_2=_body_2.size();
        }
        final int instanceBodySize = _size_2;
        if ((widgetBodySize > 0)) {
          if ((widgetBodySize != instanceBodySize)) {
            this.error("Incorrect body parameters", instance, IsmlPackage.Literals.COMPOSITE_ELEMENT__BODY);
          } else {
            ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, widgetBodySize, true);
            for (final Integer i : _doubleDotLessThan) {
              {
                final ViewStatement instanceElem = instance.getBody().get((i).intValue());
                final ViewStatement widgetElem = widget.getBody().get((i).intValue());
                TypeSpecification _typeSpecification = this._ismlModelNavigation.getTypeSpecification(this.typeChecker.getType(instanceElem));
                TypeSpecification _typeSpecification_1 = this._ismlModelNavigation.getTypeSpecification(this.typeChecker.getType(widgetElem));
                boolean _notEquals = (!Objects.equal(_typeSpecification, _typeSpecification_1));
                if (_notEquals) {
                  this.error("Incorrect body parameters", instance, IsmlPackage.Literals.COMPOSITE_ELEMENT__BODY);
                }
                if ((instanceElem instanceof NamedElement)) {
                  if ((widgetElem instanceof NamedElement)) {
                    String _elvis = null;
                    String _name = null;
                    if (((NamedElement)instanceElem)!=null) {
                      _name=((NamedElement)instanceElem).getName();
                    }
                    if (_name != null) {
                      _elvis = _name;
                    } else {
                      _elvis = "";
                    }
                    final String instanceElemName = _elvis;
                    String _elvis_1 = null;
                    String _name_1 = null;
                    if (((NamedElement)widgetElem)!=null) {
                      _name_1=((NamedElement)widgetElem).getName();
                    }
                    if (_name_1 != null) {
                      _elvis_1 = _name_1;
                    } else {
                      _elvis_1 = "";
                    }
                    final String widgetElemName = _elvis_1;
                    boolean _equals_1 = instanceElemName.equals(widgetElemName);
                    boolean _not = (!_equals_1);
                    if (_not) {
                      this.error("Incorrect body parameters", instance, 
                        IsmlPackage.Literals.COMPOSITE_ELEMENT__BODY);
                    }
                  }
                }
                if ((widgetElem instanceof CompositeElement<?>)) {
                  if ((instanceElem instanceof CompositeElement<?>)) {
                    this.checkBlockParameters(((CompositeElement<ViewStatement>) instanceElem), 
                      ((CompositeElement<ViewStatement>) widgetElem));
                  }
                }
              }
            }
          }
        }
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          e.printStackTrace();
          throw e;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void checkParameters(final Caller caller, final Function callee, final EStructuralFeature f) {
    if (((callee instanceof Entity) && caller.getParameters().isEmpty())) {
      return;
    }
    final String calleeName = callee.getName();
    final EList<Expression> realParameters = caller.getParameters();
    final int realSize = realParameters.size();
    String errorString = "";
    boolean hasErrors = false;
    int _size = callee.getParameters().size();
    boolean _notEquals = (realSize != _size);
    if (_notEquals) {
      int _size_1 = callee.getParameters().size();
      String _plus = ((("Wrong number of parameters " + calleeName) + " requires ") + Integer.valueOf(_size_1));
      String _plus_1 = (_plus + " arguments");
      this.error(_plus_1, caller, f);
      return;
    }
    final List<Parameter> formalParameters = this._generics.instantiateGenericParameters(callee, caller);
    for (int i = 0; (i < realSize); i++) {
      {
        final Expression realParam = realParameters.get(i);
        final Parameter formalParam = formalParameters.get(i);
        try {
          final Type realType = this.typeChecker.getType(realParam);
          final Type formalType = formalParam.getType();
          if (((!this.typeChecker.isAssignableFrom(formalType, realType)) && (!Objects.equal(realType, null)))) {
            String _errorString = errorString;
            TypeSpecification _typeSpecification = null;
            if (realType!=null) {
              _typeSpecification=this._ismlModelNavigation.getTypeSpecification(realType);
            }
            String _name = null;
            if (_typeSpecification!=null) {
              _name=_typeSpecification.getName();
            }
            String _plus_2 = ((("Parameter " + Integer.valueOf((i + 1))) + " of type ") + _name);
            String _plus_3 = (_plus_2 + " must be of type ");
            String _name_1 = this._ismlModelNavigation.getTypeSpecification(formalType).getName();
            String _plus_4 = (_plus_3 + _name_1);
            String _plus_5 = (_plus_4 + "\n");
            errorString = (_errorString + _plus_5);
            hasErrors = true;
          }
        } catch (final Throwable _t) {
          if (_t instanceof Throwable) {
            final Throwable t2 = (Throwable)_t;
            t2.printStackTrace();
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    }
    if (hasErrors) {
      this.error(("Incorrect parameters: \n" + errorString), caller, f);
    }
  }
  
  @Check
  public void validAssignment(final Assignment a) {
    final Type leftType = this.typeChecker.getType(a.getLeft());
    final Type rightType = this.typeChecker.getType(a.getRight());
    boolean _isAssignableFrom = this.typeChecker.isAssignableFrom(leftType, rightType);
    boolean _not = (!_isAssignableFrom);
    if (_not) {
      String _fullName = this._ismlModelNavigation.getFullName(rightType);
      String _plus = ("Cannot assign value of type " + _fullName);
      String _plus_1 = (_plus + " to variable ");
      Expression _left = a.getLeft();
      String _name = ((Reference<?>) _left).getReferencedElement().getName();
      String _plus_2 = (_plus_1 + _name);
      String _plus_3 = (_plus_2 + " of type ");
      String _fullName_1 = this._ismlModelNavigation.getFullName(leftType);
      String _plus_4 = (_plus_3 + _fullName_1);
      this.error(_plus_4, a, 
        IsmlPackage.Literals.BINARY_OPERATOR__RIGHT);
    }
  }
  
  @Check
  public void validVarDecl(final Variable v) {
    final Type leftType = v.getType();
    final Expression value = v.getValue();
    boolean _notEquals = (!Objects.equal(value, null));
    if (_notEquals) {
      final Type rightType = this.typeChecker.getType(value);
      boolean _isAssignableFrom = this.typeChecker.isAssignableFrom(leftType, rightType);
      boolean _not = (!_isAssignableFrom);
      if (_not) {
        String _fullName = this._ismlModelNavigation.getFullName(rightType);
        String _plus = ("Cannot assign value of type " + _fullName);
        String _plus_1 = (_plus + " to variable ");
        String _name = v.getName();
        String _plus_2 = (_plus_1 + _name);
        String _plus_3 = (_plus_2 + " of type ");
        String _fullName_1 = this._ismlModelNavigation.getFullName(leftType);
        String _plus_4 = (_plus_3 + _fullName_1);
        this.error(_plus_4, v, IsmlPackage.Literals.VARIABLE_TYPE_ELEMENT__VALUE);
      }
    }
  }
  
  @Check
  public void validGenericTypeInstantiation(final Type type) {
    boolean error = false;
    final int genericTypeParamSize = this._ismlModelNavigation.getTypeSpecification(type).getGenericTypeParameters().size();
    if ((type instanceof ParameterizedType)) {
      int _size = ((ParameterizedType)type).getTypeParameters().size();
      boolean _notEquals = (_size != genericTypeParamSize);
      if (_notEquals) {
        error = true;
      }
    } else {
      if ((genericTypeParamSize > 0)) {
        error = true;
      }
    }
    if (error) {
      String _name = this._ismlModelNavigation.getTypeSpecification(type).getName();
      String _plus = ("Wrong number of parameters. Type " + _name);
      String _plus_1 = (_plus + " must be extended with");
      String _plus_2 = (_plus_1 + Integer.valueOf(genericTypeParamSize));
      String _plus_3 = (_plus_2 + " parameters");
      this.error(_plus_3, type, 
        IsmlPackage.Literals.REFERENCE__REFERENCED_ELEMENT);
    }
  }
}
