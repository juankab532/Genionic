package co.edu.javeriana.isml;

import org.eclipse.xtext.naming.IQualifiedNameConverter;

@SuppressWarnings("all")
public class IsmlQualifiedNameConverter extends IQualifiedNameConverter.DefaultImpl {
  @Override
  public String getDelimiter() {
    return ".";
  }
}
