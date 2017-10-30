package co.edu.javeriana.generator.genionic

import co.edu.javeriana.isml.generator.common.GeneratorSuite
import co.edu.javeriana.isml.generator.common.OutputConfiguration
import co.edu.javeriana.generator.genionic.generators.PageGenerator;
import co.edu.javeriana.generator.genionic.generators.ControllerGenerator;
import co.edu.javeriana.generator.genionic.generators.CssGenerator;
import co.edu.javeriana.generator.genionic.generators.ModuleGenerator;
import co.edu.javeriana.generator.genionic.generators.ModelGenerator;
import co.edu.javeriana.generator.genionic.generators.Conf1Generator;
import co.edu.javeriana.generator.genionic.generators.ComponentGenerator;

class GenionicGenerator  extends GeneratorSuite {
	
	@OutputConfiguration
	public static final String VIEWS = "frontend.views";
	
	@OutputConfiguration
	public static final String CONTROLLERS = "frontend.controllers"
	
	@OutputConfiguration
	public static final String CONF1 = "frontend.conf1"
	
	@OutputConfiguration
	public static final String COMPONENT = "frontend.component"
	
	@OutputConfiguration
	public static final String CSS = "frontend.css"
	
	@OutputConfiguration
	public static final String MODULES = "frontend.module"
	
	@OutputConfiguration
	public static final String MODEL = "frontend.model"
	
	override getGenerators() {
		#{
			new PageGenerator,
			new ControllerGenerator,
			new CssGenerator,
			new ModuleGenerator,
			new ModelGenerator,
			new Conf1Generator,
			new ComponentGenerator
		}
	}
	
	
}