<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>商品详情</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Free HTML5 Template by FREEHTML5" />
<meta name="keywords"
	content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />




<!-- Facebook and Twitter integration -->
<meta property="og:title" content="" />
<meta property="og:image" content="" />
<meta property="og:url" content="" />
<meta property="og:site_name" content="" />
<meta property="og:description" content="" />
<meta name="twitter:title" content="" />
<meta name="twitter:image" content="" />
<meta name="twitter:url" content="" />
<meta name="twitter:card" content="" />

<!-- Google Fonts -->
<link
	href='http://fonts.googleapis.com/css?family=Playfair+Display:400,700,400italic|Roboto:400,300,700'
	rel='stylesheet' type='text/css'>
<!-- Animate -->
<link rel="stylesheet" href="cakeDetail/css/animate.css">
<!-- Icomoon -->
<link rel="stylesheet" href="cakeDetail/css/icomoon.css">
<!-- Bootstrap  -->
<link rel="stylesheet" href="cakeDetail/css/bootstrap.css">

<link rel="stylesheet" href="cakeDetail/css/style.css">

</head>
<body>

	<header id="fh5co-header">

	<div class="container-fluid">

		<div class="row">
			<div class="col-lg-12 col-md-12 text-center">
				<h1 id="fh5co-logo">
					<a href="login-returnPage">一起 <sup>返回</sup></a>
				</h1>
			</div>

		</div>

	</div>

	</header>
	<a href="addCart?goodsId=${goods.goodsId }&userName=${userName }" class="fh5co-post-prev"><span><i
			class="icon-shopping-cart"></i> 加入购物车</span></a>
			
	<a href="checkOut-Immediately?goodsId=${goods.goodsId }" class="fh5co-post-next"><span>立即购买 <i
			class="icon-price-tag"></i></span></a>
	<!-- END #fh5co-header -->
	
	<div class="container-fluid">
		<div class="row fh5co-post-entry single-entry">
			<article
				class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xs-12 col-xs-offset-0">
			<figure class="animate-box"> 
			<img src="imgShow?path=${goods.goodsImgPath }"
				alt="Image" class="img-responsive"
				style="margin: 0 auto"> 
			</figure> 
			<h2 class="fh5co-article-title animate-box">
				${goods.goodsName }
			</h2>
			<span class="fh5co-meta animate-box">
				商品价格：${goods.goodsPrice } 元</span>
			
			<span class="fh5co-meta fh5co-date animate-box">商品类型：${goods.goodsType }</span>

			<div
				class="col-lg-12 col-lg-offset-0 col-md-12 col-md-offset-0 col-sm-12 col-sm-offset-0 col-xs-12 col-xs-offset-0 text-left content-article">
				<div class="row">
					
					<div class="col-lg-4 animate-box">
						<div class="fh5co-highlight right">
							<h4>详细介绍</h4>
							<p>${goods.goodsDetail }</p>
						</div>
					</div>
				</div>

			</div>
			</article>
		</div>
	</div>

	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>

</body>
</html>