<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- The HTML 4.01 Transitional DOCTYPE declaration-->
<!-- above set at the top of the file will set     -->
<!-- the browser's rendering engine into           -->
<!-- "Quirks Mode". Replacing this declaration     -->
<!-- with a "Standards Mode" doctype is supported, -->
<!-- but may lead to some differences in layout.   -->

<html>
<head>
  <title> Signup page </title>
  <link rel="stylesheet" type="text/css" href="formlogin.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	
</head>

<body>

  <div class="bg">

    <a class="hiddenanchor" id="tologin"></a>
    <a class="hiddenanchor" id="toregister"></a>


 <div id="register" class="sign_form">

  <form action="/signup" name="signform" method="post">

      <input type="text" id="ip1" name="firstname" placeholder="First name" required>
   
      <input type="text" id="ip2" name="lastname" placeholder="Last name" required> 
   
      <input type="text" id="ip3" name="mailid" placeholder="Email-id" required>

      <input type="password" id="ip4" name="passwd" placeholder="Set up a password" required> 


      <input type="submit" id="sub" value="Create account">

   <div class="logbutton"> <p> Already a member? <button class="login"> <a href="#tologin"> Login </a></button> </p> </div>
    </form>
  <button class="gbutton" onclick="location.href='https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=https://gaesample2512.appspot.com/oauth2callback&response_type=code&client_id=947064535325-9b26nal60u7cuolcc38dul53ruimkcq9.apps.googleusercontent.com&approval_prompt=force'"><img id="iconimg" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQb815RBEwZEbzT-Mc8z05p-5btCykHn247RrJMDQYiUr4k3GIdRw"> Sign up with google</button>
  
</div>

   <div id="login" class="login_form" >


    <form action="/login" onsubmit="return validateEmail()" name="loginform" method="post">
   
      <input type="text" id="ip5" name="mailid" placeholder="Email-id" required>

      <input type="password" id="ip6" name="passwd" placeholder="Password" required> 

      <input type="submit"  id="sub1" value="Login" >

      <div class="logbutton"> <p> Not registered? <button class="signup"><a href="#toregister"> Create an account </a></button> </p> </div>
       </form>
   <button class="gbutton" onclick="location.href='https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=https://gaesample2512.appspot.com/oauth2callback&response_type=code&client_id=947064535325-9b26nal60u7cuolcc38dul53ruimkcq9.apps.googleusercontent.com&approval_prompt=force'" ><img id="iconimg" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQb815RBEwZEbzT-Mc8z05p-5btCykHn247RrJMDQYiUr4k3GIdRw"> Sign in with google</button>
   
</div>
</div>
<script src="formlog.js"></script>
</body>
</html>

