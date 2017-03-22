<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% String contextPath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<s:if test="#session.userName == null">
		<h4>请先进行登录操作！</h4>
		<br><br>
		<a href="<%=contextPath %>/view/login.jsp">登录</a>
		<br><br>
	</s:if>
	
	<s:else>
		<s:form action="checkOut-clearing" method="post">
			<s:textfield name="address" label="address"></s:textfield>
			<s:textfield name="phone" label="phone"></s:textfield>
			<s:hidden name="goodsId" ></s:hidden>
			<s:submit></s:submit>
		</s:form>
	</s:else>
</body>
</html>