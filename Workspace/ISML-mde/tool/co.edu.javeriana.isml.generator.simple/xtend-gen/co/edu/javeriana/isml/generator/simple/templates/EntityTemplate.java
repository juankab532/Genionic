package co.edu.javeriana.isml.generator.simple.templates;

import co.edu.javeriana.isml.generator.common.SimpleTemplate;
import co.edu.javeriana.isml.isml.Attribute;
import co.edu.javeriana.isml.isml.ConstraintInstance;
import co.edu.javeriana.isml.isml.Entity;
import co.edu.javeriana.isml.isml.Type;
import co.edu.javeriana.isml.scoping.IsmlModelNavigation;
import co.edu.javeriana.isml.validation.TypeChecker;
import com.google.inject.Inject;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class EntityTemplate extends SimpleTemplate<Entity> {
  @Inject
  @Extension
  private TypeChecker _typeChecker;
  
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Inject
  @Extension
  private IsmlModelNavigation _ismlModelNavigation;
  
  @Override
  public void preprocess(final Entity e) {
  }
  
  @Override
  public CharSequence template(final Entity e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Entity {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("name = ");
    String _name = e.getName();
    _builder.append(_name, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("extends = ");
    CharSequence _parentsToText = this.parentsToText(e);
    _builder.append(_parentsToText, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("body = {");
    _builder.newLine();
    {
      Iterable<Attribute> _attributes = this._ismlModelNavigation.getAttributes(e);
      for(final Attribute attr : _attributes) {
        _builder.append("\t\t");
        _builder.append("Attribute {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("name = ");
        String _name_1 = attr.getName();
        _builder.append(_name_1, "\t\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("type = ");
        CharSequence _text = this.toText(attr.getType());
        _builder.append(_text, "\t\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("constraints = ");
        CharSequence _constraintsToText = this.constraintsToText(attr);
        _builder.append(_constraintsToText, "\t\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence toText(final Type t) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = this._ismlModelNavigation.getTypeSpecification(t).getName();
    _builder.append(_name);
    return _builder;
  }
  
  public CharSequence parentsToText(final Entity e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[");
    {
      Collection<Type> _parents = this._ismlModelNavigation.getParents(e);
      boolean _hasElements = false;
      for(final Type p : _parents) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "");
        }
        String _name = this._ismlModelNavigation.getTypeSpecification(p).getName();
        _builder.append(_name);
      }
    }
    _builder.append("]");
    return _builder;
  }
  
  public CharSequence constraintsToText(final Attribute attr) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[");
    {
      EList<ConstraintInstance> _constraints = attr.getConstraints();
      boolean _hasElements = false;
      for(final ConstraintInstance c : _constraints) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "");
        }
        CharSequence _text = this.toText(c);
        _builder.append(_text);
      }
    }
    _builder.append("]");
    return _builder;
  }
  
  public CharSequence toText(final ConstraintInstance c) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = this._ismlModelNavigation.getTypeSpecification(c.getType()).getName();
    _builder.append(_name);
    return _builder;
  }
}
