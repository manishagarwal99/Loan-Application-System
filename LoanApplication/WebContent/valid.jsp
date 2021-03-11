<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<title>Valid Data</title>
</head>
<body>
<%
String act_datewise =(String)session.getAttribute("act_datewise");
String act_month=(String)session.getAttribute("act_month");
String act_daterange=(String)session.getAttribute("act_daterange");

%>
	<form id="my-form" method="post" action="ShowTable">
    <div style="background-color:#add8e6">
	<nav class="nav justify-content-center nav-pills flex-column flex-md-row">
		<a href="#n" class="nav-link ${act_datewise}" data-toggle="tab">Date Wise</a> <a
			href="#w" class="nav-link ${act_month}" data-toggle="tab">Month wise</a> <a
			href="#x" class="nav-link ${act_daterange }" data-toggle="tab">Date Range</a>

	</nav>
	</div>
		<div style="padding-left:30px;background-color:#add8e6;">
			<div class="tab-content py-5" style="background-color:#add8e6;padding-left:20x;">
		<div class="tab-pane ${act_datewise}" id="n">
				<h3>Date Wise</h3>
				<input type="date" id="date" name="vdate" value="" min="2010-01-01"
					max="2020-12-31"> <input class="btn" type="submit"
					value="Go" name="vbutton1">

			</div>
			<div class="tab-pane ${act_month}" id="w" style="background-color:#add8e6;padding-left:20x;">
				<h3>Month Wise</h3>
				<input type="month" id="month" name="vmonth" min="2010-01"
					value="2020-01">
				<!-- <label for="month">Month:</label> 
				<select
					id="month" name="vmonth">
					<option selected>January</option>
					<option>February</option>
					<option>March</option>
					<option>April</option>
					<option>May</option>
					<option>June</option>
					<option>July</option>
					<option>August</option>
					<option>September</option>
					<option>October</option>
					<option>November</option>
					<option>December</option>
				</select> -->
				 <input class="btn" type="submit" value="Go" name="vbutton2">

			</div>
			<div class="tab-pane ${act_daterange}" id="x" style="background-color:#add8e6;padding-left:20x;">
				<h2>Start Date:</h2>
				<input type="date" id="sdate" name="vstart" value="" min="2010-01-01"
					max="2020-12-31">
				<h2>End Date:</h2>
				<input type="date" id="edate" name="vend" value="" min="2010-01-01"
					max="2020-12-31"> <input class="btn" type="submit"
					value="Go" name="vbutton3">
			</div>

		</div>
		</div>
	</form>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
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
	document.getElementById("sdate").setAttribute("max", today);
	document.getElementById("edate").setAttribute("max", today);
	</script>
</body>
</html>