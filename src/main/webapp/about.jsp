<%@ page import="java.io.OutputStream" %><%--
  Created by IntelliJ IDEA.
  User: ashik
  Date: 5/2/2021
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>About Page</title>
</head>
<body>
    This is about page
    <%
        String image = request.getAttribute("image").toString();
    %>
    <img src="data:image/jpeg;base64,<%=image%>" width="100px" height="100px" alt="Photo">
<%--    <%= image %>--%>
</body>
</html>
