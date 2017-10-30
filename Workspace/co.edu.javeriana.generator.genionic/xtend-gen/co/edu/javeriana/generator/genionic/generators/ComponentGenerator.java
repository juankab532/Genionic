package co.edu.javeriana.generator.genionic.generators;

import co.edu.javeriana.generator.genionic.GenionicGenerator;
import co.edu.javeriana.generator.genionic.templates.ComponentTemplate;
import co.edu.javeriana.isml.generator.common.SimpleGenerator;
import co.edu.javeriana.isml.generator.common.SimpleTemplate;
import co.edu.javeriana.isml.isml.Controller;
import java.util.List;

@SuppressWarnings("all")
public class ComponentGenerator extends SimpleGenerator<List<Controller>> {
  @Override
  public String getOutputConfigurationName() {
    return GenionicGenerator.COMPONENT;
  }
  
  @Override
  protected String getFileName(final List<Controller> e) {
    return "app.component.ts";
  }
  
  @Override
  public SimpleTemplate<List<Controller>> getTemplate() {
    return new ComponentTemplate();
  }
}
