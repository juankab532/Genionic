package co.edu.javeriana.generator.genionic.templates 


import co.edu.javeriana.isml.generator.common.SimpleTemplate
import co.edu.javeriana.isml.scoping.IsmlModelNavigation
import co.edu.javeriana.isml.validation.TypeChecker
import com.google.inject.Inject

import co.edu.javeriana.isml.isml.Page
import co.edu.javeriana.isml.isml.ViewInstance
import org.eclipse.emf.common.util.EList
import co.edu.javeriana.isml.isml.ViewStatement
import co.edu.javeriana.isml.isml.VariableReference
import java.util.LinkedHashMap
import co.edu.javeriana.isml.isml.NamedViewBlock
import co.edu.javeriana.isml.isml.ForView
import java.util.ArrayList

import co.edu.javeriana.isml.isml.ParameterizedReference
import co.edu.javeriana.isml.isml.Reference

import co.edu.javeriana.isml.isml.ActionCall
import co.edu.javeriana.isml.isml.Parameter
import co.edu.javeriana.isml.isml.Expression
import co.edu.javeriana.isml.isml.BoolValue
import co.edu.javeriana.isml.isml.FloatValue
import co.edu.javeriana.isml.isml.IntValue
import co.edu.javeriana.isml.isml.NullValue
import co.edu.javeriana.isml.isml.StringValue
import co.edu.javeriana.isml.isml.MethodCall

public class PageTemplate extends SimpleTemplate<Page>{
	@Inject extension TypeChecker
	@Inject extension IsmlModelNavigation 
	@Inject extension ExtraGenionic

	override preprocess(Page e) {
	}
	
	override def CharSequence template(Page page) '''	
		«IF page.body != null»
			«widgetTemplate(page.body)»
		«ENDIF»	
	'''
	
	/**
	 * Método para obtener las partes de cada componente de tipo block
	 * 
	 */
	def dispatch CharSequence widgetTemplate(EList<ViewStatement> partBlock)'''
		«IF partBlock != null»
			«FOR part : partBlock»	
				«widgetTemplate(part)»				
			«ENDFOR»
		«ENDIF»
			
	'''
	
	def dispatch CharSequence widgetTemplate(ViewInstance viewInstance) {
	
		switch (viewInstance.type.typeSpecification.typeSpecificationString) {
		
			case "Panel"		: panel(viewInstance)
			case "Form"			: form(viewInstance)
			case "Text"			: inputText(viewInstance)
			case "Image"		: image(viewInstance)
			case "Password"		: password(viewInstance)
			case "Link"			: link(viewInstance)
			case "Spinner"		: spinner(viewInstance)
			case "ComboChooser"	: comboChooser(viewInstance)
			case "Select"		: select(viewInstance)
			case "RadioChooser"	: radioChooser(viewInstance)
			case "Calendar"		: calendar(viewInstance)
			case "Media"		: media(viewInstance)
			case "Label"		: label(viewInstance)
			case "CheckBox"		: checkBox(viewInstance)
			case "Button"		: button(viewInstance)
			case "PanelButton"	: panelButton(viewInstance)
			case "DataTable"	: dataTable(viewInstance)	
			case "MobileMap"	: map(viewInstance)
			case "Cam"			: camera(viewInstance)
			case "OutputText"	: OutputText(viewInstance)
			  
		}
		
	}
	
	def CharSequence OutputText(ViewInstance part) '''	
		<ion-input 
			type="text" 
			placeholder="«part.parameters.get(0).getValue»"
			[(ngModel)]="«part.parameters.get(1).getValue»"
			clearInput="true"
			class="form-control"
			readonly
		required></ion-input>
	'''	
	
	def CharSequence camera(ViewInstance instance) '''
		«label(instance)»
	    <button ion-button (click)="«instance.actionCall?.action?.name»(«FOR param:instance.actionCall.parameters SEPARATOR ','»«IF param instanceof VariableReference && (param as VariableReference).referencedElement.eContainer instanceof Page»«(instance.findAncestor(Page)as Page).controller.name.toFirstLower».«ENDIF»«ENDFOR»)">«instance.parameters.get(0).getValue»</button>
	    <div class="divPicture"><img class="imgPicture" [src]="«instance.parameters.get(2).getValue»" *ngIf="«instance.parameters.get(2).getValue»" /></div>
	'''
	
	def CharSequence map(ViewInstance instance) '''
		<div #«instance.parameters.get(0).getValue» id="«instance.parameters.get(0).getValue»" class="mapa"></div>
	'''
	def CharSequence panel(ViewInstance instance) '''
		<ion-header>
			 <ion-navbar color="primary">
			    <button ion-icon menuToggle>
			      <ion-icon name="menu"></ion-icon>
			    </button>
			    <ion-title>«instance.parameters.get(0).getValue»</ion-title>
			 </ion-navbar>
		</ion-header>
		<ion-content padding>
			<div class="list">
			«FOR partBlock : instance.body»
					«widgetTemplate(partBlock)»
			«ENDFOR»
			</div>
		</ion-content>
	'''
	def CharSequence form(ViewInstance part) '''
		<form #form="«part.name»">
			<div class="list">
			«FOR partBlock : part.getBody»
			«widgetTemplate(partBlock)»
			«ENDFOR»
			</div>
		</form>
	'''
	def CharSequence inputText(ViewInstance part) '''
		<label class="item item-input item-floating-label">
		<span class="input-label">«part.parameters.get(0).getValue»</span>
		<ion-input 
			type="text" 
			name="«part.parameters.get(0).getValue»"
			min="«part.parameters.get(3).getValue»"
			max="«part.parameters.get(2).getValue»"
			placeholder="«part.parameters.get(0).getValue»"
			[(ngModel)]="«part.parameters.get(1).getValue»"
			clearInput="true"
			class="form-control"
		required></ion-input>
		</label>
		
	'''
	def CharSequence text(ViewInstance part) '''
		«label(part)»
		<ion-textarea 
			name="«part.parameters.get(0).getValue»"
			min="«part.parameters.get(3).getValue»"
			max="«part.parameters.get(2).getValue»"
			[(ngModel)]="«part.parameters.get(1).getValue»"
			placeholder="«part.parameters.get(0).getValue»"
			clearInput="true"
			class="form-control"
		></ion-textarea>
	'''
	def CharSequence image(ViewInstance part) '''
		<img src="«part.parameters.get(0).getValue»">
	'''
	def CharSequence password(ViewInstance part) '''
		«label(part)»
		<ion-input 
			type="password" 
			name="«part.parameters.get(0).getValue»"
			min="«part.parameters.get(3).getValue»"
			max="«part.parameters.get(2).getValue»"
			placeholder="«part.parameters.get(0).getValue»"
			clearInput="true"
			class="form-control"
		required></ion-input>
	'''
	def CharSequence link(ViewInstance part) '''
		<a href="«part.parameters.get(1).getValue»">«part.parameters.get(0).getValue»</a>
	'''
	def CharSequence spinner(ViewInstance part) '''
		<ion-spinner></ion-spinner>
	'''
	def CharSequence comboChooser(ViewInstance part) '''
		«label(part)»
		<ion-select #«part.parameters.get(0).getValue» >
		    <ion-option value="">«part.parameters.get(3).getValue»</ion-option>
		</ion-select>
	'''
	
	def CharSequence select(ViewInstance part) '''
		«label(part)»
		<ion-select [(ngModel)]="«part.parameters.get(1).getValue»" name="«part.parameters.get(1).getValue»" class="form-control" placeholder="«part.parameters.get(0).getValue»" required> 
			<ion-option value="">Seleccione...</ion-option>
		    <ion-option  *ngFor="let valSel of «part.parameters.get(2).getValue»"  value="{{valSel.«part.parameters.get(3).getValue»}}">{{valSel.«part.parameters.get(4).getValue»}}</ion-option>
		</ion-select>
	'''
	
	def CharSequence radioChooser(ViewInstance part) '''		
		«label(part)»
		<ion-list radio-group [(ngModel)]="«part.parameters.get(2).getValue»">
		  <ion-item>
			<ion-radio *ngFor="let valSel of «part.parameters.get(1).getValue»" value="value="{{valSel.id}}" checked><ion-label>{{valSel.name}}</ion-label></ion-radio>
		  </ion-item>
		</ion-list>
	'''
	def CharSequence calendar(ViewInstance part) '''
		«label(part)»
		 <ion-datetime displayFormat="MM/DD/YYYY" [(ngModel)]="«part.parameters.get(0).getValue»"
		    name="«part.parameters.get(0).getValue»"
		 	value="«part.parameters.get(1).getValue»"
		 	class="form-control"
		 >
		 </ion-datetime>
	'''
	def CharSequence media(ViewInstance part) '''
		<iframe width="«part.parameters.get(1).getValue»" height="«part.parameters.get(2).getValue»"  src="«part.parameters.get(0).getValue»" frameborder="0" allowfullscreen></iframe>	
	'''
	def CharSequence label(ViewInstance part) '''
		<ion-label class="input-label">«part.parameters.get(0).getValue»</ion-label>
	'''
	def CharSequence checkBox(ViewInstance part) '''
		«label(part)»
		<ion-checkbox required></ion-checkbox>
	'''
	def CharSequence button(ViewInstance part) '''
		<button ion-button (click)="«part.actionCall?.action?.name»(«part.actionCall?.generateParametersActionCall»)" >«part.parameters.get(0).getValue»</button>
	'''
	def CharSequence panelButton(ViewInstance instance) '''
		<ion-list> 
			«FOR partBlock : instance.body»
			<ion-item>
				«widgetTemplate(partBlock)»
			</ion-item>
			«ENDFOR»
		</ion-list>
	'''	
	def CharSequence dataTable(ViewInstance table) '''
		<ion-grid>
				<ion-row align-items-center>
  				    «FOR pair : table.getColumnsDataTable.entrySet»
  				    «val viewInstance = pair.key as ViewInstance»
  				    <ion-col class="colHeader">«widgetTemplate(viewInstance)»</ion-col>
   					«ENDFOR»
				</ion-row>
				<ion-row  *ngFor="let «table.forViewInBody.variable.name» of «table.forViewInBody?.collection.referencedElement.name» ">
  					«val forView = table.body.get(1).cast(NamedViewBlock).body.get(0) as ForView»
  					«val tiposColumnas = new ArrayList<String>»
  					«FOR i : 0 ..< forView.body.size»
  						«var elemento = forView.body.get(i)»
  						«var tipo = elemento.type.referencedElement.name»
  						«{ tiposColumnas.add(tipo); "" }»
  					«ENDFOR»
		
  					«var i = 0»
  					«FOR pair : table.getColumnsDataTable.entrySet»
  						«val tipoColumna = tiposColumnas.get(i)»
  						«IF "Button".equals(tipoColumna)»
  							<ion-col>«widgetTemplate(pair.value)»</ion-col>
	 					«ELSE»
  							<ion-col>«widgetTemplate(pair.value)»</ion-col>		 
 						«ENDIF»
 						«{ i = i + 1; "" }»
   					«ENDFOR»
				</ion-row>
		</ion-grid>
	'''	

	/**
	 * Método para obtener las columnas de un datatable
	 * 
	 */
	def getColumnsDataTable(ViewInstance table) {
		val columns = new LinkedHashMap<ViewStatement, ViewStatement>
		val header = table.body.get(0) as NamedViewBlock
		val forView = table.body.get(1).cast(NamedViewBlock).body.get(0) as ForView
		for (i : 0 ..< header.body.size) {
			columns.put(header.body.get(i), forView.body.get(i))
			
		}
		return columns
	}
	
	def CharSequence generateParametersActionCall(ActionCall call) {
		var generatedParameters= ''''''
		if(call.parameters.size>0){
			generatedParameters='''«FOR param: call.parameters»«generateReferencedElement(param as Reference)»«ENDFOR»'''
		}
		return generatedParameters
	}
	
	def CharSequence getValue(Expression e){
		switch e{
			BoolValue		: e.literal.toString
			FloatValue		: e.literal.toString
			IntValue		: e.literal.toString
			NullValue		: "undefined"
			StringValue		: e.literal.toString
			MethodCall		: "call"
			VariableReference: if (hasTail(e)) generateTailedElement(e) else e.referencedElement.name
			default: e.toString
		}
	}
	
	

}
