package co.edu.javeriana.isml.tests;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.junit.Assert;

@SuppressWarnings("all")
public class TestHelper {
  public static class Element {
    public Class<?> type = Object.class;
    
    public List<Pair<String, Object>> attributes = new ArrayList<Pair<String, Object>>();
    
    public Element(final Class<?> type, final List<Pair<String, Object>> attributes) {
      this.type = type;
      this.attributes = attributes;
      this.validateAttributes();
    }
    
    private void validateAttributes() {
      for (final Pair<String, Object> attr : this.attributes) {
        try {
          String _firstUpper = StringExtensions.toFirstUpper(attr.getKey());
          String _plus = ("get" + _firstUpper);
          this.type.getMethod(_plus);
        } catch (final Throwable _t) {
          if (_t instanceof NoSuchMethodException) {
            final NoSuchMethodException e = (NoSuchMethodException)_t;
            String _name = this.type.getName();
            String _plus_1 = ("Class " + _name);
            String _plus_2 = (_plus_1 + " does not have attribute ");
            String _key = attr.getKey();
            String _plus_3 = (_plus_2 + _key);
            Assert.fail(_plus_3);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    }
  }
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  public void assertErrors(final EObject obj) {
    boolean _isEmpty = this._validationTestHelper.validate(obj).isEmpty();
    boolean _not = (!_isEmpty);
    Assert.assertTrue("Errors were expected in the test code, but there are none", _not);
  }
  
  public void assertNoSyntaxErrors(final EObject obj) {
    final List<Issue> errors = this._validationTestHelper.validate(obj);
    final Function1<Issue, Boolean> _function = (Issue x) -> {
      return Boolean.valueOf(x.isSyntaxError());
    };
    final Iterable<Issue> syntaxErrors = IterableExtensions.<Issue>filter(errors, _function);
    int _size = IterableExtensions.size(syntaxErrors);
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      Assert.fail(("Found syntax errors: " + syntaxErrors));
    }
  }
  
  public <T extends EObject, R extends Object> Iterable<T> assertArrayEquals(final Iterable<T> real, final Iterable<R> expected, final Function1<T, R> transformation) {
    Assert.assertArrayEquals(((Object[])Conversions.unwrapArray(expected, Object.class)), ((Object[])Conversions.unwrapArray(IterableExtensions.<T, R>map(real, transformation), Object.class)));
    return real;
  }
  
  public TestHelper.Element operator_mappedTo(final Class<?> type, final List<Pair<String, Object>> attributes) {
    return new TestHelper.Element(type, attributes);
  }
  
  public void assertEqualsElement(final EObject obj, final TestHelper.Element e) {
    String _name = e.type.getName();
    String _plus = ("Type " + _name);
    String _plus_1 = (_plus + " is not congruent with ");
    String _simpleName = obj.getClass().getSimpleName();
    String _plus_2 = (_plus_1 + _simpleName);
    Assert.assertTrue(_plus_2, e.type.isAssignableFrom(obj.getClass()));
    for (final Pair<String, Object> attr : e.attributes) {
      {
        final EStructuralFeature feature = obj.eClass().getEStructuralFeature(attr.getKey());
        final Object value = obj.eGet(feature);
        boolean _matched = false;
        if (feature instanceof EAttribute) {
          _matched=true;
          String _name_1 = obj.eClass().getName();
          String _plus_3 = ("Feature " + _name_1);
          String _plus_4 = (_plus_3 + ".");
          String _name_2 = ((EAttribute)feature).getName();
          String _plus_5 = (_plus_4 + _name_2);
          String _plus_6 = (_plus_5 + " is not equal to ");
          Object _value = attr.getValue();
          String _plus_7 = (_plus_6 + _value);
          Assert.assertEquals(_plus_7, value, attr.getValue());
        }
        if (!_matched) {
          if (feature instanceof EReference) {
            _matched=true;
            int _upperBound = ((EReference)feature).getUpperBound();
            boolean _equals = (_upperBound == 1);
            if (_equals) {
              Object _value = attr.getValue();
              this.assertEqualsElement(((EObject) value), ((TestHelper.Element) _value));
            } else {
              int _upperBound_1 = ((EReference)feature).getUpperBound();
              boolean _equals_1 = (_upperBound_1 == (-1));
              if (_equals_1) {
                final List<EObject> list = ((List<EObject>) value);
                try {
                  Object _value_1 = attr.getValue();
                  final List<TestHelper.Element> elemList = ((List<TestHelper.Element>) _value_1);
                  final Procedure2<TestHelper.Element, Integer> _function = (TestHelper.Element child, Integer i) -> {
                    this.assertEqualsElement(list.get((i).intValue()), child);
                  };
                  IterableExtensions.<TestHelper.Element>forEach(elemList, _function);
                } catch (final Throwable _t) {
                  if (_t instanceof ClassCastException) {
                    final ClassCastException ex = (ClassCastException)_t;
                    String _name_1 = obj.eClass().getName();
                    String _plus_3 = ("Feature " + _name_1);
                    String _plus_4 = (_plus_3 + ".");
                    String _name_2 = ((EReference)feature).getName();
                    String _plus_5 = (_plus_4 + _name_2);
                    String _plus_6 = (_plus_5 + " is a list, but is being compared against a single element");
                    Assert.fail(_plus_6);
                  } else {
                    throw Exceptions.sneakyThrow(_t);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}
