package co.edu.javeriana.generator.genionic.templates;

import co.edu.javeriana.isml.generator.common.SimpleTemplate;
import co.edu.javeriana.isml.isml.Page;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class CssTemplate extends SimpleTemplate<Page> {
  @Override
  protected CharSequence template(final Page c) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("page-");
    String _lowerCase = c.getName().toLowerCase();
    _builder.append(_lowerCase);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  @Override
  public void preprocess(final Page e) {
  }
}
