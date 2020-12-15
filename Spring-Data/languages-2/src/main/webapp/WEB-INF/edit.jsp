<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${language.name}"/> Information</title>
</head>
<body>
        <div class="container">
            <div class="row my-2 justify-content-end">
                <div class="col-1">
                    <form:form action="/languages/${language.id}" method="DELETE">
                		<input type="hidden" name="_method" value="delete">
                		<input class="btn btn-link" type="submit" value="Delete">
                	</form:form>
                </div>
                <div class="col-1">
                    <a href="/languages">Dashboard</a>
                </div>
            </div>
            <form:form action="/languages/${language.id}" method="post" modelAttribute="language">
            	<input type="hidden" name="_method" value="put">
                <div class="row my-2">
                    <div class="col-5">Name</div>
                    <form:input path="name" type="text" name="name" value="${language.name}" class="col-5"/>
                    <form:errors path="name" class="col-2 text-danger"/>
                </div>
                <div class="row my-2">
                    <div class="col-5">Creator</div>
                    <form:input path="creator" type="text" name="creator" value="${language.creator }" class="col-5"/>
                    <form:errors path="creator" class="col-2 text-danger"/>
                </div>
                <div class="row my-2">
                    <div class="col-5">Version</div>
                    <form:input path="version" type="text" name="version" value="${language.version }" class="col-5"/>
                    <form:errors path="version" class="col-2 text-danger"/>
                </div>
                <div class="row justify-content-end">
                    <div class="col-1">
                        <Button type="submit" class="btn btn-primary text-end">Submit</Button>
                    </div>
                </div>
            </form:form>
        </div>
</body>
</html>