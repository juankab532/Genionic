/*
 * generated by Xtext
 */
package co.edu.javeriana.isml.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class IsmlAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("co/edu/javeriana/isml/parser/antlr/internal/InternalIsml.tokens");
	}
}
