<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:out value="${language.name}"/> </title>
</head>
<body>
	<a href="/languages">Dashboard</a>
	<h1>New Language</h1>
	<form:form action="/languages" method="post" modelAttribute="language">
		<p>
			<form:label path="name">Name</form:label>
			<form:errors path="name"/>
			<form:input path="name"/>
		</p>
		<p>
			<form:label path="creator">Creator</form:label>
			<form:errors path="creator"/>
			<form:input path="creator"/>
		</p>
		<p>
			<form:label path="version">Version</form:label>
			<form:errors path="version"/>
			<form:input path="version"/>
		</p>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>