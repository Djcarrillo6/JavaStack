<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
 
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<title>New Question</title>
</head>
<body>
	<form:form>
	  <div class="form-group">
	    <label for="Questions">Question:</label>
	    <textarea class="form-control" id="exampleFormControlTextarea1" rows="5"></textarea>
	  </div>
	  
	  <div class="form-group">
	    <label for="Tags">Tags:</label>
	    <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Enter Tag(s)">
	  </div>
	</form:form>
</body>
</html>