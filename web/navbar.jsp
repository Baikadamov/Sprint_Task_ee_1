<%@ page import="kz.biltlab.narxoz.db.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Users currentUser = (Users) session.getAttribute("currentUser");
%>
<nav class="navbar navbar-expand-lg navbar-dark  bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">ITEMS</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Переключатель навигации">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Items</a>
                </li>
                <%
                    if(currentUser!=null){
                %>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        <%=currentUser.getFullName()%>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/profile">Profile</a></li>

                    </ul>
                </li>
                <%
                }else{
                %>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/login">Sign in</a>
                </li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>
</nav>