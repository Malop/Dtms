<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<div id="createDialog">
	<div class="panel">
	<form id="createForm" method="post" class="form-horizontal">
		<div class="form-group">
			<label for="certid" class="col-md-3 control-label">证件号</label>
			<div class="col-md-9">
				<input id="certId" type="text" class="form-control" name="certid" maxlength="18" required value="${partyMember.certid}">
			</div>
		</div>
		<div class="form-group">
			<label for="partyName" class="col-md-3 control-label">党员名称</label>
			<div class="col-md-9">
				<input id="partyName" type="text" class="form-control" name="partyname" maxlength="10" required value="${partyMember.partyname}">
			</div>
		</div>
		<div class="form-group">
			<label for="sex" class="col-md-3 control-label">性别</label>
			<div class="col-md-9">
				<select id="sex" class="form-control" name="sex" required>
					<option value="male">男</option>
					<option value="female">女</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="nation" class="col-md-3 control-label">民族</label>
			<div class="col-md-9">
				<input id="nation" type="text" class="form-control" name="nation" maxlength="20" required value="${partyMember.nation}">
			</div>
		</div>
		<div class="form-group">
			<label for="nativeplace" class="col-md-3 control-label">籍贯</label>
			<div class="col-md-9">
				<input id="nativeplace" type="text" class="form-control" name="nativeplace" maxlength="20" required value="${partyMember.nativeplace}">
			</div>
		</div>
		<div class="form-group">
			<label for="isTaiwan" class="col-md-3 control-label">是否台湾</label>
			<div class="col-md-9">
				<select id="isTaiwan" class="form-control" name="istaiwan" required>
					<option value="01">是</option>
					<option value="02">否</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="brithday" class="col-md-3 control-label">生日</label>
			<div class="col-md-9">
				<input id="brithday" type="text" class="form-control" name="brithday" maxlength="20" value="${partyMember.brithday}">
			</div>
		</div>
		<div class="form-group">
			<label for="age" class="col-md-3 control-label">年龄</label>
			<div class="col-md-9">
				<input id="age" type="text" class="form-control" name="age" maxlength="20" value="${partyMember.age}">
			</div>
		</div>
		<div class="form-group">
			<label for="education" class="col-md-3 control-label">学历</label>
			<div class="col-md-9">
				<input id="education" type="text" class="form-control" name="education" maxlength="20" value="${partyMember.education}">
			</div>
		</div>
		<div class="form-group">
			<label for="category" class="col-md-3 control-label">人员类别</label>
			<div class="col-md-9">
				<input id="category" type="text" class="form-control" name="category" maxlength="20" value="${partyMember.category}">
			</div>
		</div>
		<div class="form-group">
			<label for="partygroup" class="col-md-3 control-label">党组织</label>
			<div class="col-md-9">
				<input id="partygroup" type="text" class="form-control" name="partygroup" maxlength="20" value="${partyMember.partygroup}">
			</div>
		</div>
		<div class="form-group">
			<label for="partytime" class="col-md-3 control-label">入党时间</label>
			<div class="col-md-9">
				<input id="partytime" type="text" class="form-control" name="partytime" maxlength="20" value="${partyMember.partytime}">
			</div>
		</div>
		<div class="form-group">
			<label for="fullpartytime" class="col-md-3 control-label">转正时间</label>
			<div class="col-md-9">
				<input id="fullpartytime" type="text" class="form-control" name="fullpartytime" maxlength="20" value="${partyMember.fullpartytime}">
			</div>
		</div>
		<div class="form-group">
			<label for="job" class="col-md-3 control-label">工作岗位</label>
			<div class="col-md-9">
				<input id="job" type="text" class="form-control" name="job" maxlength="20" value="${partyMember.job}">
			</div>
		</div>
		<div class="form-group">
			<label for="timetowork" class="col-md-3 control-label">参加工作时间</label>
			<div class="col-md-9">
				<input id="timetowork" type="text" class="form-control" name="timetowork" maxlength="20" value="${partyMember.timetowork}">
			</div>
		</div>
		<div class="form-group">
			<label for="address" class="col-md-3 control-label">地址</label>
			<div class="col-md-9">
				<input id="address" type="text" class="form-control" name="address" maxlength="20" value="${partyMember.address}">
			</div>
		</div>
		<div class="form-group">
			<label for="mobilephone" class="col-md-3 control-label">手机号码</label>
			<div class="col-md-9">
				<input id="mobilephone" type="text" class="form-control" name="mobilephone" maxlength="20" value="${partyMember.mobilephone}">
			</div>
		</div>
		<div class="form-group">
			<label for="telephone" class="col-md-3 control-label">固定号码</label>
			<div class="col-md-9">
				<input id="telephone" type="text" class="form-control" name="telephone" maxlength="20" value="${partyMember.telephone}">
			</div>
		</div>
		<div class="form-group">
			<label for="marriage" class="col-md-3 control-label">婚姻状况</label>
			<div class="col-md-9">
				<select id="marriage" class="form-control" name="marriage" required>
					<option value="01">未婚</option>
					<option value="02">已婚</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="archiveplace" class="col-md-3 control-label">档案所在地</label>
			<div class="col-md-9">
				<input id="archiveplace" type="text" class="form-control" name="archiveplace" maxlength="20" value="${partyMember.archiveplace}">
			</div>
		</div>
		<div class="form-group">
			<label for="technicaltitle" class="col-md-3 control-label">技术职称</label>
			<div class="col-md-9">
				<input id="technicaltitle" type="text" class="form-control" name="technicaltitle" maxlength="20" value="${partyMember.technicaltitle}">
			</div>
		</div>
		<div class="form-group">
			<label for="sociallevel" class="col-md-3 control-label">社会阶层类型</label>
			<div class="col-md-9">
				<input id="sociallevel" type="text" class="form-control" name="sociallevel" maxlength="20" value="${partyMember.sociallevel}">
			</div>
		</div>
		<div class="form-group">
			<label for="situation" class="col-md-3 control-label">一线情况</label>
			<div class="col-md-9">
				<input id="situation" type="text" class="form-control" name="situation" maxlength="20" value="${partyMember.situation}">
			</div>
		</div>
		<div class="form-group">
			<label for="training" class="col-md-3 control-label">培训情况</label>
			<div class="col-md-9">
				<input id="training" type="text" class="form-control" name="training" maxlength="20" value="${partyMember.training}">
			</div>
		</div>
		<div class="form-group">
			<label for="isworker" class="col-md-3 control-label">是否农名工</label>
			<div class="col-md-9">
				<select id="isworker" class="form-control" name="isworker" required>
					<option value="01">是</option>
					<option value="02">否</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="isoffline" class="col-md-3 control-label">是否失联党员</label>
			<div class="col-md-9">
				<select id="isoffline" class="form-control" name="isoffline" required>
					<option value="01">是</option>
					<option value="02">否</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="offdate" class="col-md-3 control-label">失联时间</label>
			<div class="col-md-9">
				<input id="offdate" type="text" class="form-control" name="offdate" maxlength="20" value="${partyMember.offdate}">
			</div>
		</div>
		<div class="form-group">
			<label for="isfloat" class="col-md-3 control-label">是否流动党员</label>
			<div class="col-md-9">
				<select id="isfloat" class="form-control" name="isfloat" required>
					<option value="01">是</option>
					<option value="02">否</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="floatdirection" class="col-md-3 control-label">外出流向</label>
			<div class="col-md-9">
				<input id="floatdirection" type="text" class="form-control" name="floatdirection" maxlength="20" value="${partyMember.floatdirection}">
			</div>
		</div>
		<div class="form-group">
			<label for="infoprecent" class="col-md-3 control-label">信息完整度</label>
			<div class="col-md-9 ">
				<div class="slider-minmax" style="padding-top:10px">
				</div>
				<input id="infoprecent" type="hidden" class="form-control" name="infoprecent" maxlength="20" value="${partyMember.infoprecent}">
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
	$("#createDialog #icon").iconPicker();
	$('#createDialog #sex').multiselect();
	$('#createDialog #isTaiwan').multiselect();
	$('#createDialog #marriage').multiselect();
	$('#createDialog #isworker').multiselect();
	$('#createDialog #isoffline').multiselect();
	$('#createDialog #isfloat').multiselect();
	$("#createForm").validate();
	$("#btn_save").click(function(){
		if(!$("#createForm").valid()){
			alert("请输入必填项");
			return;
		}
		$.ajax({
	        type: 'POST',
	        url: '${basePath}/partymember/create',
	        data: $('#createForm').serialize(),
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
	
	$(".slider-minmax").noUiSlider({
        range: [0, 100],
        start: 23,
        handles: 1,
        connect: 'upper',
        step:1,
        slide: function() {
            var val = Math.floor($(this).val());
            $(this).find(".noUi-handle").text(val+"%");
            $("#infoprecent").val(val+"%");
            console.log($(this).find(".noUi-handle").parent().parent().html());
        },
        set: function() {
            var val = Math.floor($(this).val());
            $(this).find(".noUi-handle").text(val+"%");
            $("#infoprecent").val(val+"%");
        }
    }); 
});


</script>