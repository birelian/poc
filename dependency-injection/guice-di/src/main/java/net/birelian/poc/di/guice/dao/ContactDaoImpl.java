package net.birelian.poc.di.guice.dao;

import net.birelian.poc.di.guice.model.Contact;

import java.util.*;

/**
 * ContactDao implementation
 */
public class ContactDaoImpl implements ContactDao {

    private final Map<Integer, Contact> contacts = new HashMap<>();
    private Integer lastGeneratedId = 0;

    public ContactDaoImpl() {

        // Create test data
        createTestData();
    }

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

    private void createTestData() {
        Contact solidSnakeContact = new Contact("Solid", "Snake", "solidsnake@shadowmoses.net");
        solidSnakeContact.setId(1);
        contacts.put(1, solidSnakeContact);

        Contact otaconContact = new Contact("Hal", "Emmerich", "hal.emmerich@otaku.net");
        otaconContact.setId(2);
        contacts.put(2, otaconContact);

        Contact liquidSnakeContact = new Contact("Liquid", "Snake", "solidsnake@shadowmoses.net");
        liquidSnakeContact.setId(1);
        contacts.put(3, liquidSnakeContact);
    }
}
