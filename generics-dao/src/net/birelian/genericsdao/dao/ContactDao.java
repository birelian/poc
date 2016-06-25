package net.birelian.genericsdao.dao;

import net.birelian.genericsdao.model.Contact;

import java.util.List;

/**
 * Custom interface for Contacts DAO.
 *
 * Sometimes we need more methods than the one defined in the base Dao interface.
 */
public interface ContactDao extends Dao<Contact> {

    List<Contact> findBySurname(String surname);

}
