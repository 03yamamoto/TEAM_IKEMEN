<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>キャンセル確認画面</title>
<link rel = "stylesheet" href = "css/stylesheet.css">
</head>
<body>
<header>
	<h1>会議室予約キャンセル</h1>
	<hr>
	<h2>キャンセル確認</h2>
</header>
<main>
	<table>
		<tr>
			<td>予約日</td>
			<td>${reservation.date}</td>
		</tr>
		<tr>
			<td>会議室</td>
			<td>${room.name}</td>
		</tr>
		<tr>
			<td>予約時刻</td>
			<td>${reservation.start}～${reservation.end}</td>
		</tr>
		<tr>
			<td>予約者</td>
			<td>${meetingRoom.user.name}</td>
		</tr>

		<tr><td></td>
		<td>
		<form action="<%=request.getContextPath() %>/cancelInput.jsp" method="post">
		<input id = "submit" type="submit" value="戻る">
		</td>
		</form>	
		</tr>
		
		<tr><td></td>
		<td>
		<form action="<%=request.getContextPath() %>/cancelServlet" method="post">
		<input id = "submit" type="submit" value="決定">
		</td>
		</form>
		</tr>	
	</table>
</main>
<footer>

</footer>
</body>
</html>