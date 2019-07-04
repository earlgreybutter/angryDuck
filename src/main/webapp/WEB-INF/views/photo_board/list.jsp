<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<%@ include file="../include/header.jsp" %>
</head>
<body class="w3-light-grey">
	<%@ include file="../include/side_menu.jsp" %>
	<div class="w3-light-grey" id="main_content">
		<!-- Header -->
		<header>
			<div class="w3-container">
				<h1><b><i class="fab fa-sticker-mule"></i> My Product</b></h1>
				<div class="w3-section w3-bottombar w3-padding-16">
					<span class="w3-margin-right">Filter:</span> 
					<button class="w3-button w3-black">ALL</button>
					<button class="w3-button w3-white"><i class="fas fa-mars w3-margin-right"></i>Male</button>
					<button class="w3-button w3-white"><i class="fas fa-venus w3-margin-right"></i>Female</button>
				</div>
			</div>
		</header>
		
		<!-- First Photo Grid-->
		<div class="w3-row-padding">
			<div class="w3-third w3-container w3-margin-bottom">
				<img src="resources/images/horse01.jpg" alt="ProductImage" style="width:100%" class="w3-hover-opacity">
				<div class="w3-container w3-white">
					<p><b>Lorem Ipsum</b></p>
					<p>Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida diam non fringilla.</p>
				</div>
			</div>
			<div class="w3-third w3-container w3-margin-bottom">
				<img src="resources/images/horse02.jpg" alt="ProductImage" style="width:100%" class="w3-hover-opacity">
				<div class="w3-container w3-white">
					<p><b>Lorem Ipsum</b></p>
					<p>Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida diam non fringilla.</p>
				</div>
			</div>
			<div class="w3-third w3-container">
				<img src="resources/images/horse03.jpg" alt="ProductImage" style="width:100%" class="w3-hover-opacity">
				<div class="w3-container w3-white">
					<p><b>Lorem Ipsum</b></p>
					<p>Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida diam non fringilla.</p>
				</div>
			</div>
		</div>

		<!-- Second Photo Grid-->
		<div class="w3-row-padding">
			<div class="w3-third w3-container w3-margin-bottom">
				<img src="resources/images/horse04.jpg" alt="ProductImage" style="width:100%" class="w3-hover-opacity">
				<div class="w3-container w3-white">
					<p><b>Lorem Ipsum</b></p>
					<p>Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida diam non fringilla.</p>
				</div>
			</div>
			<div class="w3-third w3-container w3-margin-bottom">
				<img src="resources/images/horse05.jpg" alt="ProductImage" style="width:100%" class="w3-hover-opacity">
				<div class="w3-container w3-white">
					<p><b>Lorem Ipsum</b></p>
					<p>Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida diam non fringilla.</p>
				</div>
			</div>
			<div class="w3-third w3-container">
				<img src="resources/images/horse05.jpg" alt="ProductImage" style="width:100%" class="w3-hover-opacity">
				<div class="w3-container w3-white">
					<p><b>Lorem Ipsum</b></p>
					<p>Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida diam non fringilla.</p>
				</div>
			</div>
		</div>
		
		<!-- Pagination -->
		<div class="w3-center w3-padding-32">
			<div class="w3-bar">
				<a href="#" class="w3-bar-item w3-button w3-hover-black">≪</a>
				<a href="#" class="w3-bar-item w3-black w3-button">1</a>
				<a href="#" class="w3-bar-item w3-button w3-hover-black">2</a>
				<a href="#" class="w3-bar-item w3-button w3-hover-black">3</a>
				<a href="#" class="w3-bar-item w3-button w3-hover-black">4</a>
				<a href="#" class="w3-bar-item w3-button w3-hover-black">≫</a>
			</div>
		</div>

		<footer>
			<div class="w3-black w3-center w3-padding-24">Created by <a href="" class="w3-hover-opacity">kok202</a></div>
		</footer>
	</div>
</body>
</html>