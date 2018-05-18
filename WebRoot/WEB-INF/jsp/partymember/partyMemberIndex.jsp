<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:set var="basePath" value="${pageContext.request.contextPath }" />

<!-- 单一页面不用写html,head,body标签 -->
<div class="panel panel-default">
	<div class="panel-body" style="padding-left:5px;padding-right:5px">
	<div class="accordion-group">
		<div class="accordion-heading">
			<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
			<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
				查询条件
			</a>
		</div>
		<div id="collapseOne" class="accordion-body collapse" style="height: 0px; ">
			<form id="query_form" class="form-horizontal">
			<div class="form-group form-group-sm">
				<label class="control-label col-md-1" for="certId">证件号</label>
				<div class="col-md-2">
					<input type="text" class="form-control" id="certId">
				</div>
				<label class="control-label col-md-1" for="partyName">党员名称</label>
				<div class="col-md-2">
					<input type="text" class="form-control" id="partyName">
				</div>
				<label class="control-label col-md-1" for="query_cretId">其他</label>
				<div class="col-md-2">
					<input type="text" class="form-control" id="query_cretId" readonly>
				</div>
				<label class="control-label col-md-1" for="query_cretId">其他</label>
				<div class="col-md-2">
					<input type="text" class="form-control" id="query_cretId" readonly>
				</div>
			</div>
			<button id="btn_query" type="button" class="btn btn-success btn-sm">
				<span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
			</button>
			<button id="btn_reset" type="button" class="btn btn-success btn-sm">
				<span class="glyphicon glyphicon-search" aria-hidden="true"></span>重置
			</button>
			</form>
		</div>
	</div>
		
		<div id="toolbar" class="btn-toolbar pull-right" style="margin-bottom:3px">
			<button id="btn_scan" type="button" class="btn btn-success btn-sm">
	            <span class="glyphicon glyphicon-inbox" aria-hidden="true"></span>扫描档案
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
	        <button id="btn_import" type="button" class="btn btn-success btn-sm">
	            <span class="glyphicon glyphicon-import" aria-hidden="true"></span>导入excel
	        </button>
		</div>
		<table id="tb_departments"></table>
	</div>
</div>


<script>
$(function () {
	
	$('#tb_departments').bootstrapTable({
        url: '${basePath}/partymember/list',     //请求后台的URL（*）
        method: 'get',                      //请求方式（*）
        toolbar: '#toolbar',                //工具按钮用哪个容器
        toolbarAlign:"right",
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sortable: false,                    //是否启用排序
        sortOrder: "asc",                   //排序方式
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber:1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
        search: false,                      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以个人感觉意义不大
        strictSearch: false,
        showColumns: false,                 //是否显示所有的列
        showRefresh: false,                 //是否显示刷新按钮
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,                //是否启用点击选中行
        height: 'auto',                     //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "userid",               	//每一行的唯一标识，一般为主键列
        showToggle:false,                   //是否显示详细视图和列表视图的切换按钮
        cardView: false,                    //是否显示详细视图
        detailView: false,                  //是否显示父子表
		showExport: true,  					//是否显示excel导出按钮 
        exportDataType:'all',				//导出数据 basic:当前页 selected:选中 all:所有
        buttonsAlign:"left",  			//按钮位置  
        exportTypes:['json', 'xml', 'csv', 'txt', 'sql', 'excel'],  			//导出文件类型  
        Icons:'glyphicon-export',  
        
        queryParams: function (params) {
            return {
                limit: params.limit,   //页面大小
                offset: params.offset,  //页码
                certId: $("#certid").val()
            };
        },
        columns: [
			{field: 'ck', checkbox: true},
			{field: 'certid', title: '证件号', sortable: true, align: 'center'},
			{field: 'partyName', title: '党员名称', sortable: true, align: 'center'},
			{field: 'brithday', title: '生日', sortable: true, align: 'center'},
			{field: 'address', title: '地址', sortable: true, align: 'center'},
			{field: 'marriage', title: '婚姻状况', sortable: true, align: 'center'},
			{field: 'education', title: '学历', sortable: true, align: 'center'},
			{field: 'partygroup', title: '党组织', sortable: true, align: 'center'},
	    	{field: 'archiveplace', title: '档案所在地', sortable: true, align: 'center'},
			{field: 'partytime', title: '入党时间', sortable: true, align: 'center'},
			{field: 'infoprecent', title: '信息完整度', sortable: true, align: 'center'}
		],
		onLoadError : function(status, result){$.hdErrorConfirm(result.responseText);}
    });
	
	//初始化页面上面的按钮事件
    $("#btn_query").click(function(){
        $('#tb_departments').bootstrapTable('getOptions').pageNumber = 1;
        $('#tb_departments').bootstrapTable('refresh');
    });

	//重置查询条件
	$("#btn_reset").click(function(){
		$(".form-control").val("");
	});
	
	//扫描档案文件
	$("#btn_scan").click(function(){
		var rows = $('#tb_departments').bootstrapTable('getSelections');
		$.hdDialog({
			title:'OCX文档扫描',
			columnClass:'col-md-offset-2 col-md-8',//配合col-md-offset-x居中
			containerFluid:true,//最大化
			content: 'url:${basePath}/scan/index/' + rows[0].certid,
			//content: 'url:${basePath}/scan/index',
			onClose: function(){
			    if(HdDialog.getValue()){
			    	$('#tb_departments').bootstrapTable('refresh');
			    }
			}
		});
	});
	//导入excel
    $("#toolbar #btn_import").click(function(){
    	$.hdDialog({
			title: 'Excel文件导入',
			columnClass:'col-md-offset-2 col-md-8',//配合col-md-offset-x居中
			containerFluid:true,//最大化
			content: 'url:${basePath}/manage/fileInput',
			onClose: function(){
			    if(HdDialog.getValue()){
			    	$('#tb_departments').bootstrapTable('refresh');
			    }
			}
		});
    });
	
	//新增按钮
	$("#toolbar #btn_create").click(function(){
	    $.hdDialog({
			title: '新增系统信息',
			columnClass:'col-md-offset-2 col-md-8',//配合col-md-offset-x居中
			//containerFluid:true,//最大化
			content: 'url:${basePath}/partymember/create',
			onClose: function(){
			    if(HdDialog.getValue()){
			    	$('#tb_departments').bootstrapTable('refresh');
			    }
			}
		});
    });
	
	//详情按钮
	$("#toolbar #btn_info").click(function(){
		$.hdDialog({
			title: '用户详情',
			columnClass:'col-md-offset-2 col-md-8',//配合col-md-offset-x居中
			//containerFluid:true,//最大化
			content: 'url:${basePath}/partymember/info' + rows[0].certid,
			onClose: function(){
			    if(HdDialog.getValue()){
			    	$('#tb_departments').bootstrapTable('refresh');
			    }
			}
		});
	});
	//修改更新按钮
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
				content: 'url:${basePath}/partymember/update/' + rows[0].certid,
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
				content: '确认删除所选记录吗？',
				buttons: {
					confirm: {
						text: '确认',
						btnClass: 'btn btn-danger',
						action: function () {
							HdConfirm.close();
							var certids = new Array();
							for (var i in rows) {
								certids.push(rows[i].certid);
							}
							$.ajax({
								type: 'POST',
								url: '${basePath}/partymember/delete',
								data:{"certids":certids},
								traditional:true,
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