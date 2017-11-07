package co.edu.javeriana.generator.configuration;

import java.lang.reflect.Field;
import java.util.List;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class GeneratorSuiteConfiguration {
  public static class __OutputConfiguration extends OutputConfiguration {
    /**
     * Default constructor. It is necessary to ensure Gson deserialization
     * properly initializes all of the OutputConfiguration fields
     */
    public __OutputConfiguration() {
      super("");
    }
    
    public __OutputConfiguration(final String name) {
      super(name);
    }
    
    public void setName(final String name) {
      try {
        final Field nameField = this.getClass().getSuperclass().getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(this, name);
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
  }
  
  private String generatorClass;
  
  private boolean active;
  
  private boolean onDemand = false;
  
  private List<GeneratorSuiteConfiguration.__OutputConfiguration> outputConfigurations;
  
  public String getGeneratorClass() {
    return this.generatorClass;
  }
  
  public boolean isActive() {
    return this.active;
  }
  
  public boolean isOnDemand() {
    return this.onDemand;
  }
  
  public List<GeneratorSuiteConfiguration.__OutputConfiguration> getOutputConfigurations() {
    return this.outputConfigurations;
  }
}
