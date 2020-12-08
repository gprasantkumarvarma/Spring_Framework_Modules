<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>Student Registration From
</head>
<body>

	<form:form action="processFrom" modelAttribute="student">
     
     First Name : <form:input path="firstName" />

		<br>
		<br>
     
     Last Name  : <form:input path="lastName" />

		<br>
		<br>

		<!--  Country    : <form:select path="country">

			<form:option value="Brazil" label="Brazil" />
			<form:option value="France" label="France" />
			<form:option value="Germany" label="Germany" />
			<form:option value="India" label="India" />

		</form:select>
		
		--> 
		
		Country    : <form:select path="country">

			<form:options items="${student.contryOption}" />

		</form:select>

		<br>
		<br>

		<!--  
      Favorite Language:
        Java<form:radiobutton path="favoriteLanguage" value="java" />
        C#<form:radiobutton path="favoriteLanguage" value="C#" />
        PHP<form:radiobutton path="favoriteLanguage" value="PHP" />
        Ruby<form:radiobutton path="favoriteLanguage" value="RUBY" />
	--> 
      Favorite Language:
         <form:radiobuttons path="favoriteLanguage"
			items="${student.favoriteLanguageOption}" />
		<br>
		<br>
		Favorite Operation system:
		Linux <form:checkbox path="operatingSystem" value="Linux"/>
		Mac OS <form:checkbox path="operatingSystem" value="Mac OS"/>
		MS Windows <form:checkbox path="operatingSystem" value="MS Windows"/>
		<br>
		<br>
		
		
		
		
		
		<input type="submit" value="Submit" />






	</form:form>


</body>
</html>