<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
 
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Create a ninja!</h1>

	<form:form action="/createNinja" method="POST" modelAttribute="ninja">
		<div>
			<p>First Name:</p>
			<form:label path="firstName"></form:label>
			<form:errors path="firstName"></form:errors>
			<form:input path="firstName"></form:input>
		</div>
		<div>
			<p>Last Name:</p>
			<form:label path="lastName"></form:label>
			<form:errors path="lastName"></form:errors>
			<form:input path="lastName"></form:input>
		</div>
		<div>
			<p>Age:</p>
			<form:label path="age"></form:label>
			<form:errors path="age"></form:errors>
			<form:input path="age"></form:input>
		</div>
		
		<div>
			<p>Dojo:</p>
			<form:label path="dojo"></form:label>
			<form:errors path="dojo"></form:errors>
			<form:select path="dojo">
				<option value="" disabled selected>Select a team!</option>
				<c:forEach items="${dojos}" var="dojo">
					<form:option value="${dojo}">
						<c:out value="${dojo.name}"></c:out>
					</form:option>
				</c:forEach>
			</form:select>
		</div>
		
		<div>
			<input type="submit" value="Create a ninja!" />
		</div>
	
	</form:form>
		
</body>
</html>