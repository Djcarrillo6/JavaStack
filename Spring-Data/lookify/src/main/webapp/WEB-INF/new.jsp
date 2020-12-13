<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
 
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Add New Song</title>
</head>
<body>

	<a href="/dashboard"
	style="display:block;
	margin-left: 45rem;
	"
	 >Dashboard</a>
	

		<form:form  method = "POST" action = "/addSong" modelAttribute = "song">
		
			<h3 style="color:green;" >Add New Song Form</h3>
			
			<div>
			<p>Title</p>
			<form:label path="title"></form:label>
			<form:errors path="title"></form:errors>
			<form:input path="title"></form:input>
		</div>
		<div>
			<p>Artist</p>
			<form:label path="artist"></form:label>
			<form:errors path="artist"></form:errors>
			<form:input path="artist"></form:input>
		</div>
		
		<div>
			<p>Rating (1 - 10)</p>
			<form:label path="rating"></form:label>
			<form:errors path="rating"></form:errors>
			<form:select path="rating">
				<option value="" disabled selected>Select a rating!</option>
					<form:option value="1" label="1"/>
					<form:option value="2" label="2"/>
					<form:option value="3" label="3"/>
					<form:option value="4" label="4"/>
					<form:option value="5" label="5"/>
					<form:option value="6" label="6"/>
					<form:option value="7" label="7"/>
					<form:option value="8" label="8"/>
					<form:option value="9" label="9"/>
					<form:option value="10" label="10"/>
			</form:select>
		</div>
		
		<div>
			<input type="submit" value="Add a song!!" />
		</div>
		
		</form:form>

	
</body>
</html>