package co.edu.javeriana.isml.scoping;

import co.edu.javeriana.isml.isml.Import;
import co.edu.javeriana.isml.isml.IsmlPackage;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class IsmlImportedNamespaceAwareLocalScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Override
  protected List<ImportNormalizer> internalGetImportedNamespaceResolvers(final EObject context, final boolean ignoreCase) {
    List<ImportNormalizer> result = super.internalGetImportedNamespaceResolvers(context, ignoreCase);
    boolean _matched = false;
    if (context instanceof co.edu.javeriana.isml.isml.Package) {
      _matched=true;
      String _string = this._iQualifiedNameProvider.getFullyQualifiedName(context).toString();
      String _plus = (_string + ".*");
      result.add(this.createImportedNamespaceResolver(_plus, false));
      result.add(this.createImportedNamespaceResolver("common.primitives.*", false));
      result.add(this.createImportedNamespaceResolver("common.widgets.*", false));
      result.add(this.createImportedNamespaceResolver("common.constraints.*", false));
      result.add(this.createImportedNamespaceResolver("common.services.*", false));
      result.add(this.createImportedNamespaceResolver("common.controllers.*", false));
    }
    if (!_matched) {
    }
    return result;
  }
  
  @Override
  protected String getImportedNamespace(final EObject object) {
    if ((object instanceof Import)) {
      Import imp = ((Import) object);
      List<INode> nodes = NodeModelUtils.findNodesForFeature(imp, IsmlPackage.Literals.IMPORT__IMPORTED_PACKAGE);
      INode node = nodes.get(0);
      String _tokenText = NodeModelUtils.getTokenText(node);
      String importString = (_tokenText + ".*");
      return importString;
    }
    return null;
  }
}
