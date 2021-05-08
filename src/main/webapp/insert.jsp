<%--
  Created by IntelliJ IDEA.
  User: ashik
  Date: 5/1/2021
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Insert Page</title>
    <jsp:include page="cssLoader.jsp"/>
</head>
<body>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expires", "0");

    if(session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<div class="container">
    <br/> <br/><br/>
    <form action="insert" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" name="name" id="name" placeholder="Name">
        </div> <br/>

        <div class="form-group">
            <label for="scientificName">Scientific Name</label>
            <input type="text" class="form-control" name="scientificName" id="scientificName" placeholder="Scientific name">
        </div> <br/>

        <div class="form-group">
            <label for="category">Select Category</label>
            <select class="form-control" id="category" name="category">
                <option>Flightless Bird</option>
                <option>Night Bird</option>
                <option>Song Bird</option>
                <option>Bird of Prey</option>
                <option>Wading Bird</option>
            </select>
        </div> <br/>

        <div class="form-group">
            <label for="region">Select Region</label>
            <select class="form-control" id="region" name="region">
                <option>Asia</option>
                <option>Africa</option>
                <option>North America</option>
                <option>South America</option>
                <option>Europe</option>
                <option>Australia</option>
                <option>Antarctica</option>
            </select>
        </div> <br/>

        <div class="form-group">
            <label for="description">Description</label>
            <textarea class="form-control" name="description" id="description" rows="7" placeholder="Description"></textarea>
        </div> <br/>
<br/> <br/> <br/>

        <input type="file" name="birdImg"/>

        <div align="center">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>

</div>
</body>
</html>
