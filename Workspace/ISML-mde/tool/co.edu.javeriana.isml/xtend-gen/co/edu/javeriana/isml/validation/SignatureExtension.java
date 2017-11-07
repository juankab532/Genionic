package co.edu.javeriana.isml.validation;

import co.edu.javeriana.isml.isml.Controller;
import co.edu.javeriana.isml.isml.Function;
import co.edu.javeriana.isml.isml.GenericTypeSpecification;
import co.edu.javeriana.isml.isml.If;
import co.edu.javeriana.isml.isml.InformationSystem;
import co.edu.javeriana.isml.isml.Parameter;
import co.edu.javeriana.isml.isml.ParameterizedType;
import co.edu.javeriana.isml.isml.Type;
import co.edu.javeriana.isml.isml.TypeSpecification;
import co.edu.javeriana.isml.scoping.IsmlModelNavigation;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.LinkedList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class SignatureExtension {
  @Inject
  @Extension
  private IsmlModelNavigation _ismlModelNavigation;
  
  public String getSignature(final EObject obj) {
    boolean _matched = false;
    if (obj instanceof Controller) {
      _matched=true;
      return this.getFullyQualifiedID(obj).toString();
    }
    if (!_matched) {
      if (obj instanceof Function) {
        _matched=true;
        String _string = this.getFullyQualifiedID(obj).toString();
        StringBuilder sig = new StringBuilder(_string);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(");
        {
          EList<Parameter> _parameters = ((Function)obj).getParameters();
          boolean _hasElements = false;
          for(final Parameter param : _parameters) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",", "");
            }
            String _signature = this.getSignature(param.getType());
            _builder.append(_signature);
          }
        }
        _builder.append(")");
        sig.append(_builder);
        return sig.toString();
      }
    }
    if (!_matched) {
      if (obj instanceof Parameter) {
        _matched=true;
        final EObject container = ((Parameter)obj).eContainer();
        if ((container instanceof Function)) {
          String _signature = this.getSignature(container);
          String _name = ((Parameter)obj).getName();
          return (_signature + _name);
        } else {
          return this.getFullyQualifiedID(obj).toString();
        }
      }
    }
    if (!_matched) {
      if (obj instanceof ParameterizedType) {
        _matched=true;
        String _string = this.getFullyQualifiedID(this._ismlModelNavigation.getTypeSpecification(((Type)obj))).toString();
        StringBuilder sig = new StringBuilder(_string);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("<");
        {
          EList<Type> _typeParameters = ((ParameterizedType)obj).getTypeParameters();
          boolean _hasElements = false;
          for(final Type param : _typeParameters) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",", "");
            }
            String _signature = this.getSignature(param);
            _builder.append(_signature);
          }
        }
        _builder.append(">");
        sig.append(_builder);
        return sig.toString();
      }
    }
    if (!_matched) {
      if (obj instanceof Type) {
        _matched=true;
        final TypeSpecification typeSpec = this._ismlModelNavigation.getTypeSpecification(((Type)obj));
        if ((typeSpec instanceof GenericTypeSpecification)) {
          return ((GenericTypeSpecification)typeSpec).getName();
        }
        return this.getFullyQualifiedID(typeSpec).toString();
      }
    }
    return this.getFullyQualifiedID(obj).toString();
  }
  
  public QualifiedName getFullyQualifiedID(final EObject obj) {
    LinkedList<String> id = new LinkedList<String>();
    id.add(this.getStringID(obj));
    EObject _eContainer = null;
    if (obj!=null) {
      _eContainer=obj.eContainer();
    }
    EObject current = _eContainer;
    boolean _notEquals = (!Objects.equal(current, null));
    if (_notEquals) {
      while ((!(current instanceof InformationSystem))) {
        {
          id.add(0, this.getStringID(current));
          current = current.eContainer();
        }
      }
    }
    return QualifiedName.create(id);
  }
  
  private String getStringID(final EObject obj) {
    String id = "";
    EClass _eClass = null;
    if (obj!=null) {
      _eClass=obj.eClass();
    }
    EStructuralFeature _eStructuralFeature = null;
    if (_eClass!=null) {
      _eStructuralFeature=_eClass.getEStructuralFeature("name");
    }
    final EStructuralFeature nameFeature = _eStructuralFeature;
    boolean _notEquals = (!Objects.equal(nameFeature, null));
    if (_notEquals) {
      Object _eGet = obj.eGet(nameFeature);
      final String name = ((String) _eGet);
      boolean _notEquals_1 = (!Objects.equal(name, null));
      if (_notEquals_1) {
        id = name;
      } else {
        id = String.valueOf(obj);
      }
    } else {
      id = String.valueOf(obj);
    }
    boolean _needToDisplayFeature = this.needToDisplayFeature(obj.eContainer());
    if (_needToDisplayFeature) {
      EStructuralFeature _eContainingFeature = obj.eContainingFeature();
      String _name = null;
      if (_eContainingFeature!=null) {
        _name=_eContainingFeature.getName();
      }
      final String feature = _name;
      boolean _notEquals_2 = (!Objects.equal(feature, null));
      if (_notEquals_2) {
        id = ((("|" + feature) + "|.") + id);
      }
    }
    return id;
  }
  
  private boolean needToDisplayFeature(final EObject obj) {
    return (obj instanceof If);
  }
}
