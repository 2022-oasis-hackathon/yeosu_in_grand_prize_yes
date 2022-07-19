<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
 <head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="css.css">
  <title>픽업취소</title>
  <script src="./jquery.js"></script>
 </head>
 <script>
    $(document).ready(function(){
        $(".cancelPickup_select_btn").click(function(){
            $(".modal_back").fadeIn();
        });

        $(".cancelPickup_modal_box ul li").click(function(){
            var list_data = $(this).text();
            $(".cancelPickup_select_btn").text(list_data);
            $(".modal_back").css("display","none");
            $(".cancelPickup_select_btn").css("border","1px solid #34cea1");
            $(".cancelPickup_input_hidden").val(list_data);
        });
    });
 </script>
 <body>
    <div class="modal_back">
        <div class="cancelPickup_modal_box">
            <ul>
                <li>재난</li>
                <li>사고</li>
                <li>배송 불가 지역</li>
                <li>상품 미확인</li>
                <li>상품 분실/도난</li>
            </ul>
        </div>
    </div>
    <form action="./cancelpickupcon?idx=<c:out value="${param.idx}"/>" method="post">
    <div class="cancelPickup_title">
        픽업취소
    </div>
    <div class="cancelPickup_text">
        픽업을 취소하실 건가요?<br>
        <span>취소 사유</span>를 작성해 주세요!
    </div>

    <!-- 픽업취소 INPUT -->
    <div class="join_input_title">사유종류</div>
    <div class="cancelPickup_input_wrap">
        <div class="cancelPickup_select_btn">
            <img src="./img/add.png"> 취소 사유 선택하기
        </div>
    </div>

    <div class="join_input_title">사유내용</div>
    <div class="cancelPickup_textarea_wrap">
        <textarea name="text" required class="cancelPickup_textarea" placeholder="사유 가능 범위 : 재난 및 사고 혹은 배달 상품이 없는 경우, 혹은 배달이 어려운 지역인 경우 취소 사유로 인정됩니다."></textarea>
    </div>

    <div class="cancelPickup_input_wrap">
        <input type="hidden" name="reason" class="cancelPickup_input_hidden">
        <input type="submit" class="cancelPickup_submit" value="픽업 취소 신청하기">
    </div>
    </form>
 </body>
</html>