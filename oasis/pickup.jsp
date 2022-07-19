<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pickup list</title>
</head>
<body>


	<c:choose>
		<c:when test="${not empty pickuplist}">
			<c:forEach var="pickup" items="${pickuplist}">
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
							<td><b>팁 가격: </b></td>
							<td><c:out value="${pickup.reward}" /></td>
						</tr>
						<tr>
							<!-- <td><a href="https://map.kakao.com/link/map/<c:out value="${pickup.destination_lat}" />,<c:out value="${pickup.destination_lon}" />">경로확인</a></td> -->
							<td><a href="https://map.kakao.com/link/map/<c:out value="${pickup.departure}" />,<c:out value="${pickup.departure_lat}" />,<c:out value="${pickup.departure_lon}" />">도착지 확인</a></td>
							<td><a href="./pickupdetailed?idx=<c:out value="${pickup.idx}" />&status=픽업중">배달하기</a> </td>
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