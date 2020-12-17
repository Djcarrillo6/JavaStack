<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
 <%@ page isErrorPage="true" %>
<!DOCTYPE html>

<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<meta charset="UTF-8">
<title>Events</title>
</head>
<body>
	 <div class="container">
            <div class="row">
                <div class="col-6">
                 	<div class="row justify-content-between">
                    	<h1><c:out value="${event.name}"/></h1>
                    	<a href="/events">Event Dashboard</a>
                	</div>
                    <div class="row">
                        <h5>Edit Event</h5>
                    </div>
                    <div class="row">
                        <div class="col">
                        	<form:form action="/events/${event.id}/edit" method="POST" modelAttribute="event">
	                            <div class="row my-2">
	                                <div class="col-3">Name</div>
	                                <form:input path="name" class="col-8" type="text" value="${event.name}"/>
	                            </div>
	                            <div class="row my-2">
	                                <div class="col-3">Date</div>
	                                <form:input path="date" class="col-8" type="datetime-local" value="${eventDate}"/>
	                            </div>
	                            <div class="row my-2">
	                                <div class="col-3">Location</div>
	                                <form:input path="location" class="col-6" type="text" value="${event.location}"/>
	                                <form:select path="state" class="col-2" name="" id="">
	                                   <c:forEach items="${states}" var="state">
			                               <option value="${state}" <c:if test="${event.state.equals(state)}">selected</c:if>><c:out value="${state}"/></option>
		                               </c:forEach>
	                                </form:select>
	                            </div>
	                            <div class="row my-2 justify-content-end">
	                                <button class="btn btn-warning" type="submit">Edit</button>
	                            </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</body>
</html>