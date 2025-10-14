<%@page import="jp.co.seminar.beans.RoomBean"%>
<%@page import="jp.co.seminar.beans.MeetingRoom"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約入力画面</title>
</head>
<body>
	<h1>会議室予約</h1>
	<hr>
	<h2>利用日</h2>
		<form action="<%= request.getContextPath() %>/changeDateServlet" method="post">
			<input type="date" name="date" value="${meetingRoom.date}">
			<input type="hidden" name="page" value="reserveInput.jsp">
			<input type="submit" value="日付変更">
		</form>	
			
	<h2>予約可能時間帯（${meetingRoom.user.name}）</h2>
	<table>
		<tr>
			<th>会議室名/時間帯</th>
			<%  String[] period=MeetingRoom.getPeriod();%>
			<% for(int i=0;i<period.length;i++){%>
			<th><%= period[i] %></th>
			<% }%>
		</tr>
	<% RoomBean[] rooms=MeetingRoom.getRooms();%>
	<%	for(int i=0;i<rooms.length;i++){%>
		<tr>
			<td><%= rooms[i].getName() %></td>
			<% for(int j=0;j<period.length;j++){%>
			<form action="<%= request.getContextPath() %>/ReserveCreateServlet" method="post">
				<input type="hidden" name="roomId" value="${  rooms[i].Id }">
				<td><input type="submit" name="time" value="${  period[j].Period}"></td>
			</form>
			<% }%>
		</tr>
			
	<%	}%>
	</table>
	
	<hr>
	<form action="<%= request.getContextPath()%>/menu.jsp" method="post">
	<input type="submit" value="戻る">
	</form>
</body>
</html>