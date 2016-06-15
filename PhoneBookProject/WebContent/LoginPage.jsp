<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login page</title>
 		<link rel="stylesheet" href="css/style.css">
	</head>
<body>
      <h1>Contacts</h1>
        <form action="verify.jsp" method="get" class="login">
          Enter UserName : <input type="text" class="login-input" name="uname"/>
          <br/> Enter Password : <input type="password" class="login-input" name="pass"/>
          <br/> <input type="submit" value="Log in" class="login-submit"/>
       </form>
</body>
</html>