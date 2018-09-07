<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:set var="basePath" value="${pageContext.request.contextPath }" />
<c:set var="partyMemberCertid" value="${partyMemberCertid}" />
<!-- 单一页面不用写html,head,body标签 -->
<div class="fileListImportDialog">
	<div class="modal-body">
	    <form id="importFile" class="form-horizontal" method="post">
	        <div class="col-lg-10">
	            <input id="fileListImport" name="fileListImport" class="file-loading" type="file"/>
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
        allowedFileExtensions: ["xls", "xlsx"], //接收的文件后缀
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
        	var extraValue = "test";
            return {"excelType": extraValue};
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