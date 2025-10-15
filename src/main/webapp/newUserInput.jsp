<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規ユーザー登録</title>
<link rel = "stylesheet" href = "css/stylesheet.css">
</head>
<body>
	<h1>新規ユーザー登録内容</h1>
	<hr>
	<form action="<%= request.getContextPath() %>/InputServlet" method="post">
	<table>
		<tr>
		<td>利用者ID:</td>
		<td><input type="text" name="userId" required></td>
		</tr>
		<tr>
		<td>パスワード:</td>
		<td><input type="text" name="userPw" required></td>
		</tr>
		<tr>
		<td>利用者名:</td>
		<td><input type="text" name="userName" required></td>
		</tr>
		<tr>
		<td>住所(都道府県名):</td>
		<td><input type="text" name="userAdd" required></td>
		</tr>
	</table>
		<input type="submit" value="登録">
	</form>
	<form action="<%=request.getContextPath() %>/login.jsp" method="post">
		<input type="submit" value="戻る">
	</form>	
</body>
</html>