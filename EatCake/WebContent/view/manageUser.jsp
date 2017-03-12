<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String contextPath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	Manage User
	<br><br>
	<a href="<%=contextPath %>/view/addUser.jsp">增加</a>
	<br><br>
	<a href="<%=contextPath %>/view/deleteUser.jsp">删除</a>
	<br><br>
</body>
</html>