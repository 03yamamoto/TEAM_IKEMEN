<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
</head>
<body>
	<h1>会議室予約</h1>
	<hr>
	<h2>メニュー</h2>
	
	<table>
		<form action="<%= request.getContextPath() %>/reserveInput.jsp" method="post">
			<tr>
				<td><input type="submit" value="会議室予約"></td>
			</tr>
		</form>
		<form action="<%= request.getContextPath() %>/cancelInput.jsp" method="post">
			<tr>
				<td><input type="submit" value="予約キャンセル"></td>
			</tr>
		</form>
		<form action="<%= request.getContextPath() %>/logoutServlet" method="post">
			<tr>
				<td><input type="submit" value="ログアウト"></td>
			</tr>
		</form>
	</table>
		
	
</body>
</html>