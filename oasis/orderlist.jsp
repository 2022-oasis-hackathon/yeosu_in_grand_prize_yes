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
    <div class="pickup_list_header_wrap1">
        <ul>
            <li>
                <a href="./orderlist?where=픽업대기">
                    <div>
                        <img src="./img/load.png">
                    </div>
                    <span>픽업대기</span>
                </a>
            </li>
            <li>
                <a href="./orderlist?where=픽업중">
                    <div>
                        <img src="./img/picking.png">
                    </div>
                    <span>픽업 중</span>
                </a>
            </li>
            <li>
                <a href="./orderlist?where=배달중">
                    <div>
                        <img src="./img/sending.png">
                    </div>
                    <span>배달 중</span>
                </a>
            </li>
            <li>
                <a href="./orderlist?where=배달완료">
                    <div>
                        <img src="./img/ok.png">
                    </div>
                    <span>배달완료</span>
                </a>
            </li>
        </ul>
    </div>

    <div class="pickup_list_content_wrap">
        <!-- article 반복 하면 됩니다. -->
        <c:choose>
		<c:when test="${not empty orderList}">
			<c:forEach var="pickup" items="${orderList}">

				<article>
					<div class="pickup_list_title">
						<div class="pickup_list_img_div">
							<c:choose>
								<c:when test="${pickup.status eq '픽업대기'}">

									<img src="./img/load.png" width="80px" height="80px"
										alt="사진 없음">
								</c:when>
								<c:when test="${pickup.status eq '배달중'}">

									<img src="./img/sending.png" width="80px"
										height="80px" alt="사진 없음">
										
								</c:when>
								<c:when test="${pickup.status eq '픽업중'}">

									<img src="./img/picking.png" width="80px"
										height="80px" alt="사진 없음">
										
								</c:when>
								<c:otherwise>

									<img src="./img/ok.png" width="80px" height="80px"
										alt="사진 없음">
										
								</c:otherwise>
							</c:choose>
						</div>
						<span><c:out value="${pickup.status}" /></span>
					</div>
					<div class="pickup_list_data_wrap">
						<ul>
							<li>출발지: <span><c:out value="${pickup.departure}" />
									<c:out value="${pickup.details_departure}" /></span></li>
							<li>도착지: <span><c:out value="${pickup.destination}" />
									<c:out value="${pickup.details_destination}" /></span></li>
							<li>출발 예정 시간: <span><c:out
										value="${pickup.start_time}" /></span></li>
							<li>팁 가격: <span><c:out value="${pickup.reward}" /></span></li>
						</ul>
					</div>
					<div class="pickup_list_btn_wrap1">
						<div>
						
						
						<c:choose>
								<c:when test="${pickup.status eq '배달완료'}">

									<a href="./evaluation?idx=<c:out value="${pickup.idx}" />">평가하기</a>
								
								</c:when>
								<c:otherwise>

									<a href="https://map.kakao.com/link/map/<c:out value="${pickup.departure}" />,<c:out value="${pickup.departure_lat}" />,<c:out value="${pickup.departure_lon}" />">경로확인</a> 
										
								</c:otherwise>
							</c:choose>
						
					
								<a href="./orderdetailed?idx=<c:out value="${pickup.idx}" />">주문상세</a>
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