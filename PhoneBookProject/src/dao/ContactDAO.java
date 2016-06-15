package dao;

import java.util.List;

import model.Contact;

public interface ContactDAO {
	public void addContact( Contact contact );
	public void deleteContact( int contactId );
	public void updateContact( Contact contact );
	public List<Contact> getAllContacts();
	public Contact getContactId( int contactId );
}
