package net.birelian.poc.di.guice.service;

import net.birelian.poc.di.guice.model.Contact;

import java.util.Collection;
import java.util.List;

/**
 * Contact service interface
 */
public interface ContactService {

    /**
     * Get all contacts
     *
     * @return All contacts
     */
    Collection<Contact> findAll();

    /**
     * Find an contact by Id
     *
     * @param id Contact id
     * @return The contact that has the given id, if exists.
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

    List<Contact> findBySurname(String surname);
}
