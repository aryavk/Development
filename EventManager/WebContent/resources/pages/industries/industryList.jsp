<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Industries</title>
	<script>
		jQuery(document).ready(function()
		{
			var ajax = ajaxRequest(contextPath + '/industryList.action', 'json');

			ajax.done(function(xhr)
			{
				var tbody = jQuery('#industries').find('tbody');
				jQuery.each(xhr, function()
				{
					tbody.append('<tr><td>' + this.name + '</td></tr>');
				});
			});
		});
	
		function createIndustry()
		{
			var ajax = createDialog("industryCreate.action", 'Create Industry');

			ajax.completed.done(function()
			{
				refreshPage();
			});
		}
	</script>
</head>
	<body>
	    <h1>Industries</h1>
	    <input type="button" value="Create Industry" class="dialogButton" onclick="createIndustry()"/>
	    <br/><br/><br/>
	    <table id="industries" class="styledTable">
	    	<thead>
	    		<tr>
	    			<th>Name</th>
	   			</tr>
	    	</thead>
	    	<tbody>
	    	</tbody>
	    </table>    
	</body>
</html>