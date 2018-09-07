<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:set var="basePath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">

<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet" href="${basePath}/resources/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="${basePath}/resources/font-awesome/css/font-awesome.min.css">
<style type="text/css">
body{
    background: url("${basePath}/resources/images/bglogin.jpg") no-repeat;
    background-size:100%;
}
li{
    display:inline-block;
} 
.container{
	background: rgba(255,255,255,0.2);
	width:900px;
	position: absolute;   
    top: 360px;   
    left: 50%; 
    transform: translate(-50%,30%);
}
.img3{
	width:170px;
	height:80px;
}
.img3:hover {
	width: 200px;
	height: 100px;
}
.img1{
	width:100px;
	height:80px;
}
.img1:hover {
	width: 120px;
	height: 100px;
}
</style>
</head>
<body class="hold-transition">
<div class="container">
	<div class="col-md-3"></div>
	<div class="col-md-3"><a href="${basePath}/index/indexhome"><img class="img3" src="${basePath}/resources/images/lgicr3.png" alt="" /></a></div>
	<div class="col-md-3"><a href="#"><img class="img1" src="${basePath}/resources/images/lgicr1.png" alt="" /></a></div>
	<div class="col-md-3"></div>
	<%-- 
	<div class="col-md-3"><a href="#"><img class="img4" src="${basePath}/resources/images/lgicr4.png" alt="" /></a></div>
	<div class="col-md-3"><a href="#"><img class="img2" src="${basePath}/resources/images/lgicr2.png" alt="" /></a></div> 
	--%>
</div>
<script src="${basePath}/resources/jquery/jquery.min.js"></script>
<script src="${basePath}/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
<script>
	$(function(){
		var loginUrl = "${basePath}/index/login";
		
		$('#signIn').click(function(){
			if(!$("#signInForm").valid()) return;
			$.ajax({
				url:loginUrl,
				type:'POST',
				data:{
					username : $('#username').val(),
					password : $('#password').val(),
					rememberMe : $('#rememberMe').is(':checked')
				},
				success:function(result){
					if(result.code==0000){
						console.log(result.msg);
						location.href='${basePath}'+result.msg;
					}else{
						$.hdConfirm({
							content: result.msg,
							autoClose: 'confirm|3000',
							buttons: {confirm: {text: '取消'}}
						});
					}
				},
				error:function(error){
					console.log(error);
				}
			});
		});
		
		$('#register').click(function(){
			$.hdConfirm({
				content:"暂无法注册",
				autoClose: 'confirm|3000',
				buttons:{
					confirm:{text:'确认'}
				}
			});
		});
		
		$('#forgetPassword').click(function(){
			$.hdConfirm({
				content:"请登入后再修改",
				autoClose: 'confirm|3000',
				buttons:{
					confirm:{text:'确认'}
				}
			});
		});
	});
</script>