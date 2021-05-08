<%--
  Created by IntelliJ IDEA.
  User: ashik
  Date: 5/6/2021
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<html>
<head>
    <title>Update Page</title>
</head>
<body>
<div class="container">
    <%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");

        if(session.getAttribute("username") == null) {
            response.sendRedirect("login.jsp");
        }
        int id = (int) request.getAttribute("id");
        String name = request.getAttribute("name").toString();
        String scientificName = request.getAttribute("scientificName").toString();
        String category = request.getAttribute("category").toString();
        String region = request.getAttribute("region").toString();
        String description = request.getAttribute("description").toString();
        String image = request.getAttribute("image").toString();
    %>
    <br/> <br/><br/>
    <form action="update" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="<%=id%>">
        <input type="hidden" name="image" value="<%=image%>">
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" name="name" id="name" value="<%=name%>">
        </div> <br/>

        <div class="form-group">
            <label for="scientificName">Scientific Name</label>
            <input type="text" class="form-control" name="scientificName" id="scientificName" value="<%=scientificName%>">
        </div> <br/>

        <div class="form-group">
            <label for="category">Select Category</label>
            <select class="form-control" id="category" name="category">
                <option hidden><%=category%></option>
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
                <option hidden><%=region%></option>
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
            <textarea class="form-control" name="description" id="description" rows="7"><%=description%></textarea>
        </div> <br/>
        <br/> <br/> <br/>

        <img width="64" height="40" src="./uploadedFiles/<%=image%>" alt="<%=image%>">
        <input type="file" name="birdImg"/>

        <div align="center">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>

</div>
</body>
</html>
