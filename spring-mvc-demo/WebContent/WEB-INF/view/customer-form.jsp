<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Customer Registration form</title>
<style>
.error {
	color: red
}
</style>
</head>

<body>

	<i>Fill out the form Asterisk(*) means required.</i>

	<form:form action="processFrom" modelAttribute="customer">
    	
    	First Name  : <form:input path="firstName" />

		<br>
		<br>
    	
     	Last Name * : <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" />

		<br>
		<br>
     	Free passes : <form:input path="feePasses" />
		<form:errors path="feePasses" cssClass="error"></form:errors>
		<br>
		<br>
		Postal Code : <form:input path="postalCode"/>
		<form:errors path="postalCode" cssClass="error"></form:errors>
			<br>
		<br>
		
			Course Code : <form:input path="courseCode"/>
		<form:errors path="courseCode" cssClass="error"></form:errors>
			<br>
		<br>
		<input type="submit" value="Submit" />

	</form:form>

</body>
</html>