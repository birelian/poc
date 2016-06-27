package net.birelian.poc.di.spring.model;

/**
 * A simple contact
 */
public class Contact extends Item {

    private String name;
    private String surname;
    private String email;

    /**
     * Default constructor
     */
    public Contact() {
    }

    /**
     * All parameters constructor
     *
     * @param name Name
     * @param surname Surname
     * @param email Email
     */
    public Contact(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}