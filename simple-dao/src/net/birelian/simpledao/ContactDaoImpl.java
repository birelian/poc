package net.birelian.simpledao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * ContactDao implementation
 */
class ContactDaoImpl implements ContactDao {

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
}
