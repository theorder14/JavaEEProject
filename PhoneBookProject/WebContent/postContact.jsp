<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Contacts</title>
<link rel="stylesheet" href="css/style2.css">
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>ContactID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Mail</th>
				<th>Number</th>
				<th colspan="2">EditorDelete</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${contacts}" var="contact">
				<tr>
					<td><c:out value="${contact.contactId}" /></td>
					<td><c:out value="${contact.firstName}" /></td>
					<td><c:out value="${contact.lastName}" /></td>
					<td><c:out value="${contact.mail}" /></td>
					<td><c:out value="${contact.number}" /></td>
					<td><a
						href="ContactController.do?action=uppdate&contactId=<c:out value="${contact.contactId }"/>">Update</a></td>
					<td><a
						href="ContactController.do?action=delete&contactId=<c:out value="${contact.contactId }"/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="ContactController.do?action=add">Add Contact</a>
	</p>
	<br>
	   <a href="LoginPage.jsp">Log out</a>
</body>
</html>