<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Applicant Registration</title>
<link rel="stylesheet" href="style.css">
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
 	<h1>Loan Application</h1>
    </header>
	<section class="container">
      <form id="my-form" action="CollectData" method="post">
        <h1>Application Details</h1>
        <font color='blue' style='text-align:center'><b>${result}</b></font>
        <div class="msg"></div>
        <div>
          <label for="date">Application date:</label>
          <input type="date" name="date" id="date" min="2010-01-01" max="2020-12-31">
        </div>
        <div>
          <label for="name">Applicant name:</label>
          <input type="text" name="name" id="name">
        </div>
        <div>
          <label for="add">Residential Address:</label>
		  <input type="text" name="add" id="add">
        </div>
        <div>
          <label for="number">Contact Number:</label>
		 <input type="text" name="number" id="number">
        </div>
        <div>
          <label for="pan">PAN Number:</label>
		  <input type="text" name="pan" id="pan">
        </div>
        <div>
          <label for="aadhar">Aadhar Number:</label>
		  <input type="text" name="aadhar" id="aadhar">
        </div>
        <div>
          <label for="Loan">Loan Requirement:</label>
		  <input type="text" name="loan" id="Loan">
        </div>
        <input class="btn" type="submit" value="submit" onclick="return Validate()">
      </form>
      <div style="float: right;padding:3px;">
      <form action="Logout" method="post" style="padding:5px">
        <input type="submit" value="Logout" style="display: block;width: 100%;padding: 10px 15px;border: 0;background:#d9534f;color: #fff; border-radius: 5px;margin: 5px 0;">
     </form>
     </div>

	</section>
		 <script type="text/javascript">
	    function Validate() {
	    	var date=document.getElementById("date").value;
	    	var name=document.getElementById("name").value;
	    	var add=document.getElementById("add").value;
	        var number = document.getElementById("number").value;
	        var pan = document.getElementById("pan").value;
	        var aadhar = document.getElementById("aadhar").value;
	        var Loan = document.getElementById("Loan").value;
	        if (date == ''||name==''||add==''||number==''||pan==''||aadhar==''||Loan=='')
	        {
	        	alert("Please enter all details.");
	        	return false;
	        }
	        return true;
	    }
	</script>
	<script>
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; //January is 0!
	var yyyy = today.getFullYear();
	 if(dd<10){
	        dd='0'+dd
	    } 
	    if(mm<10){
	        mm='0'+mm
	    } 

	today = yyyy+'-'+mm+'-'+dd;
	document.getElementById("date").setAttribute("max", today);
	</script>
</body>
</html>