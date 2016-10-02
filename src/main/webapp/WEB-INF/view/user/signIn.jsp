<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/SportsBoard/css/layout.css" />
<script type="text/javascript" src="/SportsBoard/js/jquery-3.1.1.js" ></script>
<script type="text/javascript">
	$(document).ready(function(){
		moveToCenter();
		signButton();
		
		var errorCode = "${errorCode}";
		if(errorCode == "1") {
			$("div.warning").html("<p>로그인에 실패했습니다.</p>");
		}
		if(errorCode == "2") {
			$("div.warning").html("<p>아이디 또는 비밀번호를 입력하세요.</p>");
		}
			
		$("#signInBtn").click(function(){
			$("#signInForm").attr({
				"method": "post",
				"action": "/SportsBoard/doSignIn"
			}).submit();
			
		});
		
		$("#email").keyup(function(){
			if($(this).val()==""){
				$(this).addClass("warning");
				$(this).removeClass("pass");
			}
			else{
				$(this).addClass("pass");
				$(this).removeClass("warning");
			}
			signButton();
		});
		
		$("#password").keyup(function(){
			if($(this).val()==""){
				$(this).addClass("warning");
				$(this).removeClass("pass");
			}
			else{
				$(this).addClass("pass");
				$(this).removeClass("warning");
			}
			signButton();
		});
		
		
	});
	
	
	$(window).resize(function() {
		moveToCenter();
	});
	
	
	function moveToCenter() {
		var windowHeight = $(window).height();
		var wrapperHeight = $("#wrapper").height();
		var middlePosition = (parseInt(windowHeight) / 2) 
								- (parseInt(wrapperHeight) / 2);
		
		$("#wrapper").css({
			"position": "relative"
			, "top": middlePosition + "px"
		});
	}
	
	function signButton(){
		if($(".pass").length==2){
			$("#signInBtn").show(500);
		}
		else{
			$("#signInBtn").hide();
		}
	}


</script>
</head>
<body>
	<div id="wrapper">
		<div class="warning"></div>
		<form id="signInForm" >
			<input type="text" id="email" name="email" placeholder="Email of ID"><br/>
			<input type="password" id="password" name="password" placeholder="Password"><br/>
			<div class="left">
				<input type="button" id="signInBtn" value="Sign In" />
			</div>
			<div class="right">
				<input type="button" id="cancelBtn" value="Cancel" />
			</div>
			<div class="clear"></div>
		</form>
	</div>
</body>
</html>