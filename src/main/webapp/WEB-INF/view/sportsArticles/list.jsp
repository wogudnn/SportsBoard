<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/SportsBoard/css/layout.css" />
<link rel="stylesheet" type="text/css" href="/SportsBoard/css/grid.css" />
<script type="text/javascript" src="/SportsBoard/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<h2>SPORTS</h2>
	<hr />

	<div id="list">
		<div id="wrapper">
			<table class="grid">
				<tr>
					<th>글 번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
					<th>추천수</th>
				</tr>

				<c:if test="${empty articles}">
					<tr>
						<td colspan="6">등록된 게시글이 없습니다.</td>
					</tr>
				</c:if>
				<c:forEach items="${articles}" var="article">
					<tr>
						<c:set var="number"
							value="${fn:split(article.sportsArticleId, '-')[2]}" />
						<fmt:parseNumber var="number" type="number" value="${number}" />
						<td>${number}</td>
						<td><a
							href="/SportsBoard/board/detail?articleId=${article.sportsArticleId}">
								${article.sportsArticleSubject}</a></td>
						<td>${article.userVO.nickName}</td>
						<td>${article.createDate}</td>
						<td>${article.hitCount}</td>
						<td>${article.recommedCount}</td>
					</tr>
				</c:forEach>
			</table>
			<div style="padding-top: 5px">
				<div class="left">
					<a href="/SportsBoard/board/write">글쓰기</a>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>
</body>
</html>