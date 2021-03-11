<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
%> 
<header>
<h1>ABC BANK</h1>
</header>
<section class="container">
      <div style="padding:20px">
      <form id="my-form" action="Logout" method="post">
        <h1>Password has been changed</h1>
        <br>
        <div>
        <label>Go back to login page</label>
        </div>
        <br>
        <input class="btn" type="submit" value="Login again">
      </form>
      </div>
	</section>
</body>
</html>