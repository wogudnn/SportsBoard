<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>modify</title>
<link rel="stylesheet" type="text/css" href="/SportsBoard/css/layout.css">
<script type="text/javascript" src="/SportsBoard/js/jquery-3.1.1.js" ></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#backBtn").click(function(){
			location.href="/SportsBoard/board/list"
		});
		
		$("#modifyBtn").click(function(){
			if($("#subJect").val()==""){
				alert("제목을 입력하세요");
				return;
			}
			
			if($("#content").val()==""){
				alert("내용을 입력하세요");
				return;
			}
			
			$("#modifyForm").attr({
				"method": "post",
				"action": "/SportsBoard/board/doModify?articleId=${articlesVO.sportsArticleId}"
			}).submit();
			
		});
		
	});
</script>
</head>
<body>
	<div id="wrapper">
		<form id="modifyForm" name="modifyForm">
			<div>
				<input type="text" id="subJect" name="subJect"
					placeholder="제목을 입력하세요" value="${articlesVO.sportsArticleSubject}" />
			</div>
			<div>
				<textarea id="content" name="content" placeholder="내용을 입력하세요" >
				${articlesVO.sportsArticleContent}</textarea>
			</div>
			<div style="margin-top: 5px">
				<div class="lefr">
					<input type="file" id="file">
				</div>
				<div class="right">
					<div class="inline">
						<input type="button" id="backBtn" value="뒤로가기">
					</div>
					<div class="inline">
						<input type="button" id="modifyBtn" value="수정">
					</div>
				</div>
				<div class="clear"></div>
			</div>
		</form>
	</div>
</body>
</html>