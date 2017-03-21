<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
			<tr>
				<td>${goods.goodsId }</td>
				<td>${goods.goodsName }</td>
				<td>${goods.goodsBrief }</td>
				<td>${goods.goodsDetail }</td>
				<td>${goods.goodsImgPath }</td>
				<td>${goods.goodsPrice }</td>
				<td>${goods.goodsType }</td>
				<td><a href="addCart?goodsId=${goods.goodsId }&userName=${userName }">添加购物车</a></td>
				<td><a href="?goodsId=${goods.goodsId }&userName=${userName }">立即购买</a></td>
			</tr>
		</tbody>
	</table>
	<br><br>
	<a href="checkCart-check?userName=${userName }">返回</a>
</body>
</html>