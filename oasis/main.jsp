<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="./css.css">
  <title>메인 페이지</title>
 </head>
 <body>
    <div class="main_header">
    <img src="./img/main.png" width="50px" height="30px" alt="사진 없음">
    </div>
    
    <div class="main_deliver_wrap">
        <div class="main_deliver_top_letter">배달
        </div>
         <div class="main_deliver_bottom_letter">산책하면서 돈 벌기<br> 당장에서 시작하세요!
        </div>
        <div class="main_deliver_img_wrap">
            <img src="./img/package.png" class="main_deliver_img">
        </div>
        <br>
        <button class="main_deliver_btn" onClick="location.href='././pickup?orderby='">배달 시작하기</button>
    </div>
    
    <div class="main_request_wrap">
        <div class="main_request_top_letter">배달요청
        </div>
         <div class="main_request_bottom_letter">이젠 밖에 나가지 않아도 돼요.<br>당장에서 모두 배달해드릴게요!
        </div>
        <div class="main_request_img_wrap">
            <img src="./img/loud-speaker.png" class="main_request_img">
        </div>
        <button class="main_request_btn" onClick="location.href='./address1'">배달 요청하기</button>
    </div>

    <div class="main_request_history_wrap">
        <div class="main_request_history_top_letter">주문내역
        </div>
         <div class="main_request_history_bottom_letter">픽업 요청한 주문 내역,<br>여기서 모두 확인하세요! 
        </div>
        <div class="main_request_history_img_wrap">
            <img src="./img/bill.png" class="main_request_history_img">
        </div>
        <button class="main_request_history_btn" onClick="location.href='./orderlist?where='">주문내역 확인하기</button>
    </div>

    <div class="main_pickup_history_wrap">
        <div class="main_pickup_history_top_letter">픽업내역
        </div>
         <div class="main_pickup_history_bottom_letter">상품을 픽업한 픽업 내역,<br>여기서 모두 확인하세요!
        </div>
        <div class="main_pickup_history_img_wrap">
            <img src="./img/shopping-bag_1.png" class="main_pickup_history_img">
        </div>
        <button class="main_pickup_history_btn" onClick="location.href='./pickdownlist?status='">픽업내역 확인하기</button>
    </div>

 </body>
</html>