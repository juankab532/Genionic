package co.edu.javeriana.generator.genionic.backend

import co.edu.javeriana.isml.generator.common.GeneratorSuite
import co.edu.javeriana.isml.generator.common.OutputConfiguration
import co.edu.javeriana.generator.genionic.backend.generators.EntityGenerator
import co.edu.javeriana.generator.genionic.backend.generators.ServiceInterfaceGenerator
import co.edu.javeriana.generator.genionic.backend.generators.ServiceGenerator

class BackendGenerator extends GeneratorSuite {
	
	@OutputConfiguration
	public static final String ENTITIES = "entities";
	
	@OutputConfiguration
	public static final String SERVICE_IMPL = "service"
	
	@OutputConfiguration
	public static final String SERVICE_INTERFACE = "service.interface"
	
	override getGenerators() {
		#{
			new EntityGenerator,
			new ServiceInterfaceGenerator,
			new ServiceGenerator
		}
	}
	
}