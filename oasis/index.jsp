<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
 <head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="css.css">
  <title>로그인</title>

  <script src="./jquery.js"></script>
  <script>
      
  /* 	$(document).ready(function(){
          $("input[name=num]").keyup(function(){
                var input = $("input[name=num]").val();
                if(input === num){
                    alert(num + ": 인증성공");
                }else{
                    alert(num + ": 인증실패");
                }
          });
      }); */
  
      var num;
      var email;
      
      
      function sendMail() {
          email = $('input[name=email]').val();
          
          $.post("./emailcheck", {
              email : email
          }, function(data) {
              if(data == 0){
                  alert(email + "는 없는 아이디입니다. 회원가입 해주세요!");
                  return false;
              }else{
                  $('input[name=joincheck]').val(1);
              }
          });		
          if($('input[name=joincheck]').val() == 1){
              $.post("./mailSend", {
                  email : email
              }, function(data) {
                  
                  num = data;
                  alert(email + "전송 완료!");
              });	
          }
      
      }
      
      function checkMail() {
          
          if($('input[name=joincheck]').val() == 0){
              alert(email + "는 없는 아이디입니다. 회원가입 해주세요!");
              return false;
          }
          
          if ($("input[name=num]").val() == num) {
              $("input[name=numcheck]").val(1);
              alert("성공");
          } else {
              alert("실패");
          }
      }
      
      function login() {
    	  
          var check = $('input[name=numcheck]').val();
          
          if($('input[name=joincheck]').val() == 0){
              alert(email + "는 없는 아이디입니다. 회원가입 해주세요!");
              return false;
          }
          
          if ($("input[name=num]").val() == num) {
              $("input[name=numcheck]").val(1);
          } else {
              alert("실패");
          }
          
          
          if(check == 0){
              alert('메일인증 실패!');
              return false;
          }
          
          alert('로그인성공');
          document.getElementById("frm").submit();
          return true;
      }
      
  </script>

 </head>
 <body>

  <c:if test="${not empty cookie.member.value}">
	<jsp:forward page="./membersave"></jsp:forward>
</c:if>

    <form action="./logincon" method="post" id="frm">
    <div class="login_title">
        로그인
    </div>

    <!-- 회원가입 INPUT -->
    <div class="login_input_title">이메일</div>
    <div class="login_input_wrap">
        <div class="login_email_wrap">
            <input type="text" required class="login_input_email" name="email" placeholder="이메일을 입력해 주세요.">
            <input type="button" class="login_email_btn" value="인증" onclick="sendMail()">
        </div>
    </div>

    <div class="login_input_title">이메일 인증번호</div>
    <div class="login_input_wrap">
        <div class="login_email_wrap">
            <input type="text" required class="login_input_email" name="num" placeholder="인증번호를 입력해 주세요.">
            <input type="button" class="login_email_btn" value="확인" onclick="checkMail()"/>
        </div>
    </div>
    <!-- jquery로 ajax 인증 실패 시 display block -->
    <div class="check_number_div">인증번호가 일치하지 않습니다.</div>

    <div class="login_input_wrap">
        <input type="button" class="login_submit" onclick="login()" value="확인">
    </div>

    <input type="hidden" value="0" name="numcheck">
	<input type="hidden" value="0" name="joincheck">
    </form>

    <div class="login_page_join_btn">
        &nbsp;아직 회원이 아니신가요? <b><a href="./join">회원가입</a></b> 하러가기
    </div>
 </body>
</html>