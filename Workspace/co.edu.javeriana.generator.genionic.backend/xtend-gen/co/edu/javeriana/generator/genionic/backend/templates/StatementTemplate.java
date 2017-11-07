package co.edu.javeriana.generator.genionic.backend.templates;

import co.edu.javeriana.generator.genionic.backend.templates.ExpressionTemplate;
import co.edu.javeriana.generator.genionic.backend.templates.ReferenceTemplate;
import co.edu.javeriana.isml.isml.Action;
import co.edu.javeriana.isml.isml.Assignment;
import co.edu.javeriana.isml.isml.Attribute;
import co.edu.javeriana.isml.isml.Controller;
import co.edu.javeriana.isml.isml.Expression;
import co.edu.javeriana.isml.isml.For;
import co.edu.javeriana.isml.isml.If;
import co.edu.javeriana.isml.isml.Instance;
import co.edu.javeriana.isml.isml.MethodStatement;
import co.edu.javeriana.isml.isml.NullValue;
import co.edu.javeriana.isml.isml.Reference;
import co.edu.javeriana.isml.isml.Return;
import co.edu.javeriana.isml.isml.Show;
import co.edu.javeriana.isml.isml.Type;
import co.edu.javeriana.isml.isml.Variable;
import co.edu.javeriana.isml.isml.VariableReference;
import co.edu.javeriana.isml.isml.While;
import co.edu.javeriana.isml.scoping.IsmlModelNavigation;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Clase que provee los metodos utilitarios para uso general de todas las plantillas
 */
@SuppressWarnings("all")
public class StatementTemplate {
  @Inject
  @Extension
  private ExpressionTemplate _expressionTemplate;
  
  @Inject
  @Extension
  private IsmlModelNavigation _ismlModelNavigation;
  
  @Inject
  @Extension
  private ReferenceTemplate _referenceTemplate;
  
  /**
   * Este método escribe los Statement contenidos en un Body
   */
  public CharSequence writeStatements(final EList<MethodStatement> body) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final MethodStatement statement : body) {
        CharSequence _writeStatement = this.writeStatement(((MethodStatement) statement));
        _builder.append(_writeStatement);
        _builder.append("\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _writeStatement(final Reference statement) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _writeReference = this._referenceTemplate.writeReference(statement);
    _builder.append(_writeReference);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _writeStatement(final While statement) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("while(");
    CharSequence _writeExpression = this._expressionTemplate.writeExpression(statement.getCondition());
    _builder.append(_writeExpression);
    _builder.append("){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _writeStatements = this.writeStatements(statement.getBody());
    _builder.append(_writeStatements, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _writeStatement(final If statement) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if(");
    CharSequence _writeExpression = this._expressionTemplate.writeExpression(statement.getCondition());
    _builder.append(_writeExpression);
    _builder.append("){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _writeStatements = this.writeStatements(statement.getBody());
    _builder.append(_writeStatements, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    {
      EList<MethodStatement> _elseBody = statement.getElseBody();
      boolean _notEquals = (!Objects.equal(_elseBody, null));
      if (_notEquals) {
        _builder.append(" else {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        CharSequence _writeStatements_1 = this.writeStatements(statement.getElseBody());
        _builder.append(_writeStatements_1, "\t\t");
        _builder.append("\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
      } else {
        _builder.newLineIfNotEmpty();
        {
          Action _findAncestor = this._ismlModelNavigation.<If, Action>findAncestor(statement, Action.class);
          boolean _notEquals_1 = (!Objects.equal(_findAncestor, null));
          if (_notEquals_1) {
            {
              boolean _isUniqueStatement = this.isUniqueStatement(statement);
              if (_isUniqueStatement) {
                _builder.append("return \"\";");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    return _builder;
  }
  
  protected CharSequence _writeStatement(final For statement) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for (");
    String _firstUpper = StringExtensions.toFirstUpper(this._ismlModelNavigation.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(statement.getVariable().getType())));
    _builder.append(_firstUpper);
    _builder.append(" ");
    String _firstLower = StringExtensions.toFirstLower(statement.getVariable().getName());
    _builder.append(_firstLower);
    _builder.append(":");
    String _firstLower_1 = StringExtensions.toFirstLower(statement.getCollection().getReferencedElement().getName());
    _builder.append(_firstLower_1);
    _builder.append("){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _writeStatements = this.writeStatements(statement.getBody());
    _builder.append(_writeStatements, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _writeStatement(final Variable statement) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(this._ismlModelNavigation.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(statement.getType())));
    _builder.append(_firstUpper);
    _builder.append(" ");
    String _firstLower = StringExtensions.toFirstLower(statement.getName());
    _builder.append(_firstLower);
    {
      Expression _value = statement.getValue();
      boolean _notEquals = (!Objects.equal(_value, null));
      if (_notEquals) {
        _builder.append("=");
        {
          if (((!this._ismlModelNavigation.evaluateToCast(statement).isEmpty()) && (((Boolean) this._ismlModelNavigation.evaluateToCast(statement).get(0))).booleanValue())) {
            _builder.append("(");
            Object _get = this._ismlModelNavigation.evaluateToCast(statement).get(1);
            String _writeType = this._ismlModelNavigation.writeType(((Type) _get), true);
            _builder.append(_writeType);
            _builder.append(")");
          }
        }
        CharSequence _writeExpression = this._expressionTemplate.writeExpression(statement.getValue());
        _builder.append(_writeExpression);
      }
    }
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    {
      if (((!Objects.equal(this._ismlModelNavigation.<Variable, Action>findAncestor(statement, Action.class), null)) && ((Action) this._ismlModelNavigation.<Variable, Action>findAncestor(statement, Action.class)).isDefault())) {
        {
          if ((((!Objects.equal(this._ismlModelNavigation.<Variable, Controller>findAncestor(statement, Controller.class), null)) && ((Map<String, Type>) this._ismlModelNavigation.getNeededAttributes(((Controller) this._ismlModelNavigation.<Variable, Controller>findAncestor(statement, Controller.class))).get("neededAttributes")).containsKey(statement.getName())) && this._ismlModelNavigation.getTypeSpecification(((Map<String, Type>) this._ismlModelNavigation.getNeededAttributes(((Controller) this._ismlModelNavigation.<Variable, Controller>findAncestor(statement, Controller.class))).get("neededAttributes")).get(statement.getName())).getName().equals(this._ismlModelNavigation.getTypeSpecification(statement.getType()).getName()))) {
            _builder.append("this.");
            String _name = statement.getName();
            _builder.append(_name);
            _builder.append("=");
            String _name_1 = statement.getName();
            _builder.append(_name_1);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _writeStatement(final Show statement) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Expression _expression = statement.getExpression();
      EList<Expression> _parameters = ((Instance) _expression).getParameters();
      for(final Expression param : _parameters) {
        {
          if ((!(param instanceof NullValue))) {
            CharSequence _writeExpression = this._expressionTemplate.writeExpression(param);
            _builder.append(_writeExpression);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("return \"goTo");
    Expression _expression_1 = statement.getExpression();
    String _firstUpper = StringExtensions.toFirstUpper(this._ismlModelNavigation.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(((Instance) _expression_1).getType())));
    _builder.append(_firstUpper);
    _builder.append("\";\t\t");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _writeStatement(final Return statement) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("return ");
    {
      Expression _expression = statement.getExpression();
      boolean _notEquals = (!Objects.equal(_expression, null));
      if (_notEquals) {
        CharSequence _writeExpression = this._expressionTemplate.writeExpression(statement.getExpression());
        _builder.append(_writeExpression);
      }
    }
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _writeStatement(final Assignment statement) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (((((statement.getLeft() instanceof VariableReference) && (!Objects.equal(((VariableReference) statement.getLeft()).getTail(), null))) && 
        (((VariableReference) statement.getLeft()).getTail().getReferencedElement() instanceof Attribute)) && (!Objects.equal(statement.getRight(), null)))) {
        CharSequence _writeExpression = this._expressionTemplate.writeExpression(statement.getLeft());
        _builder.append(_writeExpression);
        _builder.append(" ( ");
        {
          if (((!this._ismlModelNavigation.evaluateToCast(statement).isEmpty()) && (((Boolean) this._ismlModelNavigation.evaluateToCast(statement).get(0))).booleanValue())) {
            _builder.append("(");
            Object _get = this._ismlModelNavigation.evaluateToCast(statement).get(1);
            String _writeType = this._ismlModelNavigation.writeType(((Type) _get), true);
            _builder.append(_writeType);
            _builder.append(")");
          }
        }
        CharSequence _writeExpression_1 = this._expressionTemplate.writeExpression(
          statement.getRight());
        _builder.append(_writeExpression_1);
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      } else {
        CharSequence _writeExpression_2 = this._expressionTemplate.writeExpression(statement.getLeft());
        _builder.append(_writeExpression_2);
        _builder.append(" ");
        String _symbol = statement.getSymbol();
        _builder.append(_symbol);
        _builder.append(" ");
        CharSequence _writeExpression_3 = this._expressionTemplate.writeExpression(statement.getRight());
        _builder.append(_writeExpression_3);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  /**
   * Metodo para determinar si es la unica instancia
   */
  public boolean isUniqueStatement(final EObject obj) {
    final EObject container = obj.eContainer();
    final EStructuralFeature containingFeature = obj.eContainingFeature();
    int _upperBound = containingFeature.getUpperBound();
    boolean _equals = (_upperBound == 1);
    if (_equals) {
      return true;
    } else {
      Object _eGet = container.eGet(containingFeature);
      final Collection<?> list = ((Collection<?>) _eGet);
      int _size = list.size();
      return (_size == 1);
    }
  }
  
  public CharSequence writeStatement(final MethodStatement statement) {
    if (statement instanceof For) {
      return _writeStatement((For)statement);
    } else if (statement instanceof If) {
      return _writeStatement((If)statement);
    } else if (statement instanceof Variable) {
      return _writeStatement((Variable)statement);
    } else if (statement instanceof While) {
      return _writeStatement((While)statement);
    } else if (statement instanceof Assignment) {
      return _writeStatement((Assignment)statement);
    } else if (statement instanceof Reference) {
      return _writeStatement((Reference)statement);
    } else if (statement instanceof Return) {
      return _writeStatement((Return)statement);
    } else if (statement instanceof Show) {
      return _writeStatement((Show)statement);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(statement).toString());
    }
  }
}
