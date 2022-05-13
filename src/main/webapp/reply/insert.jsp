<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대댓글</title>
<style>
	table {
		border-collapse:collapse;
	}
	table tr th {
		font-weight:700;
	}
	table tr td, table tr th {
		border:1px solid #818181;
		width:200px;
		text-align:center;
	}
	a {
		text-decoration:none;
		color:#000;
		font-weight:700;
	}
</style>
</head>
<body>
	
	
<form  action="reply-insert-process.do" name="reply" method="post">
<input type="hidden" name="b_idx" value="${board.b_idx}">
	<p> 글쓴이 : <input type="text" name="writer"></p>
	<p> 내용 : <input type="text" name="content"p> 
	<input type="submit" value="댓글등록"></p>
</form>


</body>
</html>