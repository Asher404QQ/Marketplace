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
<h4>Подробная информация о товаре</h4>
<#list images as img>
    <img src="/images/${img.id}" height="60px"/><br><br>
</#list>
<b>Название: </b>${product.title}<br>
<b>Описание: </b>${product.description}<br>
<b>Состав: </b>${product.structure}<br>
<b>Цена: </b>${product.price} руб.<br>
<b>Вес: </b>${product.weight} гр.<br>
<b>Автор: </b><a href="/user/${product.user.id}">${product.user.name}</a><br>
</body>
</html>