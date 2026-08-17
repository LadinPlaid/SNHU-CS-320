# CS-320 Project One – Contact Service

## Overview

This project was created for **CS-320: Software Test, Automation, and Quality Assurance**. The purpose of the project was to develop a Java contact service and use JUnit testing to verify that the application meets the required specifications.

The project demonstrates the use of unit testing, input validation, and software testing practices to ensure that the Contact and ContactService classes function correctly.

## Features

The Contact Service allows the application to:

* Create contacts with a unique contact ID.
* Store a contact's first name, last name, phone number, and address.
* Add new contacts to the contact service.
* Delete contacts using their unique contact ID.
* Update existing contact information.
* Validate contact information before it is stored.

## Contact Requirements

Each contact follows these requirements:

* **Contact ID:** Cannot be null and cannot exceed 10 characters.
* **First Name:** Cannot be null and cannot exceed 10 characters.
* **Last Name:** Cannot be null and cannot exceed 10 characters.
* **Phone Number:** Cannot be null and must contain exactly 10 digits.
* **Address:** Cannot be null and cannot exceed 30 characters.

The contact ID cannot be changed after the contact has been created.

## Project Files

### Contact.java

The `Contact` class represents an individual contact. It contains the contact's ID, first name, last name, phone number, and address.

The class performs input validation to prevent invalid contact information from being stored.

### ContactService.java

The `ContactService` class manages the collection of contacts. It provides methods for:

* Adding contacts.
* Deleting contacts.
* Updating contact information.
* Retrieving contacts by their contact ID.

### ContactTest.java

The `ContactTest` class contains JUnit tests for the `Contact` class. These tests verify that valid contacts can be created and that invalid values are rejected.

### ContactServiceTest.java

The `ContactServiceTest` class contains JUnit tests for the `ContactService` class. These tests verify that contacts can be successfully added, deleted, retrieved, and updated.

## Testing

JUnit was used to test the application and verify that the software meets the project requirements.

Testing includes both valid and invalid input values. Boundary testing was also used to verify restrictions such as maximum field lengths and the required 10-digit phone number.

Examples of tested conditions include:

* Creating a valid contact.
* Rejecting contact IDs longer than 10 characters.
* Rejecting names longer than 10 characters.
* Rejecting invalid phone numbers.
* Rejecting addresses longer than 30 characters.
* Preventing null values.
* Adding and deleting contacts.
* Updating contact information.
* Preventing duplicate contact IDs.

## Technologies Used

* Java
* JUnit 5
* Eclipse IDE
* Object-Oriented Programming
* Unit Testing

## What I Learned

This project helped demonstrate how automated unit testing can be used throughout software development to verify that code meets its requirements. Creating tests for both valid and invalid inputs helped identify potential problems before they could affect other parts of the application.

The project also reinforced the importance of validating user data, testing boundary conditions, and keeping application logic organized into separate classes.

## Author

**Jacob Hastert**
CS-320: Software Test, Automation, and Quality Assurance
Southern New Hampshire University
