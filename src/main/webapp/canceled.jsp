<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>キャンセル確定画面</title>
</head>
<body>
	<h1>会議室予約キャンセル</h1>
	<hr>
	<h2>キャンセル完了</h2>
	
	<table>
		<tr>
			<td>予約日</td>
			<td><%=reservation.date %></td>
		</tr>
		<tr>
			<td>会議室</td>
			<td><%=room.name %></td>
		</tr>
		<tr>
			<td>予約時刻</td>
			<td><%=reservation.start %>～<%=reservation.end %></td>
		</tr>
		<tr>
			<td>予約者</td>
			<td><%=meetingRoom.user.name %></td>
		</tr>
	</table>
	<hr>
	<form action="<%=request.getContextPath() %>/menu.jsp" method="post">
		<input type="submit" value="完了">
	</form>	
	
</body>
</html>