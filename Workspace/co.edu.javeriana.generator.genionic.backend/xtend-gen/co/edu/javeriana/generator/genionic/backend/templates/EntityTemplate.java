package co.edu.javeriana.generator.genionic.backend.templates;

import co.edu.javeriana.isml.generator.common.SimpleTemplate;
import co.edu.javeriana.isml.isml.Attribute;
import co.edu.javeriana.isml.isml.Constraint;
import co.edu.javeriana.isml.isml.ConstraintInstance;
import co.edu.javeriana.isml.isml.Entity;
import co.edu.javeriana.isml.isml.Expression;
import co.edu.javeriana.isml.isml.Instance;
import co.edu.javeriana.isml.isml.LiteralValue;
import co.edu.javeriana.isml.isml.Parameter;
import co.edu.javeriana.isml.isml.ParameterizedType;
import co.edu.javeriana.isml.isml.Primitive;
import co.edu.javeriana.isml.isml.Type;
import co.edu.javeriana.isml.isml.TypeSpecification;
import co.edu.javeriana.isml.scoping.IsmlModelNavigation;
import co.edu.javeriana.isml.validation.TypeChecker;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class EntityTemplate extends SimpleTemplate<Entity> {
  @Inject
  @Extension
  private TypeChecker _typeChecker;
  
  /**
   * Inyección de las clases auxiliares con metodos utilitarios
   */
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Inject
  @Extension
  private IsmlModelNavigation _ismlModelNavigation;
  
  /**
   * Preprocesamiento del template
   */
  @Override
  public void preprocess(final Entity e) {
  }
  
  /**
   * Plantilla para generar entidades
   */
  @Override
  public CharSequence template(final Entity entity) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(entity.eContainer());
    _builder.append(_fullyQualifiedName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import javax.persistence.*;");
    _builder.newLine();
    _builder.append("import javax.validation.constraints.*;");
    _builder.newLine();
    _builder.append("import java.io.Serializable;");
    _builder.newLine();
    _builder.append("import javax.xml.bind.annotation.XmlRootElement;");
    _builder.newLine();
    {
      boolean _isDatePresent = this.isDatePresent(entity);
      if (_isDatePresent) {
        _builder.append("import java.util.Date;");
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      Collection<Type> _parents = this._ismlModelNavigation.getParents(entity);
      for(final Type parent : _parents) {
        {
          boolean _equals = this._iQualifiedNameProvider.getFullyQualifiedName(parent.eContainer().eContainer()).equals(this._iQualifiedNameProvider.getFullyQualifiedName(entity.eContainer()));
          boolean _not = (!_equals);
          if (_not) {
            _builder.append("import ");
            QualifiedName _fullyQualifiedName_1 = this._iQualifiedNameProvider.getFullyQualifiedName(this._ismlModelNavigation.getTypeSpecification(parent));
            _builder.append(_fullyQualifiedName_1);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.newLine();
    {
      Iterable<Attribute> _attributes = this._ismlModelNavigation.getAttributes(entity);
      for(final Attribute attribute : _attributes) {
        {
          if (((!(this._ismlModelNavigation.getTypeSpecification(attribute.getType()) instanceof Primitive)) || this._typeChecker.isCollection(attribute.getType()))) {
            {
              boolean _evaluateAttributeToImport = this.evaluateAttributeToImport(attribute, entity);
              if (_evaluateAttributeToImport) {
                {
                  Type _type = attribute.getType();
                  if ((_type instanceof ParameterizedType)) {
                    {
                      Type _type_1 = attribute.getType();
                      TypeSpecification _typeSpecification = this._ismlModelNavigation.getTypeSpecification(((ParameterizedType) _type_1).getTypeParameters().get(0));
                      boolean _not_1 = (!(_typeSpecification instanceof Primitive));
                      if (_not_1) {
                        _builder.append("import ");
                        Type _type_2 = attribute.getType();
                        QualifiedName _fullyQualifiedName_2 = this._iQualifiedNameProvider.getFullyQualifiedName(this._ismlModelNavigation.getTypeSpecification(((ParameterizedType) _type_2).getTypeParameters().get(0)));
                        _builder.append(_fullyQualifiedName_2);
                        _builder.append(";");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                  } else {
                    _builder.append("import ");
                    QualifiedName _fullyQualifiedName_3 = this._iQualifiedNameProvider.getFullyQualifiedName(this._ismlModelNavigation.getTypeSpecification(attribute.getType()));
                    _builder.append(_fullyQualifiedName_3);
                    _builder.append(";");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
          }
        }
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    {
      boolean _isArrayPresent = this._ismlModelNavigation.isArrayPresent(this._ismlModelNavigation.getAttributes(entity));
      if (_isArrayPresent) {
        _builder.append("import java.util.*;");
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      boolean _isParent = this._ismlModelNavigation.isParent(entity);
      if (_isParent) {
        _builder.append("import javax.persistence.Inheritance;");
        _builder.newLine();
        _builder.append("import javax.persistence.InheritanceType;");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("@XmlRootElement");
    _builder.newLine();
    _builder.append("@Entity");
    _builder.newLine();
    {
      boolean _isParent_1 = this._ismlModelNavigation.isParent(entity);
      if (_isParent_1) {
        _builder.append("@Inheritance(strategy=InheritanceType.JOINED)");
        _builder.newLine();
        _builder.append("@DiscriminatorColumn(name=\"");
        String _upperCase = entity.getName().toUpperCase();
        _builder.append(_upperCase);
        _builder.append("_TYPE\", discriminatorType=DiscriminatorType.STRING)");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      boolean _isSon = this._ismlModelNavigation.isSon(entity);
      if (_isSon) {
        _builder.append("@DiscriminatorValue(value=\"");
        String _upperCase_1 = entity.getName().toUpperCase();
        _builder.append(_upperCase_1);
        _builder.append("\")");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("public ");
    {
      boolean _isAbstract = entity.isAbstract();
      if (_isAbstract) {
        _builder.append("abstract");
      }
    }
    _builder.append(" class ");
    String _firstUpper = StringExtensions.toFirstUpper(entity.getName());
    _builder.append(_firstUpper);
    _builder.append(" ");
    {
      boolean _isEmpty = entity.getSuperTypes().isEmpty();
      boolean _not_2 = (!_isEmpty);
      if (_not_2) {
        _builder.append("extends ");
        String _typeSpecificationString = this.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(entity.getSuperTypes().get(0)));
        _builder.append(_typeSpecificationString);
        _builder.append(" ");
      }
    }
    _builder.append("implements Serializable {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* The serialVersionUID");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static final long serialVersionUID = 1L;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      boolean _isEmpty_1 = this._ismlModelNavigation.getParents(entity).isEmpty();
      if (_isEmpty_1) {
        _builder.append("\t");
        _builder.append("/**");
        _builder.newLine();
        _builder.append("\t");
        _builder.append(" ");
        _builder.append("* The unique id for the entity");
        _builder.newLine();
        _builder.append("\t");
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Id");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@GeneratedValue(strategy = GenerationType.IDENTITY)");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Column(columnDefinition = \"serial\")");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private Long id = null;");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      Iterable<Attribute> _attributes_1 = this._ismlModelNavigation.getAttributes(entity);
      for(final Attribute attributes : _attributes_1) {
        _builder.append("\t");
        CharSequence _associationAnnotation = this.associationAnnotation(attributes);
        _builder.append(_associationAnnotation, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.newLine();
        {
          EList<ConstraintInstance> _constraints = attributes.getConstraints();
          for(final ConstraintInstance constraint : _constraints) {
            _builder.append("\t");
            _builder.append("@");
            String _firstUpper_1 = StringExtensions.toFirstUpper(this.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(constraint.getType())));
            _builder.append(_firstUpper_1, "\t");
            CharSequence _parametersTemplate = this.getParametersTemplate(constraint);
            _builder.append(_parametersTemplate, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _equalsIgnoreCase = this.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(attributes.getType())).equalsIgnoreCase("email");
          if (_equalsIgnoreCase) {
            _builder.append("\t");
            _builder.append("/**");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("* The ");
            String _name = attributes.getName();
            _builder.append(_name, "\t ");
            _builder.append(" for the ");
            String _firstUpper_2 = StringExtensions.toFirstUpper(entity.getName());
            _builder.append(_firstUpper_2, "\t ");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("*/");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("private String ");
            String _name_1 = attributes.getName();
            _builder.append(_name_1, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          } else {
            {
              boolean _isCollection = this._typeChecker.isCollection(attributes.getType());
              if (_isCollection) {
                _builder.append("\t");
                _builder.append("/**");
                _builder.newLine();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("* The ");
                String _name_2 = attributes.getName();
                _builder.append(_name_2, "\t ");
                _builder.append(" for the ");
                String _firstUpper_3 = StringExtensions.toFirstUpper(entity.getName());
                _builder.append(_firstUpper_3, "\t ");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("*/");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("private ");
                Type _type_3 = attributes.getType();
                String _collectionString = this._ismlModelNavigation.getCollectionString(((ParameterizedType) _type_3));
                _builder.append(_collectionString, "\t");
                _builder.append("<");
                Type _type_4 = attributes.getType();
                String _typeSpecificationString_1 = this.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(((ParameterizedType) _type_4).getTypeParameters().get(0)));
                _builder.append(_typeSpecificationString_1, "\t");
                _builder.append("> ");
                String _name_3 = attributes.getName();
                _builder.append(_name_3, "\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
              } else {
                boolean _equalsIgnoreCase_1 = attributes.getName().equalsIgnoreCase("id");
                boolean _not_3 = (!_equalsIgnoreCase_1);
                if (_not_3) {
                  _builder.append("\t");
                  _builder.append("/**");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append(" ");
                  _builder.append("* The ");
                  String _name_4 = attributes.getName();
                  _builder.append(_name_4, "\t ");
                  _builder.append(" for the ");
                  String _firstUpper_4 = StringExtensions.toFirstUpper(entity.getName());
                  _builder.append(_firstUpper_4, "\t ");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append(" ");
                  _builder.append("*/");
                  _builder.newLine();
                  {
                    boolean _equalsIgnoreCase_2 = this._ismlModelNavigation.getTypeSpecification(attributes.getType()).getName().equalsIgnoreCase("BytesArray");
                    if (_equalsIgnoreCase_2) {
                      _builder.append("\t");
                      _builder.append("@Column(columnDefinition = \"TEXT\")\t");
                      _builder.newLine();
                    }
                  }
                  _builder.append("\t");
                  _builder.append("private ");
                  String _firstUpper_5 = StringExtensions.toFirstUpper(this.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(attributes.getType())));
                  _builder.append(_firstUpper_5, "\t");
                  _builder.append(" ");
                  String _name_5 = attributes.getName();
                  _builder.append(_name_5, "\t");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
        }
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _firstUpper_6 = StringExtensions.toFirstUpper(entity.getName());
    _builder.append(_firstUpper_6, "\t");
    _builder.append("(){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _firstUpper_7 = StringExtensions.toFirstUpper(entity.getName());
    _builder.append(_firstUpper_7, "\t");
    _builder.append("(");
    {
      Iterable<Attribute> _attributes_2 = this._ismlModelNavigation.getAttributes(entity);
      boolean _hasElements = false;
      for(final Attribute a : _attributes_2) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "\t");
        }
        {
          boolean _equalsIgnoreCase_3 = this.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(a.getType())).equalsIgnoreCase("email");
          if (_equalsIgnoreCase_3) {
            _builder.append("String ");
            String _name_6 = a.getName();
            _builder.append(_name_6, "\t");
          } else {
            {
              boolean _isCollection_1 = this._typeChecker.isCollection(a.getType());
              if (_isCollection_1) {
                Type _type_5 = a.getType();
                String _collectionString_1 = this._ismlModelNavigation.getCollectionString(((ParameterizedType) _type_5));
                _builder.append(_collectionString_1, "\t");
                _builder.append("<");
                Type _type_6 = a.getType();
                String _typeSpecificationString_2 = this.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(((ParameterizedType) _type_6).getTypeParameters().get(0)));
                _builder.append(_typeSpecificationString_2, "\t");
                _builder.append("> ");
                String _name_7 = a.getName();
                _builder.append(_name_7, "\t");
              } else {
                String _firstUpper_8 = StringExtensions.toFirstUpper(this.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(a.getType())));
                _builder.append(_firstUpper_8, "\t");
                _builder.append(" ");
                String _name_8 = a.getName();
                _builder.append(_name_8, "\t");
              }
            }
          }
        }
      }
    }
    _builder.append("){");
    _builder.newLineIfNotEmpty();
    {
      Iterable<Attribute> _attributes_3 = this._ismlModelNavigation.getAttributes(entity);
      for(final Attribute attr : _attributes_3) {
        _builder.append("\t\t");
        _builder.append("set");
        String _firstUpper_9 = StringExtensions.toFirstUpper(attr.getName());
        _builder.append(_firstUpper_9, "\t\t");
        _builder.append("(");
        String _firstLower = StringExtensions.toFirstLower(attr.getName());
        _builder.append(_firstLower, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      Iterable<Attribute> _attributes_4 = this._ismlModelNavigation.getAttributes(entity);
      for(final Attribute attribute_1 : _attributes_4) {
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        {
          boolean _equalsIgnoreCase_4 = this.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(attribute_1.getType())).equalsIgnoreCase("email");
          if (_equalsIgnoreCase_4) {
            _builder.append("\t");
            _builder.append("/**");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("* Returns the current value for the attibute ");
            String _name_9 = attribute_1.getName();
            _builder.append(_name_9, "\t ");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("*");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("* @return current instance for ");
            String _firstLower_1 = StringExtensions.toFirstLower(attribute_1.getName());
            _builder.append(_firstLower_1, "\t ");
            _builder.append(" attribute");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("*/\t\t\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("@Pattern(regexp=\"^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$\")");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public String get");
            String _firstUpper_10 = StringExtensions.toFirstUpper(attribute_1.getName());
            _builder.append(_firstUpper_10, "\t");
            _builder.append("(){");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return ");
            String _name_10 = attribute_1.getName();
            _builder.append(_name_10, "\t\t");
            _builder.append(";");
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
            _builder.append(" ");
            _builder.append("* Sets the value for the attribute ");
            String _name_11 = attribute_1.getName();
            _builder.append(_name_11, "\t ");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("* @param ");
            String _firstLower_2 = StringExtensions.toFirstLower(attribute_1.getName());
            _builder.append(_firstLower_2, "\t ");
            _builder.append(" The value to set");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append(" ");
            _builder.append("*/");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public void set");
            String _firstUpper_11 = StringExtensions.toFirstUpper(attribute_1.getName());
            _builder.append(_firstUpper_11, "\t");
            _builder.append("(String ");
            String _name_12 = attribute_1.getName();
            _builder.append(_name_12, "\t");
            _builder.append("){");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("this.");
            String _name_13 = attribute_1.getName();
            _builder.append(_name_13, "\t\t");
            _builder.append("=");
            String _name_14 = attribute_1.getName();
            _builder.append(_name_14, "\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}\t\t\t\t");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.newLine();
            {
              boolean _isCollection_2 = this._typeChecker.isCollection(attribute_1.getType());
              if (_isCollection_2) {
                _builder.append("\t");
                _builder.append("/**");
                _builder.newLine();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("* Returns the current value for the attibute ");
                String _name_15 = attribute_1.getName();
                _builder.append(_name_15, "\t ");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("*");
                _builder.newLine();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("* @return current instance for ");
                String _firstLower_3 = StringExtensions.toFirstLower(attribute_1.getName());
                _builder.append(_firstLower_3, "\t ");
                _builder.append(" attribute");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("*/");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("public ");
                Type _type_7 = attribute_1.getType();
                String _collectionString_2 = this._ismlModelNavigation.getCollectionString(((ParameterizedType) _type_7));
                _builder.append(_collectionString_2, "\t");
                _builder.append("<");
                Type _type_8 = attribute_1.getType();
                String _typeSpecificationString_3 = this.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(((ParameterizedType) _type_8).getTypeParameters().get(0)));
                _builder.append(_typeSpecificationString_3, "\t");
                _builder.append("> get");
                String _firstUpper_12 = StringExtensions.toFirstUpper(attribute_1.getName());
                _builder.append(_firstUpper_12, "\t");
                _builder.append("(){");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("return ");
                String _name_16 = attribute_1.getName();
                _builder.append(_name_16, "\t\t");
                _builder.append(";");
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
                _builder.append(" ");
                _builder.append("* Sets the value for the attribute ");
                String _name_17 = attribute_1.getName();
                _builder.append(_name_17, "\t ");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("* @param ");
                String _firstLower_4 = StringExtensions.toFirstLower(attribute_1.getName());
                _builder.append(_firstLower_4, "\t ");
                _builder.append(" The value to set");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append(" ");
                _builder.append("*/");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("public void set");
                String _firstUpper_13 = StringExtensions.toFirstUpper(attribute_1.getName());
                _builder.append(_firstUpper_13, "\t");
                _builder.append("(");
                Type _type_9 = attribute_1.getType();
                String _collectionString_3 = this._ismlModelNavigation.getCollectionString(((ParameterizedType) _type_9));
                _builder.append(_collectionString_3, "\t");
                _builder.append("<");
                Type _type_10 = attribute_1.getType();
                String _typeSpecificationString_4 = this.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(((ParameterizedType) _type_10).getTypeParameters().get(0)));
                _builder.append(_typeSpecificationString_4, "\t");
                _builder.append("> ");
                String _name_18 = attribute_1.getName();
                _builder.append(_name_18, "\t");
                _builder.append("){");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("this.");
                String _name_19 = attribute_1.getName();
                _builder.append(_name_19, "\t\t");
                _builder.append("=");
                String _name_20 = attribute_1.getName();
                _builder.append(_name_20, "\t\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
              } else {
                boolean _equalsIgnoreCase_5 = attribute_1.getName().equalsIgnoreCase("id");
                boolean _not_4 = (!_equalsIgnoreCase_5);
                if (_not_4) {
                  _builder.append("\t");
                  _builder.append("/**");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append(" ");
                  _builder.append("* Returns the current value for the attibute ");
                  String _name_21 = attribute_1.getName();
                  _builder.append(_name_21, "\t ");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append(" ");
                  _builder.append("*");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append(" ");
                  _builder.append("* @return current instance for ");
                  String _firstLower_5 = StringExtensions.toFirstLower(attribute_1.getName());
                  _builder.append(_firstLower_5, "\t ");
                  _builder.append(" attribute");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append(" ");
                  _builder.append("*/");
                  _builder.newLine();
                  _builder.append("\t");
                  {
                    TypeSpecification _typeSpecification_1 = this._ismlModelNavigation.getTypeSpecification(attribute_1.getType());
                    if ((_typeSpecification_1 instanceof co.edu.javeriana.isml.isml.Enum)) {
                      _builder.append("@Enumerated");
                    }
                  }
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("public ");
                  String _firstUpper_14 = StringExtensions.toFirstUpper(this.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(attribute_1.getType())));
                  _builder.append(_firstUpper_14, "\t");
                  _builder.append(" get");
                  String _firstUpper_15 = StringExtensions.toFirstUpper(attribute_1.getName());
                  _builder.append(_firstUpper_15, "\t");
                  _builder.append("(){");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("return ");
                  String _name_22 = attribute_1.getName();
                  _builder.append(_name_22, "\t\t");
                  _builder.append(";");
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
                  _builder.append(" ");
                  _builder.append("* Sets the value for the attribute ");
                  String _name_23 = attribute_1.getName();
                  _builder.append(_name_23, "\t ");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append(" ");
                  _builder.append("* @param ");
                  String _firstLower_6 = StringExtensions.toFirstLower(attribute_1.getName());
                  _builder.append(_firstLower_6, "\t ");
                  _builder.append(" The value to set");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append(" ");
                  _builder.append("*/");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("public void set");
                  String _firstUpper_16 = StringExtensions.toFirstUpper(attribute_1.getName());
                  _builder.append(_firstUpper_16, "\t");
                  _builder.append("(");
                  String _firstUpper_17 = StringExtensions.toFirstUpper(this.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(attribute_1.getType())));
                  _builder.append(_firstUpper_17, "\t");
                  _builder.append(" ");
                  String _name_24 = attribute_1.getName();
                  _builder.append(_name_24, "\t");
                  _builder.append("){");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("\t");
                  _builder.append("this.");
                  String _name_25 = attribute_1.getName();
                  _builder.append(_name_25, "\t\t");
                  _builder.append("=");
                  String _name_26 = attribute_1.getName();
                  _builder.append(_name_26, "\t\t");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("}");
                  _builder.newLine();
                }
              }
            }
            _builder.append("\t");
            _builder.newLine();
          }
        }
      }
    }
    _builder.newLine();
    {
      boolean _isEmpty_2 = this._ismlModelNavigation.getParents(entity).isEmpty();
      if (_isEmpty_2) {
        _builder.append("\t");
        _builder.append("public Long getId() {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return id;");
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
        _builder.append(" ");
        _builder.append("* Sets the value for the unique id");
        _builder.newLine();
        _builder.append("\t");
        _builder.append(" ");
        _builder.append("* @param id The value to set");
        _builder.newLine();
        _builder.append("\t");
        _builder.append(" ");
        _builder.append("*/");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void setId(final Long id) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("this.id = id;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public boolean equals(Object obj) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("if (this == obj) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("return true;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("if (obj == null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("return false;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("if (!(obj instanceof ");
        String _name_27 = entity.getName();
        _builder.append(_name_27, "\t\t");
        _builder.append(")) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("return false;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("final ");
        String _name_28 = entity.getName();
        _builder.append(_name_28, "\t\t");
        _builder.append(" other = (");
        String _name_29 = entity.getName();
        _builder.append(_name_29, "\t\t");
        _builder.append(") obj;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("if (id == null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("if (other.getId() != null) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t");
        _builder.append("return false;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("} else if (!id.equals(other.getId())) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("return false;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return true;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public int hashCode() {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("int hash = 0;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("hash += (id != null ? id.hashCode() : 0);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return hash;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("@Override");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public String toString() {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return \"");
        QualifiedName _fullyQualifiedName_4 = this._iQualifiedNameProvider.getFullyQualifiedName(entity.eContainer());
        _builder.append(_fullyQualifiedName_4, "\t\t");
        _builder.append(".");
        String _name_30 = entity.getName();
        _builder.append(_name_30, "\t\t");
        _builder.append(" [ id=\" + id + \" ]\";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public boolean evaluateAttributeToImport(final Attribute attribute, final Entity entity) {
    boolean needImport = false;
    boolean _isCollection = this._typeChecker.isCollection(attribute.getType());
    boolean _not = (!_isCollection);
    if (_not) {
      boolean _equals = this._iQualifiedNameProvider.getFullyQualifiedName(this._ismlModelNavigation.getTypeSpecification(attribute.getType()).eContainer()).equals(this._iQualifiedNameProvider.getFullyQualifiedName(entity.eContainer()));
      boolean _not_1 = (!_equals);
      needImport = _not_1;
    } else {
      Type _type = attribute.getType();
      boolean _equals_1 = this._iQualifiedNameProvider.getFullyQualifiedName(this._ismlModelNavigation.getTypeSpecification(((ParameterizedType) _type).getTypeParameters().get(0)).eContainer()).equals(this._iQualifiedNameProvider.getFullyQualifiedName(entity.eContainer()));
      boolean _not_2 = (!_equals_1);
      needImport = _not_2;
    }
    return needImport;
  }
  
  public boolean isDatePresent(final Entity entity) {
    boolean hasDate = false;
    Iterable<Attribute> _attributes = this._ismlModelNavigation.getAttributes(entity);
    for (final Attribute attr : _attributes) {
      if (((this._ismlModelNavigation.getTypeSpecification(attr.getType()) instanceof Primitive) && this.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(attr.getType())).equalsIgnoreCase("Date"))) {
        hasDate = true;
      }
    }
    return hasDate;
  }
  
  public CharSequence getParametersTemplate(final Instance constraint) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isEmpty = constraint.getParameters().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder.append("(");
        {
          TypeSpecification _typeSpecification = this._ismlModelNavigation.getTypeSpecification(constraint.getType());
          EList<Parameter> _setParametersValue = this._ismlModelNavigation.setParametersValue(
            ((Constraint) _typeSpecification).getParameters(), constraint.getParameters());
          boolean _hasElements = false;
          for(final Parameter parameter : _setParametersValue) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",", "");
            }
            _builder.newLineIfNotEmpty();
            String _name = parameter.getName();
            _builder.append(_name);
            _builder.append("=");
            {
              boolean _equalsIgnoreCase = this.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(parameter.getType())).equalsIgnoreCase("string");
              if (_equalsIgnoreCase) {
                _builder.append("\"");
                Expression _value = parameter.getValue();
                Object _literal = ((LiteralValue) _value).getLiteral();
                _builder.append(_literal);
                _builder.append("\"");
              } else {
                Expression _value_1 = parameter.getValue();
                Object _literal_1 = ((LiteralValue) _value_1).getLiteral();
                _builder.append(_literal_1);
              }
            }
          }
        }
        _builder.append(")");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence associationAnnotation(final Attribute a) {
    boolean _evaluateCardinality = this._ismlModelNavigation.evaluateCardinality(a);
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
          final Attribute opposite = this._ismlModelNavigation.searchOpposite(a);
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
              String _name_2 = this._ismlModelNavigation.searchOpposite(a).getName();
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
          try {
            boolean _isCollection_4 = this._typeChecker.isCollection(this._ismlModelNavigation.searchOpposite(a).getType());
            if (_isCollection_4) {
              StringConcatenation _builder_6 = new StringConcatenation();
              _builder_6.append("@ManyToOne");
              return _builder_6;
            } else {
              StringConcatenation _builder_7 = new StringConcatenation();
              _builder_7.append("@OneToOne");
              return _builder_7;
            }
          } catch (final Throwable _t) {
            if (_t instanceof Exception) {
              final Exception e = (Exception)_t;
              StringConcatenation _builder_8 = new StringConcatenation();
              _builder_8.append("@ManyToOne");
              return _builder_8;
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
      }
    }
    StringConcatenation _builder_9 = new StringConcatenation();
    return _builder_9;
  }
  
  public String getTypeSpecificationString(final TypeSpecification specification) {
    if (((specification instanceof Primitive) && specification.getName().equalsIgnoreCase("Integer"))) {
      return "Long";
    } else {
      if (((specification instanceof Primitive) && 
        specification.getName().equalsIgnoreCase("BytesArray"))) {
        return "String";
      } else {
        if (((specification instanceof Primitive) && specification.getName().equalsIgnoreCase("Any"))) {
          return "Object";
        } else {
          return specification.getName();
        }
      }
    }
  }
}
