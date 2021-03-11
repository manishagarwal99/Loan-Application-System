<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OTP Validation</title>
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
String mailSent=(String)session.getAttribute("mailSent"); 
%>
<header >
      <h1>ABC BANK</h1>
</header>
<section class="container">
		<form id="my-form" action="ValidateOTP" method="post">
		<h1>Validate OTP</h1>
		<font color='blue' style='text-align:center'><b>${mailSent}</b></font>
		<br>
			Enter OTP:<input type="password" name="otp" id="otp"><br />
			<input class="btn" type="submit" value="Validate"  onclick="return Validate()"/>
		</form>
	</section>
		 <script type="text/javascript">
	    function Validate() {
	    	var otp=document.getElementById("otp").value;
	        if (otp=='')
	        {
	        	alert("Please enter all details.");
	        	return false;
	        }
	        return true;
	    }
	</script>
</body>
</html>