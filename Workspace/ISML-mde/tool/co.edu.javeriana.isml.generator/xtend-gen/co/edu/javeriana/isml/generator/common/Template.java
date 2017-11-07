package co.edu.javeriana.isml.generator.common;

@SuppressWarnings("all")
public interface Template<T extends Object> {
  public abstract void preprocess(final T e);
  
  public abstract CharSequence toText(final T e);
  
  public abstract String getId();
}
