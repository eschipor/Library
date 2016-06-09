<html>
<head>
<title>Musica</title>
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
    background-color: #ffffcc;
    padding: 5px;
}
tr,td
{
	text-align:center;
}
#button
{
	width: 230px;
	font-size: 19px;
	cursor: pointer;
	color: grey;
}
</style>
<body>
<h1 class="contenitore">Dati</h1>
<form action="AddMusica" method="POST">
<div class="table">
<table border=1 id="table">
<tr><td>Artista</td><td><input type="text" name="nome" size=26></td></tr>
<tr><td>Titolo</td><td><input type="text" name="titolo" size=26></td></tr>
<tr><td>Data</td><td><input type="text" name="data" size=26></td></tr>
<tr><td colspan=2 align=center><input type="submit" value="Salva" id="button"></td></tr>
</table>
</div>
</form>
<h1 class="contenitore"></h1>
</body>
</html>