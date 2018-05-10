<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:set var="basePath" value="${pageContext.request.contextPath }" />

<div id="globeDialog" class="globeDialog" style="border: 1px solid #ccc;padding: 10px;width:800px;position: relative;">
	<div style="position: relative;">
		<div style="text-align:center;border: 2px solid #ccc;position: relative;left: 0px;width: 580px;height: 445px;">
		<!--[if gte IE 7]>
			<object classid="clsid:454C18E2-8B7D-43C6-8C17-B1825B49D7DE" id="captrue"  width="600" height="449" ></object>
		<![endif]-->
	    
		<!--[if !IE]> -->
			<object
			  type="application/x-itst-activex" 
			  clsid="{454C18E2-8B7D-43C6-8C17-B1825B49D7DE}"
			  id="captrue"  
			  width="580" 
			  height="445" >
			</object>
		<!-- <![endif]-->
		</div>
		<div id="imageDiv" style="width:185px; height:445px; float: left; border: 2px solid #ccc; left: 592px; top:2px; position:absolute; overflow-y: scroll; padding: 5px;">  
		<!--[if gte IE 7]>     
	        <object classid="clsid:8622e61a-22d1-4c10-9ecc-4dfc1f9a4f03" id="cap"  width="200" height="449" ></object>
		<![endif]-->
		<!--[if !IE]> -->
			<object
			  type="application/x-itst-activex" 
			  clsid="{8622e61a-22d1-4c10-9ecc-4dfc1f9a4f03}"      
				id="cap"  
				width="185" 
				height="445" >
			</object> 
		<!-- <![endif]-->     
		</div>
	</div>
	<div align="center" style="padding:10px">
	<form method="POST" action="--WEBBOT-SELF--" name="form1" id="form1">
		<input type="hidden" id="viewImagePath"/>
		<input type="hidden" id="rotationNum"/>
		<input type="hidden" id="isSelectAll"/>
		<label> 
			<input type="radio" id="docMode" value="1" name="mode" onClick="setMode(this)" checked="checked">文档
		</label>
		<label for="exposure">文档类型</label>
		<select id="exposure" onChange="setExposure(this)">
			<option value="100">100</option>
			<option value="90">90</option>
			<option value="80">80</option>
			<option value="70">70</option>
			<option value="60">60</option>
			<option value="50" selected="selected">50</option>
			<option value="40">40</option>
			<option value="30">30</option>
			<option value="20">20</option>
			<option value="10">10</option>
			<option value="0">0</option>
		</select>&nbsp;
		<input class="btn btn-success btn-sm" type="button" value="参数设置" onClick="setup()">&nbsp;
		<input class="btn btn-success btn-sm" type="button" value="PIN" onClick="pin()">&nbsp;
		<input class="btn btn-success btn-sm" type="button" value="拍摄" onClick="shot()">&nbsp;
		<input class="btn btn-success btn-sm" type="button" value="上移" onClick=" ImageUp()"/>
		<input class="btn btn-success btn-sm" type="button" value="下移" onClick="ImageDown()"/>
		<input class="btn btn-success btn-sm" type="button" value="删除" onClick="deleteImage()"/>
		<input class="btn btn-success btn-sm" type="button" value="全选/反选" onClick="selectall()"/>
		<input class="btn btn-success btn-sm" type="button" value="拍摄PDF" onClick="SavePDF()"/>
		<input class="btn btn-success btn-sm" type="button" value="上传" onClick="upload()"/>
	</form>
	</div>
</div>
<script type="text/javascript">
	var savePath = "d:\\";
	$(function(){
		var width = $(document).width();
		var height = $(document).height();
		//$("#globeDialog").css("left",(width-780)/2);
		//$("#docMode").attr("checked",true);
		//captrue.bStopPlay();
		//captrue.bStartPlay();
	//	captrue.bSetMode(3);
	});
		
	
	function setup() {
		captrue.displayVideoPara();
	}

	
	//查看图像
	function viewImage(e,src,value){
		//设置旋转值
		$("#rotationNum").val($(e).data("rotationNum"));
		$("#viewImagePath").val(src);
		var width = $(document).width();
		var height = $(document).height();
		window.showModalDialog("viewImage.htm",window,"dialogHeight:"+height+"px;dialogWidth:"+width+"px;status:no;scroll:no");
	}
	
	var count = 0;
	function shot(){
		var d = new Date().getTime();
		var r = captrue.bSaveJPG(savePath,d);
		var str = cap.AddImage(savePath+d+".jpg"); 
	}
	
	function pin() {
		captrue.vSetCapturePin();
		var modes = document.getElementsByName("mode");
		var value;
		for(var i = 0;i < modes.length;i ++) {
			if(modes[i].checked) value = modes[i].value;
		}
		if(value == 1) {
			captrue.bStartPlay();
			//captrue.bSetMode(3);
		} else if(value == 2) {
			captrue.bStartPlay2(0);
		} 
	}

	
	function deleteImage(){
		 var str = cap.RemoveItemImg(-1,1);
	}
		
	var value = 0;
	function selectall(){
		if(value == 0){
			var str = cap.SetCheck(true);
			value = 1;
		}
		else{
			var str = cap. CancelCheck(true);
			value = 0;
		}
	}
	
	function setMode(el) {
		var value = el.value;
		if(value == 1) {
			captrue.bStopPlay();
			captrue.bStartPlay();
			//captrue.bSetMode(3);
		} else if(value == 2) {
			captrue.bStopPlay();
			captrue.bStartPlay2(0);
		} 
	}
	
	function setExposure(el) {
		captrue.vSetExposure(el.value);
	}
	
	function ImageUp(){
		var num = cap.GetListCount();
		for(var i = 0;i<num;i++){
			var b =cap. GetCheck (i);
			if(b==1){
				 cap.ImageRiseEx();
			}
		}
		
	}
	
	function ImageDown(){
		var num = cap.GetListCount();
		for(var i = 0;i<num;i++){
			var b =cap. GetCheck (i);
			if(b==1){
				 cap. ImageFallEx();
			}
		}
	}
	
	function SavePDF(){
		var count = 0;
		var d = new Date().getTime();
		var copyfile = savePath+"temp.jpg";
		var num = cap.GetListCount();
		captrue.bSavePDFStart (savePath,d);
		for(var i = 0;i<num;i++){
			var b =cap. GetCheck (i);
			if(b==1){
				count++;
			}
		}
		if(count == 0){
			alert("请选择要制作PDF的图像");
			return;
		}else{
			captrue.bSavePDFStart (savePath,d);		
		    for(var i = 0;i<num;i++){
				var b =cap. GetCheck (i);
				if(b==1){
					var file = cap. GetItemPath (i);
					captrue.bCopyFile(copyfile, file);
					captrue.bRotateJpgImage (copyfile,90);
					var test= captrue.bAddPDFColorPage(copyfile,0.331);	
					count++;
				}
			}
			captrue.bSavePDFEnd ();
			var str = captrue.OpenFile(savePath+d+".pdf");
			alert(str);
			captrue.bDeleteFile (copyfile);	
		}
				
	}
	
	function upload(){
		var filelist = "";	
		var num = cap.GetListCount();
		//captrue.bSavePDFStart (savePath,d);
		for(var i = 0;i<num;i++){
			var b =cap.GetCheck (i);
			if(b==1){
				count++;
			}
		}
		if(count == 0){
			alert("请选择要上传的图像");
			return;
		}else{
			for(var i = 0;i<num;i++){
				var b =cap. GetCheck (i);
				if(b==1){
					var file = cap.GetItemPath (i);
					filelist += file + "|";
					//filelist += imageSelects[i].value+"|";
				}
			}
			if(filelist != "") 
			filelist = filelist.substring(0,filelist.length-1);
		//alert(filelist);
		//上传部分请自行进行二次开发
		var str=captrue.bUpLoadImage(filelist, "127.0.0.1", 8080, "/scan/upload");			
		}
	}
	
</script>
