<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel = "stylesheet" href = "css/stylesheet.css">
</head>
<body>
<header>
	<h1>会議室予約</h1>
	<hr>
</header>
<main>
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
		<tr><td></td>
		<td>
		<input id = "submit" type="submit" value="ログイン">
		</td>
		</tr>
	</form>

		<tr><td></td>
		<td>
	<form action="<%= request.getContextPath() %>/newUserInput.jsp" method="post">
		<input id = "submit" type="submit" value="新規登録">
		</td>
		</tr>
	</form>
	</table>
</main>
</body>
</html>