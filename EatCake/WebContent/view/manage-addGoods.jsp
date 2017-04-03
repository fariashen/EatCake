<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
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
				<li><a class="active-menu" href="<%= contextPath %>/view/manage-addGoods.jsp"><i class="fa fa-bug "></i>添加商品</a></li>
				<li><a href="manageGoods-manage"><i class="fa fa-square-o "></i>管理商品</a></li>
				</ul>

			</div>

		</nav>
		<!-- /. NAV SIDE  -->

		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h1 class="page-head-line">新增商品</h1>
						<form role="form" action="manageGoods-add" method="post" enctype="multipart/form-data">
							<div class="form-group">
								<label for="goodsId"> goodsId</label>
									<input
									type="text" class="form-control" id="goodsId"
									placeholder="Enter goodsId" name="goodsId">
									
							</div>
							<div class="form-group">
								<label for="goodsName"> goodsName</label> 
									<input
									type="text" class="form-control" id="goodsName"
									placeholder="Enter goodsName" name="goodsName">
							</div>
							<div class="form-group">
								<label for="goodsBrief"> goodsBrief</label> 
									<input
									type="text" class="form-control" id="goodsBrief"
									placeholder="Enter goodsBrief" name="goodsBrief">
							</div>
							<div class="form-group">
								<label for="goodsDetail"> goodsDetail</label> 
									<input
									type="text" class="form-control" id="goodsDetail"
									placeholder="Enter goodsDetail" name="goodsDetail">
							</div>
							<div class="form-group">
								<label for="goodsImgPath"> goodsImgPath</label> 
									<input
									type="file" class="form-control" id="goodsImgPath"
									placeholder="Enter goodsImgPath" name="img">
							</div>
							<div class="form-group">
								<label for="goodsPrice"> goodsPrice</label> 
									<input
									type="text" class="form-control" id="goodsPrice"
									placeholder="Enter goodsPrice" name="goodsPrice">
							</div>
							<div class="form-group">
								<label for="goodsType"> goodsType</label> 
									<input
									type="text" class="form-control" id="goodsType"
									placeholder="Enter goodsType" name="goodsType">
							</div>
							<button type="submit" class="btn btn-success btn-block">
								<span class="glyphicon glyphicon-off"></span> 确定
							</button>
						</form>
						<h1 class="page-subhead-line"></h1>

					</div>
				</div>

			</div>
			<!-- /. PAGE INNER  -->

		</div>
		<!-- /. PAGE WRAPPER  -->

	</div>
	<!-- /. WRAPPER  -->


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