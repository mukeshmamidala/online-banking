
//All UserPage operation are here

$("#home").click(function(e){
	
	makeAjaxCall("userHome.jsp", "#mainContent", "POST", "");
});

$("#accountStatement").click(function(e){
	makeAjaxCall("userController?page=userAccount.jsp", "#mainContent", "POST", "");
});

$("#miniStatement").click(function(e){
	makeAjaxCall("userController?page=userMiniStatement.jsp", "#mainContent", "POST", "");
});

$("#transferMoney").click(function(e){
	makeAjaxCall("userController?page=moneyTransfer.jsp", "#mainContent", "POST", "");
});

$("#billPay").click(function(e){
	makeAjaxCall("userController?page=billPay.jsp", "#mainContent", "POST", "");
});

$("#balance").click(function(e){
	makeAjaxCall("userController?page=getBalance", "#mainContent", "POST", "");
});


$("#trnsferBtn").click(function(e){
	e.preventDefault();
	
	var userId=$("#userId").val();
	var amt=$("#amt").val();
	
	if(userId=="" ||amt =="" ){
		$("#errLbl").text("All fields are mandatory can't be blank.");
		$("#errLbl").style.color = "red";
		return;
	}else{
		var data="userId="+userId+"&amount="+amt;
		makeAjaxCall("userController?page=transferMoney", "#mainContent", "POST", data);
	}
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