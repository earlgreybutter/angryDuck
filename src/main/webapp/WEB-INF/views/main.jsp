<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GuestFinder</title>
<%@ include file="include/header.jsp"%>
<script>
 function accountDelete(){
	if(confirm("정말 탈퇴하시겠습니까?")){
		location.href="${path}/account/delete";
	}
} 
</script>

</head>
<body class="w3-light-grey">
	<%@ include file="include/side_menu.jsp"%>
	<!-- full height image -->
	<div class="w3-display-container w3-grayscale-min slideBackground00">
	</div>
	<div class="w3-display-container w3-grayscale-min slideBackground01">
	</div>
	<div class="w3-display-container w3-grayscale-min slideBackground02">
	</div>

	<!-- title info -->
	<div class="w3-padding-large w3-display-middle" id="main_forMargin">
		<div
			class="w3-container w3-center w3-white w3-opacity w3-round-xxlarge"
			id="main_title">
			<h1 class="w3-jumbo">GuestFinder</h1>

			<c:choose>
				<c:when test="${sessionScope.id==null}">
					<table align="center">
						<tr>
							<td colspan="3">
								<a href="${path}/account/login"><button>로그인</button></a>
							</td>
						</tr>
						<tr>
							<td><a href="">아이디</a>·
							<a href="">비밀번호찾기</a></td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td><a href="${path}/account/beforeJoin">회원가입</a></td>
						</tr>
						<c:if test="${message=='accountLogout'}">
						<tr>
							<td colspan="3">
								<div style="color:red;">
									로그아웃 되었습니다.
								</div>
							</td>
						</tr>	
						</c:if>
						<c:if test="${message=='accountDelete'}">
						<tr>
							<td colspan="3">
								<div style="color:red;">
									회원탈퇴 되었습니다.
								</div>
							</td>
						</tr>	
						</c:if>
						<c:if test="${message=='sendMailSuccess'}">
						<tr>
							<td colspan="3">
								<div style="color:red;">
									메일이 발송되었습니다.
								</div>
							</td>
						</tr>	
						</c:if>
					</table>
				 </c:when>
				<c:otherwise>
					<table align="center">
						<tr>
							<td colspan="3">${sessionScope.name}(${sessionScope.role })님이 로그인 중입니다.</td>
						</tr>
						<tr>
							<td><a href="${path}/account/edit"><button>정보수정</button></a>&nbsp;&nbsp;
							<td><a href="${path}/account/logout"><button>로그아웃</button></a>&nbsp;&nbsp;</td>
							<td><input type="button" value="회원탈퇴" onclick="accountDelete()"></td>
						</tr>
						<c:if test="${message=='updateSuccess'}">
						<tr>
							<td colspan="3">
								<div style="color:red;">
									정보수정이 완료되었습니다.
								</div>
							</td>
						</tr>	
						</c:if>
						<c:if test="${message=='sendMailSuccess'}">
						<tr>
							<td colspan="3">
								<div style="color:red;">
									메일이 발송되었습니다.
								</div>
							</td>
						</tr>	
						</c:if>
					</table>
				</c:otherwise>
			</c:choose> 
			<p>Find proper performer for concert.</p>
		</div>
	</div>
	<!-- title image button -->
	<div
		class="w3-center w3-container w3-section w3-large w3-text-white w3-display-bottommiddle"
		style="width: 100%" id="main_forMargin">
		<span class="w3-badge w3-border w3-transparent w3-hover-grey"
			onclick="moveSlideImage(0)"></span> <span
			class="w3-badge w3-border w3-transparent w3-hover-grey"
			onclick="moveSlideImage(1)"></span> <span
			class="w3-badge w3-border w3-transparent w3-hover-grey"
			onclick="moveSlideImage(2)"></span>
	</div>
</body>
</html>