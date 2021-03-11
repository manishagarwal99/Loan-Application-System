<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check Report</title>
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
<%session.setAttribute("act_datewise","active");%>
	<header>
      <h1>Check Loan Reports</h1>
    </header>
	<section class="container">
	  	<form action="main.jsp" style="padding:5px">
         <input type="submit" value="Date and Month wise total Loan Application Values" name="button1" style="display: block;width: 100%;padding: 10px 15px;border: 0;background:#add8e6;color: black; border-radius: 5px;margin: 5px 0;font-size:16px;">
    </form>
    <form  action="valid.jsp" style="padding:5px">
        <input type="submit" value=" Date and Month wise Valid Loan Applications" name="button2" style="display: block;width: 100%;padding: 10px 15px;border: 0;background:#add8e6;color: black; border-radius: 5px;margin: 5px 0;font-size:16px;">
    </form>
    <form action="invalid.jsp" style="padding:5px">
       <input type="submit" value=" Date and Month wise Invalid Loan Applications" name="button3" style="display: block;width: 100%;padding: 10px 15px;border: 0;background:#add8e6;color: black; border-radius: 5px;margin: 5px 0;font-size:16px;">
    </form>
      <form action="Logout" method="post" style="padding:5px">
       <input type="submit" value="Logout" style="display: block;width: 100%;padding: 10px 15px;border: 0;background:#d9534f;color: #fff; border-radius: 5px;margin: 5px 0;font-size:16px;">
     </form>
	</section>
</body>
</html>