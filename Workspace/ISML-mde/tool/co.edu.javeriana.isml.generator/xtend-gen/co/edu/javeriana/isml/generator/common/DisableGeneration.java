package co.edu.javeriana.isml.generator.common;

import co.edu.javeriana.isml.generator.common.SimpleGenerator;
import co.edu.javeriana.isml.generator.common.SimpleTemplate;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public class DisableGeneration extends SimpleGenerator<EObject> {
  private Class<? extends EObject> disabledClass;
  
  public DisableGeneration(final Class<? extends EObject> c) {
    this.disabledClass = c;
  }
  
  @Override
  protected String getFileName(final EObject e) {
    return null;
  }
  
  @Override
  protected String getOutputConfigurationName() {
    return null;
  }
  
  @Override
  public SimpleTemplate<EObject> getTemplate() {
    return null;
  }
  
  @Override
  public boolean isActive() {
    return false;
  }
  
  @Override
  public Class<? extends EObject> getInputClass() {
    return this.disabledClass;
  }
}
