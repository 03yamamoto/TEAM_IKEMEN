<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>退会失敗</title>
</head>
<body>
	<h1>退会に失敗しました</h1>
	<hr>
	<form action="<%=request.getContextPath() %>/menu.jsp" method="post">
		<input type="submit" value="戻る">
	</form>	
	
</body>
</html>