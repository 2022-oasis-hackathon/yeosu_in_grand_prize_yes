<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="./ordercon" method="post">

<p>출발지: <input type="text" name="departure" value="<c:out value="${param.departure}" />" disabled>
<input type="hidden" name="details_departure" value="<c:out value="${param.details_departure}" />" disabled>

<p>도착지: <input type="text" name="departure" value="<c:out value="${param.destination}" />" disabled>
<input type="hidden" name="details_departure" value="<c:out value="${param.details_destination}" />" disabled>


<p>시작시간: <input type="datetime-local" name="strart_time">
<p>수수료: <input type="text" name="reward">
<p>주문: <input type="text" name="text">
<p>요청사항: <input type="text" name="requested">
<p><input type="submit" value="send">

</form>

</body>
</html>