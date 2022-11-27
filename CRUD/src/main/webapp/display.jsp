<%--
  Created by IntelliJ IDEA.
  User: borntoreign
  Date: 24/11/2022
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="products.isEmpty()">
    <p>Product list empty</p>
</c:if>
<hr>
<table>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${products}" var="p">
        <tr>
            <td><c:out value="${p.getId()}"/></td>
            <td><c:out value="${p.getName()}"/></td>
            <td><c:out value="${p.getPrice()}"/></td>
            <td>
                <button><a href="/home?action=updateGet&id=${p.getId()}">Edit</a></button>
            </td>
            <td>
                <button><a href="/home?action=delete&id=${p.getId()}">Delete</a></button>
            </td>
        </tr>
    </c:forEach>
</table>
<button><a href="/home?action=createGet">Create</a></button>
</body>
</html>
