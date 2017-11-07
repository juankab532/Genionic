package co.edu.javeriana.isml.tests;

import co.edu.javeriana.isml.IsmlInjectorProvider;
import co.edu.javeriana.isml.isml.Attribute;
import co.edu.javeriana.isml.isml.Entity;
import co.edu.javeriana.isml.isml.InformationSystem;
import co.edu.javeriana.isml.isml.NamedElement;
import co.edu.javeriana.isml.isml.Type;
import co.edu.javeriana.isml.scoping.IsmlModelNavigation;
import co.edu.javeriana.isml.tests.CommonTests;
import co.edu.javeriana.isml.tests.TestHelper;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(IsmlInjectorProvider.class)
@SuppressWarnings("all")
public class EntityTest extends CommonTests {
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
  public void entityStructure() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.append("entity Parent {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("entity Parent2;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("entity MyEntity extends Parent, Parent2 {");
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
      final InformationSystem is = this._parseHelper.parse(_builder, this.rs);
      this._validationTestHelper.assertNoErrors(is);
      final co.edu.javeriana.isml.isml.Package pkg = this._ismlModelNavigation.<NamedElement, co.edu.javeriana.isml.isml.Package>cast(IterableExtensions.<NamedElement>head(this._ismlModelNavigation.getComponents(is)), co.edu.javeriana.isml.isml.Package.class);
      Assert.assertEquals("test", pkg.getName());
      final Function1<NamedElement, String> _function = (NamedElement x) -> {
        return x.getName();
      };
      Assert.assertArrayEquals(new Object[] { "Parent", "Parent2", "MyEntity" }, ((Object[])Conversions.unwrapArray(ListExtensions.<NamedElement, String>map(this._ismlModelNavigation.getComponents(pkg), _function), Object.class)));
      final Entity entity = this._ismlModelNavigation.<NamedElement, Entity>cast(this._ismlModelNavigation.getComponents(pkg).get(2), Entity.class);
      final Function1<Attribute, String> _function_1 = (Attribute x) -> {
        return x.getName();
      };
      Assert.assertArrayEquals(new Object[] { "name", "num" }, ((Object[])Conversions.unwrapArray(IterableExtensions.<Attribute, String>map(Iterables.<Attribute>filter(entity.getBody(), Attribute.class), _function_1), Object.class)));
      final Function1<Attribute, String> _function_2 = (Attribute x) -> {
        return this._ismlModelNavigation.getTypeSpecification(x.getType()).getName();
      };
      Assert.assertArrayEquals(new Object[] { "String", "Integer" }, ((Object[])Conversions.unwrapArray(IterableExtensions.<Attribute, String>map(Iterables.<Attribute>filter(entity.getBody(), Attribute.class), _function_2), Object.class)));
      final Function1<Type, String> _function_3 = (Type x) -> {
        return this._ismlModelNavigation.getTypeSpecification(x).getName();
      };
      Assert.assertArrayEquals(new Object[] { "Parent", "Parent2" }, ((Object[])Conversions.unwrapArray(ListExtensions.<Type, String>map(entity.getSuperTypes(), _function_3), Object.class)));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
