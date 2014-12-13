<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Create Industry</title>
		<script>
			function createIndustry()
			{
				var data = processFormToJsonViaAjax('createForm');

				var ajax = ajaxSubmit('industryCreate.action', 'json', data);

				ajax.done(function()
				{
					redirectTo('industries.action');
				});
			}
		</script>
	</head>
	<body>
		<form id="createForm">		
			<fieldset class="noBorder" fieldsetWidth="350">
				<ol>
					<li>
						<label>Name</label>
						<input name="name" id="name"/>
					</li>				
				</ol>
				<br/>
				<input type="button" onclick="createIndustry()" value="Create" class="dialogButton"/>
			</fieldset>		
		</form>
	</body>
</html>