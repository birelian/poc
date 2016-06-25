package net.birelian.genericsdao.dao;

import net.birelian.genericsdao.model.Contact;

import java.util.*;

/**
 * ContactDao implementation
 */
public class ContactDaoImpl implements ContactDao {

    private final Map<Integer, Contact> contacts = new HashMap<>();
    private Integer lastGeneratedId = 0;


    @Override
    public Collection<Contact> findAll() {
        return contacts.values();
    }

    @Override
    public Contact findById(Integer id) {

        return contacts.get(id);
    }

    @Override
    public void save(Contact contact) {

        // Add the contact if not exists
        if (!contacts.containsValue(contact)) {
            contact.setId(++lastGeneratedId);
            contacts.put(contact.getId(), contact);
        }
    }

    @Override
    public void delete(Contact contact) {
        contacts.remove(contact.getId());
    }

    @Override
    public void deleteAll() {
        contacts.clear();
    }

    @Override
    public List<Contact> findBySurname(String surname) {

        List<Contact> contactsFound = new ArrayList<>();

        for (Contact contact : contacts.values()) {
            if(contact.getSurname().equals(surname)) {
                contactsFound.add(contact);
            }
        }

        return contactsFound;
    }
}
