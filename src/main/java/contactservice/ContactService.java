/*
 * Name: Jacob Hastert
 * Course: CS 320 Software Test, Automation, and Quality Assurance
 * Assignment: Project One Milestone
 * Date: July 2026
 */

package contactservice;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

	// Stores all contacts in memory using the contact ID as the key.
    private final Map<String, Contact> contacts = new HashMap<>();

    /**
     * Adds a new contact to the contact service.
     * Contact IDs must be unique.
     *
     * @param contact The contact to add.
     */
    public void addContact(Contact contact) {

        // Verify the contact object is not null.
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null.");
        }

        // Retrieve the contact's unique ID.
        String contactId = contact.getContactId();

        // Ensure the ID does not already exist.
        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException(
                    "A contact with this ID already exists.");
        }

        // Add the contact to the collection.
        contacts.put(contactId, contact);
    }

    /**
     * Deletes a contact using its unique ID.
     *
     * @param contactId The ID of the contact to remove.
     */
    public void deleteContact(String contactId) {

        // Verify the contact exists before attempting removal.
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException(
                    "Contact ID not found.");
        }

        // Remove the contact.
        contacts.remove(contactId);
    }

    /**
     * Updates a contact's first name.
     *
     * @param contactId The contact's ID.
     * @param firstName The new first name.
     */
    public void updateFirstName(String contactId, String firstName) {

        Contact contact = getRequiredContact(contactId);

        // Validation occurs inside the Contact class.
        contact.setFirstName(firstName);
    }

    /**
     * Updates a contact's last name.
     *
     * @param contactId The contact's ID.
     * @param lastName The new last name.
     */
    public void updateLastName(String contactId, String lastName) {

        Contact contact = getRequiredContact(contactId);

        // Validation occurs inside the Contact class.
        contact.setLastName(lastName);
    }

    /**
     * Updates a contact's phone number.
     *
     * @param contactId The contact's ID.
     * @param phone The new phone number.
     */
    public void updatePhone(String contactId, String phone) {

        Contact contact = getRequiredContact(contactId);

        // Validation occurs inside the Contact class.
        contact.setPhone(phone);
    }

    /**
     * Updates a contact's address.
     *
     * @param contactId The contact's ID.
     * @param address The new address.
     */
    public void updateAddress(String contactId, String address) {

        Contact contact = getRequiredContact(contactId);

        // Validation occurs inside the Contact class.
        contact.setAddress(address);
    }

    /**
     * Returns a contact by its ID.
     * Primarily used by unit tests.
     *
     * @param contactId The contact's ID.
     * @return The Contact object or null if not found.
     */
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

    /**
     * Helper method that retrieves an existing contact.
     * Throws an exception if the ID does not exist.
     *
     * @param contactId The contact's ID.
     * @return The matching Contact object.
     */
    private Contact getRequiredContact(String contactId) {

        Contact contact = contacts.get(contactId);

        if (contact == null) {
            throw new IllegalArgumentException(
                    "Contact ID not found.");
        }

        return contact;
    }

}
