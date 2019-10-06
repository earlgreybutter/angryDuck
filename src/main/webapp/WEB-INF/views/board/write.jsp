<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>GuestFinder</title>
	<%@ include file="../include/header.jsp" %>
	<script>
$(function(){
	$("#btnBoardInsert").click(function(){
		var title=$("#title").val();
		if(title==""){
			alert("제목을 입력하세요");
			$("#title").focus();
			return;
		}
		document.form1.action="${path}/board/insert";
		document.form1.submit();
	});
});
	</script>
</head>
<body class="w3-light-grey">
	<%@ include file="../include/side_menu.jsp" %>
	<div id="main_content">
		<div class="w3-container" style="padding:32px 16px">
			<div id="formCenter">
				<div class="w3-card w3-white w3-padding">
					<h3 class="w3-center w3-xlarge">등록하기</h3>
					<img src="${path}/resources/images/about_01.jpg" class="setCenter w3-margin-bottom" style="width:30%">
					<form name="form1" action="${path}/photo_board/insert" method="post">
						<table align="center">
						
							<tr>
								<td>제목</td>
								<td>
									<input type="text" id="title" name="title"  size="70"
									placeholder="Title">
								</td>
							</tr>
							<tr><td><br></td></tr>
							 <tr>
								<td>내용</td>
								<td>
									<textarea  name="content" cols="80" rows="5"placeholder="내용을 입력하세요"></textarea>
							 	</td>
							 </tr>
							 <tr>
							 	<td colspan="2" align="center">
							 		<input type="button" id="btnBoardInsert" value="등록하기" class="w3-bar-item w3-button w3-black w3-hover-grey">
							 	</td>
							 </tr>
						</table>
					</form>
				</div>
			</div>
		</div>
		</div>
</body>
</html>