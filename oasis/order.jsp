<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>
<html>
 <head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="css.css">
  <title>주문입력</title>

  <script src="./jquery.js"></script>
  <script>
  
  document.getElementById('currentDatetime').value= new Date().toISOString().slice(0, -1);
  
  </script>
 </head>

 <body>
    <form action="./ordercon" method="post">
    <div class="join_title">
        주문입력
    </div>

    <!-- 회원가입 INPUT -->
    <div class="join_input_title">출발지</div>
    <div class="join_input_wrap">
        <input type="text" required class="join_input"  name="departure" value="<c:out value="${param.departure}" />" disabled>
        <input type="hidden" name="details_departure" value="<c:out value="${param.details_departure}" />" disabled>
    </div>

    <div class="join_input_title">도착지</div>
    <div class="join_input_wrap">
        <input type="text" required class="join_input" name="departure" value="<c:out value="${param.destination}" />" disabled>
        <input type="hidden" name="details_departure" value="<c:out value="${param.details_destination}" />" disabled>
    </div>

    <div class="join_input_title">시작시간</div>
    <div class="join_input_wrap">
        <input type="datetime-local" required class="join_input" id='currentDatetime' name="strart_time">
    </div>


    <div class="join_input_title">수수료</div>
    <div class="join_input_wrap">
        <input type="text" required class="join_input" name="reward" placeholder="수수료를 입력해 주세요.">
    </div>

    <div class="join_input_title">주문</div>
    <div class="join_input_wrap">
        <input type="text" required class="join_input" name="text" placeholder="주문을 입력해 주세요.">
    </div>

    <div class="join_input_title">요청사항</div>
    <div class="join_input_wrap">
        <input type="text" required class="join_input" name="requested" placeholder="요청사항을 입력해 주세요.">
    </div>

    <div class="join_input_wrap">
        <input type="submit" class="join_submit" value="확인">
    </div>
    </form>
 </body>
</html>