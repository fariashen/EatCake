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
	Manage Goods
	<br><br>
	<a href="<%=contextPath %>/view/addGoods.jsp">增加商品</a>
	<br><br>
	
	<s:if test="#request.goodsList == null || #request.goodsList.size() == 0">
		没有任何商品信息
	</s:if>
	
	<s:else>
		<table border="1" cellpadding="10" cellspacing="0">
			<thead>
				<tr>
					<td>GoodsId</td>
					<td>GoodsName</td>
					<td>GoodsBrief</td>
					<td>GoodsDetail</td>
					<td>GoodsImgPath</td>
					<td>GoodsPrice</td>
					<td>GoodsType</td>
					<td>Delete</td>
					<td>Update</td>
				</tr>
			</thead>
			
			<tbody>
				<s:iterator value="#request.goodsList">
					<tr>
						<td>${goodsId }</td>
						<td>${goodsName }</td>
						<td>${goodsBrief }</td>
						<td>${goodsDetail }</td>
						<td>${goodsImgPath }</td>
						<td>${goodsPrice }</td>
						<td>${goodsType }</td>
						<td><a href="manageGoods-delete?goodsId=${goodsId }">Delete</a></td>
						<td><a href="manageGoods-update?">Update</a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</s:else>
</body>
</html>