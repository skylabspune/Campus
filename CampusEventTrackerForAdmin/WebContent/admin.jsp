<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
<script language="javascript">

function validateAdminForm()
{
	var eventName=document.getElementById("eventName").value;
	var latitude=document.getElementById("latitude").value;
	var longitude=document.getElementById("longitude").value;
	var date=document.getElementById("date").value;
	var hour=document.getElementById("hour").value;
	var min=document.getElementById("min").value;
	var rgxPosition=/^\d+(?:\.\d+)?$/;
	//var rgxHour=/^[01]?[0-9]|2[0-3]/;
	var rgxHour=/^[01]\d|2[0-3]/;
	var rgxMin=/^[0-5][0-9]/;
 
	if(eventName=="" || latitude=="" || longitude=="" || date=="" || hour=="" || min=="")
	{
		alert("All fields are mandetory");
		return false;
	}
	
	if(!longitude.match(rgxPosition)) {
		document.addEventForm.latitude.focus();
		document.getElementById("diverror").innerHTML="Latitude should be in numerics.";
		return false;
	}
	
	if(!latitude.match(rgxPosition)) {
		document.addEventForm.longitude.focus();
		document.getElementById("diverror").innerHTML="Longitude should be in numerics.";
		return false;
	}
	
	if(!hour.match(rgxHour)) {
		document.addEventForm.longitude.focus();
		document.getElementById("diverror").innerHTML="Enter proper hours for the event";
		return false;
	}
	
	if(!min.match(rgxMin)) {
		document.addEventForm.longitude.focus();
		document.getElementById("diverror").innerHTML="Enter proper mins for the event";
		return false;
	}
	
	alert("none");
	document.getElementById("diverror").style.display= 'none';
	return true;
}
</script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
$(function() {
	$("#date").datepicker({
    	minDate: 0,
    	dateFormat: 'dd/mm/yy'
	});
});

</script>
</head>
<body>
	<div class="error" id="diverror"></div>
	<br>
	<div class="error" id="error">${requestScope.error}</div>
	<br>
	<div class="success" id="message">${requestScope.message}</div>
	<br>
	Enter Event's details to add<br><br>
		<form name="addEventForm" method="post" action="<%= request.getContextPath() %>/AddEventServlet" onsubmit="return validateAdminForm()">
			Event name : <input type="text" id="eventName" name="eventName" maxlength="50">
			<br><br>
			Event's Latitude : <input type="text" id="latitude" name="latitude" maxlength="15">
			<br><br>
			Event's Longitude : <input type="text" value="" id="longitude" name="longitude" maxlength="15">
			<br><br>
			Enter date for the event : <input type="text" id="date" name="date" readonly="readonly">
			<br><br>
			Confirm time for the event : <input type="text" id="hour" name="hour" maxlength="2"> : <input id="min" maxlength="2" type="text" name="min">	
			<br><br>
			<input type="submit" value="Add Event">
		</form>
	</body>
</html>