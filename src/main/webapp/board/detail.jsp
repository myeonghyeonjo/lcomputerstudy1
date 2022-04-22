<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 상세</title>
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
		<h1>게시판 상세페이지</h1>
	<table >
		<tr>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>내용</th>
			<th>작성일시</th>
		</tr>
			 <tr>
				<td>${board.b_title}</td>
				<th>${board.b_writer}</th>
				<th>${board.b_count}</th>
				<th>${board.b_content}</th>
				<th>${board.b_date}</th>
		     <tr>
	</table>
</body>
</html>

</style>
	<tr style="height:50px;">
		<td style="border:none;">
			<a href="${path}/lcomputerstudy1/board-edit.do?b_idx=${board.b_idx}"	style="width:70%;font-weight:700;background-color:#818181;color:#fff;" >수정</a>
		</td>
		<td style="border:none;">
			<a href="${path}/lcomputerstudy1/board-deleteprocess.do?b_idx=${board.b_idx}"	style="width:70%;font-weight:700;background-color:#818181;color:#fff;" >삭제</a>
		</td>
	</tr>



