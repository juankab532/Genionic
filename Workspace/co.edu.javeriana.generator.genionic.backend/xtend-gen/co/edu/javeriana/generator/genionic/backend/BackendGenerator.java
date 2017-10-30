package co.edu.javeriana.generator.genionic.backend;

import co.edu.javeriana.generator.genionic.backend.generators.EntityGenerator;
import co.edu.javeriana.generator.genionic.backend.generators.ServiceGenerator;
import co.edu.javeriana.generator.genionic.backend.generators.ServiceInterfaceGenerator;
import co.edu.javeriana.isml.generator.common.GeneratorSuite;
import co.edu.javeriana.isml.generator.common.OutputConfiguration;
import co.edu.javeriana.isml.generator.common.SimpleGenerator;
import java.util.Collections;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class BackendGenerator extends GeneratorSuite {
  @OutputConfiguration
  public final static String ENTITIES = "entities";
  
  @OutputConfiguration
  public final static String SERVICE_IMPL = "service";
  
  @OutputConfiguration
  public final static String SERVICE_INTERFACE = "service.interface";
  
  @Override
  public Set<? extends SimpleGenerator<?>> getGenerators() {
    EntityGenerator _entityGenerator = new EntityGenerator();
    ServiceInterfaceGenerator _serviceInterfaceGenerator = new ServiceInterfaceGenerator();
    ServiceGenerator _serviceGenerator = new ServiceGenerator();
    return Collections.<SimpleGenerator<?>>unmodifiableSet(CollectionLiterals.<SimpleGenerator<?>>newHashSet(_entityGenerator, _serviceInterfaceGenerator, _serviceGenerator));
  }
}
