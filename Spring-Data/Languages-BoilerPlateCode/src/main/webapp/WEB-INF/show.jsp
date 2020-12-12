<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${language.name}"/> Information</title>
</head>
<body>
        <div class="container">
            <div class="row my-2 justify-content-end">
                <div class="col-1">
                    <a href="">Dashboard</a>
                </div>
            </div>
            <div class="row my-2">
                <div class="col-5"><h1>Name:<c:out value="${language.name}"/></h1></div>
            </div>
            <div class="row my-2">
                <div class="col-5">Creator: <c:out value="${language.creator}"/></div>
            </div>
            <div class="row my-2">
                <div class="col-5">Version:<c:out value="${language.version}"/></div>
            </div>
            <div class="row my-2">
                <div class="col-5"><a href="/langauges/${language.id}/edit">Edit</a></div>
            </div>
            <div class="row my-2">
                 					<form:form action="/languages/${language.id}" method="POST">
                 						<input type="hidden" name="_method" value="delete">
                 						<input class="btn btn-link" type="submit" value="Delete" />
                 					</form:form>
            </div>
        </div>
</body>
</html>