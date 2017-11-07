package co.edu.javeriana.isml;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.linking.lazy.LazyLinker;

@SuppressWarnings("all")
public class IsmlLinker extends LazyLinker {
  @Override
  public void afterModelLinked(final EObject obj, final IDiagnosticConsumer diagnosticsConsumer) {
  }
}
