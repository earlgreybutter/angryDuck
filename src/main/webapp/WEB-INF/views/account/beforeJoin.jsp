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
			// 회원가입 버튼을 눌렀을 때
			$("#btnSelectRole").click(function(){
				if($("input:radio[name='role']").is(":checked")==false){
					alert("회원 유형을 선택해주세요");
					return;
				}
				document.form1.action = "${path}/account/join";
				document.form1.submit();
			});
		});
	</script>
</head>
<body class="w3-light-grey">
	<%@ include file="../include/side_menu.jsp" %>
	<div class="w3-display-container w3-grayscale-min slideBackground00">
	</div>
	<div class="w3-display-container w3-grayscale-min slideBackground01">
	</div>
	<div class="w3-display-container w3-grayscale-min slideBackground02">
	</div>
	
	<div class="w3-padding-large w3-display-middle" id="main_forMargin">
		<div class="w3-container w3-white w3-round-xxlarge w3-opacity-min" style="padding:32px 16px">
			<div id="formCenter">
				<div class="w3-card w3-white w3-padding">
					<br>
					<h3 class="w3-center w3-xlarge">회원 유형</h3>
					<br>
					<form name="form1" method="post">
						<table align="center">
							<tr>
								<td>
									<h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="role" value="performer">연주자
									&nbsp;&nbsp;&nbsp;
									<input type="radio" name="role" value="recruiter">주최자&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h4>
								</td>
							</tr>
								<td><br></td>
							<tr>
							</tr>
							<tr>
							</tr>
							<tr>
								<td><h4 class="w3-center"><button id="btnSelectRole">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;확인&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button></h4></td>
							</tr>
							</table>
					</form>
				</div>
			</div>
		</div>
		</div>
</body>
</html>