package co.edu.javeriana.isml.generator.common;

import co.edu.javeriana.isml.generator.common.GeneratorSuite;
import co.edu.javeriana.isml.generator.common.Template;

@SuppressWarnings("all")
public abstract class SimpleTemplate<T extends Object> implements Template<T> {
  private GeneratorSuite generatorSuite;
  
  public GeneratorSuite getDispatcher() {
    return this.generatorSuite;
  }
  
  public GeneratorSuite setDispatcher(final GeneratorSuite gs) {
    return this.generatorSuite = gs;
  }
  
  @Override
  public final CharSequence toText(final T e) {
    this.preprocess(e);
    return this.template(e);
  }
  
  /**
   * Gets a string that uniquely identifies this template among all of the
   * SimpleTemplate that belong to a composite template.
   * In this case, the Id is obtained from the simple name of the class,
   * removing the "Template" suffix (if exists).
   */
  @Override
  public final String getId() {
    String name = this.getClass().getSimpleName();
    final int suffixPos = name.lastIndexOf("Template");
    if ((suffixPos != (-1))) {
      name = name.substring(0, suffixPos);
    }
    return name;
  }
  
  protected abstract CharSequence template(final T e);
  
  @Override
  public void preprocess(final T e) {
  }
}
