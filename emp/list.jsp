<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<button onclick="location.href='/emp/write'">사원등록</button>
	<table border=1 style="text-align: center">
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>직무</th>
			<th>상사</th>
			<th>급여</th>
		</tr>
		<tr>
			<c:forEach items="${ eList }" var="item">
				<c:url value="/emp" var="murl" />
				<tr>
					<td><a href="/emp/remove?empno=${ item.empno }">${ item.empno }</a></td>
					<td>${ item.ename }</td>
					<td>${ item.job }</td>
					<td><a href="/emp/read?empno=${ item.mgr }">${ item.mgr }</a></td>
					<td>${ item.sal }</td>
				</tr>
			</c:forEach>
		</tr>
	</table>

</body>
</html>