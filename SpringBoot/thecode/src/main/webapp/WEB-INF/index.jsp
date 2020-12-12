<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

 
<title>Secret Code Game</title>
</head>
<body>			
	
	<div style="display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
	margin-top: 20rem;
	">
		<p style="color: red; font-weight:bold;"> <c:out value="${error}" /> </p>
		<h2 style="brown; font-weight:bold;">What is the code?</h2>
		
		<form style="margin-top:3rem;" method="POST" action="/code">
		    <input type="text" name="code">
		    <button>Submit</button>
		</form>
		
		
    </div>
    
    
	
</body>
</html>