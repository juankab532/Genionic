package co.edu.javeriana.isml.tests;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Before;

@SuppressWarnings("all")
public class CommonTests {
  protected ResourceSet rs;
  
  /**
   * Loads primitive data types, constraints, widgets, and services
   */
  @Before
  public void initCommon() {
    try {
      ResourceSetImpl _resourceSetImpl = new ResourceSetImpl();
      this.rs = _resourceSetImpl;
      String _basePath = this.getBasePath();
      String _translatePath = this.translatePath("ISML-MDE/tool/co.edu.javeriana.isml.common/model/common/primitives/Primitives.isml");
      String _plus = (_basePath + _translatePath);
      final URI uri = URI.createURI(_plus);
      final Resource resource = this.rs.createResource(uri);
      resource.load(CollectionLiterals.<Object, Object>emptyMap());
      String _basePath_1 = this.getBasePath();
      String _translatePath_1 = this.translatePath("ISML-MDE/tool/co.edu.javeriana.isml.common/model/common/primitives/Constraints.isml");
      String _plus_1 = (_basePath_1 + _translatePath_1);
      this.rs.createResource(URI.createURI(_plus_1)).load(CollectionLiterals.<Object, Object>emptyMap());
      String _basePath_2 = this.getBasePath();
      String _translatePath_2 = this.translatePath("ISML-MDE/tool/co.edu.javeriana.isml.common/view/common/widgets/PrimitiveWidgets.isml");
      String _plus_2 = (_basePath_2 + _translatePath_2);
      this.rs.createResource(URI.createURI(_plus_2)).load(CollectionLiterals.<Object, Object>emptyMap());
      String _basePath_3 = this.getBasePath();
      String _translatePath_3 = this.translatePath("ISML-MDE/tool/co.edu.javeriana.isml.common/services/common/services/Persistence.isml");
      String _plus_3 = (_basePath_3 + _translatePath_3);
      this.rs.createResource(URI.createURI(_plus_3)).load(CollectionLiterals.<Object, Object>emptyMap());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String getBasePath() {
    String _property = System.getProperty("user.home");
    String _plus = ("file:///" + _property);
    String _translatePath = this.translatePath("/git/");
    return (_plus + _translatePath);
  }
  
  public String translatePath(final String path) {
    final String sep = System.getProperty("file.separator");
    return path.replace("/", sep);
  }
}
