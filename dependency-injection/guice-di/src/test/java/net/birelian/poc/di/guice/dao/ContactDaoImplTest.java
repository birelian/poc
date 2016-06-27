package net.birelian.poc.di.guice.dao;

import net.birelian.poc.di.guice.model.Contact;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for the ContactDaoImpl class
 */
public class ContactDaoImplTest {

    private ContactDao contactDao;


    @Before
    public void setUp() {
        contactDao = createAndPopulateDao();
    }

    @Test
    public void save() throws Exception {

        Contact liquidContact = new Contact("Liquid", "Snake", "liquid.snake@shadowmoses.net");
        contactDao.save(liquidContact);
        assertNotNull(liquidContact.getId());

    }

    @Test
    public void findAll() throws Exception {

        assertEquals(2, contactDao.findAll().size());

    }

    @Test
    public void findById() throws Exception {

        assertNotNull(contactDao.findById(1));
        assertNull(contactDao.findById(3));
    }

    @Test
    public void delete() throws Exception {

        contactDao.delete(contactDao.findById(1));
        assertEquals(1, contactDao.findAll().size());

    }

    @Test
    public void deleteAll() throws Exception {

        contactDao.deleteAll();
        assertTrue(contactDao.findAll().isEmpty());

    }

    @Test
    public void findBySurname() throws Exception {

        assertEquals(1, contactDao.findBySurname("Snake").size());

    }

    private ContactDao createAndPopulateDao() {

        ContactDao contactDao= new ContactDaoImpl();

        Contact snakeContact = new Contact("Solid", "Snake", "solidsnake@shadowmoses.net");
        contactDao.save(snakeContact);
        assertNotNull(snakeContact.getId());

        Contact otaconContact = new Contact("Hal", "Emmerich", "hal.emmerich@otaku.net");
        contactDao.save(otaconContact);
        assertNotNull(otaconContact.getId());

        return contactDao;
    }
}