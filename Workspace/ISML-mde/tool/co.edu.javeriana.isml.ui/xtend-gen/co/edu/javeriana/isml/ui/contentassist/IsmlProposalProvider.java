/**
 * generated by Xtext
 */
package co.edu.javeriana.isml.ui.contentassist;

import co.edu.javeriana.isml.isml.Resource;
import co.edu.javeriana.isml.ui.contentassist.AbstractIsmlProposalProvider;
import com.google.common.base.Predicate;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * see http://www.eclipse.org/Xtext/documentation.html#contentAssist on how to customize content assistant
 */
@SuppressWarnings("all")
public class IsmlProposalProvider extends AbstractIsmlProposalProvider {
  @Override
  public void completeResourceAssignment_Left(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    AbstractElement _terminal = assignment.getTerminal();
    final Predicate<IEObjectDescription> _function = (IEObjectDescription x) -> {
      EObject _eObjectOrProxy = x.getEObjectOrProxy();
      return (_eObjectOrProxy instanceof Resource);
    };
    this.lookupCrossReference(((CrossReference) _terminal), context, acceptor, _function);
  }
}