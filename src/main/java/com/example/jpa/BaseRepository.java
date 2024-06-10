package com.example.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;

public abstract class BaseRepository<T> implements Repository<T> {

    @PersistenceContext(unitName = "sandbox-tx")
    private EntityManager em;

    /**
     * get the entity manager
     *
     * @return entity manager
     */
    public EntityManager getEm() {
        return em;
    }

    protected CriteriaBuilder getCriteriaBuilder() {
        return em.getCriteriaBuilder();
    }

    /**
     * persist a entity in DB
     *
     * @param o Object to persist
     */
    public void save(T o) {
        em.persist(o);
    }

    /**
     * Find entity by id
     *
     * @param id    id
     * @param clazz class
     * @return entity
     */
    public T findById(Long id, Class<T> clazz) {
        return getEm().find(clazz, id);
    }

    /**
     * Flush current changes
     */
    public void flush() {
        em.flush();
    }

    /**
     * detach a object of DB
     *
     * @param o
     */
    public void detach(T o) {
        em.detach(o);
    }

    /**
     * Merge an entity
     *
     * @param o Entity to merge
     */
    public void merge(T o) {
        em.merge(o);
    }

    /**
     * reload a db Entity
     *
     * @param o entity to refresh
     */
    public void refresh(T o) {
        em.refresh(o);
    }

    /**
     * removes a db Entity
     *
     * @param o entity to remove
     */
    public void remove(T o) {
        em.remove(o);
    }
}
