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
<form action="indexMusica" method="POST">
<div class="table">
<table border=1 id="table"><tr><td width=40%>
Musica<br></td><td><input type="submit" name="musica" value="INSERISCI" id="button">
		  <input type="submit" name="lista_musica" value="lista" id="button">
		  </td></tr></table></div>		  
</form>
<div class="table">
<table border=1 id="table"><tr><td width=40%>
Film<br></td><td><a href="film"><input type="button" name="film" value="INSERISCI" class="button"></a>
		<a href="film"><input type="button" name="film" value="lista" class="button"></a>
		</td></tr></table></div>
<form action="indexLibri" method="POST">
<div class="table">
<table border=1 id="table"><tr><td width=40%>
Libri<br></td><td><input type="submit" name="libri" value="INSERISCI" id="button">
		 <input type="submit" name="lista_libri" value="lista" id="button">
		 </td></tr></table></div>
</form>
</body>
</html>