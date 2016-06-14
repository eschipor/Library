<html>
<head>
<title>Musica</title>
</head>
<link href="${pageContext.request.contextPath}/library.css" rel="stylesheet" >
<body>
<h1 class="contenitore">Dati</h1>
<form action="AddMusica" method="POST">
<div class="table">
<table border=1 class="table">
<tr><td>Artista</td><td><input type="text" name="nome" size=26></td></tr>
<tr><td>Titolo</td><td><input type="text" name="titolo" size=26></td></tr>
<tr><td>Data</td><td><input type="text" name="data" size=26></td></tr>
<tr><td colspan=2 align=center><input type="submit" value="Salva" class="button_2"></td></tr>
</table>
</div>
</form>
<h1 class="contenitore"></h1>
</body>
</html>