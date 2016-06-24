package net.birelian.simpledao;

import java.util.Collection;
import java.util.Scanner;

/**
 * Main class.
 * <p>
 * It contains a menu with the next options
 * <p>
 * 1. Print all contacts
 * 2. Create a new contact
 * 3. Find a contact by Id
 * 4. Modify a contact
 * 5. Delete a contact
 * 6. Delete all contacts
 * X. Exit application.
 * <p>
 * We use the DAO pattern so we can delegate operations with contacts.
 */
public class Agenda {

    /** DAO instance */
    private final ContactDao contactDao = new ContactDaoImpl();

    /** Scanner for reading user options */
    private final Scanner optionReader = new Scanner(System.in);

    /**
     * Application entry
     *
     * @param args User args (not used)
     */
    public static void main(String[] args) {

        Agenda agenda = new Agenda();
        agenda.run();
    }

    /**
     * Main agenda method.
     */
    private void run() {

        String option = "";

        while (!option.equals("X")) {
            printMenu();
            option = optionReader.nextLine();
            processOption(option);
        }
    }

    private void printMenu() {

        System.out.println("Welcome to the worst Agenda you will ever see\n");
        System.out.println("Please choose an option\n");
        System.out.println("1. Print all contacts");
        System.out.println("2. Create a new contact");
        System.out.println("3. Find a contact by Id");
        System.out.println("4. Modify a contact");
        System.out.println("5. Delete a contact");
        System.out.println("6. Delete all contacts");
        System.out.println("X. Exit application");

    }

    private void processOption(String option) {

        switch (option) {

            case "1":
                listAllContacts();
                break;
            case "2":
                createContact();
                break;
            case "3":
                findContact();
                break;
            case "4":
                modifyContact();
                break;
            case "5":
                deleteContact();
                break;
            case "6":
                deleteAllContacts();
                break;
            case "X":
                exitApplication();
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    private void listAllContacts() {

        Collection<Contact> contacts = contactDao.findAll(); // Retrieve contacts from DAO

        if (contacts.isEmpty()) {
            System.out.println("There are no contacts in the database");

        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    private void createContact() {

        Contact contact = new Contact();

        readContactInfoFromUserInput(contact);

        contactDao.save(contact);

        System.out.println("Created contact: " + contact);

    }

    private void findContact() {

        Integer id = getContactIdFromUser();

        Contact contact = contactDao.findById(id);

        if (contact == null) {
            System.out.println("Contact not found on the database");
        } else {
            System.out.println(contact);
        }
    }

    private void modifyContact() {

        Integer id = getContactIdFromUser();

        Contact contact = contactDao.findById(id);

        if (contact == null) {
            System.out.println("Contact not found on the database");
        } else {
            readContactInfoFromUserInput(contact);
            contactDao.save(contact);
            System.out.println("Saved contact: " + contact);
        }


    }

    private void deleteContact() {

        Integer id = getContactIdFromUser();

        Contact contact = contactDao.findById(id);
        contactDao.delete(contact);
        System.out.println("Deleted contact: " + contact);

    }

    private void deleteAllContacts() {
        contactDao.deleteAll();
        System.out.println("All contacts");
    }

    private void readContactInfoFromUserInput(Contact contact) {

        Scanner reader = new Scanner(System.in);

        System.out.println("Please enter the contact name");
        contact.setName(reader.nextLine());

        System.out.println("Please enter the contact surname");
        contact.setSurname(reader.nextLine());

        System.out.println("Please enter the contact email");
        contact.setEmail(reader.nextLine());

    }

    private Integer getContactIdFromUser() {

        Scanner reader = new Scanner(System.in);
        System.out.println("Contact id?: ");
        return reader.nextInt();
    }

    private void exitApplication() {

        System.exit(0);
    }
}