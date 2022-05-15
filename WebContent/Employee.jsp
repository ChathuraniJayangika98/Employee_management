<%@ page import="com.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.6.0.min.js"></script>
<script src="Components/Employee.js"></script>
<meta charset="ISO-8859-1">

<!-- new CSS JS Import -->

<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/bootstrap.css">
<script src="js/bootstrap.js"></script>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style.css">

<!-- new CSS JS Import end -->

<title>Employee Management</title>
</head>
<body>

	<!-- form container -->

	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Employee Management</h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-12 col-lg-10">
					<div class="wrap d-md-flex">
						<div class="img" style="background-image: url(images/image3.jpg);">
						</div>
						<div class="login-wrap p-4 p-md-5">
							<div class="d-flex">
								<div class="w-100">
									<h3 class="mb-4">Employee Details</h3>
								</div>
								
							</div>
							
							<form id="formItem" name="formItem" class="signin-form">
							
								<div class="form-group mb-3">
									<label class="label" for="name">Employee Name</label> <input
										id="employeeName" name="employeeName" type="text" class="form-control"
										placeholder="employeeName" required>
										
										
								</div>
								
								<div class="form-group mb-3">
									<label class="label" for="name">Employee Type</label> <select
										id="employeeType" type="text" name="employeeType" class="form-control"
										placeholder="Employee Type" required >
										<option value="Meter Reader">Meter Reader</option>
										<option value="Maintainer">Maintainer</option>
										
										</select>
								</div>
								<div class="form-group mb-3">
									<label class="label" for="name">Email Address</label> <input
										id="email" type="text" name="email" class="form-control"
										placeholder="email" required>
								</div>
								<div class="form-group mb-3">
									<label class="label" for="name">Description</label> <input
										id="description" type="text" name="description" class="form-control"
										placeholder="description" required>
								</div>
								<div class="form-group mb-3">
									<label class="label" for="name">Phone Number</label> <input
										id="phoneNumber" type="text" name="phoneNumber" class="form-control"
										placeholder="phoneNumber" required>
								</div>
								
								<div class="form-group">
								
								<input id="btnSave" name="btnSave" type="button" value="Save"
									class="form-control btn btn-primary rounded submit px-3"> 
								<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
								</div>
								
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- form container End-->
	<div class="container">
		<div class="row">
			<div>
				<h1 style= "text-align:center">Employee Management</h1>
				

			

				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>
				<br>
				<div id="divItemGrid">
					<%
					Employee EmployeeObj = new Employee(); 
					out.print(EmployeeObj.readEmployee());
					%>
				</div>
			</div>
		</div>
	</div>

	<!-- script -->

	<script src="js/jquery.min.js"></script>
	<script src="js/popper.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/main.js"></script>

	<!-- script End-->

</body>
</html>



