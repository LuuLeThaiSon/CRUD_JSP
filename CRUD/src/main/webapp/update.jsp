<%--
  Created by IntelliJ IDEA.
  User: borntoreign
  Date: 24/11/2022
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/home?action=updatePost" method="post">
    <input type="text" name="id" id="id" value="${product.getId()}" hidden>
    <label for="name">Product name</label> <br>
    <input type="text" name="name" id="name" placeholder="Enter new product name" value="${product.getName()}"> <br>
    <label for="price">Product price</label> <br>
    <input type="text" name="price" id="price" placeholder="Enter new product price" value="${product.getPrice()}"> <br>
    <button>Submit</button>
</form>
</body>
</html>
