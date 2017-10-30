/*
 * generated by Xtext
 */
package co.edu.javeriana.isml;

import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;

import co.edu.javeriana.isml.scoping.IsmlImportedNamespaceAwareLocalScopeProvider;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class IsmlRuntimeModule extends AbstractIsmlRuntimeModule {

	@Override
	public void configureIScopeProviderDelegate(Binder binder) {
		binder.bind(IScopeProvider.class).annotatedWith(Names.named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE)).to(IsmlImportedNamespaceAwareLocalScopeProvider.class);
	}
	
	@Override
	public Class<? extends ILinker> bindILinker() {
		return IsmlLinker.class;
	}
	
	public Class<? extends IQualifiedNameConverter> bindIQualifiedNameConverter() {
		return IsmlQualifiedNameConverter.class;
	}
	
	// this is required only by the CompilationTestHelper since Xtext 2.7
  /*  public Class<? extends org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport> bindMutableFileSystemSupport() {
        return org.eclipse.xtext.xbase.file.JavaIOFileSystemSupport.class;
    }

    // this is required only by the CompilationTestHelper since Xtext 2.7
    public Class<? extends com.google.inject.Provider<org.eclipse.xtext.xbase.file.WorkspaceConfig>> provideWorkspaceConfig() {
        return org.eclipse.xtext.xbase.file.RuntimeWorkspaceConfigProvider.class;
    }
*/

}