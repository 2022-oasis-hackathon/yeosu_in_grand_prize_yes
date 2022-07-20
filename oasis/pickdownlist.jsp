<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css.css">
  <script src="./jquery.js"></script>
<title>회원가입</title>
</head>
<body>
	<div class="pickup_list_header_wrap">
		<ul>
			<li><a href="./pickdownlist?status=픽업중">
					<div>
						<img src="./img/time.png">
					</div> <span>픽업중</span>
			</a></li>
			<li><a href="./pickdownlist?status=배달중">
					<div>
						<img src="./img/sending.png">
					</div> <span>배달중</span>
			</a></li>
			<li><a href="./pickdownlist?status=배달완료">
					<div>
						<img src="./img/premium-icon-checkmark-5372180.png">
					</div> <span>배달완료</span>
			</a></li>
		</ul>
	</div>

	<div class="pickup_list_content_wrap">
		<!-- article 반복 하면 됩니다. -->
		<c:choose>
			<c:when test="${not empty pickdownlist}">
				<c:forEach var="pickup" items="${pickdownlist}">


					<article>
						<div class="pickup_list_title">
							<div class="pickup_list_img_div">
								<img src="./img/user_1.png" alt="사진 없음">
							</div>
							<span><c:out value="${pickup.name}" /></span>
						</div>
						<div class="pickup_list_data_wrap">
							<ul>
								<li>출발지: <span><c:out value="${pickup.departure}" />
										<c:out value="${pickup.details_departure}" /></span></li>
								<li>도착지: <span><c:out value="${pickup.destination}" />
										<c:out value="${pickup.details_destination}" /></span></li>
								<li>출발 예정 시간: <span><c:out
											value="${pickup.start_time}" /></span></li>
								<li>상태: <span><c:out value="${pickup.status}" /></span></li>
							</ul>
						</div>
						<div class="pickup_list_btn_wrap">
							<div>
								<a
									href="./pickupdetailed?idx=<c:out value="${pickup.idx}" />&status=<c:out value="${pickup.status}" />">상세정보</a>
							</div>
						</div>
					</article>

				</c:forEach>
			</c:when>

			<c:otherwise>
			비었습니다.
		</c:otherwise>
		</c:choose>
	</div>
</body>
</html>