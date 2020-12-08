<!-- Reference JSTL tag library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<header>Student Confirmation</header>

<body>

	The Student is Confirmed : ${student.firstName} ${student.lastName}

	<br>
	<br> Country : ${student.country}

	<br>
	<br> Favorite Language : ${student.favoriteLanguage}

	<br>
	<br> Operation System :

	<ul>
		<c:forEach var="temp" items="${student.operatingSystem}">
			<li>${temp}</li>

		</c:forEach>
	</ul>

</body>

</html>