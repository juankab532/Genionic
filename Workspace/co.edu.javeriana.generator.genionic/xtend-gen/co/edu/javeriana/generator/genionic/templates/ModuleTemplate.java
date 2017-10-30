package co.edu.javeriana.generator.genionic.templates;

import co.edu.javeriana.isml.generator.common.SimpleTemplate;
import co.edu.javeriana.isml.isml.Controller;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ModuleTemplate extends SimpleTemplate<Controller> {
  @Override
  protected CharSequence template(final Controller c) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import { NgModule } from \'@angular/core\';");
    _builder.newLine();
    _builder.append("import { IonicPageModule } from \'ionic-angular\';");
    _builder.newLine();
    _builder.append("import { ");
    String _firstUpper = StringExtensions.toFirstUpper(c.getName().toLowerCase());
    _builder.append(_firstUpper);
    _builder.append("Page } from \'./");
    String _lowerCase = c.getName().toLowerCase();
    _builder.append(_lowerCase);
    _builder.append("\';");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("@NgModule({");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("declarations: [");
    _builder.newLine();
    _builder.append("    ");
    String _firstUpper_1 = StringExtensions.toFirstUpper(c.getName().toLowerCase());
    _builder.append(_firstUpper_1, "    ");
    _builder.append("Page,");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("],");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("imports: [");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("IonicPageModule.forChild(");
    String _firstUpper_2 = StringExtensions.toFirstUpper(c.getName().toLowerCase());
    _builder.append(_firstUpper_2, "    ");
    _builder.append("Page),");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("],");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("exports: [");
    _builder.newLine();
    _builder.append("    ");
    String _firstUpper_3 = StringExtensions.toFirstUpper(c.getName().toLowerCase());
    _builder.append(_firstUpper_3, "    ");
    _builder.append("Page");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("]");
    _builder.newLine();
    _builder.append("})");
    _builder.newLine();
    _builder.append("export class ");
    String _firstUpper_4 = StringExtensions.toFirstUpper(c.getName().toLowerCase());
    _builder.append(_firstUpper_4);
    _builder.append("PageModule {}");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  @Override
  public void preprocess(final Controller c) {
  }
}
