<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Libri</title>
</head>
<style type="text/css">
.container
{ 
	margin:1em; 	 
	float:left;
}
.contenitore
{
	background-color: #ffffcc;
    color: grey;
    padding: 5px;
    text-align: center;
    font-size: 46px;
    font-family: Courier;
}
div.table 
{
    width:98%; 
    margin:1%;
}
table#table1 
{
    text-align:center; 
    margin-left:auto; 
    margin-right:auto; 
    width:674px;
}
table#table2 
{
    text-align:center; 
    margin-left:auto; 
    margin-right:auto; 
    width:300px;
    border-bottom: 2px solid #ddd;
}
tr,td
{
	text-align:left;
}
</style>
<body>
<h1 class="contenitore">Libri</h1>
<c:if test = "${empty lista}">
non ci sono libri
</c:if>
<table id="table1"><tr><td>
<c:if test = "${not empty lista}" var = "current">
<c:forEach items = "${lista}" var = "current">
<div class="container">
<div class="table">
<table id="table2"><tr><td><tr><td width=20%>
<a href="/Library/index/libri/detail?ID=${current.id}">
<img src="D:\INSTALL\eclipse-jee-mars-2-win32-x86_64\immagini\film.jpg" width=100%></a></td><td>
<a href="/Library/index/libri/detail?ID=${current.id}">
Autore: ${current.nome}<br></a>
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