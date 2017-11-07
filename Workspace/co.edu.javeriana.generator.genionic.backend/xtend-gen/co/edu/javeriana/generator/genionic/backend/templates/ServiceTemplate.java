package co.edu.javeriana.generator.genionic.backend.templates;

import co.edu.javeriana.isml.generator.common.SimpleTemplate;
import co.edu.javeriana.isml.isml.Attribute;
import co.edu.javeriana.isml.isml.Entity;
import co.edu.javeriana.isml.isml.Feature;
import co.edu.javeriana.isml.isml.GenericTypeSpecification;
import co.edu.javeriana.isml.isml.Method;
import co.edu.javeriana.isml.isml.MethodStatement;
import co.edu.javeriana.isml.isml.Parameter;
import co.edu.javeriana.isml.isml.ParameterizedType;
import co.edu.javeriana.isml.isml.Primitive;
import co.edu.javeriana.isml.isml.Service;
import co.edu.javeriana.isml.isml.Type;
import co.edu.javeriana.isml.isml.TypeSpecification;
import co.edu.javeriana.isml.scoping.IsmlModelNavigation;
import co.edu.javeriana.isml.validation.TypeChecker;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ServiceTemplate extends SimpleTemplate<Service> {
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Inject
  @Extension
  private IsmlModelNavigation _ismlModelNavigation;
  
  @Inject
  @Extension
  private TypeChecker _typeChecker;
  
  /**
   * Metodo que retorna la implementación de los servicios
   */
  @Override
  public CharSequence template(final Service service) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    EObject _eContainer = service.eContainer();
    QualifiedName _fullyQualifiedName = null;
    if (_eContainer!=null) {
      _fullyQualifiedName=this._iQualifiedNameProvider.getFullyQualifiedName(_eContainer);
    }
    QualifiedName _lowerCase = _fullyQualifiedName.toLowerCase();
    _builder.append(_lowerCase);
    _builder.append(".impl;\t\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      Set<Map.Entry<QualifiedName, TypeSpecification>> _entrySet = this.getNeededImportsInMethods(service).entrySet();
      for(final Map.Entry<QualifiedName, TypeSpecification> entity : _entrySet) {
        _builder.append("import ");
        QualifiedName _fullyQualifiedName_1 = this._iQualifiedNameProvider.getFullyQualifiedName(entity.getValue());
        _builder.append(_fullyQualifiedName_1);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Type> _superTypes = service.getSuperTypes();
      for(final Type parent : _superTypes) {
        {
          Set<Map.Entry<QualifiedName, TypeSpecification>> _entrySet_1 = this.getNeededImportsInMethods(this._ismlModelNavigation.getTypeSpecification(parent)).entrySet();
          for(final Map.Entry<QualifiedName, TypeSpecification> entity_1 : _entrySet_1) {
            _builder.append("import ");
            QualifiedName _fullyQualifiedName_2 = this._iQualifiedNameProvider.getFullyQualifiedName(entity_1.getValue());
            _builder.append(_fullyQualifiedName_2);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("import java.util.*;");
    _builder.newLine();
    _builder.append("import java.io.Serializable;");
    _builder.newLine();
    _builder.append("import javax.ejb.Stateless;");
    _builder.newLine();
    _builder.append("import javax.persistence.EntityManager;");
    _builder.newLine();
    _builder.append("import javax.persistence.PersistenceContext;");
    _builder.newLine();
    _builder.append("import javax.persistence.Query;");
    _builder.newLine();
    _builder.append("import common.services.Persistence;");
    _builder.newLine();
    _builder.append("import backend.entities.*;");
    _builder.newLine();
    _builder.append(" ");
    _builder.newLine();
    _builder.append("import ");
    EObject _eContainer_1 = service.eContainer();
    QualifiedName _fullyQualifiedName_3 = null;
    if (_eContainer_1!=null) {
      _fullyQualifiedName_3=this._iQualifiedNameProvider.getFullyQualifiedName(_eContainer_1);
    }
    QualifiedName _lowerCase_1 = _fullyQualifiedName_3.toLowerCase();
    _builder.append(_lowerCase_1);
    _builder.append(".interfaces.");
    String _firstUpper = StringExtensions.toFirstUpper(service.getName());
    _builder.append(_firstUpper);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* This class represents an EJB named ");
    String _firstUpper_1 = StringExtensions.toFirstUpper(service.getName());
    _builder.append(_firstUpper_1, " ");
    _builder.append("Impl");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("@Stateless");
    _builder.newLine();
    _builder.append("public class ");
    String _firstUpper_2 = StringExtensions.toFirstUpper(service.getName());
    _builder.append(_firstUpper_2);
    _builder.append("Impl");
    {
      boolean _isEmpty = service.getGenericTypeParameters().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder.append("<");
        {
          EList<GenericTypeSpecification> _genericTypeParameters = service.getGenericTypeParameters();
          boolean _hasElements = false;
          for(final GenericTypeSpecification param : _genericTypeParameters) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",", "");
            }
            String _name = param.getName();
            _builder.append(_name);
          }
        }
        _builder.append(">");
      }
    }
    _builder.append(" ");
    {
      boolean _isEmpty_1 = service.getSuperTypes().isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      if (_not_1) {
        _builder.append("extends ");
        String _firstUpper_3 = StringExtensions.toFirstUpper(this._ismlModelNavigation.getTypeSpecification(service.getSuperTypes().get(0)).getName());
        _builder.append(_firstUpper_3);
        {
          TypeSpecification _typeSpecification = this._ismlModelNavigation.getTypeSpecification(service.getSuperTypes().get(0));
          if ((_typeSpecification instanceof Service)) {
            {
              Type _get = service.getSuperTypes().get(0);
              if ((_get instanceof ParameterizedType)) {
                _builder.append("<");
                {
                  Type _get_1 = service.getSuperTypes().get(0);
                  EList<Type> _typeParameters = ((ParameterizedType) _get_1).getTypeParameters();
                  boolean _hasElements_1 = false;
                  for(final Type param_1 : _typeParameters) {
                    if (!_hasElements_1) {
                      _hasElements_1 = true;
                    } else {
                      _builder.appendImmediate(",", "");
                    }
                    String _writeType = this.writeType(param_1, true);
                    _builder.append(_writeType);
                  }
                }
                _builder.append(">");
              }
            }
          }
        }
      }
    }
    _builder.append(" implements ");
    String _firstUpper_4 = StringExtensions.toFirstUpper(service.getName());
    _builder.append(_firstUpper_4);
    {
      boolean _isEmpty_2 = service.getGenericTypeParameters().isEmpty();
      boolean _not_2 = (!_isEmpty_2);
      if (_not_2) {
        _builder.append("<");
        {
          EList<GenericTypeSpecification> _genericTypeParameters_1 = service.getGenericTypeParameters();
          boolean _hasElements_2 = false;
          for(final GenericTypeSpecification param_2 : _genericTypeParameters_1) {
            if (!_hasElements_2) {
              _hasElements_2 = true;
            } else {
              _builder.appendImmediate(",", "");
            }
            String _name_1 = param_2.getName();
            _builder.append(_name_1);
          }
        }
        _builder.append(">");
      }
    }
    _builder.append(",Serializable{");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("@PersistenceContext");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("private EntityManager entityManager;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected  EntityManager getEntityManager() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return entityManager;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<GenericTypeSpecification> _genericTypeParameters_2 = service.getGenericTypeParameters();
      for(final GenericTypeSpecification gen : _genericTypeParameters_2) {
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t");
        _builder.append(" ");
        _builder.append("* Class Object represented by \"");
        String _name_2 = gen.getName();
        _builder.append(_name_2, "\t ");
        _builder.append("\" class parameter");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private Class<");
        String _name_3 = gen.getName();
        _builder.append(_name_3, "\t");
        _builder.append("> clazz");
        String _name_4 = gen.getName();
        _builder.append(_name_4, "\t");
        _builder.append("Object;");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Type> _superTypes_1 = service.getSuperTypes();
      for(final Type type : _superTypes_1) {
        {
          Iterable<Feature> _features = this._ismlModelNavigation.getFeatures(this._ismlModelNavigation.getTypeSpecification(type));
          for(final Feature attr : _features) {
            {
              if ((attr instanceof Attribute)) {
                _builder.append("\t");
                _builder.append("/**");
                _builder.newLine();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("* The attribute ");
                String _firstLower = StringExtensions.toFirstLower(((Attribute)attr).getName());
                _builder.append(_firstLower, "\t ");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("*/");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("private ");
                String _writeType_1 = this.writeType(((Attribute)attr).getType(), true);
                _builder.append(_writeType_1, "\t");
                _builder.append(" ");
                String _firstLower_1 = StringExtensions.toFirstLower(((Attribute)attr).getName());
                _builder.append(_firstLower_1, "\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      Iterable<Feature> _features_1 = this._ismlModelNavigation.getFeatures(service);
      for(final Feature attr_1 : _features_1) {
        {
          if ((attr_1 instanceof Attribute)) {
            _builder.append("\t");
            _builder.append("/**");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("* The attribute ");
            String _firstLower_2 = StringExtensions.toFirstLower(((Attribute)attr_1).getName());
            _builder.append(_firstLower_2, "\t ");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("*/");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("private ");
            String _writeType_2 = this.writeType(((Attribute)attr_1).getType(), true);
            _builder.append(_writeType_2, "\t");
            _builder.append(" ");
            String _firstLower_3 = StringExtensions.toFirstLower(((Attribute)attr_1).getName());
            _builder.append(_firstLower_3, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      boolean _isEmpty_3 = service.getGenericTypeParameters().isEmpty();
      boolean _not_3 = (!_isEmpty_3);
      if (_not_3) {
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t");
        _builder.append(" ");
        _builder.append("* Service default constructor for Generic types");
        _builder.newLine();
        _builder.append("\t");
        _builder.append(" ");
        _builder.append("*");
        _builder.newLine();
        {
          EList<GenericTypeSpecification> _genericTypeParameters_3 = service.getGenericTypeParameters();
          for(final GenericTypeSpecification gen_1 : _genericTypeParameters_3) {
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("* @param clazz");
            String _name_5 = gen_1.getName();
            _builder.append(_name_5, "\t ");
            _builder.append("Object It\'s the generic clazz for \'");
            String _name_6 = gen_1.getName();
            _builder.append(_name_6, "\t ");
            _builder.append("\' generic parameter ");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        String _firstUpper_5 = StringExtensions.toFirstUpper(service.getName());
        _builder.append(_firstUpper_5, "\t");
        _builder.append("Imp(");
        {
          EList<GenericTypeSpecification> _genericTypeParameters_4 = service.getGenericTypeParameters();
          boolean _hasElements_3 = false;
          for(final GenericTypeSpecification gen_2 : _genericTypeParameters_4) {
            if (!_hasElements_3) {
              _hasElements_3 = true;
            } else {
              _builder.appendImmediate(",", "\t");
            }
            _builder.append("Class<");
            String _name_7 = gen_2.getName();
            _builder.append(_name_7, "\t");
            _builder.append("> clazz");
            String _name_8 = gen_2.getName();
            _builder.append(_name_8, "\t");
            _builder.append("Object");
          }
        }
        _builder.append("){");
        _builder.newLineIfNotEmpty();
        {
          EList<GenericTypeSpecification> _genericTypeParameters_5 = service.getGenericTypeParameters();
          for(final GenericTypeSpecification gen_3 : _genericTypeParameters_5) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("this.clazz");
            String _name_9 = gen_3.getName();
            _builder.append(_name_9, "\t\t");
            _builder.append("Object=clazz");
            String _name_10 = gen_3.getName();
            _builder.append(_name_10, "\t\t");
            _builder.append("Object;");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Service default constructor");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _firstUpper_6 = StringExtensions.toFirstUpper(service.getName());
    _builder.append(_firstUpper_6, "\t");
    _builder.append("Impl(){");
    _builder.newLineIfNotEmpty();
    {
      EList<Type> _superTypes_2 = service.getSuperTypes();
      for(final Type superType : _superTypes_2) {
        {
          if ((superType instanceof ParameterizedType)) {
            _builder.append("\t\t");
            _builder.append("super(");
            {
              EList<Type> _typeParameters_1 = ((ParameterizedType)superType).getTypeParameters();
              boolean _hasElements_4 = false;
              for(final Type param_3 : _typeParameters_1) {
                if (!_hasElements_4) {
                  _hasElements_4 = true;
                } else {
                  _builder.appendImmediate(",", "\t\t");
                }
                String _writeType_3 = this.writeType(param_3, true);
                _builder.append(_writeType_3, "\t\t");
                _builder.append(".class");
              }
            }
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<Type> _superTypes_3 = service.getSuperTypes();
      for(final Type type_1 : _superTypes_3) {
        {
          Iterable<Feature> _features_2 = this._ismlModelNavigation.getFeatures(this._ismlModelNavigation.getTypeSpecification(type_1));
          for(final Feature feature : _features_2) {
            {
              if ((feature instanceof Method)) {
                _builder.append("\t");
                _builder.append("/**");
                _builder.newLine();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("* This method executes the proper actions for ");
                String _name_11 = ((Method)feature).getName();
                _builder.append(_name_11, "\t ");
                _builder.newLineIfNotEmpty();
                {
                  EList<Parameter> _parameters = ((Method)feature).getParameters();
                  for(final Parameter param_4 : _parameters) {
                    _builder.append("\t");
                    _builder.append(" ");
                    _builder.append("* @param ");
                    String _firstLower_4 = StringExtensions.toFirstLower(param_4.getName());
                    _builder.append(_firstLower_4, "\t ");
                    _builder.append(" Parameter from type ");
                    String _firstUpper_7 = StringExtensions.toFirstUpper(this._ismlModelNavigation.getTypeSpecification(param_4.getType()).getName());
                    _builder.append(_firstUpper_7, "\t ");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  if (((!Objects.equal(((Method)feature).getType(), null)) && (!this._ismlModelNavigation.getTypeSpecification(((Method)feature).getType()).getName().equalsIgnoreCase("Void")))) {
                    _builder.append("\t");
                    _builder.append(" ");
                    _builder.append("* @return Some ");
                    String _writeType_4 = this.writeType(this._ismlModelNavigation.getReplacedType(service, ((Method)feature).getType()), true);
                    _builder.append(_writeType_4, "\t ");
                    _builder.append(" object");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("*/");
                _builder.newLine();
                {
                  if (((this._ismlModelNavigation.getTypeSpecification(((Method)feature).getType()).getName().equalsIgnoreCase("void") && this.isComplexObjectPresentInParameters(((Method)feature))) && (((Method)feature).getParameters().size() != 1))) {
                    _builder.append("\t");
                    _builder.append("@Override");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("public ");
                    String _writeType_5 = this.writeType(this._ismlModelNavigation.getReplacedType(service, ((Method)feature).getType()), true);
                    _builder.append(_writeType_5, "\t");
                    _builder.append(" ");
                    String _name_12 = ((Method)feature).getName();
                    _builder.append(_name_12, "\t");
                    _builder.append("(");
                    {
                      EList<Parameter> _parameters_1 = ((Method)feature).getParameters();
                      boolean _hasElements_5 = false;
                      for(final Parameter param_5 : _parameters_1) {
                        if (!_hasElements_5) {
                          _hasElements_5 = true;
                        } else {
                          _builder.appendImmediate(",", "\t");
                        }
                        String _writeType_6 = this.writeType(this._ismlModelNavigation.getReplacedType(service, param_5.getType()), true);
                        _builder.append(_writeType_6, "\t");
                        _builder.append(" ");
                        String _firstLower_5 = StringExtensions.toFirstLower(param_5.getName());
                        _builder.append(_firstLower_5, "\t");
                      }
                    }
                    _builder.append("){");
                    _builder.newLineIfNotEmpty();
                    {
                      boolean _equalsIgnoreCase = this._ismlModelNavigation.getTypeSpecification(((Method)feature).getType()).getName().equalsIgnoreCase("Void");
                      boolean _not_4 = (!_equalsIgnoreCase);
                      if (_not_4) {
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("return super.");
                        String _name_13 = ((Method)feature).getName();
                        _builder.append(_name_13, "\t\t");
                        _builder.append("(");
                        {
                          EList<Parameter> _parameters_2 = ((Method)feature).getParameters();
                          boolean _hasElements_6 = false;
                          for(final Parameter parameter : _parameters_2) {
                            if (!_hasElements_6) {
                              _hasElements_6 = true;
                            } else {
                              _builder.appendImmediate(",", "\t\t");
                            }
                            String _firstLower_6 = StringExtensions.toFirstLower(parameter.getName());
                            _builder.append(_firstLower_6, "\t\t");
                          }
                        }
                        _builder.append(");");
                        _builder.newLineIfNotEmpty();
                      } else {
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("super.");
                        String _name_14 = ((Method)feature).getName();
                        _builder.append(_name_14, "\t\t");
                        _builder.append("(");
                        {
                          EList<Parameter> _parameters_3 = ((Method)feature).getParameters();
                          boolean _hasElements_7 = false;
                          for(final Parameter parameter_1 : _parameters_3) {
                            if (!_hasElements_7) {
                              _hasElements_7 = true;
                            } else {
                              _builder.appendImmediate(",", "\t\t");
                            }
                            String _firstLower_7 = StringExtensions.toFirstLower(parameter_1.getName());
                            _builder.append(_firstLower_7, "\t\t");
                          }
                        }
                        _builder.append(");\t");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("\t");
                    _builder.append("}\t\t\t\t\t");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.newLine();
                  } else {
                    _builder.append("\t");
                    _builder.append("@Override");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("public ");
                    String _writeType_7 = this.writeType(this._ismlModelNavigation.getReplacedType(service, ((Method)feature).getType()), true);
                    _builder.append(_writeType_7, "\t");
                    _builder.append(" ");
                    String _name_15 = ((Method)feature).getName();
                    _builder.append(_name_15, "\t");
                    _builder.append("(");
                    {
                      EList<Parameter> _parameters_4 = ((Method)feature).getParameters();
                      boolean _hasElements_8 = false;
                      for(final Parameter parameter_2 : _parameters_4) {
                        if (!_hasElements_8) {
                          _hasElements_8 = true;
                        } else {
                          _builder.appendImmediate(",", "\t");
                        }
                        {
                          if ((this._ismlModelNavigation.getTypeSpecification(((Method)feature).getType()).getName().equalsIgnoreCase("void") && (((Method)feature).getParameters().size() != 1))) {
                            _builder.append("String ");
                            String _firstLower_8 = StringExtensions.toFirstLower(parameter_2.getName());
                            _builder.append(_firstLower_8, "\t");
                          } else {
                            String _writeType_8 = this.writeType(this._ismlModelNavigation.getReplacedType(service, parameter_2.getType()), true);
                            _builder.append(_writeType_8, "\t");
                            _builder.append(" ");
                            String _firstLower_9 = StringExtensions.toFirstLower(parameter_2.getName());
                            _builder.append(_firstLower_9, "\t");
                          }
                        }
                      }
                    }
                    _builder.append("){");
                    _builder.newLineIfNotEmpty();
                    {
                      boolean _equalsIgnoreCase_1 = this._ismlModelNavigation.getTypeSpecification(((Method)feature).getType()).getName().equalsIgnoreCase("Void");
                      boolean _not_5 = (!_equalsIgnoreCase_1);
                      if (_not_5) {
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("return super.");
                        String _name_16 = ((Method)feature).getName();
                        _builder.append(_name_16, "\t\t");
                        _builder.append("(");
                        {
                          EList<Parameter> _parameters_5 = ((Method)feature).getParameters();
                          boolean _hasElements_9 = false;
                          for(final Parameter parameter_3 : _parameters_5) {
                            if (!_hasElements_9) {
                              _hasElements_9 = true;
                            } else {
                              _builder.appendImmediate(",", "\t\t");
                            }
                            String _firstLower_10 = StringExtensions.toFirstLower(parameter_3.getName());
                            _builder.append(_firstLower_10, "\t\t");
                          }
                        }
                        _builder.append(");");
                        _builder.newLineIfNotEmpty();
                      } else {
                        _builder.append("\t");
                        _builder.append("\t");
                        _builder.append("super.");
                        String _name_17 = ((Method)feature).getName();
                        _builder.append(_name_17, "\t\t");
                        _builder.append("(");
                        {
                          EList<Parameter> _parameters_6 = ((Method)feature).getParameters();
                          boolean _hasElements_10 = false;
                          for(final Parameter parameter_4 : _parameters_6) {
                            if (!_hasElements_10) {
                              _hasElements_10 = true;
                            } else {
                              _builder.appendImmediate(",", "\t\t");
                            }
                            String _firstLower_11 = StringExtensions.toFirstLower(parameter_4.getName());
                            _builder.append(_firstLower_11, "\t\t");
                          }
                        }
                        _builder.append(");\t");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
              } else {
                {
                  if ((feature instanceof Attribute)) {
                    _builder.append("\t");
                    _builder.append("/**");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append(" ");
                    _builder.append("* Returns the current value for the attribute ");
                    String _name_18 = ((Attribute)feature).getName();
                    _builder.append(_name_18, "\t ");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append(" ");
                    _builder.append("*");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append(" ");
                    _builder.append("* @return Some ");
                    String _writeType_9 = this.writeType(this._ismlModelNavigation.getReplacedType(service, ((Attribute)feature).getType()), true);
                    _builder.append(_writeType_9, "\t ");
                    _builder.append(" object");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append(" ");
                    _builder.append("*/");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("@Override");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("public ");
                    String _writeType_10 = this.writeType(this._ismlModelNavigation.getReplacedType(service, ((Attribute)feature).getType()), true);
                    _builder.append(_writeType_10, "\t");
                    _builder.append(" get");
                    String _firstUpper_8 = StringExtensions.toFirstUpper(((Attribute)feature).getName());
                    _builder.append(_firstUpper_8, "\t");
                    _builder.append("(){");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("return ");
                    String _firstLower_12 = StringExtensions.toFirstLower(((Attribute)feature).getName());
                    _builder.append(_firstLower_12, "\t\t");
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("/**");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append(" ");
                    _builder.append("* Sets the value for the attribute ");
                    String _name_19 = ((Attribute)feature).getName();
                    _builder.append(_name_19, "\t ");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append(" ");
                    _builder.append("*");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append(" ");
                    _builder.append("* @param ");
                    String _firstLower_13 = StringExtensions.toFirstLower(((Attribute)feature).getName());
                    _builder.append(_firstLower_13, "\t ");
                    _builder.append(" The value to set");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append(" ");
                    _builder.append("*/");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("@Override");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("public void set");
                    String _firstUpper_9 = StringExtensions.toFirstUpper(((Attribute)feature).getName());
                    _builder.append(_firstUpper_9, "\t");
                    _builder.append("(");
                    String _writeType_11 = this.writeType(this._ismlModelNavigation.getReplacedType(service, ((Attribute)feature).getType()), true);
                    _builder.append(_writeType_11, "\t");
                    _builder.append(" ");
                    String _firstLower_14 = StringExtensions.toFirstLower(((Attribute)feature).getName());
                    _builder.append(_firstLower_14, "\t");
                    _builder.append("){");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("this.");
                    String _firstLower_15 = StringExtensions.toFirstLower(((Attribute)feature).getName());
                    _builder.append(_firstLower_15, "\t\t");
                    _builder.append("=");
                    String _firstLower_16 = StringExtensions.toFirstLower(((Attribute)feature).getName());
                    _builder.append(_firstLower_16, "\t\t");
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
              }
            }
          }
        }
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      Iterable<Feature> _features_3 = this._ismlModelNavigation.getFeatures(service);
      for(final Feature feature_1 : _features_3) {
        {
          if ((feature_1 instanceof Method)) {
            _builder.append("\t");
            _builder.append("/**");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("* This method executes the proper actions for ");
            String _name_20 = ((Method)feature_1).getName();
            _builder.append(_name_20, "\t ");
            _builder.newLineIfNotEmpty();
            {
              EList<Parameter> _parameters_7 = ((Method)feature_1).getParameters();
              for(final Parameter param_6 : _parameters_7) {
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("* @param ");
                String _firstLower_17 = StringExtensions.toFirstLower(param_6.getName());
                _builder.append(_firstLower_17, "\t ");
                _builder.append(" Parameter from type ");
                String _firstUpper_10 = StringExtensions.toFirstUpper(this._ismlModelNavigation.getTypeSpecification(param_6.getType()).getName());
                _builder.append(_firstUpper_10, "\t ");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              if (((!Objects.equal(((Method)feature_1).getType(), null)) && (!this._ismlModelNavigation.getTypeSpecification(((Method)feature_1).getType()).getName().equalsIgnoreCase("Void")))) {
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("* @return Some ");
                String _writeType_12 = this.writeType(this._ismlModelNavigation.getReplacedType(service, ((Method)feature_1).getType()), true);
                _builder.append(_writeType_12, "\t ");
                _builder.append(" object");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("*/");
            _builder.newLine();
            {
              if (((this._ismlModelNavigation.getTypeSpecification(((Method)feature_1).getType()).getName().equalsIgnoreCase("void") && this.isComplexObjectPresentInParameters(((Method)feature_1))) && (((Method)feature_1).getParameters().size() != 1))) {
                _builder.append("\t");
                _builder.append("@Override");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("public ");
                String _writeType_13 = this.writeType(this._ismlModelNavigation.getReplacedType(service, ((Method)feature_1).getType()), true);
                _builder.append(_writeType_13, "\t");
                _builder.append(" ");
                String _name_21 = ((Method)feature_1).getName();
                _builder.append(_name_21, "\t");
                _builder.append("(");
                {
                  EList<Parameter> _parameters_8 = ((Method)feature_1).getParameters();
                  boolean _hasElements_11 = false;
                  for(final Parameter param_7 : _parameters_8) {
                    if (!_hasElements_11) {
                      _hasElements_11 = true;
                    } else {
                      _builder.appendImmediate(",", "\t");
                    }
                    String _writeType_14 = this.writeType(this._ismlModelNavigation.getReplacedType(service, param_7.getType()), true);
                    _builder.append(_writeType_14, "\t");
                    _builder.append(" ");
                    String _firstLower_18 = StringExtensions.toFirstLower(param_7.getName());
                    _builder.append(_firstLower_18, "\t");
                  }
                }
                _builder.append("){");
                _builder.newLineIfNotEmpty();
                {
                  boolean _equalsIgnoreCase_2 = this._ismlModelNavigation.getTypeSpecification(((Method)feature_1).getType()).getName().equalsIgnoreCase("Void");
                  boolean _not_6 = (!_equalsIgnoreCase_2);
                  if (_not_6) {
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("return null;");
                    _builder.newLine();
                  }
                }
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("/**");
                _builder.newLine();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("* This method executes the proper actions for ");
                String _name_22 = ((Method)feature_1).getName();
                _builder.append(_name_22, "\t ");
                _builder.newLineIfNotEmpty();
                {
                  EList<Parameter> _parameters_9 = ((Method)feature_1).getParameters();
                  for(final Parameter param_8 : _parameters_9) {
                    _builder.append("\t");
                    _builder.append(" ");
                    _builder.append("* @param ");
                    String _firstLower_19 = StringExtensions.toFirstLower(param_8.getName());
                    _builder.append(_firstLower_19, "\t ");
                    _builder.append(" Parameter from type ");
                    String _firstUpper_11 = StringExtensions.toFirstUpper(this._ismlModelNavigation.getTypeSpecification(param_8.getType()).getName());
                    _builder.append(_firstUpper_11, "\t ");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  if (((!Objects.equal(((Method)feature_1).getType(), null)) && (!this._ismlModelNavigation.getTypeSpecification(((Method)feature_1).getType()).getName().equalsIgnoreCase("Void")))) {
                    _builder.append("\t");
                    _builder.append(" ");
                    _builder.append("* @return Some ");
                    String _writeType_15 = this.writeType(this._ismlModelNavigation.getReplacedType(service, ((Method)feature_1).getType()), true);
                    _builder.append(_writeType_15, "\t ");
                    _builder.append(" object");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("*/");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("@Override");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("public ");
                String _writeType_16 = this.writeType(this._ismlModelNavigation.getReplacedType(service, ((Method)feature_1).getType()), true);
                _builder.append(_writeType_16, "\t");
                _builder.append(" ");
                String _name_23 = ((Method)feature_1).getName();
                _builder.append(_name_23, "\t");
                _builder.append("REST(");
                {
                  EList<Parameter> _parameters_10 = ((Method)feature_1).getParameters();
                  boolean _hasElements_12 = false;
                  for(final Parameter parameter_5 : _parameters_10) {
                    if (!_hasElements_12) {
                      _hasElements_12 = true;
                    } else {
                      _builder.appendImmediate(",", "\t");
                    }
                    {
                      if ((this._ismlModelNavigation.getTypeSpecification(((Method)feature_1).getType()).getName().equalsIgnoreCase("void") && (((Method)feature_1).getParameters().size() != 1))) {
                        _builder.append("String ");
                        String _firstLower_20 = StringExtensions.toFirstLower(parameter_5.getName());
                        _builder.append(_firstLower_20, "\t");
                      } else {
                        String _writeType_17 = this.writeType(this._ismlModelNavigation.getReplacedType(service, parameter_5.getType()), true);
                        _builder.append(_writeType_17, "\t");
                        _builder.append(" ");
                        String _firstLower_21 = StringExtensions.toFirstLower(parameter_5.getName());
                        _builder.append(_firstLower_21, "\t");
                      }
                    }
                  }
                }
                _builder.append(") throws JSONException, JsonParseException, JsonMappingException, IOException{");
                _builder.newLineIfNotEmpty();
                {
                  EList<Parameter> _parameters_11 = ((Method)feature_1).getParameters();
                  for(final Parameter param_9 : _parameters_11) {
                    _builder.append("\t");
                    _builder.append("\t");
                    String _writeType_18 = this.writeType(this._ismlModelNavigation.getReplacedType(service, param_9.getType()), true);
                    _builder.append(_writeType_18, "\t\t");
                    _builder.append(" ");
                    String _name_24 = param_9.getName();
                    _builder.append(_name_24, "\t\t");
                    _builder.append("Var=");
                    {
                      if (((this._ismlModelNavigation.getTypeSpecification(param_9.getType()) instanceof Primitive) && (!this._typeChecker.isCollection(param_9.getType())))) {
                        {
                          boolean _equalsIgnoreCase_3 = this._ismlModelNavigation.getTypeSpecification(param_9.getType()).getName().equalsIgnoreCase("String");
                          if (_equalsIgnoreCase_3) {
                            String _name_25 = param_9.getName();
                            _builder.append(_name_25, "\t\t");
                          } else {
                            String _writeType_19 = this.writeType(this._ismlModelNavigation.getReplacedType(service, param_9.getType()), true);
                            _builder.append(_writeType_19, "\t\t");
                            _builder.append(".parse");
                            String _writeType_20 = this.writeType(this._ismlModelNavigation.getReplacedType(service, param_9.getType()), true);
                            _builder.append(_writeType_20, "\t\t");
                            _builder.append("(");
                            String _name_26 = param_9.getName();
                            _builder.append(_name_26, "\t\t");
                            _builder.append(")");
                          }
                        }
                      } else {
                        {
                          boolean _isCollection = this._typeChecker.isCollection(param_9.getType());
                          if (_isCollection) {
                            _builder.append("(");
                            String _writeType_21 = this.writeType(this._ismlModelNavigation.getReplacedType(service, param_9.getType()), true);
                            _builder.append(_writeType_21, "\t\t");
                            _builder.append(")JSONConverterUtil.convertFromJSONArray(");
                            Type _type = param_9.getType();
                            String _writeType_22 = this.writeType(this._ismlModelNavigation.getReplacedType(service, ((ParameterizedType) _type).getTypeParameters().get(0)), true);
                            _builder.append(_writeType_22, "\t\t");
                            _builder.append(".class,");
                            String _name_27 = param_9.getName();
                            _builder.append(_name_27, "\t\t");
                            _builder.append(")");
                          } else {
                            _builder.append("JSONConverterUtil.convertFromJSONObject(");
                            String _writeType_23 = this.writeType(this._ismlModelNavigation.getReplacedType(service, param_9.getType()), true);
                            _builder.append(_writeType_23, "\t\t");
                            _builder.append(".class,");
                            String _name_28 = param_9.getName();
                            _builder.append(_name_28, "\t\t");
                            _builder.append(")");
                          }
                        }
                      }
                    }
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("this.");
                String _name_29 = ((Method)feature_1).getName();
                _builder.append(_name_29, "\t\t");
                _builder.append("(");
                {
                  EList<Parameter> _parameters_12 = ((Method)feature_1).getParameters();
                  boolean _hasElements_13 = false;
                  for(final Parameter param_10 : _parameters_12) {
                    if (!_hasElements_13) {
                      _hasElements_13 = true;
                    } else {
                      _builder.appendImmediate(",", "\t\t");
                    }
                    String _firstLower_22 = StringExtensions.toFirstLower(param_10.getName());
                    _builder.append(_firstLower_22, "\t\t");
                    _builder.append("Var");
                  }
                }
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
              } else {
                _builder.append("\t");
                _builder.append("@Override");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("public ");
                String _writeType_24 = this.writeType(this._ismlModelNavigation.getReplacedType(service, ((Method)feature_1).getType()), true);
                _builder.append(_writeType_24, "\t");
                _builder.append(" ");
                String _name_30 = ((Method)feature_1).getName();
                _builder.append(_name_30, "\t");
                _builder.append("(");
                {
                  EList<Parameter> _parameters_13 = ((Method)feature_1).getParameters();
                  boolean _hasElements_14 = false;
                  for(final Parameter parameter_6 : _parameters_13) {
                    if (!_hasElements_14) {
                      _hasElements_14 = true;
                    } else {
                      _builder.appendImmediate(",", "\t");
                    }
                    {
                      if ((this._ismlModelNavigation.getTypeSpecification(((Method)feature_1).getType()).getName().equalsIgnoreCase("void") && (((Method)feature_1).getParameters().size() != 1))) {
                        _builder.append("String ");
                        String _firstLower_23 = StringExtensions.toFirstLower(parameter_6.getName());
                        _builder.append(_firstLower_23, "\t");
                      } else {
                        String _writeType_25 = this.writeType(this._ismlModelNavigation.getReplacedType(service, parameter_6.getType()), true);
                        _builder.append(_writeType_25, "\t");
                        _builder.append(" ");
                        String _firstLower_24 = StringExtensions.toFirstLower(parameter_6.getName());
                        _builder.append(_firstLower_24, "\t");
                      }
                    }
                  }
                }
                _builder.append("){");
                _builder.newLineIfNotEmpty();
                {
                  boolean _equalsIgnoreCase_4 = this._ismlModelNavigation.getTypeSpecification(((Method)feature_1).getType()).getName().equalsIgnoreCase("Void");
                  boolean _not_7 = (!_equalsIgnoreCase_4);
                  if (_not_7) {
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("return null;");
                    _builder.newLine();
                  }
                }
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
          } else {
            {
              if ((feature_1 instanceof Attribute)) {
                _builder.append("\t");
                _builder.append("/**");
                _builder.newLine();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("* Returns the current value for the attribute ");
                String _name_31 = ((Attribute)feature_1).getName();
                _builder.append(_name_31, "\t ");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("*");
                _builder.newLine();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("* @return Some ");
                String _writeType_26 = this.writeType(this._ismlModelNavigation.getReplacedType(service, ((Attribute)feature_1).getType()), true);
                _builder.append(_writeType_26, "\t ");
                _builder.append(" object");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("*/");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("@Override");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("public ");
                String _writeType_27 = this.writeType(this._ismlModelNavigation.getReplacedType(service, ((Attribute)feature_1).getType()), true);
                _builder.append(_writeType_27, "\t");
                _builder.append(" get");
                String _firstUpper_12 = StringExtensions.toFirstUpper(((Attribute)feature_1).getName());
                _builder.append(_firstUpper_12, "\t");
                _builder.append("(){");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("return ");
                String _firstLower_25 = StringExtensions.toFirstLower(((Attribute)feature_1).getName());
                _builder.append(_firstLower_25, "\t\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("/**");
                _builder.newLine();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("* Sets the value for the attribute ");
                String _name_32 = ((Attribute)feature_1).getName();
                _builder.append(_name_32, "\t ");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("*");
                _builder.newLine();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("* @param ");
                String _firstLower_26 = StringExtensions.toFirstLower(((Attribute)feature_1).getName());
                _builder.append(_firstLower_26, "\t ");
                _builder.append(" The value to set");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("*/");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("@Override");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("public void set");
                String _firstUpper_13 = StringExtensions.toFirstUpper(((Attribute)feature_1).getName());
                _builder.append(_firstUpper_13, "\t");
                _builder.append("(");
                String _writeType_28 = this.writeType(this._ismlModelNavigation.getReplacedType(service, ((Attribute)feature_1).getType()), true);
                _builder.append(_writeType_28, "\t");
                _builder.append(" ");
                String _firstLower_27 = StringExtensions.toFirstLower(((Attribute)feature_1).getName());
                _builder.append(_firstLower_27, "\t");
                _builder.append("){");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("this.");
                String _firstLower_28 = StringExtensions.toFirstLower(((Attribute)feature_1).getName());
                _builder.append(_firstLower_28, "\t\t");
                _builder.append("=");
                String _firstLower_29 = StringExtensions.toFirstLower(((Attribute)feature_1).getName());
                _builder.append(_firstLower_29, "\t\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    _builder.append("}\t");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    return _builder;
  }
  
  public Map<QualifiedName, TypeSpecification> getNeededImportsInMethods(final TypeSpecification service) {
    Map<QualifiedName, TypeSpecification> imports = new HashMap<QualifiedName, TypeSpecification>();
    Iterable<Feature> _features = this._ismlModelNavigation.getFeatures(service);
    for (final Feature feature : _features) {
      {
        boolean _isCollection = this._typeChecker.isCollection(feature.getType());
        boolean _not = (!_isCollection);
        if (_not) {
          if (((!Objects.equal(feature.getType(), null)) && (!this._iQualifiedNameProvider.getFullyQualifiedName(this._ismlModelNavigation.getTypeSpecification(feature.getType()).eContainer()).equals(
            this._iQualifiedNameProvider.getFullyQualifiedName(service.eContainer()))))) {
            TypeSpecification _typeSpecification = this._ismlModelNavigation.getTypeSpecification(feature.getType());
            boolean _not_1 = (!(_typeSpecification instanceof Primitive));
            if (_not_1) {
              TypeSpecification _typeSpecification_1 = this._ismlModelNavigation.getTypeSpecification(feature.getType());
              boolean _not_2 = (!(_typeSpecification_1 instanceof GenericTypeSpecification));
              if (_not_2) {
                boolean _containsKey = imports.containsKey(this._iQualifiedNameProvider.getFullyQualifiedName(this._ismlModelNavigation.getTypeSpecification(feature.getType())));
                boolean _not_3 = (!_containsKey);
                if (_not_3) {
                  imports.put(this._iQualifiedNameProvider.getFullyQualifiedName(this._ismlModelNavigation.getTypeSpecification(feature.getType())), this._ismlModelNavigation.getTypeSpecification(feature.getType()));
                }
              }
            }
          }
        } else {
          Type _type = feature.getType();
          if ((_type instanceof ParameterizedType)) {
            if (((!Objects.equal(feature.getType(), null)) && (!this._iQualifiedNameProvider.getFullyQualifiedName(this._ismlModelNavigation.getTypeSpecification(((ParameterizedType) feature.getType()).getTypeParameters().get(0)).eContainer()).equals(this._iQualifiedNameProvider.getFullyQualifiedName(service.eContainer()))))) {
              Type _type_1 = feature.getType();
              TypeSpecification _typeSpecification_2 = this._ismlModelNavigation.getTypeSpecification(((ParameterizedType) _type_1).getTypeParameters().get(0));
              boolean _not_4 = (!(_typeSpecification_2 instanceof Primitive));
              if (_not_4) {
                Type _type_2 = feature.getType();
                TypeSpecification _typeSpecification_3 = this._ismlModelNavigation.getTypeSpecification(((ParameterizedType) _type_2).getTypeParameters().get(0));
                boolean _not_5 = (!(_typeSpecification_3 instanceof GenericTypeSpecification));
                if (_not_5) {
                  Type _type_3 = feature.getType();
                  boolean _containsKey_1 = imports.containsKey(this._iQualifiedNameProvider.getFullyQualifiedName(this._ismlModelNavigation.getTypeSpecification(((ParameterizedType) _type_3).getTypeParameters().get(0))));
                  boolean _not_6 = (!_containsKey_1);
                  if (_not_6) {
                    Type _type_4 = feature.getType();
                    Type _type_5 = feature.getType();
                    imports.put(this._iQualifiedNameProvider.getFullyQualifiedName(this._ismlModelNavigation.getTypeSpecification(((ParameterizedType) _type_4).getTypeParameters().get(0))), 
                      this._ismlModelNavigation.getTypeSpecification(((ParameterizedType) _type_5).getTypeParameters().get(0)));
                  }
                }
              }
            }
          }
        }
        if ((feature instanceof Method)) {
          EList<Parameter> _parameters = ((Method)feature).getParameters();
          for (final Parameter param : _parameters) {
            boolean _isCollection_1 = this._typeChecker.isCollection(param.getType());
            boolean _not_7 = (!_isCollection_1);
            if (_not_7) {
              boolean _equals = this._iQualifiedNameProvider.getFullyQualifiedName(this._ismlModelNavigation.getTypeSpecification(param.getType()).eContainer()).equals(
                this._iQualifiedNameProvider.getFullyQualifiedName(service.eContainer()));
              boolean _not_8 = (!_equals);
              if (_not_8) {
                TypeSpecification _typeSpecification_4 = this._ismlModelNavigation.getTypeSpecification(param.getType());
                boolean _not_9 = (!(_typeSpecification_4 instanceof Primitive));
                if (_not_9) {
                  TypeSpecification _typeSpecification_5 = this._ismlModelNavigation.getTypeSpecification(param.getType());
                  boolean _not_10 = (!(_typeSpecification_5 instanceof GenericTypeSpecification));
                  if (_not_10) {
                    boolean _containsKey_2 = imports.containsKey(this._iQualifiedNameProvider.getFullyQualifiedName(this._ismlModelNavigation.getTypeSpecification(param.getType())));
                    boolean _not_11 = (!_containsKey_2);
                    if (_not_11) {
                      imports.put(this._iQualifiedNameProvider.getFullyQualifiedName(this._ismlModelNavigation.getTypeSpecification(param.getType())), this._ismlModelNavigation.getTypeSpecification(param.getType()));
                    }
                  }
                }
              }
            } else {
              Type _type_6 = param.getType();
              if ((_type_6 instanceof ParameterizedType)) {
                Type _type_7 = param.getType();
                boolean _equals_1 = this._iQualifiedNameProvider.getFullyQualifiedName(this._ismlModelNavigation.getTypeSpecification(((ParameterizedType) _type_7).getTypeParameters().get(0)).eContainer()).equals(this._iQualifiedNameProvider.getFullyQualifiedName(service.eContainer()));
                boolean _not_12 = (!_equals_1);
                if (_not_12) {
                  Type _type_8 = param.getType();
                  TypeSpecification _typeSpecification_6 = this._ismlModelNavigation.getTypeSpecification(((ParameterizedType) _type_8).getTypeParameters().get(0));
                  boolean _not_13 = (!(_typeSpecification_6 instanceof Primitive));
                  if (_not_13) {
                    Type _type_9 = param.getType();
                    TypeSpecification _typeSpecification_7 = this._ismlModelNavigation.getTypeSpecification(((ParameterizedType) _type_9).getTypeParameters().get(0));
                    boolean _not_14 = (!(_typeSpecification_7 instanceof GenericTypeSpecification));
                    if (_not_14) {
                      Type _type_10 = param.getType();
                      boolean _containsKey_3 = imports.containsKey(this._iQualifiedNameProvider.getFullyQualifiedName(this._ismlModelNavigation.getTypeSpecification(((ParameterizedType) _type_10).getTypeParameters().get(0))));
                      boolean _not_15 = (!_containsKey_3);
                      if (_not_15) {
                        Type _type_11 = param.getType();
                        Type _type_12 = param.getType();
                        TypeSpecification _typeSpecification_8 = this._ismlModelNavigation.getTypeSpecification(((ParameterizedType) _type_12).getTypeParameters().get(0));
                        imports.put(this._iQualifiedNameProvider.getFullyQualifiedName(this._ismlModelNavigation.getTypeSpecification(((ParameterizedType) _type_11).getTypeParameters().get(0))), 
                          ((Entity) _typeSpecification_8));
                      }
                    }
                  }
                }
              }
            }
          }
          EList<MethodStatement> _body = ((Method)feature).getBody();
          boolean _notEquals = (!Objects.equal(_body, null));
          if (_notEquals) {
            EList<MethodStatement> _body_1 = ((Method)feature).getBody();
            for (final MethodStatement stmnt : _body_1) {
              this._ismlModelNavigation.isNeededImportInBody(IteratorExtensions.<EObject>toList(stmnt.eAllContents()), imports, service);
            }
          }
        }
      }
    }
    return imports;
  }
  
  public boolean isComplexObjectPresentInParameters(final Method feature) {
    EList<Parameter> _parameters = feature.getParameters();
    for (final Parameter param : _parameters) {
      if (((!(this._ismlModelNavigation.getTypeSpecification(param.getType()) instanceof Primitive)) || this._typeChecker.isCollection(param.getType()))) {
        return true;
      }
    }
    return false;
  }
  
  public String writeType(final Type type, final boolean complete) {
    String typeString = "";
    String _name = this._ismlModelNavigation.getTypeSpecification(type).getName();
    if (_name != null) {
      switch (_name) {
        case "Any":
          typeString = "Object";
          break;
        case "Type":
          typeString = this._ismlModelNavigation.getClassValue(type);
          break;
        case "Void":
          typeString = "void";
          break;
        case "Null":
          typeString = "null";
          break;
        case "Integer":
          typeString = "Long";
          break;
        case "Array":
          typeString = "List";
          break;
        default:
          typeString = this._ismlModelNavigation.getTypeString(type);
          break;
      }
    } else {
      typeString = this._ismlModelNavigation.getTypeString(type);
    }
    return typeString;
  }
}
