package model;

public class Contact {

	private int contactId;
	private String firstName;
	private String lastName;
	private String mail;
	private int number;
	
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Contacts [contactId=" + contactId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", eMail=" + mail + ", number="
				+ number + "]";
	}
		
}
