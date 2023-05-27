<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>MARKETPLACE</title>
</head>
<h1>MARKETPLACE</h1>
<form action="/registration" method="post">
    Имя Пользователя: <input type="text" name="name"><br><br>
    Email: <input type="email" name="email"><br><br>
    Номер телефона: <input type="text" name="phoneNumber"><br><br>
    Пароль: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" name="Зарегистрироваться">
</form>
<#if errorMassage??>
    <h2 style="color: red">${errorMassage}</h2>
</#if>
</body>
</html>