package ContactService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {
	private List<Contact> contactList = new ArrayList<>();
	
	public Contact addContact(String firstname, String lastname, String number, String address) {
		Contact contact = new Contact(newUniqueId(), firstname, lastname, number, address);
		contactList.add(contact);
		return contact;
	}

	public void deleteContact(String id) throws Exception {
		contactList.remove(searchContacts(id));
	}

	public void updateFirstName(String id, String firstName) throws Exception {
		searchContacts(id).setFirstName(firstName);
	}

	public void updateLastName(String id, String lastName) throws Exception {
		searchContacts(id).setLastName(lastName);
	}

	public void updatePhoneNumber(String id, String number) throws Exception {
		searchContacts(id).setNumber(number);
	}

	public void updateAddress(String id, String address) throws Exception {
		searchContacts(id).setAddress(address);
	}

	protected List<Contact> getContactList() {
		return contactList;
	}

	private String newUniqueId() {
		return UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}

	public Contact searchContacts(String id){
		int index = 0;
		while (index < contactList.size()) {
			if (id.equals(contactList.get(index).getId())) {
				return contactList.get(index);
			}
			index++;
		}
		return null;
	}
}
