package co.edu.javeriana.isml.generator.crud.templates;

import co.edu.javeriana.isml.isml.Attribute;
import co.edu.javeriana.isml.isml.Entity;
import co.edu.javeriana.isml.isml.ParameterizedType;
import co.edu.javeriana.isml.isml.Type;
import co.edu.javeriana.isml.isml.TypeSpecification;
import co.edu.javeriana.isml.scoping.IsmlModelNavigation;
import co.edu.javeriana.isml.validation.TypeChecker;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class CommonTemplates {
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Inject
  @Extension
  private IsmlModelNavigation _ismlModelNavigation;
  
  @Inject
  @Extension
  private TypeChecker _typeChecker;
  
  public CharSequence controllerName(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = e.getName();
    _builder.append(_name);
    _builder.append("Manager");
    return _builder;
  }
  
  public CharSequence variable(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstLower = StringExtensions.toFirstLower(e.getName());
    _builder.append(_firstLower);
    return _builder;
  }
  
  public CharSequence itVariable(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a");
    String _name = e.getName();
    _builder.append(_name);
    return _builder;
  }
  
  public CharSequence collectionVariable(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstLower = StringExtensions.toFirstLower(e.getName());
    _builder.append(_firstLower);
    _builder.append("List");
    return _builder;
  }
  
  public CharSequence idVariable(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("id");
    return _builder;
  }
  
  public CharSequence idType(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Integer");
    return _builder;
  }
  
  public CharSequence arrayType(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Array<");
    String _name = e.getName();
    _builder.append(_name);
    _builder.append(">");
    return _builder;
  }
  
  public CharSequence collectionType(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Collection<");
    String _name = e.getName();
    _builder.append(_name);
    _builder.append(">");
    return _builder;
  }
  
  public CharSequence listPage(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = e.getName();
    _builder.append(_name);
    _builder.append("List");
    return _builder;
  }
  
  public CharSequence subListPage(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = e.getName();
    _builder.append(_name);
    _builder.append("SubList");
    return _builder;
  }
  
  public CharSequence createToAddPage(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Create");
    String _name = e.getName();
    _builder.append(_name);
    _builder.append("ToAdd");
    return _builder;
  }
  
  public CharSequence selectToAddPage(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Select");
    String _name = e.getName();
    _builder.append(_name);
    _builder.append("ToAdd");
    return _builder;
  }
  
  public CharSequence selectToAssignPage(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Select");
    String _name = e.getName();
    _builder.append(_name);
    _builder.append("ToAssign");
    return _builder;
  }
  
  public CharSequence viewPage(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("View");
    String _name = e.getName();
    _builder.append(_name);
    return _builder;
  }
  
  public CharSequence editPage(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Edit");
    String _name = e.getName();
    _builder.append(_name);
    return _builder;
  }
  
  public CharSequence listAction(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("list");
    String _name = e.getName();
    _builder.append(_name);
    return _builder;
  }
  
  public CharSequence subListAction(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("subList");
    String _name = e.getName();
    _builder.append(_name);
    return _builder;
  }
  
  public CharSequence viewAction(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("view");
    String _name = e.getName();
    _builder.append(_name);
    return _builder;
  }
  
  public CharSequence createAction(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("create");
    String _name = e.getName();
    _builder.append(_name);
    return _builder;
  }
  
  public CharSequence addAction(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("add");
    String _name = e.getName();
    _builder.append(_name);
    return _builder;
  }
  
  public CharSequence cancelAddAction(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("cancelAdd");
    String _name = e.getName();
    _builder.append(_name);
    return _builder;
  }
  
  public CharSequence createToAddAction(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("create");
    String _name = e.getName();
    _builder.append(_name);
    _builder.append("ToAdd");
    return _builder;
  }
  
  public CharSequence selectToAddAction(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("select");
    String _name = e.getName();
    _builder.append(_name);
    _builder.append("ToAdd");
    return _builder;
  }
  
  public CharSequence selectToAssignAction(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("select");
    String _name = e.getName();
    _builder.append(_name);
    _builder.append("ToAssign");
    return _builder;
  }
  
  public CharSequence assignAction(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("assign");
    String _name = e.getName();
    _builder.append(_name);
    return _builder;
  }
  
  public CharSequence editAction(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("edit");
    String _name = e.getName();
    _builder.append(_name);
    return _builder;
  }
  
  public CharSequence saveAction(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("save");
    String _name = e.getName();
    _builder.append(_name);
    return _builder;
  }
  
  public CharSequence deleteAction(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("delete");
    String _name = e.getName();
    _builder.append(_name);
    return _builder;
  }
  
  public CharSequence removeAction(final TypeSpecification e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("remove");
    String _name = e.getName();
    _builder.append(_name);
    return _builder;
  }
  
  /**
   * Converts a string in camel case to a human-readable format, i.e., putting spaces between case changes.
   */
  public String toLabel(final String s) {
    return StringExtensions.toFirstUpper(s).replaceAll("([a-z])([A-Z])", "$1 $2");
  }
  
  /**
   * Converts a string in camel case to a human-readable format, i.e., putting spaces between case changes.
   */
  public String toLabel(final CharSequence s) {
    return this.toLabel(s.toString());
  }
  
  public CharSequence headerCell(final Attribute attr) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isCollection = this._typeChecker.isCollection(attr.getType());
      if (_isCollection) {
        _builder.newLine();
      } else {
        _builder.append("Label(\"");
        String _label = this.toLabel(attr.getName());
        _builder.append(_label);
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence cell(final Entity e, final Attribute a) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isCollection = this._typeChecker.isCollection(a.getType());
      if (_isCollection) {
        _builder.newLine();
      } else {
        _builder.append("Label(");
        CharSequence _variable = this.variable(e);
        _builder.append(_variable);
        _builder.append(".");
        String _name = a.getName();
        _builder.append(_name);
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public String toText(final Type t) {
    String name = "";
    String _name = name;
    TypeSpecification _typeSpecification = this._ismlModelNavigation.getTypeSpecification(t);
    String _name_1 = null;
    if (_typeSpecification!=null) {
      _name_1=_typeSpecification.getName();
    }
    name = (_name + _name_1);
    if ((t instanceof ParameterizedType)) {
      String _name_2 = name;
      name = (_name_2 + "<");
      EList<Type> _typeParameters = ((ParameterizedType)t).getTypeParameters();
      for (final Type typeParam : _typeParameters) {
        String _name_3 = name;
        String _text = this.toText(typeParam);
        name = (_name_3 + _text);
      }
      String _name_4 = name;
      name = (_name_4 + ">");
    }
    return name;
  }
  
  public CharSequence templateEdit(final Entity e, final Attribute a, final boolean deepEdit) {
    final TypeSpecification attTypeSpec = this._ismlModelNavigation.getTypeSpecification(a.getType());
    String _name = this._ismlModelNavigation.getTypeSpecification(a.getType()).getName();
    boolean _matched = false;
    if (Objects.equal(_name, "String")) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Text(\"");
      String _label = this.toLabel(a.getName());
      _builder.append(_label);
      _builder.append("\", ");
      CharSequence _variable = this.variable(e);
      _builder.append(_variable);
      _builder.append(".");
      String _name_1 = a.getName();
      _builder.append(_name_1);
      _builder.append(", 25, 1);");
      return _builder.toString();
    }
    if (!_matched) {
      if (Objects.equal(_name, "Date")) {
        _matched=true;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("Calendar(\"");
        String _label_1 = this.toLabel(a.getName());
        _builder_1.append(_label_1);
        _builder_1.append("\", ");
        CharSequence _variable_1 = this.variable(e);
        _builder_1.append(_variable_1);
        _builder_1.append(".");
        String _name_2 = a.getName();
        _builder_1.append(_name_2);
        _builder_1.append(", null, \"dd/MM/yyyy\", true, \"inline\");");
        return _builder_1.toString();
      }
    }
    if (!_matched) {
      if (Objects.equal(_name, "Integer")) {
        _matched=true;
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("Text(\"");
        String _label_2 = this.toLabel(a.getName());
        _builder_2.append(_label_2);
        _builder_2.append("\", ");
        CharSequence _variable_2 = this.variable(e);
        _builder_2.append(_variable_2);
        _builder_2.append(".");
        String _name_3 = a.getName();
        _builder_2.append(_name_3);
        _builder_2.append(", 10, 1);");
        return _builder_2.toString();
      }
    }
    if (!_matched) {
      if (Objects.equal(_name, "Float")) {
        _matched=true;
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("Text(\"");
        String _label_3 = this.toLabel(a.getName());
        _builder_3.append(_label_3);
        _builder_3.append("\", ");
        CharSequence _variable_3 = this.variable(e);
        _builder_3.append(_variable_3);
        _builder_3.append(".");
        String _name_4 = a.getName();
        _builder_3.append(_name_4);
        _builder_3.append(", 10, 1);");
        return _builder_3.toString();
      }
    }
    if (!_matched) {
      if (Objects.equal(_name, "Boolean")) {
        _matched=true;
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append("CheckBox(\"");
        String _label_4 = this.toLabel(a.getName());
        _builder_4.append(_label_4);
        _builder_4.append("\", ");
        CharSequence _variable_4 = this.variable(e);
        _builder_4.append(_variable_4);
        _builder_4.append(".");
        String _name_5 = a.getName();
        _builder_4.append(_name_5);
        _builder_4.append(");");
        return _builder_4.toString();
      }
    }
    if (!_matched) {
      if (Objects.equal(_name, "Email")) {
        _matched=true;
        StringConcatenation _builder_5 = new StringConcatenation();
        _builder_5.append("Text(\"");
        String _label_5 = this.toLabel(a.getName());
        _builder_5.append(_label_5);
        _builder_5.append("\", ");
        CharSequence _variable_5 = this.variable(e);
        _builder_5.append(_variable_5);
        _builder_5.append(".");
        String _name_6 = a.getName();
        _builder_5.append(_name_6);
        _builder_5.append(", 25, 1);");
        return _builder_5.toString();
      }
    }
    {
      final Type attrType = a.getType();
      if (deepEdit) {
        if ((attrType instanceof ParameterizedType)) {
          boolean _isCollection = this._typeChecker.isCollection(a.getType());
          if (_isCollection) {
            return this.templateEditList(e, a, ((ParameterizedType)attrType));
          }
        }
        final TypeSpecification attrTypeSpec = this._ismlModelNavigation.getTypeSpecification(attrType);
        if ((attrTypeSpec instanceof Entity)) {
          StringConcatenation _builder_6 = new StringConcatenation();
          _builder_6.append("Panel(\"");
          String _label_6 = this.toLabel(a.getName());
          _builder_6.append(_label_6);
          _builder_6.append("\") {");
          _builder_6.newLineIfNotEmpty();
          {
            Iterable<Attribute> _allAttributes = this._ismlModelNavigation.getAllAttributes(e);
            for(final Attribute attr : _allAttributes) {
              _builder_6.append("\t");
              CharSequence _templateView = this.templateView(e, attr, false);
              _builder_6.append(_templateView, "\t");
              _builder_6.newLineIfNotEmpty();
            }
          }
          _builder_6.append("\t");
          _builder_6.append("Button(\"Change\", false) -> ");
          CharSequence _controllerName = this.controllerName(attTypeSpec);
          _builder_6.append(_controllerName, "\t");
          _builder_6.append(".");
          CharSequence _selectToAssignAction = this.selectToAssignAction(attTypeSpec);
          _builder_6.append(_selectToAssignAction, "\t");
          _builder_6.append("(");
          CharSequence _variable_6 = this.variable(e);
          _builder_6.append(_variable_6, "\t");
          _builder_6.append(", \"");
          String _name_7 = a.getName();
          _builder_6.append(_name_7, "\t");
          _builder_6.append("\");");
          _builder_6.newLineIfNotEmpty();
          _builder_6.append("\t");
          _builder_6.append("Button(\"Remove\", false) -> ");
          CharSequence _controllerName_1 = this.controllerName(attTypeSpec);
          _builder_6.append(_controllerName_1, "\t");
          _builder_6.append(".");
          CharSequence _assignAction = this.assignAction(attTypeSpec);
          _builder_6.append(_assignAction, "\t");
          _builder_6.append("(");
          CharSequence _variable_7 = this.variable(e);
          _builder_6.append(_variable_7, "\t");
          _builder_6.append(", \"");
          String _name_8 = a.getName();
          _builder_6.append(_name_8, "\t");
          _builder_6.append("\", null);");
          _builder_6.newLineIfNotEmpty();
          _builder_6.append("}");
          _builder_6.newLine();
          return _builder_6.toString();
        }
      }
      StringConcatenation _builder_7 = new StringConcatenation();
      return _builder_7.toString();
    }
  }
  
  public CharSequence templateEditList(final Entity e, final Attribute a, final ParameterizedType attrType) {
    CharSequence _xblockexpression = null;
    {
      final TypeSpecification containedTypeSpec = this._typeChecker.containedTypeSpecification(a.getType());
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Panel(\"");
      String _label = this.toLabel(a.getName());
      _builder.append(_label);
      _builder.append("\") {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("DataTable(\"");
      String _label_1 = this.toLabel(a.getName());
      _builder.append(_label_1, "\t");
      _builder.append("\", null) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("header : {                    ");
      _builder.newLine();
      {
        Iterable<Attribute> _allAttributes = this._ismlModelNavigation.getAllAttributes(containedTypeSpec);
        for(final Attribute attr : _allAttributes) {
          _builder.append("\t\t          ");
          CharSequence _headerCell = this.headerCell(attr);
          _builder.append(_headerCell, "\t\t          ");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t          ");
      _builder.append("Label(\"Delete\");");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("body : ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("for(");
      String _name = containedTypeSpec.getName();
      _builder.append(_name, "\t\t");
      _builder.append(" ");
      CharSequence _itVariable = this.itVariable(containedTypeSpec);
      _builder.append(_itVariable, "\t\t");
      _builder.append(" in ");
      CharSequence _variable = this.variable(e);
      _builder.append(_variable, "\t\t");
      _builder.append(".");
      String _name_1 = a.getName();
      _builder.append(_name_1, "\t\t");
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      {
        Iterable<Attribute> _allAttributes_1 = this._ismlModelNavigation.getAllAttributes(containedTypeSpec);
        for(final Attribute attr_1 : _allAttributes_1) {
          _builder.append("\t\t      \t\t");
          _builder.append("Label(");
          CharSequence _itVariable_1 = this.itVariable(containedTypeSpec);
          _builder.append(_itVariable_1, "\t\t      \t\t");
          _builder.append(".");
          String _name_2 = attr_1.getName();
          _builder.append(_name_2, "\t\t      \t\t");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t      \t\t");
      _builder.append("Button(\"Remove\",false) -> ");
      CharSequence _controllerName = this.controllerName(containedTypeSpec);
      _builder.append(_controllerName, "\t\t      \t\t");
      _builder.append(".");
      CharSequence _removeAction = this.removeAction(containedTypeSpec);
      _builder.append(_removeAction, "\t\t      \t\t");
      _builder.append("(");
      CharSequence _variable_1 = this.variable(e);
      _builder.append(_variable_1, "\t\t      \t\t");
      _builder.append(", ");
      CharSequence _variable_2 = this.variable(e);
      _builder.append(_variable_2, "\t\t      \t\t");
      _builder.append(".");
      String _name_3 = a.getName();
      _builder.append(_name_3, "\t\t      \t\t");
      _builder.append(", ");
      CharSequence _itVariable_2 = this.itVariable(containedTypeSpec);
      _builder.append(_itVariable_2, "\t\t      \t\t");
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Button(\"Add New ");
      String _label_2 = this.toLabel(containedTypeSpec.getName());
      _builder.append(_label_2, "\t");
      _builder.append("\", false) -> ");
      CharSequence _controllerName_1 = this.controllerName(containedTypeSpec);
      _builder.append(_controllerName_1, "\t");
      _builder.append(".");
      CharSequence _createToAddAction = this.createToAddAction(containedTypeSpec);
      _builder.append(_createToAddAction, "\t");
      _builder.append("(");
      CharSequence _variable_3 = this.variable(e);
      _builder.append(_variable_3, "\t");
      _builder.append(", ");
      CharSequence _variable_4 = this.variable(e);
      _builder.append(_variable_4, "\t");
      _builder.append(".");
      String _name_4 = a.getName();
      _builder.append(_name_4, "\t");
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("Button(\"Add Existing ");
      String _label_3 = this.toLabel(containedTypeSpec.getName());
      _builder.append(_label_3, "\t");
      _builder.append("\", false) -> ");
      CharSequence _controllerName_2 = this.controllerName(containedTypeSpec);
      _builder.append(_controllerName_2, "\t");
      _builder.append(".");
      CharSequence _selectToAddAction = this.selectToAddAction(containedTypeSpec);
      _builder.append(_selectToAddAction, "\t");
      _builder.append("(");
      CharSequence _variable_5 = this.variable(e);
      _builder.append(_variable_5, "\t");
      _builder.append(", ");
      CharSequence _variable_6 = this.variable(e);
      _builder.append(_variable_6, "\t");
      _builder.append(".");
      String _name_5 = a.getName();
      _builder.append(_name_5, "\t");
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence templateView(final Entity e, final Attribute a, final boolean deepView) {
    CharSequence _xifexpression = null;
    boolean _isCollection = this._typeChecker.isCollection(a.getType());
    if (_isCollection) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Button(\"");
      String _label = this.toLabel(a.getName());
      _builder.append(_label);
      _builder.append("\", false) -> ");
      CharSequence _controllerName = this.controllerName(this._typeChecker.containedTypeSpecification(a.getType()));
      _builder.append(_controllerName);
      _builder.append(".");
      TypeSpecification _containedTypeSpecification = this._typeChecker.containedTypeSpecification(a.getType());
      CharSequence _subListAction = null;
      if (_containedTypeSpecification!=null) {
        _subListAction=this.subListAction(_containedTypeSpecification);
      }
      _builder.append(_subListAction);
      _builder.append("(");
      CharSequence _variable = this.variable(e);
      _builder.append(_variable);
      _builder.append(", ");
      CharSequence _variable_1 = this.variable(e);
      _builder.append(_variable_1);
      _builder.append(".");
      String _name = a.getName();
      _builder.append(_name);
      _builder.append(");");
      _xifexpression = _builder;
    } else {
      CharSequence _xifexpression_1 = null;
      if (((this._ismlModelNavigation.getTypeSpecification(a.getType()) instanceof Entity) && deepView)) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("Button(\"");
        String _label_1 = this.toLabel(a.getName());
        _builder_1.append(_label_1);
        _builder_1.append("\", false) -> ");
        CharSequence _controllerName_1 = this.controllerName(this._ismlModelNavigation.getTypeSpecification(a.getType()));
        _builder_1.append(_controllerName_1);
        _builder_1.append(".");
        CharSequence _viewAction = this.viewAction(this._ismlModelNavigation.getTypeSpecification(a.getType()));
        _builder_1.append(_viewAction);
        _builder_1.append("(");
        CharSequence _variable_2 = this.variable(e);
        _builder_1.append(_variable_2);
        _builder_1.append(".");
        String _name_1 = a.getName();
        _builder_1.append(_name_1);
        _builder_1.append(");");
        _xifexpression_1 = _builder_1;
      } else {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("Label(\"");
        String _label_2 = this.toLabel(a.getName());
        _builder_2.append(_label_2);
        _builder_2.append("\");");
        _builder_2.newLineIfNotEmpty();
        _builder_2.append("Label(");
        CharSequence _variable_3 = this.variable(e);
        _builder_2.append(_variable_3);
        _builder_2.append(".");
        String _name_2 = a.getName();
        _builder_2.append(_name_2);
        _builder_2.append(");");
        _builder_2.newLineIfNotEmpty();
        _xifexpression_1 = _builder_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
}
