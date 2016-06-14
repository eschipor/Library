<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Musica</title>
</head>
<link href="${pageContext.request.contextPath}/library.css" rel="stylesheet" >
<body>
<h1 class="contenitore">Musica</h1>
<c:if test = "${empty lista}">
non ci sono canzoni!
</c:if>
<table id="table_container"><tr><td>
<c:if test = "${not empty lista}">
<c:forEach items = "${lista}" var = "current">
<div class="container">
<div class="table">
<table id="list_table"><tr><td><tr><td width=20%>
<a href="/Library/index/musica/detail?ID=${current.id}">
<img src="D:\INSTALL\eclipse-jee-mars-2-win32-x86_64\immagini\film.jpg" width=100%></a></td><td>
<a href="/Library/index/musica/detail?ID=${current.id}">
Artista: ${current.nome}<br></a>
Titolo: ${current.titolo}<br>
Data: ${current.data}<br>
</td></tr></table>
</div>
</div>
</c:forEach>
</c:if>
</td></tr>
</table>
<h1 class="contenitore"></h1>
</body>
</html>