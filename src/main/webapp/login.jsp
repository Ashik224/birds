<%--
  Created by IntelliJ IDEA.
  User: ashik
  Date: 5/6/2021
  Time: 6:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<div class="container" align="center">
    <br/><br/><br/>
<form action="" method="post">
    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
    <div class="form-group">
        <label for="name">Username</label>
        <input type="text" class="form-control" name="name" id="name" placeholder="Enter Username">
    </div>
        </div>
    </div>
        <br/><br/>
    <div class="row"><div class="col-sm-4"></div>
    <div class="col-sm-4">
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" name="password" id="password" placeholder="Enter Password">
    </div>
    </div>
    </div>
        <br/>
    <div align="center">
        <button type="submit" class="btn btn-primary">Submit</button>
    </div>
</form>
</div>
</body>
</html>
