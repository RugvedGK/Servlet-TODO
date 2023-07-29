<%@page import="Dto.AddTask"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>To-Do | List Home page</title>
</head>
<body>
<form action="home" method="post">
	<h1 align="center">Welcome to To-Do HomePage</h1>
	<table border="2px">
	<tr>
	<td>Id</td>
	<td>TaskName</td>
	<td>Task Describe</td>
	<td>Task Date</td>
	<td>Task completion Date</td>
	<td>Change Status</td>
	<td>Change</td>
	<td>Delete</td>
	<td>Update</td>
	</tr>
	<tr>
	<%
	List<AddTask> list  = (List<AddTask>) request.getAttribute("list");
	%>
	<%
	for (AddTask task : list){
	%>
	<td><%=task.getId() %></td>
	<td><%=task.getName()%></td>
	<td><%=task.getDescription()%></td>
	<td><%=task.getStart()%></td>
	<td><%=task.getComplete()%></td>
	<td><%if(task.isStatus())%>Completed<%else%>Not Completed</td>
	<td><button>change</button></td>
	<td><button>Delete</button></td>
	<td><button>Update</button></td>
	</tr>
	<%
	}
	%>
	</table>
	<br>
	<br>
	</form>
	<a href="Taskdetails.html"><button style="margin-left: 20px">Add Task</button></a>
	<a href = "LoginForm.html"><button style="margin-left: 540px">Logout</button></a>
</body>
</html>