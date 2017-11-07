package co.edu.javeriana.generator;

import co.edu.javeriana.generator.IMultiModelGenerator;
import co.edu.javeriana.generator.configuration.ConfigurationPersistence;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import java.util.Map;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.builder.BuilderParticipant;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class IsmlBuilderParticipant extends BuilderParticipant implements IXtextBuilderParticipant {
  protected ThreadLocal<Boolean> buildSemaphor = new ThreadLocal<Boolean>();
  
  @Inject
  private ResourceDescriptionsProvider resourceDescriptionsProvider;
  
  @Inject
  private IContainer.Manager containerManager;
  
  @Inject
  private IMultiModelGenerator multiGenerator;
  
  @Override
  protected Map<String, OutputConfiguration> getOutputConfigurations(final IXtextBuilderParticipant.IBuildContext context) {
    return ConfigurationPersistence.loadOutputConfigurations(context);
  }
  
  @Override
  public void build(final IXtextBuilderParticipant.IBuildContext context, final IProgressMonitor monitor) throws CoreException {
    this.buildSemaphor.set(Boolean.valueOf(false));
    super.build(context, monitor);
  }
  
  @Override
  public void handleChangedContents(final IResourceDescription.Delta delta, final IXtextBuilderParticipant.IBuildContext context, final EclipseResourceFileSystemAccess2 fileSystemAccess) {
    try {
      if (((!(this.buildSemaphor.get()).booleanValue()) && (!Objects.equal(this.getGenerator(), null)))) {
        this.invokeGenerator(delta, context, fileSystemAccess);
      }
      super.handleChangedContents(delta, context, fileSystemAccess);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void invokeGenerator(final IResourceDescription.Delta delta, final IXtextBuilderParticipant.IBuildContext context, final IFileSystemAccess fileSystemAccess) {
    this.buildSemaphor.set(Boolean.valueOf(true));
    Resource resource = context.getResourceSet().getResource(delta.getUri(), true);
    boolean _shouldGenerate = this.shouldGenerate(resource, context);
    if (_shouldGenerate) {
      IResourceDescriptions index = this.resourceDescriptionsProvider.createResourceDescriptions();
      IResourceDescription resDesc = index.getResourceDescription(resource.getURI());
      List<IContainer> visibleContainers = this.containerManager.getVisibleContainers(resDesc, index);
      for (final IContainer c : visibleContainers) {
        Iterable<IResourceDescription> _resourceDescriptions = c.getResourceDescriptions();
        for (final IResourceDescription rd : _resourceDescriptions) {
          context.getResourceSet().getResource(rd.getURI(), true);
        }
      }
      this.multiGenerator.doGenerate(context.getResourceSet(), fileSystemAccess);
    }
  }
}
