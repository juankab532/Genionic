package co.edu.javeriana.isml.validation;

import co.edu.javeriana.isml.isml.Caller;
import co.edu.javeriana.isml.isml.Expression;
import co.edu.javeriana.isml.isml.Feature;
import co.edu.javeriana.isml.isml.Function;
import co.edu.javeriana.isml.isml.GenericTypeSpecification;
import co.edu.javeriana.isml.isml.Parameter;
import co.edu.javeriana.isml.isml.ParameterizedType;
import co.edu.javeriana.isml.isml.Type;
import co.edu.javeriana.isml.isml.TypeSpecification;
import co.edu.javeriana.isml.scoping.IsmlModelNavigation;
import co.edu.javeriana.isml.validation.TypeChecker;
import co.edu.javeriana.isml.validation.TypeFactory;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Generics {
  @Inject
  @Extension
  private TypeChecker _typeChecker;
  
  @Inject
  @Extension
  private IsmlModelNavigation _ismlModelNavigation;
  
  @Inject
  @Extension
  private TypeFactory _typeFactory;
  
  public Map<Type, Type> getTypeSubstitutions(final Function callee, final Caller caller) {
    final TreeMap<Type, Type> substitutions = new TreeMap<Type, Type>(new Comparator<Type>() {
      @Override
      public int compare(final Type t1, final Type t2) {
        return Generics.this._ismlModelNavigation.getFullName(t1).compareTo(Generics.this._ismlModelNavigation.getFullName(t2));
      }
    });
    if ((callee instanceof Feature)) {
      this.addTypeSubstitutions(substitutions, this._ismlModelNavigation.getContainerType(caller));
      final TypeSpecification calleeTypeSpec = this._ismlModelNavigation.getContainerTypeSpecification(((Feature)callee));
      final TypeSpecification callerTypeSpec = this._ismlModelNavigation.getContainerTypeSpecification(caller);
      TypeSpecification currentTypeSpec = callerTypeSpec;
      while (((!Objects.equal(currentTypeSpec, null)) && (!Objects.equal(currentTypeSpec, calleeTypeSpec)))) {
        {
          final Type parent = IterableExtensions.<Type>head(currentTypeSpec.getSuperTypes());
          this.addTypeSubstitutions(substitutions, parent);
          currentTypeSpec = this._ismlModelNavigation.getTypeSpecification(parent);
        }
      }
    }
    final int size = callee.getParameters().size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, size, true);
    for (final Integer i : _doubleDotLessThan) {
      this.addTypeSubstitutions(substitutions, callee.getParameters().get((i).intValue()), caller.getParameters().get((i).intValue()));
    }
    return substitutions;
  }
  
  public void addTypeSubstitutions(final Map<Type, Type> substitutions, final Type type) {
    if ((type instanceof ParameterizedType)) {
      final int size = ((ParameterizedType)type).getTypeParameters().size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, size, true);
      for (final Integer i : _doubleDotLessThan) {
        this.addTypeSubstitutions(substitutions, this._typeFactory.createType(this._ismlModelNavigation.getTypeSpecification(type)), type);
      }
    }
  }
  
  public void addTypeSubstitutions(final Map<Type, Type> substitutions, final Parameter formalParam, final Expression realParam) {
    final Type realParamType = this._typeChecker.getType(realParam);
    final Type formalParamType = formalParam.getType();
    this.addTypeSubstitutions(substitutions, formalParamType, realParamType);
  }
  
  public void addTypeSubstitutions(final Map<Type, Type> substitutions, final Type originType, final Type destinationType) {
    final TypeSpecification originTypeSpec = this._ismlModelNavigation.getTypeSpecification(originType);
    if (((originType instanceof ParameterizedType) && (destinationType instanceof ParameterizedType))) {
      this.addTypeSubstitutions(substitutions, ((ParameterizedType) originType), ((ParameterizedType) destinationType));
    } else {
      if ((originTypeSpec instanceof GenericTypeSpecification)) {
        this.addTypeSubstitution(substitutions, originType, destinationType);
      } else {
      }
    }
  }
  
  public void addTypeSubstitutions(final Map<Type, Type> substitutions, final ParameterizedType originType, final ParameterizedType destinationType) {
    final int size = originType.getTypeParameters().size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, size, true);
    for (final Integer i : _doubleDotLessThan) {
      this.addTypeSubstitutions(substitutions, originType.getTypeParameters().get((i).intValue()), destinationType.getTypeParameters().get((i).intValue()));
    }
  }
  
  public void addTypeSubstitution(final Map<Type, Type> substitutions, final Type originType, final Type destinationType) {
    boolean _containsKey = substitutions.containsKey(originType);
    boolean _not = (!_containsKey);
    if (_not) {
      substitutions.put(originType, destinationType);
    }
  }
  
  public List<Parameter> instantiateGenericParameters(final Function function, final Caller caller) {
    final Map<Type, Type> typeSubstitutions = this.getTypeSubstitutions(function, caller);
    final ArrayList<Parameter> instantiatedParams = new ArrayList<Parameter>();
    final EList<Parameter> parameters = function.getParameters();
    for (final Parameter p : parameters) {
      {
        final Parameter param = EcoreUtil.<Parameter>copy(p);
        param.setType(this.instantiate(param.getType(), typeSubstitutions));
        instantiatedParams.add(param);
      }
    }
    return instantiatedParams;
  }
  
  public Type instantiate(final Type type, final Map<Type, Type> substitutions) {
    Type substType = substitutions.get(type);
    boolean _equals = Objects.equal(substType, null);
    if (_equals) {
      substType = type;
    }
    final Type instantiatedType = EcoreUtil.<Type>copy(substType);
    if ((instantiatedType instanceof ParameterizedType)) {
      int _size = ((ParameterizedType)instantiatedType).getTypeParameters().size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for (final Integer i : _doubleDotLessThan) {
        {
          final Type typeParam = ((ParameterizedType)instantiatedType).getTypeParameters().get((i).intValue());
          ((ParameterizedType)instantiatedType).getTypeParameters().set((i).intValue(), this.instantiate(typeParam, substitutions));
        }
      }
    }
    return instantiatedType;
  }
}
