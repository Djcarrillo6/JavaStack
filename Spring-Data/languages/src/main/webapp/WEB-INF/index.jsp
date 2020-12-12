<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
 
<!DOCTYPE html>

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


<title>Languages</title>
</head>
<body>
	<div class="container">
		<div class="row my-2">
		<!-- table to show all languages -->
			<table class="table table-bordered">
				<thead>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Action</th>
                 </thead>
                 <tbody>
                 	<!-- //begin of forEach language in languages -->
                 	<c:forEach items="${languages}" var="language">
                 		<tr>
				            <td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
            				<td><c:out value="${language.creator}"/></td>
            				<td><c:out value="${language.version}"/></td>
                 			<td>
                 				<div class="row">
                 					
                 					<form:form action="/languages/${language.id}" method="POST">
                 						<input type="hidden" name="_method" value="delete">
                 						<input class="btn btn-link" type="submit" value="Delete" />
                 					</form:form>
                 					
                 					<a href="/languages/${language.id}/edit">Edit</a>
	                            </div>
	                        </td>
	                     </tr>
	                    
	                </c:forEach>
	              </tbody>
              </table>
         </div>
         
         <form:form action="/languages" method="POST" modelAttribute="language">
                <div class="row my-2">
                    <form:label path="name" class="col-5">Name</form:label>
                    <form:input path="name" class="col-5" type="text"/>
                    <form:errors path="name" class="col-2 text-danger"/>
                </div>
                <div class="row my-2">
                    <form:label path="creator" class="col-5">Creator</form:label>
                    <form:input path="creator" class="col-5" type="text" name="creator"/>
                    <form:errors path="creator" class="col-2 text-danger"/>
                </div>
                <div class="row my-2">
                    <form:label path="version" class="col-5">Version</form:label>
                    <form:input path="version" class="col-5" type="text" name="version"/>
                    <form:errors path="version" class="col-2 text-danger"/>
                </div>
                <div class="row my-2 d-flex justify-content-around">
                    <button class="btn btn-outline-secondary" type="submit">Submit</button>
                </div>
          </form:form>
	</div>
</body>
</html>