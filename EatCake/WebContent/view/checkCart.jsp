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
		<table border="1" cellpadding="10" cellspacing="0">
			<thead>
				<tr>
					<td>GoodsName</td>
					<td>GoodsPrice</td>
					<td>CartNum</td>
				</tr>
			</thead>
			
			<tbody>
				<s:iterator value="#session.cartVoList">
					<tr>
						<td><a href="checkCart-detail?goodsId=${goodsId }">${goodsName }</a></td>
						<td>${goodsPrice }</td>
						<td>${num }</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		
		<br><br>
		<a href="<%=contextPath%>/index.jsp">返回</a>
		<br><br>
		<a href="<%=contextPath%>/view/clearingCart.jsp">结算</a>
	</s:else>
	
</body>
</html>