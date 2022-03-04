<%--
  Created by IntelliJ IDEA.
  User: simonpirko
  Date: 1.03.22
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<form action="/user/reg" method="post">
	<input type="text" name="name" placeholder="Name">
	<p>${name}</p>
	<input type="text" name="password" placeholder="Password">
	<p>${password}</p>
	<button>Submit</button>
</form>
</body>
</html>
