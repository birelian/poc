package net.birelian.simpledao;

import java.util.Collection;

/**
 * This interface defines the methods that should be implemented by the DAO
 *
 * Implementing an interface is a good practice because it decouples classes so we may later change the implementation
 * of the DAO. We may have for example a real database DAO and a "In memory" DAO.
 */
interface ContactDao {

    /**
     * Get all contacts
     *
     * @return All contacts
     */
    Collection<Contact> findAll();

    /**
     * Find a contact by Id
     *
     * @param id Contact id
     * @return The contacts who has the given id, if exists.
     */
    Contact findById(Integer id);

    /**
     * Save a contact
     *
     * @param contact Contact to be saved
     */
    void save(Contact contact);

    /**
     * Delete a contact
     *
     * @param contact The contact
     */
    void delete(Contact contact);

    /**
     * Delete all contacts. Be careful ;)
     */
    void deleteAll();

}
