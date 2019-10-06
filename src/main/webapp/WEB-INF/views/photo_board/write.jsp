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
	$("#btnPhoto_boardInsert").click(function(){
		var title=$("#title").val();
		var datetime =$("#datetime").val();
		var file1 = $("#file1").val();
			
		if(title==""){
			alert("제목을 입력하세요");
			$("#title").focus();
			return;
		}
		if(datetime==""){
			alert("공연날짜를 입력하세요");
			$("#datetime").focus();
			return;
		}
		if(file1==""){
			alert("이미지를 넣어주세요");
			$("#file1").focus();
			return;
		}
		if($("input:checkbox[name='instrument']").is(":checked")==false){
			alert("악기를 하나 이상 선택해 주세요");
			return;
		}
		if($("input:checkbox[name='tag']").is(":checked")==false){
			alert("태그를 하나 이상 선택해 주세요");
			return;
		}
		document.form1.action="${path}/photo_board/insert";
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
					<form name="form1" action="${path}/photo_board/insert" method="post" 
					enctype="multipart/form-data">
						<table align="center">
						
							<tr>
								<td>제목</td>
								<td>
									<input type="text" id="title" name="title"  size="80"
									placeholder="Title">
								</td>
							</tr>
							<tr><td><br></td></tr>
							<tr>
								<td>공연날짜</td>
								<td>
									<input type="datetime-local" id="datetime" name="datetime">
								</td>
							</tr>
							<tr><td><br></td></tr>
							<tr>
								<td>첨부파일</td>
								<td>
									<input type="file" id="file1" name="file1" 
									placeholder="Image"> 
							 	</td>
							 </tr>
							 <tr><td><br></td></tr>
							<tr>
								<td>지역</td>
								<td>
									<select name="region">
										<option value="서울">서울</option>
										<option value="경기도">경기도</option>
										<option value="강원도">강원도</option>
										<option value="충청북도">충청북도</option>
										<option value="충청남도">충청남도</option>
										<option value="경상북도">경상북도</option>
										<option value="경상남도">경상남도</option>
										<option value="전라북도">전라북도</option>
										<option value="전라남도">전라남도</option>
										<option value="제주도">제주도</option>
									</select>
								</td>
							</tr>
							<tr><td><br></td></tr>
							<tr>
								<td>악기</td>
								<td>
									<input type="checkbox" name="instrument" value="violin">바이올린&nbsp;
									<input type="checkbox" name="instrument" value="viola">비올라&nbsp;
									<input type="checkbox" name="instrument" value="cello">첼로&nbsp;
									<input type="checkbox" name="instrument" value="contrabass">콘트라베이스&nbsp;
									<input type="checkbox" name="instrument" value="bass">베이스&nbsp;
									<input type="checkbox" name="instrument" value="guitar">기타&nbsp;
								</td>
							</tr>
							<tr>
								<td></td>
								<td>
									<input type="checkbox" name="instrument" value="flute">플루트&nbsp;
									<input type="checkbox" name="instrument" value="oboe">오보에&nbsp;
									<input type="checkbox" name="instrument" value="clarinet">클라리넷&nbsp;
									<input type="checkbox" name="instrument" value="bassoon">바순&nbsp;
									<input type="checkbox" name="instrument" value="saxophone">색소폰&nbsp;
									<input type="checkbox" name="instrument" value="horn">호른&nbsp;
								</td>
							</tr>
							<tr>
								<td></td>
								<td>
									<input type="checkbox" name="instrument" value="trumpet">트럼펫&nbsp;
									<input type="checkbox" name="instrument" value="trombone">트롬본&nbsp;
									<input type="checkbox" name="instrument" value="drum">드럼&nbsp;
									<input type="checkbox" name="instrument" value="piano">피아노&nbsp;
									<input type="checkbox" name="instrument" value="organ">오르간&nbsp;
									<input type="checkbox" name="instrument" value="keyboard">키보드&nbsp;
								</td>
							</tr>
							<tr><td><br/></td></tr>
							<tr>
								<td>태그</td>
								<td>
									<input type="checkbox" name="tag" value="rock">락&nbsp;
									<input type="checkbox" name="tag" value="folk">포크&nbsp;
									<input type="checkbox" name="tag" value="rnb">알앤비&nbsp;
									<input type="checkbox" name="tag" value="hiphop">힙합&nbsp;
									<input type="checkbox" name="tag" value="jazz">재즈&nbsp;
									<input type="checkbox" name="tag" value="dance">댄스&nbsp;
									
								</td>
							</tr>
							<tr>
								<td></td>
								<td>
									<input type="checkbox" name="tag" value="indie">인디&nbsp;
									<input type="checkbox" name="tag" value="rap">랩&nbsp;
									<input type="checkbox" name="tag" value="ballads">발라드&nbsp;
									<input type="checkbox" name="tag" value="techno">테크노&nbsp;
									<input type="checkbox" name="tag" value="newage">뉴에이지&nbsp;
				
								</td>
							</tr>
							<tr><td><br/></td></tr>
							 <tr>
								<td>내용</td>
								<td>
									<textarea  name="content" cols="80" rows="5"placeholder="내용을 입력하세요"></textarea>
							 	</td>
							 </tr>
							 <tr>
							 	<td colspan="2" align="center">
							 		<input type="button" id="btnPhoto_boardInsert" value="등록하기" class="w3-bar-item w3-button w3-black w3-hover-grey">
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