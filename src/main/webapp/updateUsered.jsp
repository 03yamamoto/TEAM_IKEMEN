<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修正成功</title>
</head>
<body>
	<h1>修正に成功しました</h1>
	<hr>
	<table>
		<tr>
			<td>利用者ID:</td>
			<td>${updateuser.id}</td>
		</tr>
		<tr>
			<td>パスワード:</td>
			<td>${updateuser.pass}</td>
		</tr>
		<tr>
			<td>利用者名:</td>
			<td>${updateuser.name}</td>
		</tr>
		<tr>
			<td>住所:</td>
			<td>${updateuser.add}</td>
		</tr>
	</table>
	<hr>
	<form action="<%=request.getContextPath() %>/login.jsp" method="post">
		<input type="submit" value="戻る">
	</form>	
	
</body>
</html>