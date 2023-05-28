<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>MARKETPLACE</title>
</head>
<body>
    <h1>MARKETPLACE</h1>
    <#if user.email??>
        <h3>Имя пользователя: <i>${user.name}</i></h3>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="Выйти">
        </form>
        <#if user.isAdmin()>
            <a href="/admin">Панель администратора</a>
        </#if>
    <#else>
        <h1><a href="/login">Войти</a></h1>
        <hr>
    </#if>
    <h4>Товары по всей России!</h4>
    <form action="/" method="get">
        Поиск объявления по названию: <input type="text" name="title"><br>
        <input type="submit" value="Поиск">
    </form>
    <#list products as product>
        <div>
            <p><b>${product.title}</b> ${product.price} руб. | <a href="/product/${product.id}">Подробнее...</a></p>
        </div>
        <#else>
        <h3>Товаров нет</h3>
    </#list>
    <#if user.email??>
        <hr>
        <h3>Создать новый товар</h3>
        <form action="/product/create" method="post" enctype="multipart/form-data">
            Название: <input type="text" name="title"/><br><br>
            Описание: <input type="text" name="description"/><br><br>
            Состав: <input type="text" name="structure"/><br><br>
            Цена: <input type="number" name="price"/> руб.<br><br>
            Вес: <input type="number" name="weight"/> гр.<br><br>
            Первая фотография: <input type="file" name="file1"/><br><br>
            Вторая фотография: <input type="file" name="file2"/><br><br>
            Третья фотография: <input type="file" name="file3"/><br><br>
            Четвертая фотография: <input type="file" name="file4"/><br><br>
            Пятая фотография: <input type="file" name="file5"/><br><br>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="Добавить товар">
        </form>
    </#if>
</body>
</html>