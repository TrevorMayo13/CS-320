package ContactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import TaskService.Task;

class ContactTest {

	@Test
	void testContact() throws Exception {
		Contact contact = new Contact("lasdgo3", "Billy", "Smith", "8882087348", "24 Main St New York City");
		assertTrue(contact.getId().equals("lasdgo3"));
		assertTrue(contact.getFirstName().equals("Billy"));
		assertTrue(contact.getLastName().equals("Smith"));
		assertTrue(contact.getNumber().equals("8882087348"));
		assertTrue(contact.getAddress().equals("24 Main St New York City"));
	}

	@Test
	void testContactFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("lasdgo3", null, "Smith", "8882087348", "24 Main St New York City");
		});
	}

	@Test
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("lasdgo3", "Billythekjalsdglkjasdgklj", "Smith", "8882087348", "24 Main St New York City");
		});
	}

	@Test
	void testContactLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("lasdgo3", "Billy", null, "8882087348", "24 Main St New York City");
		});
	}

	@Test
	void testContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("lasdgo3", "Billy", "Smithasdfasdfasdfasdfasdf", "8882087348", "24 Main St New York City");
		});
	}
	
	@Test
	void testContactNumberNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("lasdgo3", "Billy", "Smith", null, "24 Main St New York City");
		});
	}

	@Test
	void testContactNumberTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("lasdgo3", "Billy", "Smith", "8882087348asdfasdf", "24 Main St New York City");
		});
	}

	@Test
	void testContactAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("lasdgo3", "Billy", "Smith", "8882087348", null);
		});
	}

	@Test
	void testContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("lasdgo3", "Billy", "Smith", "8882087348", "24 Main St New York Cityasdgasdgasdgasdgasdgasdg");
		});
	}

	@Test
	void testTaskIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Billy", "Smith", "8882087348", "24 Main St New York City");
		});
	}

	@Test
	void testTaskIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("asdfasdasdgasfghasdgasdg", "Billy", "Smith", "8882087348", "24 Main St New York City");
		});
	}

	@Test
	void testTaskIdExists() {
		Assertions.assertThrows(Exception.class, () -> {
			Contact contact = new Contact("lasdgo3", "Billy", "Smith", "8882087348", "24 Main St New York City");
			contact.setId("something");
		});
	}

}
