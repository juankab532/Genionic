package co.edu.javeriana.isml.tests;

import co.edu.javeriana.isml.IsmlInjectorProvider;
import co.edu.javeriana.isml.isml.Feature;
import co.edu.javeriana.isml.isml.InformationSystem;
import co.edu.javeriana.isml.isml.Method;
import co.edu.javeriana.isml.isml.NamedElement;
import co.edu.javeriana.isml.isml.Service;
import co.edu.javeriana.isml.scoping.IsmlModelNavigation;
import co.edu.javeriana.isml.tests.CommonTests;
import co.edu.javeriana.isml.tests.TestHelper;
import co.edu.javeriana.isml.validation.SignatureExtension;
import com.google.inject.Inject;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(IsmlInjectorProvider.class)
@SuppressWarnings("all")
public class GenericsTest extends CommonTests {
  @Inject
  @Extension
  private ParseHelper<InformationSystem> _parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Inject
  @Extension
  private TestHelper _testHelper;
  
  @Inject
  @Extension
  private SignatureExtension _signatureExtension;
  
  @Inject
  @Extension
  private IsmlModelNavigation _ismlModelNavigation;
  
  @Test
  public void overloadedMethodSignatureTest() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("service Persistence {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("native <T> T delete(Type<T> type, Integer id);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("native <T> T delete(T obj);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      final InformationSystem is = this._parseHelper.parse(_builder, this.rs);
      NamedElement _get = this._ismlModelNavigation.getComponents(is).get(0);
      final co.edu.javeriana.isml.isml.Package pkg = ((co.edu.javeriana.isml.isml.Package) _get);
      NamedElement _get_1 = this._ismlModelNavigation.getComponents(pkg).get(0);
      final Service serv = ((Service) _get_1);
      Feature _get_2 = serv.getBody().get(0);
      final Method met1 = ((Method) _get_2);
      Feature _get_3 = serv.getBody().get(1);
      final Method met2 = ((Method) _get_3);
      InputOutput.<String>println(this._signatureExtension.getSignature(met1));
      Assert.assertEquals("test.Persistence.delete(common.primitives.Type<T>,common.primitives.Integer)", this._signatureExtension.getSignature(met1));
      InputOutput.<String>println(this._signatureExtension.getSignature(met2));
      Assert.assertEquals("test.Persistence.delete(T)", this._signatureExtension.getSignature(met2));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void genericsAndInheritance() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("entity Team {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._parseHelper.parse(_builder, this.rs);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package test;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("page TeamList(Array <Team> teams, Team selectedTeam, String queryCountry) controlledBy TeamListManager {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this._parseHelper.parse(_builder_1, this.rs);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package test;");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("controller TeamListManager {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("has TeamPersistence teamPersistence;");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("action() {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("show TeamList(teamPersistence.findAll(),null,null);");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this._parseHelper.parse(_builder_2, this.rs);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("package test;");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append("service TeamPersistence extends Persistence<Team> {");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.newLine();
      _builder_3.append("}");
      _builder_3.newLine();
      this._parseHelper.parse(_builder_3, this.rs);
      final Consumer<Resource> _function = (Resource x) -> {
        this._validationTestHelper.assertNoErrors(x.getContents().get(0));
      };
      this.rs.getResources().forEach(_function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void genericsInstantiation() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("entity Team {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._parseHelper.parse(_builder, this.rs);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package test;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("page TeamList(Array <Team> teams, Team selectedTeam, String queryCountry) controlledBy TeamListManager {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this._parseHelper.parse(_builder_1, this.rs);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package test;");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("controller TeamListManager {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("has Persistence<Team> teamPersistence;");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("action() {");
      _builder_2.newLine();
      _builder_2.append("\t\t");
      _builder_2.append("show TeamList(teamPersistence.findAll(),null,null);");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      this._parseHelper.parse(_builder_2, this.rs);
      final Consumer<Resource> _function = (Resource x) -> {
        this._validationTestHelper.assertNoErrors(x.getContents().get(0));
      };
      this.rs.getResources().forEach(_function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void wrongNumOfTypeParameters() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("service Test<T> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final InformationSystem obj1 = this._parseHelper.parse(_builder, this.rs);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package test;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("service Test2 extends Test<Integer,Integer> {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final InformationSystem obj2 = this._parseHelper.parse(_builder_1, this.rs);
      this._testHelper.assertErrors(obj2);
      this._testHelper.assertNoSyntaxErrors(obj1);
      this._testHelper.assertNoSyntaxErrors(obj2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
