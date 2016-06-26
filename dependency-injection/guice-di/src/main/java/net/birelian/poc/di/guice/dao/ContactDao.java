package net.birelian.poc.di.guice.dao;

import net.birelian.poc.di.guice.model.Contact;

import java.util.List;

/**
 * Custom interface for Contacts DAO.
 *
 * Sometimes we need more methods than the one defined in the base DAO interface.
 */
public interface ContactDao extends Dao<Contact> {

    List<Contact> findBySurname(String surname);

}
