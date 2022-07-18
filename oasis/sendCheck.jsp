<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인증</title>
</head>
<body>
<form action="./certifiedCheck" method="post">
	<p>메일: <input type="text" name="email">
	<p>인증번호: <input type="text" name="num">
	<input type="submit" value="send">
</form>
</body>
</html>