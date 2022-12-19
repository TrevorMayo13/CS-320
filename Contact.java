package ContactService;


public class Contact {
	private String firstName, lastName, number, address, id;
	private Integer id_length = 10;

	public Contact(String id, String first, String last, String number, String address) {
		setId(id);
		setFirstName(first);
		setLastName(last);
		setNumber(number);
		setAddress(address);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName == null) {
			throw new IllegalArgumentException("First Name can't be null");
		}else if (firstName.length() > 10) {
			throw new IllegalArgumentException("First Name can't be longer than 10 characters");
		} else {
			this.firstName = firstName;
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName == null) {
			throw new IllegalArgumentException("Last Name can't be null");
		} else if (lastName.length() > 10) {
			throw new IllegalArgumentException("Last Name can't be longer than 10 characters");
		}else {
			this.lastName = lastName;
		}
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		if (number == null) {
			throw new IllegalArgumentException("Number can't be null");
		} else if (number.length() != 10) {
			throw new IllegalArgumentException("Number has to be exactly 10 characters");
		}else {
			this.number = number;
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if (address == null) {
			throw new IllegalArgumentException("Address can't be null");
		} else if (address.length() > 30) {
			throw new IllegalArgumentException("Address can't be longer than 30 characters");
		}else {
			this.address = address;
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if (id == null) {
			throw new IllegalArgumentException("ID can't be null");
		} else if (id.length() > id_length) {
			throw new IllegalArgumentException("ID can't be longer than 10 characters");
		} else if (this.id != null){
			throw new IllegalArgumentException("Can't update id");
		}else {
			this.id = id;
		}
	}

	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", number=" + number + ", address="
				+ address + ", id=" + id;
	}
	
}
