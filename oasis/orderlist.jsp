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
		<c:when test="${not empty orderList}">
			<c:forEach var="pickup" items="${orderList}">
				<div>
					<table>
						<tr>
							<c:choose>
								<c:when test="${pickup.status eq '픽업대기'}">

									<td><img src="./img/load.png" width="100px" height="100px"
										alt="사진 없음"></td>
									<td><c:out value="${pickup.status}" /><a
										href="./orderdetailed?idx=<c:out value="${pickup.idx}" />&status=<c:out value="${pickup.status}" />">상세정보</a>
									</td>
								</c:when>
								<c:when test="${pickup.status eq '배달중'}">

									<td><img src="./img/sending.png" width="100px"
										height="100px" alt="사진 없음"></td>
									<td><c:out value="${pickup.status}" /><a
										href="./orderdetailed?idx=<c:out value="${pickup.idx}" />&status=<c:out value="${pickup.status}" />">상세정보</a>
									</td>
								</c:when>
								<c:otherwise>

									<td><img src="./img/ok.png" width="100px" height="100px"
										alt="사진 없음"></td>
									<td><c:out value="${pickup.status}" /><a
										href="./orderdetailed?idx=<c:out value="${pickup.idx}" />&status=<c:out value="${pickup.status}" />">상세정보</a>
									</td>
								</c:otherwise>
							</c:choose>

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
							<c:choose>
								<c:when test="${pickup.status eq '배달완료'}">
									<td><a
										href="./evaluation?idx=<c:out value="${pickup.idx}" />">평가하기</a></td>
									<td></td>
								</c:when>

								<c:otherwise>

								</c:otherwise>
							</c:choose>


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