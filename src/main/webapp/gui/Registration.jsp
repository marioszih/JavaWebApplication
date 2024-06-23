<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
		<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
		<meta charset="UTF-8">
		<script>
			window.onload = function() {
		        var form = document.getElementById('registrationForm');
		
		        form.onsubmit = function() {
		            alert("Your registration has been submitted!");
		            return true;
		        }
		    }
		</script>

		<title>Registration Page</title>
		<style>
		</style>
	</head>
	<body>
		<form id="registrationForm" action="<%= request.getContextPath() %>/register" method = "post">
		  <div align = "center">
		    <h1>Register</h1>
		    <p>Please fill in this form to create an account.</p>
		    <table>
			    <tr>
				    <th><label for="name"><b>Your first name</b></label></th>
				    <th><input type="text" placeholder="Enter your first name" name="name" id="name" required></th>
			    </tr>
				<tr>
				    <th><label for="surname"><b>Your Surname</b></label></th>
				  	<th><input type="text" placeholder="Enter your surname" name="surname" id="surname" required></th>
				</tr>
				<tr>
				    <th><label for="gender"><b>Choose you gender:</b></label></th>
					<td>
						<select name="gender" id="gender" required> 
							<option value="Male">Male</option>
					  		<option value="Female">Female</option>
						</select>
					</td> 
			    </tr>
			    <tr>
			    	<th><label for="birthday"><b>Choose you birth day:</b></label></th>
			    	<th><input data-provide="datepicker" data-date-format="dd/mm/yyyy" name="date" id="date" required></th>
			    </tr>
			    <tr>
				    <th><label for="workAddress"><b>Your work address</b></label></th>
				    <th><textarea placeholder="Enter your work address" name="workAddress" id="workAddress" rows=1 required></textarea></th>
				</tr>
				<tr>
				    <th><label for="homeAddress"><b>Your home address</b></label></th>
				  	<th><textarea placeholder="Enter your home address" name="homeAddress" id="homeAddress" rows=1 required></textarea></th>
				</tr>
		    </table>
		    <button class="btn btn-primary" type="submit">Register</button>
		   	<a class="btn btn-danger" href="/JavaWebApp" role="button">Cancel</a>
		  </div>
		</form>
		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"></script>
	</body>
</html>