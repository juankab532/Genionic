package co.edu.javeriana.generator.configuration;

import co.edu.javeriana.generator.configuration.GeneratorSuiteConfiguration;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class GeneratorSuitesConfiguration {
  private final List<GeneratorSuiteConfiguration> generatorSuiteConfigurations = new ArrayList<GeneratorSuiteConfiguration>();
  
  public List<GeneratorSuiteConfiguration> getGeneratorSuiteConfigurations() {
    return this.generatorSuiteConfigurations;
  }
}
