<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Film</title>
</head>
<body>
<h1>Film</h1>
<c:if test = "${not empty film}">
ID: ${film.id}<br>
Titolo: ${film.titolo}<br>
Data: ${film.data}<br>
</c:if>
</body>
</html>