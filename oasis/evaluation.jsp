<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
 <head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="css.css">
  <title>배달 평가하기</title>
  <script src="./jquery.js"></script>
 </head>
 <script>
    $(document).ready(function(){

    });
 </script>
 <body>
    <form action="#" method="post">
    <div class="cancelPickup_title">
        배달 평가하기
    </div>
    <div class="cancelPickup_text">
        이번 배달은 어떠셨나요?<br>
        <span>배달 평점</span>을 남겨 주세요!
    </div>

    <!-- 배달 평가 INPUT -->
    <div class="evaluation_wrap">

        
            <div>
                <a href="./evaluationcon?idx=<c:out value="${param.idx}" />&score=-1">
                <img src="./img/free-icon-like-126473_eh.png">
                <span>별로였어요.</span>
                </a>
            </div>

        
            <div>
                <a href="./evaluationcon?idx=<c:out value="${param.idx}" />&score=1">
                <img src="./img/free-icon-like-126473.png">
                <span>좋았어요.</span>
                </a>
            </div>
        
    </div>
    </form>
 </body>
</html>