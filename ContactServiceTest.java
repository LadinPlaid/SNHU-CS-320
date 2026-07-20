/*
 * Name: Jacob Hastert
 * Course: CS 320 Software Test, Automation, and Quality Assurance
 * Assignment: Project One Milestone
 * Date: July 2026
 */


package contactservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
    
	private ContactService contactService;
    private Contact contact;

    // Creates a new service and valid contact before each test.
    @BeforeEach
    void setUp() {

        contactService = new ContactService();

        contact = new Contact(
                "1001",
                "Jacob",
                "Hastert",
                "5551234567",
                "123 Main Street");
    }

    // Tests that a valid contact can be added to the service.
    @Test
    void testAddContact() {

        contactService.addContact(contact);

        // Verify that the contact was stored successfully.
        assertNotNull(contactService.getContact("1001"));
        assertEquals("Jacob",
                contactService.getContact("1001").getFirstName());
    }

    // Tests that a null contact cannot be added.
    @Test
    void testCannotAddNullContact() {

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(null);
        });
    }

    // Tests that two contacts cannot use the same contact ID.
    @Test
    void testCannotAddDuplicateContactId() {

        contactService.addContact(contact);

        Contact duplicateContact = new Contact(
                "1001",
                "John",
                "Smith",
                "5559876543",
                "456 Oak Road");

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(duplicateContact);
        });
    }

    // Tests that an existing contact can be deleted by ID.
    @Test
    void testDeleteContact() {

        contactService.addContact(contact);
        contactService.deleteContact("1001");

        // The contact should no longer exist in the service.
        assertNull(contactService.getContact("1001"));
    }

    // Tests that deleting a contact ID that does not exist is rejected.
    @Test
    void testDeleteMissingContact() {

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("9999");
        });
    }

    // Tests that a contact's first name can be updated.
    @Test
    void testUpdateFirstName() {

        contactService.addContact(contact);
        contactService.updateFirstName("1001", "Jake");

        assertEquals("Jake",
                contactService.getContact("1001").getFirstName());
    }

    // Tests that a contact's last name can be updated.
    @Test
    void testUpdateLastName() {

        contactService.addContact(contact);
        contactService.updateLastName("1001", "Smith");

        assertEquals("Smith",
                contactService.getContact("1001").getLastName());
    }

    // Tests that a contact's phone number can be updated.
    @Test
    void testUpdatePhone() {

        contactService.addContact(contact);
        contactService.updatePhone("1001", "5559876543");

        assertEquals("5559876543",
                contactService.getContact("1001").getPhone());
    }

    // Tests that a contact's address can be updated.
    @Test
    void testUpdateAddress() {

        contactService.addContact(contact);
        contactService.updateAddress("1001", "456 Oak Road");

        assertEquals("456 Oak Road",
                contactService.getContact("1001").getAddress());
    }

    // Tests that a missing contact cannot be updated.
    @Test
    void testCannotUpdateMissingContact() {

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName("9999", "Jake");
        });
    }

    // Tests that an invalid first name is rejected during an update.
    @Test
    void testCannotUpdateInvalidFirstName() {

        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName(
                    "1001",
                    "Christopher");
        });
    }

    // Tests that an invalid last name is rejected during an update.
    @Test
    void testCannotUpdateInvalidLastName() {

        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateLastName(
                    "1001",
                    "Longlastname");
        });
    }

    // Tests that an invalid phone number is rejected during an update.
    @Test
    void testCannotUpdateInvalidPhone() {

        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updatePhone(
                    "1001",
                    "12345");
        });
    }

    // Tests that an invalid address is rejected during an update.
    @Test
    void testCannotUpdateInvalidAddress() {

        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateAddress(
                    "1001",
                    "1234567890123456789012345678901");
        });
    }

    // Tests that updating one field does not change the contact ID.
    @Test
    void testContactIdRemainsUnchangedAfterUpdate() {

        contactService.addContact(contact);
        contactService.updateFirstName("1001", "Jake");

        assertEquals("1001",
                contactService.getContact("1001").getContactId());
    }

}
