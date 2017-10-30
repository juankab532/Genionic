package co.edu.javeriana.generator.genionic;

import co.edu.javeriana.generator.genionic.generators.ComponentGenerator;
import co.edu.javeriana.generator.genionic.generators.Conf1Generator;
import co.edu.javeriana.generator.genionic.generators.ControllerGenerator;
import co.edu.javeriana.generator.genionic.generators.CssGenerator;
import co.edu.javeriana.generator.genionic.generators.ModelGenerator;
import co.edu.javeriana.generator.genionic.generators.ModuleGenerator;
import co.edu.javeriana.generator.genionic.generators.PageGenerator;
import co.edu.javeriana.isml.generator.common.GeneratorSuite;
import co.edu.javeriana.isml.generator.common.OutputConfiguration;
import co.edu.javeriana.isml.generator.common.SimpleGenerator;
import java.util.Collections;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class GenionicGenerator extends GeneratorSuite {
  @OutputConfiguration
  public final static String VIEWS = "frontend.views";
  
  @OutputConfiguration
  public final static String CONTROLLERS = "frontend.controllers";
  
  @OutputConfiguration
  public final static String CONF1 = "frontend.conf1";
  
  @OutputConfiguration
  public final static String COMPONENT = "frontend.component";
  
  @OutputConfiguration
  public final static String CSS = "frontend.css";
  
  @OutputConfiguration
  public final static String MODULES = "frontend.module";
  
  @OutputConfiguration
  public final static String MODEL = "frontend.model";
  
  @Override
  public Set<? extends SimpleGenerator<?>> getGenerators() {
    PageGenerator _pageGenerator = new PageGenerator();
    ControllerGenerator _controllerGenerator = new ControllerGenerator();
    CssGenerator _cssGenerator = new CssGenerator();
    ModuleGenerator _moduleGenerator = new ModuleGenerator();
    ModelGenerator _modelGenerator = new ModelGenerator();
    Conf1Generator _conf1Generator = new Conf1Generator();
    ComponentGenerator _componentGenerator = new ComponentGenerator();
    return Collections.<SimpleGenerator<?>>unmodifiableSet(CollectionLiterals.<SimpleGenerator<?>>newHashSet(_pageGenerator, _controllerGenerator, _cssGenerator, _moduleGenerator, _modelGenerator, _conf1Generator, _componentGenerator));
  }
}
