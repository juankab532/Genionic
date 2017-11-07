package co.edu.javeriana.isml.generator.crud.templates;

import co.edu.javeriana.isml.generator.common.SimpleTemplate;
import co.edu.javeriana.isml.generator.crud.templates.CommonTemplates;
import co.edu.javeriana.isml.isml.Attribute;
import co.edu.javeriana.isml.isml.Entity;
import co.edu.javeriana.isml.scoping.IsmlModelNavigation;
import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class ListPageTemplate extends SimpleTemplate<Entity> {
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Inject
  @Extension
  private CommonTemplates _commonTemplates;
  
  @Inject
  @Extension
  private IsmlModelNavigation _ismlModelNavigation;
  
  protected CharSequence template(final Entity e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    EObject _eContainer = e.eContainer();
    QualifiedName _fullyQualifiedName = null;
    if (_eContainer!=null) {
      _fullyQualifiedName=this._iQualifiedNameProvider.getFullyQualifiedName(_eContainer);
    }
    _builder.append(_fullyQualifiedName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("page ");
    CharSequence _listPage = this._commonTemplates.listPage(e);
    _builder.append(_listPage);
    _builder.append("(");
    CharSequence _collectionType = this._commonTemplates.collectionType(e);
    _builder.append(_collectionType);
    _builder.append(" ");
    CharSequence _collectionVariable = this._commonTemplates.collectionVariable(e);
    _builder.append(_collectionVariable);
    _builder.append(") controlledBy ");
    CharSequence _controllerName = this._commonTemplates.controllerName(e);
    _builder.append(_controllerName);
    _builder.append("  {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("Form {");
    _builder.newLine();
    _builder.append("\t       ");
    _builder.append("Panel(\"");
    String _label = this._commonTemplates.toLabel(this._commonTemplates.collectionType(e));
    _builder.append(_label, "\t       ");
    _builder.append("\") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t           ");
    _builder.append("DataTable(\"");
    String _label_1 = this._commonTemplates.toLabel(this._commonTemplates.collectionType(e));
    _builder.append(_label_1, "\t           ");
    _builder.append("\", null) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t               ");
    _builder.append("header : {                    ");
    _builder.newLine();
    {
      Iterable<Attribute> _attributes = this._ismlModelNavigation.getAttributes(e);
      for(final Attribute attr : _attributes) {
        _builder.append("\t                   ");
        CharSequence _headerCell = this._commonTemplates.headerCell(attr);
        _builder.append(_headerCell, "\t                   ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t                   ");
    _builder.append("Label(\"View\");");
    _builder.newLine();
    _builder.append("\t                   ");
    _builder.append("Label(\"Edit\");");
    _builder.newLine();
    _builder.append("\t                   ");
    _builder.append("Label(\"Delete\");");
    _builder.newLine();
    _builder.append("\t               ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t               ");
    _builder.append("body : ");
    _builder.newLine();
    _builder.append("\t               ");
    _builder.append("for(");
    String _name = e.getName();
    _builder.append(_name, "\t               ");
    _builder.append(" ");
    CharSequence _variable = this._commonTemplates.variable(e);
    _builder.append(_variable, "\t               ");
    _builder.append(" in ");
    CharSequence _collectionVariable_1 = this._commonTemplates.collectionVariable(e);
    _builder.append(_collectionVariable_1, "\t               ");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    {
      Iterable<Attribute> _attributes_1 = this._ismlModelNavigation.getAttributes(e);
      for(final Attribute attr_1 : _attributes_1) {
        _builder.append("\t               \t\t");
        CharSequence _cell = this._commonTemplates.cell(e, attr_1);
        _builder.append(_cell, "\t               \t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t                   \t");
    _builder.append("Button(\"View\",false)-> ");
    CharSequence _viewAction = this._commonTemplates.viewAction(e);
    _builder.append(_viewAction, "\t                   \t");
    _builder.append("(");
    CharSequence _variable_1 = this._commonTemplates.variable(e);
    _builder.append(_variable_1, "\t                   \t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t                   \t");
    _builder.append("Button(\"Edit\",false) -> ");
    CharSequence _editAction = this._commonTemplates.editAction(e);
    _builder.append(_editAction, "\t                   \t");
    _builder.append("(");
    CharSequence _variable_2 = this._commonTemplates.variable(e);
    _builder.append(_variable_2, "\t                   \t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t                   \t");
    _builder.append("Button(\"Delete\",false) -> ");
    CharSequence _deleteAction = this._commonTemplates.deleteAction(e);
    _builder.append(_deleteAction, "\t                   \t");
    _builder.append("(");
    CharSequence _variable_3 = this._commonTemplates.variable(e);
    _builder.append(_variable_3, "\t                   \t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t               ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t           ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t        \t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} ");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
