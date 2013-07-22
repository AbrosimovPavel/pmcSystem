<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<script src="${pageContext.request.contextPath}/web-resources/js/jquery.1.9.1.min.js"></script>
	
	<script src="${pageContext.request.contextPath}/web-resources/js/vendor/jquery.ui.widget.js"></script>
	<script src="${pageContext.request.contextPath}/web-resources/js/jquery.iframe-transport.js"></script>
	<script src="${pageContext.request.contextPath}/web-resources/js/jquery.fileupload.js"></script>
	
	<!-- bootstrap just to have good looking page -->
	<script src="${pageContext.request.contextPath}/web-resources/bootstrap/js/bootstrap.min.js"></script>
	<link href="${pageContext.request.contextPath}/web-resources/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet" />
	
	<!-- we code these -->
	<link href="${pageContext.request.contextPath}/web-resources/css/dropzone.css" type="text/css" rel="stylesheet" />
	<script src="${pageContext.request.contextPath}/web-resources/js/myuploadfunction.js"></script>
</head>

<body>
	<h1>Spring MVC - jQuery File Upload</h1>

	<!-- button panel -->
	<!-- Button to trigger modal -->
	<a href="#myModal" role="button" class="btn" data-toggle="modal">Launch
		demo modal</a>

	<!-- Modal -->
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">Modal header</h3>
		</div>
		<div class="modal-body">
			<p>One fine body…</p>
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
			<button class="btn btn-primary">Save changes</button>
		</div>
	</div>
	<!-- end button panel -->


	<div style="width: 500px; padding: 20px">

		<input id="fileupload" type="file" name="files[]"
			data-url="<c:url value="/upload.html" />" multiple>

		<div id="dropzone" class="fade well">Drop files here</div>

		<div id="progress" class="progress">
			<div class="bar" style="width: 0%;"></div>
		</div>

		<table id="uploaded-files" class="table">
			<tr>
				<th>File Name</th>
				<th>File Size</th>
				<th>File Type</th>
				<th>Download</th>
			</tr>
		</table>

	</div>
</body>
</html>