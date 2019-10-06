<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>GuestFinder</title>
	<%@ include file="../include/header.jsp" %>
<script>
function btnLogin(){
	var email=$("#email").val();
	var password=$("#password").val();
	
	if(email==""){
		alert("이메일를 입력하세요");
		$("#email").focus();
		return;
	}
	if(password==""){
		alert("비밀번호를 입력하세요");
		$("#password").focus();
		return;
	}
	document.form1.action = "${path}/account/loginCheck";
	document.form1.submit();
}
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
		<div class="w3-container w3-white w3-opacity-min w3-round-xxlarge" style="padding:32px 16px">
			<div id="formCenter">
				<div class="w3-card w3-white w3-padding">
					<h3 class="w3-center w3-xlarge">Login</h3>
					<form name="form1" method="post">
						<table align="center">
							<tr>
								<td>이메일</td>
								<td>
									<input type="text" id="email" name="email" 
									placeholder="Email" value="${map.email}">
								</td>
							</tr>
							<tr>
								<td>비밀번호</td>
								<td>
									<input type="password" id="password" name="password" 
									placeholder="Password">  
								</td>
							<tr>
								<td colspan="2" align="center">
									<input type="button" value ="로그인" onclick="btnLogin()">
								</td>
							</tr>
							<c:if test="${message=='joinSuccess'}">
								<tr>
									<td colspan="2">
										<div style="color:red;">
											회원가입이 완료되었습니다.
										</div>
									</td>
								</tr>	
							</c:if>
							<c:if test="${map.message=='loginFail'}">
								<tr>
									<td colspan="2">
										<div style="color:red;">
											아이디와 비밀번호가 틀립니다.
										</div>
									</td>
								</tr>	
							</c:if>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>