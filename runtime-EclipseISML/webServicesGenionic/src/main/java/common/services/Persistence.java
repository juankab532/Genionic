
package common.services;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class Persistence<T> {
	private Class<T> entityClass;

	public Persistence(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	protected abstract EntityManager getEntityManager();

	public void create(T entity) {
		getEntityManager().persist(entity);
	}

	public void save(T entity) {
		getEntityManager().merge(entity);
	}

	public void remove(T entity) {
		getEntityManager().remove(getEntityManager().merge(entity));
	}
	
    public void remove(Long id) {
    	getEntityManager().remove(find(id));
    }

	public T find(Long id) {
		return getEntityManager().find(entityClass, id);
	}

	public List<T> findAll() {
		javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return getEntityManager().createQuery(cq).getResultList();
	}
	public List findAllExcept(Collection elementsToExclude) {
		return null;
	}
	public List<T> findRange(Long rangeSize,Long from) {
		javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		javax.persistence.Query q = getEntityManager().createQuery(cq);
		q.setMaxResults((int)(long)rangeSize);
		q.setFirstResult((int)(long)from);
		return q.getResultList();
	}

	public Long count() {
		javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
		cq.select(getEntityManager().getCriteriaBuilder().count(rt));
		javax.persistence.Query q = getEntityManager().createQuery(cq);
		return (long) ((Long) q.getSingleResult()).intValue();
	}
	public Boolean isPersistent(T entity){
		if(getEntityManager().find(entityClass, entity) != null)
			return true;
		else 
			return false;
	}
	public void addToCollection(Object container,Collection collection,T obj){
	}
	public void removeFromCollection(Object container,Collection collection,T obj){
	}
	
	public void assignToAttribute(Object container,String attribute,T obj){
	}
	
	public T selectUniqueResult(Object ent,Object field,String value,Object path) {
		return null;
	}
	public Collection selectListResult(String field,String value){
		return null;
	}
	public List execute(String expresion) { 
		Query query = getEntityManager().createQuery(expresion);
        return query.getResultList();
	}

}