<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
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
      <h1>Main Menu</h1>
    </header>
	<section class="container">
	  <form action="fieldofficial_form.jsp" style="padding:5px">
       <input type="submit" value="Create a field official account" style="display: block;width: 100%;padding: 10px 15px;border: 0;background:#add8e6;color: black; border-radius: 5px;margin: 5px 0;font-size:16px;">
      </form>
      <form action="CheckReport.jsp" style="padding:5px">
       <input type="submit" value="Check loan report" style="display: block;width: 100%;padding: 10px 15px;border: 0;background:#add8e6;color:black; border-radius: 5px;margin: 5px 0;font-size:16px;">
      </form>
      <form action="Logout" method="post" style="padding:5px">
        <input type="submit" value="Logout" style="display: block;width: 100%;padding: 10px 15px;border: 0;background:#d9534f;color: #fff; border-radius: 5px;margin: 5px 0;">
    </form>
</section>
</body>
</html>