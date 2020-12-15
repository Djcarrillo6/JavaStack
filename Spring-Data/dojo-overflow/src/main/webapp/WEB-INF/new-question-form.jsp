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
	<form:form action="/submit-question" method="POST" modelAttribute="question">
	  <div style="width: 80%;
    			margin-left: 10rem;" 
    			class="form-group">
	    <form:label path="text" for="Question">Question:</form:label>
	    <form:input path="text" class="form-control" id="exampleFormControlTextarea1" rows="5"></form:input>
	    <form:errors path="text"></form:errors>
	  </div>
	  

		  <div style="width: 60%;
	    			margin-left: 10rem;" class="form-group">
		    <form:label path="${tag.getSubject()}" for="Tag">Tags:</form:label>
		    <form:input path="${tag.getSubject()}" type="text" class="form-control" id="exampleFormControlInput1"></form:input>
		     <form:errors path="${tag.getSubject()}"></form:errors>
		  </div>
	  

	   <div style="display: flex;
    flex-direction: row-reverse;
    margin-right: 14rem;
    margin-top: 5rem;
    	">

    
			<input style="background-color:green;"  type="submit" value="Submit"/>
		</div>
	</form:form>
</body>
</html>