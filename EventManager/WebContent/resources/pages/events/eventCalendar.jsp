<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Events</title>
	<script>
		jQuery(document).ready(function()
		{
			var url = '/eventList.action';

			var ajax = ajaxRequest(contextPath + url, 'json');

			var ehEvents = [];
			
			ajax.done(function(xhr)
			{
				jQuery.each(xhr, function()
				{
					var eventObj = 
					{
						title: this.name,
						start: new Date(this.fromDateMillis),
						end: new Date(this.toDateMillis + 86400000),
						color: this.attending ? "blue" : "red"
					};
					
					ehEvents.push(eventObj);

					jQuery('#calendar').fullCalendar('renderEvent', eventObj, true);
				});
			});
		});
	</script>
</head>
<body>
	<h1>Events</h1>
	<div id="calendar" class="calendar"></div>    		
</body>
</html>