package net.birelian.poc.di.guice.service;

import com.google.inject.Inject;
import net.birelian.poc.di.guice.dao.ContactDao;
import net.birelian.poc.di.guice.model.Contact;

import java.util.*;

/**
 * Contact service implementation
 */
public class ContactServiceImpl implements ContactService {

    private final ContactDao contactDao;

    /**
     * Constructor
     *
     * @param contactDao Injected contact DAO
     */
    @Inject
    public ContactServiceImpl(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    public Collection<Contact> findAll() {
        return contactDao.findAll();
    }

    @Override
    public Contact findById(Integer id) {

        return contactDao.findById(id);
    }

    @Override
    public void save(Contact contact) {

        contactDao.save(contact);
    }

    @Override
    public void delete(Contact contact) {
        contactDao.delete(contact);
    }

    @Override
    public void deleteAll() {
        contactDao.deleteAll();
    }

    @Override
    public List<Contact> findBySurname(String surname) {

        return contactDao.findBySurname(surname);
    }
}