package co.edu.javeriana.isml.generator.crud.templates;

import co.edu.javeriana.isml.generator.common.SimpleTemplate;
import co.edu.javeriana.isml.generator.crud.templates.CommonTemplates;
import co.edu.javeriana.isml.isml.Entity;
import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class ControllerTemplate extends SimpleTemplate<Entity> {
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Inject
  @Extension
  private CommonTemplates _commonTemplates;
  
  protected CharSequence template(final Entity e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    EObject _eContainer = e.eContainer();
    QualifiedName _fullyQualifiedName = null;
    if (_eContainer!=null) {
      _fullyQualifiedName=this._iQualifiedNameProvider.getFullyQualifiedName(_eContainer);
    }
    _builder.append(_fullyQualifiedName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("controller ");
    CharSequence _controllerName = this._commonTemplates.controllerName(e);
    _builder.append(_controllerName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("has Persistence<");
    String _name = e.getName();
    _builder.append(_name, "\t");
    _builder.append("> persistence;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* Lists all instances of ");
    String _name_1 = e.getName();
    _builder.append(_name_1, "\t");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("default listAll() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("show ");
    CharSequence _listPage = this._commonTemplates.listPage(e);
    _builder.append(_listPage, "\t\t");
    _builder.append("(persistence.findAll());");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* Lists instances of ");
    String _name_2 = e.getName();
    _builder.append(_name_2, "\t");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("* @param ");
    CharSequence _collectionVariable = this._commonTemplates.collectionVariable(e);
    _builder.append(_collectionVariable, "\t");
    _builder.append(" The list of instances of ");
    String _name_3 = e.getName();
    _builder.append(_name_3, "\t");
    _builder.append(" to show.");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _listAction = this._commonTemplates.listAction(e);
    _builder.append(_listAction, "\t");
    _builder.append("(");
    CharSequence _collectionType = this._commonTemplates.collectionType(e);
    _builder.append(_collectionType, "\t");
    _builder.append(" ");
    CharSequence _collectionVariable_1 = this._commonTemplates.collectionVariable(e);
    _builder.append(_collectionVariable_1, "\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("show ");
    CharSequence _listPage_1 = this._commonTemplates.listPage(e);
    _builder.append(_listPage_1, "\t\t");
    _builder.append("(");
    CharSequence _collectionVariable_2 = this._commonTemplates.collectionVariable(e);
    _builder.append(_collectionVariable_2, "\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* Lists instances of ");
    String _name_4 = e.getName();
    _builder.append(_name_4, "\t");
    _builder.append(" that are in a collection.");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("* @param ");
    CharSequence _collectionVariable_3 = this._commonTemplates.collectionVariable(e);
    _builder.append(_collectionVariable_3, "\t");
    _builder.append(" The list of instances of ");
    String _name_5 = e.getName();
    _builder.append(_name_5, "\t");
    _builder.append(" to show.");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _subListAction = this._commonTemplates.subListAction(e);
    _builder.append(_subListAction, "\t");
    _builder.append("(Any container, Collection<");
    String _name_6 = e.getName();
    _builder.append(_name_6, "\t");
    _builder.append("> collection) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("show ");
    CharSequence _subListPage = this._commonTemplates.subListPage(e);
    _builder.append(_subListPage, "\t\t");
    _builder.append("(container, collection);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/** Creates a new instance of ");
    String _name_7 = e.getName();
    _builder.append(_name_7, "\t");
    _builder.append(" and opens a form to ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("* edit that instance and add it to collection.");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* @param container The entity that contains collection");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* @param collection The collection to which the new instance will be added");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _createToAddAction = this._commonTemplates.createToAddAction(e);
    _builder.append(_createToAddAction, "\t");
    _builder.append("(Any container, Collection<");
    String _name_8 = e.getName();
    _builder.append(_name_8, "\t");
    _builder.append("> collection) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("show ");
    CharSequence _createToAddPage = this._commonTemplates.createToAddPage(e);
    _builder.append(_createToAddPage, "\t\t");
    _builder.append("(container, collection, new ");
    String _name_9 = e.getName();
    _builder.append(_name_9, "\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/** Opens a page to select an instance to add it to collection.");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* @param container The entity that contains collection");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* @param collection The collection to which the selected instance will be added");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _selectToAddAction = this._commonTemplates.selectToAddAction(e);
    _builder.append(_selectToAddAction, "\t");
    _builder.append("(Any container, Collection<");
    String _name_10 = e.getName();
    _builder.append(_name_10, "\t");
    _builder.append("> collection) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("Collection<");
    String _name_11 = e.getName();
    _builder.append(_name_11, "\t\t");
    _builder.append("> selectableElements = persistence.findAllExcept(collection);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("show ");
    CharSequence _selectToAddPage = this._commonTemplates.selectToAddPage(e);
    _builder.append(_selectToAddPage, "\t\t");
    _builder.append("(selectableElements, container, collection);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/** Adds an instance of ");
    String _name_12 = e.getName();
    _builder.append(_name_12, "\t");
    _builder.append(" to a collection");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("* @param container The entity that contains collection");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* @param collection The collection to which the new instance will be added");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* @param ");
    CharSequence _variable = this._commonTemplates.variable(e);
    _builder.append(_variable, "\t");
    _builder.append(" The instance that will be added to collection");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _addAction = this._commonTemplates.addAction(e);
    _builder.append(_addAction, "\t");
    _builder.append("(Any container, Collection<");
    String _name_13 = e.getName();
    _builder.append(_name_13, "\t");
    _builder.append("> collection, ");
    String _name_14 = e.getName();
    _builder.append(_name_14, "\t");
    _builder.append(" instance) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("persistence.addToCollection(container, collection, instance);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("-> DefaultPageDispatcher.edit(container);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/** Removes an instance of ");
    String _name_15 = e.getName();
    _builder.append(_name_15, "\t");
    _builder.append(" from a collection");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("* @param container The entity that contains collection");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* @param collection The collection to which the new instance will be added");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* @param ");
    CharSequence _variable_1 = this._commonTemplates.variable(e);
    _builder.append(_variable_1, "\t");
    _builder.append(" The instance that will be removed from collection");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _removeAction = this._commonTemplates.removeAction(e);
    _builder.append(_removeAction, "\t");
    _builder.append("(Any container, Collection<");
    String _name_16 = e.getName();
    _builder.append(_name_16, "\t");
    _builder.append("> collection, ");
    String _name_17 = e.getName();
    _builder.append(_name_17, "\t");
    _builder.append(" instance) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("persistence.removeFromCollection(container, collection, instance);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("-> DefaultPageDispatcher.edit(container);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/** Opens a page to select an instance to assign it to an entity\'s attribute.");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* @param container The entity that has the attribute");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* @param attribute The attribute name to which the selected instance will be assigned");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _selectToAssignAction = this._commonTemplates.selectToAssignAction(e);
    _builder.append(_selectToAssignAction, "\t");
    _builder.append("(Any container, String attribute) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("Collection<");
    String _name_18 = e.getName();
    _builder.append(_name_18, "\t\t");
    _builder.append("> elements = persistence.findAll();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("show ");
    CharSequence _selectToAssignPage = this._commonTemplates.selectToAssignPage(e);
    _builder.append(_selectToAssignPage, "\t\t");
    _builder.append("(elements, container, attribute);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/** Assigns an object to an entity\'s attribute.");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* @param container The entity that has the attribute");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* @param attribute The attribute name that will be assigned");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* @param instance The object that will be assigned to attribute");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _assignAction = this._commonTemplates.assignAction(e);
    _builder.append(_assignAction, "\t");
    _builder.append("(Any container, String attribute, ");
    String _name_19 = e.getName();
    _builder.append(_name_19, "\t");
    _builder.append(" instance) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("persistence.assignToAttribute(container, attribute, instance);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("-> DefaultPageDispatcher.edit(container);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* Views an instance of ");
    String _name_20 = e.getName();
    _builder.append(_name_20, "\t");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("* @param ");
    CharSequence _idVariable = this._commonTemplates.idVariable(e);
    _builder.append(_idVariable, "\t");
    _builder.append(" the ID of the ");
    String _name_21 = e.getName();
    _builder.append(_name_21, "\t");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _viewAction = this._commonTemplates.viewAction(e);
    _builder.append(_viewAction, "\t");
    _builder.append("(");
    CharSequence _idType = this._commonTemplates.idType(e);
    _builder.append(_idType, "\t");
    _builder.append(" ");
    CharSequence _idVariable_1 = this._commonTemplates.idVariable(e);
    _builder.append(_idVariable_1, "\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("show ");
    CharSequence _viewPage = this._commonTemplates.viewPage(e);
    _builder.append(_viewPage, "\t\t");
    _builder.append("(persistence.find(");
    CharSequence _idVariable_2 = this._commonTemplates.idVariable(e);
    _builder.append(_idVariable_2, "\t\t");
    _builder.append("));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* Views an instance of ");
    String _name_22 = e.getName();
    _builder.append(_name_22, "\t");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("* @param ");
    CharSequence _variable_2 = this._commonTemplates.variable(e);
    _builder.append(_variable_2, "\t");
    _builder.append(" the ");
    String _name_23 = e.getName();
    _builder.append(_name_23, "\t");
    _builder.append(" to open.");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("*/\t\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _viewAction_1 = this._commonTemplates.viewAction(e);
    _builder.append(_viewAction_1, "\t");
    _builder.append("(");
    String _name_24 = e.getName();
    _builder.append(_name_24, "\t");
    _builder.append(" ");
    CharSequence _variable_3 = this._commonTemplates.variable(e);
    _builder.append(_variable_3, "\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("show ");
    CharSequence _viewPage_1 = this._commonTemplates.viewPage(e);
    _builder.append(_viewPage_1, "\t\t");
    _builder.append("(");
    CharSequence _variable_4 = this._commonTemplates.variable(e);
    _builder.append(_variable_4, "\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* Edits an existing instance of ");
    String _name_25 = e.getName();
    _builder.append(_name_25, "\t");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("* @param ");
    CharSequence _variable_5 = this._commonTemplates.variable(e);
    _builder.append(_variable_5, "\t");
    _builder.append(" the ");
    String _name_26 = e.getName();
    _builder.append(_name_26, "\t");
    _builder.append(" to open.");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("*/\t\t\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _editAction = this._commonTemplates.editAction(e);
    _builder.append(_editAction, "\t");
    _builder.append("(");
    String _name_27 = e.getName();
    _builder.append(_name_27, "\t");
    _builder.append(" ");
    CharSequence _variable_6 = this._commonTemplates.variable(e);
    _builder.append(_variable_6, "\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("show ");
    CharSequence _editPage = this._commonTemplates.editPage(e);
    _builder.append(_editPage, "\t\t");
    _builder.append("(");
    CharSequence _variable_7 = this._commonTemplates.variable(e);
    _builder.append(_variable_7, "\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* Creates a a new instance of ");
    String _name_28 = e.getName();
    _builder.append(_name_28, "\t");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("*/\t\t\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _createAction = this._commonTemplates.createAction(e);
    _builder.append(_createAction, "\t");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("show ");
    CharSequence _editPage_1 = this._commonTemplates.editPage(e);
    _builder.append(_editPage_1, "\t\t");
    _builder.append("(new ");
    String _name_29 = e.getName();
    _builder.append(_name_29, "\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* Saves an instance of ");
    String _name_30 = e.getName();
    _builder.append(_name_30, "\t");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("* @param ");
    CharSequence _variable_8 = this._commonTemplates.variable(e);
    _builder.append(_variable_8, "\t");
    _builder.append(" the ");
    String _name_31 = e.getName();
    _builder.append(_name_31, "\t");
    _builder.append(" to save.");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("*/\t\t\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _saveAction = this._commonTemplates.saveAction(e);
    _builder.append(_saveAction, "\t");
    _builder.append("(");
    String _name_32 = e.getName();
    _builder.append(_name_32, "\t");
    _builder.append(" ");
    CharSequence _variable_9 = this._commonTemplates.variable(e);
    _builder.append(_variable_9, "\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("if(persistence.isPersistent(");
    CharSequence _variable_10 = this._commonTemplates.variable(e);
    _builder.append(_variable_10, "\t");
    _builder.append(")){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("persistence.edit(");
    CharSequence _variable_11 = this._commonTemplates.variable(e);
    _builder.append(_variable_11, "\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("persistence.create(");
    CharSequence _variable_12 = this._commonTemplates.variable(e);
    _builder.append(_variable_12, "\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("-> listAll();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* Deletes an instance of ");
    String _name_33 = e.getName();
    _builder.append(_name_33, "\t");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("* @param ");
    CharSequence _variable_13 = this._commonTemplates.variable(e);
    _builder.append(_variable_13, "\t");
    _builder.append(" the ");
    String _name_34 = e.getName();
    _builder.append(_name_34, "\t");
    _builder.append(" to delete.");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("*/\t\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _deleteAction = this._commonTemplates.deleteAction(e);
    _builder.append(_deleteAction, "\t");
    _builder.append("(");
    String _name_35 = e.getName();
    _builder.append(_name_35, "\t");
    _builder.append(" ");
    CharSequence _variable_14 = this._commonTemplates.variable(e);
    _builder.append(_variable_14, "\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("persistence.remove(");
    CharSequence _variable_15 = this._commonTemplates.variable(e);
    _builder.append(_variable_15, "\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("-> listAll();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("* Deletes an instance of ");
    String _name_36 = e.getName();
    _builder.append(_name_36, "\t");
    _builder.append(".");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("* @param ");
    CharSequence _idVariable_3 = this._commonTemplates.idVariable(e);
    _builder.append(_idVariable_3, "\t");
    _builder.append(" the ID of the ");
    String _name_37 = e.getName();
    _builder.append(_name_37, "\t");
    _builder.append(" to delete.");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("*/\t\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _deleteAction_1 = this._commonTemplates.deleteAction(e);
    _builder.append(_deleteAction_1, "\t");
    _builder.append("(");
    CharSequence _idType_1 = this._commonTemplates.idType(e);
    _builder.append(_idType_1, "\t");
    _builder.append(" ");
    CharSequence _idVariable_4 = this._commonTemplates.idVariable(e);
    _builder.append(_idVariable_4, "\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("persistence.remove(");
    CharSequence _idVariable_5 = this._commonTemplates.idVariable(e);
    _builder.append(_idVariable_5, "\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("-> listAll();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
