<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
<link rel = "stylesheet" href = "css/stylesheet.css">
</head>
<body>
<header>
	<h1>会議室予約</h1>
	<hr>
	<h2>メニュー</h2>
</header>
<main>
	<table>
		<form action="<%= request.getContextPath() %>/reserveInput.jsp" method="post">
			<tr>
				<td><input id = "submit" type="submit" value="会議室予約"></td>
			</tr>
		</form>
		<form action="<%= request.getContextPath() %>/cancelInput.jsp" method="post">
			<tr>
				<td><input id = "submit" type="submit" value="予約キャンセル"></td>
			</tr>
		</form>
		<form action="<%= request.getContextPath() %>/updateUserInput.jsp" method="post">
			<tr>
				<td><input id = "submit" type="submit" value="登録情報修正"></td>
			</tr>
		</form>
		<form action="<%= request.getContextPath() %>/LogoutServlet" method="post">
			<tr>
				<td><input id = "submit" type="submit" value="ログアウト"></td>
			</tr>
		</form>
		<form action="<%= request.getContextPath() %>/deleteUserConfirm.jsp" method="post">
			<tr>
				<td><input id = "submit" type="submit" value="退会"></td>
			</tr>
		</form>
	</table>
</main>
<footer>

</footer>	
</body>
</html>