<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Events</title>
		<script>

			function searchEvents()
			{
				var url = '/eventList.action?';

				var state = jQuery('#state').val();
				var industry = jQuery('#industry').val();
				
				if (state > 0)
					url += 'stateId=' + state + '&';

				if (industry > 0)
					url += 'industryId=' + industry + '&';

				var ajax = ajaxRequest(contextPath + url, 'json');

				ajax.done(function(xhr)
				{
					var tbody = jQuery('#events').find('tbody');
					jQuery.each(xhr, function()
					{
						var attending = this.attending ? 'Yes' : 'No';
						var row = '<tr>' +
						'<td><img class="deleteButton" onclick="modifyEvent(' + this.id + ')"/></td>' +
						'<td><img class="editButton" onclick="modifyEvent(' + this.id + ')"/></td>' + 
						'<td>' + this.name + '</td>' + 
						'<td>' + this.industry.name + '</td>' + 
						'<td>' + this.state.name + '</td>' + 
						'<td>' + displayValue(this.location) + '</td>' + 
						'<td>' + displayValue(this.venue) + '</td>' + 
						'<td>' + displayValueWithLink(this.website) + '</td>' + 
						'<td sorttable_customkey="' + this.fromDateMillis + '">' + this.fromDate + '</td>' + 
						'<td sorttable_customkey="' + this.toDateMillis + '">' + this.toDate + '</td>' + 
						'<td>' + attending + '</td>' + 
						'</tr>';

						tbody.append(row);
					});

					var eTable = document.getElementById('events');
					sorttable.makeSortable(eTable);
				});
			}
		
			jQuery(document).ready(function()
			{
				fillSelectBoxFromUrl("getStates.action", jQuery('#state'));
				fillSelectBoxFromUrl("getIndustries.action", jQuery('#industry'));				
			});

			function modifyEvent(id)
			{
				var ajax = createDialog("eventModify.action?id=" + id, 'Modify Event');

				ajax.completed.done(function()
				{
					refreshPage();
				});
			}

			function deleteEvent(id)
			{
				var confirm = confirmDialog('Are you sure you want to delete this event?', "Confirm");

				confirm.done(function()
				{
					var data = {id: eventId};
					var ajax = ajaxSubmit(contextPath + '/eventDelete.action', 'json', data, HttpDelete);

	        		ajax.done(function()
	            	{
	                	refreshPage();
	            	});
				});
			}

			function loadUrl(url)
			{
				window.open(url,'_blank');
			}
		</script>
	</head>
	<body>
		<fieldset>
			<legend>Search Events</legend>
			<ol>
				<li>
					<label>Industry</label>
					<select id="industry" name="industry">
						<option value="0">All</option>
					</select>
				</li>
				<li>
					<label>State</label>
					<select id="state" name="state">
						<option value="0">All</option>
					</select>
				</li>
				<li>
					<label></label>
					<input type="button" value="Search" onclick="searchEvents()" class="dialogButton"/>
				</li>			
			</ol>
		</fieldset>
		<br/><br/><br/>
		<div id="results">
		    <table id="events" class="styledTable">
		    	<thead>
		    		<tr>
		    			<th></th>
		    			<th></th>
		    			<th>Name</th>
		    			<th>Industry</th>
		    			<th>State</th>
		    			<th>Location</th>
		    			<th>Venue</th>
		    			<th>Website</th>
		    			<th>From Date</th>
		    			<th>To Date</th>
		    			<th>Attending</th>
		   			</tr>
		    	</thead>
		    	<tbody>	    		
		    	</tbody>
		    </table>
	    </div>
	</body>
</html>