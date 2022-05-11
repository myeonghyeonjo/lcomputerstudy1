<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 추가</title>
</head>
<body>
<h2> 답글등록 </h2>
<form action="board-reply-process.do" name="board" method="post">
	<input type="hidden" name="b_group" value="${board.b_group}">
	<p> 이름 : <input type="text" name="title"></p>
	<p> 내용 : <input type="text" name="content"></p>
	<p> <input type="submit" value="등록하기"></p>
</form>

</body>
</html>



