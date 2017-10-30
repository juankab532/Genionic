package co.edu.javeriana.generator.genionic.templates;

import co.edu.javeriana.generator.genionic.templates.ExtraGenionic;
import co.edu.javeriana.isml.generator.common.SimpleTemplate;
import co.edu.javeriana.isml.isml.Action;
import co.edu.javeriana.isml.isml.ActionCall;
import co.edu.javeriana.isml.isml.Assignment;
import co.edu.javeriana.isml.isml.Attribute;
import co.edu.javeriana.isml.isml.BinaryOperator;
import co.edu.javeriana.isml.isml.Controller;
import co.edu.javeriana.isml.isml.Entity;
import co.edu.javeriana.isml.isml.Expression;
import co.edu.javeriana.isml.isml.For;
import co.edu.javeriana.isml.isml.If;
import co.edu.javeriana.isml.isml.MethodCall;
import co.edu.javeriana.isml.isml.MethodStatement;
import co.edu.javeriana.isml.isml.NamedElement;
import co.edu.javeriana.isml.isml.Page;
import co.edu.javeriana.isml.isml.Parameter;
import co.edu.javeriana.isml.isml.ParameterizedType;
import co.edu.javeriana.isml.isml.Reference;
import co.edu.javeriana.isml.isml.ResourceReference;
import co.edu.javeriana.isml.isml.Return;
import co.edu.javeriana.isml.isml.Service;
import co.edu.javeriana.isml.isml.Show;
import co.edu.javeriana.isml.isml.StringValue;
import co.edu.javeriana.isml.isml.StructInstance;
import co.edu.javeriana.isml.isml.Type;
import co.edu.javeriana.isml.isml.TypeSpecification;
import co.edu.javeriana.isml.isml.TypedElement;
import co.edu.javeriana.isml.isml.Variable;
import co.edu.javeriana.isml.isml.VariableReference;
import co.edu.javeriana.isml.isml.ViewInstance;
import co.edu.javeriana.isml.isml.While;
import co.edu.javeriana.isml.isml.impl.IntValueImpl;
import co.edu.javeriana.isml.scoping.IsmlModelNavigation;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ControllerTemplate extends SimpleTemplate<Controller> {
  @Inject
  @Extension
  private IsmlModelNavigation _ismlModelNavigation;
  
  @Inject
  @Extension
  private ExtraGenionic _extraGenionic;
  
  private Controller ctrl;
  
  private List<MethodStatement> elementsMethod;
  
  private HashSet<String> valueSet = new HashSet<String>();
  
  private List<TypedElement> imports = new ArrayList<TypedElement>();
  
  private Set<Entity> entities = new LinkedHashSet<Entity>();
  
  private Set<Service> services = new LinkedHashSet<Service>();
  
  private Set<Page> calledPages = new LinkedHashSet<Page>();
  
  private Set<Page> relatedPages = new LinkedHashSet<Page>();
  
  public Show lastShowMethod;
  
  @Override
  public void preprocess(final Controller c) {
    this._extraGenionic.setControllerTemplate(this);
    this.ctrl = c;
    final List<TypedElement> descendants = IteratorExtensions.<TypedElement>toList(Iterators.<TypedElement>filter(c.eAllContents(), TypedElement.class));
    this.imports.addAll(descendants);
    for (final TypedElement desc : descendants) {
      {
        Type _type = desc.getType();
        TypeSpecification _typeSpecification = null;
        if (_type!=null) {
          _typeSpecification=this._ismlModelNavigation.getTypeSpecification(_type);
        }
        final NamedElement e = _typeSpecification;
        if ((e instanceof Entity)) {
          this.entities.add(((Entity)e));
        } else {
          if ((e instanceof Service)) {
            this.services.add(((Service)e));
          } else {
            if ((e instanceof Page)) {
              this.calledPages.add(((Page)e));
            }
          }
        }
      }
    }
    EList<Page> _controlledPages = this._ismlModelNavigation.getControlledPages(c);
    for (final Page p : _controlledPages) {
      this.relatedPages.add(p);
    }
  }
  
  @Override
  protected CharSequence template(final Controller c) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import { Component } from \'@angular/core\';");
    _builder.newLine();
    _builder.append("import { IonicPage, NavController, NavParams } from \'ionic-angular\';");
    _builder.newLine();
    _builder.append("import { Persistence } from \"../../providers/persistence/persistence\";");
    _builder.newLine();
    _builder.append("import { Http } from \'@angular/http\';");
    _builder.newLine();
    _builder.append("import { CameraService } from \"../../providers/camera-service/camera-service\";");
    _builder.newLine();
    _builder.append("import { MapService } from \"../../providers/map-service/map-service\";");
    _builder.newLine();
    _builder.newLine();
    {
      for(final Entity elm : this.entities) {
        {
          String _name = elm.getName();
          String _firstUpper = StringExtensions.toFirstUpper(c.getName().toLowerCase());
          int _length = c.getName().length();
          int _minus = (_length - 1);
          CharSequence _subSequence = _firstUpper.subSequence(0, _minus);
          String _plus = (_subSequence + "E");
          boolean _equalsIgnoreCase = _name.equalsIgnoreCase(_plus);
          if (_equalsIgnoreCase) {
            _builder.append("import { ");
            String _name_1 = elm.getName();
            _builder.append(_name_1);
            _builder.append(" } from \'./");
            String _lowerCase = elm.getName().toLowerCase();
            _builder.append(_lowerCase);
            _builder.append("\';");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("import { ");
            String _name_2 = elm.getName();
            _builder.append(_name_2);
            _builder.append(" } from \'../");
            String _lowerCase_1 = elm.getName().toLowerCase();
            int _length_1 = elm.getName().length();
            int _minus_1 = (_length_1 - 1);
            String _substring = _lowerCase_1.substring(0, _minus_1);
            _builder.append(_substring);
            _builder.append("/");
            String _lowerCase_2 = elm.getName().toLowerCase();
            _builder.append(_lowerCase_2);
            _builder.append("\';");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      for(final Page elm_1 : this.calledPages) {
        {
          String _name_3 = elm_1.getName();
          String _firstUpper_1 = StringExtensions.toFirstUpper(c.getName().toLowerCase());
          int _length_2 = c.getName().length();
          int _minus_2 = (_length_2 - 1);
          CharSequence _subSequence_1 = _firstUpper_1.subSequence(0, _minus_2);
          String _plus_1 = (_subSequence_1 + "V");
          boolean _equalsIgnoreCase_1 = _name_3.equalsIgnoreCase(_plus_1);
          boolean _not = (!_equalsIgnoreCase_1);
          if (_not) {
            _builder.append("import { ");
            String _firstUpper_2 = StringExtensions.toFirstUpper(elm_1.getName().toLowerCase());
            int _length_3 = elm_1.getName().length();
            int _minus_3 = (_length_3 - 1);
            String _substring_1 = _firstUpper_2.substring(0, _minus_3);
            _builder.append(_substring_1);
            _builder.append("cPage } from \'../");
            String _lowerCase_3 = elm_1.getName().toLowerCase();
            int _length_4 = elm_1.getName().length();
            int _minus_4 = (_length_4 - 1);
            String _substring_2 = _lowerCase_3.substring(0, _minus_4);
            _builder.append(_substring_2);
            _builder.append("/");
            String _lowerCase_4 = elm_1.getName().toLowerCase();
            int _length_5 = elm_1.getName().length();
            int _minus_5 = (_length_5 - 1);
            String _substring_3 = _lowerCase_4.substring(0, _minus_5);
            _builder.append(_substring_3);
            _builder.append("c\';");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.newLine();
    _builder.append("@IonicPage()");
    _builder.newLine();
    _builder.append("@Component({");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("selector: \'page-");
    String _lowerCase_5 = c.getName().toLowerCase();
    int _length_6 = c.getName().length();
    int _minus_6 = (_length_6 - 1);
    String _substring_4 = _lowerCase_5.substring(0, _minus_6);
    String _plus_2 = (_substring_4 + "v");
    _builder.append(_plus_2, "  ");
    _builder.append("\',");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("templateUrl: \'");
    String _lowerCase_6 = c.getName().toLowerCase();
    int _length_7 = c.getName().length();
    int _minus_7 = (_length_7 - 1);
    String _substring_5 = _lowerCase_6.substring(0, _minus_7);
    String _plus_3 = (_substring_5 + "v");
    _builder.append(_plus_3, "  ");
    _builder.append(".html\',");
    _builder.newLineIfNotEmpty();
    _builder.append("})");
    _builder.newLine();
    _builder.append("export class ");
    String _firstUpper_3 = StringExtensions.toFirstUpper(c.getName().toLowerCase());
    _builder.append(_firstUpper_3);
    _builder.append("Page {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      Iterable<Attribute> _filter = Iterables.<Attribute>filter(c.getBody(), Attribute.class);
      for(final Attribute attr : _filter) {
        {
          if (((!this._ismlModelNavigation.getTypeSpecification(attr.getType()).getName().equalsIgnoreCase("CameraService")) && (!this._ismlModelNavigation.getTypeSpecification(attr.getType()).getName().equalsIgnoreCase("MapService")))) {
            _builder.append("\t");
            String _name_4 = attr.getName();
            _builder.append(_name_4, "\t");
            _builder.append(":");
            CharSequence _generateType = this._extraGenionic.generateType(this._ismlModelNavigation.getTypeSpecification(attr.getType()).getName());
            _builder.append(_generateType, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("constructor(public navCtrl\t\t: NavController, ");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("public navParams\t: NavParams,");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("public cam\t\t\t: CameraService,");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("public mapService   : MapService,");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("public http\t\t\t: Http");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append(") {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("/*Asigna la Persistencia*/");
    _builder.newLine();
    {
      Iterable<Attribute> _filter_1 = Iterables.<Attribute>filter(c.getBody(), Attribute.class);
      for(final Attribute attr_1 : _filter_1) {
        {
          boolean _equalsIgnoreCase_2 = this._ismlModelNavigation.getTypeSpecification(attr_1.getType()).getName().equalsIgnoreCase("Persistence");
          if (_equalsIgnoreCase_2) {
            _builder.append("\t\t");
            _builder.append("this.");
            String _name_5 = attr_1.getName();
            _builder.append(_name_5, "\t\t");
            _builder.append("= new ");
            CharSequence _generateType_1 = this._extraGenionic.generateType(this._ismlModelNavigation.getTypeSpecification(attr_1.getType()).getName());
            _builder.append(_generateType_1, "\t\t");
            _builder.append("(http);");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t\t");
    _builder.append("/*Asigna la ruta del servicio a la persistencia*/");
    _builder.newLine();
    {
      Iterable<Attribute> _filter_2 = Iterables.<Attribute>filter(c.getBody(), Attribute.class);
      for(final Attribute attr_2 : _filter_2) {
        {
          boolean _equalsIgnoreCase_3 = this._ismlModelNavigation.getTypeSpecification(attr_2.getType()).getName().equalsIgnoreCase("Persistence");
          if (_equalsIgnoreCase_3) {
            _builder.append("\t\t");
            Type typeEntity = attr_2.getType();
            {
              if ((typeEntity instanceof ParameterizedType)) {
                _builder.append("this.");
                String _name_6 = attr_2.getName();
                _builder.append(_name_6, "\t\t");
                _builder.append(".service=\'");
                String _lowerCase_7 = this._ismlModelNavigation.getTypeSpecification(((ParameterizedType)typeEntity).getTypeParameters().get(0)).getName().toLowerCase();
                int _length_8 = this._ismlModelNavigation.getTypeSpecification(((ParameterizedType)typeEntity).getTypeParameters().get(0)).getName().length();
                int _minus_8 = (_length_8 - 1);
                String _substring_6 = _lowerCase_7.substring(0, _minus_8);
                _builder.append(_substring_6, "\t\t");
                _builder.append("c\';");
              }
            }
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t\t\t\t");
    _builder.newLine();
    {
      Iterable<Action> _actions = this._ismlModelNavigation.getActions(c);
      for(final Action func : _actions) {
        _builder.append("\t\t");
        CharSequence _parametersController = this.getParametersController(func);
        _builder.append(_parametersController, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t  \t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//Metodos\t\t  ");
    _builder.newLine();
    {
      Iterable<Action> _actions_1 = this._ismlModelNavigation.getActions(c);
      for(final Action func_1 : _actions_1) {
        _builder.append("\t");
        CharSequence _generateFunction = this.generateFunction(func_1);
        _builder.append(_generateFunction, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * Obtiene los parametros enviados a la vista
   */
  public CharSequence getParametersController(final Action a) {
    final EList<MethodStatement> ab = a.getBody();
    String txt = "";
    for (final MethodStatement element : ab) {
      if ((element instanceof Show)) {
        final Expression expression = ((Show)element).getExpression();
        if ((expression instanceof ViewInstance)) {
          String _name = this._ismlModelNavigation.getTypeSpecification(((ViewInstance)expression).getType()).getName();
          String _firstUpper = StringExtensions.toFirstUpper(this.ctrl.getName().toLowerCase());
          int _length = this.ctrl.getName().length();
          int _minus = (_length - 1);
          CharSequence _subSequence = _firstUpper.subSequence(0, _minus);
          String _plus = (_subSequence + "V");
          boolean _equalsIgnoreCase = _name.equalsIgnoreCase(_plus);
          if (_equalsIgnoreCase) {
            EList<Expression> _parameters = ((ViewInstance)expression).getParameters();
            for (final Expression p : _parameters) {
              boolean _add = this.valueSet.add(this._extraGenionic.getValue(p).toString());
              if (_add) {
                String _txt = txt;
                CharSequence _typeParameter = this._extraGenionic.typeParameter(p);
                String _plus_1 = (_typeParameter + "");
                CharSequence _value = this._extraGenionic.getValue(p);
                String _plus_2 = (_plus_1 + _value);
                String _plus_3 = (_plus_2 + "=this.navParams.get(\'");
                CharSequence _value_1 = this._extraGenionic.getValue(p);
                String _plus_4 = (_plus_3 + _value_1);
                String _plus_5 = (_plus_4 + "\');");
                txt = (_txt + _plus_5);
              }
            }
          }
        }
      }
    }
    return txt;
  }
  
  /**
   * Genera un método
   */
  public CharSequence generateFunction(final Action action) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = action.getName();
    _builder.append(_name);
    _builder.append("(");
    {
      int _size = action.getParameters().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        CharSequence _parameters = this.getParameters(action);
        _builder.append(_parameters);
      }
    }
    _builder.append("){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _generateBody = this.generateBody(action.getBody());
    _builder.append(_generateBody, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * Recorre cada uno de los elementos  de un método
   */
  public CharSequence generateBody(final List<MethodStatement> lms) {
    CharSequence _xblockexpression = null;
    {
      this.elementsMethod = lms;
      this.lastShowMethod = null;
      StringConcatenation _builder = new StringConcatenation();
      {
        for(final MethodStatement sentence : lms) {
          {
            boolean _notEquals = (!Objects.equal(this.lastShowMethod, sentence));
            if (_notEquals) {
              CharSequence _generateMethodStatement = this.generateMethodStatement(sentence);
              _builder.append(_generateMethodStatement);
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected CharSequence _generateMethodStatement(final Show show) {
    final Expression expression = show.getExpression();
    String txt = "";
    boolean _matched = false;
    if (expression instanceof ViewInstance) {
      _matched=true;
      String _firstUpper = StringExtensions.toFirstUpper(this._ismlModelNavigation.getTypeSpecification(((ViewInstance)expression).getType()).getName().toLowerCase());
      int _length = this._ismlModelNavigation.getTypeSpecification(((ViewInstance)expression).getType()).getName().length();
      int _minus = (_length - 1);
      String _substring = _firstUpper.substring(0, _minus);
      String _plus = ("return this.navCtrl.push(" + _substring);
      String _plus_1 = (_plus + "cPage, ");
      CharSequence _generateArray = this._extraGenionic.generateArray(((ViewInstance)expression));
      String _plus_2 = (_plus_1 + _generateArray);
      String _plus_3 = (_plus_2 + ");");
      txt = _plus_3;
    }
    if (!_matched) {
      txt = "";
    }
    return txt;
  }
  
  protected CharSequence _generateMethodStatement(final Variable variable) {
    CharSequence _xifexpression = null;
    boolean _contains = this._ismlModelNavigation.getTypeSpecification(variable.getType()).getName().contains("Service");
    boolean _not = (!_contains);
    if (_not) {
      CharSequence _xblockexpression = null;
      {
        final Expression tipo = variable.getValue();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("var ");
        String _name = variable.getName();
        _builder.append(_name);
        _builder.append(":");
        CharSequence _generateType = this._extraGenionic.generateType(this._ismlModelNavigation.getTypeSpecification(variable.getType()).getName());
        _builder.append(_generateType);
        _builder.append("=");
        {
          if (((!Objects.equal(tipo, null)) && (tipo instanceof StringValue))) {
            CharSequence _value = this._extraGenionic.getValue(variable.getValue());
            _builder.append(_value);
          } else {
            if (((!Objects.equal(tipo, null)) && (variable.getValue() instanceof VariableReference))) {
              Expression _value_1 = variable.getValue();
              CharSequence _value_2 = this._extraGenionic.getValue(((VariableReference) _value_1));
              _builder.append(_value_2);
              CharSequence _value_3 = this._extraGenionic.getValue(variable.getValue());
              _builder.append(_value_3);
            } else {
              if ((tipo instanceof BinaryOperator)) {
                CharSequence _generateMethodStatement = this.generateMethodStatement(tipo);
                _builder.append(_generateMethodStatement);
              } else {
                if ((tipo instanceof StructInstance)) {
                  CharSequence _generateMethodStatement_1 = this.generateMethodStatement(tipo);
                  _builder.append(_generateMethodStatement_1);
                } else {
                  if ((tipo instanceof IntValueImpl)) {
                    CharSequence _generateMethodStatement_2 = this.generateMethodStatement(tipo);
                    _builder.append(_generateMethodStatement_2);
                  } else {
                    String _string = tipo.toString();
                    _builder.append(_string);
                  }
                }
              }
            }
          }
        }
        _xblockexpression = _builder;
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  protected CharSequence _generateMethodStatement(final VariableReference vr) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Reference<? extends NamedElement> _tail = vr.getTail();
      boolean _notEquals = (!Objects.equal(_tail, null));
      if (_notEquals) {
        CharSequence _value = this._extraGenionic.getValue(vr);
        _builder.append(_value);
      } else {
        CharSequence _typeParameter = this._extraGenionic.typeParameter(vr);
        _builder.append(_typeParameter);
        CharSequence _value_1 = this._extraGenionic.getValue(vr);
        _builder.append(_value_1);
      }
    }
    return _builder;
  }
  
  protected CharSequence _generateMethodStatement(final Type type) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  protected CharSequence _generateMethodStatement(final ResourceReference resref) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  protected CharSequence _generateMethodStatement(final MethodCall mcst) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(" ");
    String _name = this._ismlModelNavigation.getMethod(mcst).getName();
    _builder.append(_name, " ");
    _builder.append("(");
    {
      EList<Expression> _parameters = mcst.getParameters();
      boolean _hasElements = false;
      for(final Expression parameter : _parameters) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", " ");
        }
        CharSequence _typeParameter = this._extraGenionic.typeParameter(parameter);
        _builder.append(_typeParameter, " ");
        CharSequence _generateMethodStatement = this.generateMethodStatement(parameter);
        _builder.append(_generateMethodStatement, " ");
      }
    }
    _builder.append(")");
    return _builder;
  }
  
  protected CharSequence _generateMethodStatement(final ActionCall acst) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("return this.");
    String _name = this._ismlModelNavigation.getAction(acst).getName();
    _builder.append(_name);
    _builder.append("(");
    {
      int _size = this._ismlModelNavigation.getAction(acst).getParameters().size();
      boolean _notEquals = (_size != 0);
      if (_notEquals) {
        _builder.append(", ");
        CharSequence _parameters = this.getParameters(this._ismlModelNavigation.getAction(acst));
        _builder.append(_parameters);
      }
    }
    _builder.append(")");
    return _builder;
  }
  
  protected CharSequence _generateMethodStatement(final While whilest) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  protected CharSequence _generateMethodStatement(final For forst) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for(");
    CharSequence _value = this._extraGenionic.getValue(forst.getCollection());
    _builder.append(_value);
    _builder.append(" of ");
    CharSequence _generateMethodStatement = this.generateMethodStatement(forst.getVariable());
    _builder.append(_generateMethodStatement);
    _builder.append("){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _generateBody = this.generateBody(forst.getBody());
    _builder.append(_generateBody, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _generateMethodStatement(final If ifst) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if(");
    CharSequence _value = this._extraGenionic.getValue(ifst.getCondition());
    _builder.append(_value);
    _builder.append("){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _generateBody = this.generateBody(ifst.getBody());
    _builder.append(_generateBody, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _generateMethodStatement(final Return returnst) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  protected CharSequence _generateMethodStatement(final Assignment assign) {
    CharSequence _xblockexpression = null;
    {
      final CharSequence texto = this.extendAssignment(assign);
      CharSequence _xifexpression = null;
      int _length = texto.length();
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(texto);
        _xifexpression = _builder;
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        CharSequence _generateMethodStatement = this.generateMethodStatement(assign.getLeft());
        _builder_1.append(_generateMethodStatement);
        _builder_1.append(" ");
        CharSequence _writeSymbol = this.writeSymbol(assign.getSymbol());
        _builder_1.append(_writeSymbol);
        _builder_1.append(" ");
        CharSequence _generateMethodStatement_1 = this.generateMethodStatement(assign.getRight());
        _builder_1.append(_generateMethodStatement_1);
        _xifexpression = _builder_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected CharSequence _generateMethodStatement(final BinaryOperator expression) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generateMethodStatement = this.generateMethodStatement(expression.getLeft());
    _builder.append(_generateMethodStatement);
    _builder.append(" ");
    CharSequence _writeSymbol = this.writeSymbol(expression.getSymbol());
    _builder.append(_writeSymbol);
    _builder.append(" ");
    CharSequence _generateMethodStatement_1 = this.generateMethodStatement(expression.getRight());
    _builder.append(_generateMethodStatement_1);
    return _builder;
  }
  
  protected CharSequence _generateMethodStatement(final StringValue expression) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _value = this._extraGenionic.getValue(expression);
    _builder.append(_value);
    return _builder;
  }
  
  protected CharSequence _generateMethodStatement(final StructInstance expression) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new ");
    String _name = this._ismlModelNavigation.getTypeSpecification(expression.getType()).getName();
    _builder.append(_name);
    return _builder;
  }
  
  protected CharSequence _generateMethodStatement(final IntValueImpl expresion) {
    StringConcatenation _builder = new StringConcatenation();
    Object _literal = expresion.getLiteral();
    _builder.append(_literal);
    return _builder;
  }
  
  /**
   * Este método escribe el equivalente en java de los símbolos (Operadores Binarios)
   * utilizados en el lenguaje ISML
   */
  public CharSequence writeSymbol(final String symbol) {
    boolean _equals = symbol.equals("and");
    if (_equals) {
      return "&&";
    } else {
      boolean _equals_1 = symbol.equals("or");
      if (_equals_1) {
        return "||";
      } else {
        boolean _equals_2 = symbol.equals("not");
        if (_equals_2) {
          return "!";
        } else {
          return symbol;
        }
      }
    }
  }
  
  /**
   * Genere el código especifico para Ionic para la persistencia y los plugins del celular
   */
  public CharSequence extendAssignment(final Assignment assign) {
    final String operadorLeft = this._extraGenionic.getValue(assign.getLeft()).toString();
    final String operadorRight = this._extraGenionic.getValue(assign.getRight()).toString();
    String str = "";
    final String[] options = { "findall", "execute" };
    int _size = ((List<String>)Conversions.doWrapArray(options)).size();
    ExclusiveRange _greaterThanDoubleDot = new ExclusiveRange(_size, 0, false);
    for (final Integer i : _greaterThanDoubleDot) {
      if ((operadorLeft.toLowerCase().contains(options[(i).intValue()]) || operadorRight.toLowerCase().contains(options[(i).intValue()]))) {
        String lastShow = "";
        for (final MethodStatement e : this.elementsMethod) {
          if ((e instanceof Show)) {
            this.lastShowMethod = ((Show)e);
            CharSequence _generateMethodStatement = this.generateMethodStatement(e);
            String _plus = ("" + _generateMethodStatement);
            lastShow = _plus;
          }
        }
        Expression _right = assign.getRight();
        CharSequence _generateMethodStatement_1 = this.generateMethodStatement(((VariableReference) _right));
        String _plus_1 = ("" + _generateMethodStatement_1);
        String _plus_2 = (_plus_1 + ".then((r)=>{");
        CharSequence _typeParameter = this._extraGenionic.typeParameter(assign.getLeft());
        String _plus_3 = (_plus_2 + _typeParameter);
        CharSequence _value = this._extraGenionic.getValue(assign.getLeft());
        String _plus_4 = (_plus_3 + _value);
        String _plus_5 = (_plus_4 + "=r; ");
        String _plus_6 = (_plus_5 + lastShow);
        String _plus_7 = (_plus_6 + "}).catch(error =>{alert(error)});");
        str = _plus_7;
      }
    }
    if ((operadorLeft.toLowerCase().contains("takepicture") || operadorRight.toLowerCase().contains("takepicture"))) {
      String lastShow_1 = "";
      for (final MethodStatement e_1 : this.elementsMethod) {
        if ((e_1 instanceof Show)) {
          this.lastShowMethod = ((Show)e_1);
          CharSequence _generateMethodStatement_2 = this.generateMethodStatement(e_1);
          String _plus_8 = ("" + _generateMethodStatement_2);
          lastShow_1 = _plus_8;
        }
      }
      Expression _right_1 = assign.getRight();
      CharSequence _generateMethodStatement_3 = this.generateMethodStatement(((VariableReference) _right_1));
      String _plus_9 = ("" + _generateMethodStatement_3);
      String _plus_10 = (_plus_9 + ".then((r)=>{");
      CharSequence _value_1 = this._extraGenionic.getValue(assign.getLeft());
      String _plus_11 = (_plus_10 + _value_1);
      String _plus_12 = (_plus_11 + "=r+\'\';");
      String _plus_13 = (_plus_12 + lastShow_1);
      String _plus_14 = (_plus_13 + "}).catch(error =>{alert(error);});");
      str = _plus_14;
    }
    return str;
  }
  
  public CharSequence getParameters(final Action action) {
    StringConcatenation _builder = new StringConcatenation();
    {
      int _size = action.getParameters().size();
      boolean _notEquals = (_size != 0);
      if (_notEquals) {
        {
          EList<Parameter> _parameters = action.getParameters();
          boolean _hasElements = false;
          for(final Parameter param : _parameters) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",", "");
            }
            CharSequence _generateParams = this.generateParams(param);
            _builder.append(_generateParams);
          }
        }
      } else {
      }
    }
    return _builder;
  }
  
  public CharSequence generateParams(final Parameter p) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = p.getName();
    _builder.append(_name);
    _builder.append(":");
    CharSequence _generateType = this._extraGenionic.generateType(this._ismlModelNavigation.getTypeSpecification(p.getType()).getName());
    _builder.append(_generateType);
    return _builder;
  }
  
  public Map<String, String> removeTheFirstNameDuplicates(final Map<String, String> map) {
    Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
    HashSet<String> valueSet = new HashSet<String>();
    while (iter.hasNext()) {
      {
        Map.Entry<String, String> next = iter.next();
        boolean _add = valueSet.add(next.getValue());
        boolean _not = (!_add);
        if (_not) {
          iter.remove();
        }
      }
    }
    return map;
  }
  
  public CharSequence generateMethodStatement(final Notifier expresion) {
    if (expresion instanceof IntValueImpl) {
      return _generateMethodStatement((IntValueImpl)expresion);
    } else if (expresion instanceof ActionCall) {
      return _generateMethodStatement((ActionCall)expresion);
    } else if (expresion instanceof MethodCall) {
      return _generateMethodStatement((MethodCall)expresion);
    } else if (expresion instanceof For) {
      return _generateMethodStatement((For)expresion);
    } else if (expresion instanceof If) {
      return _generateMethodStatement((If)expresion);
    } else if (expresion instanceof ResourceReference) {
      return _generateMethodStatement((ResourceReference)expresion);
    } else if (expresion instanceof StructInstance) {
      return _generateMethodStatement((StructInstance)expresion);
    } else if (expresion instanceof Type) {
      return _generateMethodStatement((Type)expresion);
    } else if (expresion instanceof Variable) {
      return _generateMethodStatement((Variable)expresion);
    } else if (expresion instanceof VariableReference) {
      return _generateMethodStatement((VariableReference)expresion);
    } else if (expresion instanceof While) {
      return _generateMethodStatement((While)expresion);
    } else if (expresion instanceof Assignment) {
      return _generateMethodStatement((Assignment)expresion);
    } else if (expresion instanceof Return) {
      return _generateMethodStatement((Return)expresion);
    } else if (expresion instanceof Show) {
      return _generateMethodStatement((Show)expresion);
    } else if (expresion instanceof StringValue) {
      return _generateMethodStatement((StringValue)expresion);
    } else if (expresion instanceof BinaryOperator) {
      return _generateMethodStatement((BinaryOperator)expresion);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(expresion).toString());
    }
  }
}
