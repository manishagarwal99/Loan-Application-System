<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<%
response.setHeader("Pragma","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Expires","0");
response.setDateHeader("Expires",-1);
if(session.getAttribute("name")==null&&session.getAttribute("flag")==null)
{
	response.sendRedirect("index.jsp");
}
String mailSent=(String)session.getAttribute("mailSent"); 
%>
    <header>
      <h1>ABC BANK</h1>
    </header>
	<section class="container">
		<form id="my-form" action="forgotpassword" method="post">
		<h3>Account Details for Password Recovery</h3>
		<font color='blue' style='text-align:center'><b>${mailSent}</b></font>
		<div>
          <label for="user">Email Id:</label>
          <input type="text" name="user" id="email">
        </div>
        <div>
        <label for="uname">User Name:</label>
        <input type="text" name="uname" id="uname"><br />
        </div>
	 <input class="btn" type="submit" value="Send"  onclick="return Validate()" />
		</form>
	</section>
		 <script type="text/javascript">
	    function Validate() {
	    	var email=document.getElementById("email").value;
	    	var uname=document.getElementById("uname").value;
	        if (email==''||uname=='')
	        {
	        	alert("Please enter all details.");
	        	return false;
	        }
	        return true;
	    }
	</script>
</body>
</html>