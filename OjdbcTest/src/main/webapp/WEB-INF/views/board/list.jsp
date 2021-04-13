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

<table border=1>
	<c:forEach items="${list}" var="list">
	<tr>
		<td><c:out value="${list.bno}"/></td>
		<td><c:out value="${list.title}"/></td>
		<td><c:out value="${list.writer}"/></td>
		<td><c:out value="${list.regdate}"/></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>