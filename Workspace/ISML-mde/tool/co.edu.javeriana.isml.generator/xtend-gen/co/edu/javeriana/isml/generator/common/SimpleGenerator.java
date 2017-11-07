package co.edu.javeriana.isml.generator.common;

import co.edu.javeriana.isml.generator.Activator;
import co.edu.javeriana.isml.generator.common.GeneratorSuite;
import co.edu.javeriana.isml.generator.common.SimpleTemplate;
import com.google.common.base.Objects;
import com.google.inject.Injector;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public abstract class SimpleGenerator<T extends Object> {
  private Injector injector = Activator.getInjector();
  
  private GeneratorSuite generatorSuite;
  
  @Extension
  private SimpleTemplate<T> template;
  
  public SimpleGenerator() {
    this.template = this.getTemplate();
    boolean _notEquals = (!Objects.equal(this.template, null));
    if (_notEquals) {
      this.injector.injectMembers(this.template);
    }
  }
  
  public void execute(final T element, final IFileSystemAccess fsa) {
    boolean _isActive = this.isActive();
    if (_isActive) {
      final T elementT = ((T) element);
      fsa.generateFile(this.getFileName(elementT), this.getFullOutputConfigurationName(), this.template.toText(elementT));
      String _name = element.getClass().getName();
      String _plus = ("Generated " + _name);
      String _plus_1 = (_plus + " with ");
      String _simpleName = this.getClass().getSimpleName();
      String _plus_2 = (_plus_1 + _simpleName);
      System.err.println(_plus_2);
    }
  }
  
  protected String getFullOutputConfigurationName() {
    String _name = this.getGeneratorSuite().getClass().getName();
    String _plus = (_name + ".");
    String _outputConfigurationName = this.getOutputConfigurationName();
    return (_plus + _outputConfigurationName);
  }
  
  protected boolean isActive() {
    return true;
  }
  
  public Class<?> getInputClass() {
    return this.findClass(this.getInputType());
  }
  
  public Class<?> findClass(final Type inputType) {
    boolean _matched = false;
    if (inputType instanceof Class) {
      _matched=true;
      return ((Class<?>)inputType);
    }
    if (!_matched) {
      if (inputType instanceof ParameterizedType) {
        _matched=true;
        return this.findClass(((ParameterizedType)inputType).getRawType());
      }
    }
    return null;
  }
  
  public Type getInputType() {
    Type _genericSuperclass = this.getClass().getGenericSuperclass();
    final ParameterizedType superType = ((ParameterizedType) _genericSuperclass);
    return superType.getActualTypeArguments()[0];
  }
  
  public GeneratorSuite getGeneratorSuite() {
    return this.generatorSuite;
  }
  
  public GeneratorSuite setGeneratorSuite(final GeneratorSuite gs) {
    return this.generatorSuite = gs;
  }
  
  protected abstract String getFileName(final T e);
  
  protected abstract String getOutputConfigurationName();
  
  public abstract SimpleTemplate<T> getTemplate();
}
