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
									<a href="single.jsp">
										<img src="${goodsImgPath }" alt="Image" class="img-responsive">
									</a>
								</figure> 
								<h2 class="fh5co-article-title">
									<a href="single.jsp">${goodsName }</a>
								</h2>
								<span class="fh5co-meta">
									<a href="single.jsp">${goodsPrice }元</a>
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
			<div id="content_1" class="inner-left">
				
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
									<h6><a href="checkCart-detail?goodsId=${goodsId }">${cart.goodsName }</a></h6>
									<p>数量：${num }</p>
								</div>
							</s:iterator>
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
				<header>EXPERIENCE</header>
				<p class="exp-title">
					Photographer<span class="duration"><i
						class="fa fa-calendar color"></i> 2012 - 2014</span>
				</p>
				<p class="exp-company">
					<i class="fa fa-camera-retro"></i> Wet Plate INC
				</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis
					vitae dapibus dolor, et eleifend turpis. Praesent pharetra odio
					lectus. Vivamus convallis, lacus vel adipiscing ultricies, urna
					quam molestie nulla, sed blandit quam neque nec felis. Etiam non
					neque eu lorem dapibus commodo. Phasellus euismod magna velit, nec
					mattis magna suscipit eget. Duis malesuada est non hendrerit
					tempor. Fusce accumsan ullamcorper diam, at dignissim mi elementum
					eget. Integer sed urna eget neque suscipit feugiat. Nam congue
					lectus vitae nunc pulvinar, at laoreet orci pellentesque. Nunc eget
					accumsan velit. Proin odio dui, molestie sed convallis non, dictum
					eu diam.</p>
				<p>Sed et diam dui. Curabitur tortor nibh, laoreet sit amet
					ipsum eu, consequat vehicula dolor. Etiam ac faucibus elit.
					Maecenas vitae adipiscing est. Proin libero purus, dapibus at ante
					eget, posuere tempus dui. Fusce porttitor nulla eget pretium
					ultrices. Suspendisse eget faucibus dui, fermentum posuere felis.
					Etiam tempus blandit dui sit amet molestie. Duis viverra risus
					mattis, pellentesque lacus nec, aliquam justo.</p>
				</p>
				<p class="exp-title second-exp">
					Alchymist<span class="duration"><i
						class="fa fa-calendar color"></i> 2010 - 2012</span>
				</p>
				<p class="exp-company">
					<i class="fa fa-flask"></i> Collodion Labs
				</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut
					pretium pellentesque semper. Vivamus pharetra condimentum sapien,
					et ultricies purus luctus semper. Lorem ipsum dolor sit amet,
					consectetur adipiscing elit. Morbi varius diam metus, sed auctor
					lorem vestibulum a. Vestibulum accumsan euismod scelerisque.
					Suspendisse potenti. Duis ac elit molestie tortor suscipit
					convallis. Pellentesque sed suscipit arcu.</p>
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