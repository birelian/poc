package net.birelian.poc.di.spring.service;

import net.birelian.poc.di.spring.dao.ContactDao;
import net.birelian.poc.di.spring.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Contact service implementation
 */
@Service("contactService")
public class ContactServiceImpl implements ContactService {

    private final ContactDao contactDao;

    /**
     * Constructor
     *
     * @param contactDao Injected contact DAO
     */
    @Autowired
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