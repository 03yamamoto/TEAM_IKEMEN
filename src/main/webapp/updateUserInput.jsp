<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録情報修正</title>
</head>
<body>
	<h1>ユーザー登録情報修正</h1>
	<hr>
	
	<form action="<%= request.getContextPath() %>/UpdateServlet" method="post">
	<table>
		<tr>
		<td>利用者ID:</td>
		<td><input type="text" name="userId" value="${sessionScope.id}" required></td>
		</tr>
		<tr>
		<td>パスワード:</td>
		<td><input type="text" name="userPw" value="${sessionScope.pass}" required></td>
		</tr>
		<tr>
		<td>利用者名:</td>
		<td><input type="text" name="userName" value="${sessionScope.name}" required></td>
		</tr>
		<tr>
		<td>住所(都道府県名):</td>
		<td><input type="text" name="userAdd" value="${sessionScope.add}" required></td>
		</tr>
	</table>
		<input type="submit" value="修正">
	</form>
	<form action="<%=request.getContextPath() %>/menu.jsp" method="post">
		<input type="submit" value="戻る">
	</form>	
</body>
</html>