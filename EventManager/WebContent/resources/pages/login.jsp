<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
	<head>
		<title>Login</title>
		<script>
			jQuery(document).ready(function()
			{
				jQuery('#username').focus();
			});
		</script>				
	</head>
	<body>

		<h1>Event Manager</h1>
	
		<div id="login-box">
	
			<form id="loginForm" name='loginForm' action="<c:url value='/j_spring_security_check'/>" method='POST'>
				<fieldset class="noBorder">
					<ol>
						<li>
							<label>Username</label>
							<input type='text' id="username" name='username'>
						</li>
						<li>
							<label>Password</label>
							<input type='password' id="password" name='password' />
						</li>
						<li>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
							<input class="dialogButton" type="submit" value="Login"/>
						</li>
					</ol>
				</fieldset>								
			</form>
		</div>
	</body>
</html>