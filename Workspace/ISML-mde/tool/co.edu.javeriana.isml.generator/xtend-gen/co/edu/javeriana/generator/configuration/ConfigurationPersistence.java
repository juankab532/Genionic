package co.edu.javeriana.generator.configuration;

import co.edu.javeriana.generator.configuration.GeneratorSuiteConfiguration;
import co.edu.javeriana.generator.configuration.GeneratorSuitesConfiguration;
import co.edu.javeriana.isml.generator.common.IGeneratorSuite;
import com.google.common.base.Objects;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class ConfigurationPersistence {
  private final static Gson gson = new GsonBuilder().create();
  
  private static URIConverter conv = new ExtensibleURIConverterImpl();
  
  public static GeneratorSuitesConfiguration loadGeneratorConfiguration(final IXtextBuilderParticipant.IBuildContext context) {
    try {
      final IProject project = context.getBuiltProject();
      final File propFile = project.getLocation().append("conf").append("generation.conf.json").toFile();
      FileInputStream _fileInputStream = new FileInputStream(propFile);
      final InputStreamReader reader = new InputStreamReader(_fileInputStream);
      return ConfigurationPersistence.gson.<GeneratorSuitesConfiguration>fromJson(reader, GeneratorSuitesConfiguration.class);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public static GeneratorSuitesConfiguration loadGeneratorConfiguration(final Resource resource) {
    try {
      final URI fileURI = ConfigurationPersistence.getProjectURI(resource.getURI()).appendSegment("conf").appendSegment("generation.conf.json");
      final InputStream stream = ConfigurationPersistence.conv.createInputStream(fileURI);
      final InputStreamReader reader = new InputStreamReader(stream);
      return ConfigurationPersistence.gson.<GeneratorSuitesConfiguration>fromJson(reader, GeneratorSuitesConfiguration.class);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public static HashMap<String, OutputConfiguration> loadOutputConfigurations(final IXtextBuilderParticipant.IBuildContext context) {
    return ConfigurationPersistence.loadOutputConfigurations(ConfigurationPersistence.loadGeneratorConfiguration(context));
  }
  
  public static HashMap<String, OutputConfiguration> loadOutputConfigurations(final Resource resource) {
    return ConfigurationPersistence.loadOutputConfigurations(ConfigurationPersistence.loadGeneratorConfiguration(resource));
  }
  
  private static HashMap<String, OutputConfiguration> loadOutputConfigurations(final GeneratorSuitesConfiguration configurations) {
    final HashMap<String, OutputConfiguration> processedConfigurations = new HashMap<String, OutputConfiguration>();
    boolean _notEquals = (!Objects.equal(configurations, null));
    if (_notEquals) {
      List<GeneratorSuiteConfiguration> _generatorSuiteConfigurations = configurations.getGeneratorSuiteConfigurations();
      for (final GeneratorSuiteConfiguration config : _generatorSuiteConfigurations) {
        List<GeneratorSuiteConfiguration.__OutputConfiguration> _outputConfigurations = config.getOutputConfigurations();
        for (final GeneratorSuiteConfiguration.__OutputConfiguration oc : _outputConfigurations) {
          {
            String _generatorClass = config.getGeneratorClass();
            String _plus = (_generatorClass + ".");
            String _name = oc.getName();
            String _plus_1 = (_plus + _name);
            oc.setName(_plus_1);
            processedConfigurations.put(oc.getName(), oc);
          }
        }
      }
      final OutputConfiguration defaultOutputConfiguration = new OutputConfiguration(IFileSystemAccess.DEFAULT_OUTPUT);
      defaultOutputConfiguration.setOutputDirectory("./src-gen");
      processedConfigurations.put(IFileSystemAccess.DEFAULT_OUTPUT, defaultOutputConfiguration);
    }
    return processedConfigurations;
  }
  
  public static IGeneratorSuite loadGeneratorSuite(final Resource input, final Class<? extends IGeneratorSuite> generatorSuiteClass) {
    final GeneratorSuitesConfiguration configurations = ConfigurationPersistence.loadGeneratorConfiguration(input);
    boolean _notEquals = (!Objects.equal(configurations, null));
    if (_notEquals) {
      List<GeneratorSuiteConfiguration> _generatorSuiteConfigurations = configurations.getGeneratorSuiteConfigurations();
      for (final GeneratorSuiteConfiguration config : _generatorSuiteConfigurations) {
        if ((config.isOnDemand() && config.getGeneratorClass().equals(generatorSuiteClass.getName()))) {
          return ConfigurationPersistence.loadGeneratorSuite(config);
        }
      }
    }
    return null;
  }
  
  public static IGeneratorSuite loadGeneratorSuite(final GeneratorSuiteConfiguration config) {
    try {
      final IConfigurationElement[] generatorSuites = Platform.getExtensionRegistry().getConfigurationElementsFor("co.edu.javeriana.isml.generator");
      for (final IConfigurationElement confElem : generatorSuites) {
        {
          final Object o = confElem.createExecutableExtension("class");
          if ((o instanceof IGeneratorSuite)) {
            boolean _equals = ((IGeneratorSuite)o).getClass().getName().equals(config.getGeneratorClass());
            if (_equals) {
              return ((IGeneratorSuite)o);
            }
          }
        }
      }
      String _generatorClass = config.getGeneratorClass();
      String _plus = ("Could not find generator named " + _generatorClass);
      System.err.println(_plus);
      return null;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static URI getProjectURI(final URI uri) {
    boolean _isPlatformResource = uri.isPlatformResource();
    if (_isPlatformResource) {
      return URI.createPlatformResourceURI(uri.segment(1), false);
    }
    return null;
  }
}
