<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title> Customer </title>
<link rel="stylesheet" type="text/css" href="todo.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<SCRIPT type="text/javascript">
    function noBack() { window.history.forward(); }   
	</SCRIPT>
</head>

<%
if(session!=null && (session.getAttribute("sessionname")!=null)){
%>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="">
	<center><h1> Customer </h1></center>
	<button id="butn" onclick="location.href='/Logout';">Logout</button>
<div class="custlist">
	<center><h3> Customer list </h3></center>	
<center>  <button id="addbtn"> Add Customer: </button> </center> 
<div id="popuplayout" class="popup"> 
	<form id="pop" onsubmit="return create()" action="javascript:void(0);" method="post"> 
		<input name="cusname" id="name1" type="text" placeholder="name" style="margin-top: 15px" required > </br>
        <input name="number" id="num1" type="text" placeholder="Phone" required > </br>
        <input name="email"  id="email1" type= "text" placeholder="Email" required > <br> 
        <input name="address"  id="address1" type="text" placeholder="Address" required> <br>
        <center><input type="submit"></center>
       </form>
</div>

<p id="p1"> </p>
 <ul classname="uli" id="ulist" style="list-style-type:none">
 	
 </ul>
</div>
<div class="details">
<center> <h3> Details </h3> </center>
<form id="customer-details" action="javascript:void(0);">
<br>
  <label class="lab"> Name: </label> <input id="name2" type="text" placeholder="name"> <br> 
  <label class="lab"> Phone number : </label> <input id="num2" type="text"  placeholder="Phone" > <br>
  <label class="lab"> Email : </label> <input id="email2" type= "text" placeholder="Email"> <br>
  <label class="lab"> Address: </label> <input id="address2" type="text" placeholder="Address"> <br>
 <br>
 <center><button onclick="updateForm()"> Update </button></center>

</form>
</div>
<div class="todo">
	<center><h3> Todo list </h3> </center>
	<center><input type="text" id="add1"><button onclick="addTodo()"> Add </button></center>
	<ul id="ulist2" style="list-style-type:none">
   
    </ul>

</div>
<script src="custpage.js"></script>

</body>
</html>
<% 
}
else{ response.sendRedirect("index.jsp");
}
%>