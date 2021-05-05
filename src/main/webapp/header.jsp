<%--
  Created by IntelliJ IDEA.
  User: ashik
  Date: 5/1/2021
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>

<body>
<jsp:include page="cssLoader.jsp"/>
<div class="container" id = "primary">
    <header class="header">
        <nav class="navbar navbar-expand-lg navbar-light bggreen">
            <div class="container-fluid">
                <a class="navbar-brand" href="index.jsp">
                    <img src="./resources/images/logo.png" alt="LOGO"/>
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                </button>
                <div class="collapse navbar-collapse justify-content-between" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="insert.jsp">Insert</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="about">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Login</a>
                        </li>
                    </ul>
                    <ul class="navbar-nav ms-auto">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-dark" type="submit">Search</button>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
</div>
</body>
