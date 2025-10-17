<%@page import="jp.co.seminar.util.RoomList"%>
<%@page import="jp.co.seminar.beans.RoomBean"%>
<%@page import="jp.co.seminar.beans.MeetingRoom"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% MeetingRoom Meetingroom=(MeetingRoom)session.getAttribute("meetingroom"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約入力画面</title>
<link rel = "stylesheet" href = "css/stylesheet.css">
</head>
<body>
<header>
	<h1>会議室予約</h1>
	<hr>
	<h2>利用日</h2>
	<form action="<%= request.getContextPath() %>/ChangeDateServlet" method="post">
		<input type="date" name="date" value="${meetingroom.date}"> 
		<input type="hidden" name="page" value="reserveInput.jsp"> 
		<input type="submit" value="日付変更">
	</form>

	<h2>予約可能時間帯（${meetingroom.user.name}）</h2>
</header>
<main>
	<table>
		<tr>
			<th>会議室名/時間帯</th>
			<%--Meetingroom.startPeriod("16:00")を7に変更 --%>
			<% String[] period = Meetingroom.getPeriod(); %>
			<% for(int p=0;p<period.length;p++){%>
			<th><%= period[p] %></th>
			<% }%>
		</tr>
		<%-- RoomBean[]をRoomList型に変更--%>
		<% RoomList rooms=Meetingroom.getRooms();%>
		<%	for(int i=0;i<rooms.size();i++){%>
		<tr>
			<td><%= rooms.get(i).getName() %></td>
			
			<% for(int j=0;j<period.length;j++){%>
			<form action="<%= request.getContextPath() %>/ReserveCreateServlet"
				method="post">
				<input type="hidden" name="roomId" value="<%= rooms.get(i).getId() %>">
				<td><input type="submit" name="time" value="<%= period[j] %>"></td>
			</form>
			<% }%>
		</tr>
		<%	}%>
		<tr><td></td>
		<td>
	<form action="<%= request.getContextPath()%>/menu.jsp" method="post">
		<input type="submit" value="戻る">
	</form>
		</td>
		</tr>
	</table>
</main>
<footer>

</footer>
</body>
</html>