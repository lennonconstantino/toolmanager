package com.toolmanager.dao;

//import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
 
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
    
	public void update(Object id, Class<T> classe) {
		T entityToBeRemoved = entityManager.getReference(classe, id);
		entityManager.merge(entityToBeRemoved);
	}
    
    public void delete(T entity) {
        entityManager.remove(entity);
    }

	public void delete(Object id, Class<T> classe) {
		T entityToBeRemoved = entityManager.getReference(classe, id);
		entityManager.remove(entityToBeRemoved);
	}
	
	public List<T> findAll() {
		@SuppressWarnings("rawtypes")
		CriteriaQuery cq = getCriteria().createQuery();
		cq.select(cq.from(entityClass));
		return entityManager.createQuery(cq).getResultList();
	}    
 
	public T get(String sql, String value) {
		List<T> list = new ArrayList<T>();
		Query query = entityManager.createNativeQuery(sql,entityClass).setParameter("param", value);
		
		list = query.getResultList();
		if (list.size() > 0){
			System.out.println(list.get(0));
			return (T) list.get(0);
		}else{
			return null;
		}
	}
	
	public T get(String sql, Long value) {
		List<T> list = new ArrayList<T>();
		Query query = entityManager.createNativeQuery(sql,entityClass).setParameter("param", value);
		
		list = query.getResultList();
		
		if (list.size() > 0){
			return (T) list.get(0);
		}else{
			return null;
		}
	}
	
	public List<T> getList(String sql) {
		Query query = entityManager.createNativeQuery(sql,entityClass);
		return query.getResultList();        
	}
	
	public T getWithNamedQuery(String sql){
		Query query = entityManager.createNamedQuery(sql);
		return (T) query.getSingleResult();
	}
	
	public T getWithNamedQuery(String sql, String value){
		Query query = entityManager.createNamedQuery(sql).setParameter("param", value);
		return (T) query.getSingleResult();
	}
	
	public T getWithNamedQuery(String sql, Long id){
		Query query = entityManager.createNamedQuery(sql).setParameter("param", id);
		return (T) query.getSingleResult();		
	}	
	
	// Using the unchecked because JPA does not have a
	// query.getSingleResult()<T> method
	public T findOneResultWithNamedQuery(String namedQuery, Map<String, Object> parameters) {
		T result = null;

		try {
			Query query = entityManager.createNamedQuery(namedQuery);

			// Method that will populate parameters if they are passed not null and empty
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}
			result = (T) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("No result found for named query: " + namedQuery);
		} catch (Exception e) {
			System.out.println("Error while running query: " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}	
	
	public List<T> findListResultWithNamedQuery(String namedQuery, Map<String, Object> parameters) {
		List<T> result = null;

		try {
			Query query = entityManager.createNamedQuery(namedQuery);

			// Method that will populate parameters if they are passed not null and empty
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}
			result = query.getResultList();
		} catch (NoResultException e) {
			System.out.println("No result found for named query: " + namedQuery);
		} catch (Exception e) {
			System.out.println("Error while running query: " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}		
	
	private void populateQueryParameters(Query query, Map<String, Object> parameters) {
		for (Entry<String, Object> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
	}		
}
