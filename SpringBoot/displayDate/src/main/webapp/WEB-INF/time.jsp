<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/time.css">
<title>Insert title here</title>
</head>

<body>
		<div id="display" >
        <h1> <c:out value="${time}"/> </h1>
        </div>
        
    	<script type="text/javascript" src="js/time.js"></script>
</body>
</html>