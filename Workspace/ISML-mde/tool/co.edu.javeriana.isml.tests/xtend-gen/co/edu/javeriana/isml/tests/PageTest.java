package co.edu.javeriana.isml.tests;

import co.edu.javeriana.isml.IsmlInjectorProvider;
import co.edu.javeriana.isml.isml.InformationSystem;
import co.edu.javeriana.isml.tests.CommonTests;
import co.edu.javeriana.isml.tests.TestHelper;
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
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(IsmlInjectorProvider.class)
@SuppressWarnings("all")
public class PageTest extends CommonTests {
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
  public void actionCall() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Controller {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action1() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action2() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("page Page controlledBy Controller{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Button(\"\", true) -> action1();");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder, this.rs));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void actionCall2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Controller {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action1() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action2() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Controller2 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("page Page controlledBy Controller2{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Button(\"\", true) -> Controller.action1();");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder, this.rs));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void actionCallMultipleResources() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("page Page controlledBy Controller1 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Button(\"\", true) -> Controller2.action2();");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Button(\"\", true) -> action1();");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Button(\"\", true) -> Controller1.action1();");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      this._parseHelper.parse(_builder, this.rs);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package test;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("controller Controller1 {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("action1() {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      this._parseHelper.parse(_builder_1, this.rs);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package test;");
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.newLine();
      _builder_2.append("controller Controller2 {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("action2() {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("}");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
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
  public void incorrectActionCall() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Controller {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action1() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action2() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Controller2 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action3() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("page Page controlledBy Controller{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Button(\"\", true) -> action3();");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final InformationSystem obj = this._parseHelper.parse(_builder, this.rs);
      this._testHelper.assertErrors(obj);
      this._testHelper.assertNoSyntaxErrors(obj);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void forVarReference() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Controller {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action1() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action2() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("page Page(Array<String> list) controlledBy Controller{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("for (String str in list) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Button(str, true);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder, this.rs));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void forVarReference2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("entity Entity {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String name;");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Controller {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action1() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action2() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("page Page(Array<Entity> list) controlledBy Controller{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("for (Entity ent in list) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Button(ent.name, true);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder, this.rs));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void wodgetHasBodyAndInstanceAlsoHasBody() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.append("widget TestText;");
      _builder.newLine();
      _builder.append("widget TestForm {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("controller Controller {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action1() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action2() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("page Page controlledBy Controller{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("TestForm {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder, this.rs));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void instanceShouldHaveBody() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.append("widget TestText;");
      _builder.newLine();
      _builder.append("widget TestForm {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Controller {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action1() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action2() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("page Page controlledBy Controller{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("TestForm;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final InformationSystem obj = this._parseHelper.parse(_builder, this.rs);
      this._testHelper.assertErrors(obj);
      this._testHelper.assertNoSyntaxErrors(obj);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void correctBlock3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.append("widget TestText;");
      _builder.newLine();
      _builder.append("widget TestForm {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("controller Controller {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action1() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action2() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("page Page controlledBy Controller{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("TestForm {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder, this.rs));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void missingAndIncorrectBlockParameters() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("widget TestDataTable {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("header: {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("body: {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("widget TestText;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Controller;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("page Page controlledBy Controller{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("TestDataTable {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("TestText;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final InformationSystem obj = this._parseHelper.parse(_builder, this.rs);
      this._testHelper.assertErrors(obj);
      this._testHelper.assertNoSyntaxErrors(obj);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void incorrectBlockParameter() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("widget TestDataTable {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("header: {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("body: {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("widget TestText;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Controller;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("page Page controlledBy Controller{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("TestDataTable {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("header: {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("incorrectParameter: {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final InformationSystem obj = this._parseHelper.parse(_builder, this.rs);
      this._testHelper.assertErrors(obj);
      this._testHelper.assertNoSyntaxErrors(obj);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void missingBlockParameter() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("widget TestDataTable {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("header: {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("subheader: {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("body: {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("widget TestText;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Controller;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("page Page controlledBy Controller{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("TestDataTable {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("header: {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("body: {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final InformationSystem obj = this._parseHelper.parse(_builder, this.rs);
      this._testHelper.assertErrors(obj);
      this._testHelper.assertNoSyntaxErrors(obj);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void correctNestedBlockParameters() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("widget TestDataTable {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("header: {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("subheader: {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("subsubheader: {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("body: {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("widget TestText;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Controller {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action1() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action2() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("page Page controlledBy Controller{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("TestDataTable {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("header: {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("subheader: {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("subsubheader: {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("body: {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("TestText;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final InformationSystem obj = this._parseHelper.parse(_builder, this.rs);
      this._validationTestHelper.assertNoErrors(obj);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void correctBlockParameters2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("widget TestDataTable {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("header: {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("body: {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("widget TestText;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Controller {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action1() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action2() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("entity Person{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String name;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("page Page(Collection<Person> persons) controlledBy Controller{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("TestDataTable {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("header: {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("TestText;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("body: ");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("for (Person p in persons) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("TestText;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final InformationSystem obj = this._parseHelper.parse(_builder, this.rs);
      this._validationTestHelper.assertNoErrors(obj);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void incorrectNestedBlockParameters() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("widget TestDataTable {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("header: {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("subheader: {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("subsubheader: {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("body: {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("widget TestText;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Controller {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action1() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action2() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("page Page controlledBy Controller{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("TestDataTable {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("header: {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("subheader: {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("TestText;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("body: {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("TestText;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final InformationSystem obj = this._parseHelper.parse(_builder, this.rs);
      this._testHelper.assertErrors(obj);
      this._testHelper.assertNoSyntaxErrors(obj);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void correctViewInstance() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Controller ;");
      _builder.newLine();
      _builder.append("widget TestWidget;");
      _builder.newLine();
      _builder.append("page Page controlledBy Controller {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Form {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("TestWidget;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder, this.rs));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void correctCollectionReference() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test ;");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Controller ;");
      _builder.newLine();
      _builder.append("widget TestWidget;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("entity Company {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Array<Person> persons;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("entity Person {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String name;");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("page Page(Company company) controlledBy Controller {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("for(Person aPerson in company.persons) {");
      _builder.newLine();
      _builder.append("\t \t\t");
      _builder.append("Label(aPerson.name);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder, this.rs));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
