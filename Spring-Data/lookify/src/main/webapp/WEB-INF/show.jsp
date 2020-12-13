<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
 
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Lookify!</title>

<body>

	 
	 <div class="container">
            <div class="row my-2 justify-content-end">
                <div class="col-1">
                    <a href="/dashboard">Dashboard</a>
                </div>
            </div>
            <div class="row my-2">
                <div class="col-5"><h1>Title:<c:out value="${song.title}"/></h1></div>
            </div>
            <div class="row my-2">
                <div class="col-5">Artist: <c:out value="${song.artist}"/></div>
            </div>
            <div class="row my-2">
                <div class="col-5">Rating(1-10):<c:out value="${song.rating}"/></div>
            </div>

        </div>
        
        <form:form action="/songs/${s.id}" method="POST" 
        style="display:block;
		margin-left: 45rem;
		">
                		<input type="hidden" name="_method" value="delete">
                		<input class="btn btn-link" type="submit" value="Delete">
        </form:form>

</body>
</html>