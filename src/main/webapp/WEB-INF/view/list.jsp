<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: huy8895
  Date: 9/9/20
  Time: 8:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LIST PRODUCT</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2><a href="/product" class="badge badge-primary">List products</a> </h2>
    <form method="get" action="/product">
        <input type="text" class="form-control" id="description" placeholder="Enter " name="searchBox">
        <input type="hidden" name="action" value="search">
        <button type="submit" value="Search" class="btn btn-secondary">Search</button>
    </form>
    <form method="get" action="/product">
        <input type="hidden" name="action" value="create">
        <button type="submit" class="btn btn-success">create</button>
    </form>
    <table class="table table-hover">
        <tr>
            <th>name</th>
            <th>price</th>
            <th>quantity</th>
            <th>color</th>
            <th>description</th>
            <th>category</th>
            <td colspan="2">Action</td>
        </tr>
        <c:forEach  var="product" items="${productList}">
            <tr>
                <td><c:out value="${product.name}"></c:out></td>
                <td><c:out value="${product.price}"></c:out></td>
                <td><c:out value="${product.quantity}"></c:out></td>
                <td><c:out value="${product.color}"></c:out></td>
                <td><c:out value="${product.description}"></c:out></td>
                <td><c:out value="${categoryDAOImp.selectCategory(product.categoryID).name}"></c:out></td>
                <td><h4><a href="/product?action=edit&id=${product.id}" class="badge badge-primary">edit</a></h4></td>
                <td><h4><a href="/product?action=delete&id=${product.id}" class="badge badge-danger">delete</a></h4></td>
            </tr>

        </c:forEach>
    </table>
    </div>
</body>
</html>
