<%--
  Created by IntelliJ IDEA.
  User: LAM
  Date: 1/6/2022
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <title>Title</title>
</head>
<body>
<form method="post">
    <div class="form-group">
        <label>Name</label>
        <input type="text" class="form-control" name="name" aria-describedby="emailHelp" placeholder="enter name">
    </div>
    <div class="form-group">
        <label>Price</label>
        <input type=text class="form-control" name="price"
               placeholder="enter price">
    </div>
    <div class="form-group">
        <label>Quantity</label>
        <input type="text" class="form-control" name="quantity" placeholder="enter quantity">
    </div>
    <div class="form-group">
        <label>Color</label>
        <input type="text" class="form-control" name="color"
               placeholder="enter mau sac">
    </div>
    <div class="form-group">
        <label>Description</label>
        <input type="text" class="form-control" name="description"  placeholder="enter description">
    </div>

    <div class="form-group">
        <label>Category</label>
        <select name="idCategory">
            <c:forEach items="${category}" var="p">
                <option value="${p.idCategory}">
                    <p>${p.namecategory}</p>
                </option>
            </c:forEach>
        </select>

    </div>
    <%--    <div class="form-check">--%>
    <%--        <input type="checkbox" class="form-check-input" id="exampleCheck1">--%>
    <%--        <label class="form-check-label" for="exampleCheck1">Check me out</label>--%>
    <%--    </div>--%>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>