<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Marketplace</title>
</head>
<body>
    <h1>MARKETPLACE</h1>
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
    <hr>
    <h3>Создать новый товар</h3>
    <form action="/product/create" method="post">
        Название: <input type="text" name="title"/><br><br>
        Описание: <input type="text" name="description"/><br><br>
        Состав: <input type="text" name="structure"/><br><br>
        Цена: <input type="number" name="price"/> руб.<br><br>
        Вес: <input type="number" name="weight"/> гр.<br><br>
        Автор: <input type="text" name="author"/><br><br>
        <input type="submit" value="Добавить товар">
    </form>
</body>
</html>