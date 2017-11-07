/**
 * generated by Xtext
 */
package co.edu.javeriana.isml.formatting;

import co.edu.javeriana.isml.services.IsmlGrammarAccess;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.util.Pair;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation.html#formatting
 * on how and when to use it
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
@SuppressWarnings("all")
public class IsmlFormatter extends AbstractDeclarativeFormatter {
  @Override
  protected void configureFormatting(final FormattingConfig c) {
    IGrammarAccess _grammarAccess = this.getGrammarAccess();
    IsmlGrammarAccess grammar = ((IsmlGrammarAccess) _grammarAccess);
    c.setAutoLinewrap(120);
    List<Pair<Keyword, Keyword>> _findKeywordPairs = grammar.findKeywordPairs("{", "}");
    for (final Pair<Keyword, Keyword> pair : _findKeywordPairs) {
      {
        this.getConfig().setIndentation(pair.getFirst(), pair.getSecond());
        this.getConfig().setLinewrap(1).before(pair.getSecond());
      }
    }
    c.setLinewrap(1, 2, 3).around(grammar.getStructInstanceRule());
    c.setLinewrap(1, 2, 3).around(grammar.getNamedViewBlockRule());
    c.setLinewrap(1, 2, 3).around(grammar.getViewInstanceRule());
    c.setLinewrap(1, 2, 3).around(grammar.getAttributeRule());
    c.setLinewrap(1, 2, 3).around(grammar.getVariableRule());
    c.setLinewrap(1, 2, 3).around(grammar.getForRule());
    c.setLinewrap(1, 2, 3).around(grammar.getIfRule());
    c.setLinewrap(1, 2, 3).around(grammar.getWhileRule());
    c.setLinewrap(1, 2, 3).around(grammar.getMethodCallRule());
    c.setLinewrap(1, 2, 3).around(grammar.getReferenceStatementRule());
    c.setLinewrap(1, 2, 3).around(grammar.getImportRule());
    c.setLinewrap(1, 2, 3).around(grammar.getEntityRule());
    c.setLinewrap(1, 2, 3).around(grammar.getControllerRule());
    c.setLinewrap(1, 2, 3).around(grammar.getPageRule());
    c.setLinewrap(1, 2, 3).around(grammar.getWidgetRule());
    c.setLinewrap(1, 2, 3).around(grammar.getPrimitiveRule());
    c.setLinewrap(1, 2, 3).around(grammar.getResourceAssignmentRule());
    c.setLinewrap(1, 2, 3).around(grammar.getConstraintRule());
    c.setLinewrap(1, 2, 3).around(grammar.getServiceRule());
    c.setLinewrap(1, 2, 3).around(grammar.getActorRule());
    c.setLinewrap(1, 2, 3).around(grammar.getIfViewRule());
    c.setLinewrap(1, 2, 3).around(grammar.getViewStatementRule());
    c.setLinewrap(1, 2, 3).around(grammar.getActionRule());
    c.setLinewrap(1, 2, 3).around(grammar.getMethodRule());
    c.setLinewrap(1, 2, 3).around(grammar.getShowRule());
    c.setLinewrap(1, 2, 3).around(grammar.getResourceRule());
    c.setLinewrap(1, 2, 3).around(grammar.getResourceBundleRule());
    c.setLinewrap(1, 2, 3).after(grammar.getPackageRule());
    c.setLinewrap(0, 1, 2).before(grammar.getSL_COMMENTRule());
    c.setLinewrap(0, 1, 2).before(grammar.getML_COMMENTRule());
    c.setLinewrap(0, 1, 1).after(grammar.getML_COMMENTRule());
    final Consumer<Keyword> _function = (Keyword x) -> {
      c.setSpace(" ").before(x);
    };
    grammar.findKeywords("else").forEach(_function);
    final Consumer<Keyword> _function_1 = (Keyword x) -> {
      c.setLinewrap(1, 2, 3).before(x);
    };
    grammar.findKeywords("before").forEach(_function_1);
    final Consumer<Keyword> _function_2 = (Keyword x) -> {
      c.setLinewrap(1, 2, 3).before(x);
    };
    grammar.findKeywords("after").forEach(_function_2);
    final Consumer<Keyword> _function_3 = (Keyword x) -> {
      c.setLinewrap(1, 2, 3).before(x);
    };
    grammar.findKeywords("resources").forEach(_function_3);
    final Consumer<Keyword> _function_4 = (Keyword x) -> {
      c.setSpace(" ").around(x);
    };
    grammar.findKeywords("=").forEach(_function_4);
    List<Keyword> _findKeywords = grammar.findKeywords(",");
    for (final Keyword comma : _findKeywords) {
      c.setNoSpace().before(comma);
    }
    List<Keyword> _findKeywords_1 = grammar.findKeywords("$");
    for (final Keyword dollar : _findKeywords_1) {
      c.setNoSpace().after(dollar);
    }
    List<Keyword> _findKeywords_2 = grammar.findKeywords(".");
    for (final Keyword dot : _findKeywords_2) {
      {
        c.setNoSpace().before(dot);
        c.setNoSpace().after(dot);
      }
    }
    List<Keyword> _findKeywords_3 = grammar.findKeywords("..");
    for (final Keyword dotdot : _findKeywords_3) {
      {
        c.setNoSpace().before(dotdot);
        c.setNoSpace().after(dotdot);
      }
    }
    List<Keyword> _findKeywords_4 = grammar.findKeywords("[");
    for (final Keyword bracket : _findKeywords_4) {
      {
        c.setNoSpace().before(bracket);
        c.setNoSpace().after(bracket);
      }
    }
    List<Keyword> _findKeywords_5 = grammar.findKeywords("]");
    for (final Keyword bracket_1 : _findKeywords_5) {
      c.setNoSpace().before(bracket_1);
    }
    List<Keyword> _findKeywords_6 = grammar.findKeywords("(");
    for (final Keyword bracket_2 : _findKeywords_6) {
      {
        c.setNoSpace().before(bracket_2);
        c.setNoSpace().after(bracket_2);
      }
    }
    List<Keyword> _findKeywords_7 = grammar.findKeywords(")");
    for (final Keyword bracket_3 : _findKeywords_7) {
      c.setNoSpace().before(bracket_3);
    }
    List<Keyword> _findKeywords_8 = grammar.findKeywords(".*");
    for (final Keyword wildcard : _findKeywords_8) {
      c.setNoSpace().before(wildcard);
    }
  }
}