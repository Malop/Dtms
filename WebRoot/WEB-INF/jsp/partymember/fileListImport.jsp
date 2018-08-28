<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:set var="basePath" value="${pageContext.request.contextPath }" />
<c:set var="partyMemberCertid" value="${partyMemberCertid}" />
<!-- 单一页面不用写html,head,body标签 -->
<div class="fileListImportDialog">
	<div class="modal-body">
	    <form id="importFile" class="form-horizontal" method="post">
	        <div class="col-lg-2">
                <select id="fileType" class="form-control " name="fileType">
					<option value="">请选择文件类型</option>
					<option value="01">中国共产党党员基本情况登记表</option>
					<option value="02">发展党员工作全程记实表</option>
					<option value="03">入党申请书</option>
					<option value="04">入党申请人谈话记录表</option>
					<option value="05">确立为入党积极分子情况备案报告</option>
					<option value="06">个人自传</option>
					<option value="07">入党积极分子培养考察登记表</option>
					<option value="08">入党政治审查材料</option>
					<option value="09">入党积极分子确定为发展对象的公示</option>
					<option value="10">列为发展对象情况备案报告</option>
					<option value="11">预审请示</option>
					<option value="12">党（工）委预审意见</option>
					<option value="13">接受中共预备党员票决情况汇总单</option>
					<option value="14">中国共产党入党志愿书</option>
					<option value="15">考察期个人思想汇报</option>
					<option value="16">预备党员转正申请书</option>
					<option value="17">预备党员转正式党员公示情况登记表</option>
					<option value="18">中共预备党员转正票决情况汇总单</option>
					<option value="19">其他材料</option>
					<option value="20">年度参加“三会一课”、固定活动日、培训教育、“先锋指数”评定情况</option>
					<option value="21">党内表彰奖励情况</option>
					<option value="22">党纪处分情况</option>
					<option value="23">组织处置情况</option>
					<option value="24">其他材料</option>
					<option value="25">存档证明</option>
					<option value="26">其他</option>
				</select>
            </div>
            <div class="col-lg-1"></div>
	        <div class="col-lg-9">
	            <input id="fileListImport" name="fileListImport" class="file-loading" type="file" multiple accept=".pdf">
	        </div>
	    </form>
	</div>
</div>
<script>
//$("#fileType").multiselect();
initUpload("fileListImport", "${basePath}/partymember/fileListImport");
function initUpload(ctrlName, uploadUrl) {
    var control = $('#' + ctrlName);
    control.fileinput({
        language: 'zh', //设置语言
        uploadUrl: uploadUrl, //上传的地址
        uploadAsync: true, //默认异步上传
        showCaption: true,//是否显示标题
        showUpload: true, //是否显示上传按钮
        showCancel:false,//是否显示取消按钮
        browseClass: "btn btn-success", //按钮样式
        enctype : 'multipart/form-data',
        allowedFileExtensions: ["pdf"], //接收的文件后缀
        maxFileCount: 1,//最大上传文件数限制
        previewFileIcon: '<i class="glyphicon glyphicon-file"></i>',
        showPreview: false, //是否显示预览区域
        layoutTemplates :{
            actionDelete:'', //去除上传预览的缩略图中的删除图标
            actionUpload:'',//去除上传预览缩略图中的上传图片；
            actionZoom:''   //去除上传预览缩略图中的查看详情预览的缩略图标。
        },
        previewFileIconSettings: {
            'docx': '<i ass="fa fa-file-word-o text-primary"></i>',
            'xlsx': '<i class="fa fa-file-excel-o text-success"></i>',
            'xls': '<i class="fa fa-file-excel-o text-success"></i>',
            'pptx': '<i class="fa fa-file-powerpoint-o text-danger"></i>',
            'jpg': '<i class="fa fa-file-photo-o text-warning"></i>',
            'pdf': '<i class="fa fa-file-archive-o text-muted"></i>',
            'zip': '<i class="fa fa-file-archive-o text-muted"></i>',
        },
        uploadExtraData: function () {
            var fileType = $("#fileType option:selected").val();
            var fileName = $('#fileType option:selected').text();
            return {"fileType": fileType,"fileName": fileName,"partyMemberCertid":"${partyMemberCertid}"};
        }
    });
}

//文件上传成功回调方法
$("#fileListImport").on("fileuploaded", function (event, data, previewId, index) {
    if(data.response.code == 1){
        alert(data.files[index].name + ":"+data.response.msg);
    	//关闭
        $(".close").click();
    }else{
        alert(data.files[index].name + ":" + data.response.msg);
	    //重置
	    $("#fileListImport").fileinput("clear");
	    $("#fileListImport").fileinput("reset");
	   	//$('#excelFile').fileinput("refresh");
	    $("#fileListImport").fileinput('enable');
    }
});
</script>