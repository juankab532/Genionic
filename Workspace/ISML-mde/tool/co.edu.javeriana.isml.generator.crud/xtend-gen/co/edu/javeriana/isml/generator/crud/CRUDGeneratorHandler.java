package co.edu.javeriana.isml.generator.crud;

import co.edu.javeriana.generator.OnDemandGeneratorHandler;
import co.edu.javeriana.isml.generator.common.IGeneratorSuite;
import co.edu.javeriana.isml.generator.crud.CRUDGenerator;

@SuppressWarnings("all")
public class CRUDGeneratorHandler extends OnDemandGeneratorHandler {
  public Class<? extends IGeneratorSuite> getGeneratorClass() {
    return CRUDGenerator.class;
  }
}
