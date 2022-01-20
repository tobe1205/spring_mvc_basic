<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>${article.boardNo}번 게시물 내용 수정</h1>
<form action="/board/modify" method="post">
	<input type="hidden" name="boardNo" value="${article.boardNo}">
	<p>
		# 글번호: ${article.boardNo}<br>
		# 작성자: <input type="text" name="writer" value="${article.writer}"><br>
		# 제목: <input type="text" name="title" value="${article.title}"><br>
		# 내용: <textarea rows="3" name="content">${article.content}</textarea>	
		<br>
		<input type="submit" value="수정">
	</p>
</form>

<a href="/board/list">글 목록보기</a>&nbsp;


</body>
</html>



