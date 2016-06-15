package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Contact;
import connectdb.ConnectDB;

public class ContactDAOIMP implements ContactDAO {
	
	private Connection conn;

	public ContactDAOIMP() {
		conn = ConnectDB.getConnection();
	}
	@Override
	public void addContact( Contact contact ) {
		try {
			String query = "insert into contacts (firstName, lastName, eMail, number) values (?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString( 1, contact.getFirstName() );
			preparedStatement.setString( 2, contact.getLastName() );
			preparedStatement.setString( 3, contact.getMail() );
			preparedStatement.setInt( 4, contact.getNumber() );
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteContact( int contactId ) {
		try {
			String query = "delete from contacts where contactId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, contactId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void updateContact( Contact contact ) {
		try {
			String query = "update contacts set firstName=?, lastName=?, eMail=?, number=? where contactId=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setString( 1, contact.getFirstName() );
			preparedStatement.setString( 2, contact.getLastName() );
			preparedStatement.setString( 3, contact.getMail() );
			preparedStatement.setInt( 4, contact.getNumber() );
			preparedStatement.setInt(5, contact.getContactId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Contact> getAllContacts() {
		List<Contact> contacts = new ArrayList<Contact>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery( "select * from contacts" );
			while( resultSet.next() ) {
				Contact contact = new Contact();
				contact.setContactId( resultSet.getInt( "contactId" ) );
				contact.setFirstName( resultSet.getString( "firstName" ) );
				contact.setLastName( resultSet.getString( "lastName" ) );
				contact.setMail( resultSet.getString( "eMail" ) );
				contact.setNumber( resultSet.getInt( "number" ) );
				contacts.add(contact);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contacts;
	}
	@Override
	public Contact getContactId(int contactId) {
		Contact contact = new Contact();
		try {
			String query = "select * from contacts where contactId=?";
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, contactId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) {
				contact.setContactId( resultSet.getInt( "contactId" ) );
				contact.setFirstName( resultSet.getString( "firstName" ) );
				contact.setLastName( resultSet.getString( "LastName" ) );
				contact.setMail( resultSet.getString( "eMail" ) );
				contact.setNumber( resultSet.getInt( "number" ) );
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contact;
	}

}