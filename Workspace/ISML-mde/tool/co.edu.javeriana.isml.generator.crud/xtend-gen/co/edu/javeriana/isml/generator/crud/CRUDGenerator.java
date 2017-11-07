package co.edu.javeriana.isml.generator.crud;

import co.edu.javeriana.isml.generator.common.GeneratorSuite;
import co.edu.javeriana.isml.generator.common.OutputConfiguration;
import co.edu.javeriana.isml.generator.common.SimpleGenerator;
import co.edu.javeriana.isml.generator.crud.generators.AddPageGenerator;
import co.edu.javeriana.isml.generator.crud.generators.ControllerGenerator;
import co.edu.javeriana.isml.generator.crud.generators.EditPageGenerator;
import co.edu.javeriana.isml.generator.crud.generators.ListPageGenerator;
import co.edu.javeriana.isml.generator.crud.generators.SelectToAddPageGenerator;
import co.edu.javeriana.isml.generator.crud.generators.SelectToAssignPageGenerator;
import co.edu.javeriana.isml.generator.crud.generators.SubListPageGenerator;
import co.edu.javeriana.isml.generator.crud.generators.ViewPageGenerator;
import java.util.Collections;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * Generates code from your model files on save.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#TutorialCodeGeneration
 */
@SuppressWarnings("all")
public class CRUDGenerator extends GeneratorSuite {
  @OutputConfiguration
  public final static String CONTROLLERS = "controllers";
  
  public final static String PAGES = "pages";
  
  public Set<? extends SimpleGenerator<?>> getGenerators() {
    ControllerGenerator _controllerGenerator = new ControllerGenerator();
    EditPageGenerator _editPageGenerator = new EditPageGenerator();
    ListPageGenerator _listPageGenerator = new ListPageGenerator();
    ViewPageGenerator _viewPageGenerator = new ViewPageGenerator();
    AddPageGenerator _addPageGenerator = new AddPageGenerator();
    SelectToAddPageGenerator _selectToAddPageGenerator = new SelectToAddPageGenerator();
    SelectToAssignPageGenerator _selectToAssignPageGenerator = new SelectToAssignPageGenerator();
    SubListPageGenerator _subListPageGenerator = new SubListPageGenerator();
    return Collections.<SimpleGenerator<?>>unmodifiableSet(CollectionLiterals.<SimpleGenerator<?>>newHashSet(_controllerGenerator, _editPageGenerator, _listPageGenerator, _viewPageGenerator, _addPageGenerator, _selectToAddPageGenerator, _selectToAssignPageGenerator, _subListPageGenerator));
  }
}
