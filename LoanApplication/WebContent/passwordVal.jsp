<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Set new password</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<%
response.setHeader("Pragma","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Expires","0");
response.setDateHeader("Expires",-1);
if(session.getAttribute("name")==null)
{
	response.sendRedirect("index.jsp");
}
session.setAttribute("flag","true");
%> 
<header>
<h1>ABC BANK</h1>
</header>
	<section class="container">
		<form id="my-form" action="ConfirmMatch" method="post">
		<h1>Change Password</h1>
			New password:<input type="password" name="pass" id="pass"><br /> 
			Confirm new password:<input type="password" name="password" id="password"><br /> 
			<input class="btn" type="submit" value="Update" onclick="return Validate()">
		</form>
	</section>
	 <script type="text/javascript">
	    function Validate() {
	        var password = document.getElementById("pass").value;
	        var confirmPassword = document.getElementById("password").value;
	        if (password == ''||confirmPassword=='')
	        {
	        	alert("Please enter all details.");
	        	return false;
	        }
		    
	        else if (password != confirmPassword) {
	        	alert("Password did not match.");
	            return false;
	        }
	        else
	        {
	        	alert("Password changed successfully.");
	        	return true;
	        }
	    }
	</script>
</body>
</html>