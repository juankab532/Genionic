package co.edu.javeriana.generator.genionic.backend.generators;

import co.edu.javeriana.generator.genionic.backend.BackendGenerator;
import co.edu.javeriana.generator.genionic.backend.templates.ServiceInterfaceTemplate;
import co.edu.javeriana.isml.generator.common.SimpleGenerator;
import co.edu.javeriana.isml.generator.common.SimpleTemplate;
import co.edu.javeriana.isml.isml.Service;
import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ServiceInterfaceGenerator extends SimpleGenerator<Service> {
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Override
  public String getFileName(final Service e) {
    EObject _eContainer = e.eContainer();
    QualifiedName _fullyQualifiedName = null;
    if (_eContainer!=null) {
      _fullyQualifiedName=this._iQualifiedNameProvider.getFullyQualifiedName(_eContainer);
    }
    String _lowerCase = _fullyQualifiedName.toString("/").toLowerCase();
    String _plus = (_lowerCase + "/");
    String _plus_1 = (_plus + "interfaces");
    String _plus_2 = (_plus_1 + "/");
    String _firstUpper = StringExtensions.toFirstUpper(e.getName());
    String _plus_3 = (_plus_2 + _firstUpper);
    return (_plus_3 + ".java");
  }
  
  @Override
  public String getOutputConfigurationName() {
    return BackendGenerator.SERVICE_INTERFACE;
  }
  
  @Override
  public SimpleTemplate<Service> getTemplate() {
    return new ServiceInterfaceTemplate();
  }
}
