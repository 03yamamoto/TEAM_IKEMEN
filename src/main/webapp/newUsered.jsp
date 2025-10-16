<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録成功</title>
<link rel = "stylesheet" href = "css/stylesheet.css">
</head>
<body>
<header>
	<h1>登録に成功しました</h1>
	<hr>
</header>
<main>
	<table>
		<tr>
			<td>利用者ID:</td>
			<td>${newuser.id}</td>
		</tr>
		<tr>
			<td>パスワード:</td>
			<td>${newuser.password}</td>
		</tr>
		<tr>
			<td>利用者名:</td>
			<td>${newuser.name}</td>
		</tr>
		<tr>
			<td>住所:</td>
			<td>${newuser.address}</td>
		</tr>
		<tr><td></td>
		<td>
	<form action="<%=request.getContextPath() %>/login.jsp" method="post">
		<input id = "submit" type="submit" value="戻る">
		</td>
		</tr>
	</form>	
	</table>
</main>
<footer>

</footer>
</body>
</html>