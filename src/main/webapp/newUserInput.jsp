<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規ユーザー登録</title>
</head>
<body>
	<h1>新規登録内容</h1>
	<hr>
	
	<form action="<%= request.getContextPath() %>/newuserServlet" method="post">
	<table>
		<tr>
		<td>利用者ID:</td>
		<td><input type="text" name="userId" required="required"></td>
		</tr>
		<tr>
		<td>パスワード:</td>
		<td><input type="password" name="userPw" required="required"></td>
		</tr>
		<tr>
		<td>利用者名:</td>
		<td><input type="text" name="userName" required="required"></td>
		</tr>
		<tr>
		<td>住所(都道府県名):</td>
		<td><input type="password" name="userAddress" required="required"></td>
		</tr>
	</table>
		<input type="submit" value="ログイン">
	</form>
</body>
</html>