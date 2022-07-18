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
	
	function sendMail() {
		var email = $('input[name=email]').val();
		
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
		
		if(check == 0){
			alert('메일인증을 받아주세요!');
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
	<p>메일: <input type="text" name="email">
	<input type="button" value="인증" onclick="sendMail()"/>
	<p>인증번호: <input type="number" name="num"  max="9999">
	<input type="button" value="확인" onclick="checkMail()"/>
	<input type="hidden" value="0" name="numcheck">
	<input type="hidden" value="0" name="joincheck">
	<input type="button" value="로그인" onclick="login()"/>
	<p><input type="button" value="회원가입" onclick="location.href='./join'"/>
</form>

</body>
</html>