<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
 
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<title>Top 10 Rated Songs on Lookify!</title>
</head>
<body>


	<div id="header"
		style="display:flex;
		flex-direction: row;
		justify-content: space-around;
		padding-bottom: 5rem;

		
		"
	>
		<h1 style="color:gold; font-weight: bold;" >Top Ten Songs:</h1>
		<a href="/dashboard">Dashboard</a>
	</div>
	
	 <div class="container">
            <div class="row my-2 justify-content-between">
                <div class="col-6">
                    <h3>Top Ten Songs</h3>
                </div>

            </div>
            <div class="row my-2">
                <div class="col-6 border border-dark p-3">
                	<c:forEach items="${songs}" var="song">
                		<div class="row m-2">
	                        ${song.rating} 
	                        
	                        - 
	                        
	                        <a href="/songs/${song.id}">
	                        
	                        	${song.title}
	                        	
	                        </a> 
	                        
	                        - 
	                        
	                        ${song.artist}
	                        
	                        
	                    </div>
                	</c:forEach>
                </div>
            </div>
        </div>

</body>
</html>