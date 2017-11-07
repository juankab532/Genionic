package co.edu.javeriana.isml.validation;

import co.edu.javeriana.isml.isml.BinaryOperator;
import co.edu.javeriana.isml.isml.BoolValue;
import co.edu.javeriana.isml.isml.Caller;
import co.edu.javeriana.isml.isml.Entity;
import co.edu.javeriana.isml.isml.EnumItem;
import co.edu.javeriana.isml.isml.Expression;
import co.edu.javeriana.isml.isml.FloatValue;
import co.edu.javeriana.isml.isml.Function;
import co.edu.javeriana.isml.isml.Instance;
import co.edu.javeriana.isml.isml.IntValue;
import co.edu.javeriana.isml.isml.Method;
import co.edu.javeriana.isml.isml.MethodCall;
import co.edu.javeriana.isml.isml.NamedElement;
import co.edu.javeriana.isml.isml.NamedViewBlock;
import co.edu.javeriana.isml.isml.NullValue;
import co.edu.javeriana.isml.isml.Page;
import co.edu.javeriana.isml.isml.Parameter;
import co.edu.javeriana.isml.isml.ParameterizedType;
import co.edu.javeriana.isml.isml.Primitive;
import co.edu.javeriana.isml.isml.Reference;
import co.edu.javeriana.isml.isml.Resource;
import co.edu.javeriana.isml.isml.StringValue;
import co.edu.javeriana.isml.isml.Type;
import co.edu.javeriana.isml.isml.TypeSpecification;
import co.edu.javeriana.isml.isml.TypedElement;
import co.edu.javeriana.isml.isml.UnaryOperator;
import co.edu.javeriana.isml.scoping.IsmlModelNavigation;
import co.edu.javeriana.isml.validation.Generics;
import co.edu.javeriana.isml.validation.TypeFactory;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class TypeChecker {
  @Inject
  @Extension
  private IsmlModelNavigation _ismlModelNavigation;
  
  @Inject
  @Extension
  private Generics _generics;
  
  @Inject
  @Extension
  private TypeFactory _typeFactory;
  
  public boolean isCongruentWith(final Function callee, final Caller caller) {
    final EList<Expression> realParameters = caller.getParameters();
    final int realSize = realParameters.size();
    final EList<Parameter> formalParameters = callee.getParameters();
    final int formalSize = formalParameters.size();
    if ((realSize != formalSize)) {
      return false;
    }
    final Map<Type, Type> typeSubstitutions = this._generics.getTypeSubstitutions(callee, caller);
    for (int i = 0; (i < realSize); i++) {
      {
        final Expression realParam = realParameters.get(i);
        final Parameter formalParam = formalParameters.get(i);
        try {
          final Type realType = this.getType(realParam);
          final Type formalType = formalParam.getType();
          final Type instantiatedType = this._generics.instantiate(formalType, typeSubstitutions);
          if (((!Objects.equal(instantiatedType, null)) && (!this.isAssignableFrom(instantiatedType, realType)))) {
            return false;
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
    return true;
  }
  
  public Iterable<? extends Function> filterCongruent(final Iterable<? extends Function> callees, final Caller caller) {
    boolean _isEmpty = caller.getParameters().isEmpty();
    if (_isEmpty) {
      return callees;
    } else {
      final Function1<Function, Boolean> _function = (Function f) -> {
        return Boolean.valueOf(this.isCongruentWith(f, caller));
      };
      return IterableExtensions.filter(callees, _function);
    }
  }
  
  public boolean isCollection(final Type type) {
    return this._ismlModelNavigation.isSubtypeSpecificationOf(this._ismlModelNavigation.getTypeSpecification(type), this._typeFactory.getPrimitiveTypeSpecification(type.eResource(), "Collection"));
  }
  
  public boolean isMapModel(final Type type) {
    return this._ismlModelNavigation.isSubtypeSpecificationOf(this._ismlModelNavigation.getTypeSpecification(type), this._typeFactory.getPrimitiveTypeSpecification(type.eResource(), "MapModel"));
  }
  
  public boolean isAssignableFrom(final Type t1, final Type t2) {
    if ((Objects.equal(t1, null) || Objects.equal(t2, null))) {
      return false;
    }
    if (((!Objects.equal(this._ismlModelNavigation.getTypeSpecification(t1), null)) && (!Objects.equal(this._ismlModelNavigation.getTypeSpecification(t2), null)))) {
      return (this.isParentOf(this._ismlModelNavigation.getTypeSpecification(t1), this._ismlModelNavigation.getTypeSpecification(t2)) && this.typeParametersAreAssignable(t1, t2));
    } else {
      return EcoreUtil2.equals(t1, t2);
    }
  }
  
  public boolean typeParametersAreAssignable(final Type type1, final Type type2) {
    if ((type1 instanceof ParameterizedType)) {
      if ((type2 instanceof ParameterizedType)) {
        int _size = ((ParameterizedType)type1).getTypeParameters().size();
        ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
        for (final Integer i : _doubleDotLessThan) {
          {
            final Type typeParam1 = ((ParameterizedType)type1).getTypeParameters().get(0);
            final Type typeParam2 = ((ParameterizedType)type2).getTypeParameters().get(0);
            boolean _isAssignableFrom = this.isAssignableFrom(typeParam1, typeParam2);
            boolean _not = (!_isAssignableFrom);
            if (_not) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }
  
  public boolean isParentOf(final TypeSpecification c1, final TypeSpecification c2) {
    if ((Objects.equal(c1, null) || Objects.equal(c2, null))) {
      return false;
    }
    if (((c1 instanceof Entity) || (c1 instanceof Primitive))) {
      if (("Any".equals(c1.getName()) || "Null".equals(c2.getName()))) {
        return true;
      }
    }
    if ((c1 instanceof Page)) {
      boolean _equals = "AnyPage".equals(((Page)c1).getName());
      if (_equals) {
        return true;
      }
    }
    return this.findIsParentOf(c1, c2);
  }
  
  private boolean findIsParentOf(final TypeSpecification c1, final TypeSpecification c2) {
    boolean _notEquals = (!Objects.equal(c2, null));
    if (_notEquals) {
      boolean _equals = EcoreUtil2.equals(c1, c2);
      if (_equals) {
        return true;
      } else {
        EList<Type> _superTypes = c2.getSuperTypes();
        for (final Type superType : _superTypes) {
          boolean _findIsParentOf = this.findIsParentOf(c1, this._ismlModelNavigation.getTypeSpecification(superType));
          if (_findIsParentOf) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public Type maxType(final Type type, final Type type2) {
    return type;
  }
  
  protected Type _getType(final UnaryOperator exp) {
    return this.getType(exp.getExpression());
  }
  
  protected Type _getType(final NullValue exp) {
    return this._typeFactory.getPrimitiveType(exp.eResource(), "Null");
  }
  
  protected Type _getType(final BinaryOperator exp) {
    Type _switchResult = null;
    String _symbol = exp.getSymbol();
    if (_symbol != null) {
      switch (_symbol) {
        case "as":
          Expression _right = exp.getRight();
          _switchResult = ((Type) _right);
          break;
        case "is":
          _switchResult = this._typeFactory.getPrimitiveType(exp.eResource(), "Boolean");
          break;
        default:
          _switchResult = this.maxType(this.getType(exp.getLeft()), this.getType(exp.getRight()));
          break;
      }
    } else {
      _switchResult = this.maxType(this.getType(exp.getLeft()), this.getType(exp.getRight()));
    }
    return _switchResult;
  }
  
  protected Type _getType(final Reference r) {
    Reference current = r;
    while ((!Objects.equal(current.getTail(), null))) {
      current = current.getTail();
    }
    final NamedElement element = current.getReferencedElement();
    EcoreUtil2.resolve(element, r.eResource().getResourceSet());
    if ((element instanceof Resource)) {
      return this._typeFactory.getPrimitiveType(((Resource)element).eResource(), "String");
    } else {
      if ((current instanceof Type)) {
        return this._typeFactory.getPrimitiveType(((Type)current).eResource(), "Type");
      } else {
        if ((current instanceof MethodCall)) {
          return this.getType(current);
        } else {
          return this.getType(element);
        }
      }
    }
  }
  
  protected Type _getType(final BoolValue exp) {
    return this._typeFactory.getPrimitiveType(exp.eResource(), "Boolean");
  }
  
  protected Type _getType(final StringValue exp) {
    return this._typeFactory.getPrimitiveType(exp.eResource(), "String");
  }
  
  protected Type _getType(final IntValue exp) {
    return this._typeFactory.getPrimitiveType(exp.eResource(), "Integer");
  }
  
  protected Type _getType(final FloatValue exp) {
    return this._typeFactory.getPrimitiveType(exp.eResource(), "Float");
  }
  
  protected Type _getType(final Instance exp) {
    return exp.getType();
  }
  
  protected Type _getType(final Type exp) {
    return this._typeFactory.getPrimitiveType(exp.eResource(), "Type", exp);
  }
  
  protected Type _getType(final NamedViewBlock exp) {
    return this._typeFactory.getPrimitiveType(exp.eResource(), "Block");
  }
  
  protected Type _getType(final MethodCall caller) {
    Method _referencedElement = caller.getReferencedElement();
    final Method callee = ((Method) _referencedElement);
    final Map<Type, Type> typeSubstitutions = this._generics.getTypeSubstitutions(callee, caller);
    return this._generics.instantiate(callee.getType(), typeSubstitutions);
  }
  
  protected Type _getType(final EnumItem exp) {
    return this.getType(exp.eContainer());
  }
  
  protected Type _getType(final TypedElement te) {
    return te.getType();
  }
  
  /**
   * If a's type is a ParameterizedType, obtains the first type parameter of the type of a.
   * Otherwise it returns null
   */
  public TypeSpecification containedTypeSpecification(final Type type) {
    if ((type instanceof ParameterizedType)) {
      Type _head = IterableExtensions.<Type>head(((ParameterizedType)type).getTypeParameters());
      TypeSpecification _typeSpecification = null;
      if (_head!=null) {
        _typeSpecification=this._ismlModelNavigation.getTypeSpecification(_head);
      }
      return _typeSpecification;
    }
    return null;
  }
  
  public Type getType(final EObject caller) {
    if (caller instanceof MethodCall) {
      return _getType((MethodCall)caller);
    } else if (caller instanceof EnumItem) {
      return _getType((EnumItem)caller);
    } else if (caller instanceof NamedViewBlock) {
      return _getType((NamedViewBlock)caller);
    } else if (caller instanceof Type) {
      return _getType((Type)caller);
    } else if (caller instanceof Instance) {
      return _getType((Instance)caller);
    } else if (caller instanceof Reference) {
      return _getType((Reference)caller);
    } else if (caller instanceof BoolValue) {
      return _getType((BoolValue)caller);
    } else if (caller instanceof FloatValue) {
      return _getType((FloatValue)caller);
    } else if (caller instanceof IntValue) {
      return _getType((IntValue)caller);
    } else if (caller instanceof NullValue) {
      return _getType((NullValue)caller);
    } else if (caller instanceof StringValue) {
      return _getType((StringValue)caller);
    } else if (caller instanceof TypedElement) {
      return _getType((TypedElement)caller);
    } else if (caller instanceof BinaryOperator) {
      return _getType((BinaryOperator)caller);
    } else if (caller instanceof UnaryOperator) {
      return _getType((UnaryOperator)caller);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(caller).toString());
    }
  }
}
