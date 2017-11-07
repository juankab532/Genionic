package co.edu.javeriana.isml.generator.common;

import co.edu.javeriana.isml.generator.Activator;
import co.edu.javeriana.isml.generator.common.DisableGeneration;
import co.edu.javeriana.isml.generator.common.IGeneratorSuite;
import co.edu.javeriana.isml.generator.common.SimpleGenerator;
import com.google.common.base.Objects;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.inject.Injector;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public abstract class GeneratorSuite implements IGeneratorSuite {
  private Injector injector = Activator.getInjector();
  
  private Multimap<String, SimpleGenerator<?>> generatorsMap;
  
  private List<SimpleGenerator<?>> multiModelGenerators;
  
  public GeneratorSuite() {
    this.init();
  }
  
  public void init() {
    final Set<? extends SimpleGenerator<?>> childrenList = this.getGenerators();
    this.generatorsMap = LinkedHashMultimap.<String, SimpleGenerator<?>>create();
    ArrayList<SimpleGenerator<?>> _arrayList = new ArrayList<SimpleGenerator<?>>();
    this.multiModelGenerators = _arrayList;
    for (final SimpleGenerator<?> generator : childrenList) {
      {
        this.injector.injectMembers(generator);
        generator.setGeneratorSuite(this);
        final Class<?> inputClass = generator.getInputClass();
        boolean _equals = Objects.equal(inputClass, ResourceSet.class);
        if (_equals) {
          this.multiModelGenerators.add(generator);
        } else {
          boolean _isAssignableFrom = EObject.class.isAssignableFrom(inputClass);
          if (_isAssignableFrom) {
            this.generatorsMap.put(inputClass.getSimpleName(), generator);
          } else {
            boolean _isAssignableFrom_1 = Collection.class.isAssignableFrom(inputClass);
            if (_isAssignableFrom_1) {
              this.multiModelGenerators.add(generator);
            }
          }
        }
      }
    }
  }
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
    final Procedure1<EObject> _function = new Procedure1<EObject>() {
      @Override
      public void apply(final EObject _) {
        GeneratorSuite.this.generate(_, fsa);
      }
    };
    IteratorExtensions.<EObject>forEach(resource.getAllContents(), _function);
  }
  
  private void generate(final EObject element, final IFileSystemAccess fsa) {
    final Collection<SimpleGenerator<?>> gens = this.getGenerators(element);
    final Consumer<SimpleGenerator<?>> _function = new Consumer<SimpleGenerator<?>>() {
      @Override
      public void accept(final SimpleGenerator<?> _) {
        ((SimpleGenerator<EObject>) _).execute(element, fsa);
      }
    };
    gens.forEach(_function);
  }
  
  @Override
  public void doGenerate(final ResourceSet resourceSet, final IFileSystemAccess fsa) {
    for (final SimpleGenerator<?> generator : this.multiModelGenerators) {
      {
        final Class<?> inputClass = generator.getInputClass();
        boolean _equals = Objects.equal(inputClass, ResourceSet.class);
        if (_equals) {
          ((SimpleGenerator<ResourceSet>) generator).execute(resourceSet, fsa);
        } else {
          boolean _isAssignableFrom = Collection.class.isAssignableFrom(inputClass);
          if (_isAssignableFrom) {
            Type _inputType = generator.getInputType();
            Type _get = ((ParameterizedType) _inputType).getActualTypeArguments()[0];
            final Class<?> classToGenerate = ((Class<?>) _get);
            final Function1<Object, Boolean> _function = new Function1<Object, Boolean>() {
              @Override
              public Boolean apply(final Object _) {
                return Boolean.valueOf(classToGenerate.isAssignableFrom(_.getClass()));
              }
            };
            Iterator<Object> itElementsToGenerate = IteratorExtensions.<Object>filter(EcoreUtil.<Object>getAllContents(resourceSet, true), _function);
            ArrayList<Object> elementsToGenerate = Lists.<Object>newArrayList(itElementsToGenerate);
            ((SimpleGenerator<Collection<?>>) generator).execute(elementsToGenerate, fsa);
          }
        }
      }
    }
  }
  
  protected DisableGeneration disableGenerationFor(final Class<? extends EObject> c) {
    return new DisableGeneration(c);
  }
  
  /**
   * Finds all of the Generators that can be applied to element. This includes
   * generators explicitly defined for the element's class and also generators
   * defined for any of the element's superclasses.
   */
  private Collection<SimpleGenerator<?>> getGenerators(final EObject element) {
    final EClass c = element.eClass();
    boolean _equals = c.getName().equals("EObject");
    boolean _not = (!_equals);
    if (_not) {
      Collection<SimpleGenerator<?>> generators = this.getGenerators(c);
      boolean _isEmpty = generators.isEmpty();
      boolean _not_1 = (!_isEmpty);
      if (_not_1) {
        return generators;
      }
      EList<EClass> _eAllSuperTypes = c.getEAllSuperTypes();
      for (final EClass p : _eAllSuperTypes) {
        {
          generators = this.getGenerators(p);
          boolean _isEmpty_1 = generators.isEmpty();
          boolean _not_2 = (!_isEmpty_1);
          if (_not_2) {
            return generators;
          }
        }
      }
    }
    return CollectionLiterals.<SimpleGenerator<?>>emptySet();
  }
  
  /**
   * Finds all of the generators for a given EClass
   */
  private Collection<SimpleGenerator<?>> getGenerators(final EClass c) {
    return this.generatorsMap.get(c.getName());
  }
  
  public abstract Set<? extends SimpleGenerator<?>> getGenerators();
}
