/*
 * Name: Jacob Hastert
 * Course: CS 320 Software Test, Automation, and Quality Assurance
 * Assignment: Project One Milestone
 * Date: July 2026
 */

package contactservice;

public class Contact {
    
	// Contact ID cannot be changed after creation.
	private final String contactId;
	
	// Contact information that can be updated.
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor used to create a new contact.
    // All fields are validated before being assigned.
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        
		validateContactId(contactId);
        validateFirstName(firstName);
        validateLastName(lastName);
        validatePhone(phone);
        validateAddress(address);

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
	}
	
	// Returns the contact's unique ID.
    public String getContactId() {
        return contactId;
    }
    // Returns the contact's first name.
    public String getFirstName() {
        return firstName;
    }

    // Updates the first name after validation.
    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    // Returns the contact's last name.
    public String getLastName() {
        return lastName;
    }

    // Updates the last name after validation.
    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    // Returns the contact's phone number.
    public String getPhone() {
        return phone;
    }

    // Updates the phone number after validation.
    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }

    // Returns the contact's address.
    public String getAddress() {
        return address;
    }

    // Updates the address after validation.
    public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
    }

    // Ensures the contact ID is valid.
    private static void validateContactId(String contactId) {
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException(
                    "Contact ID cannot be null or exceed 10 characters.");
        }
    }

    // Ensures the first name is valid.
    private static void validateFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException(
                    "First name cannot be null or exceed 10 characters.");
        }
    }

    // Ensures the last name is valid.
    private static void validateLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException(
                    "Last name cannot be null or exceed 10 characters.");
        }
    }

    // Ensures the phone number contains exactly 10 digits.
    private static void validatePhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException(
                    "Phone number must contain exactly 10 digits.");
        }
    }

    // Ensures the address is valid.
    private static void validateAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException(
                    "Address cannot be null or exceed 30 characters.");
        }
    }
}
