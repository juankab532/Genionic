package co.edu.javeriana.isml.generator.simple;

import co.edu.javeriana.isml.generator.common.GeneratorSuite;
import co.edu.javeriana.isml.generator.common.OutputConfiguration;
import co.edu.javeriana.isml.generator.common.SimpleGenerator;
import co.edu.javeriana.isml.generator.simple.generators.EntityGenerator;
import java.util.Collections;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * Generates code from your model files on save.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#TutorialCodeGeneration
 */
@SuppressWarnings("all")
public class SimpleGeneratorSuite extends GeneratorSuite {
  @OutputConfiguration
  public final static String SIMPLE_OUTPUT = "SIMPLE_OUTPUT";
  
  @Override
  public Set<? extends SimpleGenerator<?>> getGenerators() {
    EntityGenerator _entityGenerator = new EntityGenerator();
    return Collections.<SimpleGenerator<?>>unmodifiableSet(CollectionLiterals.<SimpleGenerator<?>>newHashSet(_entityGenerator));
  }
}
