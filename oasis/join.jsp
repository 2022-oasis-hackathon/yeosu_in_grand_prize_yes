<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="css.css">
  <script src="./jquery.js"></script>
  <title>회원가입</title>
 </head>
 <script type="text/javascript">
    function setImageFromFile(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $(".join_profile_img").css("display","none");
                $(".join_profile").css({"background":"url("+e.target.result+")"});
            }
            reader.readAsDataURL(input.files[0]);
        }
    }

	var num;

	function check() {
        checkMail();
		var check = $('input[name=numcheck]').val();
		
		if(check == 0){
			alert('메일인증 실패');
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
			//alert("성공");
		} else {
			//alert("실패");
		}
	}

 </script>
 <body>
    <form action="./joincon" method="post" enctype="multipart/form-data" id="frm" >
    <div class="join_title">
        회원가입
    </div>

    <!-- 회원가입 프로필 사진 -->
    <div class="join_profile_wrap">
        <div class="join_profile">
            <img src="./img/user_1.png" class="join_profile_img">
            <div class="join_pofile_camera_wrap">
                <label>
                    <input type="file" name="file1" accept="image/*" onchange="setImageFromFile(this)" class="join_pofile_camera" multiple>
                    <img src="./img/premium-icon-camera-3512315_id.png">
                </label>
            </div>
        </div>
    </div>

    <!-- 회원가입 INPUT -->
    <div class="join_input_title">닉네임</div>
    <div class="join_input_wrap">
        <input type="text" required class="join_input"  name="nick" placeholder="사용할 닉네임을 입력해 주세요.">
    </div>

    <div class="join_input_title">전화번호</div>
    <div class="join_input_wrap">
        <input type="text" required class="join_input" name="phone" placeholder="전화번호를 입력해 주세요.">
    </div>

    <div class="join_input_title">이메일</div>
    <div class="join_input_wrap"> <!-- 빨강 -->
        <div class="join_email_wrap"><!-- 파랑 -->
            <input type="text" required class="join_input_email" name="email" placeholder="이메일을 입력해 주세요.">
            <input type="button" class="join_email_btn" value="인증" onclick="sendMail()">
        </div>
    </div>

    <div class="join_input_title">이메일 인증번호</div>
    <div class="join_input_wrap">
        <input type="text" required class="join_input" name="num" placeholder="인증번호를 입력해 주세요.">
        <input type="hidden" name="numcheck" value="0">
    </div>

    <div class="join_input_wrap">
        <input type="button" class="join_submit" value="확인" onclick="check()">
    </div>
    </form>
 </body>
</html>