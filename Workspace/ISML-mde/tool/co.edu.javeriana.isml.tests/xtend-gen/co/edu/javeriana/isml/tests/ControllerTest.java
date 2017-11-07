package co.edu.javeriana.isml.tests;

import co.edu.javeriana.isml.IsmlInjectorProvider;
import co.edu.javeriana.isml.isml.Action;
import co.edu.javeriana.isml.isml.ActionCall;
import co.edu.javeriana.isml.isml.Assignment;
import co.edu.javeriana.isml.isml.Controller;
import co.edu.javeriana.isml.isml.Expression;
import co.edu.javeriana.isml.isml.If;
import co.edu.javeriana.isml.isml.InformationSystem;
import co.edu.javeriana.isml.isml.MethodStatement;
import co.edu.javeriana.isml.isml.NamedElement;
import co.edu.javeriana.isml.isml.Reference;
import co.edu.javeriana.isml.isml.Type;
import co.edu.javeriana.isml.isml.TypeSpecification;
import co.edu.javeriana.isml.isml.Variable;
import co.edu.javeriana.isml.scoping.IsmlModelNavigation;
import co.edu.javeriana.isml.tests.CommonTests;
import co.edu.javeriana.isml.tests.TestHelper;
import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(IsmlInjectorProvider.class)
@SuppressWarnings("all")
public class ControllerTest extends CommonTests {
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
  private IsmlModelNavigation _ismlModelNavigation;
  
  @Test
  public void uniqueInIfElse() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Test {");
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
      final InformationSystem is = this._parseHelper.parse(_builder, this.rs);
      this._validationTestHelper.assertNoErrors(is);
      Pair<String, Object> _mappedTo = Pair.<String, Object>of("name", "test");
      Pair<String, Object> _mappedTo_1 = Pair.<String, Object>of("name", "Test");
      TestHelper.Element _mappedTo_2 = this._testHelper.operator_mappedTo(
        Action.class, Collections.<Pair<String, Object>>unmodifiableList(CollectionLiterals.<Pair<String, Object>>newArrayList()));
      Pair<String, Object> _mappedTo_3 = Pair.<String, Object>of("name", "s");
      Pair<String, Object> _mappedTo_4 = Pair.<String, Object>of("name", "String");
      TestHelper.Element _mappedTo_5 = this._testHelper.operator_mappedTo(TypeSpecification.class, Collections.<Pair<String, Object>>unmodifiableList(CollectionLiterals.<Pair<String, Object>>newArrayList(_mappedTo_4)));
      Pair<String, Object> _mappedTo_6 = Pair.<String, Object>of("referencedElement", _mappedTo_5);
      TestHelper.Element _mappedTo_7 = this._testHelper.operator_mappedTo(Type.class, Collections.<Pair<String, Object>>unmodifiableList(CollectionLiterals.<Pair<String, Object>>newArrayList(_mappedTo_6)));
      Pair<String, Object> _mappedTo_8 = Pair.<String, Object>of("type", _mappedTo_7);
      TestHelper.Element _mappedTo_9 = this._testHelper.operator_mappedTo(
        Variable.class, Collections.<Pair<String, Object>>unmodifiableList(CollectionLiterals.<Pair<String, Object>>newArrayList(_mappedTo_3, _mappedTo_8)));
      Pair<String, Object> _mappedTo_10 = Pair.<String, Object>of("body", Collections.<TestHelper.Element>unmodifiableList(CollectionLiterals.<TestHelper.Element>newArrayList(_mappedTo_9)));
      TestHelper.Element _mappedTo_11 = this._testHelper.operator_mappedTo(
        Action.class, Collections.<Pair<String, Object>>unmodifiableList(CollectionLiterals.<Pair<String, Object>>newArrayList(_mappedTo_10)));
      Pair<String, Object> _mappedTo_12 = Pair.<String, Object>of("body", Collections.<TestHelper.Element>unmodifiableList(CollectionLiterals.<TestHelper.Element>newArrayList(_mappedTo_2, _mappedTo_11)));
      TestHelper.Element _mappedTo_13 = this._testHelper.operator_mappedTo(
        Controller.class, Collections.<Pair<String, Object>>unmodifiableList(CollectionLiterals.<Pair<String, Object>>newArrayList(_mappedTo_1, _mappedTo_12)));
      Pair<String, Object> _mappedTo_14 = Pair.<String, Object>of("body", Collections.<TestHelper.Element>unmodifiableList(CollectionLiterals.<TestHelper.Element>newArrayList(_mappedTo_13)));
      TestHelper.Element _mappedTo_15 = this._testHelper.operator_mappedTo(
        co.edu.javeriana.isml.isml.Package.class, Collections.<Pair<String, Object>>unmodifiableList(CollectionLiterals.<Pair<String, Object>>newArrayList(_mappedTo, _mappedTo_14)));
      Pair<String, Object> _mappedTo_16 = Pair.<String, Object>of("body", Collections.<TestHelper.Element>unmodifiableList(CollectionLiterals.<TestHelper.Element>newArrayList(_mappedTo_15)));
      TestHelper.Element _mappedTo_17 = this._testHelper.operator_mappedTo(
        InformationSystem.class, Collections.<Pair<String, Object>>unmodifiableList(CollectionLiterals.<Pair<String, Object>>newArrayList(_mappedTo_16)));
      this._testHelper.assertEqualsElement(is, _mappedTo_17);
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
      _builder.append("controller Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action2() {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("String x;");
      _builder.newLine();
      _builder.append("\t\t\t");
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
      final InformationSystem is = this._parseHelper.parse(_builder, this.rs);
      InputOutput.<List<Issue>>println(this._validationTestHelper.validate(is));
      this._validationTestHelper.assertNoErrors(is);
      final Action action2 = this._ismlModelNavigation.<Action, Action>cast(IterableExtensions.<Action>head(this._ismlModelNavigation.<NamedElement, Controller>cast(IterableExtensions.<NamedElement>head(this._ismlModelNavigation.getComponents(this._ismlModelNavigation.<NamedElement, co.edu.javeriana.isml.isml.Package>cast(IterableExtensions.<NamedElement>head(this._ismlModelNavigation.getComponents(is)), co.edu.javeriana.isml.isml.Package.class))), Controller.class).getBody()), Action.class);
      final Variable v = this._ismlModelNavigation.<MethodStatement, Variable>cast(IterableExtensions.<MethodStatement>head(action2.getBody()), Variable.class);
      final Assignment assignment = this._ismlModelNavigation.<MethodStatement, Assignment>cast(action2.getBody().get(1), Assignment.class);
      final NamedElement assignedVar = this._ismlModelNavigation.<Expression, Reference>cast(assignment.getLeft(), Reference.class).getReferencedElement();
      Assert.assertSame(v, assignedVar);
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
      _builder.newLine();
      _builder.append("controller Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action2() {");
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
      _builder.append("y = \"a\";");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("x = \"bggg\";");
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
      final InformationSystem is = this._parseHelper.parse(_builder, this.rs);
      this._validationTestHelper.assertNoErrors(is);
      final Action action2 = this._ismlModelNavigation.<Action, Action>cast(IterableExtensions.<Action>head(this._ismlModelNavigation.<NamedElement, Controller>cast(IterableExtensions.<NamedElement>head(this._ismlModelNavigation.getComponents(this._ismlModelNavigation.<NamedElement, co.edu.javeriana.isml.isml.Package>cast(IterableExtensions.<NamedElement>head(this._ismlModelNavigation.getComponents(is)), co.edu.javeriana.isml.isml.Package.class))), Controller.class).getBody()), Action.class);
      final Variable x = this._ismlModelNavigation.<MethodStatement, Variable>cast(IterableExtensions.<MethodStatement>head(action2.getBody()), Variable.class);
      final Variable y = this._ismlModelNavigation.<MethodStatement, Variable>cast(IterableExtensions.<MethodStatement>head(this._ismlModelNavigation.<MethodStatement, If>cast(action2.getBody().get(1), If.class).getBody()), Variable.class);
      final Assignment xAssignment = this._ismlModelNavigation.<MethodStatement, Assignment>cast(IterableExtensions.<MethodStatement>head(this._ismlModelNavigation.<MethodStatement, If>cast(action2.getBody().get(1), If.class).getElseBody()), Assignment.class);
      final Assignment yAssignment = this._ismlModelNavigation.<MethodStatement, Assignment>cast(this._ismlModelNavigation.<MethodStatement, If>cast(action2.getBody().get(1), If.class).getBody().get(1), Assignment.class);
      Assert.assertSame(x, this._ismlModelNavigation.<Expression, Reference>cast(xAssignment.getLeft(), Reference.class).getReferencedElement());
      Assert.assertSame(y, this._ismlModelNavigation.<Expression, Reference>cast(yAssignment.getLeft(), Reference.class).getReferencedElement());
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
      _builder.newLine();
      _builder.append("controller Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action2() {");
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
      final InformationSystem is = this._parseHelper.parse(_builder, this.rs);
      this._validationTestHelper.assertNoErrors(is);
      final Action action2 = this._ismlModelNavigation.<Action, Action>cast(IterableExtensions.<Action>head(this._ismlModelNavigation.<NamedElement, Controller>cast(IterableExtensions.<NamedElement>head(this._ismlModelNavigation.getComponents(this._ismlModelNavigation.<NamedElement, co.edu.javeriana.isml.isml.Package>cast(IterableExtensions.<NamedElement>head(this._ismlModelNavigation.getComponents(is)), co.edu.javeriana.isml.isml.Package.class))), Controller.class).getBody()), Action.class);
      final Variable x = this._ismlModelNavigation.<MethodStatement, Variable>cast(IterableExtensions.<MethodStatement>head(this._ismlModelNavigation.<MethodStatement, If>cast(IterableExtensions.<MethodStatement>head(action2.getBody()), If.class).getBody()), Variable.class);
      final Variable x2 = this._ismlModelNavigation.<MethodStatement, Variable>cast(IterableExtensions.<MethodStatement>head(this._ismlModelNavigation.<MethodStatement, If>cast(IterableExtensions.<MethodStatement>head(action2.getBody()), If.class).getElseBody()), Variable.class);
      final Assignment xAssignment = this._ismlModelNavigation.<MethodStatement, Assignment>cast(this._ismlModelNavigation.<MethodStatement, If>cast(IterableExtensions.<MethodStatement>head(action2.getBody()), If.class).getBody().get(1), Assignment.class);
      final Assignment x2Assignment = this._ismlModelNavigation.<MethodStatement, Assignment>cast(this._ismlModelNavigation.<MethodStatement, If>cast(IterableExtensions.<MethodStatement>head(action2.getBody()), If.class).getElseBody().get(1), Assignment.class);
      Assert.assertSame(x, this._ismlModelNavigation.<Expression, Reference>cast(xAssignment.getLeft(), Reference.class).getReferencedElement());
      Assert.assertSame(x2, this._ismlModelNavigation.<Expression, Reference>cast(x2Assignment.getLeft(), Reference.class).getReferencedElement());
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
      _builder.newLine();
      _builder.append("controller Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action2() {");
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
      final InformationSystem is = this._parseHelper.parse(_builder, this.rs);
      this._testHelper.assertErrors(is);
      this._testHelper.assertNoSyntaxErrors(is);
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
      _builder.append("controller Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action2() {");
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
      _builder.append("controller Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action2() {");
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
      _builder.newLine();
      _builder.append("controller Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action(String a, String b) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("-> action2(a);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("-> action(a,b);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("-> action2(b);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("-> action(b,a);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action2(String c) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final InformationSystem is = this._parseHelper.parse(_builder, this.rs);
      this._validationTestHelper.assertNoErrors(is);
      final Action action = this._ismlModelNavigation.<Action, Action>cast(IterableExtensions.<Action>head(this._ismlModelNavigation.<NamedElement, Controller>cast(IterableExtensions.<NamedElement>head(this._ismlModelNavigation.getComponents(this._ismlModelNavigation.<NamedElement, co.edu.javeriana.isml.isml.Package>cast(IterableExtensions.<NamedElement>head(this._ismlModelNavigation.getComponents(is)), co.edu.javeriana.isml.isml.Package.class))), Controller.class).getBody()), Action.class);
      final Action action2 = this._ismlModelNavigation.<Action, Action>cast(this._ismlModelNavigation.<NamedElement, Controller>cast(IterableExtensions.<NamedElement>head(this._ismlModelNavigation.getComponents(this._ismlModelNavigation.<NamedElement, co.edu.javeriana.isml.isml.Package>cast(IterableExtensions.<NamedElement>head(this._ismlModelNavigation.getComponents(is)), co.edu.javeriana.isml.isml.Package.class))), Controller.class).getBody().get(1), Action.class);
      final ActionCall action2Call1 = this._ismlModelNavigation.<MethodStatement, ActionCall>cast(IterableExtensions.<MethodStatement>head(action.getBody()), ActionCall.class);
      final ActionCall action1Call1 = this._ismlModelNavigation.<MethodStatement, ActionCall>cast(action.getBody().get(1), ActionCall.class);
      final ActionCall action2Call2 = this._ismlModelNavigation.<MethodStatement, ActionCall>cast(action.getBody().get(2), ActionCall.class);
      final ActionCall action1Call2 = this._ismlModelNavigation.<MethodStatement, ActionCall>cast(action.getBody().get(3), ActionCall.class);
      Assert.assertSame(action, action1Call1.getReferencedElement());
      Assert.assertSame(action, action1Call2.getReferencedElement());
      Assert.assertSame(action2, action2Call1.getReferencedElement());
      Assert.assertSame(action2, action2Call2.getReferencedElement());
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
      _builder.newLine();
      _builder.append("controller Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action(String a, String b) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("a = \"aa\";");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action2(String c) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final InformationSystem is = this._parseHelper.parse(_builder, this.rs);
      this._validationTestHelper.assertNoErrors(is);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void otherControllerActionCall() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action(String a, String b) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("-> Test2.action3();");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action2(String c) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Test2 {");
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
      final InformationSystem is = this._parseHelper.parse(_builder, this.rs);
      this._validationTestHelper.assertNoErrors(is);
      final Action action = this._ismlModelNavigation.<Action, Action>cast(IterableExtensions.<Action>head(this._ismlModelNavigation.<NamedElement, Controller>cast(IterableExtensions.<NamedElement>head(this._ismlModelNavigation.getComponents(this._ismlModelNavigation.<NamedElement, co.edu.javeriana.isml.isml.Package>cast(IterableExtensions.<NamedElement>head(this._ismlModelNavigation.getComponents(is)), co.edu.javeriana.isml.isml.Package.class))), Controller.class).getBody()), Action.class);
      final Action action3 = this._ismlModelNavigation.<Action, Action>cast(IterableExtensions.<Action>head(this._ismlModelNavigation.<NamedElement, Controller>cast(this._ismlModelNavigation.getComponents(this._ismlModelNavigation.<NamedElement, co.edu.javeriana.isml.isml.Package>cast(IterableExtensions.<NamedElement>head(this._ismlModelNavigation.getComponents(is)), co.edu.javeriana.isml.isml.Package.class)).get(1), Controller.class).getBody()), Action.class);
      final ActionCall action3Call = this._ismlModelNavigation.<MethodStatement, ActionCall>cast(IterableExtensions.<MethodStatement>head(action.getBody()), ActionCall.class);
      Assert.assertSame(action3, action3Call.getReferencedElement());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void otherControllerActionCallMultipleResources() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action(String a, String b) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("-> Test2.action3();");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action2(String c) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      final InformationSystem is = this._parseHelper.parse(_builder, this.rs);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package test;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("controller Test2 {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("action3() {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      final InformationSystem is2 = this._parseHelper.parse(_builder_1, this.rs);
      final Consumer<Resource> _function = (Resource r) -> {
        this._validationTestHelper.assertNoErrors(r.getContents().get(0));
      };
      this.rs.getResources().forEach(_function);
      final Action action = this._ismlModelNavigation.<Action, Action>cast(IterableExtensions.<Action>head(this._ismlModelNavigation.<NamedElement, Controller>cast(IterableExtensions.<NamedElement>head(this._ismlModelNavigation.getComponents(this._ismlModelNavigation.<NamedElement, co.edu.javeriana.isml.isml.Package>cast(IterableExtensions.<NamedElement>head(this._ismlModelNavigation.getComponents(is)), co.edu.javeriana.isml.isml.Package.class))), Controller.class).getBody()), Action.class);
      final Action action3 = this._ismlModelNavigation.<Action, Action>cast(IterableExtensions.<Action>head(this._ismlModelNavigation.<NamedElement, Controller>cast(IterableExtensions.<NamedElement>head(this._ismlModelNavigation.getComponents(this._ismlModelNavigation.<NamedElement, co.edu.javeriana.isml.isml.Package>cast(IterableExtensions.<NamedElement>head(this._ismlModelNavigation.getComponents(is2)), co.edu.javeriana.isml.isml.Package.class))), Controller.class).getBody()), Action.class);
      final ActionCall action3Call = this._ismlModelNavigation.<MethodStatement, ActionCall>cast(IterableExtensions.<MethodStatement>head(action.getBody()), ActionCall.class);
      Assert.assertSame(action3, action3Call.getReferencedElement());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void nullParameterCall() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("-> action2(null);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action2(String c) {");
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
      final InformationSystem is = this._parseHelper.parse(_builder, this.rs);
      this._validationTestHelper.assertNoErrors(is);
      final Action action = this._ismlModelNavigation.<Action, Action>cast(IterableExtensions.<Action>head(this._ismlModelNavigation.<NamedElement, Controller>cast(IterableExtensions.<NamedElement>head(this._ismlModelNavigation.getComponents(this._ismlModelNavigation.<NamedElement, co.edu.javeriana.isml.isml.Package>cast(IterableExtensions.<NamedElement>head(this._ismlModelNavigation.getComponents(is)), co.edu.javeriana.isml.isml.Package.class))), Controller.class).getBody()), Action.class);
      final Action action2 = this._ismlModelNavigation.<Action, Action>cast(this._ismlModelNavigation.<NamedElement, Controller>cast(IterableExtensions.<NamedElement>head(this._ismlModelNavigation.getComponents(this._ismlModelNavigation.<NamedElement, co.edu.javeriana.isml.isml.Package>cast(IterableExtensions.<NamedElement>head(this._ismlModelNavigation.getComponents(is)), co.edu.javeriana.isml.isml.Package.class))), Controller.class).getBody().get(1), Action.class);
      final ActionCall action2Call = this._ismlModelNavigation.<MethodStatement, ActionCall>cast(IterableExtensions.<MethodStatement>head(action.getBody()), ActionCall.class);
      Assert.assertSame(action2, action2Call.getReferencedElement());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void callWithinCall() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("-> action();");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action2(String c) {");
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
      final InformationSystem is = this._parseHelper.parse(_builder, this.rs);
      this._validationTestHelper.assertNoErrors(is);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
