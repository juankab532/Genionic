package co.edu.javeriana.generator.genionic.templates;

import co.edu.javeriana.generator.genionic.templates.ExtraGenionic;
import co.edu.javeriana.isml.generator.common.SimpleTemplate;
import co.edu.javeriana.isml.isml.Attribute;
import co.edu.javeriana.isml.isml.Entity;
import co.edu.javeriana.isml.isml.TypeSpecification;
import co.edu.javeriana.isml.scoping.IsmlModelNavigation;
import co.edu.javeriana.isml.validation.TypeChecker;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ModelTemplate extends SimpleTemplate<Entity> {
  private List<String> relatedEntities = new ArrayList<String>();
  
  @Inject
  @Extension
  private IsmlModelNavigation _ismlModelNavigation;
  
  @Inject
  @Extension
  private ExtraGenionic _extraGenionic;
  
  @Inject
  @Extension
  private TypeChecker _typeChecker;
  
  @Override
  protected CharSequence template(final Entity e) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final String elm : this.relatedEntities) {
        _builder.append("import { ");
        _builder.append(elm);
        _builder.append(" } from \'../");
        String _lowerCase = elm.toLowerCase();
        int _length = elm.length();
        int _minus = (_length - 1);
        String _substring = _lowerCase.substring(0, _minus);
        _builder.append(_substring);
        _builder.append("/");
        String _lowerCase_1 = elm.toLowerCase();
        _builder.append(_lowerCase_1);
        _builder.append("\';");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("export class ");
    String _firstUpper = StringExtensions.toFirstUpper(e.getName());
    _builder.append(_firstUpper);
    _builder.append("{");
    _builder.newLineIfNotEmpty();
    {
      Iterable<Attribute> _attributes = this._ismlModelNavigation.getAttributes(e);
      for(final Attribute attributes : _attributes) {
        {
          TypeSpecification _typeSpecification = this._ismlModelNavigation.getTypeSpecification(attributes.getType());
          if ((_typeSpecification instanceof Entity)) {
            _builder.append("\t");
            String _name = attributes.getName();
            _builder.append(_name, "\t");
            _builder.append(":");
            CharSequence _generateType = this._extraGenionic.generateType(this._ismlModelNavigation.getTypeSpecification(attributes.getType()).getName());
            _builder.append(_generateType, "\t");
            _builder.append("= new ");
            CharSequence _generateType_1 = this._extraGenionic.generateType(this._ismlModelNavigation.getTypeSpecification(attributes.getType()).getName());
            _builder.append(_generateType_1, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t");
            String _name_1 = attributes.getName();
            _builder.append(_name_1, "\t");
            _builder.append(":");
            CharSequence _generateType_2 = this._extraGenionic.generateType(this._ismlModelNavigation.getTypeSpecification(attributes.getType()).getName());
            _builder.append(_generateType_2, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      Iterable<Attribute> _attributes_1 = this._ismlModelNavigation.getAttributes(e);
      for(final Attribute attributes_1 : _attributes_1) {
        _builder.append("\t");
        _builder.append("get");
        String _firstUpper_1 = StringExtensions.toFirstUpper(attributes_1.getName());
        _builder.append(_firstUpper_1, "\t");
        _builder.append("(){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("  ");
        _builder.append("return this.");
        String _name_2 = attributes_1.getName();
        _builder.append(_name_2, "\t  ");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("set");
        String _firstUpper_2 = StringExtensions.toFirstUpper(attributes_1.getName());
        _builder.append(_firstUpper_2, "\t");
        _builder.append("(valor){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("  ");
        _builder.append("this.");
        String _name_3 = attributes_1.getName();
        _builder.append(_name_3, "\t  ");
        _builder.append("=valor;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  @Override
  public void preprocess(final Entity e) {
    Iterable<Attribute> _attributes = this._ismlModelNavigation.getAttributes(e);
    for (final Attribute attributes : _attributes) {
      TypeSpecification _typeSpecification = this._ismlModelNavigation.getTypeSpecification(attributes.getType());
      if ((_typeSpecification instanceof Entity)) {
        this.relatedEntities.add(this._ismlModelNavigation.getTypeSpecification(attributes.getType()).getName());
      }
    }
  }
}
