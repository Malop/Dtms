<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
<title>Welcome! ${user.username}</title>

<!-- Font Awesome -->
<link href="${basePath}/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" >
<!-- Ionicons -->
<link href="${basePath}/resources/ionicons/css/ionicons.min.css" rel="stylesheet" >
<!-- Theme style -->
<link href="${basePath}/resources/adminlte/css/AdminLTE.min.css" rel="stylesheet" >
<!-- AdminLTE Skins. Choose a skin from the css/skins folder instead of downloading all of them to reduce the load. -->
<link href="${basePath}/resources/adminlte/css/skins/_all-skins.min.css" rel="stylesheet" >
<!-- Bootstrap 3.3.7 -->
<link href="${basePath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="${basePath}/resources/bootstrap/css/bootstrap-table.min.css" rel="stylesheet" />
<link href="${basePath}/resources/bootstrap/css/bootstrap-multiselect.css" rel="stylesheet" />
<link href="${basePath}/resources/bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet" />
<!-- jquery confirm -->
<link href="${basePath}/resources/ie/jquery-confirm.css" rel="stylesheet"/>
<link href="${basePath}/resources/common/base.css" rel="stylesheet"/>
<!-- ztree -->
<link href="${basePath}/resources/ztree/css/ztree_bootstrap.css" rel="stylesheet"/>
<!-- img-picket -->
<link href="${basePath}/resources/icon-picker/css/icon-picker.min.css" rel="stylesheet"/>

</head>
<body class="hold-transition sidebar-mini skin-green-light"><!--整体皮肤类skin-green-light -->
	<div class="wrapper">
		<header class="main-header">
			<a href="#" class="logo">
				<span id="system_name" class="logo-mini" style="font-size:12px">DTMS</span>
				<span id="system_title" class="logo-lg" style="font-size:15px"><b>XX管理系统</b></span>
			</a>
			<nav class="navbar navbar-static-top">
				<a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
					<span class="sr-only"></span>
				</a>
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<li class="dropdown messages-menu">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<i class="fa fa-envelope-o"></i>
								<span class="label label-success" id="message_count1"></span>
							</a>
							<ul class="dropdown-menu">
								<li class="header">你有<span id="message_count"></span>条信息</li>
								<li>
									<ul class="menu" id="message_list"></ul>
									<li class="footer">
										<a href="javascript:void(0);" id="view_all_message" data-url="/manage/message/index">查看全部</a>
									</li>
							</ul>
						</li>
						<li class="dropdown notifications-menu">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<i class="fa fa-bell-o"></i>
								<span class="label label-warning">1</span>
							</a>
							<ul class="dropdown-menu">
								<li class="header">你有一个通知</li>
								<li>
									<ul class="menu">
										<li><a href="#"><i class="fa fa-users text-aqua"></i>这是一个通知</a></li>
									</ul>
								</li>
								<li class="footer"><a href="#">查看全部</a></li>
							</ul>
						</li>
						<li class="dropdown tasks-menu">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<i class="fa fa-flag-o"></i>
								<span class="label label-danger">1</span>
							</a>
							<ul class="dropdown-menu">
								<li class="header">您有1个待完成任务</li>
								<li>
									<ul class="menu">
										<li>
											<a href="#">
												<h3>这是个进度条 <small class="pull-right">20%</small></h3>
												<div class="progress xs">
													<div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
														<span class="sr-only">20% 完成</span>
													</div>
												</div>
											</a>
										</li>
									</ul>
								</li>
								<li class="footer"><a href="#">查看全部</a></li>
							</ul>
						</li>
						<li class="dropdown notifications-menu">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<i class="fa fa-stack-exchange"></i>
							</a>
							<ul class="dropdown-menu">
								<li class="header">请选择系统切换</li>
								<li>
									<ul class="menu">
										<c:forEach var="system" items="${upmsSystems}" varStatus="status">
											<li>
												<a href="#" class="switch-systems" data-systemTheme="${system.theme}" data-systemid="${system.systemId}" data-systemname="${system.name}" data-systemtitle="${system.title}">
													<i class="glyphicon glyphicon-${system.icon}"></i>${system.title}
												</a>
											</li>
										</c:forEach>
									</ul>
								</li>
							</ul>
						</li>
						<li class="dropdown user user-menu">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<span class="hidden-xs">${user.realname}</span>
							</a>
							<ul class="dropdown-menu">
								<!-- User image -->
								<li class="user-header" style="height:100px">
									<p>
										${user.realname} <small>${user.phone}</small><small>${user.email}</small>
									</p>
								</li>
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a href="#" id="self-info" class="btn btn-default btn-flat">信息修改</a>
									</div>
									<div class="pull-right">
										<a href="#" id="logout" class="btn btn-default btn-flat">退出</a>
									</div>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</nav>
		</header>
		
		<aside class="main-sidebar">
			<section class="sidebar">
				<div class="user-panel" style="height:45px">
					<div class="pull-left info" style="left:5px">
						<p>${user.realname}[${user.username}]</p>
					</div>
				</div>
				<form action="#" method="get" class="sidebar-form">
					<div class="input-group">
						<input type="text" name="q" class="form-control" placeholder="搜索..."> 
						<span class="input-group-btn">
							<button type="submit" name="search" id="search-btn" class="btn btn-flat">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</form>
				<ul class="sidebar-menu" data-widget="tree">
					<c:forEach var="parentmenu" items="${listMenus}" varStatus="status">
						<c:if test="${parentmenu.parentid == 0}">
						<li class="treeview system_menus menu_${parentmenu.menuid}" >
							<a href="#"><span>${parentmenu.menuname}</span></a>
							<ul class="treeview-menu">
								<c:forEach var="childmenu" items="${listMenus}">
									<c:if test="${childmenu.parentid == parentmenu.menuid}">
										<li><a href="javascript:void(0);" data-url="${childmenu.uri}"><i class="fa fa-circle-o"></i>${childmenu.menuname}</a></li>
									</c:if>
								</c:forEach>
							</ul>
						</li>
						</c:if>
					</c:forEach>
				</ul>
			</section>
		</aside>
		<!-- 右侧主数据界面 -->
		<div class="content-wrapper">
			<section class="content" id="mainDiv" style="padding:1px;">
			</section>
		</div>
		<!-- 底部 -->
		<footer class="main-footer">
			<div class="pull-right hidden-xs">
				<b>Version</b> 1.0.0
			</div>
			<strong>Copyright &copy; 2017-2020.
			</strong> All rights reserved.
		</footer>
	</div>
</body>
</html>
<!-- jQuery 3 -->
<script src="${basePath}/resources/jquery/jquery.min.js"></script>
<script src="${basePath}/resources/jquery/jquery.cookie.js"></script>
<script src="${basePath}/resources/jquery-confirm/jquery-confirm.js"></script>
<script src="${basePath}/resources/jquery-validate/jquery.validate.min.js"></script>
<script src="${basePath}/resources/jquery-validate/messages_zh.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${basePath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="${basePath}/resources/bootstrap/js/bootstrap-table.js"></script>
<script src="${basePath}/resources/bootstrap/js/bootstrap-multiselect.js"></script>
<script src="${basePath}/resources/bootstrap/js/bootstrap-table-zh-CN.min.js"></script>
<script src="${basePath}/resources/bootstrap/js/bootstrap-datetimepicker.js"></script>
<script src="${basePath}/resources/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
<!-- AdminLTE App -->
<script src="${basePath}/resources/adminlte/js/adminlte.min.js"></script>
<script src="${basePath}/resources/common/base.js"></script>
<script src="${basePath}/resources/ztree/js/jquery.ztree.all.min.js"></script>
<!-- img-picket -->
<script src="${basePath}/resources/icon-picker/js/img-picker.js"></script>
<script src="${basePath}/resources/icon-picker/js/icon-picker.js"></script>
<!-- echarts -->
<script src="${basePath}/resources/echarts/js/echarts-all.js"></script>
<script>
var HD_CONTENT = {};//内容区域属性
var __oldTheme = '';


$(function(){
	//HdDict.init();//初始化字典项
    $("ul.treeview-menu li a[data-url]").click(function(){
		loadPage("${basePath}/"+$(this).data("url"));
	    $("ul.treeview-menu li").removeClass("active");
	    $(this).parent().addClass("active");
    });
	//初始化
    HD_CONTENT.fullHeight = $(".content-wrapper").height();
	HD_CONTENT.title = 41;
	HD_CONTENT.padding = 30;
	HD_CONTENT.height = HD_CONTENT.fullHeight - HD_CONTENT.title - HD_CONTENT.padding -4;
	HD_CONTENT.treeHeight = HD_CONTENT.height -10;
	$("#logout").click(function(){
		location.href = '${basePath}/login/logout?username=${user.username}';
	});
	$("#self-info").click(function(){
		$.hdDialog({
			 title:'用户信息修改',
			 columnClass:'col-md-offset-2 col-md-8',
			 content:'url:${basePath}/manage/user/updateSelf',
			 onClose: function(){
			 }
		});
	});
	
	$('.switch-systems').click(function () {
		var systemid = $(this).attr('data-systemid');
		var systemname = $(this).attr('data-systemname');
		var systemtitle = $(this).attr('data-systemtitle');
		var systemTheme = $(this).attr('data-systemTheme');
		$('.system_menus').hide(0, function () {
			$('.system_' + systemid).show();
		});
		$('body').removeClass(__oldTheme).addClass(systemTheme);
		__oldTheme = systemTheme;
		document.title = systemtitle;
		$('#system_name').text(systemname);
		$('#system_title').text(systemtitle);
		$.ajax({
	        type: 'get',
	        url: '${basePath}/manage/systeminfo/'+systemid,
	        success: function(result) {
				$("#mainDiv").html(result);
	        }
	    });
		var expire = new Date();
		expire.setDate(expire.getDate()+30);
		$.cookie('hdong-systemname', systemname,{expires:expire});
	});
	
	<c:if test = "${useCookieFlag==false}">
	$(".switch-systems[data-systemname='"+"${systemname}"+"']").click();
	</c:if>
	<c:if test = "${useCookieFlag==true}">
	var systemname = $.cookie('hdong-systemname');
	var chooseObj = null;
	if(systemname){
		chooseObj = $(".switch-systems[data-systemname='"+systemname+"']");
	}
	
	if(chooseObj == null || chooseObj.length==0){
		chooseObj = $(".switch-systems")[0];
	}
	chooseObj.click();
	</c:if>
	messageList();
	
	$("#view_all_message").click(function(){
		loadPage("${basePath}"+$(this).attr('data-url'));
	});


	if($.cookie('hdong-systemname') == 'mtms' || "${systemname}" == 'mtms') {
        loadPage("${basePath}/market/monitor/index");
    }

});

function messageList(){
	$.ajax({
		type: 'get',
		async: false,
		url: '${basePath}/market/message/list/',
		data: {},
		dataType: 'json',
		success: function(result) {
			if(result) {
				var htmlStr = '';
				var max = result.rows.length < 10 ? result.rows.length : 10;
				for(var i = 0; i < max; i++){
					htmlStr = htmlStr + '<li>';
					htmlStr = htmlStr + '<a href="javascript:showMessage(' + result.rows[i].messageSeqId + ',' + '\'' + result.rows[i].messageTitle + '\'' + ',' + '\'' + result.rows[i].messageContent + '\'' + ');">';
					htmlStr = htmlStr + '<h4>' + result.rows[i].messageTitle + '</h4>';
					htmlStr = htmlStr + '<p>' + result.rows[i].messageContent.substring(0,15) + '......</p>';
					htmlStr = htmlStr + '</a></li>';
				}
				$('#message_list').html(htmlStr);
				$('#message_count').text(result.total);
				$('#message_count1').text(result.total);
			}
		},
		error: function(errorMsg){
			var htmlStr = '<li>消息提醒数据查询出错，请于消息提醒菜单进行查询！</a></li>';
			$('#message_list').html(htmlStr);
		}
	});
	var t = setTimeout("messageList()", 60000*5);//避免服务器压力，消息提醒刷新时间修改为5分钟
}

function showMessage(seqId, title, content) {
	$.hdConfirm({
		title:false,
		type: 'blue',
		content: '<h4>' + title + '</h4>' + '<p>' + content + '</p>',
		buttons: {
			confirm: {
				text:'确认',
				action:function(){
					HdConfirm.close();
					$.ajax({
						type: 'post',
						url: '${basePath}/market/message/update/' + seqId + '/' + 'READ',
						success: function(result) {
							messageList();
						}
					});
				}
			}
		}
	});
}

</script>