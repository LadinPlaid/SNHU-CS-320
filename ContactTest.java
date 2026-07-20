/*
 * Name: Jacob Hastert
 * Course: CS 320 Software Test, Automation, and Quality Assurance
 * Assignment: Project One Milestone
 * Date: July 2026
 */

package contactservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

	// Tests that a valid Contact object is created correctly.
    @Test
    void testContactCreation() {

        Contact contact = new Contact(
                "1001",
                "Jacob",
                "Hastert",
                "5551234567",
                "123 Main Street");

        // Verify that each field contains the expected value.
        assertEquals("1001", contact.getContactId());
        assertEquals("Jacob", contact.getFirstName());
        assertEquals("Hastert", contact.getLastName());
        assertEquals("5551234567", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    // Tests that the contact ID cannot be null.
    @Test
    void testContactIdCannotBeNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    null,
                    "Jacob",
                    "Hastert",
                    "5551234567",
                    "123 Main Street");
        });
    }

    // Tests that the contact ID cannot exceed 10 characters.
    @Test
    void testContactIdCannotBeTooLong() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345678901",
                    "Jacob",
                    "Hastert",
                    "5551234567",
                    "123 Main Street");
        });
    }

    // Tests that the first name cannot be null.
    @Test
    void testFirstNameCannotBeNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "1001",
                    null,
                    "Hastert",
                    "5551234567",
                    "123 Main Street");
        });
    }

    // Tests that the first name cannot exceed 10 characters.
    @Test
    void testFirstNameCannotBeTooLong() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "1001",
                    "Christopher",
                    "Hastert",
                    "5551234567",
                    "123 Main Street");
        });
    }

    // Tests that the last name cannot be null.
    @Test
    void testLastNameCannotBeNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "1001",
                    "Jacob",
                    null,
                    "5551234567",
                    "123 Main Street");
        });
    }

    // Tests that the last name cannot exceed 10 characters.
    @Test
    void testLastNameCannotBeTooLong() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "1001",
                    "Jacob",
                    "Longlastname",
                    "5551234567",
                    "123 Main Street");
        });
    }

    // Tests that the phone number cannot be null.
    @Test
    void testPhoneCannotBeNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "1001",
                    "Jacob",
                    "Hastert",
                    null,
                    "123 Main Street");
        });
    }

    // Tests that the phone number must contain exactly 10 digits.
    @Test
    void testPhoneMustBeTenDigits() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "1001",
                    "Jacob",
                    "Hastert",
                    "555123456",
                    "123 Main Street");
        });
    }

    // Tests that the phone number cannot contain letters.
    @Test
    void testPhoneCannotContainLetters() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "1001",
                    "Jacob",
                    "Hastert",
                    "555ABC4567",
                    "123 Main Street");
        });
    }

    // Tests that the address cannot be null.
    @Test
    void testAddressCannotBeNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "1001",
                    "Jacob",
                    "Hastert",
                    "5551234567",
                    null);
        });
    }

    // Tests that the address cannot exceed 30 characters.
    @Test
    void testAddressCannotBeTooLong() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "1001",
                    "Jacob",
                    "Hastert",
                    "5551234567",
                    "1234567890123456789012345678901");
        });
    }

    // Tests that the first name can be updated with a valid value.
    @Test
    void testSetFirstName() {

        Contact contact = createValidContact();

        contact.setFirstName("Jake");

        assertEquals("Jake", contact.getFirstName());
    }

    // Tests that the last name can be updated with a valid value.
    @Test
    void testSetLastName() {

        Contact contact = createValidContact();

        contact.setLastName("Smith");

        assertEquals("Smith", contact.getLastName());
    }

    // Tests that the phone number can be updated with a valid value.
    @Test
    void testSetPhone() {

        Contact contact = createValidContact();

        contact.setPhone("5559876543");

        assertEquals("5559876543", contact.getPhone());
    }

    // Tests that the address can be updated with a valid value.
    @Test
    void testSetAddress() {

        Contact contact = createValidContact();

        contact.setAddress("456 Oak Road");

        assertEquals("456 Oak Road", contact.getAddress());
    }

    // Tests that an invalid updated first name is rejected.
    @Test
    void testSetInvalidFirstName() {

        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("Christopher");
        });
    }

    // Tests that an invalid updated phone number is rejected.
    @Test
    void testSetInvalidPhone() {

        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("12345");
        });
    }

    // Creates a valid Contact object for use in multiple tests.
    private Contact createValidContact() {

        return new Contact(
                "1001",
                "Jacob",
                "Hastert",
                "5551234567",
                "123 Main Street");
    }
}
