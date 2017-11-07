package templateGenerator;

import com.google.common.base.Objects;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class TemplateGenerator {
  private PrintWriter mainWriter;
  
  private Set<String> rootClasses;
  
  private String basePackage;
  
  private String metamodelBasePackage;
  
  public static void main(final String[] args) {
    new TemplateGenerator().generate(
      "/home/jpavlich/git/ISML-MDE/tool/co.edu.javeriana.isml/model/Isml.ecore", 
      "co.edu.javeriana.isml.generator.sample", 
      "co.edu.javeriana.isml.generator", 
      "Entity", 
      "Controller", 
      "Page", 
      "Service", 
      "Resource", 
      "DTO");
  }
  
  public Object registerFactories() {
    Map<String, Object> _extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
    EcoreResourceFactoryImpl _ecoreResourceFactoryImpl = new EcoreResourceFactoryImpl();
    return _extensionToFactoryMap.put("ecore", _ecoreResourceFactoryImpl);
  }
  
  public void generate(final String modelURI, final String basePackage, final String metamodelBasePackage, final String... rootClasses) {
    try {
      this.registerFactories();
      PrintWriter _printWriter = new PrintWriter("templates/common.xtend", "UTF-8");
      this.mainWriter = _printWriter;
      this.mainWriter.println(this.commonTemplateHeader());
      HashSet<String> _hashSet = new HashSet<String>();
      this.rootClasses = _hashSet;
      CollectionExtensions.<String>addAll(this.rootClasses, rootClasses);
      this.basePackage = basePackage;
      this.metamodelBasePackage = metamodelBasePackage;
      final ResourceSetImpl rs = new ResourceSetImpl();
      final Resource resource = rs.getResource(URI.createURI(modelURI), true);
      Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(resource.getAllContents());
      for (final EObject obj : _iterable) {
        this.process(obj);
      }
      this.mainWriter.println(this.commonTemplateFooter());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public CharSequence template(final EClass c) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(this.basePackage);
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(this.metamodelBasePackage);
    _builder.append(".*");
    _builder.newLineIfNotEmpty();
    _builder.append("import com.google.inject.Inject");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.naming.IQualifiedNameProvider");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _name = c.getName();
    _builder.append(_name);
    _builder.append("Template extends SimpleTemplate<");
    String _name_1 = c.getName();
    _builder.append(_name_1);
    _builder.append("> {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("@Inject extension IQualifiedNameProvider");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override preprocess(");
    String _name_2 = c.getName();
    _builder.append(_name_2, "\t");
    _builder.append(" ");
    String _firstLower = StringExtensions.toFirstLower(c.getName());
    _builder.append(_firstLower, "\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override CharSequence template(");
    String _name_3 = c.getName();
    _builder.append(_name_3, "\t");
    _builder.append(" obj) ");
    _builder.append("\'\'\'", "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    String _name_4 = c.getName();
    _builder.append(_name_4, "\t\t");
    _builder.append(": ");
    _builder.append("«", "\t\t");
    String _firstLower_1 = StringExtensions.toFirstLower(c.getName());
    _builder.append(_firstLower_1, "\t\t");
    _builder.append(".name");
    _builder.append("«", "\t\t");
    _builder.newLineIfNotEmpty();
    {
      EList<EStructuralFeature> _eAllStructuralFeatures = c.getEAllStructuralFeatures();
      for(final EStructuralFeature f : _eAllStructuralFeatures) {
        _builder.append("\t\t");
        CharSequence _text = this.toText(f, c);
        _builder.append(_text, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("\'\'\'", "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("} ");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence commonTemplateHeader() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(this.basePackage);
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    _builder.append(this.metamodelBasePackage);
    _builder.append(".*");
    _builder.newLineIfNotEmpty();
    _builder.append("import com.google.inject.Inject");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.naming.IQualifiedNameProvider");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class CommonTemplate ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Inject extension IQualifiedNameProvider");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence commonTemplateFooter() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public void indent(final int ind) {
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, ind, true);
    for (final Integer i : _doubleDotLessThan) {
      InputOutput.<String>print(" ");
    }
  }
  
  public void process(final EObject obj) {
    try {
      if ((obj instanceof EClass)) {
        boolean _isAbstract = ((EClass)obj).isAbstract();
        boolean _not = (!_isAbstract);
        if (_not) {
          boolean _contains = this.rootClasses.contains(((EClass)obj).getName());
          if (_contains) {
            String _name = ((EClass)obj).getName();
            String _plus = (_name + "Template.xtend");
            final PrintWriter writer = new PrintWriter(_plus, "UTF-8");
            writer.println(this.template(((EClass)obj)));
          } else {
            this.mainWriter.println(this.toText(((EClass)obj)));
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public CharSequence toText(final EClass c) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def dispatch toText(");
    String _name = c.getName();
    _builder.append(_name, "\t");
    _builder.append(" ");
    String _firstLower = StringExtensions.toFirstLower(c.getName());
    _builder.append(_firstLower, "\t");
    _builder.append(") ");
    _builder.append("\'\'\'", "\t");
    _builder.newLineIfNotEmpty();
    {
      EList<EStructuralFeature> _eAllStructuralFeatures = c.getEAllStructuralFeatures();
      for(final EStructuralFeature f : _eAllStructuralFeatures) {
        _builder.append("\t\t");
        CharSequence _text = this.toText(f, c);
        _builder.append(_text, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("\'\'\'", "\t");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _toText(final EReference r, final EClass container) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isMany = r.isMany();
      if (_isMany) {
        {
          boolean _isContainment = r.isContainment();
          if (_isContainment) {
            _builder.append("«");
            _builder.append("FOR ");
            String _iteratorName = this.getIteratorName(r.getName());
            _builder.append(_iteratorName);
            _builder.append(" : ");
            String _firstLower = StringExtensions.toFirstLower(container.getName());
            _builder.append(_firstLower);
            _builder.append(".");
            String _name = r.getName();
            _builder.append(_name);
            _builder.append("»");
            _builder.newLineIfNotEmpty();
            _builder.append("«");
            String _iteratorName_1 = this.getIteratorName(r.getName());
            _builder.append(_iteratorName_1);
            _builder.append(".toText");
            _builder.append("»");
            _builder.newLineIfNotEmpty();
            _builder.append("«");
            _builder.append("ENDFOR");
            _builder.append("»");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("«");
            _builder.append("FOR ");
            String _iteratorName_2 = this.getIteratorName(r.getName());
            _builder.append(_iteratorName_2);
            _builder.append(" : ");
            String _firstLower_1 = StringExtensions.toFirstLower(container.getName());
            _builder.append(_firstLower_1);
            _builder.append(".");
            String _name_1 = r.getName();
            _builder.append(_name_1);
            _builder.append("»");
            _builder.newLineIfNotEmpty();
            _builder.append("«");
            String _iteratorName_3 = this.getIteratorName(r.getName());
            _builder.append(_iteratorName_3);
            _builder.append(".toSimpleText");
            _builder.append("»");
            _builder.newLineIfNotEmpty();
            _builder.append("«");
            _builder.append("ENDFOR");
            _builder.append("»");
            _builder.newLineIfNotEmpty();
          }
        }
      } else {
        {
          boolean _isContainment_1 = r.isContainment();
          if (_isContainment_1) {
            _builder.append("«");
            String _firstLower_2 = StringExtensions.toFirstLower(container.getName());
            _builder.append(_firstLower_2);
            _builder.append(".");
            String _name_2 = r.getName();
            _builder.append(_name_2);
            _builder.append(".toText");
            _builder.append("»");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("«");
            String _firstLower_3 = StringExtensions.toFirstLower(container.getName());
            _builder.append(_firstLower_3);
            _builder.append(".");
            String _name_3 = r.getName();
            _builder.append(_name_3);
            _builder.append(".toSimpleText");
            _builder.append("»");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  protected CharSequence _toText(final EAttribute a, final EClass container) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = a.getName();
    _builder.append(_name);
    _builder.append(": ");
    _builder.append("«");
    String _firstLower = StringExtensions.toFirstLower(container.getName());
    _builder.append(_firstLower);
    _builder.append(".name»");
    String _name_1 = a.getName();
    _builder.append(_name_1);
    _builder.append("»");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _toText(final EObject object, final EClass container) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
  
  public String getClassifierName(final EStructuralFeature f) {
    EObject _eContainer = f.eContainer();
    final EClassifier c = ((EClassifier) _eContainer);
    return c.getName();
  }
  
  public String getIteratorName(final String s) {
    int _length = s.length();
    int _minus = (_length - 1);
    final char lastChar = s.charAt(_minus);
    if ((Objects.equal(Character.valueOf(lastChar), "s") || Objects.equal(Character.valueOf(lastChar), "S"))) {
      int _length_1 = s.length();
      int _minus_1 = (_length_1 - 1);
      return s.substring(0, _minus_1);
    } else {
      return "element";
    }
  }
  
  public CharSequence toText(final EObject a, final EClass container) {
    if (a instanceof EAttribute) {
      return _toText((EAttribute)a, container);
    } else if (a instanceof EReference) {
      return _toText((EReference)a, container);
    } else if (a != null) {
      return _toText(a, container);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(a, container).toString());
    }
  }
}
