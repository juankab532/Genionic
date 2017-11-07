/*
 * generated by Xtext
 */
package co.edu.javeriana.isml.scoping

import co.edu.javeriana.isml.isml.ActionCall
import co.edu.javeriana.isml.isml.Assignment
import co.edu.javeriana.isml.isml.Attribute
import co.edu.javeriana.isml.isml.Controller
import co.edu.javeriana.isml.isml.Entity
import co.edu.javeriana.isml.isml.Interface
import co.edu.javeriana.isml.isml.MethodCall
import co.edu.javeriana.isml.isml.Parameter
import co.edu.javeriana.isml.isml.Reference
import co.edu.javeriana.isml.isml.Type
import co.edu.javeriana.isml.isml.Variable
import co.edu.javeriana.isml.isml.VariableReference
import co.edu.javeriana.isml.validation.TypeChecker
import java.util.ArrayList
import java.util.HashSet
import javax.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider
import org.eclipse.xtext.util.PolymorphicDispatcher
import co.edu.javeriana.isml.isml.Service

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation.html#scoping
 * on how and when to use it 
 * 
 */
class IsmlScopeProvider extends AbstractDeclarativeScopeProvider {
	@Inject extension IsmlModelNavigation
	@Inject extension TypeChecker
	@Inject extension IQualifiedNameProvider
	@Inject extension ScopeExtension

	override protected def getPredicate(EObject context, EReference reference) {
		val methodName = "scope_" + context.eClass.getName() + "_" + reference.getName();
		return PolymorphicDispatcher.Predicates.forName(methodName, 2);
	}

	def IScope scope_VariableReference_referencedElement(VariableReference r, EReference ref) {
		try {
			val referencedVariables = new ArrayList<EObject>
			val allElementsInScope = r.allElementsInScope
			referencedVariables.addAll(allElementsInScope.filter(Parameter))
			referencedVariables.addAll(allElementsInScope.filter(Variable))
			val containerController = r.containerController
			if(containerController != null) {
				referencedVariables.addAll(containerController.allFeatures)
			}

			val parent = r.eContainer
			switch (parent) {
				VariableReference: {
					val parentType = parent.referencedElement?.type
					val parentClassifier = parentType?.typeSpecification
					if(parentClassifier != null) {
						referencedVariables.addAll(parentClassifier.allFeatures)
					}
				}
				Type: {
					val parentClassifier = parent.typeSpecification
					if(parentClassifier != null) {
						referencedVariables.addAll(parentClassifier.allFeatures)
					}
				}
			}
			return Scopes.scopeFor(referencedVariables)
		} catch(Throwable t) {
			t.printStackTrace
			return null
		}
	}

	def IScope scope_ResourceReference_referencedElement(Reference r, EReference ref) {
		val scopes = r.eContainer.getScope(ref)
		return scopes
	}

	def IScope scope_MethodCall_referencedElement(MethodCall call, EReference ref) {
		val parent = call.eContainer
		val scopes = new ArrayList<EObject>
//		scopes.addAll(call.containerController.allMethods)
		switch (parent) {
			Reference: {
				val parentType = parent.referencedElement.type
				val parentClassifier = parentType.typeSpecification
				if(parentClassifier instanceof Interface) {
					scopes.addAll(parentClassifier.allMethods.filter [ method |
						method.isCongruentWith(call)
					])
				}
				return Scopes.scopeFor(scopes)
			}
			default: {
				val containerService = call.findAncestor(Service)
				if(containerService != null) {
					scopes.addAll(containerService.allMethods.filter [ method |
						method.isCongruentWith(call)
					])
				}
				for (service : call.unnamedServices) {
					if(service.name == null) {
						scopes.addAll(service.allMethods.filter[method|method.isCongruentWith(call)])
					}
				}

				return Scopes.scopeFor(scopes)
			}
		}
	}

	def IScope scope_ActionCall_referencedElement(ActionCall caller, EReference ref) {
		var scope = IScope::NULLSCOPE
		try {
			val controllers = caller.eResource.resourceSet.getAllInstances(Controller)
			val candidateActions = controllers.map[getActions].flatten
			val actions = (candidateActions).filterCongruent(caller)
			scope = Scopes::scopeFor(actions, [ x |
				QualifiedName.create(x.containerController.name).append(x.name)
			], scope)
			val controller = caller.containerController
			if(controller != null) {
				scope = Scopes::scopeFor(controller.actions.filterCongruent(caller), scope)
			}
		} catch(Throwable t) {
			t.printStackTrace
		}
		return scope
	}

	def IScope scope_Assignment_element(Assignment a, EReference ref) {
		val scopes = new ArrayList<EObject>
		scopes.addAll(a.containerController.allFeatures)
		return Scopes.scopeFor(scopes)
	}

	def IScope scope_Attribute_opposite(Attribute a, EReference ref) {
		val oppositeEntity = a.oppositeEntity
		if(oppositeEntity != null) {
			val entity = a.eContainer
			if(entity instanceof Entity) {
				val opposites = new HashSet<Attribute>
				for (op : oppositeEntity.allAttributes) {
					val opTypeSpec = op.type.findEntityTypeSpec
					if(opTypeSpec != null && opTypeSpec.fullyQualifiedName.equals(entity.fullyQualifiedName)) {
						opposites.add(op)
					}
				}
				return Scopes::scopeFor(opposites)
			}
		}
		return IScope::NULLSCOPE
	}

	def is(IEObjectDescription desc, Class<? extends EObject> c) {
		c.isInstance(desc.getEObjectOrProxy)
	}

}