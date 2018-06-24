<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:set var="basePath" value="${pageContext.request.contextPath }" />
<style type="text/css">
    body {padding-bottom: 40px;}
    .sidebar-nav {padding: 9px 0;}

    @media (max-width: 980px) {
        /* Enable use of floated navbar text */
        .navbar-text.pull-right {
            float: none;
            padding-left: 5px;
            padding-right: 5px;
        }
    }

</style>
<!-- 单一页面不用写html,head,body标签 -->
<div class="panel panel-default">
	<div class="panel-body" style="padding-left:5px;padding-right:5px">
    	文件类型：<input type="text" name="mfiletype" id="mfiletype" class="input-default" /> 
    	<button id="btn_que" type="button" class="btn btn-primary btn-sm" >查询</button>
    
	<table class="filelist table table-bordered table-hover definewidth m10" >
    <thead>
    <tr>
        <th>文件id</th>
        <th>文件类型</th>
        <th>文件名称</th>
        <th>操作</th>
    </tr>
    </thead>
    <!-- <tr>
      <td><input type="text" name="" value=""/></td>
      <td>管理员</td>
      <td>1</td>
      <td><a href="edit.html">编辑</a></td>
    </tr> -->
 	
	</table>
	<table id="tb_departments"></table>
	</div>
</div>


<script>
$(function () {
	
	$.ajax({
		url:'${basePath}/partymember/fileList/${partyMemberCertid}',
		dataType:'json',
		type:'POST',
		data:'',
		contentType:'application/json',
		success:function(data){
			$(data.rows).each(function(i,n){
				var item = '<tr class="mfiletr"><td>'+n.mfileid+'</td><td>'+n.mfiletype+'</td><td>'+n.mfilename+'</td><td><a href="'+n.mfileurl+'">查看</a></td></tr>';
				$(item).appendTo('table.filelist');
			})
		}
	});
	
	//初始化页面上面的按钮事件
    $("#btn_que").click(function(){
    	var mfiletype = $("#mfiletype").val();
    	$.ajax({
    		url:'${basePath}/partymember/fileList/${partyMemberCertid}',
    		dataType:'json',
    		type:'POST',
    		data:{'mFileType':mfiletype},
    		success:function(data){
    			$('.mfiletr').remove();
    			$(data.rows).each(function(i,n){
    				var item = '<tr class="mfiletr"><td>'+n.mfileid+'</td><td>'+n.mfiletype+'</td><td>'+n.mfilename+'</td><td><a href="'+n.mfileurl+'">查看</a></td></tr>';
    				$(item).appendTo('table.filelist');
    			})
    		}
    	});
    });
	
});
</script>