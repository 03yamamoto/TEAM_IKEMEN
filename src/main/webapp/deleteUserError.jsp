<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>退会失敗</title>
<link rel = "stylesheet" href = "css/stylesheet.css">
</head>
<body>
<header>
	<h1>退会失敗しました(＾ω＾)</h1>
	<hr>
</header>
<main>
	<form action="<%=request.getContextPath() %>/menu.jsp" method="post">
		<input id = "submit" type="submit" value="戻る">
	</form>	
</main>
<footer>

</footer>	
</body>
</html>