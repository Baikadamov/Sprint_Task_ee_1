<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.biltlab.narxoz.db.Tasks" %>
<%@ page import="kz.biltlab.narxoz.db.Items" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Демо Bootstrap</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="container mt-5">
    <div class="row">
        <h4 class="text-center">REGISTER PAGE</h4>
        <div class="col-4 mx-auto">
            <%
                String error = request.getParameter("error");
                if (error != null) {
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Incorrect email or password!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
                }
            %>
            <form action="/login" method="post">
                <div class="row">
                    <div class="col-12">
                        <label>Email</label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="email" class="form-control" name="email" required placeholder="">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>Password</label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="password" class="form-control" name="password" required placeholder="">
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <button class="btn btn-success">Login</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>