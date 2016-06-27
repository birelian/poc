package net.birelian.poc.di.spring.dao;

import net.birelian.poc.di.spring.model.Contact;

import java.util.List;

/**
 * Custom interface for Contacts DAO.
 *
 * Sometimes we need more methods than the one defined in the base DAO interface.
 */
public interface ContactDao extends Dao<Contact> {

    List<Contact> findBySurname(String surname);

}
