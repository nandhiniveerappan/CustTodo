var logmailid=document.getElementById("ip5");
var logpwd=document.getElementById("ip6");
var mailformat=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  

$('.sign_form').hide();
$('.login_form').show();


$('.signup').click(function(){

document.getElementById("ip5").value = "";
document.getElementById("ip6").innerHTML="";

$('.login_form').hide();
$('.sign_form').show();
});

$('.login').click(function(){
document.getElementById("ip1").innerHTML="";
document.getElementById("ip2").innerHTML="";
document.getElementById("ip3").innerHTML="";
document.getElementById("ip4").innerHTML="";
$('.sign_form').hide();
$('.login_form').show();
});

function validateEmail() {
		if(!(logmailid.value.match(mailformat)))  
		{ 
			window.alert("Please enter a valid email address");
			return false;
		}
	}

