<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<div id="outDialog">
	<div class="panel">
	<form id="outForm" method="post" class="form-horizontal">
		<div class="form-group">
			<label for="certid" class="col-md-3 control-label">证件号</label>
			<div class="col-md-9">
				<input id="certId" type="text" class="form-control" name="certid" maxlength="18" required value="${partyMember.certid}" readonly="readonly">
			</div>
		</div>
		<div class="form-group">
			<label for="partyName" class="col-md-3 control-label">党员名称</label>
			<div class="col-md-9">
				<input id="partyName" type="text" class="form-control" name="partyname" maxlength="10" required value="${partyMember.partyname}" readonly="readonly">
			</div>
		</div>
		<div class="form-group">
			<label for="sex" class="col-md-3 control-label">是否转出</label>
			<div class="col-md-9">
				<select id="isout" class="form-control" name="isout" required>
					<option value="0">否</option>
					<option value="1">是</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="outtime" class="col-md-3 control-label">转出时间</label>
			<div class="col-md-9">
				<input id="outtime" type="text" class="form-control" name="outtime" maxlength="10" required value="${partyMember.outtime}">
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-1 col-md-offset-5">
				<button id="btn_save" type="button" class="btn btn-primary">保存</button>
			</div>
			<div class="col-md-1">
				<button id="btn_cancel" type="button" class="btn btn-warning">取消</button>
			</div>
		</div>
	</form>
	</div>
</div>
<script>
$(function () {
	$("#outDialog #icon").iconPicker();
	$('#outDialog #isout').multiselect();
	
	$("#outForm").validate();
	$("#btn_save").click(function(){
		if(!$("#outForm").valid()){
			alert("请输入必填项");
			return;
		}
		$.ajax({
	        type: 'POST',
	        url: '${basePath}/partymember/out',
	        data: $('#outForm').serialize(),
	        success: function(result) {
	        	 if(result.code == 1){
	        		$.hdConfirm({
						type:'blue',
						content: result.msg,
						autoClose: 'confirm|3000',
						buttons: {
							confirm: {
								text:'确认',
								action:function(){HdDialog.close(true);}
							}
						}
					});
	        	}else{
	        		$.hdErrorConfirm(result);
	        	} 
	        },
			error:function(error){
				console.log(error);
			}
	    });
	});
	$("#btn_cancel").click(function(){
		HdDialog.close(false);
	});
	
});


</script>