<!DOCTYPE html>
<head>
    <title>GameSite</title>
</head>
<body>
<h1>Players</h1>
<form action="/" method="get">
    Search by player nickname: <input type="text" name="nickname"><br>
    <input type="submit" value="Search"/>
</form>

<#list players as player>
    <div>
        <p><b>${player.nickname} </b>${player.realName} | <a href="/player/${player.id}"> More Info </a> </p>
    </div>
    <#else>
        <h3>No Player</h3>
</#list>
<hr>
<h3>NEW PLAYER</h3>
<form action="/player/create" method="post">
    Player nickname: <input type="text" name="nickname"/> <br><br>
    Player real name: <input type="text" name="realName"/> <br><br>
    Player national: <input type="text" name="national"/> <br><br>
    Player age: <input type="number" name="age"/> <br><br>
    Player team: <input type="text" name="team"/> <br><br>
    <input type="submit" value="New player"/>
</form>
</body>
</html>