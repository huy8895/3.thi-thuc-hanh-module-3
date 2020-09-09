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
    <title>Edit product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Edit Product</h2>
    <form action="/product" method="post">
        <div class="form-group">
            <label for="name">name:</label>
            <input type="text" class="form-control" id="name"  name="name" value="${product.name}">
        </div>
        <div class="form-group">
            <label for="price">price:</label>
            <input type="number" class="form-control" id="price"  name="price" value="${product.price}">
        </div>
        <div class="form-group">
            <label for="quantity">quantity:</label>
            <input type="number" class="form-control" id="quantity"  name="quantity" value="${product.quantity}">
        </div>
        <div class="form-group">
            <label for="color">color:</label>
            <input type="text" class="form-control" id="color"  name="color" value="${product.color}">
        </div>
        <div class="form-group">
            <label for="description">description:</label>
            <input type="text" class="form-control" id="description"  name="description" value="${product.description}">
        </div>
        <div class="form-group">
            <label for="categoryID">categoryID:</label>
            <input type="number" class="form-control" id="categoryID"  name="categoryID" value="${product.categoryID}">
        </div>
        <input type="hidden" name="action" value="edit">
        <button type="submit" value="Search" class="btn btn-primary">Edit</button>
        <a href="/product" class="badge badge-primary">back</a>
    </form>
</div>

</body>
</html>
