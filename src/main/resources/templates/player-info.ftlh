<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>GameSite</title>
</head>
<body>
<h1>Players</h1>
<h2>Player Information</h2>


<b>Player nickname: </b> ${player.nickname}<br>
<b>Player Real Name: </b>${player.realName}<br>
<b>Player national: </b>${player.national}<br>
<b>Player age: </b>${player.age}<br>
<b>Player team: </b>${player.team}<br>

<hr>
<form action="/player/delete/${player.id}" method="post">
    <input type="submit" value="Delete player"/>
</form>
</body>
</html>