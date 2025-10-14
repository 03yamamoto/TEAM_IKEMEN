<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<h1>会議室予約</h1>
	<hr>
	<h2>ログイン</h2>
	<form action="<%= request.getContextPath() %>/LoginServlet" method="post">
	<table>
		<tr>
		<td>利用者ID:</td>
		<td><input type="text" name="userId" required></td>
		</tr>
		<tr>
		<td>パスワード:</td>
		<td><input type="password" name="userPw" required></td>
		</tr>
	</table>
		<input type="submit" value="ログイン">
	</form>
</body>
</html>