<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

출발지: <c:out value="${reservation.departure}" /><c:out value="${reservation.details_departure}" /><br>
도착지: <c:out value="${reservation.destination}" /><c:out value="${reservation.details_destination}" /><br>

주문번호: <c:out value="${reservation.idx}" /><br>
주문정보: <c:out value="${reservation.text}" /><br>
출발예정시간: <c:out value="${reservation.start_time}" /><br>
상태: <c:out value="${reservation.status}" /><br>
금액: <c:out value="${reservation.reward}" /><br>
요청사항: <c:out value="${reservation.requested}" /><br>

<a href="tel:<c:out value="${requestScope.pickupPhone}" />">배달원에게 연락하기</a>

</body>
</html>