package co.edu.javeriana.isml.scoping;

import co.edu.javeriana.isml.isml.CompositeElement;
import co.edu.javeriana.isml.isml.Function;
import co.edu.javeriana.isml.isml.Iteration;
import co.edu.javeriana.isml.isml.TypedElement;
import co.edu.javeriana.isml.scoping.IsmlModelNavigation;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class ScopeExtension {
  @Inject
  @Extension
  private IsmlModelNavigation _ismlModelNavigation;
  
  public Iterable<EObject> getAllElementsInScope(final EObject obj) {
    ArrayList<EObject> vars = new ArrayList<EObject>();
    EObject current = obj;
    while ((!Objects.equal(current, null))) {
      {
        this.addAllStatementsInScope(current, vars);
        current = current.eContainer();
      }
    }
    return vars;
  }
  
  public boolean addAllStatementsInScope(final EObject obj, final ArrayList<EObject> vars) {
    boolean _xblockexpression = false;
    {
      final EObject container = obj.eContainer();
      if ((container instanceof CompositeElement<?>)) {
        Iterables.<EObject>addAll(vars, this.findAllPreviousInstancesOfType(obj, TypedElement.class));
      }
      if ((container instanceof Iteration)) {
        vars.add(((Iteration)container).getVariable());
      }
      boolean _xifexpression = false;
      if ((container instanceof Function)) {
        _xifexpression = vars.addAll(((Function)container).getParameters());
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  /**
   * Finds all the instances of a given type that appear previously in the same block of a given object.
   * This can be utilized to find variable declarations that should be located before a variable reference
   */
  public Iterable<EObject> findAllPreviousInstancesOfType(final EObject obj, final Class<?>... types) {
    final ArrayList<EObject> previousInstances = new ArrayList<EObject>();
    EObject container = obj.eContainer();
    final EStructuralFeature containingFeature = obj.eContainingFeature();
    boolean _notEquals = (!Objects.equal(container, null));
    if (_notEquals) {
      final Object body = container.eGet(containingFeature);
      if ((body instanceof EList<?>)) {
        for (final Object ch : ((EList<?>)body)) {
          {
            final EObject child = ((EObject) ch);
            boolean _equals = Objects.equal(child, obj);
            if (_equals) {
              return previousInstances;
            }
            for (final Class<?> type : types) {
              boolean _isAssignableFrom = type.isAssignableFrom(child.getClass());
              if (_isAssignableFrom) {
                previousInstances.add(child);
              }
            }
          }
        }
      }
    }
    return previousInstances;
  }
}
