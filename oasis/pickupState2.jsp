<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
 <head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="css.css">
<script src="./jquery.js"></script>
  <title>픽업상태변경</title>
 </head>
 <script type="text/javascript">
    function setImageFromFile(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                //$(".pickup_profile_img").css("display","none");
                $(".pickup_text").text("");
                $(".pickup_wrap").css({"background":"url("+e.target.result+")"});
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
 </script>
 <body>
	<form action="transit?idx=<c:out value="${param.idx}"/>&status=배달완료" method="post" enctype="multipart/form-data">
		<div class="join_title">사진첨부</div>

		<!-- 회원가입 프로필 사진 -->
		<div class="pickup_wrap">
			<label> <input type="file" name="file1" accept="image/*"
				onchange="setImageFromFile(this)" class="pickup_pofile_camera" multiple>
				<div class="pickup_profile">
					<img src="./img/premium-icon-camera-3512315.png"
						class="pickup_profile_img">
				</div>
			</label>
			<div class="pickup_text">
				            <b>배달 완료한 사진</b>을 찍어주세요!<br>
            <span>예) 배달 물품을 현관 앞에 둔 사진</span>
			</div>
		</div>

		<div class="join_input_wrap">
			<input type="submit" class="join_submit" value="픽업 상태 변경하기">
		</div>
	</form>
</body>
</html>