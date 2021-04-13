<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
<H1>게시판</H1>

<form action="/board/register" method="post">
	<table border=1>
		<tr><td>제목</td><td><input type=text name=title></td></tr>
		<tr><td>내용</td><td><textarea name=content></textarea></td></tr>
		<tr><td>작성자</td><td><input type="text" name="writer"></td></tr>
	</table>
	<input type=submit value="제출">
</form>
</body>
</html>