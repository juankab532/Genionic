package co.edu.javeriana.isml.generator.simple.tests;

import co.edu.javeriana.isml.IsmlInjectorProvider;
import co.edu.javeriana.isml.generator.simple.templates.EntityTemplate;
import co.edu.javeriana.isml.generator.test.TestGeneratorHelper;
import co.edu.javeriana.isml.isml.Entity;
import co.edu.javeriana.isml.isml.InformationSystem;
import co.edu.javeriana.isml.isml.NamedElement;
import co.edu.javeriana.isml.scoping.IsmlModelNavigation;
import co.edu.javeriana.isml.tests.CommonTests;
import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(IsmlInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class EntityGeneratorTest extends CommonTests {
  @Inject
  @Extension
  private ParseHelper<InformationSystem> _parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Inject
  @Extension
  private TestGeneratorHelper _testGeneratorHelper;
  
  @Inject
  @Extension
  private IsmlModelNavigation _ismlModelNavigation;
  
  @Inject
  private EntityTemplate template;
  
  @Test
  public void entityGeneration() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.append("entity Person extends Animal, Sentient {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String name must be Size(1,10);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Integer age;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("entity Animal {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("entity Sentient {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final InformationSystem informationSystem = this._parseHelper.parse(_builder, this.rs);
      this._validationTestHelper.assertNoErrors(informationSystem);
      NamedElement _head = IterableExtensions.<NamedElement>head(informationSystem.getBody());
      final co.edu.javeriana.isml.isml.Package pkg = ((co.edu.javeriana.isml.isml.Package) _head);
      NamedElement _head_1 = IterableExtensions.<NamedElement>head(pkg.getBody());
      final Entity entity = ((Entity) _head_1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Entity {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("name = Person");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("extends = [Animal, Sentient]");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("body = {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("Attribute {");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("name = name");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("type = String");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("constraints = [Size]");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("Attribute {");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("name = age");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("type = Integer");
      _builder_1.newLine();
      _builder_1.append("\t\t\t");
      _builder_1.append("constraints = [];");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this._testGeneratorHelper.<Entity>assertGenerates(this.template, entity, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
