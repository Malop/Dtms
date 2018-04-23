<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:set var="basePath" value="${pageContext.request.contextPath }" />

<!-- 单一页面不用写html,head,body标签 -->
<div class="panel panel-default">
	<div class="panel-body" style="padding-left:0px;padding-right:15px">
		<form id="query_form" class="form-horizontal">
			<div class="form-group form-group-sm">
				<label class="control-label col-sm-1" for="userid">用户号</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="userid">
				</div>
				<label class="control-label col-sm-1" for="username">用户名</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="username">
				</div>
				<label class="control-label col-sm-1" for="query_cretId">其他查询条件</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="query_cretId" readonly>
				</div>
			</div>
		</form>
		<div id="toolbar" class="btn-toolbar pull-right" style="margin-bottom:3px">
			<button id="btn_query" type="button" class="btn btn-success btn-sm">
				<span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
			</button>
			<button id="btn_create" type="button" class="btn btn-success btn-sm">
	            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
	        </button>
			<button id="btn_info" type="button" class="btn btn-success btn-sm">
	            <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>详情
	        </button>
	        <button id="btn_update" type="button" class="btn btn-success btn-sm">
	            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
	        </button>
	        <button id="btn_delete" type="button" class="btn btn-success btn-sm">
	            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
	        </button>
		</div>
		<table id="tb_departments"></table>
	</div>
</div>


<script>
$(function () {
	var themeMap = {};
	themeMap["skin-black"] = '白暗';
	themeMap["skin-black-light"] = '白亮';
	themeMap["skin-blue"] = '蓝暗';
	themeMap["skin-blue-light"] = '蓝亮';
	themeMap["skin-green"] = '绿暗';
	themeMap["skin-green-light"] = '绿亮';
	themeMap["skin-red"] = '红暗';
	themeMap["skin-red-light"] = '红亮';
	themeMap["skin-yellow"] = '黄暗';
	themeMap["skin-yellow-light"] = '黄亮';
	themeMap["skin-purple"] = '紫暗';
	themeMap["skin-purple-light"] = '紫亮';
	
	$('#tb_departments').bootstrapTable({
        url: '${basePath}/manage/list',         //请求后台的URL（*）
        method: 'get',                      //请求方式（*）
        toolbar: '#toolbar',                //工具按钮用哪个容器
        toolbarAlign:"right",
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sortable: false,                     //是否启用排序
        sortOrder: "asc",                   //排序方式
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber:1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
        search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        strictSearch: false,
        showColumns: false,                  //是否显示所有的列
        showRefresh: false,                  //是否显示刷新按钮
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,                //是否启用点击选中行
        height: 'auto',                      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "systemId",               //每一行的唯一标识，一般为主键列
        showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
        cardView: false,                    //是否显示详细视图
        detailView: false,                   //是否显示父子表
        queryParams: function (params) {
            return {
                limit: params.limit,   //页面大小
                offset: params.offset,  //页码
                systemName: $("#username").val()
            };
        },
        columns: [
			{field: 'ck', checkbox: true},
			{field: 'userid', title: '用户号', sortable: true, align: 'center'},
			{field: 'username', title: '用户名', sortable: true, align: 'center'},
			{field: 'password', title: '密码', sortable: true, align: 'center'},
			{field: 'realname', title: '姓名', sortable: true, align: 'center'},
	    	{field: 'sex', title: '性别', sortable: true, align: 'center'},
			{field: 'phone', title: '电话', sortable: true, align: 'center'},
			{field: 'email', title: 'email', sortable: true, align: 'center'},
			{field: 'cttime', title: '创建时间', sortable: true, align: 'center'}
		],
		onLoadError : function(status, result){$.hdErrorConfirm(result.responseText);}
    });
	
	//初始化页面上面的按钮事件
    $("#toolbar #btn_query").click(function(){
        $('#tb_departments').bootstrapTable('getOptions').pageNumber = 1;
        $('#tb_departments').bootstrapTable('refresh');
    });
	$("#toolbar #btn_create").click(function(){
	    $.hdDialog({
			title: '新增系统信息',
			columnClass:'col-md-offset-2 col-md-8',//配合col-md-offset-x居中
			//containerFluid:true,//最大化
			content: 'url:${basePath}/manage/system/create',
			onClose: function(){
			    if(HdDialog.getValue()){
			    	$('#tb_departments').bootstrapTable('refresh');
			    }
			}
		});
    });
	$("#toolbar #btn_update").click(function(){
	    var rows = $('#tb_departments').bootstrapTable('getSelections');
		if (rows.length != 1) {
			$.hdConfirm({
				content: '请选择一条记录！',
				autoClose: 'cancel|3000',
				buttons: {
					cancel: {
						text: '取消'
					}
				}
			});
		} else {
		    $.hdDialog({
				title: '系统信息修改',
				columnClass:'col-md-offset-2 col-md-8',//配合col-md-offset-x居中
				//containerFluid:true,//最大化
				content: 'url:${basePath}/manage/system/update/' + rows[0].systemId,
				onClose: function(){
				    if(HdDialog.getValue()){
				    	$('#tb_departments').bootstrapTable('refresh');
				    }
				}
			});
		}
    });
	$("#btn_delete").click(function(){
		var rows = $('#tb_departments').bootstrapTable('getSelections');
		if (rows.length == 0) {
			$.hdConfirm({
				title: false,
				content: '请至少选择一条记录！',
				autoClose: 'cancel|3000',
				backgroundDismiss: true,
				buttons: {
					cancel: {
						text: '取消'
					}
				}
			});
		} else {
			$.hdConfirm({
				type: 'red',
				animationSpeed: 100,
				title: false,
				content: '确认删除所选系统吗？',
				buttons: {
					confirm: {
						text: '确认',
						btnClass: 'btn btn-danger',
						action: function () {
							HdConfirm.close();
							var ids = new Array();
							for (var i in rows) {
								ids.push(rows[i].systemId);
							}
							$.ajax({
								type: 'get',
								url: '${basePath}/manage/system/delete/' + ids.join("-"),
								success: function(result) {
									if (result.code == 1) {
										$.hdConfirm({
											title:false,
											content: '删除成功!',
											buttons: {
												confirm: {
													text:'确认',
													action:function(){
														HdConfirm.close();
														$('#tb_departments').bootstrapTable('refresh');
													}
												}
											}
										});
									} else {
										$.hdErrorConfirm(result);
									}
								}
							});
						}
					},
					cancel: {
						text: '取消',
						btnClass: 'btn btn-warning'
					}
				}
			});
		}
	});
});
</script>