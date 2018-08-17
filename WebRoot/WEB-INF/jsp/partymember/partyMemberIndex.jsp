<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:set var="basePath" value="${pageContext.request.contextPath }" />
<c:set var="isOut" value= "${isOut}" scope="request"/>

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
			<form id="query_form" class="" role="form">
			<div class="container">
				<div class="form-group">
                    <div class="col-lg-2">
                        <select id="queryParm" class="form-control " name="queryParm" required>
							<option value="">请选择条件</option>
							<option value="certid">证件号</option>
							<option value="partyName">党员名称</option>
							<option value="education">学历</option>
							<option value="address">地址</option>
							<option value="nation">民族</option>
							<option value="partygroup">党组织</option>
						</select>
                    </div>
                    <div class=" col-lg-3">
                    	<input type="text" class="form-control" id="queryVal">
                    </div>
                    
                    <div class="col-lg-2">
                        <select id="queryParm1" class="form-control " name="queryParm1" required>
							<option value="">请选择条件</option>
							<option value="certid">证件号</option>
							<option value="partyName">党员名称</option>
							<option value="education">学历</option>
							<option value="address">地址</option>
							<option value="nation">民族</option>
							<option value="partygroup">党组织</option>
						</select>
                    </div>
                    <div class=" col-lg-3">
                    	<input type="text" class="form-control" id="queryVal1">
                    </div>
                    <button id="btn_query" type="button" class="btn btn-danger btn-sm">
						<span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
					</button>
               	</div>
               	<div class="form-group">
	               	<div class="form-group col-lg-5">
	                    <div class="input-group">
	                        <span class="input-group-addon">生日</span>
	                        <input class="form-control" type="text" id="brithDayBegin">
	                        <span class="input-group-addon">至</span>
	                        <input class="form-control" type="text" id="brithDayEnd">
	                    </div>
	               	</div>
	               	<div class="form-group col-lg-5">
	                    <div class="input-group">
	                        <span class="input-group-addon">入党时间</span>
	                        <input class="form-control" type="text" id="partyTimeBegin">
	                        <span class="input-group-addon">至</span>
	                        <input class="form-control" type="text" id="partyTimeEnd">
	                    </div>
	               	</div>
					<button id="btn_reset" type="button" class="btn btn-danger btn-sm">
						<span class="glyphicon glyphicon-search" aria-hidden="true"></span>重置
					</button>
               	</div>
			</div>
			
			</form>
		</div>
	</div>
		
	<div id="toolbar" class="btn-toolbar pull-right" style="margin-bottom:3px">
	<c:if test="${isOut == 0}">
		<button id="btn_scan" type="button" class="btn btn-danger btn-sm" style="display:none">
            <span class="glyphicon glyphicon-inbox" aria-hidden="true"></span>扫描档案
        </button>
		<button id="btn_filelist" type="button" class="btn btn-danger btn-sm">
            <span class="glyphicon glyphicon-inbox" aria-hidden="true"></span>档案查看
        </button>
		<button id="btn_create" type="button" class="btn btn-danger btn-sm">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
        </button>
		<button id="btn_info" type="button" class="btn btn-danger btn-sm">
            <span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>详情
        </button>
        <button id="btn_update" type="button" class="btn btn-danger btn-sm" style="display:none">
            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>详情测试按钮
        </button> 
        <button id="btn_delete" type="button" class="btn btn-danger btn-sm">
            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
        </button>
        <button id="btn_import" type="button" class="btn btn-danger btn-sm">
            <span class="glyphicon glyphicon-import" aria-hidden="true"></span>导入excel
        </button>
        <button id="btn_out" type="button" class="btn btn-danger btn-sm">
            <span class="glyphicon glyphicon-export" aria-hidden="true"></span>党籍状态
        </button>
	</c:if>
	</div>
	<table id="tb_departments"></table>
	</div>
</div>


<script>
$(function () {
	
	$('#tb_departments').bootstrapTable({
        url: '${basePath}/partymember/list',     //请求后台的URL（*）
        method: 'post',                      //请求方式（*）
        toolbar: '#toolbar',                //工具按钮用哪个容器
        toolbarAlign:"right",
        contentType:"application/x-www-form-urlencoded",
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sortable: false,                    //是否启用排序
        sortName : 'certid',				//初始化的时候排序的字段
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
                limit: params.limit,	//页面大小
                offset: params.offset,  //页码
                order:this.sortOrder,	//排序命令
                sort:this.sortName,		//排序字段
                isOut:'${isOut}',		//是否转出标志
                queryParm: $("#queryParm").val(),
                queryVal:$("#queryVal").val(),
                queryParm1: $("#queryParm1").val(),
                queryVal1:$("#queryVal1").val(),
                brithDayBegin:$("#brithDayBegin").val(),
                brithDayEnd:$("#brithDayEnd").val(),
                partyTimeBegin:$("#partyTimeBegin").val(),
                partyTimeEnd:$("#partyTimeEnd").val()
            };
        },
        columns: [
			{field: 'ck', checkbox: true},
			{field: 'certid', title: '证件号', sortable: true, align: 'center'},
			{field: 'partyname', title: '党员名称', sortable: true, align: 'center'},
			{field: 'sex', title: '性别', sortable: true, align: 'center'},
			{field: 'education', title: '学历', sortable: true, align: 'center'},
			{field: 'mobilephone', title: '联系方式', sortable: true, align: 'center'},
			{field: 'address', title: '地址', sortable: true, align: 'center'},
			{field: 'job', title: '工作单位及职务', sortable: true, align: 'center'},
			{field: 'partygroup', title: '党组织', sortable: true, align: 'center'},
			{field: 'partytime', title: '入党时间', sortable: true, align: 'center'},
			{field: 'mainfileprecent', title: '关键资料完整度', sortable: true, align: 'center'},
			{field: 'fileprecent', title: '档案完整度', sortable: true, align: 'center'}
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
	
	//档案文件列表
	$("#btn_filelist").click(function(){
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
				title: '档案文件信息查看',
				columnClass:'col-md-offset-2 col-md-8',//配合col-md-offset-x居中
				//containerFluid:true,//最大化
				content: 'url:${basePath}/partymember/fileList/' + rows[0].certid,
				onClose: function(){
				    if(HdDialog.getValue()){
				    	$('#tb_departments').bootstrapTable('refresh');
				    }
				}
			});
		}
	});
	
	
	//扫描档案文件
	$("#btn_scan").click(function(){
		var rows = $('#tb_departments').bootstrapTable('getSelections');
		if (rows.length != 1) {
			$.hdConfirm({
				content: '请选择一条记录！',
				autoClose: 'cancel|3000',
				buttons: {cancel: {text: '取消'}}
			});
		} else {
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
		}
	});
	
	//导入excel
    $("#toolbar #btn_import").click(function(){
    	$.hdDialog({
			title: 'Excel文件导入',
			columnClass:'col-md-offset-2 col-md-8',//配合col-md-offset-x居中
			containerFluid:true,//最大化
			content: 'url:${basePath}/partymember/fileInput',
			onClose: function(){
				$('#tb_departments').bootstrapTable('refresh');
			   /*  if(HdDialog.getValue()){
			    	$('#tb_departments').bootstrapTable('refresh');
			    } */
			}
		});
    });
	
	//新增按钮
	$("#toolbar #btn_create").click(function(){
	    $.hdDialog({
			title: '新增党员信息',
			columnClass:'col-md-offset-2 col-md-8',//配合col-md-offset-x居中
			//containerFluid:true,//最大化
			content: 'url:${basePath}/partymember/create',
			onClose: function(){
				$('#tb_departments').bootstrapTable('refresh');
			    /* if(HdDialog.getValue()){
			    	$('#tb_departments').bootstrapTable('refresh');
			    } */
			}
		});
    });
	
	//详情与修改合并
	//详情测试按钮
 	$("#toolbar #btn_update").click(function(){
 		var rows = $('#tb_departments').bootstrapTable('getSelections');
 		loadPage("${basePath}/partymember/info/" + rows[0].certid);
 		//window.location.href="${basePath}/partymember/info/" + rows[0].certid;
	});
	//详情更新按钮
	$("#toolbar #btn_info").click(function(){
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
				title: '党员信息修改',
				columnClass:'col-md-offset-2 col-md-8',//配合col-md-offset-x居中
				//containerFluid:true,//最大化
				content: 'url:${basePath}/partymember/info/' + rows[0].certid,
				onClose: function(){
				    if(HdDialog.getValue()){
				    	$('#tb_departments').bootstrapTable('refresh');
				    }
				}
			});
		}
    });
	//转出按钮
	$("#toolbar #btn_out").click(function(){
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
				title: '党员转出',
				columnClass:'col-md-offset-2 col-md-8',//配合col-md-offset-x居中
				//containerFluid:true,//最大化
				content: 'url:${basePath}/partymember/out/' + rows[0].certid,
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