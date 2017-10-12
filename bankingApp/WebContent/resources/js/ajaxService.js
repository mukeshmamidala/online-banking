
$("#ca").click(function(){
    makeAjaxCall('createUser.jsp',"#mainContent");
});


$("#cc").click(function(e){
	makeAjaxCall("userController?page=getAllUser", "#mainContent", "POST", "");
});

$("#logOut").click(function(){
	$('#lo').submit();
});

$("#callDepositForm").click(function(){
    makeAjaxCall('deposit.jsp',"#mainContent");
});


//*** Role cashier Deposit Operation
$("#depositBtn").click(function(e){
	e.preventDefault();
	
	var userId=$("#userId").val();
	var amt=$("#amt").val();
	
	if(userId=="" ||amt =="" ){
		$("#errLbl").text("All fields are mandatory can't be blank.");
		$("#errLbl").style.color = "red";
		return;
	}else{
		var data="userId="+userId+"&amount="+amt;
		makeAjaxCall("bankOperationServlet?operation=deposit", "#mainContent", "POST", data);
	}
});




$("#registerUser").click(function(e){
	
	e.preventDefault();
	
	var mobile=$("#mobile").val();
	var username=$("#username").val();
	var role=$('select[name=role]').val();
	var pwd=$("#pwd").val();	
	
	if(mobile=="" || username=="" || role=="" || pwd==""){
		$("#errLbl").text("All fields are mandatory can't be blank.");
		$("#errLbl").style.color = "red";
		return;
	}
	
	var data="mobile="+mobile+"&username="+username+"&role="+role+"&pwd="+pwd;
	makeAjaxCall("registerUser", "#mainContent","POST",data);
});



function makeAjaxCall(url,id,method,data){
	
	if(method==undefined || method=="")
		method="GET";
	
	if(data==undefined || data==""){
		data="";
	}
	
	 $.ajax({
		 	type: method,
		 	url: url, 
		 	data:data,
		 	success: function(result){
	        $(id).html(result);
	    },
	    error: function(XMLHttpRequest, textStatus, errorThrown) { 
	        alert("Status: " + textStatus+" "+"Error: " + errorThrown);
	    }    
	    });
}





/*beforeSend: function() { textreplace(description); },
type: "POST",  
url: "updatedjob.php",
data: "jobID="+ job +"& description="+ description +"& startDate="+ startDate +"& releaseDate="+ releaseDate +"& status="+ status, 
success: function(){  
    $("form#updatejob").hide(function(){$("div.success").fadeIn();});  
},
error: function(XMLHttpRequest, textStatus, errorThrown) { 
    alert("Status: " + textStatus); alert("Error: " + errorThrown); 
}    */