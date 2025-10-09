<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>キャンセル入力画面</title>
</head>
<body>
	<h1>会議室予約キャンセル</h1>
	<hr>
	<h2>利用日</h2>
		<form action="<%= request.getContextPath() %>/changeDateServlet" method="post">
			<input type="date" name="date" value="<% meetingRoom.date %>">
			<input type="hidden" name="page" value="cancelInput.jsp">
			<input type="submit" value="日付変更">
		</form>	
			
	<h2>キャンセル可能時間帯（<%= meetingRoom.user.name %>）</h2>
	<table>
		<tr>
			<th>会議室名/時間帯</th>
			<% for(int i=0;i<period.length;i++){%>
			<th><%= period[i]%></th>
			<% }%>
		</tr>
		
	<%	for(){%>
	
		<tr>
			<td><%= rooms[].getName() %></td>
			<% for(int i=0;i<period.length;i++){%>
			<form action="<%= request.getContextPath() %>/CancelCreate" method="post">
				<input type="hidden" name="roomId" value="<%= rooms[].getId() %>">
				<td><input type="submit" name="time" value="<%= period[i]%>"></td>
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