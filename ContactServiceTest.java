package ContactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ContactService.ContactService;

class ContactServiceTest {

	ContactService service = new ContactService();

	@Test
	void testAddContact() {
		Assertions.assertDoesNotThrow(() -> {
			service.addContact("Billy", "Smith", "8882087348", "24 Main St New York City");
		});
		Assertions.assertNotNull(service.getContactList().get(0));
	}

	@Test
	void testDeleteContact() {
		Assertions.assertDoesNotThrow(() -> {
			Contact contact = service.addContact("Billy", "Smith", "8882087348", "24 Main St New York City");
			service.deleteContact(contact.getId());
		});
		Assertions.assertTrue(service.getContactList().size() == 0);
	}

	@Test
	void testUpdateFirstName() {
		Assertions.assertDoesNotThrow(() -> {
			Contact contact1 = service.addContact("Billy", "Smith", "8882087348", "24 Main St New York City");
			service.updateFirstName(contact1.getId(), "Billylol");
		});
		String id = service.getContactList().get(0).getId();
		Contact contact2 = service.searchContacts(id);
		Assertions.assertTrue(contact2.getFirstName() == "Billylol");
	}

	@Test
	void testUpdateLastName() {
		Assertions.assertDoesNotThrow(() -> {
			Contact contact1 = service.addContact("Billy", "Smith", "8882087348", "24 Main St New York City");
			service.updateLastName(contact1.getId(), "Smithie");
		});
		String id = service.getContactList().get(0).getId();
		Contact contact2 = service.searchContacts(id);
		Assertions.assertTrue(contact2.getLastName() == "Smithie");
	}
	
	@Test
	void testUpdatePhoneNumber() {
		Assertions.assertDoesNotThrow(() -> {
			Contact contact1 = service.addContact("Billy", "Smith", "8882087348", "24 Main St New York City");
			service.updatePhoneNumber(contact1.getId(), "2031925476");
		});
		String id = service.getContactList().get(0).getId();
		Contact contact2 = service.searchContacts(id);
		Assertions.assertTrue(contact2.getNumber() == "2031925476");
	}

	@Test
	void testUpdateAddress() {
		Assertions.assertDoesNotThrow(() -> {
			Contact contact1 = service.addContact("Billy", "Smith", "8882087348", "24 Main St New York City");
			service.updateAddress(contact1.getId(), "Over the Rainbow");
		});
		String id = service.getContactList().get(0).getId();
		Contact contact2 = service.searchContacts(id);
		Assertions.assertTrue(contact2.getAddress() == "Over the Rainbow");
	}

}
