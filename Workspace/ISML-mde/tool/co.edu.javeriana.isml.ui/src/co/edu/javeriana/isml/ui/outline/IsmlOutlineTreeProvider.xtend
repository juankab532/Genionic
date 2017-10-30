/*
 * generated by Xtext
 */
package co.edu.javeriana.isml.ui.outline

import co.edu.javeriana.isml.isml.Action
import co.edu.javeriana.isml.isml.ActionCall
import co.edu.javeriana.isml.isml.Attribute
import co.edu.javeriana.isml.isml.CompositeElement
import co.edu.javeriana.isml.isml.Constraint
import co.edu.javeriana.isml.isml.Controller
import co.edu.javeriana.isml.isml.Element
import co.edu.javeriana.isml.isml.Entity
import co.edu.javeriana.isml.isml.ForView
import co.edu.javeriana.isml.isml.Function
import co.edu.javeriana.isml.isml.IfView
import co.edu.javeriana.isml.isml.Import
import co.edu.javeriana.isml.isml.InformationSystem
import co.edu.javeriana.isml.isml.Instance
import co.edu.javeriana.isml.isml.Method
import co.edu.javeriana.isml.isml.Page
import co.edu.javeriana.isml.isml.Parameter
import co.edu.javeriana.isml.isml.ParameterizedType
import co.edu.javeriana.isml.isml.Reference
import co.edu.javeriana.isml.isml.Type
import co.edu.javeriana.isml.isml.ViewInstance
import co.edu.javeriana.isml.scoping.IsmlModelNavigation
import com.google.inject.Inject
import org.eclipse.emf.common.util.EList
import org.eclipse.swt.graphics.Image
import org.eclipse.xtext.ui.IImageHelper
import org.eclipse.xtext.ui.editor.outline.IOutlineNode
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode

/**
 * Customization of the default outline structure.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#outline
 */
class IsmlOutlineTreeProvider extends DefaultOutlineTreeProvider {
	@Inject extension IImageHelper
	@Inject extension IsmlModelNavigation

	protected def _createChildren(DocumentRootNode parentNode, InformationSystem is) {
		for (element : is.components) {
			createNode(parentNode, element);
		}
	}

	protected def _createNode(IOutlineNode parentNode, Import imp) {
		// do nothing
	}

	protected def _createNode(IOutlineNode parentNode, Parameter par) {
		// do nothing
	}

	protected def _createNode(IOutlineNode parentNode, Type t) {
		// do nothing
	}

	protected def <T extends Element> _createChildren(IOutlineNode parentNode, CompositeElement<T> statement) {

		for (block : statement.body) {
			createNode(parentNode, block)
		}

	}

	protected def _createChildren(IOutlineNode parentNode, Action action) {
		// do nothing
	}

	protected dispatch def String toText(ParameterizedType type) '''
	«type.typeSpecification.name»«type.typeParameters.toText»'''

	protected dispatch def String toText(Type type) '''
	«type.typeSpecification.name»'''

	protected def String toText(Iterable<Type> typeParams) '''
	«IF typeParams != null»<«FOR t : typeParams SEPARATOR ','»«t.toText»«ENDFOR»>«ENDIF»'''

	protected def String _text(Attribute attr) '''
	«attr.type.toText» «attr.name»«attr.oppositeToText»'''

	protected def String oppositeToText(Attribute attr) '''
	«IF attr.opposite != null» -- «attr.opposite.name»«ENDIF»'''

	protected def String _text(Action action) '''
	«action?.name» «action?.parameters?.toText»'''

	protected def String _text(Method method) '''
	«method.type.toText» «method?.name» «method?.parameters?.toText»'''

//	protected def _createNode(IOutlineNode parentNode, CompositeStatement block) {
//		if(block.eContainer.eContents.filter(ViewBlock).size > 1) {
//			_createNode(parentNode, block as EObject)
//		} else {
//			for (element : block.statements) {
//				createNode(parentNode, element)
//			}
//		}
//	}
	protected def _createChildren(IOutlineNode parentNode, IfView ifvp) {
		for (element : ifvp.body) {
			createNode(parentNode, element)
		}
	}

	protected def String _text(ViewInstance vi) '''
	«vi.type.typeSpecification.name»«vi.type.typeSpecification.parameters?.toText» «vi.actionCall?.toText»'''

	def String toText(EList<Parameter> params) '''
	«if(!params.empty) "("»«FOR p : params SEPARATOR ","»«p.type.typeSpecification.name»«ENDFOR»«if(!params.empty) ")"»'''

	protected def String _text(IfView ifvp) '''if'''

	protected def String _text(Reference ref) {
		var str = "" + ref.referencedElement.name
		var r = ref.tail
		while(r != null) {
			str += "." + r.referencedElement.name
			r = r.tail
		}
		str
	}

	def String toText(ActionCall actionCall) '''
	-> «actionCall.referencedElement.name» «(actionCall.referencedElement as Function).parameters?.toText»'''

	def String _text(Instance inst) '''
	«inst.type.toText»«inst.type.typeSpecification.parameters.toText»'''

	def String _text(ForView f) '''
	for («f.variable.name» in «f.collection.referencedElement.name»)'''

	def Image _image(Method m) {
		return getImage("blueSquare.png")
	}

	def Image _image(Action a) {
		return getImage("blueArrow.png")
	}

	def Image _image(Entity e) {
		return getImage("entity.png")
	}

	def Image _image(Attribute a) {
		return getImage("greenDot.png")
	}

	def Image _image(Package a) {
		return getImage("package.png")
	}

	def Image _image(Page p) {
		return getImage("view.png")
	}

	def Image _image(Controller c) {
		return getImage("controller.png")
	}

	def Image _image(Instance inst) {
		if(inst.type.typeSpecification instanceof Constraint) {
			getImage("chain.png")
		} else {
			getImage("default.png")
		}
	}

	def Image _image(ViewInstance vi) {
		return getImage("default.png")
	}

	def Image _image(IfView ifvp) {
		return getImage("default.png")
	}

}
