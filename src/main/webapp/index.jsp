<%@ page import="com.example.BirdInfo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp"%>
<%--<%@ include file="footer.jsp"%>--%>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <jsp:include page="cssLoader.jsp"/>
</head>
<body>
    <jsp:include page="/hello"/>
<%--    <%--%>
<%--        List<BirdInfo> info = (List<BirdInfo>) request.getAttribute("birdInfo");--%>
<%--    %>--%>

    <div class="container" align="center">
        <br/><br/><br/>
    <iframe width="853" height="480" src="https://www.youtube.com/embed/a1wp1RnC7kk" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

        <div class="row">
            <c:forEach var="bird" items="${birdInfo}">

                <div class="col-sm-4">
                    <br/><br/><br/><br/>
                    <div class="card">
                        <img class="card-img-top" width="240" height="180" src="./uploadedFiles/${bird.getRealImage()}" alt="${bird.getRealImage()}">
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
    <br/><br/><br/>
    <%@ include file="footer.jsp"%>
</body>
</html>
