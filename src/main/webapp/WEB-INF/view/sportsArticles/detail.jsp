<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/SportsBoard/css/layout.css" />
<script type="text/javascript" src="/SportsBoard/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#deleteBtn").click(function() {
			if(confirm("\"${articlesVO.sportsArticleSubject}.\"를 삭제하시겠습니까?")) {

				location.href="/SportsBoard/board/doDelete?articleId=${articlesVO.sportsArticleId}"
			}
		});
		
		$("#recommendBtn").click(function(){
			if(confirm("\"${articlesVO.sportsArticleSubject}\"를 추천하시겠습니까?")) {
				
				location.href="/SportsBoard/board/doRecommend?articleId=${articlesVO.sportsArticleId}"
			}
			
		});
		
		$("#modifyBtn").click(function(){
			if(confirm("\"${articlesVO.sportsArticleSubject}\"를 수정하시겠습니까?")) {
				
				location.href="/SportsBoard/board/modify?articleId=${articlesVO.sportsArticleId}"
			}
			
		});
		
		
	});
</script>
</head>
<body>
	<div id="wrapper">
		<div id="article">
			<div id="articleHeader">
				<p>${articlesVO.sportsArticleSubject}</p>
				<div id="articleInfo">
					<span>작성자 : ${articlesVO.userVO.nickName}(${articlesVO.userVO.point})</span>
					<span>작성시간: ${articlesVO.createDate}</span>
					<span>조회수 : ${articlesVO.hitCount}</span>
					<span>추천수 : ${articlesVO.recommedCount}</span>
				</div>
			</div>
			<hr/>
			<div id="articleBody">
				${articlesVO.sportsArticleContent}
			</div>
		</div>
		<div id="articleFooter">
			<div class="right">
				<a href="javascript:void(0);" id="modifyBtn">수정</a>
				<a href="javascript:void(0);" id="recommendBtn">추천</a>
				<a href="javascript:void(0);" id="deleteBtn">삭제</a>
				<a href="/SportsBoard/board/list">목록보기</a>
			</div>
			<div class="clear"></div>
		</div>
		
	</div>

</body>
</html>