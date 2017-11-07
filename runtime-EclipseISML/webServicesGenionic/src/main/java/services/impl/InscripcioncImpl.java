package services.impl;				

import backend.entities.FacultadE;
	
import java.util.*;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import common.services.Persistence;
import backend.entities.*;
 
import services.interfaces.Inscripcionc;


/**
 * This class represents an EJB named InscripcioncImpl
 */
@Stateless
public class InscripcioncImpl extends Persistence<InscripcionE> implements Inscripcionc,Serializable{
	
   @PersistenceContext
    private EntityManager entityManager;
	
	protected  EntityManager getEntityManager() {
		return entityManager;
	}
	
	
	
	
	/**
	 * Service default constructor
	 */
	public InscripcioncImpl(){
		super(InscripcionE.class);
	}
	
	/**
	 * This method executes the proper actions for remove
	 * @param obj Parameter from type T
	 */
	@Override
	public void remove(InscripcionE obj){
		super.remove(obj);	
	}
	/**
	 * This method executes the proper actions for remove
	 * @param id Parameter from type Integer
	 */
	@Override
	public void remove(Long id){
		super.remove(id);	
	}
	/**
	 * This method executes the proper actions for create
	 * @param obj Parameter from type T
	 */
	@Override
	public void create(InscripcionE obj){
		super.create(obj);	
	}
	/**
	 * This method executes the proper actions for findAll
	 * @return Some List object
	 */
	@Override
	public List findAll(){
		return super.findAll();
	}
	/**
	 * This method executes the proper actions for find
	 * @param id Parameter from type Integer
	 * @return Some InscripcionE object
	 */
	@Override
	public InscripcionE find(Long id){
		return super.find(id);
	}
	/**
	 * This method executes the proper actions for save
	 * @param obj Parameter from type T
	 */
	@Override
	public void save(InscripcionE obj){
		super.save(obj);	
	}
	/**
	 * This method executes the proper actions for findRange
	 * @param rangeSize Parameter from type Integer
	 * @param from Parameter from type Integer
	 * @return Some List object
	 */
	@Override
	public List findRange(Long rangeSize,Long from){
		return super.findRange(rangeSize,from);
	}
	/**
	 * This method executes the proper actions for count
	 * @return Some Long object
	 */
	@Override
	public Long count(){
		return super.count();
	}
	/**
	 * This method executes the proper actions for addToCollection
	 * @param container Parameter from type Any
	 * @param collection Parameter from type Collection
	 * @param obj Parameter from type T
	 */
	@Override
	public void addToCollection(Object container,Collection collection,InscripcionE obj){
		super.addToCollection(container,collection,obj);	
	}					
		
	/**
	 * This method executes the proper actions for selectListResult
	 * @param field Parameter from type String
	 * @param value Parameter from type String
	 * @return Some Collection object
	 */
	@Override
	public Collection selectListResult(String field,String value){
		return super.selectListResult(field,value);
	}
	/**
	 * This method executes the proper actions for execute
	 * @param expresion Parameter from type String
	 * @return Some List object
	 */
	@Override
	public List execute(String expresion){
		return super.execute(expresion);
	}
	
}	

	
