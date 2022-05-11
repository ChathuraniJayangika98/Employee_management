<%@ page import="com.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.6.0.min.js"></script>
<script src="Components/User.js"></script>


<meta charset="ISO-8859-1">
<title>Employee Management</title>
</head>
<body>

<div class="container"><div class="row"><div class="col-6">
<h1>Employee Management</h1>

	<form id="formItem" name="formItem">
		
		 Employee Name:
		<input id="employeeName" name="employeeName" type="text" class="form-control form-control-sm"><br> 
		Email Address:
		<input id="email" name="email" type="text" class="form-control form-control-sm"><br>
		 Phone Number:
		<input id="phoneNumber" name="phoneNumber" type="text" class="form-control form-control-sm"><br>
		 
		<label>employeeType</label> 
							<select id="employeeType" name="employeeType" class="form-control form-control-sm">
							<option value="1">Meeter Reader</option>
							<option value="2">Maintainer</option>
							
							</select><br>
							
		Description:
		<input id="description" name="description" type="text" class="form-control form-control-sm"><br>				
							
		 
		
		<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
		<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
	</form>
	
	<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>
	<br>
	<div id="divItemGrid">
	<%
	User CartObj = new User(); 
	 out.print(CartObj.readCart()); 
	%>
	</div>
</div> </div> </div> 
	
</body>
</html>