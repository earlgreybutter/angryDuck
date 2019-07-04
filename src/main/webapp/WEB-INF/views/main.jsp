<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<%@ include file="include/header.jsp" %>
</head>
<body class="w3-light-grey">
	<%@ include file="include/side_menu.jsp" %>
	<div class="w3-light-grey" id="main_content">
		<!-- full height image -->
		<div class="w3-display-container w3-grayscale-min slideBackground00"> </div>
		<div class="w3-display-container w3-grayscale-min slideBackground01"> </div>
		<div class="w3-display-container w3-grayscale-min slideBackground02"> </div>
		
		<!-- title info -->
		<div class="w3-padding-large w3-display-middle" id="main_forMargin">
			<div class="w3-container w3-center w3-white w3-opacity w3-round-xxlarge"  id="main_title" >
				<h1 class="w3-jumbo">The horse cafe</h1>
				<p>about selling horse.</p></span>
			</div>
		</div>
		
		<!-- title image button -->
		<div class="w3-center w3-container w3-section w3-large w3-text-white w3-display-bottommiddle" style="width:100%" id="main_forMargin">
			<span class="w3-badge w3-border w3-transparent w3-hover-grey" onclick="moveSlideImage(0)"></span>
			<span class="w3-badge w3-border w3-transparent w3-hover-grey" onclick="moveSlideImage(1)"></span>
			<span class="w3-badge w3-border w3-transparent w3-hover-grey" onclick="moveSlideImage(2)"></span>
		</div>
	</div>
</body>
</html>