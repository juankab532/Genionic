package co.edu.javeriana.isml.generator.crud.templates;

import co.edu.javeriana.isml.generator.common.SimpleTemplate;
import co.edu.javeriana.isml.generator.crud.templates.CommonTemplates;
import co.edu.javeriana.isml.isml.Attribute;
import co.edu.javeriana.isml.isml.Entity;
import co.edu.javeriana.isml.scoping.IsmlModelNavigation;
import co.edu.javeriana.isml.validation.TypeChecker;
import co.edu.javeriana.isml.validation.TypeFactory;
import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class AddPageTemplate extends SimpleTemplate<Entity> {
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Inject
  @Extension
  private CommonTemplates _commonTemplates;
  
  @Inject
  @Extension
  private TypeChecker _typeChecker;
  
  @Inject
  @Extension
  private TypeFactory _typeFactory;
  
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
    CharSequence _createToAddPage = this._commonTemplates.createToAddPage(e);
    _builder.append(_createToAddPage);
    _builder.append("(Any container, Collection<");
    String _name = e.getName();
    _builder.append(_name);
    _builder.append("> collection, ");
    String _name_1 = e.getName();
    _builder.append(_name_1);
    _builder.append(" ");
    CharSequence _variable = this._commonTemplates.variable(e);
    _builder.append(_variable);
    _builder.append(") controlledBy ");
    CharSequence _controllerName = this._commonTemplates.controllerName(e);
    _builder.append(_controllerName);
    _builder.append("  {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("Form {");
    _builder.newLine();
    {
      Iterable<Attribute> _allAttributes = this._ismlModelNavigation.getAllAttributes(e);
      for(final Attribute a : _allAttributes) {
        _builder.append("\t\t");
        CharSequence _templateEdit = this._commonTemplates.templateEdit(e, a, false);
        _builder.append(_templateEdit, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Button(\"Save\", true) -> ");
    CharSequence _addAction = this._commonTemplates.addAction(e);
    _builder.append(_addAction, "\t\t");
    _builder.append("(container, collection, ");
    CharSequence _variable_1 = this._commonTemplates.variable(e);
    _builder.append(_variable_1, "\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("Button(\"Cancel\", false) -> DefaultPageDispatcher.edit(container);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
