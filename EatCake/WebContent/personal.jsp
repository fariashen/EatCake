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

<title>"Eat Cake" 一起</title>
<meta name="description" content="Description goes here" />
<meta name="author" content="CssTemplateHeaven">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href='http://fonts.useso.com/css?family=Quicksand:300,400,700'
	rel='stylesheet' type='text/css' />
<link
	href='http://fonts.useso.com/css?family=Dosis:200,300,400,500,600,700,800'
	rel='stylesheet' type='text/css' />

<!-- jScrollPane -->
<link href="css/jquery.mCustomScrollbar.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="css/personalStyle.css" />

<link rel="stylesheet" href="css/cakesFilter.css">
<link rel="stylesheet" href="css/cakesShow.css">
</head>
<body id="homepage">

	<!-- Opener -->

	<div class="modal">
		<h1 id="testid" data-content="GET&nbsp;READY!">GET&nbsp;READY!</h1>
	</div>

	<!-- MENU AND TEXT LOGO -->

	<div class="menu collapse">

		<h1>一起</h1>
		<span>纯粹 &amp; 幸福</span>
		<nav id="cbp-fbscroller1" class="cbp-fbscroller"> 
			<a href="#fbsection1" class="cbp-fbcurrent">HOME</a> 
			<a href="#fbsection2">CAKES</a> 
			<a class="experience" href="#fbsection3">CART</a>
			<a href="#fbsection4">ORDERS</a> 
		</nav>

		<a class="tablet-close icon-menu"><i class="fa fa-align-justify"></i></a>
	</div>
	<div id="cbp-fbscroller" class="cbp-fbscroller">

		<!-- TEXT IN MIDDLE IMAGE TOP -->

		<section id="fbsection1">
		<div class="block">
			<span class="effectopacity"></span>
			<div class="tablet-logo">
				<div class="inner-tablet-logo"></div>
			</div>
		</div>
		</section>

		<!--SECTION CAKES-->

		<section id="fbsection2">
		<div class="block">
			<!-- Works -->
			<div class="inner-noslit">
				<!-- Filter Button Start -->
				<div id="puge-portfolio-filter"
					class="puge-portfolio-filter-btn-group">
					<ul>
						<li>
							<a href="#" class="selected" data-filter="*">ALL</a>
							<!-- -->
                          	<a href="#" data-filter=".testType">testType</a>
                          	<!-- --> 
                          	<a href="#" data-filter=".testRetrieve">testRetrieve</a> 
                          	<!----> 
                          	<a href="#" data-filter=".testAdd">testAdd</a> 
							<!----> 
							<a href="#" data-filter=".testUpdate">testUpdate</a></li>
					</ul>
				</div>
				<!-- Filter Button End -->

				<div class="container-fluid">
					<div class="puge-portfolio-items row fh5co-post-entry ">

						<s:iterator value="#request.goodsList">
							<article
							class="item  ${goodsType } animate-box">
								<figure> 
									<a href="checkCart-detail?goodsId=${goodsId }">
										<img src="${goodsImgPath }" alt="Image" class="img-responsive">
									</a>
								</figure> 
								<h2 class="fh5co-article-title">
									<a href="checkCart-detail?goodsId=${goodsId }">${goodsName }</a>
								</h2>
								<span class="fh5co-meta">
									<a href="checkCart-detail?goodsId=${goodsId }">${goodsPrice }元</a>
								</span>
								
								<span class="fh5co-meta fh5co-date">${goodsBrief }</span> 
							</article>
						</s:iterator>
						
						<div
							class="clearfix visible-lg-block visible-md-block visible-sm-block visible-xs-block">
						</div>

					</div>
				</div>

			</div>
			<!-- Works End -->
		</div>
		</section>

		<!-- SECTION  CART-->

		<section class="about" id="fbsection3">
		<div class="block">
			<div id="content_1" class="inner-noslit">
				
				<header>购物车</header>
				
				<div class="services pack-service">
					<div class="service">
						<s:if 
							test="#session.cartVoList == null || #session.cartVoList.size()==0">
							<div class="service-detail">
									<h6>购物车为空</h6>
							</div>
						</s:if>
						<s:else>
							<s:iterator value="#session.cartVoList" var="cart">
								<div class="service-detail">
									<h6><a href="checkCart-detail?goodsId=${cart.goodsId }">${cart.goodsName }</a></h6>
									<p>数量：${cart.num }</p>
								</div>
							</s:iterator>
							<header>
								<a href="<%=contextPath%>/view/clearingCart.jsp">结算</a>
							</header>
						</s:else>
						
					</div>
				</div>

				<div class="clear"></div>
				
			</div>
		</div>
		</section>

		<!-- SECTION ORDERS -->

		<section class="experience" id="fbsection4">
		<div class="block">
			<div class="inner-noslit">
				<header>订单信息</header>
				
				<s:if test="#request.orderVoList == null || #request.orderVoList.size() < 0">
					<p class="exp-company">
					<i class="fa fa-camera-retro"></i> 暂无订单信息！
					</p>
				</s:if>
				
				<s:else>
					<s:iterator value="#request.orderVoList" var="order">
						<p class="exp-title">
							<a href="checkOrder-detail?orderId=${order.orderId }">
							订单编号：${order.orderId }</a>
							<span class="duration">
								<i class="fa fa-calendar color"></i> 
								支付状态：${order.orderStatus }
							</span>
						</p>
						<p class="exp-company">
							<i class="fa fa-camera-retro"></i> 
							收货地址：${order.address }
						</p>
						<p>联系电话：${order.phone }</p>
					</s:iterator>
				</s:else>
				
			</div>
		</div>
		</section>

	</div>
	<script src="js/js/jquery.min.js"></script>
	<script src="js/layout.js" type="text/javascript"></script>

	<!-- the jScrollPane script -->
	<script type="text/javascript"
		src="js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="js/personalJs.js" type="text/javascript"></script>


	<script src="js/js/modernizr.min.js"></script>
	<script src="js/js/jquery.min.js"></script>
	<script src="js/js/bootstrap.min.js"></script>
	<script src="js/js/jquery.easing.js"></script>
	<script src="js/js/jquery.scrollUp.min.js"></script>
	<script src="js/js/jquery.magnific-popup.min.js"></script>
	<script src="js/js/owl.carousel.min.js"></script>
	<script src="js/js/isotope.pkgd.min.js"></script>
	<script src="js/js/jquery.stellar.min.js"></script>
	<script src="js/js/jquery.waypoints.min.js"></script>
	<script src="js/js/wow.min.js"></script>
	<script src="js/js/jquery.nav.js"></script>
	<script src="js/js/custom.js"></script>

	<script type="text/javascript" src="js/jquery.mousewheel.js"></script>
	<script src="js/jquery.fancybox.js" type="text/javascript"></script>

	<script src="js/cakesShow.js"></script>
</body>
</html>