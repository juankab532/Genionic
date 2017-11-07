package co.edu.javeriana.isml.generator.crud.generators;

import co.edu.javeriana.isml.generator.common.SimpleGenerator;
import co.edu.javeriana.isml.generator.common.SimpleTemplate;
import co.edu.javeriana.isml.generator.crud.CRUDGenerator;
import co.edu.javeriana.isml.generator.crud.templates.CommonTemplates;
import co.edu.javeriana.isml.generator.crud.templates.ViewPageTemplate;
import co.edu.javeriana.isml.isml.Entity;
import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class ViewPageGenerator extends SimpleGenerator<Entity> {
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Inject
  @Extension
  private CommonTemplates _commonTemplates;
  
  protected String getFileName(final Entity e) {
    EObject _eContainer = e.eContainer();
    QualifiedName _fullyQualifiedName = null;
    if (_eContainer!=null) {
      _fullyQualifiedName=this._iQualifiedNameProvider.getFullyQualifiedName(_eContainer);
    }
    String _lowerCase = _fullyQualifiedName.toString("/").toLowerCase();
    String _plus = (_lowerCase + "/");
    CharSequence _viewPage = this._commonTemplates.viewPage(e);
    String _plus_1 = (_plus + _viewPage);
    return (_plus_1 + ".isml");
  }
  
  protected String getOutputConfigurationName() {
    return CRUDGenerator.PAGES;
  }
  
  public SimpleTemplate<Entity> getTemplate() {
    return new ViewPageTemplate();
  }
}
