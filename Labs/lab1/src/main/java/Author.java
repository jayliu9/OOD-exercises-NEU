/**
 * Name: Shijie Liu
 * NUID: 001561546
 * Course: CS 5005
 * Course Number: 38135
 * Semester: Spring 2021
 *
 * This class represents an author with their details--name, email and physical address
 *
 */
public class Author {
    private Person name;
    private String email;
    private String address;

    /**
     * Creates an Author object and initialize it with the given name, email and address
     * @param name the author's name
     * @param email the author's email address
     * @param address the author's physical address
     */
    public Author(Person name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    /**
     * Gets this author's name
     * @return the name
     */
    public String getName() {
        return this.name.getFirstName() + " " + this.name.getLastName();
    }

    /**
     * Gets this author's email
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Gets this author's address
     * @return the address
     */
    public String getAddress() {
        return this.address;
    }
}
