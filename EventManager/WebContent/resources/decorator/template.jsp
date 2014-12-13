<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.css" media="all"/>  
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fullcalendar.css" media="all"/> 
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/application.css" media="all"/>    
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-ui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/moment.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/fullcalendar.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/form2js.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/sorttable.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/application.js"></script>
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    
    <title>EventManager - <decorator:title></decorator:title></title> 
 
    <decorator:head></decorator:head>
    
    <script>
    	jQuery(document).ready(function()
    	{
   	    	loadElements();
    	});

    	jQuery(document).ajaxComplete(function()
 	    {
 	   		loadElements();
 	    });

    	<sec:authorize access="hasRole('ROLE_ADMIN')">
    		function logout()
    		{
        		var ajax = ajaxSubmit('${pageContext.request.contextPath}/j_spring_security_logout', 'html', {});

        		ajax.done(function()
            	{
                	refreshPage();
            	});
       		}
   		</sec:authorize>
 	    
    </script>
 
</head>
<body bgcolor="grey">	
	<div class="wrapper">
		<div class="header"></div>	
		<div class="navigation">
			<sec:authorize access="hasRole('ROLE_ADMIN')">			
		  		<ul id="menu">
		  			<li><a href="${pageContext.request.contextPath}/industries.action">Industries</a></li>
	  				<li><a href="${pageContext.request.contextPath}/eventCalendar.action">Event Calendar</a></li>
		  			<li><a href="${pageContext.request.contextPath}/events.action">Events</a></li>
		  			<li>
		  				<a href="#">Events Per State</a>
		  				<ul>
  							<li><a href="${pageContext.request.contextPath}/events.action?stateId=1">New South Wales</a></li>
  							<li><a href="${pageContext.request.contextPath}/events.action?stateId=2">Queensland</a></li>
  							<li><a href="${pageContext.request.contextPath}/events.action?stateId=3">Victoria</a></li>
  							<li><a href="${pageContext.request.contextPath}/events.action?stateId=4">Tasmania</a></li>
  							<li><a href="${pageContext.request.contextPath}/events.action?stateId=5">South Australia</a></li>
  							<li><a href="${pageContext.request.contextPath}/events.action?stateId=6">Western Australia</a></li>
  							<li><a href="${pageContext.request.contextPath}/events.action?stateId=7">Northern Territoriy</a></li>
  							<li><a href="${pageContext.request.contextPath}/events.action?stateId=8">ACT</a></li>
  						</ul>
  					</li>	
		  			<li class="userDetails">
		  				Signed in as: <sec:authentication property="principal.username"/><br/>
		  				<span class="clickable" onclick="logout()">Logout</span>
		  			</li>
		  		</ul>
	  		</sec:authorize>
	  	</div>
	  	<div id="bodyWrapper">	  		  			
    		<decorator:body></decorator:body>
   		</div>  
 	</div>
</body>
</html>