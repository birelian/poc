package net.birelian.poc.di.guice.dao;

import java.util.Collection;

/**
 * Base DAO interface for all the entities.
 */
public interface Dao<T> {

    /**
     * Get all entities
     *
     * @return All entities
     */
    Collection<T> findAll();

    /**
     * Find an entity by Id
     *
     * @param id Entity id
     * @return The entity that has the given id, if exists.
     */
    T findById(Integer id);

    /**
     * Save an entity
     *
     * @param entity Entity to be saved
     */
    void save(T entity);

    /**
     * Delete an entity
     *
     * @param entity The entity
     */
    void delete(T entity);

    /**
     * Delete all entities. Be careful ;)
     */
    void deleteAll();

}
