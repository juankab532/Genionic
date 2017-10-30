package co.edu.javeriana.generator.genionic.generators;

import co.edu.javeriana.generator.genionic.GenionicGenerator;
import co.edu.javeriana.generator.genionic.templates.PageTemplate;
import co.edu.javeriana.isml.generator.common.SimpleGenerator;
import co.edu.javeriana.isml.generator.common.SimpleTemplate;
import co.edu.javeriana.isml.isml.Page;
import com.google.inject.Inject;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class PageGenerator extends SimpleGenerator<Page> {
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Override
  public String getOutputConfigurationName() {
    return GenionicGenerator.VIEWS;
  }
  
  @Override
  protected String getFileName(final Page e) {
    String _lowerCase = e.getName().toLowerCase();
    int _length = e.getName().length();
    int _minus = (_length - 1);
    CharSequence _subSequence = _lowerCase.subSequence(0, _minus);
    String _plus = (_subSequence + "/");
    String _lowerCase_1 = e.getName().toLowerCase();
    String _plus_1 = (_plus + _lowerCase_1);
    return (_plus_1 + ".html");
  }
  
  @Override
  public SimpleTemplate<Page> getTemplate() {
    return new PageTemplate();
  }
}
