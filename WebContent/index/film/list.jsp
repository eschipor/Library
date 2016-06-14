<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Film</title>
</head>
<link href="${pageContext.request.contextPath}/library.css" rel="stylesheet" >
<body>
<h1 class="contenitore">Film</h1>
<c:if test = "${empty lista}">
non ci sono film
</c:if>
<table id="table_container"><tr><td>
<c:if test = "${not empty lista}">
<c:forEach items = "${lista}" var = "current">
<div class="container">
<div class="table">
<table id="list_table"><tr><td width=20%>
<a href="/Library/index/film/detail?ID=${current.id}">
</a></td><td>
<a href="/Library/index/film/detail?ID=${current.id}">
Titolo: ${current.titolo}<br></a>
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