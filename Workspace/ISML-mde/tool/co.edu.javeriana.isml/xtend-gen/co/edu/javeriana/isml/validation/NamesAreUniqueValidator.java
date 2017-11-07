package co.edu.javeriana.isml.validation;

import co.edu.javeriana.isml.isml.InformationSystem;
import co.edu.javeriana.isml.isml.NamedElement;
import co.edu.javeriana.isml.scoping.IsmlModelNavigation;
import co.edu.javeriana.isml.validation.SignatureExtension;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.CancelableDiagnostician;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

@SuppressWarnings("all")
public class NamesAreUniqueValidator extends AbstractDeclarativeValidator {
  @Inject
  private IResourceServiceProvider.Registry resourceServiceProviderRegistry = IResourceServiceProvider.Registry.INSTANCE;
  
  @Inject
  @Extension
  private IsmlModelNavigation _ismlModelNavigation;
  
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Inject
  @Extension
  private SignatureExtension _signatureExtension;
  
  @Check
  public void checkUniqueNamesInResourceOf(final InformationSystem is) {
    boolean _containsKey = this.getContext().containsKey(is.eResource());
    if (_containsKey) {
      return;
    }
    this.getContext().put(is.eResource(), this);
    Object _get = this.getContext().get(CancelableDiagnostician.CANCEL_INDICATOR);
    final CancelIndicator cancelIndicator = ((CancelIndicator) _get);
    final HashMap<String, EObject> qualifiedNameIndex = new HashMap<String, EObject>();
    Iterable<NamedElement> _duplicatableNamedElements = this.getDuplicatableNamedElements(is);
    for (final NamedElement obj : _duplicatableNamedElements) {
      try {
        final String signature = this._signatureExtension.getSignature(obj);
        qualifiedNameIndex.put(signature, obj);
      } catch (final Throwable _t) {
        if (_t instanceof Throwable) {
          final Throwable t = (Throwable)_t;
          t.printStackTrace();
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    final Iterable<InformationSystem> allInstances = IteratorExtensions.<InformationSystem>toIterable(Iterators.<InformationSystem>filter(is.eResource().getResourceSet().getAllContents(), InformationSystem.class));
    for (final InformationSystem infSys : allInstances) {
      {
        final Iterable<NamedElement> duplicatableNamedElements = this.getDuplicatableNamedElements(infSys);
        for (final NamedElement obj_1 : duplicatableNamedElements) {
          {
            boolean _equals = Objects.equal(obj_1, null);
            if (_equals) {
              InputOutput.<NamedElement>println(obj_1);
            }
            final String signature_1 = this._signatureExtension.getSignature(obj_1);
            final EObject duplicate = qualifiedNameIndex.get(signature_1);
            if ((qualifiedNameIndex.containsKey(signature_1) && (!Objects.equal(obj_1, duplicate)))) {
              this.error(("Duplicate element " + signature_1), duplicate, duplicate.eClass().getEStructuralFeature("name"));
            }
            if (((!Objects.equal(cancelIndicator, null)) && cancelIndicator.isCanceled())) {
              return;
            }
          }
        }
      }
    }
  }
  
  /**
   * Retrieves all NamedElements within an InformationSystem with non null name and that are not Packages or Generic Types
   */
  public Iterable<NamedElement> getDuplicatableNamedElements(final InformationSystem is) {
    final Function1<NamedElement, Boolean> _function = (NamedElement x) -> {
      return Boolean.valueOf((((!Objects.equal(x.getName(), null)) && (!this._ismlModelNavigation.isPackage(x))) && (!this._ismlModelNavigation.isGenericType(x))));
    };
    return IterableExtensions.<NamedElement>filter(Iterables.<NamedElement>filter(IteratorExtensions.<EObject>toIterable(is.eAllContents()), NamedElement.class), _function);
  }
  
  @Override
  public List<EPackage> getEPackages() {
    final ArrayList<EPackage> result = new ArrayList<EPackage>();
    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.javeriana.edu.co/isml/Isml"));
    return result;
  }
}
