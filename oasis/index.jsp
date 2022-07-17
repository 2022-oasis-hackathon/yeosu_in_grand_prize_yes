<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="./jquery.js"></script>
<script>

	var num;
	
	function sendMail() {
		var email = $('input[name=email]').val();
		
		$.post("./mailSend", {
			email : email
		}, function(data) {
			num = data;
			alert(email + "전송 완료!");
		});		
	}
	
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
	
	function checkMail(){
		if($("input[name=num]").val() == num){
			alert("성공");
		}else{
			alert("실패");
		}
	}
	
</script>

</head>
<body>
	<p>메일: <input type="text" name="email">
	<input type="button" value="인증" onclick="sendMail()"/>
	<p>인증번호: <input type="number" name="num" min="4" max="4">
	<input type="button" value="확인" onclick="checkMail()"/>
	<p><input type="button" value="회원가입" onclick="location.href='./join'"/>
</body>
</html>