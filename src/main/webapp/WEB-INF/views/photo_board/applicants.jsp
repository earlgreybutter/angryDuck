<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>GuestFinder</title>
	<%@ include file="../include/header.jsp" %>
	<script>
	function pageback(){
		history.go(-1);
	}
	</script>
</head>
<body class="w3-light-grey">
	<%@ include file="../include/side_menu.jsp" %>
	<div id="main_content">
		<!-- Header -->
		<header>
			<div class="w3-container">
				<h1>
					<b><i class="fas fa-drum w3-xxlarge"></i> Concert</b>
				</h1>
				<div class="w3-section w3-bottombar w3-padding-16">
					<div style="text-align: right;">
						<input type="button" value="뒤로가기" onclick="pageback()" class="w3-bar-item w3-button w3-black w3-hover-grey">
					</div>
				</div>
			</div>
			
		</header>
		<b>&nbsp;&nbsp;&nbsp;&nbsp;지원자 목록입니다.</b>

		<div class="w3-container w3-white w3-margin">
			<div class="w3-padding-16">
				
				<c:forEach var="row" items="${map.applicants}">
					<div class="w3-container">
						<p>email : ${row.email}</p>
						<p>name : ${row.name}</p>
						<p>age : ${row.age} &nbsp;&nbsp;&nbsp;&nbsp; gender : ${row.gender}</p>
						<p>
						instruments : 
						<c:forEach var="instrument" items="${row.instruments}">
							${instrument.name} &nbsp;
						</c:forEach>
						</p>
						<p>
						tag : 
						<c:forEach var="tag" items="${row.tags}">
							${tag.content} &nbsp;
						</c:forEach>
						</p>
						<p>자기소개 : ${row.description}</p>
					</div>
				<hr>
				</c:forEach>
			</div>
		</div>
		

		<footer>
			<div class="w3-black w3-center w3-padding-24">
				Created by <a href="${path}/contact"" class="w3-hover-opacity">angryduck</a>
			</div>
		</footer>
	</div>
</body>
</html>