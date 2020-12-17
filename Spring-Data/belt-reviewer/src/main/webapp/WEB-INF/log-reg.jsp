<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
 <%@ page isErrorPage="true" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<title>Welcome</title>
</head>
<body>
	<div class="container">
            <header>
                <h1 class="display-1">Welcome</h1>
            </header>
            <div class="row justify-content-between">
                <div class="col-6 border border-dark">
                    <h1>Register</h1>
                    <form:form action="/register" method="POST" modelAttribute="user">
                    	<div class="row my-2 text-danger">
                    		<form:errors path="*"/>
                    	</div>
	                    <div class="row my-2">
	                        <div class="col-4">First Name</div>
	                        <form:input path="firstName" class="col-7" type="text"/>
	                    </div>
	                    <div class="row my-2">
	                        <div class="col-4">Last Name</div>
	                        <form:input path="lastName" class="col-7" type="text"/>
	                    </div>
	                    <div class="row my-2">
	                        <div class="col-4">Email</div>
	                        <form:input path="email" class="col-7" type="text"/>
	                    </div>
	                    <div class="row my-2">
	                        <div class="col-4">Location</div>
	                        <form:input path="location" class="col-5" type="text"/>
	                        <form:select path="state" class="col-2" name="state" id="">
	                        	<c:forEach items="${states}" var="state">
	                            	<option value="${state}"><c:out value="${state}"></c:out></option>
	                            </c:forEach>
	                        </form:select>
	                    </div>
	                    <div class="row my-2">
	                        <div class="col-4">Password</div>
	                        <form:input path="password" class="col-7" type="password"/>
	                    </div>
	                    <div class="row my-2">
	                        <div class="col-4">PW Conf:</div>
	                        <form:input path="passwordConfirmation" class="col-7" type="password"/>
	                    </div>
	                    <div class="row my-2">
	                    	<div class="col text-right">
	                    		<button type="submit" class="btn btn-outline-dark">Register</button>
	                    	</div>
	                    </div>
                    </form:form>
                </div>
                <div class="col-5 border-dark border">
                    <h1>Login</h1>
                    <form action="/login" method="POST">
                    	<div class="row my-2 text-danger">
                    		<c:out value="${errors}"/>
                    	</div>
	                    <div class="row my-2">
	                        <div class="col-4">Email</div>
	                        <input class="col-7" name="email" type="email"/>
	                    </div>
	                    <div class="row my-2">
	                        <div class="col-4">Password</div>
	                        <input class="col-7" name="password" type="password"/>
	                    </div>
	                    <div class="row my-2">
	                    	<div class="col text-right">
	                    		<button type="submit" class="btn btn-outline-primary">Login</button>
	                    	</div>
	                    </div>
                    </form>
            </div>
        </div>
</body>
</html>