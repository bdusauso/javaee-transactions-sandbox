package com.example.jpa;

public interface Repository<T> {
    /**
     * persist a entity in DB
     *
     * @param o Object to persist
     */
    void save(T o);

    /**
     * Find entity by id
     *
     * @param id    id
     * @param clazz class
     * @return entity
     */
    T findById(Long id, Class<T> clazz);

    /**
     * Flush current changes
     */
    void flush();

    /**
     * detach a object of DB
     *
     * @param o
     */
    void detach(T o);

    /**
     * Merge an entity
     *
     * @param o Entity to merge
     */
    void merge(T o);

    /**
     * reload a db Entity
     *
     * @param o entity to refresh
     */
    void refresh(T o);

    /**
     * removes a db Entity
     *
     * @param o entity to remove
     */
    void remove(T o);
}
