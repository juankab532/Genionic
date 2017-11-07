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
public class SubListPageTemplate extends SimpleTemplate<Entity> {
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
    CharSequence _subListPage = this._commonTemplates.subListPage(e);
    _builder.append(_subListPage);
    _builder.append("(Any container, Collection<");
    String _name = e.getName();
    _builder.append(_name);
    _builder.append("> collection) controlledBy ");
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
    _builder.append("\t               ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t               ");
    _builder.append("body : ");
    _builder.newLine();
    _builder.append("\t               ");
    _builder.append("for(");
    String _name_1 = e.getName();
    _builder.append(_name_1, "\t               ");
    _builder.append(" ");
    CharSequence _variable = this._commonTemplates.variable(e);
    _builder.append(_variable, "\t               ");
    _builder.append(" in collection) {");
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
    _builder.append("\t               ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t           ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("Button(\"Back\", false) -> DefaultPageDispatcher.view(container);");
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
