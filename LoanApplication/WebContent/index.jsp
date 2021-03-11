<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Loan Management</title>
    <link rel="stylesheet" href="style.css">
  </head>
  <body>
  <%
  String result=(String)session.getAttribute("result");
  %>
    <header >
      <h1>ABC BANK</h1>
    </header>
    <section class="container">
      <form id="my-form" method="post" action="LoginPage">
        <h1>Login</h1>
        <font color='blue' style='text-align:center'><b>${result}</b></font>
        <font color='blue' style='text-align:center'><b>${result1}</b></font>
        <div class="msg"></div>
        <div>
          <label for="name">User name:</label>
          <input type="text" id="name" name="user" id="user">
        </div>
        <div>
          <label for="name">Password:</label>
          <input type="password" id="name" name="pass" id="pass">
        </div>
        <input class="btn" type="submit" value="Submit" onclick="return Validate()">
      </form>
      <div style="float: right;padding:3px;">
      	<%session = request.getSession();
      	session.setAttribute("flag","true");%>
	       <font color="red"><a href="email.jsp" style="text-decoration:none;color:#aaa;background-color:white;" onMouseOver="this.style.color='blue'" onMouseOut="this.style.color='#aaa'">Forgot password </a></font>
      </div>
    </section>
    	 <script type="text/javascript">
	    function Validate() {
	        var user = document.getElementById("user").value;
	        var pass = document.getElementById("pass").value;
	        if (pass == ''||user=='')
	        {
	        	alert("Please enter all details.");
	        	return false;
	        }
	        return true;
	    }
	</script>
  </body>
</html>

