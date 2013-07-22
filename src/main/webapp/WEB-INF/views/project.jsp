<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<!DOCTYPE html>
<html>
<head>
<title>project page</title>
    <link href="${pageContext.request.contextPath}/web-resources/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/web-resources/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/web-resources/bootstrap/css/main.css" type="text/css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/web-resources/bootstrap/css/bootstrap-responsive.css" type="text/css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/web-resources/bootstrap/css/bootstrap-responsive.min.css" type="text/css" rel="stylesheet" />
    
    <script src="${pageContext.request.contextPath}/web-resources/bootstrap/js/bootstrap.min.js"></script>
    
    <script src="http://code.jquery.com/jquery-latest.js" type="text/javascript"><!-- --></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
</head>
<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="brand" href="<c:url value="/project.html" />">Project manager center</a>
				<div class="nav-collapse collapse"></div>
				<!--/.nav-collapse -->
			    <a class="pull-left" style="margin-top: 9px" href="<c:url value="/profile.html" />">
			        <c:out value="${employee.firstName} ${employee.lastName} "></c:out>
			    </a>
				<a class="pull-right" style="margin-top: 9px" href="<c:url value="/logout.html" />">LogOut</a>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3">
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
		              <li class="nav-header">Navigation</li>
		              <li class="active"><a href="<c:url value="/project.html" />">projects</a></li>
		              <li><a href="<c:url value="/project.html" />">assignment</a></li>
		              <li><a href="<c:url value="/project.html" />">time journal</a></li>
            </ul>
				</div>
				<!--/.well -->
			</div>
			<!--/span-->
			<div class="span9">
				<div class="hero-unit">
					<h2 style="color: dimgrey">Projects</h2>
					<c:if test="${!empty projectList}">
						<table class="table table-hover">
							<thead>
								<tr>
									<th style="width: 50px;">Id</th>
									<th>Name project</th>
									<th>Current status</th>
									<th>Start date</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="projects" items="${projectList}">
									<tr onclick="location.href='task.html?id=${projects.projectId}'">
										<td><c:out value="${projects.projectId}" /></td>
										<td><c:out value="${projects.projectName}" /></td>
										<td><c:out value="${projects.projectStatus.name}" /></td>
										<td><c:out value="${projects.planedStartDate}" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:if>
					<c:if test="${empty projectList}">
						<h4>empty</h4>
					</c:if>
				</div>
			</div>
			<!--/span-->
		</div>
		<!--/row-->

		<hr>

		<footer>
			<p>&copy; Abrosimau Pavel 2013</p>
		</footer>

	</div>
	<!--/.fluid-container-->


</body>
</html>