<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<%-- <c:redirect url="/index/index.jsp"/>
 --%>
<div class="center-block" style="width:800px;padding-top:100px;" >
	<div class="col-md-6" style="width:400px;height:200px;background:url(${basePath}/resources/images/2.jpg)">
		<a href="#" target="_blank">
		<span>块1</span>
		</a>
	</div>
	<div class="col-md-6" style="width:400px;height:200px;background-color:yellow">
		<a href="#" target="_blank">
		<span>块2</span>
		</a>
	</div>
	<div class="col-md-6" style="width:400px;height:200px;background-color:yellow">
		<a href="#" target="_blank">
		<span>块3</span>
		</a>
	</div>
	<div class="col-md-6" style="width:400px;height:200px;background-color:yellow">
			<a href="#" target="_blank">
			<span>块4</span>
			</a>
	</div>
</div>