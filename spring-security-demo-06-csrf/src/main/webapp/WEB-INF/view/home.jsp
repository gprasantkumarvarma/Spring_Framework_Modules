<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>
<title>Love 2 Code Home Page</title>
</head>
<body>
<h2>Love 2 code Company Home Page</h2>
<hr>

<p>
Welcome to the Love 2 Code home Page!
</p>

	<!-- add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		
		<input type="submit" value="logout"/>
		
		</form:form>
	

</body>
</html>