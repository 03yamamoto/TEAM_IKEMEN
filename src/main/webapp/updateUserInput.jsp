<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録情報修正</title>
<link rel = "stylesheet" href = "css/stylesheet.css">
</head>
<body>
<header>
	<h1>ユーザー登録情報修正</h1>
	<hr>
</header>
<main>
	<form action="<%= request.getContextPath() %>/UpdateServlet" method="post">
	<table>
		<tr>
		<td>利用者ID:</td>
		<td><input type="text" name="userId" value="${newuser.id}" required></td>
		</tr>
		<tr>
		<td>パスワード:</td>
		<td><input type="text" name="userPw" value="${newuser.pass}" required></td>
		</tr>
		<tr>
		<td>利用者名:</td>
		<td><input type="text" name="userName" value="${newuser.name}" required></td>
		</tr>
		<tr>
		<td>住所(都道府県名):</td>
		<td><input type="text" name="userAdd" value="${newuser.add}" required></td>
		</tr>
		<tr><td></td>
		<td>
		<input id ="submit" type="submit" value="修正">
		</td>
		</tr>
	</form>
		<tr><td></td>
		<td>
	<form action="<%=request.getContextPath() %>/menu.jsp" method="post">
		<input id ="submit" type="submit" value="戻る">
		</td>
		</tr>
	</form>	
	</table>
</main>
<footer>

</footer>
</body>
</html>