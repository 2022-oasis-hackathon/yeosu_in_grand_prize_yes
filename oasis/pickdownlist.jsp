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





<c:choose>
		<c:when test="${not empty pickdownlist}">
			<c:forEach var="pickup" items="${pickdownlist}">
				<div>
					<table>
						<tr>
							<td><img src="<c:out value="${pickup.profile}" />" width="100px" height="100px" alt="사진 없음"></td>
							<td><c:out value="${pickup.name}" /></td>
						</tr>
						<tr>
							<td><b>출발지: </b></td>
							<td><c:out value="${pickup.departure}" /> <c:out
									value="${pickup.details_departure}" /></td>
						</tr>
						<tr>
							<td><b>도착지: </b></td>
							<td><c:out value="${pickup.destination}" /> <c:out
									value="${pickup.details_destination}" /></td>
						</tr>
						<tr>
							<td><b>출발 예정 시간: </b></td>
							<td><c:out value="${pickup.start_time}" /></td>
						</tr>
						<tr>
							<td><b>상태: </b></td>
							<td><c:out value="${pickup.status}" /></td>
						</tr>
						<tr>
							<td><a href="#">경로확인</a></td>
							<td><a href="./pickupdetailed?idx=<c:out value="${pickup.idx}" />&status=<c:out value="${pickup.status}" />">상세정보</a> </td>
						</tr>
					</table>
				</div>
			</c:forEach>
		</c:when>

		<c:otherwise>
			비었습니다.
		</c:otherwise>
	</c:choose>







</body>
</html>