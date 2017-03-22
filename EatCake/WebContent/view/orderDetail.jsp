<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>订单详情</h4>
	<table border="1" cellpadding="10" cellspacing="0">

		<thead>
			<tr>
				<td>OrderId</td>
				<td>Address</td>
				<td>Phone</td>
				<td>OrderStatus</td>
			</tr>
		</thead>

		<tbody>
				<tr>
					<td>${orderVo.orderId }</td>
					<td>${orderVo.address }</td>
					<td>${orderVo.phone }</td>
					<td>${orderVo.orderStatus }</td>
				</tr>
		</tbody>
	</table>
	<br>
	<br>
	
	<h4>商品信息：</h4>
	<table border="1" cellpadding="10" cellspacing="0">

		<thead>
			<tr>
				<td>GoodsName</td>
				<td>GoodsBrief</td>
				<td>GoodsDetail</td>
				<td>GoodsImgPath</td>
				<td>GoodsPrice</td>
				<td>GoodsType</td>
			</tr>
		</thead>

		<tbody>
			<s:iterator value="#request.orderGoodsList">
				<tr>
					<td>${goodsName }</td>
					<td>${goodsBrief }</td>
					<td>${goodsDetail }</td>
					<td>${goodsImgPath }</td>
					<td>${goodsPrice }</td>
					<td>${goodsType }</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	<br>
	
	<s:if test="#request.orderVo.orderStatus.equals('未支付')">
		<a href="checkOut-checkOut?orderId=${orderVo.orderId }">付款</a>
	</s:if>
</body>
</html>