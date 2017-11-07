<%@ 
	page language="java" 
	contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" 
	import="com.projecttasktree.ProjectBean" 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
	</head>
	<body>
		<% ProjectBean project = (ProjectBean) request.getAttribute("project"); %>
		<h1><%= project.getProjectname() %></h1>
		<a href="TasksServlet/<%= project.getProjectid() %>">Show task tree</a>
	</body>
</html>