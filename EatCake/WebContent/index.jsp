<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String contextPath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	Hello,EatCake
	<br><br>
	<a href="<%=contextPath %>/view/login.jsp">登录</a>
	<br><br>
	<a href="<%=contextPath %>/view/register.jsp">注册</a>
	<br><br>
</body>
</html>