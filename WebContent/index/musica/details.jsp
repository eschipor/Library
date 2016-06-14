<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Musica</title>
</head>
<link href="${pageContext.request.contextPath}/library.css" rel="stylesheet" >
<body>
<h1 class="contenitore">Libri</h1>
<table id="table_container"><tr><td>
<div class="container">
<div class="table">
<table id="detail_table" border=1><tr><td width=50%>
</td><td>
ID: ${musica.id}<br>
Titolo: ${musica.titolo}<br>
Data: ${musica.data}<br>
</td></tr></table>
</div>
</div>
</td></tr></table>
</body>
</html>