<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
 <head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="css.css">
  <title>주문 상세정보</title>
  <script src="./jquery.js"></script>
 </head>
 <body>
    
    <div class="order_detail_title">주문 상세정보
    </div>
    
    <div class="order_detail_adress_top">주소 정보</div>
    <div class="order_detail_adress_start_title">출발지</div>
    <div class="order_detail_adress_start_wrap">
        <div class="order_detail_adress_start_letter">
            <c:out value="${reservation.departure}" /><c:out value="${reservation.details_departure}" /></div>
    </div>

    <div class="order_detail_adress_arrive_title">도착지</div>
    <div class="order_detail_adress_arrive_wrap">
        <div class="order_detail_adress_arrive_letter">
            <c:out value="${reservation.destination}" /><c:out value="${reservation.details_destination}" /></div>
    </div>
    <div class="pickup_list_content_wrapp">
        <!-- article 반복 하면 됩니다. -->
        <article>
            <div class="pickup_list_data_wrap">
                <ul>
                    <li>주문번호: <span><c:out value="${reservation.idx}" /></span></li>
                    <li>주문정보: <span><c:out value="${reservation.text}" /></span></li>
                    <li>주문일시: <span><c:out value="${reservation.start_time}" /></span></li>
                    <li>상태: <span><c:out value="${reservation.status}" /></span></li>
                    <li>결제금액: <span><c:out value="${reservation.reward}" /></span></li>
                    <li>요청사항: <span><c:out value="${reservation.requested}" /></span></li>
                </ul>
                <br>
            </div>

        </article>
        
    </div>

<button class="order_detail_contact_btn" onclick="document.location.href='https://map.kakao.com/link/map/<c:out value="${reservation.departure}" />,<c:out value="${reservation.departure_lat}" />,<c:out value="${reservation.departure_lon}" />'">경로 확인하기</button>
<button class="order_detail_contact_btn" onclick="document.location.href='tel:<c:out value="${pickdownPhone}" />'">주문자에게 연락하기</button>
<button class="order_detail_contact_btn" onclick="document.location.href='./changestatus?idx=<c:out value="${reservation.idx}" />&status=<c:out value="${reservation.status}" />'">상태 변경하기</button>
<button class="order_detail_contact_btn" onclick="document.location.href='./cancelpickup?idx=<c:out value="${reservation.idx}" />'">픽업취소 요청하기</button>


 </body>
</html>