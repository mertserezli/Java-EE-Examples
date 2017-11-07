<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Task/employee</title>
	</head>
	<body>
		<% String html = (String) request.getAttribute("tree"); %>
		<%= html %>
	</body>
	<style type="text/css">
	
		* {margin: 0; padding: 0;}
		
		.tree ul {
			padding-top: 20px; position: relative;
			
			transition: all 0.5s;
			-webkit-transition: all 0.5s;
			-moz-transition: all 0.5s;
		}
		
		.tree li {
			float: left; text-align: center;
			list-style-type: none;
			position: relative;
			padding: 20px 5px 0 5px;
			
			transition: all 0.5s;
			-webkit-transition: all 0.5s;
			-moz-transition: all 0.5s;
		}
				
		.tree li::before, .tree li::after{
			content: '';
			position: absolute; top: 0; right: 50%;
			border-top: 1px solid #ccc;
			width: 50%; height: 20px;
		}
		
		.tree li::after{
			right: auto; left: 50%;
			border-left: 1px solid #ccc;
		}
		
		.tree li:only-child::after, .tree li:only-child::before {
			display: none;
		}
		
		.tree li:only-child{ padding-top: 0;}
		
		.tree li:first-child::before, .tree li:last-child::after{
			border: 0 none;
		}
		
		.tree li:last-child::before{
			border-right: 1px solid #ccc;
			border-radius: 0 5px 0 0;
			-webkit-border-radius: 0 5px 0 0;
			-moz-border-radius: 0 5px 0 0;
		}
		.tree li:first-child::after{
			border-radius: 5px 0 0 0;
			-webkit-border-radius: 5px 0 0 0;
			-moz-border-radius: 5px 0 0 0;
		}
		
		.tree ul ul::before{
			content: '';
			position: absolute; top: 0; left: 50%;
			border-left: 1px solid #ccc;
			width: 0; height: 20px;
		}
		
		.tree li a{
			border: 1px solid #ccc;
			padding: 5px 10px;
			text-decoration: none;
			color: #000;
			font-family: arial, verdana, tahoma;
			font-size: 11px;
			display: inline-block;
			
			border-radius: 5px;
			-webkit-border-radius: 5px;
			-moz-border-radius: 5px;
			
			transition: all 0.5s;
			-webkit-transition: all 0.5s;
			-moz-transition: all 0.5s;
		}
		
		.tree li a:hover, .tree li a:hover+ul li a {
			background: #c8e4f8; color: #000; border: 1px solid #94a0b4;
		}
		/*Connector styles on hover*/
		.tree li a:hover+ul li::after, 
		.tree li a:hover+ul li::before, 
		.tree li a:hover+ul::before, 
		.tree li a:hover+ul ul::before{
			border-color:  #94a0b4;
		}
	
		.task{
			background-color:#ff0000;
		}

		.employee{
			background-color:#0066ff;
		}	
	</style>
</html>