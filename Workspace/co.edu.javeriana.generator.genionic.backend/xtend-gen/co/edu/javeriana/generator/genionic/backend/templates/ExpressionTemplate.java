package co.edu.javeriana.generator.genionic.backend.templates;

import co.edu.javeriana.generator.genionic.backend.templates.ReferenceTemplate;
import co.edu.javeriana.isml.isml.Action;
import co.edu.javeriana.isml.isml.ActionCall;
import co.edu.javeriana.isml.isml.BinaryOperator;
import co.edu.javeriana.isml.isml.Controller;
import co.edu.javeriana.isml.isml.Expression;
import co.edu.javeriana.isml.isml.Instance;
import co.edu.javeriana.isml.isml.IntValue;
import co.edu.javeriana.isml.isml.LiteralValue;
import co.edu.javeriana.isml.isml.MethodStatement;
import co.edu.javeriana.isml.isml.Page;
import co.edu.javeriana.isml.isml.Reference;
import co.edu.javeriana.isml.isml.Show;
import co.edu.javeriana.isml.isml.StringValue;
import co.edu.javeriana.isml.isml.Type;
import co.edu.javeriana.isml.isml.UnaryOperator;
import co.edu.javeriana.isml.scoping.IsmlModelNavigation;
import co.edu.javeriana.isml.validation.TypeChecker;
import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ExpressionTemplate {
  @Inject
  @Extension
  private IsmlModelNavigation _ismlModelNavigation;
  
  @Inject
  @Extension
  private TypeChecker _typeChecker;
  
  @Inject
  @Extension
  private ReferenceTemplate _referenceTemplate;
  
  protected CharSequence _writeExpression(final Type expression) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(this._ismlModelNavigation.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(expression)));
    _builder.append(_firstUpper);
    _builder.append(".class");
    return _builder;
  }
  
  protected CharSequence _writeExpression(final Instance expression) {
    String _xblockexpression = null;
    {
      String text = "";
      EObject _eContainer = expression.eContainer().eContainer();
      if ((_eContainer instanceof Show)) {
        Controller _findAncestor = this._ismlModelNavigation.<Instance, Controller>findAncestor(expression, Controller.class);
        Controller controller = ((Controller) _findAncestor);
        Object _get = this._ismlModelNavigation.getNeededAttributes(controller).get(
          "neededAttributes");
        Map<String, Type> neededAttributes = ((Map<String, Type>) _get);
        Set<Map.Entry<String, Type>> _entrySet = neededAttributes.entrySet();
        for (final Map.Entry<String, Type> entry : _entrySet) {
          boolean _equals = this._ismlModelNavigation.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(entry.getValue())).equals(
            this._ismlModelNavigation.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(expression.getType())));
          if (_equals) {
            String _text = text;
            String _key = entry.getKey();
            String _plus = ("this." + _key);
            String _plus_1 = (_plus + "=");
            text = (_text + _plus_1);
          }
        }
      }
      String _xifexpression = null;
      boolean _isMapModel = this._typeChecker.isMapModel(expression.getType());
      boolean _not = (!_isMapModel);
      if (_not) {
        String _xblockexpression_1 = null;
        {
          String _text_1 = text;
          String _firstUpper = StringExtensions.toFirstUpper(this._ismlModelNavigation.getTypeSpecificationString(this._ismlModelNavigation.getTypeSpecification(expression.getType())));
          String _plus_2 = ("new " + _firstUpper);
          String _plus_3 = (_plus_2 + "(");
          text = (_text_1 + _plus_3);
          int i = 0;
          EList<Expression> _parameters = expression.getParameters();
          for (final Expression parameter : _parameters) {
            {
              String _text_2 = text;
              CharSequence _writeExpression = this.writeExpression(parameter);
              text = (_text_2 + _writeExpression);
              int _size = expression.getParameters().size();
              int _minus = (_size - 1);
              boolean _notEquals = (i != _minus);
              if (_notEquals) {
                String _text_3 = text;
                text = (_text_3 + ",");
              }
              i++;
            }
          }
          String _text_2 = text;
          _xblockexpression_1 = text = (_text_2 + ")");
        }
        _xifexpression = _xblockexpression_1;
      } else {
        String _xblockexpression_2 = null;
        {
          Controller _findAncestor_1 = this._ismlModelNavigation.<Instance, Controller>findAncestor(expression, Controller.class);
          Controller control = ((Controller) _findAncestor_1);
          Object _get_1 = this._ismlModelNavigation.getNeededAttributes(control).get(
            "neededAttributes");
          Map<String, Type> neededAttributesMap = ((Map<String, Type>) _get_1);
          String _text_1 = text;
          String _key_1 = ((Map.Entry<String, Type>[])Conversions.unwrapArray(neededAttributesMap.entrySet(), Map.Entry.class))[0].getKey();
          String _plus_2 = (("new DefaultMapModel();" + 
            "for (Lugares lugar : this.") + _key_1);
          String _plus_3 = (_plus_2 + ") {\r\n                LatLng coord1 = new LatLng(Double.parseDouble(lugar.getCoordenada1()), Double.parseDouble(lugar.getCoordenada2()));\r\n                getSimpleModel().addOverlay(new Marker(coord1, lugar.getDescripcion()));\r\n            }");
          _xblockexpression_2 = text = (_text_1 + _plus_3);
        }
        _xifexpression = _xblockexpression_2;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected CharSequence _writeExpression(final BinaryOperator expression) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _writeExpression = this.writeExpression(expression.getLeft());
    _builder.append(_writeExpression);
    _builder.append(" ");
    CharSequence _writeSymbol = this.writeSymbol(expression.getSymbol());
    _builder.append(_writeSymbol);
    _builder.append(" ");
    CharSequence _writeExpression_1 = this.writeExpression(expression.getRight());
    _builder.append(_writeExpression_1);
    return _builder;
  }
  
  protected CharSequence _writeExpression(final UnaryOperator expression) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _writeSymbol = this.writeSymbol(expression.getSymbol());
    _builder.append(_writeSymbol);
    _builder.append(" ");
    CharSequence _writeExpression = this.writeExpression(expression.getExpression());
    _builder.append(_writeExpression);
    return _builder;
  }
  
  protected CharSequence _writeExpression(final LiteralValue expression) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _writeLiteral = this.writeLiteral(expression);
    _builder.append(_writeLiteral);
    return _builder;
  }
  
  protected CharSequence _writeExpression(final Reference reference) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _writeReference = this._referenceTemplate.writeReference(reference);
    _builder.append(_writeReference);
    return _builder;
  }
  
  /**
   * Este método escribe el equivalente en java de los símbolos (Operadores Binarios)
   * utilizados en el lenguaje ISML
   */
  public CharSequence writeSymbol(final String symbol) {
    boolean _equals = symbol.equals("and");
    if (_equals) {
      return "&&";
    } else {
      boolean _equals_1 = symbol.equals("or");
      if (_equals_1) {
        return "||";
      } else {
        boolean _equals_2 = symbol.equals("not");
        if (_equals_2) {
          return "!";
        } else {
          return symbol;
        }
      }
    }
  }
  
  /**
   * Este método escribe los valores literales para JAVA
   */
  public CharSequence writeLiteral(final LiteralValue literal) {
    if ((literal instanceof StringValue)) {
      Object _literal = ((StringValue)literal).getLiteral();
      String _plus = ("\"" + _literal);
      return (_plus + "\"");
    } else {
      if (((literal instanceof IntValue) && Objects.equal(this._ismlModelNavigation.<LiteralValue, Page>findAncestor(literal, Page.class), null))) {
        Object _literal_1 = literal.getLiteral();
        return (_literal_1 + "L");
      } else {
        return literal.getLiteral().toString();
      }
    }
  }
  
  /**
   * Este método busca los controladores de los ActionCall que puedan existir en el
   * Controller que entra por parámetros, para ser inyectados como atributos del
   * BackingBean
   */
  public EList<Controller> getActionCallControllers(final Controller controller) {
    EList<Controller> actionCallList = new BasicEList<Controller>();
    Iterable<Action> _actions = this._ismlModelNavigation.getActions(controller);
    for (final Action action : _actions) {
      EList<MethodStatement> _body = action.getBody();
      boolean _notEquals = (!Objects.equal(_body, null));
      if (_notEquals) {
        EList<MethodStatement> _body_1 = action.getBody();
        for (final MethodStatement statement : _body_1) {
          if ((statement instanceof ActionCall)) {
            EObject _eContainer = this._ismlModelNavigation.getAction(((ActionCall)statement)).eContainer();
            Controller c = ((Controller) _eContainer);
            if (((!actionCallList.contains(c)) && (!c.getName().equals(controller.getName())))) {
              actionCallList.add(c);
            }
          }
        }
      }
    }
    return actionCallList;
  }
  
  public CharSequence writeExpression(final Expression expression) {
    if (expression instanceof Type) {
      return _writeExpression((Type)expression);
    } else if (expression instanceof Instance) {
      return _writeExpression((Instance)expression);
    } else if (expression instanceof Reference) {
      return _writeExpression((Reference)expression);
    } else if (expression instanceof BinaryOperator) {
      return _writeExpression((BinaryOperator)expression);
    } else if (expression instanceof LiteralValue) {
      return _writeExpression((LiteralValue)expression);
    } else if (expression instanceof UnaryOperator) {
      return _writeExpression((UnaryOperator)expression);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(expression).toString());
    }
  }
}
