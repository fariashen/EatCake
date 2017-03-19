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
	<s:debug></s:debug>
	<s:form action="manageGoods-update" method="post">
		<s:textfield name="goodsId" label="goodsId" readonly="true"></s:textfield>
		<s:textfield name="goodsName" label="goodsName"></s:textfield>
		<s:textfield name="goodsBrief" label="goodsBrief"></s:textfield>
		<s:textfield name="goodsDetail" label="goodsDetail"></s:textfield>
		<s:textfield name="goodsImgPath" label="goodsImgPath"></s:textfield>
		<s:textfield name="goodsPrice" label="goodsPrice"></s:textfield>
		<s:textfield name="goodsType" label="goodsType"></s:textfield>
		<s:submit></s:submit>
	</s:form>
</body>
</html>