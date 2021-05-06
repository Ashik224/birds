<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: ashik
  Date: 5/5/2021
  Time: 12:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<html>
<head>
    <title>Details Page</title>
</head>
<body>
    <%
        String name = request.getAttribute("name").toString();
        String scientificName = request.getAttribute("scientificName").toString();
        String category = request.getAttribute("category").toString();
        String region = request.getAttribute("region").toString();
        String description = request.getAttribute("description").toString();
        String image = request.getAttribute("image").toString();
    %>
 <div class="container" align="center">
     <br/><br/><br/>
     <img src="./uploadedFiles/<%=image%>" alt="Details Image">
     <h2><%=name%></h2>
     <h3>Scientific Name: <i><%=scientificName%></i></h3>
     <h4>Category: <b><%=category%></b></h4>
     <h4>Region: <b><%=region%></b></h4>
     <p><%=description%></p>
     <br/><br/>
     <form action="retrieveForUpdate" method="post">
         <input type="hidden" name="scientific" value="<%=scientificName%>">
         <input type="submit" class="btn btn-success" value="Update">
     </form>
     <form action="delete" method="post">
         <input type="hidden" name="scientific" value="<%=scientificName%>">
         <input type="submit" class="btn btn-danger" value="Delete">
     </form>
 </div>
</body>
</html>
