package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Employee {
	
	
		
	//A common method to connect to the DB
	//A common method to connect to the DB
	private Connection connect(){
		Connection con = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");

	//Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/buyer2", "root", "chathu1998");
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return con;
	}
			
		
		
		//Insert Project Details--------------------------------
	
			public String insertEmployee(String employeeID, String employeeName, String employeeType, String email,String description, String phoneNumber){
			String output = "";
			try{
				Connection con = connect();
					if (con == null){
						return "Error while connecting to the database for inserting."; 
				}
				
					
		// create a prepared statement
			String query = "INSERT INTO `employee`(`employeeID`, `employeeName`, `employeeType`, `email`, `description`,`phoneNumber`) VALUES (?,?,?,?,?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
					
					
					 // binding values
					 preparedStmt.setInt(1, 0);
					 preparedStmt.setString(2, employeeName);
					 preparedStmt.setString(3, employeeType);
					 preparedStmt.setString(4, email);
					 preparedStmt.setString(5, description); 
					 preparedStmt.setString(6, phoneNumber);
					 
					 // execute the statement
					 preparedStmt.execute();
					 con.close();
					 
					 String newEmployee = readEmployee(); 
					 output = "{\"status\":\"success\", \"data\": \"" + newEmployee + "\"}";
					 
					 }catch (Exception e)
					 {
						 
						 output = "{\"status\":\"error\", \"data\":\"Error while inserting the employee to system.\"}"; 
						 System.err.println(e.getMessage());
					 }
			 		return output;
		 }
		
		
		
			public String readEmployee(){
				String output = "";
			try{
				Connection con = connect();
					if (con == null){
						return "Error while connecting to the database for reading."; 
			}
					
			// Prepare the html table to be displayed
				output = 
						"<table border='1' class='table table-info table-bordered table-striped table-hover table-warning' >"+ 
						"<tr >" +
							 "<th >Employee Name</th>" +
							 "<th >Employee Type</th>" +
							 "<th>Email</th>" +
							 "<th>Description</th>" +
							 "<th>Phone Number</th>" +
							 "<th>Update</th>" +
							 "<th>Remove</th>" +
						
						 "</tr>";
	
				String query = "select * from `employee`";
				 Statement stmt = con.createStatement();
				 ResultSet rs = stmt.executeQuery(query);
				 
				 
			// iterate through the rows in the result set
				 while (rs.next()){
					 
					 
					 String employeeId =  Integer.toString(rs.getInt("employeeId"));
					 String employeeName = rs.getString("employeeName");
					 String employeeType = rs.getString("employeeType");
					 String email = rs.getString("email");
					 String description = rs.getString("description");
					 String phoneNumber = rs.getString("phoneNumber");
	
					 
				// Add into the html table
					 
					 //output += "<tr><td>" + employeeId + "</td>";
					 output += "<td>" + employeeName + "</td>";
					 output += "<td>" + employeeType + "</td>";
					 output += "<td>" + email + "</td>";
					 output += "<td>" + description + "</td>";
					 output += "<td>" + phoneNumber + "</td>";
		
					 
					 
					 // buttons
					
					 output += "<td><input name='btnUpdate' type='button' value='Update' "
								+ "class='btnUpdate btn btn-secondary' data-userid='" + employeeId + "'></td>"
								+ "<td><input name='btnRemove' type='button' value='Remove' "
								+ "class='btnRemove btn btn-danger' data-userid='" + employeeId + "'></td></tr>"; 
				 }
			 con.close();
			 
		 // Complete the html table
			 output += "</table>";
			 
			 
			 }catch (Exception e){
				 
				 output = "Error while reading the employees.";
				 System.err.println(e.getMessage());
			 }
			 return output;
			 
		}
		
		//Update Details-------------------------------------
		
		public String updateEmployee(String employeeId, String employeeName, String employeeType, String email,String description,String phoneNumber){ 
			String output = ""; 
			try{
				Connection con = connect();
				if (con == null){
					return "Error while connecting to the database for updating."; 
				} 
				
				 // create a prepared statement
				String query = "UPDATE `employee` SET `employeeName`=?,`employeeType`=?,`email`=?,`description`=?,`phoneNumber`=? WHERE `employeeId`=?";
				 PreparedStatement preparedStmt = con.prepareStatement(query); 
				 
				 // binding values
				  
				 preparedStmt.setString(1, employeeName);
				 preparedStmt.setString(2, employeeType);
				 preparedStmt.setString(3, email);
				 preparedStmt.setString(4, description);
				 preparedStmt.setString(5, phoneNumber);
				 preparedStmt.setString(6, employeeId);
				 
				// preparedStmt.setString(4, sector);
				
				 
 
				 
				 // execute the statement
				 preparedStmt.execute(); 
				 con.close(); 
				 
				 String newEmployee = readEmployee(); 
				 output = "{\"status\":\"success\", \"data\": \"" + newEmployee + "\"}";
				 
		
				 } catch (Exception e) {
					 
					 output = "{\"status\":\"error\", \"data\": \"Error while updating the employee.\"}";
					 System.err.println(e.getMessage()); 
				 } 
				 return output; 
		 }
		
		//Delete details--------------------------

		public String deleteEmployee(String employeeId) { 
			String output = ""; 
			try{ 
				Connection con = connect();
				if (con == null) { 
					return "Error while connecting to the database for deleting."; 
				} 
					// create a prepared statement
				    String query ="DELETE FROM `employee` WHERE employeeId=?";
					PreparedStatement preparedStmt = con.prepareStatement(query); 
					
					// binding values
					preparedStmt.setInt(1, Integer.parseInt(employeeId)); 
					
					// execute the statement
					preparedStmt.execute(); 
					con.close(); 
					
					String newEmployee = readEmployee(); 
					output = "{\"status\":\"success\", \"data\": \"" + newEmployee + "\"}"; 
					
			} catch (Exception e) { 
				output = "{\"status\":\"error\", \"data\": \"Error while deleting the employee.\"}"; 
				System.err.println(e.getMessage()); 
			} 
			return output; 
		}
		
}