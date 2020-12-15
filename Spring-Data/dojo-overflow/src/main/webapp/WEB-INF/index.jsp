<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %> 
<!-- needed for rendering date -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Dojo Overflow</title>
</head>


<body>

	<h1 style="margin-left: 45rem; margin-bottom: 5rem;" >Questions Dashboard</h1>

	 <div class="container">
            <div class="row my-2">
                <table class="table table-bordered table-striped">
                    <thead>
                        <th>Question</th>
                        <th>Tags</th>

                    </thead>
                    <tbody>
                    	<c:forEach items="${questions}" var="q">
                    	<c:forEach items="${tags}" var="t">
                    		<tr>
	                            <td><a href="/">${q.text}</a></td>
	                            <td>${t.subject}</td>
	                        </tr>
	                        </c:forEach>
                    	</c:forEach>
                    </tbody>
                </table>
            </div>
            
             <div style="display: flex;
    					flex-direction: row-reverse;">
                    <a href="/questions/new">New Question</a>
             </div>
        </div>
</body>
</html>