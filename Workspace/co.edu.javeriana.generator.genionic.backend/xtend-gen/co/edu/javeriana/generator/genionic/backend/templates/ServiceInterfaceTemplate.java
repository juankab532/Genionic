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
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ServiceInterfaceTemplate extends SimpleTemplate<Service> {
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Inject
  @Extension
  private IsmlModelNavigation _ismlModelNavigation;
  
  @Inject
  @Extension
  private TypeChecker _typeChecker;
  
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
    _builder.append(".interfaces;\t\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.*;");
    _builder.newLine();
    _builder.append("import javax.ejb.Local; ");
    _builder.newLine();
    _builder.append("import javax.ws.rs.*;\t\t");
    _builder.newLine();
    _builder.append("import javax.ws.rs.core.*;");
    _builder.newLine();
    _builder.append("import javax.persistence.Query;");
    _builder.newLine();
    _builder.append("import backend.entities.*;");
    _builder.newLine();
    {
      EList<Type> _superTypes = service.getSuperTypes();
      for(final Type superType : _superTypes) {
        _builder.append("import ");
        QualifiedName _fullyQualifiedName_1 = this._iQualifiedNameProvider.getFullyQualifiedName(this._ismlModelNavigation.getTypeSpecification(superType));
        _builder.append(_fullyQualifiedName_1);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* This interface represents the local instance for the ");
    String _firstUpper = StringExtensions.toFirstUpper(service.getName());
    _builder.append(_firstUpper, " ");
    _builder.append("Bean EJB ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("@Local");
    _builder.newLine();
    _builder.append("@Path(\"/");
    String _firstLower = StringExtensions.toFirstLower(service.getName());
    _builder.append(_firstLower);
    _builder.append("\")");
    _builder.newLineIfNotEmpty();
    _builder.append("public interface ");
    String _firstUpper_1 = StringExtensions.toFirstUpper(service.getName());
    _builder.append(_firstUpper_1);
    _builder.append("{");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<Type> _superTypes_1 = service.getSuperTypes();
      for(final Type type : _superTypes_1) {
        {
          Iterable<Feature> _features = this._ismlModelNavigation.getFeatures(this._ismlModelNavigation.getTypeSpecification(type));
          for(final Feature feature : _features) {
            {
              if ((feature instanceof Method)) {
                _builder.append("\t");
                _builder.append("/**");
                _builder.newLine();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("* This method executes the proper actions for ");
                String _name = ((Method)feature).getName();
                _builder.append(_name, "\t ");
                _builder.newLineIfNotEmpty();
                {
                  EList<Parameter> _parameters = ((Method)feature).getParameters();
                  for(final Parameter param : _parameters) {
                    _builder.append("\t");
                    _builder.append(" ");
                    _builder.append("* @param ");
                    String _firstLower_1 = StringExtensions.toFirstLower(param.getName());
                    _builder.append(_firstLower_1, "\t ");
                    _builder.append(" Parameter from type ");
                    String _firstUpper_2 = StringExtensions.toFirstUpper(this._ismlModelNavigation.getTypeSpecification(param.getType()).getName());
                    _builder.append(_firstUpper_2, "\t ");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  if (((!Objects.equal(((Method)feature).getType(), null)) && (!this._ismlModelNavigation.getTypeSpecification(((Method)feature).getType()).getName().equalsIgnoreCase("Void")))) {
                    _builder.append("\t");
                    _builder.append(" ");
                    _builder.append("* @return Some ");
                    String _writeType = this.writeType(this._ismlModelNavigation.getReplacedType(service, ((Method)feature).getType()), true);
                    _builder.append(_writeType, "\t ");
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
                    _builder.append("public ");
                    String _writeType_1 = this.writeType(this._ismlModelNavigation.getReplacedType(service, ((Method)feature).getType()), true);
                    _builder.append(_writeType_1, "\t");
                    _builder.append(" ");
                    String _name_1 = ((Method)feature).getName();
                    _builder.append(_name_1, "\t");
                    _builder.append("(");
                    {
                      EList<Parameter> _parameters_1 = ((Method)feature).getParameters();
                      boolean _hasElements = false;
                      for(final Parameter param_1 : _parameters_1) {
                        if (!_hasElements) {
                          _hasElements = true;
                        } else {
                          _builder.appendImmediate(",", "\t");
                        }
                        String _writeType_2 = this.writeType(this._ismlModelNavigation.getReplacedType(service, param_1.getType()), true);
                        _builder.append(_writeType_2, "\t");
                        _builder.append(" ");
                        String _firstLower_2 = StringExtensions.toFirstLower(param_1.getName());
                        _builder.append(_firstLower_2, "\t");
                      }
                    }
                    _builder.append(");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.newLine();
                  } else {
                    {
                      boolean _equalsIgnoreCase = this._ismlModelNavigation.getTypeSpecification(((Method)feature).getType()).getName().equalsIgnoreCase("void");
                      if (_equalsIgnoreCase) {
                        _builder.append("\t");
                        _builder.append("@POST");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("@Consumes(MediaType.APPLICATION_JSON)");
                        _builder.newLine();
                      } else {
                        _builder.append("\t");
                        _builder.append("@GET");
                        _builder.newLine();
                        _builder.append("\t");
                        _builder.append("@Produces(MediaType.APPLICATION_JSON)");
                        _builder.newLine();
                      }
                    }
                    _builder.append("\t");
                    _builder.append("@Path(\"/");
                    String _name_2 = ((Method)feature).getName();
                    _builder.append(_name_2, "\t");
                    {
                      boolean _isComplexObjectPresentInParameters = this.isComplexObjectPresentInParameters(((Method)feature));
                      boolean _not = (!_isComplexObjectPresentInParameters);
                      if (_not) {
                        {
                          EList<Parameter> _parameters_2 = ((Method)feature).getParameters();
                          for(final Parameter param_2 : _parameters_2) {
                            {
                              if (((!this._ismlModelNavigation.getTypeSpecification(((Method)feature).getType()).getName().equalsIgnoreCase("void")) || ((this._ismlModelNavigation.getTypeSpecification(param_2.getType()) instanceof Primitive) && (!this._typeChecker.isCollection(param_2.getType()))))) {
                                _builder.append("/{");
                                String _name_3 = param_2.getName();
                                _builder.append(_name_3, "\t");
                                _builder.append("}");
                              }
                            }
                          }
                        }
                      }
                    }
                    _builder.append("\")\t\t\t\t\t");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("public ");
                    String _writeType_3 = this.writeType(this._ismlModelNavigation.getReplacedType(service, ((Method)feature).getType()), true);
                    _builder.append(_writeType_3, "\t");
                    _builder.append(" ");
                    String _name_4 = ((Method)feature).getName();
                    _builder.append(_name_4, "\t");
                    _builder.append("(");
                    {
                      EList<Parameter> _parameters_3 = ((Method)feature).getParameters();
                      boolean _hasElements_1 = false;
                      for(final Parameter parameter : _parameters_3) {
                        if (!_hasElements_1) {
                          _hasElements_1 = true;
                        } else {
                          _builder.appendImmediate(",", "\t");
                        }
                        {
                          boolean _equalsIgnoreCase_1 = this._ismlModelNavigation.getTypeSpecification(((Method)feature).getType()).getName().equalsIgnoreCase("void");
                          boolean _not_1 = (!_equalsIgnoreCase_1);
                          if (_not_1) {
                            _builder.append("@PathParam(\"");
                            String _firstLower_3 = StringExtensions.toFirstLower(parameter.getName());
                            _builder.append(_firstLower_3, "\t");
                            _builder.append("\")");
                          } else {
                            {
                              if ((((this._ismlModelNavigation.getTypeSpecification(((Method)feature).getType()).getName().equalsIgnoreCase("void") && (this._ismlModelNavigation.getTypeSpecification(parameter.getType()) instanceof Primitive)) && (!this._typeChecker.isCollection(parameter.getType()))) && (((Method)feature).getParameters().size() == 1))) {
                                _builder.append("@PathParam(\"");
                                String _firstLower_4 = StringExtensions.toFirstLower(parameter.getName());
                                _builder.append(_firstLower_4, "\t");
                                _builder.append("\")");
                              } else {
                                {
                                  if ((this._ismlModelNavigation.getTypeSpecification(((Method)feature).getType()).getName().equalsIgnoreCase("void") && (((Method)feature).getParameters().size() != 1))) {
                                    _builder.append("@QueryParam(\"");
                                    String _firstLower_5 = StringExtensions.toFirstLower(parameter.getName());
                                    _builder.append(_firstLower_5, "\t");
                                    _builder.append("\")");
                                  }
                                }
                              }
                            }
                          }
                        }
                        {
                          if ((this._ismlModelNavigation.getTypeSpecification(((Method)feature).getType()).getName().equalsIgnoreCase("void") && (((Method)feature).getParameters().size() != 1))) {
                            _builder.append("String ");
                            String _firstLower_6 = StringExtensions.toFirstLower(parameter.getName());
                            _builder.append(_firstLower_6, "\t");
                          } else {
                            String _writeType_4 = this.writeType(this._ismlModelNavigation.getReplacedType(service, parameter.getType()), true);
                            _builder.append(_writeType_4, "\t");
                            _builder.append(" ");
                            String _firstLower_7 = StringExtensions.toFirstLower(parameter.getName());
                            _builder.append(_firstLower_7, "\t");
                          }
                        }
                      }
                    }
                    _builder.append(");");
                    _builder.newLineIfNotEmpty();
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
      Iterable<Feature> _features_1 = this._ismlModelNavigation.getFeatures(service);
      for(final Feature feature_1 : _features_1) {
        {
          if ((feature_1 instanceof Method)) {
            _builder.append("\t");
            _builder.append("/**");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("* This method executes the proper actions for ");
            String _name_5 = ((Method)feature_1).getName();
            _builder.append(_name_5, "\t ");
            _builder.newLineIfNotEmpty();
            {
              EList<Parameter> _parameters_4 = ((Method)feature_1).getParameters();
              for(final Parameter param_3 : _parameters_4) {
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("* @param ");
                String _firstLower_8 = StringExtensions.toFirstLower(param_3.getName());
                _builder.append(_firstLower_8, "\t ");
                _builder.append(" Parameter from type ");
                String _firstUpper_3 = StringExtensions.toFirstUpper(this._ismlModelNavigation.getTypeSpecification(param_3.getType()).getName());
                _builder.append(_firstUpper_3, "\t ");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              if (((!Objects.equal(((Method)feature_1).getType(), null)) && (!this._ismlModelNavigation.getTypeSpecification(((Method)feature_1).getType()).getName().equalsIgnoreCase("Void")))) {
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("* @return Some ");
                String _writeType_5 = this.writeType(this._ismlModelNavigation.getReplacedType(service, ((Method)feature_1).getType()), true);
                _builder.append(_writeType_5, "\t ");
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
                _builder.append("public ");
                String _writeType_6 = this.writeType(this._ismlModelNavigation.getReplacedType(service, ((Method)feature_1).getType()), true);
                _builder.append(_writeType_6, "\t");
                _builder.append(" ");
                String _name_6 = ((Method)feature_1).getName();
                _builder.append(_name_6, "\t");
                _builder.append("(");
                {
                  EList<Parameter> _parameters_5 = ((Method)feature_1).getParameters();
                  boolean _hasElements_2 = false;
                  for(final Parameter param_4 : _parameters_5) {
                    if (!_hasElements_2) {
                      _hasElements_2 = true;
                    } else {
                      _builder.appendImmediate(",", "\t");
                    }
                    String _writeType_7 = this.writeType(this._ismlModelNavigation.getReplacedType(service, ((Method)feature_1).getType()), true);
                    _builder.append(_writeType_7, "\t");
                    _builder.append(" ");
                    String _firstLower_9 = StringExtensions.toFirstLower(service.getName());
                    _builder.append(_firstLower_9, "\t");
                  }
                }
                _builder.append(");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("/**");
                _builder.newLine();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("* This method executes the proper actions for ");
                String _name_7 = ((Method)feature_1).getName();
                _builder.append(_name_7, "\t ");
                _builder.newLineIfNotEmpty();
                {
                  EList<Parameter> _parameters_6 = ((Method)feature_1).getParameters();
                  for(final Parameter param_5 : _parameters_6) {
                    _builder.append("\t");
                    _builder.append(" ");
                    _builder.append("* @param ");
                    String _firstLower_10 = StringExtensions.toFirstLower(param_5.getName());
                    _builder.append(_firstLower_10, "\t ");
                    _builder.append(" Parameter from type ");
                    String _firstUpper_4 = StringExtensions.toFirstUpper(this._ismlModelNavigation.getTypeSpecification(param_5.getType()).getName());
                    _builder.append(_firstUpper_4, "\t ");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  if (((!Objects.equal(((Method)feature_1).getType(), null)) && (!this._ismlModelNavigation.getTypeSpecification(((Method)feature_1).getType()).getName().equalsIgnoreCase("Void")))) {
                    _builder.append("\t");
                    _builder.append(" ");
                    _builder.append("* @return Some ");
                    String _writeType_8 = this.writeType(this._ismlModelNavigation.getReplacedType(service, ((Method)feature_1).getType()), true);
                    _builder.append(_writeType_8, "\t ");
                    _builder.append(" object");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("*/");
                _builder.newLine();
                {
                  boolean _equalsIgnoreCase_2 = this._ismlModelNavigation.getTypeSpecification(((Method)feature_1).getType()).getName().equalsIgnoreCase("void");
                  if (_equalsIgnoreCase_2) {
                    _builder.append("\t");
                    _builder.append("@POST");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("@Consumes(MediaType.APPLICATION_JSON)");
                    _builder.newLine();
                  } else {
                    _builder.append("\t");
                    _builder.append("@GET");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("@Produces(MediaType.APPLICATION_JSON)");
                    _builder.newLine();
                  }
                }
                _builder.append("\t");
                _builder.append("@Path(\"/");
                String _name_8 = ((Method)feature_1).getName();
                _builder.append(_name_8, "\t");
                {
                  boolean _isComplexObjectPresentInParameters_1 = this.isComplexObjectPresentInParameters(((Method)feature_1));
                  boolean _not_2 = (!_isComplexObjectPresentInParameters_1);
                  if (_not_2) {
                    {
                      EList<Parameter> _parameters_7 = ((Method)feature_1).getParameters();
                      for(final Parameter param_6 : _parameters_7) {
                        {
                          if (((!this._ismlModelNavigation.getTypeSpecification(((Method)feature_1).getType()).getName().equalsIgnoreCase("void")) || ((this._ismlModelNavigation.getTypeSpecification(param_6.getType()) instanceof Primitive) && (!this._typeChecker.isCollection(param_6.getType()))))) {
                            _builder.append("/{");
                            String _name_9 = param_6.getName();
                            _builder.append(_name_9, "\t");
                            _builder.append("}");
                          }
                        }
                      }
                    }
                  }
                }
                _builder.append("\")\t\t\t\t\t");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("public ");
                String _writeType_9 = this.writeType(this._ismlModelNavigation.getReplacedType(service, ((Method)feature_1).getType()), true);
                _builder.append(_writeType_9, "\t");
                _builder.append(" ");
                String _name_10 = ((Method)feature_1).getName();
                _builder.append(_name_10, "\t");
                _builder.append("(");
                {
                  EList<Parameter> _parameters_8 = ((Method)feature_1).getParameters();
                  boolean _hasElements_3 = false;
                  for(final Parameter parameter_1 : _parameters_8) {
                    if (!_hasElements_3) {
                      _hasElements_3 = true;
                    } else {
                      _builder.appendImmediate(",", "\t");
                    }
                    {
                      boolean _equalsIgnoreCase_3 = this._ismlModelNavigation.getTypeSpecification(((Method)feature_1).getType()).getName().equalsIgnoreCase("void");
                      boolean _not_3 = (!_equalsIgnoreCase_3);
                      if (_not_3) {
                        _builder.append("@PathParam(\"");
                        String _firstLower_11 = StringExtensions.toFirstLower(parameter_1.getName());
                        _builder.append(_firstLower_11, "\t");
                        _builder.append("\")");
                      } else {
                        {
                          if ((((this._ismlModelNavigation.getTypeSpecification(((Method)feature_1).getType()).getName().equalsIgnoreCase("void") && (this._ismlModelNavigation.getTypeSpecification(parameter_1.getType()) instanceof Primitive)) && (!this._typeChecker.isCollection(parameter_1.getType()))) && (((Method)feature_1).getParameters().size() == 1))) {
                            _builder.append("@PathParam(\"");
                            String _firstLower_12 = StringExtensions.toFirstLower(parameter_1.getName());
                            _builder.append(_firstLower_12, "\t");
                            _builder.append("\")");
                          } else {
                            {
                              if ((this._ismlModelNavigation.getTypeSpecification(((Method)feature_1).getType()).getName().equalsIgnoreCase("void") && (((Method)feature_1).getParameters().size() != 1))) {
                                _builder.append("@QueryParam(\"");
                                String _firstLower_13 = StringExtensions.toFirstLower(parameter_1.getName());
                                _builder.append(_firstLower_13, "\t");
                                _builder.append("\")");
                              }
                            }
                          }
                        }
                      }
                    }
                    {
                      if ((this._ismlModelNavigation.getTypeSpecification(((Method)feature_1).getType()).getName().equalsIgnoreCase("void") && (((Method)feature_1).getParameters().size() != 1))) {
                        _builder.append("String ");
                        String _firstLower_14 = StringExtensions.toFirstLower(parameter_1.getName());
                        _builder.append(_firstLower_14, "\t");
                      } else {
                        String _writeType_10 = this.writeType(this._ismlModelNavigation.getReplacedType(service, parameter_1.getType()), true);
                        _builder.append(_writeType_10, "\t");
                        _builder.append(" ");
                        String _firstLower_15 = StringExtensions.toFirstLower(parameter_1.getName());
                        _builder.append(_firstLower_15, "\t");
                      }
                    }
                  }
                }
                _builder.append(");");
                _builder.newLineIfNotEmpty();
              } else {
                {
                  boolean _equalsIgnoreCase_4 = this._ismlModelNavigation.getTypeSpecification(((Method)feature_1).getType()).getName().equalsIgnoreCase("void");
                  if (_equalsIgnoreCase_4) {
                    _builder.append("\t");
                    _builder.append("@POST");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("@Consumes(MediaType.APPLICATION_JSON)");
                    _builder.newLine();
                  } else {
                    _builder.append("\t");
                    _builder.append("@GET");
                    _builder.newLine();
                    _builder.append("\t");
                    _builder.append("@Produces(MediaType.APPLICATION_JSON)");
                    _builder.newLine();
                  }
                }
                _builder.append("\t");
                _builder.append("@Path(\"/");
                String _name_11 = ((Method)feature_1).getName();
                _builder.append(_name_11, "\t");
                {
                  boolean _isComplexObjectPresentInParameters_2 = this.isComplexObjectPresentInParameters(((Method)feature_1));
                  boolean _not_4 = (!_isComplexObjectPresentInParameters_2);
                  if (_not_4) {
                    {
                      EList<Parameter> _parameters_9 = ((Method)feature_1).getParameters();
                      for(final Parameter param_7 : _parameters_9) {
                        {
                          if (((!this._ismlModelNavigation.getTypeSpecification(((Method)feature_1).getType()).getName().equalsIgnoreCase("void")) || ((this._ismlModelNavigation.getTypeSpecification(param_7.getType()) instanceof Primitive) && (!this._typeChecker.isCollection(param_7.getType()))))) {
                            _builder.append("/{");
                            String _name_12 = param_7.getName();
                            _builder.append(_name_12, "\t");
                            _builder.append("}");
                          }
                        }
                      }
                    }
                  }
                }
                _builder.append("\")\t\t\t\t\t");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("public ");
                String _writeType_11 = this.writeType(this._ismlModelNavigation.getReplacedType(service, ((Method)feature_1).getType()), true);
                _builder.append(_writeType_11, "\t");
                _builder.append(" ");
                String _name_13 = ((Method)feature_1).getName();
                _builder.append(_name_13, "\t");
                _builder.append("(");
                {
                  EList<Parameter> _parameters_10 = ((Method)feature_1).getParameters();
                  boolean _hasElements_4 = false;
                  for(final Parameter parameter_2 : _parameters_10) {
                    if (!_hasElements_4) {
                      _hasElements_4 = true;
                    } else {
                      _builder.appendImmediate(",", "\t");
                    }
                    {
                      boolean _equalsIgnoreCase_5 = this._ismlModelNavigation.getTypeSpecification(((Method)feature_1).getType()).getName().equalsIgnoreCase("void");
                      boolean _not_5 = (!_equalsIgnoreCase_5);
                      if (_not_5) {
                        _builder.append("@PathParam(\"");
                        String _firstLower_16 = StringExtensions.toFirstLower(parameter_2.getName());
                        _builder.append(_firstLower_16, "\t");
                        _builder.append("\")");
                      } else {
                        {
                          if ((((this._ismlModelNavigation.getTypeSpecification(((Method)feature_1).getType()).getName().equalsIgnoreCase("void") && (this._ismlModelNavigation.getTypeSpecification(parameter_2.getType()) instanceof Primitive)) && (!this._typeChecker.isCollection(parameter_2.getType()))) && (((Method)feature_1).getParameters().size() == 1))) {
                            _builder.append("@PathParam(\"");
                            String _firstLower_17 = StringExtensions.toFirstLower(parameter_2.getName());
                            _builder.append(_firstLower_17, "\t");
                            _builder.append("\")");
                          } else {
                            {
                              if ((this._ismlModelNavigation.getTypeSpecification(((Method)feature_1).getType()).getName().equalsIgnoreCase("void") && (((Method)feature_1).getParameters().size() != 1))) {
                                _builder.append("@QueryParam(\"");
                                String _firstLower_18 = StringExtensions.toFirstLower(parameter_2.getName());
                                _builder.append(_firstLower_18, "\t");
                                _builder.append("\")");
                              }
                            }
                          }
                        }
                      }
                    }
                    {
                      if ((this._ismlModelNavigation.getTypeSpecification(((Method)feature_1).getType()).getName().equalsIgnoreCase("void") && (((Method)feature_1).getParameters().size() != 1))) {
                        _builder.append("String ");
                        String _firstLower_19 = StringExtensions.toFirstLower(parameter_2.getName());
                        _builder.append(_firstLower_19, "\t");
                      } else {
                        String _writeType_12 = this.writeType(this._ismlModelNavigation.getReplacedType(service, parameter_2.getType()), true);
                        _builder.append(_writeType_12, "\t");
                        _builder.append(" ");
                        String _firstLower_20 = StringExtensions.toFirstLower(parameter_2.getName());
                        _builder.append(_firstLower_20, "\t");
                      }
                    }
                  }
                }
                _builder.append(");");
                _builder.newLineIfNotEmpty();
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
                String _name_14 = ((Attribute)feature_1).getName();
                _builder.append(_name_14, "\t ");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("*");
                _builder.newLine();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("* @return Some ");
                String _writeType_13 = this.writeType(this._ismlModelNavigation.getReplacedType(service, ((Attribute)feature_1).getType()), true);
                _builder.append(_writeType_13, "\t ");
                _builder.append(" object");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("*/");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("public ");
                String _writeType_14 = this.writeType(this._ismlModelNavigation.getReplacedType(service, ((Attribute)feature_1).getType()), true);
                _builder.append(_writeType_14, "\t");
                _builder.append(" get");
                String _firstUpper_5 = StringExtensions.toFirstUpper(((Attribute)feature_1).getName());
                _builder.append(_firstUpper_5, "\t");
                _builder.append("();");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("/**");
                _builder.newLine();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("* Sets the value for the attribute ");
                String _name_15 = ((Attribute)feature_1).getName();
                _builder.append(_name_15, "\t ");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("*");
                _builder.newLine();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("* @param ");
                String _firstLower_21 = StringExtensions.toFirstLower(((Attribute)feature_1).getName());
                _builder.append(_firstLower_21, "\t ");
                _builder.append(" The value to set");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("*/");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("public void set");
                String _firstUpper_6 = StringExtensions.toFirstUpper(((Attribute)feature_1).getName());
                _builder.append(_firstUpper_6, "\t");
                _builder.append("(");
                String _writeType_15 = this.writeType(this._ismlModelNavigation.getReplacedType(service, ((Attribute)feature_1).getType()), true);
                _builder.append(_writeType_15, "\t");
                _builder.append(" ");
                String _firstLower_22 = StringExtensions.toFirstLower(((Attribute)feature_1).getName());
                _builder.append(_firstLower_22, "\t");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
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
  
  /**
   * Metodo que obtiene las dependencias necesarias de los servicios
   */
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
  
  public boolean hasComplexMethod(final Service service) {
    Iterable<Method> _filter = Iterables.<Method>filter(this._ismlModelNavigation.getFeatures(service), Method.class);
    for (final Method feature : _filter) {
      if (((this._ismlModelNavigation.getTypeSpecification(feature.getType()).getName().equalsIgnoreCase("void") && this.isComplexObjectPresentInParameters(feature)) && (feature.getParameters().size() != 1))) {
        return true;
      }
    }
    EList<Type> _superTypes = service.getSuperTypes();
    for (final Type superType : _superTypes) {
      Iterable<Method> _filter_1 = Iterables.<Method>filter(this._ismlModelNavigation.getFeatures(this._ismlModelNavigation.getTypeSpecification(superType)), Method.class);
      for (final Method feature_1 : _filter_1) {
        if (((this._ismlModelNavigation.getTypeSpecification(feature_1.getType()).getName().equalsIgnoreCase("void") && this.isComplexObjectPresentInParameters(feature_1)) && (feature_1.getParameters().size() != 1))) {
          return true;
        }
      }
    }
    return false;
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
