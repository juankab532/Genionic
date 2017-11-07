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
public class ServiceTest extends CommonTests {
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
  public void uniqueInIfElse() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("service Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Void method1() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Void method2() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("String s;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (true) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("String s;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("String s;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final InformationSystem result = this._parseHelper.parse(_builder, this.rs);
      this._validationTestHelper.assertNoErrors(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void correctVariableDeclaration1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("service Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Void method2() {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("String x;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("x = \"a\";");
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
  public void correctVariableDeclaration2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("service Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Void method2() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("String x;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (true) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("String y;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("y = \"aaa\";");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("x = \"bbb\";");
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
      final InformationSystem result = this._parseHelper.parse(_builder, this.rs);
      this._validationTestHelper.assertNoErrors(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void correctVariableDeclaration3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("service Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Void method2() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (true) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("String x;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("x = \"aa\";");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("String x;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("x = \"bb\";");
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
      final InformationSystem result = this._parseHelper.parse(_builder, this.rs);
      this._validationTestHelper.assertNoErrors(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void incorrectVariableDeclaration1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("service Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Void method2() {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("x = 1;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("String x;");
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
  public void incorrectVariableDeclaration2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("service Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Void method2() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (true) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("String x;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("x = 1;");
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
  public void incorrectVariableDeclaration3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("service Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Void method2() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (true) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("x = 1;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("String x;");
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
  public void parameterReference() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("service Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Void method(String a, String b) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("method2(a);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("method2(b);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Void method2(String c) {");
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
  public void parameterReference2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("service Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Void method2(String c) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Void method(String a, String b) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("method2(a);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("method2(b);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder, this.rs));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
