<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<s:form action="register" method="post">
		<s:textfield name="userName" label="UserName"></s:textfield>
		<s:textfield name="passWord" label="PassWord"></s:textfield>
		
		<s:submit></s:submit>
	</s:form>
</body>
</html>