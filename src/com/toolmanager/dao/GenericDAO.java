package com.toolmanager.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
 
import javax.persistence.EntityManager;
 
/**
 * @author gabriel
 *
 * Oct 17, 2013
 */
 
@SuppressWarnings("unchecked")
public class GenericDAO<T> {
    private EntityManager entityManager;
 
    public GenericDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
 
    public T getById(Long id) {
        return (T) entityManager.find(getTypeClass(), id);
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
        return entityManager.createQuery(("FROM " + getTypeClass().getName()))
                .getResultList();
    }
 
    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }
}
