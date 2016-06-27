package net.birelian.poc.di.guice.service;

import com.google.inject.Guice;
import net.birelian.poc.di.guice.config.GuiceConfigurationModule;
import net.birelian.poc.di.guice.model.Contact;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for the contactServiceImpl class
 */
public class ContactServiceImplTest {

    private ContactService contactService
            = Guice.createInjector(new GuiceConfigurationModule()).getInstance(ContactService.class);

    @Test
    public void save() throws Exception {

        Contact anotherContact = new Contact("Another", "Contact", "another.contact@shadowmoses.net");
        contactService.save(anotherContact);
        assertNotNull(anotherContact.getId());
    }

    @Test
    public void findAll() throws Exception {

        assertEquals(3, contactService.findAll().size());
    }

    @Test
    public void findById() throws Exception {

        assertNotNull(contactService.findById(1));
        assertNotNull(contactService.findById(2));
        assertNotNull(contactService.findById(3));

        assertNull(contactService.findById(4));
    }

    @Test
    public void delete() throws Exception {

        contactService.delete(contactService.findById(1));
        assertEquals(2, contactService.findAll().size());
    }

    @Test
    public void deleteAll() throws Exception {

        contactService.deleteAll();
        assertTrue(contactService.findAll().isEmpty());
    }

    @Test
    public void findBySurname() throws Exception {

        assertEquals(2, contactService.findBySurname("Snake").size());
    }
}