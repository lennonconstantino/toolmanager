package com.toolmanager.dao;

//import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
 
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
 
/**
 * @author Lennon
 *
 * Oct 28, 2014
 */
 
@SuppressWarnings("unchecked")
public class GenericDAO<T> {
    private EntityManager entityManager;
    private Class<T> entityClass;
    
    public GenericDAO(Class<T> entityClass,EntityManager entityManager) {
        this.entityManager = entityManager;
        this.entityClass = entityClass;
    }
        
    public CriteriaBuilder getCriteria()
    {
    	return entityManager.getCriteriaBuilder();
    }  
    public T getById(Long id) {
        return (T) entityManager.find(entityClass, id);
    }
 
    public void save(T entity) {
        entityManager.persist(entity);
    }
 
    public void update(T entity) {
        entityManager.merge(entity);
    }
 
    public void delete(T entity) {
        entityManager.remove(entity);
    }

	public List<T> findAll() {
		@SuppressWarnings("rawtypes")
		CriteriaQuery cq = getCriteria().createQuery();
		cq.select(cq.from(entityClass));
		return entityManager.createQuery(cq).getResultList();
	}    
 
	public T get(String sql, String value) {
		List<T> list = new ArrayList<T>();
		Query query = entityManager.createNamedQuery(sql).setParameter("param", value);
		
		list = query.getResultList();
		if (list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	public T get(String sql, Long value) {
		List<T> list = new ArrayList<T>();
		Query query = entityManager.createNamedQuery(sql).setParameter("param", value);
		
		list = query.getResultList();
		if (list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	public List<T> getList(String sql) {
		Query query = entityManager.createNamedQuery(sql);
		return query.getResultList();
	}
 	/*
    public List<T> findAll() {
        return entityManager.createQuery(("FROM " + getTypeClass().getName()))
                .getResultList();
    }
    */	
}
