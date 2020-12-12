<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

<title>Visit Counter</title>
</head>
<body>
	
  			<div style="display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
	margin-top: 20rem;">
    			<h3 style="margin-right:5rem;" >You have visited <a href="http://localhost:8080">http://local:8080</a> <c:out value="${count}"/> Times</h3>
    			<p style ="color:purple; font-weight:bold; margin-right:5rem;"><a href="http://localhost:8080">Test another visit?</a></p>
    			<a style="color:red; font-weight:bold;" href="/reset">Reset</a>
 			 </div>
</body>
</html>
