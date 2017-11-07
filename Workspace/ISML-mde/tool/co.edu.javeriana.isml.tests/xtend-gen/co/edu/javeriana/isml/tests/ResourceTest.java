package co.edu.javeriana.isml.tests;

import co.edu.javeriana.isml.IsmlInjectorProvider;
import co.edu.javeriana.isml.isml.InformationSystem;
import co.edu.javeriana.isml.tests.CommonTests;
import co.edu.javeriana.isml.tests.TestHelper;
import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(IsmlInjectorProvider.class)
@SuppressWarnings("all")
public class ResourceTest extends CommonTests {
  @Inject
  @Extension
  private ParseHelper<InformationSystem> _parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Inject
  @Extension
  private TestHelper _testHelper;
  
  @Test
  public void resourceReference() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package pac;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("resources {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("$course; ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("$course.name;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("resourceBundle Resource_es_CO {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("$course = \"Curso\";");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("$course.name = \"Nombre\";");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final InformationSystem result = this._parseHelper.parse(_builder, this.rs);
      this._validationTestHelper.assertNoErrors(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
