<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<html>
<head>

</head>


<body>
	<div style="display: flex; flex-direction: row;" >
		<div>
			<form action="/" method="POST">
                <h3>Farm</h3>
                <p>(Earn 10-20 Gold)</p>
                
                <input name="farm" type="submit" value="Find Gold!" />
            </form>
         </div>
         
         		<div>
			<form action="/" method="POST">
                <h3>Cave</h3>
                <p>(Earn 10-20 Gold)</p>
                
               <input name="cave" type="submit" value="Find Gold!" />
            </form>
         </div>
         
         <h1>Gold: <c:out value="${gold}" /> </h1>
         
         
         
	</div>
	
	<div id="activities" >
         
         <c:forEach var="activity" items="${ activities } " >
         
         	
         		<h3 > ${actvity.color} </h3>
         	
         </c:forEach>
         
        	
         
         </div>
</body>


</html>