package co.edu.javeriana.generator;

import co.edu.javeriana.generator.configuration.ConfigurationPersistence;
import co.edu.javeriana.isml.generator.Activator;
import co.edu.javeriana.isml.generator.common.IGeneratorSuite;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@SuppressWarnings("all")
public abstract class OnDemandGeneratorHandler extends AbstractHandler {
  @Inject
  private Provider<EclipseResourceFileSystemAccess2> fileAccessProvider;
  
  @Inject
  private Provider<ResourceSet> resourceSetProvider;
  
  public OnDemandGeneratorHandler() {
    try {
      Activator.getInjector().injectMembers(this);
    } catch (final Throwable _t) {
      if (_t instanceof Throwable) {
        final Throwable t = (Throwable)_t;
        t.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public abstract Class<? extends IGeneratorSuite> getGeneratorClass();
  
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    try {
      System.err.println("starting on demand generator");
      final ISelection selection = HandlerUtil.getCurrentSelection(event);
      if ((selection instanceof IStructuredSelection)) {
        Iterable<Object> _iterable = IteratorExtensions.<Object>toIterable(((IStructuredSelection)selection).iterator());
        for (final Object elem : _iterable) {
          if ((elem instanceof IFile)) {
            final IProject project = ((IFile)elem).getProject();
            final URI uri = URI.createPlatformResourceURI(((IFile)elem).getFullPath().toString(), true);
            final ResourceSet rs = this.resourceSetProvider.get();
            final Resource r = rs.getResource(uri, true);
            final EclipseResourceFileSystemAccess2 fsa = this.fileAccessProvider.get();
            fsa.setProject(project);
            fsa.setOutputConfigurations(ConfigurationPersistence.loadOutputConfigurations(r));
            NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
            fsa.setMonitor(_nullProgressMonitor);
            this.doGenerate(r, fsa);
          }
        }
      }
    } catch (final Throwable _t) {
      if (_t instanceof Throwable) {
        final Throwable t = (Throwable)_t;
        t.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return null;
  }
  
  private void doGenerate(final Resource input, final EclipseResourceFileSystemAccess2 fsa) {
    Class<? extends IGeneratorSuite> _generatorClass = this.getGeneratorClass();
    String _plus = ("***** ON DEMAND GENERATOR RUNNING ****** " + _generatorClass);
    System.err.println(_plus);
    final IGeneratorSuite generatorSuite = ConfigurationPersistence.loadGeneratorSuite(input, this.getGeneratorClass());
    boolean _equals = Objects.equal(generatorSuite, null);
    if (_equals) {
      Class<? extends IGeneratorSuite> _generatorClass_1 = this.getGeneratorClass();
      String _plus_1 = ("Could not load generator " + _generatorClass_1);
      System.err.println(_plus_1);
    } else {
      Class<? extends IGeneratorSuite> _generatorClass_2 = this.getGeneratorClass();
      String _plus_2 = ("Using " + _generatorClass_2);
      String _plus_3 = (_plus_2 + " to generate from ");
      URI _uRI = input.getURI();
      String _plus_4 = (_plus_3 + _uRI);
      System.err.println(_plus_4);
      generatorSuite.doGenerate(input, fsa);
    }
  }
}
