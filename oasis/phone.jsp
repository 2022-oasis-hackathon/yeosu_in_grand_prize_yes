<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<a href="javascript:app_get_device_info('my_device_info')">디바이스 정보 알아내기</a>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>



// 콜백 함수를 만들어 주세요.
function my_device_info(info_array){
 var str = "";
 str += "\ndeviceuid : "+ info_array['deviceuid']; // 기기 고유번호
 str += "\napp_version : "+ info_array['app_version']; // 앱버젼   
 str += "\napp_version_code : "+ info_array['app_version_code']; // 앱버젼코드  // 완전 웃김... 반드시 문자열로 변환해줘야  값이 전달된다...
 str += "\nappname : "+ info_array['appname']; // APP이름
 str += "\nappversion : "+ info_array['appversion']; // APP버전
 str += "\nplatform : "+ info_array['platform']; // 운영체제
 str += "\ndevicetoken : "+ info_array['devicetoken'];
 str += "\ndevicename : "+ info_array['devicename']; // 제조사명
 str += "\ndevicemodel : "+ info_array['devicemodel']; // 디바이스 모델넘버
 str += "\ndeviceversion : "+ info_array['deviceversion']; // 디바이스 버전
 str += "\npushalert : "+ info_array['pushalert']; // 알림
 str += "\npushsound : "+ info_array['pushsound']; // 알림사운드
 str += "\nhp_num : "+ info_array['hp_num']; // 핸드폰번호
 str += "\ndevelopment : "+ info_array['development']; // 개발자 및 배포판
 
 alert(str);

}

</script>
</html>