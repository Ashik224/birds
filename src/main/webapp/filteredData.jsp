<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.BirdInfo" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ashik
  Date: 5/7/2021
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<%
    List<BirdInfo> birdInfoList = (List<BirdInfo>) request.getAttribute("birdInfoList");
%>
<div class="container" align="center">
    <br/><br/><br/>

    <div class="row">
        <c:forEach var="bird" items="${birdInfoList}">

            <div class="col-sm-4">
                <br/><br/><br/><br/>
                <div class="card">
                    <img width="286" height="180" class="card-img-top" src="./uploadedFiles/${bird.getRealImage()}" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">${bird.getName()}</h5>
                        <p class="card-text">${bird.getCategory()}</p>
                        <form action="details" method="post">
                            <input type="hidden" name="scientificName" value="${bird.getScientificName()}">
                            <button class="btn btn-primary"> View Details</button>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
