<%--
  Created by IntelliJ IDEA.
  User: borntoreign
  Date: 24/11/2022
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/home?action=createPost" method="post">
        <label for="id">Product id</label> <br>
        <input type="text" name="id" id="id" placeholder="Enter product id"> <br>
        <label for="name">Product name</label> <br>
        <input type="text" name="name" id="name" placeholder="Enter product name"> <br>
        <label for="price">Product price</label> <br>
        <input type="text" name="price" id="price" placeholder="Enter product price"><br>
        <button>Create product</button>
    </form>
</body>
</html>
