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

<title><c:out value="${event.name}"/></title>
</head>
<body>
	 <div class="container">
            <header>
                 <div class="row justify-content-between">
                    <h1><c:out value="${event.name}"/></h1>
                    <a href="/events">Event Dashboard</a>
                </div>
            </header>
            <div class="row justify-content-between">
                <div class="col-6">
                    <div class="row my-1">
                        <div class="col-3">Host:</div>
                        <div class="col-8"><c:out value="${event.host.firstName} ${event.host.lastName}"/></div>
                    </div>
                    <div class="row my-1">
                        <div class="col-3">Date:</div>
                        <div class="col-8"><c:out value="${event.date}"/></div>
                    </div>
                    <div class="row my-1">
                        <div class="col-3">Location:</div>
                        <div class="col-8"><c:out value="${event.location}"/></div>
                    </div>
                    <div class="row my-1">
                        <div class="col-3"># Attendees:</div>
                        <div class="col-8"><c:out value="${event.attendees.size()}"/></div>
                    </div>
                    <div class="row my-4">
                        <table class="table table-striped table-bordered">
                            <thead>
                                <th>Name</th>
                                <th>Location</th>
                            </thead>
                            <tbody>
                            	<c:forEach items="${event.attendees}" var="attendee">
	                                <tr>
	                                    <td><c:out value="${attendee.firstName} ${attendee.lastName}"/></td>
	                                    <td><c:out value="${attendee.location}"/></td>
	                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col-5">
                    <h3>Message Wall</h3>
                    <div class="row my-2">
                        <div style="overflow-y: scroll; height: 300px;" class="container border border-dark">
                            <c:forEach items="${event.messages}" var="message">
	                            <p><c:out value="${message.user.firstName} ${message.user.lastName}"/> says: <c:out value="${message.message}"/></p>
	                            <p>-----------------------------------</p>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="row my-2">
                        Add Comment:
                    </div>
                    <form action="/events/${event.id}/message" method="POST"> 
	                    <div class="row my-2">
	                        <input name="newMessage" class="col-12 border border-dark" type="text"/>
	                    </div>
	                    <div class="row">
	                        <div class="col text-right">
	                            <button class="btn btn-outline-success">Submit</button>
	                        </div>
	                    </div>
                    </form>
                </div>
            </div>
        </div>
</body>
</html>