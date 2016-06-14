<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Film</title>
</head>
<link href="${pageContext.request.contextPath}/library.css" rel="stylesheet" >
<body>
<h1 class="contenitore">Film</h1>
<table id="table_container"><tr><td>
<div class="container">
<div class="table">
<table id="detail_table" border=1><tr><td width=50% height=300>
${film.media.ref_media}<br>
Nome: ${film.media.nome}<br>
Tipo: ${film.media.tipo}<br>
Indirizzo: ${film.media.indirizzo}<br>
Size: ${film.media.size}<br>
</td><td>
ID: ${film.id}<br>
Titolo: ${film.titolo}<br>
Data: ${film.data}<br>
</td></tr></table>
</div>
</div>
</td></tr></table>
</body>
</html>