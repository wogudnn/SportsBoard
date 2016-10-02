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
		
		var erroeCode = "${errorCode}";
		if(erroeCode == "1") {
			$("div.warning").html("<p>회원가입에 실패했습니다.</p>");
		}
		
		
		$("#signUpBtn").click(function(){
			$("#signUpForm").attr({
				"method": "post",
				"action": "/SportsBoard/doSignUp"
			}).submit();
			
		});
		
		
		$("#cancelBtn").click(function(){
			location.href="/SportsBoard/signUp"
			
		});
		
		$("#email").keyup(function(){
			$.post("/SportsBoard/checkEmail", 
					{"email": $("#email").val()},
					function(data){
						if(data == "false") {
							$("#email").addClass("pass");
							$("#email").removeClass("warning");
							
						}
						else {
							$("#email").removeClass("pass");
							$("#email").addClass("warning");
						}
						signButton();
					});
		});
		
		
		$("#nickname").keyup(function(){
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
		
		$("#password1").keyup(function(){
			if($(this).val() != $("#password2").val() ){
				$(this).addClass("warning");
				$(this).removeClass("pass");
				$("#password2").addClass("warning");
				$("#password2").removeClass("pass");
			}
			else if($(this).val() == "") {
				$(this).addClass("warning");
				$(this).removeClass("pass");
				$("#password2").addClass("warning");
				$("#password2").removeClass("pass");
			}
			else {
				$(this).addClass("pass");
				$(this).removeClass("warning");
				$("#password2").addClass("pass");
				$("#password2").removeClass("warning");
			}
			signButton();
		});
		
		$("#password2").keyup(function(){
			if($(this).val() != $("#password1").val() ){
				$(this).addClass("warning");
				$(this).removeClass("pass");
				$("#password1").addClass("warning");
				$("#password1").removeClass("pass");
			}
			else if($(this).val() == ""){
				$(this).addClass("warning");
				$(this).removeClass("pass");
				$("#password1").addClass("warning");
				$("#password1").removeClass("pass");
			}
			else {
				$(this).addClass("pass");
				$(this).removeClass("warning");
				$("#password1").addClass("pass");
				$("#password1").removeClass("warning");
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
		if($(".pass").length==4){
			$("#signUpBtn").show(500);
		}
		else{
			$("#signUpBtn").hide();
		}
	}


</script>
</head>
<body>
	<div id="wrapper">
		<div class="warning"></div>
		<form id="signUpForm" >
			<input type="text" id="email" name="email" placeholder="Email of ID"><br/>
			<input type="text" id="nickname" name="nickname" placeholder="Nick Name"><br/>
			<input type="password" id="password1" name="password1" placeholder="Password"><br/>
			<input type="password" id="password2" name="password2" placeholder="Password Confirm"><br/>
			<div class="left">
				<input type="button" id="signUpBtn" value="Sign Up" />
			</div>
			<div class="right">
				<input type="button" id="cancelBtn" value="Cancel" />
			</div>
			<div class="clear"></div>
		</form>
	</div>

</body>
</html>