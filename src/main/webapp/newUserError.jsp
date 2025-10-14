<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録失敗</title>
</head>
<body>
	<h1>登録に失敗しました</h1>
	<hr>
	<hr>
	<form action="<%=request.getContextPath() %>/newUserInput.jsp" method="post">
		<input type="submit" value="戻る">
	</form>	
	
</body>
</html>