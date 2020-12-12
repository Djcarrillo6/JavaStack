<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

</head>


<body>
	
	<div style="display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
	margin-top: 20rem;
	">

		
		<form style="display: flex; flex-direction:column;"  method="POST" action="/form">
		    <label>Your Name: <input type="text" name="name"></label>
		    <label style="margin-top: 3rem;">Dojo Location: </label>
		    <select name="location">

				<option>Orange County</option>
				
				<option>San Jose</option>
				
				<option>Burbank</option>
				
				<option>Boise</option>
				
			</select>
			
			<label style="margin-top: 3rem;">Favorite Language: </label>
		    <select name="language">

				<option>Python</option>
				
				<option>C#</option>
				
				<option>MERN</option>
				
				<option>Java</option>
				
			</select>
		  
			<label style="margin-top: 3rem;" for="comment">Leave A Comment:</label>

			<textarea id="comment" name="comment" rows="4" cols="50">
					
			</textarea>
		  
		    <button style="background-color: turquoise" >Submit</button>
		</form>
    </div>
</body>


</html>