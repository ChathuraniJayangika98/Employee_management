$(document).on("click", "#btnSave", function(event){ 
	
	// Clear alerts---------------------
	 $("#alertSuccess").text(""); 
	 $("#alertSuccess").hide(); 
	 $("#alertError").text(""); 
	 $("#alertError").hide(); 
 
	 
	// Form validation-------------------
	var status = validateItemForm(); 
	if (status != true) 
	 { 
	 $("#alertError").text(status); 
	 $("#alertError").show(); 
	 
 	return; 
} 


	// If valid------------------------
	var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT"; 
	$.ajax( 
	{ 
	 	url : "EmployeeAPI", 
	 	type : type, 
	 	data : $("#formItem").serialize(), 
	 	dataType : "text", 
	 	complete : function(response, status) { 
		 
		onItemSaveComplete(response.responseText, status); 
	 } 
	}); 
});

	function onItemSaveComplete(response, status){ 
	if (status == "success") {
		
		 var resultSet = JSON.parse(response); 
		 if (resultSet.status.trim() == "success") { 
			 
			 $("#alertSuccess").text("Successfully saved."); 
			 $("#alertSuccess").show(); 
			 $("#divItemsGrid").html(resultSet.data); 
		 } 
		 else if (resultSet.status.trim() == "error") {
			 
			 $("#alertError").text(resultSet.data); 
			 $("#alertError").show(); 
		 } 
	} 
		else if (status == "error") { 
		
		 $("#alertError").text("Error while saving."); 
		 $("#alertError").show(); 
	} 	else{ 
		
		 $("#alertError").text("Unknown error while saving.."); 
		 $("#alertError").show(); 
		}
		$("#hidItemIDSave").val(""); 
		$("#formItem")[0].reset(); 
	}


		// UPDATE------------------------------------
		$(document).on("click", ".btnUpdate", function(event){ 
		
		 $("#hidItemIDSave").val($(this).data("userid")); 
		 $("#employeeName").val($(this).closest("tr").find('td:eq(0)').text()); 
		 $("#employeetype").val($(this).closest("tr").find('td:eq(1)').text()); 
		 $("#email").val($(this).closest("tr").find('td:eq(2)').text()); 
		 $("#description").val($(this).closest("tr").find('td:eq(3)').text()); 
		 $("#phoneNumber").val($(this).closest("tr").find('td:eq(4)').text());  
		 
		
		 
		});





		$(document).on("click", ".btnRemove", function(event) { 
		 $.ajax( 
	 	{ 
	 		url : "EmployeeAPI", 
	 		type : "DELETE", 
	 		data : "employeeId=" + $(this).data("userid"),
	 		dataType : "text", 
	 		complete : function(response, status) { 
	 		onItemDeleteComplete(response.responseText, status); 
	 	} 
	}); 
})
	

	//Delete------------------------------------
	
	function onItemDeleteComplete(response, status){
	
	if (status == "success") {
		
		var resultSet = JSON.parse(response); 
			if (resultSet.status.trim() == "success"){
			
				$("#alertSuccess").text("Successfully deleted."); 
				$("#alertSuccess").show(); 
				$("#divItemsGrid").html(resultSet.data); 
				
			} else if (resultSet.status.trim() == "error") { 
				
				$("#alertError").text(resultSet.data); 
				$("#alertError").show(); 
		} 
	} 
			else if (status == "error") { 
				$("#alertError").text("Error while deleting."); 
				$("#alertError").show(); 
		} 
			else { 
				$("#alertError").text("Unknown error while deleting.."); 
				$("#alertError").show(); 
		} 

	}

	// CLIENT-MODEL

	function validateItemForm(){
	// CODE

	//Employee Type---------------------------
	if ($("#employeeType").val().trim() == "")
	{
		return "Insert Employee Type.";
	} 

	//Email------------------------------
	if ($("#email").val().trim() == "")
	{
		return "Insert Email.";
	}

	//Description------------------------------
	if ($("#description").val().trim() == "")
	{	
		return "Insert Description.";
	}

	//Phone Number-------------------------------
	if ($("#phoneNumber").val().trim() == "")
	{
		return "Insert Phone Number.";
	}
	
 	return true;
}

