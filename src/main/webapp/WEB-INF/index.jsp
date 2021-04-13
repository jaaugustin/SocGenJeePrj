<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>

<br/>
    <div style='color:red' >${keyErrLogin}</div>
<br/>

<form action="Controleur" >
    Login : <input type="text" name="loginForm" value=""/><br/>
    Mot de passe : <input type="text" name="pwdForm" value=""/><br/>
    <input type="submit" name="action" value="Validez"/><br/>
</form>

</body>
</html>