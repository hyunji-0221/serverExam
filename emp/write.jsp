<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/emp/write" method="POST">
			<table border=1 style="text-align:center">
				<tr>
					<td>사번</td>
					<td><input type="text" name="empno" /></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="ename" /></td>
				</tr>
				<tr>
					<td>직무</td>
					<td><input type="text" name="job" /></td>
				</tr>
				<tr>
					<td>상사</td>
					<td><input type="text" name="mgr" /></td>
				</tr>
				<tr>
					<td>급여</td>
					<td><input type="text" name="sal" /></td>
				</tr>
				<tr>
					<td colspan="4" align="center">
					<input type="submit" value="등록">
					</td>
				</tr>
			</table>
		</form>

</body>
</html>