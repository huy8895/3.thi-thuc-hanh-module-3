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
    <title>Create new Product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Create new Product</h2>
    <form action="/product" method="post">
        <div class="form-group">
            <label for="name">name:</label>
            <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
        </div>
        <div class="form-group">
            <label for="price">price:</label>
            <input type="number" class="form-control" id="price" placeholder="Enter price" name="price">
        </div>
        <div class="form-group">
            <label for="quantity">quantity:</label>
            <input type="number" class="form-control" id="quantity" placeholder="Enter quantity" name="quantity">
        </div>
        <div class="form-group">
            <label for="color">color:</label>
            <input type="text" class="form-control" id="color" placeholder="Enter color" name="color">
        </div>
        <div class="form-group">
            <label for="description">description:</label>
            <input type="text" class="form-control" id="description" placeholder="Enter description" name="description">
        </div>
        <div class="form-group">
            <label for="categoryID">categoryID:</label>
            <input type="number" class="form-control" id="categoryID" placeholder="Enter categoryID" name="categoryID">
        </div>
        <input type="hidden" name="action" value="create">
        <button type="submit" value="Search" class="btn btn-primary">Create</button>
        <button type="reset" value="Reset" class="btn btn-secondary">Reset</button>
        <a href="/product" >back</a>
    </form>
</div>
</body>
</html>
