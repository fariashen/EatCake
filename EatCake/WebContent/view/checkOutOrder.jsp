<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>确认订单</h4>
	<s:textfield name="address" label="address" readonly="true"></s:textfield>
	<s:textfield name="phone" label="phone" readonly="true"></s:textfield>
	<br>
	
	<table border="1" cellpadding="10" cellspacing="0">
	
		<thead>
				<tr>
					<td>GoodsName</td>
					<td>GoodsPrice</td>
					<td>CartNum</td>
				</tr>
		</thead>
		
		<tbody>
			<s:if test="#session.clearingCart != null && #session.clearingCart.size() > 0">
				<s:iterator value="#session.clearingCart">
					<tr>
						<td><a href="checkCart-detail?goodsId=${goodsId }">${goodsName }</a></td>
						<td>${goodsPrice }</td>
						<td>${num }</td>
					</tr>
				</s:iterator>
			</s:if>
			<s:elseif test="#session.checkOutGoods != null">
				<tr>
					<td><a href="checkCart-detail?goodsId=${checkOutGoods.goodsId }">${checkOutGoods.goodsName }</a></td>
					<td>${checkOutGoods.goodsPrice }</td>
					<td>1</td>
				</tr>
			</s:elseif>
		</tbody>
		
	</table>
	
	<s:form action="checkOut-checkOut" method="post">
		<s:hidden name="orderId"></s:hidden>
		<s:submit value="确认付款"></s:submit>
	</s:form>
	
</body>
</html>