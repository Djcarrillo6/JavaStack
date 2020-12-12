<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

</head>


<body>
	
	<div>
		<h1>
			Submitted Info
		</h1>
	</div>
	
	<div id="card"  style="display: flex; justify-content:center; align-items: center; flex-direction:column" >
		<p>Name: 		<c:out value="${name}"/></p>
		<p>Dojo Location: 		<c:out value="${location}"/></p>
		<p>Favorite Language: 		<c:out value="${language}"/></p>
		<p>Comment: 		<c:out value="${comment}"/></p>
		
		
	</div>
	<button 
	style="
	margin-left: 68rem;
    margin-top: 5rem;
    background-color: turquoise" 
    onclick="location.href='http://localhost:8080'" 
    type="button">Go Back</button>

</body>


</html>