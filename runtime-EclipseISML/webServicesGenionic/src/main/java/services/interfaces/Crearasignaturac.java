package services.interfaces;		

import java.util.*;
import javax.ejb.Local; 
import javax.ws.rs.*;		
import javax.ws.rs.core.*;
import javax.persistence.Query;
import backend.entities.*;
import common.services.Persistence;

/**
 * This interface represents the local instance for the CrearasignaturacBean EJB 
 */
@Local
@Path("/crearasignaturac")
public interface Crearasignaturac{
	
	/**
	 * This method executes the proper actions for remove
	 * @param obj Parameter from type T
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/remove")					
	public void remove(AsignaturaE obj);
	/**
	 * This method executes the proper actions for remove
	 * @param id Parameter from type Integer
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/remove/{id}")					
	public void remove(@PathParam("id")Long id);
	/**
	 * This method executes the proper actions for create
	 * @param obj Parameter from type T
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/create")					
	public void create(AsignaturaE obj);
	/**
	 * This method executes the proper actions for findAll
	 * @return Some List object
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findAll")					
	public List findAll();
	/**
	 * This method executes the proper actions for find
	 * @param id Parameter from type Integer
	 * @return Some AsignaturaE object
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/find/{id}")					
	public AsignaturaE find(@PathParam("id")Long id);
	/**
	 * This method executes the proper actions for save
	 * @param obj Parameter from type T
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/save")					
	public void save(AsignaturaE obj);
	/**
	 * This method executes the proper actions for findRange
	 * @param rangeSize Parameter from type Integer
	 * @param from Parameter from type Integer
	 * @return Some List object
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findRange/{rangeSize}/{from}")					
	public List findRange(@PathParam("rangeSize")Long rangeSize,@PathParam("from")Long from);
	/**
	 * This method executes the proper actions for count
	 * @return Some Long object
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/count")					
	public Long count();
	/**
	 * This method executes the proper actions for addToCollection
	 * @param container Parameter from type Any
	 * @param collection Parameter from type Collection
	 * @param obj Parameter from type T
	 */
	public void addToCollection(Object container,Collection collection,AsignaturaE obj);
	
	/**
	 * This method executes the proper actions for selectListResult
	 * @param field Parameter from type String
	 * @param value Parameter from type String
	 * @return Some Collection object
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/selectListResult/{field}/{value}")					
	public Collection selectListResult(@PathParam("field")String field,@PathParam("value")String value);
	/**
	 * This method executes the proper actions for execute
	 * @param expresion Parameter from type String
	 * @return Some List object
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/execute/{expresion}")					
	public List execute(@PathParam("expresion")String expresion);
	
}	

	
