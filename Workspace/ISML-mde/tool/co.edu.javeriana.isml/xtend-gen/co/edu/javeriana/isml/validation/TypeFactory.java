package co.edu.javeriana.isml.validation;

import co.edu.javeriana.isml.isml.GenericTypeSpecification;
import co.edu.javeriana.isml.isml.IsmlFactory;
import co.edu.javeriana.isml.isml.ParameterizedType;
import co.edu.javeriana.isml.isml.Primitive;
import co.edu.javeriana.isml.isml.Type;
import co.edu.javeriana.isml.isml.TypeSpecification;
import co.edu.javeriana.isml.scoping.IsmlModelNavigation;
import com.google.inject.Inject;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class TypeFactory {
  @Inject
  @Extension
  private IsmlModelNavigation _ismlModelNavigation;
  
  public Type getPrimitiveType(final Resource r, final String name) {
    final TypeSpecification primitive = this.getPrimitiveTypeSpecification(r, name);
    return this.createType(primitive);
  }
  
  public ParameterizedType getPrimitiveType(final Resource r, final String name, final Type... typeParameters) {
    final TypeSpecification primitive = this.getPrimitiveTypeSpecification(r, name);
    return this.createType(primitive, typeParameters);
  }
  
  public TypeSpecification getPrimitiveTypeSpecification(final Resource r, final String name) {
    TypeSpecification _xblockexpression = null;
    {
      final Collection<Primitive> primitives = this._ismlModelNavigation.<Primitive>getAllInstances(r.getResourceSet(), Primitive.class);
      Primitive _findByName = this._ismlModelNavigation.<Primitive>findByName(primitives, name);
      final TypeSpecification primitive = ((TypeSpecification) _findByName);
      _xblockexpression = primitive;
    }
    return _xblockexpression;
  }
  
  public Type createType(final TypeSpecification c) {
    boolean _isEmpty = c.getGenericTypeParameters().isEmpty();
    if (_isEmpty) {
      final Type type = IsmlFactory.eINSTANCE.createType();
      this._ismlModelNavigation.setTypeSpecification(type, c);
      return type;
    } else {
      final ParameterizedType type_1 = IsmlFactory.eINSTANCE.createParameterizedType();
      EList<GenericTypeSpecification> _genericTypeParameters = c.getGenericTypeParameters();
      for (final GenericTypeSpecification genTypeSpec : _genericTypeParameters) {
        type_1.getTypeParameters().add(this.createType(genTypeSpec));
      }
      return type_1;
    }
  }
  
  public ParameterizedType createType(final TypeSpecification c, final Type... typeParameters) {
    final ParameterizedType type = IsmlFactory.eINSTANCE.createParameterizedType();
    this._ismlModelNavigation.setTypeSpecification(type, c);
    for (final Type param : typeParameters) {
      type.getTypeParameters().add(EcoreUtil.<Type>copy(param));
    }
    return type;
  }
}
