package co.edu.javeriana.isml.tests;

import co.edu.javeriana.isml.IsmlInjectorProvider;
import co.edu.javeriana.isml.isml.Action;
import co.edu.javeriana.isml.isml.Controller;
import co.edu.javeriana.isml.isml.Expression;
import co.edu.javeriana.isml.isml.InformationSystem;
import co.edu.javeriana.isml.isml.MethodStatement;
import co.edu.javeriana.isml.isml.NamedElement;
import co.edu.javeriana.isml.isml.Variable;
import co.edu.javeriana.isml.scoping.IsmlModelNavigation;
import co.edu.javeriana.isml.tests.CommonTests;
import co.edu.javeriana.isml.tests.TestHelper;
import co.edu.javeriana.isml.validation.TypeChecker;
import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(IsmlInjectorProvider.class)
@SuppressWarnings("all")
public class TypeCheckerTest extends CommonTests {
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
  private TypeChecker _typeChecker;
  
  @Inject
  @Extension
  private IsmlModelNavigation _ismlModelNavigation;
  
  private final String code = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("controller Controller {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("action() {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("Integer i = 10;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      return _builder.toString();
    }
  }.apply();
  
  @Test
  public void getCorrectType() {
    try {
      final InformationSystem is = this._parseHelper.parse(this.code, this.rs);
      NamedElement _get = this._ismlModelNavigation.getComponents(is).get(0);
      final co.edu.javeriana.isml.isml.Package pkg = ((co.edu.javeriana.isml.isml.Package) _get);
      NamedElement _get_1 = this._ismlModelNavigation.getComponents(pkg).get(0);
      final Controller controller = ((Controller) _get_1);
      Action _get_2 = controller.getBody().get(0);
      final Action action = ((Action) _get_2);
      MethodStatement _get_3 = action.getBody().get(0);
      final Variable variable = ((Variable) _get_3);
      final String varType = this._ismlModelNavigation.getTypeSpecification(variable.getType()).getName();
      Assert.assertEquals("Integer", varType);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void getCorrectType2() {
    try {
      final InformationSystem is = this._parseHelper.parse(this.code, this.rs);
      NamedElement _get = this._ismlModelNavigation.getComponents(is).get(0);
      final co.edu.javeriana.isml.isml.Package pkg = ((co.edu.javeriana.isml.isml.Package) _get);
      NamedElement _get_1 = this._ismlModelNavigation.getComponents(pkg).get(0);
      final Controller controller = ((Controller) _get_1);
      Action _get_2 = controller.getBody().get(0);
      final Action action = ((Action) _get_2);
      MethodStatement _get_3 = action.getBody().get(0);
      final Variable variable = ((Variable) _get_3);
      final Expression value = variable.getValue();
      final String valueType = this._ismlModelNavigation.getTypeSpecification(this._typeChecker.getType(value)).getName();
      Assert.assertEquals("Integer", valueType);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
