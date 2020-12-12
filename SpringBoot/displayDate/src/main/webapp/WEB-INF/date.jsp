<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" type="text/css" href="css/date.css">
<title>Date</title>
</head>

<body>
		<div id="display" >
        <h1><c:out value="${date}"/></h1>
        </div>
    	<script type="text/javascript" src="js/date.js"></script>
</body>
</html>