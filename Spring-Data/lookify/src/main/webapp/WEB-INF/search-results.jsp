<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
 
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
        <div class="container">
            <div class="row my-2 justify-content-center">
                <div class="col-6">
                    <h3>Songs by artist: <c:out value="${query}" /> </h3>
                </div>
                <div class="col-4">
                	<form action="/lookify/search" method="post">
	                    <input type="text" name="searchString">
	                    <button type="submit" class="btn btn-primary">New Search</button>
                    </form>
                </div>
                <div class="col">
                    <a href="/dashboard">Dashboard</a>
                </div>
            </div>
            <div class="row my-2">
                <table class="table table-bordered table-striped">
                    <thead>
                        <th>Name</th>
                        <th>Rating</th>
                        <th>Actions</th>
                    </thead>
                    <tbody>
                    	<c:forEach items="${songs}" var="song">
                    		<tr>
	                            <td><a href="/lookify/${song.id}"><c:out value="${song.title}" /></a></td>
	                            <td><c:out value="${song.rating}"/></td>
	                            <td>
	                                <form action="/lookify/${song.id}" method="POST">
	                            		<input type="hidden" name="_method" value="delete">
	                            		<button type="submit" class="btn btn-link">Delete</button>
	                            	</form>
	                            </td>
	                        </tr>
                    	</c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
</body>
</html>

