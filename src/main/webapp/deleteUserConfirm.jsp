<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>退会ユーザー確認</title>
<link rel = "stylesheet" href = "css/stylesheet.css">
</head>
<body>
<header>
	<h1>退会ユーザー確認</h1>
	<hr>
</header>
<main>
	<table>
		<tr>
			<td>利用者ID:</td>
			<td>${sessionScope.id}</td>
		</tr>
		<tr>
			<td>パスワード:</td>
			<td>${sessionScope.pass}</td>
		</tr>
		<tr>
			<td>利用者名:</td>
			<td>${sessionScope.name}</td>
		</tr>
		<tr>
			<td>住所:</td>
			<td>${sessionScope.add}</td>
		</tr>
		
		<tr><td></td>
		<td>
		<form action="<%=request.getContextPath() %>/DeleteServlet" method="post">
		<input id = "submit" type="submit" value="退会">
		</td>
		</form>	
		</tr>
		
		<tr><td></td>
		<td>
		<form action="<%=request.getContextPath() %>/menu.jsp" method="post">
		<input id = "submit" type="submit" value="戻る">
		</td>
		</form>	
		</tr>
	</table>
</main>
<footer>

</footer>
</body>
</html>