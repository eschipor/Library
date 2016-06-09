<html>
<head>
<title>Library</title>
</head>
<style type="text/css">
.contenitore
{
	background-color: #ffffcc;
    color: grey;
    padding: 5px;
    text-align: center;
    font-size: 46px;
    font-family: Courier;
}
.button
{
	width: 225px;
	font-size: 19px;
	cursor: pointer;
	color: grey;
}
div.table 
{
    width:98%; 
    margin:1%;
}
table#table 
{
    text-align:center; 
    margin-left:auto; 
    margin-right:auto;
    width: 400; 
    background-color: #ffffcc;
    font-size: 22px;
    font-weight: bold;
    font-family: arial black;
    color: grey;
    padding: 5px;
}
tr,td
{
	text-align:center;
}
</style>
<body>
<h1 class="contenitore">Library</h1>

<div class="table">
<table border=1 id="table"><tr><td width=40%>
Musica<br></td><td><a href="index/musica/insert.jsp"><input type="button" name="musica" value="INSERISCI" class="button"></a>
		  <a href="index/musica?list=show"><input type="button" name="list" value="Lista" class="button"></a>
		  </td></tr></table>	
<br> 	  

<table border=1 id="table"><tr><td width=40%>
Film<br></td><td><a href="index/film/insert.jsp"><input type="button" name="film" value="INSERISCI" class="button"></a>
		<a href="index/film?list=show"><input type="button" name="list" value="Lista" class="button"></a>
		</td></tr></table>
<br>

<table border=1 id="table"><tr><td width=40%>
Libri<br></td><td><a href="index/libri/insert.jsp"><input type="button" name="libri" value="INSERISCI" class="button"></a>
		 <a href="index/libri?list=show"><input type="button" name="list" value="Lista" class="button"></a>
		 </td></tr></table></div>

</body>
<h1 class="contenitore"></h1>
</html>