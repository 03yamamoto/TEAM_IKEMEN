<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約エラー画面</title>
<link rel = "stylesheet" href = "css/stylesheet.css">
</head>
<body>
<header>
	<h1>会議室予約</h1>
	<hr>
	<h2>予約エラー</h2>
	<p>${errorReason}</p>
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
	
	<hr>
		<tr><td></td>
		<td>
	<form action="<%=request.getContextPath() %>/menu.jsp" method="post">
		<input id ="submit" type="submit" value="確認">
		</td>
		</tr>
	</form>	
	</table>
</main>
<footer>

</footer>
</body>
</html>