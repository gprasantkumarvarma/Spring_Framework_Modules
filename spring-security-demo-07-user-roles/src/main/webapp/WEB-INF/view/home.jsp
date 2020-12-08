<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<html>

<head>
<title>Love 2 Code Home Page</title>
</head>
<body>
	<h2>Love 2 code Company Home Page</h2>
	<hr>

	<p>Welcome to the Love 2 Code home Page!</p>

	<hr>
	<!-- display user name -->
	<p>
		User:
		<security:authentication property="principal.username" />
		<br> <br> Role(s) :
		<security:authentication property="principal.authorities" />

	</p>
	<hr>

	<security:authorize access="hasRole('MANAGER')">
	
		<!-- add a link to point to/leader...this is for the manager -->

		<p>
			<a href="${pageContext.request.contextPath}/leaders">LeaderShip
				Meeting</a> (Only for manager peeps)
		</p>
	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">
	
		<!-- Add alink to point to /system.. this is only for the admins -->
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT Systems
				Meeting</a> (Only for Admin peeps)
		</p>

		<hr>
	</security:authorize>
	<hr>
	<!-- add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="logout" />

	</form:form>


</body>
</html>