package co.edu.javeriana.isml.tests;

import co.edu.javeriana.isml.IsmlInjectorProvider;
import co.edu.javeriana.isml.isml.InformationSystem;
import co.edu.javeriana.isml.tests.CommonTests;
import co.edu.javeriana.isml.tests.TestHelper;
import co.edu.javeriana.isml.validation.TypeChecker;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(IsmlInjectorProvider.class)
@SuppressWarnings("all")
public class IsmlValidatorTest extends CommonTests {
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
  
  @Test
  public void incorrectAssignment() {
    try {
      InputOutput.<String>println("incorrectAssignment");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("controller Controller {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("action() {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("Integer i = \"a\";");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      final InformationSystem is = this._parseHelper.parse(_builder, this.rs);
      InputOutput.<List<Issue>>println(this._validationTestHelper.validate(is));
      this._testHelper.assertErrors(is);
      this._testHelper.assertNoSyntaxErrors(is);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void incorrectAssignmentGenericArray() {
    try {
      InputOutput.<String>println("incorrectAssignmentGenericArray");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("entity Course {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("service Persistence {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("native <T> Any load(Type<T> t,Integer id);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("native <T> Collection<T> findAll(Type<T> t);");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Controller {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("has Persistence persistence;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Course course = persistence.findAll(Course);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final InformationSystem is = this._parseHelper.parse(_builder, this.rs);
      InputOutput.<List<Issue>>println(this._validationTestHelper.validate(is));
      this._testHelper.assertErrors(is);
      this._testHelper.assertNoSyntaxErrors(is);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void incorrectAssignmentArrayContent() {
    try {
      InputOutput.<String>println("incorrectAssignmentArrayContent");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("entity Course {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("service Persistence {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("native <T> Any load(Type<T> t,Integer id);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("native <T> Collection<T> findAll(Type<T> t);");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Controller {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("has Persistence persistence;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Collection<Course> course = persistence.findAll(String);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final InformationSystem is = this._parseHelper.parse(_builder, this.rs);
      InputOutput.<List<Issue>>println(this._validationTestHelper.validate(is));
      this._testHelper.assertErrors(is);
      this._testHelper.assertNoSyntaxErrors(is);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void correctAssignmentGenericsWithTypes() {
    try {
      InputOutput.<String>println("correctAssignmentGenericsWithTypes");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("entity Course {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("service Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("native <T> T load(Type<T> t,Integer id);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("native <T> Collection<T> findAll(Type<T> t);");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Controller {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("has Test test;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Course course = test.load(Course, 1);");
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
  public void parameterizedType4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("entity Course {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("service Persistence {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("native <T> Any load(Type<T> t,Integer id);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("native <T> Collection<T> findAll(Type<T> t);");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Controller {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("has Persistence persistence;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Course course = persistence.load(String, 1);");
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
  public void callToGenericMethod() {
    try {
      InputOutput.<String>println("callToGenericMethod");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("entity Course {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("service Persistence {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("native <T> T load(Type<T> type,Integer id);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("native <T> Collection<T> findAll(Type<T> type);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("native <T> T delete(Type<T> type, Integer id);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("native <T> T delete(T obj);");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Controller {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("has Persistence persistence;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Course course;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("persistence.delete(course);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final InformationSystem is = this._parseHelper.parse(_builder, this.rs);
      InputOutput.<List<Issue>>println(this._validationTestHelper.validate(is));
      this._validationTestHelper.assertNoErrors(is);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
