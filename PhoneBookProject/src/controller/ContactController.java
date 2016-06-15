package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactDAO;
import dao.ContactDAOIMP;
import model.Contact;

@WebServlet("/ContactController")
public class ContactController extends HttpServlet {
	
	private ContactDAO dao;
	private static final long serialVersionUID = 1L;
	public static final String POST_CONTACT = "/postContact.jsp";
	public static final String ADD_OR_UPDATE = "/contact.jsp";
    
    public ContactController() {
    	dao = new ContactDAOIMP();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter( "action" );
		
		if( action.equalsIgnoreCase( "delete" ) ) {
			forward = POST_CONTACT;
			int contactId = Integer.parseInt( request.getParameter("contactId") );
			dao.deleteContact(contactId);
			request.setAttribute("contacts", dao.getAllContacts() );
		}
		else if( action.equalsIgnoreCase( "uppdate" ) ) {
			forward = ADD_OR_UPDATE;
			int contactId = Integer.parseInt( request.getParameter("contactId") );
			Contact contact = dao.getContactId(contactId);
			request.setAttribute("contact", contact);
		}
		else if( action.equalsIgnoreCase( "add" ) ) {
			forward = ADD_OR_UPDATE;
		}
		else {
			forward =POST_CONTACT;
			request.setAttribute("contacts", dao.getAllContacts() );
		}
		RequestDispatcher view = request.getRequestDispatcher( forward );
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contact contact = new Contact();
		contact.setFirstName( request.getParameter( "firstName" ) );
		contact.setLastName( request.getParameter( "lastName" ) );
		contact.setMail( request.getParameter( "mail" ) );
		contact.setNumber( Integer.parseInt( request.getParameter( "number" ) ) );
		String contactId = request.getParameter("contactId");
		
		if( contactId == null || contactId.isEmpty() ) 
			dao.addContact(contact);
		else {
			contact.setContactId( Integer.parseInt(contactId) );
			dao.updateContact(contact);
		}
		RequestDispatcher view = request.getRequestDispatcher( POST_CONTACT );
		request.setAttribute("contacts", dao.getAllContacts());
		view.forward(request, response);
	}
}
