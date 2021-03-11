<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>Create Account</title>
</head>
<body>
<%
response.setHeader("Pragma","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Expires","0");
response.setDateHeader("Expires",-1);
String result=(String)session.getAttribute("result");
if(session.getAttribute("name")==null)
{
	response.sendRedirect("index.jsp");
}
%> 
    <header>
      <h1>Create Field Official's Account</h1>
    </header>
	<section class="container">
      <form id="my-form" action="FieldOfficial" method="post">
        <h1>Application Details</h1>
        <font color='blue' style='text-align:center'><b>${result}</b></font>
        <div class="msg"></div>
        <div>
          <label for="name">Field Official Name:</label>
          <input type="text" name="name" id="name">
        </div>
        <div>
          <label for="email">Email Id:</label>
		  <input type="text" name="email" id="email">
        </div>
        <div>
        <div>
          <label for="uname">User Name:</label>
          <input type="text" name="uname" id="uname">
        </div>
          <label for="password">Password:</label>
		 <input type="password" name="password" id="pass">
        </div>
        <div>
          <label for="cpassword">Confirm Password:</label>
		  <input type="password" name="cpassword" id="password">
        </div>
        <input class="btn" type="submit" value="Create account" onclick="return Validate()">
      </form>
      <div style="float: right;padding:3px;">
      <form action="Logout" method="post" style="padding:5px">
        <input type="submit" value="Logout" style="display: block;width: 100%;padding: 10px 15px;border: 0;background:#d9534f;color: #fff; border-radius: 5px;margin: 5px 0;">
     </form>
     </div>
	</section>
	 <script type="text/javascript">
	    function Validate() {
	    	var name=document.getElementById("name").value;
	    	var email=document.getElementById("email").value;
	    	var uname=document.getElementById("uname").value;
	        var password = document.getElementById("pass").value;
	        var confirmPassword = document.getElementById("password").value;
	        if (password == ''||name==''||email==''||uname==''||confirmPassword=='')
	        {
	        	alert("Please enter all details.");
	        	return false;
	        }
		    
	        else if (password != confirmPassword) {
	        	alert("Password did not match.");
	            return false;
	        }
	        return true;
	    }
	</script>
</body>
</html>