<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Create Event</title>
		<script>
			jQuery(document).ready(function()
			{
				fillSelectBoxFromUrl("getStates.action", jQuery('#state'));
				fillSelectBoxFromUrl("getIndustries.action", jQuery('#industry'));
			});

			function createKEvent()
			{
				var data = processFormToJsonViaAjax('createForm');

				var ajax = ajaxSubmit('eventCreate.action', 'json', data);

				ajax.done(function(xhr)
				{
					redirectTo('events.action');
				});
			}

			function dateHandler(dateText)
			{
				if (jQuery('#toDate').val().length == 0)
					jQuery('#toDate').val(dateText);
			}
		</script>
	</head>
	<body>
		<form id="createForm">		
			<fieldset class="noBorder" fieldsetWidth="450">
				<legend>Create Event</legend>
				<ol>
					<li>
						<label>Name</label>
						<input name="name"/>
					</li>
					<li>
						<label>Industry</label>
						<select id="industry" name="industry.id">
							<option value="0">Select</option>
						</select>
					</li>
					<li>
						<label>State</label>
						<select id="state" name="state.id">
							<option value="0">Select</option>
						</select>
					</li>
					<li>
						<label>Location</label>
						<input name="location"/>
					</li>
					<li>
						<label>Venue</label>
						<input name="venue"/>
					</li>
					<li>
						<label>Website</label>
						<input name="website"/>
					</li>
					<li>
						<label>From Date</label>
						<input name="fromDate" class="datePicker" onchangeHandler="true"/>
					</li>
					<li>
						<label>To Date</label>
						<input id="toDate" name="toDate" class="datePicker"/>
					</li>
				</ol>
				<br/>
				<input type="button" onclick="createKEvent()" value="Create" class="dialogButton"/>
			</fieldset>		
		</form>
	</body>
</html>