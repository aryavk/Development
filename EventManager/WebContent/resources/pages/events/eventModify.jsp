<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Modify Event</title>
		<script>

			var eventId = getQueryVariableInDialog(jQuery('#Modify_Event'), 'id'); 
			
			jQuery(document).ready(function()
			{
				var url = '/eventRead.action?id=' + eventId;
				var ajax = ajaxRequest(contextPath + url, 'json');

				ajax.done(function(xhr)
				{
					jQuery('#eventId').val(xhr.id);
					jQuery('#name').val(displayValue(xhr.name));
					jQuery('#location').val(displayValue(xhr.location));
					jQuery('#venue').val(displayValue(xhr.venue));
					jQuery('#website').val(displayValue(xhr.website));
					jQuery('#fromDate').val(xhr.fromDate);
					jQuery('#toDate').val(xhr.toDate);
					jQuery('#pros').val(displayValue(xhr.pros));
					jQuery('#cons').val(displayValue(xhr.cons));
					jQuery('#notes').val(displayValue(xhr.responsiblePeople));

					var attending;
					
					if (xhr.attending)
					{
						attending = 'Yes';
						jQuery('#attendButton').hide();
						jQuery('#notAttendButton').show();
					}
					else
					{ 
						attending = 'No';
						jQuery('#attendButton').show();
						jQuery('#notAttendButton').hide();
					}
					jQuery('#attending').html(attending);

					var locationAjax = fillSelectBoxFromUrl(contextPath + "/getStates.action", jQuery('#state'));

					locationAjax.done(function()
					{
						jQuery('#state').val(xhr.state.id);
					});
					
					var industryAjax = fillSelectBoxFromUrl(contextPath + "/getIndustries.action", jQuery('#industry'));

					industryAjax.done(function()
					{
						jQuery('#industry').val(xhr.industry.id);
					});
					
				});								
			});

			function modifyEvent()
			{
				var data = processFormToJsonViaAjax('modifyForm');

				var ajax = ajaxSubmit(contextPath + '/eventModify.action', 'json', data);

				ajax.done(function(xhr)
				{
					refreshDiv(jQuery('#Modify_Event'));
				});
			}

			function attendEvent()
			{
				var ajax = ajaxSubmit(contextPath + '/eventAttend.action?id=' + eventId, 'html', {});

        		ajax.done(function()
            	{
                	refreshDiv(jQuery('#Modify_Event'));
            	});
			}

			function notAttendEvent()
			{
				var ajax = ajaxSubmit(contextPath + '/eventNotAttend.action?id=' + eventId, 'html', {});

        		ajax.done(function()
            	{
        			refreshDiv(jQuery('#Modify_Event'));
            	});
			}
		</script>
	</head>
	<body>
		<form id="modifyForm">
			<input type="hidden" id="eventId" name="id"/>
			<table>
				<tr>
					<td valign="top">
						<fieldset class="noBorder" fieldsetWidth="450">
							<ol>
								<li>
									<label>Name</label>
									<input id="name" name="name"/>
								</li>
								<li>
									<label>Industry</label>
									<select id="industry" name="industry.id">
									</select>
								</li>
								<li>
									<label>State</label>
									<select id="state" name="state.id">
									</select>
								</li>
								<li>
									<label>Location</label>
									<input id="location" name="location"/>
								</li>
								<li>
									<label>Venue</label>
									<input id="venue" name="venue"/>
								</li>
								<li>
									<label>Website</label>
									<input id="website" name="website"/>
								</li>
								<li>
									<label>From Date</label>
									<input id="fromDate" name="fromDate" class="datePicker"/>
								</li>
								<li>
									<label>To Date</label>
									<input id="toDate" name="toDate" class="datePicker"/>
								</li>
								<li>
									<label>Attending</label>
									<span id="attending"/>									
								</li>
							</ol>				
						</fieldset>
					</td>
					<td valign="top">
						<fieldset class="noBorder" fieldsetWidth="400">
							<ol>
								<li>
									<label>Pros</label>
									<textarea id="pros" name="pros"></textarea>
								</li>
								<li>
									<label>Cons</label>
									<textarea id="cons" name="cons"></textarea>
								</li>
								<li>
									<label>Notes</label>
									<textarea id="notes" name="responsiblePeople"></textarea>
								</li>
							</ol>				
						</fieldset>
					</td>
				</tr>
			</table>								
			<input type="button" id="attendButton" onclick="attendEvent()" value="Attending" class="dialogButton"/>
			<input type="button" id="notAttendButton" onclick="notAttendEvent()" value="Not Attending" class="dialogButton"/>
			<input type="button" onclick="modifyEvent()" value="Update" class="dialogButton"/>
		</form>
	</body>
</html>