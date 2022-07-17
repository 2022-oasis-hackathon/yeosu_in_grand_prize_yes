<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<script src="./jquery.js"></script>
<script>
	var num;

	function check() {
		var check = $('input[name=numcheck]').val();
		
		if(check == 0){
			alert('메일인증을 받아주세요!');
			return false;
		}
		
		alert('가입성공');
		document.getElementById("frm").submit();
		return true;
	}
	
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

	function checkMail() {
		if ($("input[name=num]").val() == num) {
			$("input[name=numcheck]").val(1);
			alert("성공");
		} else {
			alert("실패");
		}
	}
</script>

</head>
<body>
	<form action="./joincon" method="post" enctype="multipart/form-data" id="frm">
		<p>
			사진: <input type="file" name="file1" multiple>
		<p>
			메일: <input type="text" name="email"> <input type="button"
				value="인증" onclick="sendMail()" />
		<p>
			인증번호: <input type="number" name="num" max="9999"> <input
				type="button" value="확인" onclick="checkMail()" />
		<p>
			닉네임: <input type="text" name="nick">
		<p>
			전화번호: <input type="text" name="phone"> 
			<input type="hidden" value="0" name="numcheck">
			<input type="button" value="가입하기" onclick="check()">
				
	</form>
</body>
</html>