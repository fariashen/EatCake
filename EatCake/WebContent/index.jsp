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
	<a href="<%=contextPath %>/view/logout.jsp">注销</a>
	<br><br>
	<a href="<%=contextPath %>/view/register.jsp">注册</a>
	<br><br>
	<a href="<%=contextPath %>/view/manageUser.jsp">管理用户</a>
	<br><br>
	<a href="manageGoods-manage">管理商品</a>
	<br><br>
	<a href="<%=contextPath %>/view/retrieveGoods.jsp">检索商品</a>
	<br><br>
	<a href="manageGoods-list">查看商品</a>
	<br><br>
	<a href="checkCart-check?userName=${userName }">查看购物车</a>
	<br><br>
</body>
</html>