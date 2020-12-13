<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
 
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<title>Lookify Dashboard</title>
</head>
<body>
	<div id="header"
		style="display:flex;
		flex-direction: row;
		justify-content: space-around;
		padding-bottom: 5rem;

		
		"
	>
	
		<a href="/songs/new">Add New</a>
		<a href="/search/topTen">Top Songs</a>
		
	</div>
	 <div class="col-4">
                    <form action="/lookify/search/searchString" method="post">
	                    <input type="text" name="searchString">
	                    <button type="submit" class="btn btn-primary">Search Artists</button>
                    </form>
                </div>
	
	

	
		<table style="width:75%">
			  <tr >
			    <th>Title</th>
			    <th>Rating</th> 
			    <th>Actions</th>
			  </tr>
			  <c:forEach items="${songs}" var="s">
			  <tr>
			  
			    <td><a href="/song/${s.id}" ><c:out value="${s.title}"></c:out></a></td>
			    <td><c:out value="${s.rating}"></c:out></td>
			    <td>
			    	<form:form action="/songs/${s.id}" method="POST">
                		<input type="hidden" name="_method" value="delete">
                		<input class="btn btn-link" type="submit" value="Delete">
                	</form:form>
			    </td>
			    </c:forEach>
			  </tr>
			  
		</table>
		

	
	
	
</body>
</html>