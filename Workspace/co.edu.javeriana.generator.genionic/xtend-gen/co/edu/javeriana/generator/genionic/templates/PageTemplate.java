package co.edu.javeriana.generator.genionic.templates;

import co.edu.javeriana.generator.genionic.templates.ExtraGenionic;
import co.edu.javeriana.isml.generator.common.SimpleTemplate;
import co.edu.javeriana.isml.isml.Action;
import co.edu.javeriana.isml.isml.ActionCall;
import co.edu.javeriana.isml.isml.BoolValue;
import co.edu.javeriana.isml.isml.Expression;
import co.edu.javeriana.isml.isml.FloatValue;
import co.edu.javeriana.isml.isml.ForView;
import co.edu.javeriana.isml.isml.IntValue;
import co.edu.javeriana.isml.isml.MethodCall;
import co.edu.javeriana.isml.isml.NamedViewBlock;
import co.edu.javeriana.isml.isml.NullValue;
import co.edu.javeriana.isml.isml.Page;
import co.edu.javeriana.isml.isml.Reference;
import co.edu.javeriana.isml.isml.StringValue;
import co.edu.javeriana.isml.isml.VariableReference;
import co.edu.javeriana.isml.isml.ViewInstance;
import co.edu.javeriana.isml.isml.ViewStatement;
import co.edu.javeriana.isml.scoping.IsmlModelNavigation;
import co.edu.javeriana.isml.validation.TypeChecker;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class PageTemplate extends SimpleTemplate<Page> {
  @Inject
  @Extension
  private TypeChecker _typeChecker;
  
  @Inject
  @Extension
  private IsmlModelNavigation _ismlModelNavigation;
  
  @Inject
  @Extension
  private ExtraGenionic _extraGenionic;
  
  @Override
  public void preprocess(final Page e) {
  }
  
  @Override
  public CharSequence template(final Page page) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<ViewStatement> _body = page.getBody();
      boolean _notEquals = (!Objects.equal(_body, null));
      if (_notEquals) {
        CharSequence _widgetTemplate = this.widgetTemplate(page.getBody());
        _builder.append(_widgetTemplate);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  /**
   * Método para obtener las partes de cada componente de tipo block
   */
  protected CharSequence _widgetTemplate(final EList<ViewStatement> partBlock) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _notEquals = (!Objects.equal(partBlock, null));
      if (_notEquals) {
        {
          for(final ViewStatement part : partBlock) {
            CharSequence _widgetTemplate = this.widgetTemplate(part);
            _builder.append(_widgetTemplate);
            _builder.append("\t\t\t\t");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _widgetTemplate(final ViewInstance viewInstance) {
    CharSequence _switchResult = null;
    String _typeSpecificationString = this._ismlModelNavigation.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(viewInstance.getType()));
    if (_typeSpecificationString != null) {
      switch (_typeSpecificationString) {
        case "Panel":
          _switchResult = this.panel(viewInstance);
          break;
        case "Form":
          _switchResult = this.form(viewInstance);
          break;
        case "Text":
          _switchResult = this.inputText(viewInstance);
          break;
        case "Image":
          _switchResult = this.image(viewInstance);
          break;
        case "Password":
          _switchResult = this.password(viewInstance);
          break;
        case "Link":
          _switchResult = this.link(viewInstance);
          break;
        case "Spinner":
          _switchResult = this.spinner(viewInstance);
          break;
        case "ComboChooser":
          _switchResult = this.comboChooser(viewInstance);
          break;
        case "Select":
          _switchResult = this.select(viewInstance);
          break;
        case "RadioChooser":
          _switchResult = this.radioChooser(viewInstance);
          break;
        case "Calendar":
          _switchResult = this.calendar(viewInstance);
          break;
        case "Media":
          _switchResult = this.media(viewInstance);
          break;
        case "Label":
          _switchResult = this.label(viewInstance);
          break;
        case "CheckBox":
          _switchResult = this.checkBox(viewInstance);
          break;
        case "Button":
          _switchResult = this.button(viewInstance);
          break;
        case "PanelButton":
          _switchResult = this.panelButton(viewInstance);
          break;
        case "DataTable":
          _switchResult = this.dataTable(viewInstance);
          break;
        case "MobileMap":
          _switchResult = this.map(viewInstance);
          break;
        case "Cam":
          _switchResult = this.camera(viewInstance);
          break;
        case "OutputText":
          _switchResult = this.OutputText(viewInstance);
          break;
      }
    }
    return _switchResult;
  }
  
  public CharSequence OutputText(final ViewInstance part) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<ion-input ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type=\"text\" ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("placeholder=\"");
    CharSequence _value = this.getValue(part.getParameters().get(0));
    _builder.append(_value, "\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("[(ngModel)]=\"");
    CharSequence _value_1 = this.getValue(part.getParameters().get(1));
    _builder.append(_value_1, "\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("clearInput=\"true\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("class=\"form-control\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("readonly");
    _builder.newLine();
    _builder.append("required></ion-input>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence camera(final ViewInstance instance) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _label = this.label(instance);
    _builder.append(_label);
    _builder.newLineIfNotEmpty();
    _builder.append("\t    ");
    _builder.append("<button ion-button (click)=\"");
    ActionCall _actionCall = instance.getActionCall();
    Action _action = null;
    if (_actionCall!=null) {
      _action=this._ismlModelNavigation.getAction(_actionCall);
    }
    String _name = null;
    if (_action!=null) {
      _name=_action.getName();
    }
    _builder.append(_name, "\t    ");
    _builder.append("(");
    {
      EList<Expression> _parameters = instance.getActionCall().getParameters();
      boolean _hasElements = false;
      for(final Expression param : _parameters) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "\t    ");
        }
        {
          if (((param instanceof VariableReference) && (((VariableReference) param).getReferencedElement().eContainer() instanceof Page))) {
            Page _findAncestor = this._ismlModelNavigation.<ViewInstance, Page>findAncestor(instance, Page.class);
            String _firstLower = StringExtensions.toFirstLower(((Page) _findAncestor).getController().getName());
            _builder.append(_firstLower, "\t    ");
            _builder.append(".");
          }
        }
      }
    }
    _builder.append(")\">");
    CharSequence _value = this.getValue(instance.getParameters().get(0));
    _builder.append(_value, "\t    ");
    _builder.append("</button>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t    ");
    _builder.append("<div class=\"divPicture\"><img class=\"imgPicture\" [src]=\"");
    CharSequence _value_1 = this.getValue(instance.getParameters().get(2));
    _builder.append(_value_1, "\t    ");
    _builder.append("\" *ngIf=\"");
    CharSequence _value_2 = this.getValue(instance.getParameters().get(2));
    _builder.append(_value_2, "\t    ");
    _builder.append("\" /></div>");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence map(final ViewInstance instance) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<div #");
    CharSequence _value = this.getValue(instance.getParameters().get(0));
    _builder.append(_value);
    _builder.append(" id=\"");
    CharSequence _value_1 = this.getValue(instance.getParameters().get(0));
    _builder.append(_value_1);
    _builder.append("\" class=\"mapa\"></div>");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence panel(final ViewInstance instance) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<ion-header>");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("<ion-navbar color=\"primary\">");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("<button ion-icon menuToggle>");
    _builder.newLine();
    _builder.append("\t      ");
    _builder.append("<ion-icon name=\"menu\"></ion-icon>");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("</button>");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("<ion-title>");
    CharSequence _value = this.getValue(instance.getParameters().get(0));
    _builder.append(_value, "\t    ");
    _builder.append("</ion-title>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t ");
    _builder.append("</ion-navbar>");
    _builder.newLine();
    _builder.append("</ion-header>");
    _builder.newLine();
    _builder.append("<ion-content padding>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<div class=\"list\">");
    _builder.newLine();
    {
      EList<ViewStatement> _body = instance.getBody();
      for(final ViewStatement partBlock : _body) {
        _builder.append("\t");
        CharSequence _widgetTemplate = this.widgetTemplate(partBlock);
        _builder.append(_widgetTemplate, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("</ion-content>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence form(final ViewInstance part) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<form #form=\"");
    String _name = part.getName();
    _builder.append(_name);
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<div class=\"list\">");
    _builder.newLine();
    {
      EList<ViewStatement> _body = part.getBody();
      for(final ViewStatement partBlock : _body) {
        _builder.append("\t");
        CharSequence _widgetTemplate = this.widgetTemplate(partBlock);
        _builder.append(_widgetTemplate, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("</form>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence inputText(final ViewInstance part) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<label class=\"item item-input item-floating-label\">");
    _builder.newLine();
    _builder.append("<span class=\"input-label\">");
    CharSequence _value = this.getValue(part.getParameters().get(0));
    _builder.append(_value);
    _builder.append("</span>");
    _builder.newLineIfNotEmpty();
    _builder.append("<ion-input ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type=\"text\" ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("name=\"");
    CharSequence _value_1 = this.getValue(part.getParameters().get(0));
    _builder.append(_value_1, "\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("min=\"");
    CharSequence _value_2 = this.getValue(part.getParameters().get(3));
    _builder.append(_value_2, "\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("max=\"");
    CharSequence _value_3 = this.getValue(part.getParameters().get(2));
    _builder.append(_value_3, "\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("placeholder=\"");
    CharSequence _value_4 = this.getValue(part.getParameters().get(0));
    _builder.append(_value_4, "\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("[(ngModel)]=\"");
    CharSequence _value_5 = this.getValue(part.getParameters().get(1));
    _builder.append(_value_5, "\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("clearInput=\"true\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("class=\"form-control\"");
    _builder.newLine();
    _builder.append("required></ion-input>");
    _builder.newLine();
    _builder.append("</label>");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence text(final ViewInstance part) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _label = this.label(part);
    _builder.append(_label);
    _builder.newLineIfNotEmpty();
    _builder.append("<ion-textarea ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("name=\"");
    CharSequence _value = this.getValue(part.getParameters().get(0));
    _builder.append(_value, "\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("min=\"");
    CharSequence _value_1 = this.getValue(part.getParameters().get(3));
    _builder.append(_value_1, "\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("max=\"");
    CharSequence _value_2 = this.getValue(part.getParameters().get(2));
    _builder.append(_value_2, "\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("[(ngModel)]=\"");
    CharSequence _value_3 = this.getValue(part.getParameters().get(1));
    _builder.append(_value_3, "\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("placeholder=\"");
    CharSequence _value_4 = this.getValue(part.getParameters().get(0));
    _builder.append(_value_4, "\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("clearInput=\"true\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("class=\"form-control\"");
    _builder.newLine();
    _builder.append("></ion-textarea>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence image(final ViewInstance part) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<img src=\"");
    CharSequence _value = this.getValue(part.getParameters().get(0));
    _builder.append(_value);
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence password(final ViewInstance part) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _label = this.label(part);
    _builder.append(_label);
    _builder.newLineIfNotEmpty();
    _builder.append("<ion-input ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type=\"password\" ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("name=\"");
    CharSequence _value = this.getValue(part.getParameters().get(0));
    _builder.append(_value, "\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("min=\"");
    CharSequence _value_1 = this.getValue(part.getParameters().get(3));
    _builder.append(_value_1, "\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("max=\"");
    CharSequence _value_2 = this.getValue(part.getParameters().get(2));
    _builder.append(_value_2, "\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("placeholder=\"");
    CharSequence _value_3 = this.getValue(part.getParameters().get(0));
    _builder.append(_value_3, "\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("clearInput=\"true\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("class=\"form-control\"");
    _builder.newLine();
    _builder.append("required></ion-input>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence link(final ViewInstance part) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a href=\"");
    CharSequence _value = this.getValue(part.getParameters().get(1));
    _builder.append(_value);
    _builder.append("\">");
    CharSequence _value_1 = this.getValue(part.getParameters().get(0));
    _builder.append(_value_1);
    _builder.append("</a>");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence spinner(final ViewInstance part) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<ion-spinner></ion-spinner>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence comboChooser(final ViewInstance part) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _label = this.label(part);
    _builder.append(_label);
    _builder.newLineIfNotEmpty();
    _builder.append("<ion-select #");
    CharSequence _value = this.getValue(part.getParameters().get(0));
    _builder.append(_value);
    _builder.append(" >");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("<ion-option value=\"\">");
    CharSequence _value_1 = this.getValue(part.getParameters().get(3));
    _builder.append(_value_1, "    ");
    _builder.append("</ion-option>");
    _builder.newLineIfNotEmpty();
    _builder.append("</ion-select>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence select(final ViewInstance part) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _label = this.label(part);
    _builder.append(_label);
    _builder.newLineIfNotEmpty();
    _builder.append("<ion-select [(ngModel)]=\"");
    CharSequence _value = this.getValue(part.getParameters().get(1));
    _builder.append(_value);
    _builder.append("\" name=\"");
    CharSequence _value_1 = this.getValue(part.getParameters().get(1));
    _builder.append(_value_1);
    _builder.append("\" class=\"form-control\" placeholder=\"");
    CharSequence _value_2 = this.getValue(part.getParameters().get(0));
    _builder.append(_value_2);
    _builder.append("\" required> ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<ion-option value=\"\">Seleccione...</ion-option>");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<ion-option  *ngFor=\"let valSel of ");
    CharSequence _value_3 = this.getValue(part.getParameters().get(2));
    _builder.append(_value_3, "    ");
    _builder.append("\"  value=\"{{valSel.");
    CharSequence _value_4 = this.getValue(part.getParameters().get(3));
    _builder.append(_value_4, "    ");
    _builder.append("}}\">{{valSel.");
    CharSequence _value_5 = this.getValue(part.getParameters().get(4));
    _builder.append(_value_5, "    ");
    _builder.append("}}</ion-option>");
    _builder.newLineIfNotEmpty();
    _builder.append("</ion-select>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence radioChooser(final ViewInstance part) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _label = this.label(part);
    _builder.append(_label);
    _builder.newLineIfNotEmpty();
    _builder.append("<ion-list radio-group [(ngModel)]=\"");
    CharSequence _value = this.getValue(part.getParameters().get(2));
    _builder.append(_value);
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("<ion-item>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<ion-radio *ngFor=\"let valSel of ");
    CharSequence _value_1 = this.getValue(part.getParameters().get(1));
    _builder.append(_value_1, "\t");
    _builder.append("\" value=\"value=\"{{valSel.id}}\" checked><ion-label>{{valSel.name}}</ion-label></ion-radio>");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("</ion-item>");
    _builder.newLine();
    _builder.append("</ion-list>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence calendar(final ViewInstance part) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _label = this.label(part);
    _builder.append(_label);
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("<ion-datetime displayFormat=\"MM/DD/YYYY\" [(ngModel)]=\"");
    CharSequence _value = this.getValue(part.getParameters().get(0));
    _builder.append(_value, " ");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("name=\"");
    CharSequence _value_1 = this.getValue(part.getParameters().get(0));
    _builder.append(_value_1, "    ");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append(" \t");
    _builder.append("value=\"");
    CharSequence _value_2 = this.getValue(part.getParameters().get(1));
    _builder.append(_value_2, " \t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append(" \t");
    _builder.append("class=\"form-control\"");
    _builder.newLine();
    _builder.append(" ");
    _builder.append(">");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("</ion-datetime>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence media(final ViewInstance part) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<iframe width=\"");
    CharSequence _value = this.getValue(part.getParameters().get(1));
    _builder.append(_value);
    _builder.append("\" height=\"");
    CharSequence _value_1 = this.getValue(part.getParameters().get(2));
    _builder.append(_value_1);
    _builder.append("\"  src=\"");
    CharSequence _value_2 = this.getValue(part.getParameters().get(0));
    _builder.append(_value_2);
    _builder.append("\" frameborder=\"0\" allowfullscreen></iframe>\t");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence label(final ViewInstance part) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<ion-label class=\"input-label\">");
    CharSequence _value = this.getValue(part.getParameters().get(0));
    _builder.append(_value);
    _builder.append("</ion-label>");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence checkBox(final ViewInstance part) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _label = this.label(part);
    _builder.append(_label);
    _builder.newLineIfNotEmpty();
    _builder.append("<ion-checkbox required></ion-checkbox>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence button(final ViewInstance part) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<button ion-button (click)=\"");
    ActionCall _actionCall = part.getActionCall();
    Action _action = null;
    if (_actionCall!=null) {
      _action=this._ismlModelNavigation.getAction(_actionCall);
    }
    String _name = null;
    if (_action!=null) {
      _name=_action.getName();
    }
    _builder.append(_name);
    _builder.append("(");
    ActionCall _actionCall_1 = part.getActionCall();
    CharSequence _generateParametersActionCall = null;
    if (_actionCall_1!=null) {
      _generateParametersActionCall=this.generateParametersActionCall(_actionCall_1);
    }
    _builder.append(_generateParametersActionCall);
    _builder.append(")\" >");
    CharSequence _value = this.getValue(part.getParameters().get(0));
    _builder.append(_value);
    _builder.append("</button>");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence panelButton(final ViewInstance instance) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<ion-list> ");
    _builder.newLine();
    {
      EList<ViewStatement> _body = instance.getBody();
      for(final ViewStatement partBlock : _body) {
        _builder.append("\t");
        _builder.append("<ion-item>");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        CharSequence _widgetTemplate = this.widgetTemplate(partBlock);
        _builder.append(_widgetTemplate, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("</ion-item>");
        _builder.newLine();
      }
    }
    _builder.append("</ion-list>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence dataTable(final ViewInstance table) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<ion-grid>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<ion-row align-items-center>");
    _builder.newLine();
    {
      Set<Map.Entry<ViewStatement, ViewStatement>> _entrySet = this.getColumnsDataTable(table).entrySet();
      for(final Map.Entry<ViewStatement, ViewStatement> pair : _entrySet) {
        _builder.append("  \t\t\t\t    ");
        ViewStatement _key = pair.getKey();
        final ViewInstance viewInstance = ((ViewInstance) _key);
        _builder.newLineIfNotEmpty();
        _builder.append("  \t\t\t\t    ");
        _builder.append("<ion-col class=\"colHeader\">");
        CharSequence _widgetTemplate = this.widgetTemplate(viewInstance);
        _builder.append(_widgetTemplate, "  \t\t\t\t    ");
        _builder.append("</ion-col>");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("</ion-row>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<ion-row  *ngFor=\"let ");
    String _name = this._ismlModelNavigation.getForViewInBody(table).getVariable().getName();
    _builder.append(_name, "\t\t");
    _builder.append(" of ");
    ForView _forViewInBody = this._ismlModelNavigation.getForViewInBody(table);
    Reference _collection = null;
    if (_forViewInBody!=null) {
      _collection=_forViewInBody.getCollection();
    }
    String _name_1 = _collection.getReferencedElement().getName();
    _builder.append(_name_1, "\t\t");
    _builder.append(" \">");
    _builder.newLineIfNotEmpty();
    _builder.append("  \t\t\t\t\t");
    ViewStatement _get = this._ismlModelNavigation.<ViewStatement, NamedViewBlock>cast(table.getBody().get(1), NamedViewBlock.class).getBody().get(0);
    final ForView forView = ((ForView) _get);
    _builder.newLineIfNotEmpty();
    _builder.append("  \t\t\t\t\t");
    final ArrayList<String> tiposColumnas = new ArrayList<String>();
    _builder.newLineIfNotEmpty();
    {
      int _size = forView.getBody().size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for(final Integer i : _doubleDotLessThan) {
        _builder.append("  \t\t\t\t\t");
        ViewStatement elemento = forView.getBody().get((i).intValue());
        _builder.newLineIfNotEmpty();
        _builder.append("  \t\t\t\t\t");
        String tipo = this._typeChecker.getType(elemento).getReferencedElement().getName();
        _builder.newLineIfNotEmpty();
        _builder.append("  \t\t\t\t\t");
        String _xblockexpression = null;
        {
          tiposColumnas.add(tipo);
          _xblockexpression = "";
        }
        _builder.append(_xblockexpression, "  \t\t\t\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("  \t\t\t\t\t");
    int i_1 = 0;
    _builder.newLineIfNotEmpty();
    {
      Set<Map.Entry<ViewStatement, ViewStatement>> _entrySet_1 = this.getColumnsDataTable(table).entrySet();
      for(final Map.Entry<ViewStatement, ViewStatement> pair_1 : _entrySet_1) {
        _builder.append("  \t\t\t\t\t\t");
        final String tipoColumna = tiposColumnas.get(i_1);
        _builder.newLineIfNotEmpty();
        {
          boolean _equals = "Button".equals(tipoColumna);
          if (_equals) {
            _builder.append("  \t\t\t\t\t\t");
            _builder.append("<ion-col>");
            CharSequence _widgetTemplate_1 = this.widgetTemplate(pair_1.getValue());
            _builder.append(_widgetTemplate_1, "  \t\t\t\t\t\t");
            _builder.append("</ion-col>");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("  \t\t\t\t\t\t");
            _builder.append("<ion-col>");
            CharSequence _widgetTemplate_2 = this.widgetTemplate(pair_1.getValue());
            _builder.append(_widgetTemplate_2, "  \t\t\t\t\t\t");
            _builder.append("</ion-col>\t\t ");
            _builder.newLineIfNotEmpty();
          }
        }
        String _xblockexpression_1 = null;
        {
          i_1 = (i_1 + 1);
          _xblockexpression_1 = "";
        }
        _builder.append(_xblockexpression_1);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("</ion-row>");
    _builder.newLine();
    _builder.append("</ion-grid>");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * Método para obtener las columnas de un datatable
   */
  public LinkedHashMap<ViewStatement, ViewStatement> getColumnsDataTable(final ViewInstance table) {
    final LinkedHashMap<ViewStatement, ViewStatement> columns = new LinkedHashMap<ViewStatement, ViewStatement>();
    ViewStatement _get = table.getBody().get(0);
    final NamedViewBlock header = ((NamedViewBlock) _get);
    ViewStatement _get_1 = this._ismlModelNavigation.<ViewStatement, NamedViewBlock>cast(table.getBody().get(1), NamedViewBlock.class).getBody().get(0);
    final ForView forView = ((ForView) _get_1);
    int _size = header.getBody().size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      columns.put(header.getBody().get((i).intValue()), forView.getBody().get((i).intValue()));
    }
    return columns;
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
          CharSequence _generateReferencedElement = this._extraGenionic.generateReferencedElement(((Reference) param));
          _builder_1.append(_generateReferencedElement);
        }
      }
      generatedParameters = _builder_1.toString();
    }
    return generatedParameters;
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
        _switchResult = ((StringValue)e).getLiteral().toString();
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
        boolean _hasTail = this._extraGenionic.hasTail(((Reference)e));
        if (_hasTail) {
          _xifexpression = this._extraGenionic.generateTailedElement(((VariableReference)e));
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
  
  public CharSequence widgetTemplate(final Object viewInstance) {
    if (viewInstance instanceof ViewInstance) {
      return _widgetTemplate((ViewInstance)viewInstance);
    } else if (viewInstance instanceof EList) {
      return _widgetTemplate((EList<ViewStatement>)viewInstance);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(viewInstance).toString());
    }
  }
}
