<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録成功</title>
</head>
<body>
	<h1>登録に成功しました</h1>
	<hr>
	<table>
		<tr>
			<td>利用者ID</td>
			<td>${sessionScope.id}</td>
		</tr>
		<tr>
			<td>パスワード</td>
			<td>${sessionScope.pass}</td>
		</tr>
		<tr>
			<td>利用者名</td>
			<td>${sessionScope.name}</td>
		</tr>
		<tr>
			<td>住所</td>
			<td>${sessionScope.add}</td>
		</tr>
	</table>
	<hr>
	<form action="<%=request.getContextPath() %>/login.jsp" method="post">
		<input type="submit" value="戻る">
	</form>	
	
</body>
</html>