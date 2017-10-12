/*$('.message a').click(function(){
   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});
*/

function validation()
{
	if($("#username").val()==""){
		$("#errLbl").text("Register mobile field can't be blank.");
		return;
	}
	if($("#userpwd").val()==""){
		$("#errLbl").text("User password can't be blank.");
		return;
	}
	
	$('#loginForm').submit();
		
}



$("#chngPass").click(function(e){
	e.preventDefault();
	
	
});


function check()
{

    var pass1 = document.getElementById('mobile');
    var message = document.getElementById('errLbl');

   var goodColor = "Green";
    var badColor = 'red';

    if(mobile.value.length!=10){

    	//username.style.backgroundColor = badColor;
        message.style.color = badColor;
        message.innerHTML = "Required 10 digits, match requested format!";
    }
    if(mobile.value.length==0){
    	
        message.innerHTML = "";
   }
  if(mobile.value.length==10){
	  message.style.color = goodColor;
        message.innerHTML = "Correct";
   }
    
    if(mobile.value.length>10){
    	 message.style.color = badColor;
         message.innerHTML = "More than 10 digits!";
    }

}
