package co.edu.javeriana.isml.scoping;

import co.edu.javeriana.isml.isml.Action;
import co.edu.javeriana.isml.isml.ActionCall;
import co.edu.javeriana.isml.isml.Actor;
import co.edu.javeriana.isml.isml.Assignment;
import co.edu.javeriana.isml.isml.Attribute;
import co.edu.javeriana.isml.isml.Caller;
import co.edu.javeriana.isml.isml.CompositeTypeSpecification;
import co.edu.javeriana.isml.isml.Controller;
import co.edu.javeriana.isml.isml.Element;
import co.edu.javeriana.isml.isml.Entity;
import co.edu.javeriana.isml.isml.Expression;
import co.edu.javeriana.isml.isml.Feature;
import co.edu.javeriana.isml.isml.ForView;
import co.edu.javeriana.isml.isml.Function;
import co.edu.javeriana.isml.isml.GenericTypeSpecification;
import co.edu.javeriana.isml.isml.InformationSystem;
import co.edu.javeriana.isml.isml.Instance;
import co.edu.javeriana.isml.isml.Interface;
import co.edu.javeriana.isml.isml.LiteralValue;
import co.edu.javeriana.isml.isml.Method;
import co.edu.javeriana.isml.isml.MethodCall;
import co.edu.javeriana.isml.isml.MethodStatement;
import co.edu.javeriana.isml.isml.NamedElement;
import co.edu.javeriana.isml.isml.NamedViewBlock;
import co.edu.javeriana.isml.isml.Page;
import co.edu.javeriana.isml.isml.Parameter;
import co.edu.javeriana.isml.isml.ParameterizedType;
import co.edu.javeriana.isml.isml.Primitive;
import co.edu.javeriana.isml.isml.Reference;
import co.edu.javeriana.isml.isml.Service;
import co.edu.javeriana.isml.isml.Show;
import co.edu.javeriana.isml.isml.Struct;
import co.edu.javeriana.isml.isml.Type;
import co.edu.javeriana.isml.isml.TypeSpecification;
import co.edu.javeriana.isml.isml.TypedElement;
import co.edu.javeriana.isml.isml.Variable;
import co.edu.javeriana.isml.isml.VariableReference;
import co.edu.javeriana.isml.isml.VariableTypeElement;
import co.edu.javeriana.isml.isml.View;
import co.edu.javeriana.isml.isml.ViewInstance;
import co.edu.javeriana.isml.isml.ViewStatement;
import co.edu.javeriana.isml.validation.TypeChecker;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.mwe2.language.scoping.QualifiedNameProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Helper to navigate Isml models
 */
@SuppressWarnings("all")
public class IsmlModelNavigation {
  @Inject
  private ResourceDescriptionsProvider resourceDescriptionsProvider;
  
  @Inject
  @Extension
  private TypeChecker _typeChecker;
  
  @Inject
  @Extension
  private QualifiedNameProvider _qualifiedNameProvider;
  
  public TypeSpecification getContainerTypeSpecification(final Feature f) {
    final EObject container = f.eContainer();
    if ((container instanceof TypeSpecification)) {
      return ((TypeSpecification)container);
    }
    return null;
  }
  
  public TypeSpecification getContainerTypeSpecification(final Caller c) {
    Type _containerType = this.getContainerType(c);
    TypeSpecification _typeSpecification = null;
    if (_containerType!=null) {
      _typeSpecification=this.getTypeSpecification(_containerType);
    }
    return _typeSpecification;
  }
  
  public Type getContainerType(final Caller c) {
    final EObject container = c.eContainer();
    if ((container instanceof VariableReference)) {
      final VariableTypeElement referenced = ((VariableReference)container).getReferencedElement();
      return referenced.getType();
    }
    return null;
  }
  
  public Iterable<Feature> getFeatures(final TypeSpecification ts) {
    if ((ts instanceof CompositeTypeSpecification<?>)) {
      return Iterables.<Feature>filter(((CompositeTypeSpecification<?>)ts).getBody(), Feature.class);
    } else {
      return CollectionLiterals.<Feature>emptyList();
    }
  }
  
  public Iterable<Attribute> getAttributes(final Struct c) {
    final EList<Attribute> body = c.getBody();
    Iterable<Attribute> _filter = null;
    if (body!=null) {
      _filter=Iterables.<Attribute>filter(body, Attribute.class);
    }
    return _filter;
  }
  
  public Iterable<Method> getMethods(final Interface c) {
    Iterable<Feature> _features = this.getFeatures(c);
    Iterable<Method> _filter = null;
    if (_features!=null) {
      _filter=Iterables.<Method>filter(_features, Method.class);
    }
    return _filter;
  }
  
  public Iterable<Action> getActions(final Controller c) {
    EList<Action> _body = c.getBody();
    Iterable<Action> _filter = null;
    if (_body!=null) {
      _filter=Iterables.<Action>filter(_body, Action.class);
    }
    return _filter;
  }
  
  public Iterable<Attribute> getAllAttributes(final TypeSpecification c) {
    final Set<TypedElement> f = this.getAllFeatures(c);
    Iterable<Attribute> _filter = null;
    if (f!=null) {
      _filter=Iterables.<Attribute>filter(f, Attribute.class);
    }
    return _filter;
  }
  
  public Iterable<Method> getAllMethods(final TypeSpecification c) {
    return Iterables.<Method>filter(this.getAllFeatures(c), Method.class);
  }
  
  public Iterable<Action> getAllActions(final TypeSpecification c) {
    return Iterables.<Action>filter(this.getAllFeatures(c), Action.class);
  }
  
  public Entity getEntity(final Attribute attribute) {
    EObject _eContainer = attribute.eContainer();
    return ((Entity) _eContainer);
  }
  
  public TypeSpecification getTypeSpecification(final Type type) {
    return type.getReferencedElement();
  }
  
  public void setTypeSpecification(final Type type, final TypeSpecification ts) {
    type.setReferencedElement(ts);
  }
  
  public <T extends EObject> T findByName(final Iterable<T> elements, final String name) {
    for (final T e : elements) {
      if ((e instanceof NamedElement)) {
        final NamedElement ne = ((NamedElement) e);
        boolean _equals = name.equals(ne.getName());
        if (_equals) {
          return e;
        }
      }
    }
    return null;
  }
  
  public Method getMethod(final MethodCall mc) {
    Method _referencedElement = mc.getReferencedElement();
    return ((Method) _referencedElement);
  }
  
  public Action getAction(final ActionCall ac) {
    Action _referencedElement = ac.getReferencedElement();
    return ((Action) _referencedElement);
  }
  
  /**
   * The "body" attribute of a view statement is no longer of type Block, but
   * of type EList.
   * Now the elements contained in a view statement must be accessed directly through the
   * "body" attribute.
   */
  @Deprecated
  public Iterable<ViewStatement> parts(final Object viewBlock) {
    throw new UnsupportedOperationException();
  }
  
  public boolean instanceOf(final Instance instance, final Type type) {
    return this.isSubtypeOf(instance.getType(), type);
  }
  
  protected boolean _isSubtypeOf(final ParameterizedType t1, final ParameterizedType t2) {
    boolean _isSubtypeSpecificationOf = this.isSubtypeSpecificationOf(this.getTypeSpecification(t1), this.getTypeSpecification(t2));
    if (_isSubtypeSpecificationOf) {
      int _size = t1.getTypeParameters().size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for (final Integer i : _doubleDotLessThan) {
        {
          final Type typeParam1 = t1.getTypeParameters().get((i).intValue());
          final Type typeParam2 = t2.getTypeParameters().get((i).intValue());
          boolean _isSubtypeOf = this.isSubtypeOf(typeParam1, typeParam2);
          boolean _not = (!_isSubtypeOf);
          if (_not) {
            return false;
          }
        }
      }
      return true;
    } else {
      return false;
    }
  }
  
  protected boolean _isSubtypeOf(final Type t1, final Type t2) {
    boolean _equals = EcoreUtil.equals(t1, t2);
    if (_equals) {
      return true;
    } else {
      EList<Type> _superTypes = this.getTypeSpecification(t1).getSuperTypes();
      for (final Type superType : _superTypes) {
        boolean _isSubtypeOf = this.isSubtypeOf(superType, t2);
        if (_isSubtypeOf) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean isSubtypeSpecificationOf(final TypeSpecification t1, final TypeSpecification t2) {
    boolean _equals = EcoreUtil.equals(t1, t2);
    if (_equals) {
      return true;
    } else {
      Iterable<TypeSpecification> _superTypeSpecifications = this.getSuperTypeSpecifications(t1);
      for (final TypeSpecification superType : _superTypeSpecifications) {
        boolean _isSubtypeSpecificationOf = this.isSubtypeSpecificationOf(superType, t2);
        if (_isSubtypeSpecificationOf) {
          return true;
        }
      }
    }
    return false;
  }
  
  public Iterable<TypeSpecification> getSuperTypeSpecifications(final TypeSpecification typeSpec) {
    final Function1<Type, TypeSpecification> _function = (Type x) -> {
      return this.getTypeSpecification(x);
    };
    return ListExtensions.<Type, TypeSpecification>map(typeSpec.getSuperTypes(), _function);
  }
  
  protected Set<TypedElement> _getAllFeatures(final Controller c) {
    final LinkedHashSet<TypedElement> features = new LinkedHashSet<TypedElement>();
    features.addAll(this.getAllTypeSpecificationFeatures(c));
    final Consumer<Service> _function = (Service x) -> {
      features.addAll(this.getAllFeatures(x));
    };
    this.getUnnamedServices(c).forEach(_function);
    return features;
  }
  
  protected Set<TypedElement> _getAllFeatures(final Primitive p) {
    return CollectionLiterals.<TypedElement>emptySet();
  }
  
  protected Set<TypedElement> _getAllFeatures(final CompositeTypeSpecification<?> ts) {
    return this.getAllTypeSpecificationFeatures(ts);
  }
  
  protected Set<TypedElement> _getAllFeatures(final Type t) {
    return this.getAllFeatures(this.getTypeSpecification(t));
  }
  
  public Set<TypedElement> getAllTypeSpecificationFeatures(final CompositeTypeSpecification<?> c) {
    final LinkedHashSet<TypedElement> features = new LinkedHashSet<TypedElement>();
    Iterables.<TypedElement>addAll(features, this.getFeatures(c));
    if ((c instanceof TypeSpecification)) {
      EList<Type> _superTypes = c.getSuperTypes();
      for (final Type p : _superTypes) {
        features.addAll(this.getAllFeatures(p));
      }
    }
    return features;
  }
  
  @Deprecated
  public TypeSpecification getClassifier(final Type type) {
    return this.getTypeSpecification(type);
  }
  
  public Collection<Type> getParents(final TypeSpecification typeSpec) {
    return typeSpec.getSuperTypes();
  }
  
  protected View _getView(final ViewInstance obj) {
    TypeSpecification _typeSpecification = this.getTypeSpecification(obj.getType());
    return ((View) _typeSpecification);
  }
  
  protected View _getView(final Instance obj) {
    EObject container = obj.eContainer();
    while (((!(container instanceof View)) || Objects.equal(((View) container).getController(), null))) {
      container = container.eContainer();
    }
    if (((!Objects.equal(container, null)) && (container instanceof View))) {
      return ((View) container);
    }
    return null;
  }
  
  public <T extends EObject> Collection<T> getAllInstancesOfSameClass(final T obj) {
    final ResourceSet resourceSet = obj.eResource().getResourceSet();
    final IResourceDescriptions resourceDescriptions = this.resourceDescriptionsProvider.getResourceDescriptions(resourceSet);
    final LinkedHashSet<T> instances = new LinkedHashSet<T>();
    Iterable<IResourceDescription> _allResourceDescriptions = resourceDescriptions.getAllResourceDescriptions();
    for (final IResourceDescription resourceDescription : _allResourceDescriptions) {
      {
        final Resource r = resourceSet.getResource(resourceDescription.getURI(), true);
        Iterable<? extends EObject> _iterable = IteratorExtensions.toIterable(Iterators.filter(r.getAllContents(), obj.getClass()));
        for (final EObject o : _iterable) {
          boolean _eIsProxy = o.eIsProxy();
          if (_eIsProxy) {
            EObject _resolve = EcoreUtil2.resolve(o, obj.eResource().getResourceSet());
            final T resolved = ((T) _resolve);
            instances.add(resolved);
          } else {
            instances.add(((T) o));
          }
        }
      }
    }
    return instances;
  }
  
  public <T extends EObject> Collection<T> getAllInstances(final ResourceSet resourceSet, final Class<T> c) {
    final IResourceDescriptions resourceDescriptions = this.resourceDescriptionsProvider.getResourceDescriptions(resourceSet);
    final LinkedHashSet<T> instances = new LinkedHashSet<T>();
    Iterable<IResourceDescription> _allResourceDescriptions = resourceDescriptions.getAllResourceDescriptions();
    for (final IResourceDescription resourceDescription : _allResourceDescriptions) {
      {
        final Resource res = resourceSet.getResource(resourceDescription.getURI(), true);
        Iterable<T> _iterable = IteratorExtensions.<T>toIterable(Iterators.<T>filter(res.getAllContents(), c));
        for (final T o : _iterable) {
          boolean _eIsProxy = o.eIsProxy();
          if (_eIsProxy) {
            final EObject resolved = EcoreUtil2.resolve(o, resourceSet);
            instances.add(((T) resolved));
          } else {
            instances.add(o);
          }
        }
      }
    }
    return instances;
  }
  
  public Iterable<IEObjectDescription> filterByClass(final Iterable<IEObjectDescription> descriptions, final Class<?> c) {
    final Function1<IEObjectDescription, Boolean> _function = (IEObjectDescription x) -> {
      return Boolean.valueOf(c.isInstance(x.getEObjectOrProxy()));
    };
    return IterableExtensions.<IEObjectDescription>filter(descriptions, _function);
  }
  
  public View getContainerView(final EObject vp) {
    EObject current = vp;
    while (((!Objects.equal(current, null)) && (!(current instanceof View)))) {
      current = current.eContainer();
    }
    return ((View) current);
  }
  
  public Iterable<Feature> getServices(final CompositeTypeSpecification<?> c) {
    final Function1<Feature, Boolean> _function = (Feature x) -> {
      Type _type = x.getType();
      TypeSpecification _typeSpecification = null;
      if (_type!=null) {
        _typeSpecification=this.getTypeSpecification(_type);
      }
      return Boolean.valueOf((_typeSpecification instanceof Service));
    };
    return IterableExtensions.<Feature>filter(this.getFeatures(c), _function);
  }
  
  public Iterable<Feature> getServices(final Reference r) {
    EObject current = this.findAnyAncestor(r, Controller.class, View.class, Service.class);
    if ((current instanceof View)) {
      Controller _controller = ((View)current).getController();
      boolean _notEquals = (!Objects.equal(_controller, null));
      if (_notEquals) {
        return this.getServices(((View)current).getController());
      }
    }
    if ((current instanceof Controller)) {
      return this.getServices(((CompositeTypeSpecification<?>)current));
    }
    if ((current instanceof Service)) {
      return this.getServices(((CompositeTypeSpecification<?>)current));
    }
    return CollectionLiterals.<Feature>emptySet();
  }
  
  private <T extends TypedElement> Iterable<T> filterUnnamed(final Iterable<T> s) {
    final Function1<T, Boolean> _function = (T x) -> {
      String _name = x.getName();
      return Boolean.valueOf(Objects.equal(_name, null));
    };
    return IterableExtensions.<T>filter(s, _function);
  }
  
  private <T extends TypedElement> Iterable<T> filterNamed(final Iterable<T> s) {
    final Function1<T, Boolean> _function = (T x) -> {
      String _name = x.getName();
      return Boolean.valueOf((!Objects.equal(_name, null)));
    };
    return IterableExtensions.<T>filter(s, _function);
  }
  
  public Iterable<Service> getUnnamedServices(final Reference r) {
    final Function1<Feature, TypeSpecification> _function = (Feature x) -> {
      return this.getTypeSpecification(x.getType());
    };
    return Iterables.<Service>filter(IterableExtensions.<Feature, TypeSpecification>map(this.<Feature>filterUnnamed(this.getServices(r)), _function), Service.class);
  }
  
  public Iterable<Service> getUnnamedServices(final Controller c) {
    final Function1<Feature, TypeSpecification> _function = (Feature x) -> {
      return this.getTypeSpecification(x.getType());
    };
    return Iterables.<Service>filter(IterableExtensions.<Feature, TypeSpecification>map(this.<Feature>filterUnnamed(this.getServices(c)), _function), Service.class);
  }
  
  /**
   * Finds ancestor of certain types.
   * @param obj the object from which ancestors are searched
   * @param classes the classes of the ancestors that are going to be found
   * @return the first ancestors that is instance of any class in classes
   */
  public EObject findAnyAncestor(final EObject obj, final Class<? extends EObject>... classes) {
    EObject current = obj;
    while ((!Objects.equal(current, null))) {
      {
        for (final Class<? extends EObject> c : classes) {
          boolean _isAssignableFrom = c.isAssignableFrom(current.getClass());
          if (_isAssignableFrom) {
            return current;
          }
        }
        current = current.eContainer();
      }
    }
    return null;
  }
  
  public <S extends EObject, T extends EObject> T findAncestor(final S obj, final Class<T> c) {
    return this.<EObject, T>cast(this.findAnyAncestor(obj, c), c);
  }
  
  public EStructuralFeature findContainingFeature(final EObject object, final EObject ancestor) {
    EObject current = object;
    EStructuralFeature currentFeature = null;
    while (((!Objects.equal(current, null)) && (!Objects.equal(current, ancestor)))) {
      {
        currentFeature = current.eContainingFeature();
        current = current.eContainer();
      }
    }
    return currentFeature;
  }
  
  /**
   * Finds the ancestor whose parent is of certain types.
   * @param obj the object from which ancestors' child are searched
   * @param classes the classes of the ancestors that are going to be found
   * @return the child of the first ancestors that is instance of any class in classes
   */
  public EObject findAncestorWithParentOfType(final EObject obj, final Class<? extends EObject>... classes) {
    EObject current = obj;
    while ((!Objects.equal(current, null))) {
      {
        final EObject parent = current.eContainer();
        boolean _notEquals = (!Objects.equal(parent, null));
        if (_notEquals) {
          for (final Class<? extends EObject> c : classes) {
            boolean _isAssignableFrom = c.isAssignableFrom(parent.getClass());
            if (_isAssignableFrom) {
              return current;
            }
          }
        }
        current = parent;
      }
    }
    return null;
  }
  
  public EObject findDescendent(final EObject obj, final Class<? extends EObject>... classes) {
    Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(obj.eAllContents());
    for (final EObject child : _iterable) {
      for (final Class<? extends EObject> c : classes) {
        boolean _isAssignableFrom = c.isAssignableFrom(child.getClass());
        if (_isAssignableFrom) {
          return child;
        }
      }
    }
    return null;
  }
  
  public Collection<Method> getAllMethods(final Interface i) {
    final LinkedHashSet<Method> methods = new LinkedHashSet<Method>();
    Iterables.<Method>addAll(methods, this.getMethods(i));
    EList<Type> _superTypes = i.getSuperTypes();
    for (final Type superType : _superTypes) {
      {
        final TypeSpecification typeSpecification = this.getTypeSpecification(superType);
        if ((typeSpecification instanceof Interface)) {
          methods.addAll(this.getAllMethods(((Interface)typeSpecification)));
        }
      }
    }
    return methods;
  }
  
  public Collection<Method> getAllMethods(final Controller c) {
    final LinkedHashSet<Method> methods = new LinkedHashSet<Method>();
    final Consumer<Service> _function = (Service x) -> {
      methods.addAll(this.getAllMethods(x));
    };
    this.getUnnamedServices(c).forEach(_function);
    return methods;
  }
  
  /**
   * Obtiene el controlador que contiene a un elemento del modelo
   */
  public Controller getContainerController(final EObject e) {
    EObject current = e;
    while ((((!Objects.equal(current, null)) && (!(current instanceof Controller))) && (!(current instanceof Page)))) {
      current = current.eContainer();
    }
    if ((current instanceof Page)) {
      return ((Page)current).getController();
    } else {
      if ((current instanceof Controller)) {
        return ((Controller)current);
      } else {
        return null;
      }
    }
  }
  
  public Page getContainerPage(final EObject e) {
    EObject current = e;
    while (((!Objects.equal(current, null)) && (!(current instanceof Page)))) {
      current = current.eContainer();
    }
    return ((Page) current);
  }
  
  public Attribute getProperty(final Entity e, final String propName) {
    Iterable<Attribute> _attributes = this.getAttributes(e);
    for (final Attribute p : _attributes) {
      boolean _equals = p.getName().equals(propName);
      if (_equals) {
        return p;
      }
    }
    return null;
  }
  
  public Parameter getParameter(final TypeSpecification t, final String paramName) {
    EList<Parameter> _parameters = t.getParameters();
    for (final Parameter p : _parameters) {
      boolean _equals = p.getName().equals(paramName);
      if (_equals) {
        return p;
      }
    }
    return null;
  }
  
  public NamedViewBlock getTableBody(final ViewInstance i) {
    ViewStatement _findByName = this.<ViewStatement>findByName(i.getBody(), "body");
    return ((NamedViewBlock) _findByName);
  }
  
  public NamedViewBlock getTableHeader(final ViewInstance i) {
    ViewStatement _findByName = this.<ViewStatement>findByName(i.getBody(), "header");
    return ((NamedViewBlock) _findByName);
  }
  
  public <T extends NamedElement> T findByName(final EList<T> elements, final String name) {
    final Function1<T, Boolean> _function = (T x) -> {
      return Boolean.valueOf(x.getName().equals(name));
    };
    return IterableExtensions.<T>findFirst(elements, _function);
  }
  
  public ForView getForViewInBody(final ViewInstance i) {
    EObject _findDescendent = this.findDescendent(i, ForView.class);
    return ((ForView) _findDescendent);
  }
  
  public Expression getParameter(final Instance i, final String paramName) {
    int pos = 0;
    EList<Parameter> _parameters = this.getTypeSpecification(i.getType()).getParameters();
    for (final Parameter p : _parameters) {
      {
        boolean _equals = p.getName().equals(paramName);
        if (_equals) {
          return i.getParameters().get(pos);
        }
        pos = (pos + 1);
      }
    }
    return null;
  }
  
  public Object getAttributeValue(final EObject parent, final String relativePath) {
    String[] pathElements = relativePath.split("\\.");
    EObject element = parent;
    int i = 0;
    while ((i < (pathElements.length - 1))) {
      {
        final String attr = pathElements[i];
        Object obj = this.getSimpleAttributeValue(element, attr);
        boolean _notEquals = (!Objects.equal(obj, null));
        if (_notEquals) {
          if ((obj instanceof EObject)) {
            element = ((EObject) obj);
          }
        } else {
          return null;
        }
        i = (i + 1);
      }
    }
    return this.getSimpleAttributeValue(element, pathElements[i]);
  }
  
  private Object getSimpleAttributeValue(final EObject element, final String attr) {
    final EStructuralFeature feature = element.eClass().getEStructuralFeature(attr);
    boolean _notEquals = (!Objects.equal(feature, null));
    if (_notEquals) {
      Object obj = element.eGet(feature);
      return obj;
    } else {
      return null;
    }
  }
  
  public EList<Parameter> setParametersValue(final EList<Parameter> parameters, final EList<Expression> parameterValues) {
    EList<Expression> parametersValuesTmp = new BasicEList<Expression>();
    for (final Expression ex : parameterValues) {
      parametersValuesTmp.add(ex);
    }
    EList<Parameter> parametersListReturn = new BasicEList<Parameter>();
    for (int i = 0; (i < parameters.size()); i++) {
      {
        Parameter p = parameters.get(i);
        p.setValue(parametersValuesTmp.get(i));
        parametersListReturn.add(p);
      }
    }
    return parametersListReturn;
  }
  
  public boolean isCalledFromPage(final ActionCall call) {
    EObject _eContainer = call.eContainer();
    return (_eContainer instanceof ViewInstance);
  }
  
  /**
   * Metodo que verifica si la entidad es una instancia de Entity
   */
  public boolean isParentEntity(final EList<TypeSpecification> superTypes) {
    boolean isEntity = false;
    for (final TypeSpecification c : superTypes) {
      if ((c instanceof Entity)) {
        isEntity = true;
      }
    }
    return isEntity;
  }
  
  /**
   * Metodo que verifica si la entidad tiene padres
   * @param entity: se refiere a la entidad
   * @return isSon : si la entidad tiene padres
   */
  public boolean isSon(final Entity entity) {
    boolean isSon = false;
    EList<Type> _superTypes = entity.getSuperTypes();
    for (final Type parent : _superTypes) {
      TypeSpecification _typeSpecification = this.getTypeSpecification(parent);
      if ((_typeSpecification instanceof Entity)) {
        isSon = true;
      }
    }
    return isSon;
  }
  
  /**
   * Metodo que verifica si en la lista de parametros existe
   * una instancia de Array definido en el lenguaje
   * @param EList<Attribute>: lista de atributos
   * @return isArrayPresent: si existe una instacia de Array
   */
  public boolean isArrayPresent(final Iterable<Attribute> attributes) {
    for (final Attribute a : attributes) {
      boolean _isCollection = this._typeChecker.isCollection(a.getType());
      if (_isCollection) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isArray(final Type t) {
    return "Array".equals(this.getTypeSpecification(t).getName());
  }
  
  public boolean isPackage(final NamedElement elem) {
    return (elem instanceof co.edu.javeriana.isml.isml.Package);
  }
  
  public boolean isGenericType(final EObject elem) {
    if ((elem instanceof GenericTypeSpecification)) {
      return true;
    }
    if ((elem instanceof Type)) {
      TypeSpecification _typeSpecification = this.getTypeSpecification(((Type)elem));
      return (_typeSpecification instanceof GenericTypeSpecification);
    }
    return false;
  }
  
  /**
   * Metodo que verifica si una entidad es padre
   * @param entity: parametro entidad
   * @return isParent: retorna true si es una entidad padre
   */
  public boolean isParent(final Entity entity) {
    boolean isParent = false;
    EObject _eContainer = entity.eContainer().eContainer();
    InformationSystem is = ((InformationSystem) _eContainer);
    Set<Entity> allEntities = new LinkedHashSet<Entity>();
    allEntities.addAll(this.<Entity>getAllInstances(is.eResource().getResourceSet(), Entity.class));
    allEntities.addAll(this.<Actor>getAllInstances(is.eResource().getResourceSet(), Actor.class));
    for (final Entity anotherEntity : allEntities) {
      EList<Type> _superTypes = anotherEntity.getSuperTypes();
      for (final Type superType : _superTypes) {
        boolean _equals = this.getTypeSpecification(superType).getName().equals(entity.getName());
        if (_equals) {
          isParent = true;
        }
      }
    }
    return isParent;
  }
  
  public Entity getOppositeEntity(final Attribute a) {
    Entity _xblockexpression = null;
    {
      final Type type = a.getType();
      _xblockexpression = this.findEntityTypeSpec(type);
    }
    return _xblockexpression;
  }
  
  public Entity findEntityTypeSpec(final Type type) {
    boolean _is = this.is(type, Entity.class);
    if (_is) {
      TypeSpecification _typeSpecification = this.getTypeSpecification(type);
      return ((Entity) _typeSpecification);
    } else {
      boolean _isCollection = this._typeChecker.isCollection(type);
      if (_isCollection) {
        final ParameterizedType collectionType = ((ParameterizedType) type);
        final TypeSpecification containedTypeSpec = this.getTypeSpecification(collectionType.getTypeParameters().get(0));
        if ((containedTypeSpec instanceof Entity)) {
          return ((Entity)containedTypeSpec);
        }
      }
    }
    return null;
  }
  
  public boolean is(final Type type, final Class<? extends TypeSpecification> typeSpecClass) {
    return typeSpecClass.isAssignableFrom(this.getTypeSpecification(type).getClass());
  }
  
  public boolean getIsOppositeCollection(final Attribute attribute) {
    final Attribute opposite = this.searchOpposite(attribute);
    boolean _notEquals = (!Objects.equal(opposite, null));
    if (_notEquals) {
      return this._typeChecker.isCollection(opposite.getType());
    }
    return false;
  }
  
  /**
   * Método encargado de buscar el atributo opuesto de una relación, para el caso
   * en el que el atributo no defina la sentencia <code><strong>opposite</strong></code>
   * 
   * @param a Es el atributo del cual se quiere saber el opuesto
   * 
   * @return El atributo opuesto de la relación
   */
  public Attribute searchOpposite(final Attribute a) {
    Attribute opposite = null;
    Type _type = a.getType();
    if ((_type instanceof ParameterizedType)) {
      Type _type_1 = a.getType();
      Iterable<Feature> _features = this.getFeatures(this.getTypeSpecification(((ParameterizedType) _type_1).getTypeParameters().get(0)));
      for (final Feature feature : _features) {
        if ((feature instanceof Attribute)) {
          if (((!Objects.equal(((Attribute)feature).getOpposite(), null)) && ((Attribute)feature).getOpposite().getName().equals(a.getName()))) {
            opposite = ((Attribute)feature);
          }
        }
      }
    } else {
      Iterable<Feature> _features_1 = this.getFeatures(this.getTypeSpecification(a.getType()));
      for (final Feature feature_1 : _features_1) {
        if ((feature_1 instanceof Attribute)) {
          if (((!Objects.equal(((Attribute)feature_1).getOpposite(), null)) && ((Attribute)feature_1).getOpposite().getName().equals(a.getName()))) {
            opposite = ((Attribute)feature_1);
          }
        }
      }
    }
    return opposite;
  }
  
  /**
   * Este método obtiene los statements de tipo Show de un Block
   */
  public Iterable<Show> getShowStatements(final EObject statement) {
    return IteratorExtensions.<Show>toIterable(Iterators.<Show>filter(statement.eAllContents(), Show.class));
  }
  
  /**
   * Este método obtiene las acciones que contienen acciones de tipo show invocadas en una página determinada
   */
  public Iterable<Action> getShowActions(final Page page) {
    final ArrayList<Action> showActions = new ArrayList<Action>();
    final Function1<ViewInstance, Boolean> _function = (ViewInstance x) -> {
      ActionCall _actionCall = x.getActionCall();
      return Boolean.valueOf((!Objects.equal(_actionCall, null)));
    };
    final Function1<ViewInstance, Action> _function_1 = (ViewInstance x) -> {
      return this.getAction(x.getActionCall());
    };
    final Iterable<Action> actions = IteratorExtensions.<Action>toIterable(IteratorExtensions.<ViewInstance, Action>map(IteratorExtensions.<ViewInstance>filter(Iterators.<ViewInstance>filter(page.eAllContents(), ViewInstance.class), _function), _function_1));
    for (final Action action : actions) {
      boolean _isEmpty = IteratorExtensions.isEmpty(Iterators.<Show>filter(action.eAllContents(), Show.class));
      boolean _not = (!_isEmpty);
      if (_not) {
        showActions.add(action);
      }
    }
    return showActions;
  }
  
  public EList<Page> getControlledPages(final Controller controller) {
    Set<Page> allPages = null;
    EList<Page> controlledPages = new BasicEList<Page>();
    LinkedHashSet<Page> _linkedHashSet = new LinkedHashSet<Page>();
    allPages = _linkedHashSet;
    EObject _eContainer = controller.eContainer().eContainer();
    allPages.addAll(
      this.<Page>getAllInstances(((InformationSystem) _eContainer).eResource().getResourceSet(), Page.class));
    for (final Page page : allPages) {
      Controller _controller = page.getController();
      boolean _tripleNotEquals = (_controller != null);
      if (_tripleNotEquals) {
        boolean _equals = page.getController().getName().equals(controller.getName());
        if (_equals) {
          controlledPages.add(page);
        }
      }
    }
    return controlledPages;
  }
  
  public String getCollectionString(final Type type) {
    boolean _equals = this.getTypeSpecification(type).getName().equals("Collection");
    if (_equals) {
      return "List";
    } else {
      return this.getTypeSpecification(type).getName();
    }
  }
  
  public boolean evaluateCardinality(final Attribute a) {
    boolean flag = false;
    Type _type = a.getType();
    if ((_type instanceof ParameterizedType)) {
      Type _type_1 = a.getType();
      TypeSpecification _typeSpecification = this.getTypeSpecification(((ParameterizedType) _type_1).getTypeParameters().get(0));
      flag = (_typeSpecification instanceof Entity);
    } else {
      TypeSpecification _typeSpecification_1 = this.getTypeSpecification(a.getType());
      flag = (_typeSpecification_1 instanceof Entity);
    }
    return flag;
  }
  
  public CharSequence associationAnnotation(final Attribute a) {
    boolean _evaluateCardinality = this.evaluateCardinality(a);
    if (_evaluateCardinality) {
      boolean _isCollection = this._typeChecker.isCollection(a.getType());
      if (_isCollection) {
        Attribute _opposite = a.getOpposite();
        boolean _notEquals = (!Objects.equal(_opposite, null));
        if (_notEquals) {
          boolean _isCollection_1 = this._typeChecker.isCollection(a.getOpposite().getType());
          if (_isCollection_1) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("@ManyToMany(mappedBy = \"");
            String _name = a.getOpposite().getName();
            _builder.append(_name);
            _builder.append("\")");
            return _builder;
          } else {
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("@OneToMany(mappedBy = \"");
            String _name_1 = a.getOpposite().getName();
            _builder_1.append(_name_1);
            _builder_1.append("\")");
            return _builder_1;
          }
        } else {
          final Attribute opposite = this.searchOpposite(a);
          boolean _notEquals_1 = (!Objects.equal(opposite, null));
          if (_notEquals_1) {
            boolean _isCollection_2 = this._typeChecker.isCollection(opposite.getType());
            if (_isCollection_2) {
              StringConcatenation _builder_2 = new StringConcatenation();
              _builder_2.append("@ManyToMany");
              return _builder_2;
            } else {
              StringConcatenation _builder_3 = new StringConcatenation();
              _builder_3.append("@OneToMany(mappedBy = \"");
              String _name_2 = this.searchOpposite(a).getName();
              _builder_3.append(_name_2);
              _builder_3.append("\")");
              return _builder_3;
            }
          }
        }
      } else {
        Attribute _opposite_1 = a.getOpposite();
        boolean _notEquals_2 = (!Objects.equal(_opposite_1, null));
        if (_notEquals_2) {
          boolean _isCollection_3 = this._typeChecker.isCollection(a.getOpposite().getType());
          if (_isCollection_3) {
            StringConcatenation _builder_4 = new StringConcatenation();
            _builder_4.append("@ManyToOne");
            return _builder_4;
          } else {
            StringConcatenation _builder_5 = new StringConcatenation();
            _builder_5.append("@OneToOne(mappedBy=\"");
            String _name_3 = a.getOpposite().getName();
            _builder_5.append(_name_3);
            _builder_5.append("\")");
            return _builder_5;
          }
        } else {
          boolean _isCollection_4 = this._typeChecker.isCollection(this.searchOpposite(a).getType());
          if (_isCollection_4) {
            StringConcatenation _builder_6 = new StringConcatenation();
            _builder_6.append("@ManyToOne");
            return _builder_6;
          } else {
            StringConcatenation _builder_7 = new StringConcatenation();
            _builder_7.append("@OneToOne");
            return _builder_7;
          }
        }
      }
    }
    return null;
  }
  
  public String writeType(final Type type, final boolean complete) {
    String typeString = "";
    boolean _isCollection = this._typeChecker.isCollection(type);
    boolean _not = (!_isCollection);
    if (_not) {
      String _name = this.getTypeSpecification(type).getName();
      if (_name != null) {
        switch (_name) {
          case "Any":
            typeString = "Object";
            break;
          case "Type":
            typeString = this.getClassValue(type);
            break;
          case "Void":
            typeString = "void";
            break;
          case "Null":
            typeString = "null";
            break;
          case "Integer":
            typeString = "Long";
            break;
          default:
            typeString = this.getTypeString(type);
            break;
        }
      } else {
        typeString = this.getTypeString(type);
      }
    } else {
      typeString = this.getCollectionString(type);
      if (((type instanceof ParameterizedType) && (complete == true))) {
        boolean _isEmpty = ((ParameterizedType) type).getTypeParameters().isEmpty();
        if (_isEmpty) {
          String _typeString = typeString;
          typeString = (_typeString + "<Object>");
        } else {
          String _typeString_1 = typeString;
          String _writeType = this.writeType(((ParameterizedType) type).getTypeParameters().get(0), complete);
          String _plus = ("<" + _writeType);
          String _plus_1 = (_plus + ">");
          typeString = (_typeString_1 + _plus_1);
          TypeSpecification _typeSpecification = this.getTypeSpecification(((ParameterizedType) type).getTypeParameters().get(0));
          if ((_typeSpecification instanceof GenericTypeSpecification)) {
            EObject _eContainer = type.eContainer();
            if ((_eContainer instanceof Function)) {
              EObject _findAnyAncestor = this.findAnyAncestor(type.eContainer(), TypeSpecification.class);
              TypeSpecification ser = ((TypeSpecification) _findAnyAncestor);
              boolean _isEmpty_1 = ser.getGenericTypeParameters().isEmpty();
              if (_isEmpty_1) {
                TypeSpecification _typeSpecification_1 = this.getTypeSpecification(((ParameterizedType) type).getTypeParameters().get(0));
                String _plus_2 = ("<" + _typeSpecification_1);
                String _plus_3 = (_plus_2 + 
                  ">");
                String _plus_4 = (_plus_3 + typeString);
                typeString = _plus_4;
              }
            }
          }
        }
      } else {
        if ((complete == true)) {
          String _typeString_2 = typeString;
          typeString = (_typeString_2 + "<Object>");
        }
      }
    }
    return typeString;
  }
  
  public String getClassValue(final Type type) {
    if ((type instanceof Primitive)) {
      boolean _isEmpty = ((Primitive)type).getGenericTypeParameters().isEmpty();
      if (_isEmpty) {
        return "Class<?>";
      } else {
        return "Class<T>";
      }
    }
    return null;
  }
  
  public String getTypeString(final Type t) {
    if (((this.getTypeSpecification(t) instanceof GenericTypeSpecification) && (!(t.eContainer() instanceof ParameterizedType)))) {
      String str = "";
      EObject _eContainer = t.eContainer();
      if ((_eContainer instanceof Function)) {
        str = "";
        EObject _findAnyAncestor = this.findAnyAncestor(t.eContainer(), TypeSpecification.class);
        TypeSpecification ser = ((TypeSpecification) _findAnyAncestor);
        boolean _isEmpty = ser.getGenericTypeParameters().isEmpty();
        if (_isEmpty) {
          String _name = this.getTypeSpecification(t).getName();
          String _plus = ("<" + _name);
          String _plus_1 = (_plus + ">");
          String _name_1 = this.getTypeSpecification(t).getName();
          String _plus_2 = (_plus_1 + _name_1);
          str = _plus_2;
        } else {
          str = this.getTypeSpecification(t).getName();
        }
      } else {
        str = this.getTypeSpecification(t).getName();
      }
      return str;
    } else {
      return StringExtensions.toFirstUpper(this.getTypeSpecification(t).getName());
    }
  }
  
  public Map<String, Object> getNeededAttributes(final Controller controller) {
    Map<String, Object> returnData = new HashMap<String, Object>();
    Map<String, Type> neededAttributes = new HashMap<String, Type>();
    this.retrieveControllerEntity(controller, returnData);
    EList<Page> controlledPages = this.getControlledPages(controller);
    for (final Page page : controlledPages) {
      EList<Parameter> _parameters = page.getParameters();
      for (final Parameter param : _parameters) {
        boolean _containsKey = neededAttributes.containsKey(param.getName());
        boolean _not = (!_containsKey);
        if (_not) {
          neededAttributes.put(param.getName(), param.getType());
        }
      }
    }
    returnData.put("neededAttributes", neededAttributes);
    return returnData;
  }
  
  public Object retrieveControllerEntity(final Controller controller, final Map<String, Object> returnData) {
    Object _xblockexpression = null;
    {
      EList<Entity> controllerEntities = new BasicEList<Entity>();
      EList<Page> controlledPages = this.getControlledPages(controller);
      for (final Page page : controlledPages) {
        EList<Parameter> _parameters = page.getParameters();
        for (final Parameter param : _parameters) {
          Type _type = param.getType();
          TypeSpecification _typeSpecification = null;
          if (_type!=null) {
            _typeSpecification=this.getTypeSpecification(_type);
          }
          if ((_typeSpecification instanceof Entity)) {
            TypeSpecification _typeSpecification_1 = this.getTypeSpecification(param.getType());
            controllerEntities.add(((Entity) _typeSpecification_1));
          } else {
            Type _type_1 = param.getType();
            if ((_type_1 instanceof ParameterizedType)) {
              Type _type_2 = param.getType();
              TypeSpecification _typeSpecification_2 = this.getTypeSpecification(((ParameterizedType) _type_2).getTypeParameters().get(0));
              if ((_typeSpecification_2 instanceof Entity)) {
                Type _type_3 = param.getType();
                TypeSpecification _typeSpecification_3 = this.getTypeSpecification(((ParameterizedType) _type_3).getTypeParameters().get(0));
                returnData.put("entityToList", 
                  ((Entity) _typeSpecification_3));
                Type _type_4 = param.getType();
                returnData.put("selectedRegisters", ((ParameterizedType) _type_4));
              }
            }
          }
        }
      }
      _xblockexpression = returnData.put("controllerEntities", controllerEntities);
    }
    return _xblockexpression;
  }
  
  public EList<Parameter> evaluateParameters(final EList<Parameter> parameters, final Map<String, Type> neededAttibutes) {
    EList<Parameter> newList = new BasicEList<Parameter>();
    for (final Parameter param : parameters) {
      boolean _containsKey = neededAttibutes.containsKey(param.getName());
      boolean _not = (!_containsKey);
      if (_not) {
        newList.add(param);
      }
    }
    return newList;
  }
  
  public Map<QualifiedName, TypeSpecification> getNeededImportsInActions(final Controller controller) {
    Map<QualifiedName, TypeSpecification> imports = new HashMap<QualifiedName, TypeSpecification>();
    Iterable<Action> _actions = this.getActions(controller);
    for (final Action action : _actions) {
      {
        if (((!Objects.equal(action.getType(), null)) && 
          (!this._qualifiedNameProvider.getFullyQualifiedName(this.getTypeSpecification(action.getType()).eContainer()).equals(
            this._qualifiedNameProvider.getFullyQualifiedName(controller.eContainer()))))) {
          TypeSpecification _typeSpecification = this.getTypeSpecification(action.getType());
          boolean _not = (!(_typeSpecification instanceof Primitive));
          if (_not) {
            boolean _containsKey = imports.containsKey(this._qualifiedNameProvider.getFullyQualifiedName(this.getTypeSpecification(action.getType())));
            boolean _not_1 = (!_containsKey);
            if (_not_1) {
              imports.put(this._qualifiedNameProvider.getFullyQualifiedName(this.getTypeSpecification(action.getType())), this.getTypeSpecification(action.getType()));
            }
          }
        }
        EList<Parameter> _parameters = action.getParameters();
        for (final Parameter param : _parameters) {
          boolean _isCollection = this._typeChecker.isCollection(param.getType());
          boolean _not_2 = (!_isCollection);
          if (_not_2) {
            boolean _equals = this._qualifiedNameProvider.getFullyQualifiedName(this.getTypeSpecification(param.getType()).eContainer()).equals(
              this._qualifiedNameProvider.getFullyQualifiedName(controller.eContainer()));
            boolean _not_3 = (!_equals);
            if (_not_3) {
              TypeSpecification _typeSpecification_1 = this.getTypeSpecification(param.getType());
              boolean _not_4 = (!(_typeSpecification_1 instanceof Primitive));
              if (_not_4) {
                boolean _containsKey_1 = imports.containsKey(this._qualifiedNameProvider.getFullyQualifiedName(this.getTypeSpecification(param.getType())));
                boolean _not_5 = (!_containsKey_1);
                if (_not_5) {
                  imports.put(this._qualifiedNameProvider.getFullyQualifiedName(this.getTypeSpecification(param.getType())), 
                    this.getTypeSpecification(param.getType()));
                }
              }
            }
          } else {
            Type _type = param.getType();
            if ((_type instanceof ParameterizedType)) {
              Type _type_1 = param.getType();
              boolean _equals_1 = this._qualifiedNameProvider.getFullyQualifiedName(this.getTypeSpecification(((ParameterizedType) _type_1).getTypeParameters().get(0)).eContainer()).equals(this._qualifiedNameProvider.getFullyQualifiedName(controller.eContainer()));
              boolean _not_6 = (!_equals_1);
              if (_not_6) {
                Type _type_2 = param.getType();
                TypeSpecification _typeSpecification_2 = this.getTypeSpecification(((ParameterizedType) _type_2).getTypeParameters().get(0));
                boolean _not_7 = (!(_typeSpecification_2 instanceof Primitive));
                if (_not_7) {
                  Type _type_3 = param.getType();
                  boolean _containsKey_2 = imports.containsKey(
                    this._qualifiedNameProvider.getFullyQualifiedName(this.getTypeSpecification(((ParameterizedType) _type_3).getTypeParameters().get(0))));
                  boolean _not_8 = (!_containsKey_2);
                  if (_not_8) {
                    Type _type_4 = param.getType();
                    Type _type_5 = param.getType();
                    TypeSpecification _typeSpecification_3 = this.getTypeSpecification(((ParameterizedType) _type_5).getTypeParameters().get(0));
                    imports.put(
                      this._qualifiedNameProvider.getFullyQualifiedName(this.getTypeSpecification(((ParameterizedType) _type_4).getTypeParameters().get(0))), 
                      ((Entity) _typeSpecification_3));
                  }
                }
              }
            }
          }
        }
        EList<MethodStatement> _body = action.getBody();
        for (final MethodStatement stmnt : _body) {
          this.isNeededImportInBody(IteratorExtensions.<EObject>toList(stmnt.eAllContents()), imports, controller);
        }
      }
    }
    return imports;
  }
  
  public void isNeededImportInBody(final List<EObject> allContents, final Map<QualifiedName, TypeSpecification> imports, final TypeSpecification controller) {
    for (final EObject obj : allContents) {
      {
        if (((obj instanceof TypedElement) && 
          (!(this.getTypeSpecification(((TypedElement) obj).getType()) instanceof Primitive)))) {
          boolean _equals = this._qualifiedNameProvider.getFullyQualifiedName(this.getTypeSpecification(((TypedElement) obj).getType()).eContainer()).equals(
            this._qualifiedNameProvider.getFullyQualifiedName(controller.eContainer()));
          boolean _not = (!_equals);
          if (_not) {
            boolean _containsKey = imports.containsKey(this._qualifiedNameProvider.getFullyQualifiedName(this.getTypeSpecification(((TypedElement) obj).getType())));
            boolean _not_1 = (!_containsKey);
            if (_not_1) {
              imports.put(this._qualifiedNameProvider.getFullyQualifiedName(this.getTypeSpecification(((TypedElement) obj).getType())), 
                this.getTypeSpecification(((TypedElement) obj).getType()));
            }
          }
        } else {
          if ((((obj instanceof Reference) && 
            (((Reference) obj).getReferencedElement() instanceof TypeSpecification)) && 
            (!(((Reference) obj).getReferencedElement() instanceof Primitive)))) {
            NamedElement _referencedElement = ((Reference) obj).getReferencedElement();
            boolean _equals_1 = this._qualifiedNameProvider.getFullyQualifiedName(((TypeSpecification) _referencedElement).eContainer()).equals(this._qualifiedNameProvider.getFullyQualifiedName(controller.eContainer()));
            boolean _not_2 = (!_equals_1);
            if (_not_2) {
              NamedElement _referencedElement_1 = ((Reference) obj).getReferencedElement();
              boolean _containsKey_1 = imports.containsKey(
                this._qualifiedNameProvider.getFullyQualifiedName(((TypeSpecification) _referencedElement_1)));
              boolean _not_3 = (!_containsKey_1);
              if (_not_3) {
                NamedElement _referencedElement_2 = ((Reference) obj).getReferencedElement();
                NamedElement _referencedElement_3 = ((Reference) obj).getReferencedElement();
                imports.put(this._qualifiedNameProvider.getFullyQualifiedName(((TypeSpecification) _referencedElement_2).eContainer()), ((TypeSpecification) _referencedElement_3));
              }
            }
          }
        }
        this.isNeededImportInBody(IteratorExtensions.<EObject>toList(obj.eAllContents()), imports, controller);
      }
    }
  }
  
  public Controller getControllerIfExists(final EObject actionCall) {
    Controller c = null;
    EObject tmp = actionCall;
    while (((!Objects.equal(tmp, null)) && Objects.equal(c, null))) {
      {
        if (((!Objects.equal(tmp.eContainer(), null)) && (tmp.eContainer() instanceof Controller))) {
          EObject _eContainer = tmp.eContainer();
          c = ((Controller) _eContainer);
        }
        tmp = tmp.eContainer();
      }
    }
    return c;
  }
  
  public EList<Expression> validateParameterForActionCall(final ActionCall action) {
    EList<Expression> finalList = new BasicEList<Expression>();
    Controller c = this.getControllerIfExists(action.getReferencedElement());
    boolean _notEquals = (!Objects.equal(c, null));
    if (_notEquals) {
      Object _get = this.getNeededAttributes(c).get(
        "neededAttributes");
      Map<String, Type> controllerAttributes = ((Map<String, Type>) _get);
      EList<Expression> _parameters = action.getParameters();
      for (final Expression parameter : _parameters) {
        if (((!(parameter instanceof VariableReference)) || ((parameter instanceof VariableReference) && 
          (!controllerAttributes.containsKey(
            ((VariableReference) parameter).getReferencedElement().getName()))))) {
          finalList.add(parameter);
        }
      }
    }
    return finalList;
  }
  
  public int getRows(final ViewInstance viewInstance) {
    Expression rows = this.getParameter(viewInstance, "rows");
    if ((rows instanceof LiteralValue)) {
      Object _literal = ((LiteralValue)rows).getLiteral();
      return (((Integer) _literal)).intValue();
    }
    return 0;
  }
  
  public Type getTailType(final Reference reference) {
    Reference tmp = reference;
    while ((!Objects.equal(tmp.getTail(), null))) {
      tmp = tmp.getTail();
    }
    return this.<NamedElement, TypedElement>cast(tmp.getReferencedElement(), TypedElement.class).getType();
  }
  
  protected List<Object> _evaluateToCast(final Variable assignment) {
    List<Object> returnData = new ArrayList<Object>();
    Boolean doCast = Boolean.valueOf(false);
    Type castTo = null;
    Expression _value = assignment.getValue();
    if ((_value instanceof Reference)) {
      Expression _value_1 = assignment.getValue();
      Reference value = ((Reference) _value_1);
      boolean _equals = this.getTypeSpecification(this.getTailType(value)).getName().equals(this.getTypeSpecification(assignment.getType()).getName());
      boolean _not = (!_equals);
      if (_not) {
        doCast = Boolean.valueOf(true);
        castTo = assignment.getType();
        returnData.add(doCast);
        returnData.add(castTo);
      }
    }
    return returnData;
  }
  
  protected List<Object> _evaluateToCast(final Assignment assignment) {
    List<Object> returnData = new ArrayList<Object>();
    Boolean doCast = Boolean.valueOf(false);
    Type castTo = null;
    if (((assignment.getRight() instanceof Reference) && (assignment.getLeft() instanceof Reference))) {
      Expression _right = assignment.getRight();
      Reference rightRef = ((Reference) _right);
      Expression _left = assignment.getLeft();
      Reference leftRef = ((Reference) _left);
      boolean _equals = this.getTypeSpecification(this.getTailType(rightRef)).getName().equals(
        this.getTypeSpecification(this.getTailType(leftRef)).getName());
      boolean _not = (!_equals);
      if (_not) {
        doCast = Boolean.valueOf(true);
        castTo = this.getTailType(leftRef);
        returnData.add(doCast);
        returnData.add(castTo);
      }
    } else {
      if (((assignment.getRight() instanceof Reference) && (assignment.getLeft() instanceof Variable))) {
        Expression _right_1 = assignment.getRight();
        Reference rightRef_1 = ((Reference) _right_1);
        Expression _left_1 = assignment.getLeft();
        Variable leftRef_1 = ((Variable) _left_1);
        boolean _equals_1 = this.getTypeSpecification(this.getTailType(rightRef_1)).getName().equals(this.getTypeSpecification(leftRef_1.getType()).getName());
        boolean _not_1 = (!_equals_1);
        if (_not_1) {
          doCast = Boolean.valueOf(true);
          castTo = leftRef_1.getType();
          returnData.add(doCast);
          returnData.add(castTo);
        }
      }
    }
    return returnData;
  }
  
  /**
   * Este metodo obtiene recursivamente la acción a la cual pertenece un statement
   */
  public Action getActionRecursivelly(final EObject eContainer) {
    if ((eContainer instanceof Action)) {
      return ((Action)eContainer);
    } else {
      return this.getActionRecursivelly(eContainer.eContainer());
    }
  }
  
  public String getTypeSpecificationString(final TypeSpecification specification) {
    if (((specification instanceof Primitive) && specification.getName().equalsIgnoreCase("Integer"))) {
      return "Long";
    } else {
      if (((specification instanceof Primitive) && 
        specification.getName().equalsIgnoreCase("BytesArray"))) {
        return "byte[]";
      } else {
        if (((specification instanceof Primitive) && specification.getName().equalsIgnoreCase("Any"))) {
          return "Object";
        } else {
          return specification.getName();
        }
      }
    }
  }
  
  public String getFullName(final Type t) {
    String name = "";
    String _name = name;
    TypeSpecification _typeSpecification = this.getTypeSpecification(t);
    QualifiedName _fullyQualifiedName = null;
    if (_typeSpecification!=null) {
      _fullyQualifiedName=this._qualifiedNameProvider.getFullyQualifiedName(_typeSpecification);
    }
    name = (_name + _fullyQualifiedName);
    if ((t instanceof ParameterizedType)) {
      String _name_1 = name;
      name = (_name_1 + "<");
      EList<Type> _typeParameters = ((ParameterizedType)t).getTypeParameters();
      for (final Type typeParam : _typeParameters) {
        String _name_2 = name;
        String _fullName = this.getFullName(typeParam);
        name = (_name_2 + _fullName);
      }
      String _name_3 = name;
      name = (_name_3 + ">");
    }
    return name;
  }
  
  public Type getReplacedType(final TypeSpecification service, final Type type) {
    TypeSpecification _typeSpecification = this.getTypeSpecification(type);
    if ((_typeSpecification instanceof GenericTypeSpecification)) {
      boolean _isEmpty = service.getGenericTypeParameters().isEmpty();
      if (_isEmpty) {
        boolean _isEmpty_1 = this.getTypeSpecification(service.getSuperTypes().get(0)).getGenericTypeParameters().isEmpty();
        if (_isEmpty_1) {
          return type;
        } else {
          int i = 0;
          EList<GenericTypeSpecification> _genericTypeParameters = this.getTypeSpecification(service.getSuperTypes().get(0)).getGenericTypeParameters();
          for (final GenericTypeSpecification param : _genericTypeParameters) {
            {
              boolean _equals = param.getName().equals(this.getTypeSpecification(type).getName());
              if (_equals) {
                Type _get = service.getSuperTypes().get(0);
                if ((_get instanceof ParameterizedType)) {
                  Type _get_1 = service.getSuperTypes().get(0);
                  boolean _isEmpty_2 = ((ParameterizedType) _get_1).getTypeParameters().isEmpty();
                  boolean _not = (!_isEmpty_2);
                  if (_not) {
                    Type _get_2 = service.getSuperTypes().get(0);
                    return ((ParameterizedType) _get_2).getTypeParameters().get(i);
                  }
                }
              }
              i++;
            }
          }
          return type;
        }
      }
    } else {
      boolean _isCollection = this._typeChecker.isCollection(type);
      if (_isCollection) {
        boolean _isEmpty_2 = service.getGenericTypeParameters().isEmpty();
        if (_isEmpty_2) {
          boolean _isEmpty_3 = service.getSuperTypes().isEmpty();
          boolean _not = (!_isEmpty_3);
          if (_not) {
            boolean _isEmpty_4 = this.getTypeSpecification(service.getSuperTypes().get(0)).getGenericTypeParameters().isEmpty();
            if (_isEmpty_4) {
              return type;
            } else {
              int i_1 = 0;
              EList<GenericTypeSpecification> _genericTypeParameters_1 = this.getTypeSpecification(service.getSuperTypes().get(0)).getGenericTypeParameters();
              for (final GenericTypeSpecification param_1 : _genericTypeParameters_1) {
                {
                  boolean _equals = param_1.getName().equals(
                    this.getTypeSpecification(((ParameterizedType) type).getTypeParameters().get(0)).getName());
                  if (_equals) {
                    Type _get = service.getSuperTypes().get(0);
                    if ((_get instanceof ParameterizedType)) {
                      ParameterizedType typ = ((ParameterizedType) type);
                      Type _get_1 = service.getSuperTypes().get(0);
                      boolean _isEmpty_5 = ((ParameterizedType) _get_1).getTypeParameters().isEmpty();
                      boolean _not_1 = (!_isEmpty_5);
                      if (_not_1) {
                        EList<Type> l = new BasicEList<Type>();
                        Type _get_2 = service.getSuperTypes().get(0);
                        l.addAll(
                          ((ParameterizedType) _get_2).getTypeParameters());
                        Type _get_3 = typ.getTypeParameters().get(i_1);
                        Type _get_4 = service.getSuperTypes().get(0);
                        this.setTypeSpecification(_get_3, this.getTypeSpecification(((ParameterizedType) _get_4).getTypeParameters().get(i_1)));
                        return typ;
                      }
                    }
                  }
                  i_1++;
                }
              }
              return type;
            }
          }
        }
      }
    }
    return type;
  }
  
  public <S extends EObject, T extends S> T cast(final S obj, final Class<T> c) {
    return ((T) obj);
  }
  
  public EList<NamedElement> getComponents(final InformationSystem is) {
    return is.getBody();
  }
  
  public EList<NamedElement> getComponents(final co.edu.javeriana.isml.isml.Package p) {
    return p.getBody();
  }
  
  public boolean isUniqueStatement(final EObject obj) {
    final EObject container = obj.eContainer();
    final EStructuralFeature containingFeature = obj.eContainingFeature();
    int _upperBound = containingFeature.getUpperBound();
    boolean _equals = (_upperBound == 1);
    if (_equals) {
      return true;
    } else {
      Object _eGet = container.eGet(containingFeature);
      final Collection<?> list = ((Collection<?>) _eGet);
      int _size = list.size();
      return (_size == 1);
    }
  }
  
  public boolean isSubtypeOf(final Type t1, final Type t2) {
    if (t1 instanceof ParameterizedType
         && t2 instanceof ParameterizedType) {
      return _isSubtypeOf((ParameterizedType)t1, (ParameterizedType)t2);
    } else if (t1 != null
         && t2 != null) {
      return _isSubtypeOf(t1, t2);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t1, t2).toString());
    }
  }
  
  public Set<TypedElement> getAllFeatures(final Element c) {
    if (c instanceof Controller) {
      return _getAllFeatures((Controller)c);
    } else if (c instanceof CompositeTypeSpecification) {
      return _getAllFeatures((CompositeTypeSpecification<?>)c);
    } else if (c instanceof Primitive) {
      return _getAllFeatures((Primitive)c);
    } else if (c instanceof Type) {
      return _getAllFeatures((Type)c);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(c).toString());
    }
  }
  
  public View getView(final Instance obj) {
    if (obj instanceof ViewInstance) {
      return _getView((ViewInstance)obj);
    } else if (obj != null) {
      return _getView(obj);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(obj).toString());
    }
  }
  
  public List<Object> evaluateToCast(final MethodStatement assignment) {
    if (assignment instanceof Variable) {
      return _evaluateToCast((Variable)assignment);
    } else if (assignment instanceof Assignment) {
      return _evaluateToCast((Assignment)assignment);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(assignment).toString());
    }
  }
}
