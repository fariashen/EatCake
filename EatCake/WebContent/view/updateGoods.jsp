<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String contextPath = request.getContextPath(); %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>EatCake Manage</title>

<!-- BOOTSTRAP STYLES-->
<link href="../assets/css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="../assets/css/font-awesome.css" rel="stylesheet" />
<!--CUSTOM BASIC STYLES-->
<link href="../assets/css/basic.css" rel="stylesheet" />
<!--CUSTOM MAIN STYLES-->
<link href="../assets/css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />

<style type="text/css">
form .label {
	color: #000;
}
</style>
</head>
<body>

	<div id="wrapper">
		<nav class="navbar navbar-default navbar-cls-top " role="navigation"
			style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".sidebar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.html">EAT CAKE</a>
		</div>

		</nav>
		<!-- /. NAV TOP  -->

		<nav class="navbar-default navbar-side" role="navigation">
		<div class="sidebar-collapse">
			<ul class="nav" id="main-menu">

				<li><a href="<%= contextPath %>/view/manage.jsp"><i
						class="fa fa-dashboard "></i>Dashboard</a></li>
				<li><a href="<%= contextPath %>/view/manage-addUser.jsp"><i class="fa fa-flash "></i>新增会员 </a></li>
				<li><a href="<%= contextPath %>/view/manage-deleteUser.jsp"><i class="fa fa-anchor "></i>删除会员</a></li>
				<li><a href="<%= contextPath %>/view/manage-addGoods.jsp"><i class="fa fa-bug "></i>添加商品</a></li>
				<li><a class="active-menu" href="manageGoods-manage"><i class="fa fa-square-o "></i>管理商品</a></li>
			</ul>

		</div>

		</nav>
		<!-- /. NAV SIDE  -->

		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h1 class="page-head-line">更新商品信息</h1>

						<s:form action="manageGoods-update" method="post">
							<s:textfield name="goodsId" label="goodsId" readonly="true"></s:textfield>
							<s:textfield name="goodsName" label="goodsName"></s:textfield>
							<s:textfield name="goodsBrief" label="goodsBrief"></s:textfield>
							<s:textfield name="goodsDetail" label="goodsDetail"></s:textfield>
							<s:textfield name="goodsImgPath" label="goodsImgPath"></s:textfield>
							<s:textfield name="goodsPrice" label="goodsPrice"></s:textfield>
							<s:textfield name="goodsType" label="goodsType"></s:textfield>
							<s:submit value="确定"></s:submit>
						</s:form>
					</div>
				</div>

			</div>
			<!-- /. PAGE INNER  -->

		</div>
		<!-- /. PAGE WRAPPER  -->

	</div>
	<!-- /. WRAPPER  -->

<%-- 	<s:form action="manageGoods-update" method="post">
		<s:textfield name="goodsId" label="goodsId" readonly="true"></s:textfield>
		<s:textfield name="goodsName" label="goodsName"></s:textfield>
		<s:textfield name="goodsBrief" label="goodsBrief"></s:textfield>
		<s:textfield name="goodsDetail" label="goodsDetail"></s:textfield>
		<s:textfield name="goodsImgPath" label="goodsImgPath"></s:textfield>
		<s:textfield name="goodsPrice" label="goodsPrice"></s:textfield>
		<s:textfield name="goodsType" label="goodsType"></s:textfield>
		<s:submit></s:submit>
	</s:form> --%>

	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script src="../assets/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="../assets/js/bootstrap.js"></script>
	<!-- METISMENU SCRIPTS -->
	<script src="../assets/js/jquery.metisMenu.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="../assets/js/custom.js"></script>

</body>
</html>