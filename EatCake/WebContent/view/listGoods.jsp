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

	<h4>Goods List</h4>
	
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
					<td>添加购物车</td>
					<td>立即购买</td>
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
						<td><a href="addCart?goodsId=${goodsId }&userName=${userName }">添加购物车</a></td>
						<td><a href="?goodsId=${goodsId }&userName=${userName }">立即购买</a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</s:else>
	
</body>
</html>