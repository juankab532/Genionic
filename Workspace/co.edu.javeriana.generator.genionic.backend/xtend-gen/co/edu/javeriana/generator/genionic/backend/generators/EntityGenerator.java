package co.edu.javeriana.generator.genionic.backend.generators;

import co.edu.javeriana.generator.genionic.backend.BackendGenerator;
import co.edu.javeriana.generator.genionic.backend.templates.EntityTemplate;
import co.edu.javeriana.isml.generator.common.SimpleGenerator;
import co.edu.javeriana.isml.generator.common.SimpleTemplate;
import co.edu.javeriana.isml.isml.Entity;
import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class EntityGenerator extends SimpleGenerator<Entity> {
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Override
  public String getFileName(final Entity e) {
    EObject _eContainer = e.eContainer();
    QualifiedName _fullyQualifiedName = null;
    if (_eContainer!=null) {
      _fullyQualifiedName=this._iQualifiedNameProvider.getFullyQualifiedName(_eContainer);
    }
    String _lowerCase = _fullyQualifiedName.toString("/").toLowerCase();
    String _plus = (_lowerCase + "/");
    String _name = e.getName();
    String _plus_1 = (_plus + _name);
    return (_plus_1 + ".java");
  }
  
  @Override
  public String getOutputConfigurationName() {
    return BackendGenerator.ENTITIES;
  }
  
  @Override
  public SimpleTemplate<Entity> getTemplate() {
    return new EntityTemplate();
  }
}