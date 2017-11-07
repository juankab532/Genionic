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
public class DTOTest extends CommonTests {
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
  public void accessDTOAttrs() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Cont {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("dto MyDTO {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String name;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Integer num;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("page Test(MyDTO myDto) controlledBy Cont {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Button(myDto.name, true);");
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
  public void accessDTOAttrs2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("dto MyDTO {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String name;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Integer num;");
      _builder.newLine();
      _builder.append("}\t\t\t");
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Cont {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action(MyDTO adto) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("String n = adto.name;");
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
  
  @Test
  public void accessDTOAttrs3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("controller Cont {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("action(MyDTO adto) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("String n = adto.name;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("dto MyDTO {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String name;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Integer num;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final InformationSystem is = this._parseHelper.parse(_builder, this.rs);
      this._validationTestHelper.assertNoErrors(is);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
