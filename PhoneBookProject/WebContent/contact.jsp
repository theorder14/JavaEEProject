<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add New Contact</title>
		<link rel="stylesheet" href="css/style3.css">
	</head>
<body>
	<h1>Add Contact</h1>
 	<form action="ContactController.do" method="post">
		<fieldset>
			<div>
				<label for="contactId">ContactID</label> <input type="text"
					name="contactId" value="<c:out value="${contact.contactId}" />"
					readonly="readonly" placeholder="Contact ID" />
			</div>
			<div>
				<label for="firstName">First Name</label> <input type="text"
					name="firstName" value="<c:out value="${contact.firstName}" />"
					placeholder="First Name" />
			</div>
			<div>
				<label for="lastName">Last Name</label> <input type="text"
					name="lastName" value="<c:out value="${contact.lastName}" />"
					placeholder="Last Name" />
			</div>
			<div>
					<label for="mail">Mail</label> <input type="text" name="mail"
					value="<c:out value="${contact.mail}" />" placeholder="Mail" />
			</div>
			<div>
				<label for="number">Number</label> <input type="text" name="number"
					value="<c:out value="${contact.number}" />" placeholder="Number" /></div>
		  </fieldset>
        <input type="submit" value="submit" />
        <br></br>
        <a href="ContactController.do?action=postContact">Return</a>
      </form>
	</body>
</html>