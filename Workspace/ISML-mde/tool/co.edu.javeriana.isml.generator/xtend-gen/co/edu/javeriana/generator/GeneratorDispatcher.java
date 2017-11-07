package co.edu.javeriana.generator;

import co.edu.javeriana.generator.IMultiModelGenerator;
import co.edu.javeriana.generator.configuration.ConfigurationPersistence;
import co.edu.javeriana.generator.configuration.GeneratorSuiteConfiguration;
import co.edu.javeriana.generator.configuration.GeneratorSuitesConfiguration;
import co.edu.javeriana.isml.generator.common.IGeneratorSuite;
import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;

@SuppressWarnings("all")
public class GeneratorDispatcher implements IGenerator, IMultiModelGenerator {
  @Override
  public void doGenerate(final Resource input, final IFileSystemAccess fsa) {
    final GeneratorSuitesConfiguration configurations = ConfigurationPersistence.loadGeneratorConfiguration(input);
    boolean _notEquals = (!Objects.equal(configurations, null));
    if (_notEquals) {
      System.err.println("***** GENERATOR RUNNING ******");
      List<GeneratorSuiteConfiguration> _generatorSuiteConfigurations = configurations.getGeneratorSuiteConfigurations();
      for (final GeneratorSuiteConfiguration config : _generatorSuiteConfigurations) {
        boolean _isOnDemand = config.isOnDemand();
        boolean _not = (!_isOnDemand);
        if (_not) {
          final IGeneratorSuite generatorSuite = ConfigurationPersistence.loadGeneratorSuite(config);
          boolean _equals = Objects.equal(generatorSuite, null);
          if (_equals) {
            String _generatorClass = config.getGeneratorClass();
            String _plus = ("Could not load generator " + _generatorClass);
            System.err.println(_plus);
          } else {
            String _generatorClass_1 = config.getGeneratorClass();
            String _plus_1 = ("Using " + _generatorClass_1);
            String _plus_2 = (_plus_1 + " to generate from ");
            URI _uRI = input.getURI();
            String _plus_3 = (_plus_2 + _uRI);
            System.err.println(_plus_3);
            generatorSuite.doGenerate(input, fsa);
          }
        }
      }
    } else {
      URI _uRI_1 = input.getURI();
      String _plus_4 = ("No generator configuration file found for " + _uRI_1);
      System.err.println(_plus_4);
    }
  }
  
  @Override
  public void doGenerate(final ResourceSet input, final IFileSystemAccess fsa) {
    boolean _isEmpty = input.getResources().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final GeneratorSuitesConfiguration configurations = ConfigurationPersistence.loadGeneratorConfiguration(input.getResources().get(0));
      boolean _notEquals = (!Objects.equal(configurations, null));
      if (_notEquals) {
        System.err.println("***** MULTIGENERATOR RUNNING ******");
        List<GeneratorSuiteConfiguration> _generatorSuiteConfigurations = configurations.getGeneratorSuiteConfigurations();
        for (final GeneratorSuiteConfiguration config : _generatorSuiteConfigurations) {
          boolean _isOnDemand = config.isOnDemand();
          boolean _not_1 = (!_isOnDemand);
          if (_not_1) {
            final IGeneratorSuite generatorSuite = ConfigurationPersistence.loadGeneratorSuite(config);
            boolean _equals = Objects.equal(generatorSuite, null);
            if (_equals) {
              String _generatorClass = config.getGeneratorClass();
              String _plus = ("Could not load generator " + _generatorClass);
              System.err.println(_plus);
            } else {
              String _generatorClass_1 = config.getGeneratorClass();
              String _plus_1 = ("Using " + _generatorClass_1);
              String _plus_2 = (_plus_1 + " to generate from all input files");
              System.err.println(_plus_2);
              generatorSuite.doGenerate(input, fsa);
            }
          }
        }
      } else {
        URI _uRI = input.getResources().get(0).getURI();
        String _plus_3 = ("No generator configuration file found for " + _uRI);
        System.err.println(_plus_3);
      }
    }
  }
}
