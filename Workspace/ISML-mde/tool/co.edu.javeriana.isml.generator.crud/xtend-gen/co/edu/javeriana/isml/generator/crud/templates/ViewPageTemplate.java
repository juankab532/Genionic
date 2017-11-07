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
public class ViewPageTemplate extends SimpleTemplate<Entity> {
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
    CharSequence _viewPage = this._commonTemplates.viewPage(e);
    _builder.append(_viewPage);
    _builder.append("(");
    String _name = e.getName();
    _builder.append(_name);
    _builder.append(" ");
    CharSequence _variable = this._commonTemplates.variable(e);
    _builder.append(_variable);
    _builder.append(") controlledBy ");
    CharSequence _controllerName = this._commonTemplates.controllerName(e);
    _builder.append(_controllerName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("Panel(\"");
    String _label = this._commonTemplates.toLabel(e.getName());
    _builder.append(_label, "\t");
    _builder.append("\") {");
    _builder.newLineIfNotEmpty();
    {
      Iterable<Attribute> _allAttributes = this._ismlModelNavigation.getAllAttributes(e);
      for(final Attribute attr : _allAttributes) {
        _builder.append("\t\t");
        CharSequence _templateView = this._commonTemplates.templateView(e, attr, true);
        _builder.append(_templateView, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Button(\"Ok\", false) -> listAll();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
