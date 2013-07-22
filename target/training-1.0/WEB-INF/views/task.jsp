<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<!DOCTYPE html>
<html>
<head>
<title>project page</title>
    <style type="text/css">
            <%@include file="css/main.css" %>
            <%@include file="css/bootstrap.min.css" %>
            <%@include file="css/bootstrap.css" %>
            <%@include file="css/bootstrap-responsive.css" %>
            <%@include file="css/bootstrap-responsive.min.css" %>
        </style>
        <style type="text/javascript">
            <%@include file="js/bootstrap.min.js" %>
        </style>
            <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      .sidebar-nav {
        padding: 9px 0;
      }

      @media (max-width: 980px) {
        .navbar-text.pull-right {
          float: none;
          padding-left: 5px;
          padding-right: 5px;
        }
      }
    </style>
        <script src="http://code.jquery.com/jquery-latest.js" type="text/javascript"><!-- --></script>
        <script 
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
		
		<script>
		$(document).ready(function() {
		
		    $('#addFile').click(function() {
		        var fileIndex = $('#fileTable tr').children().length - 1;
		        $('#fileTable').append(
		                '<tr><td>'+
		                '   <input type="file" name="files['+ fileIndex +']" />'+
		                '</td></tr>');
		    });
		    
		});
		</script>
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
        <div class="span12">
          <div class="well sidebar-nav">
           <div class="nav nav-list">
               <h3> Name project: <c:out value="${project.projectName}" /></h3>
           </div>
           <div class="row-fluid">
	           <div class="span6" style="padding-left:10px;">
	               <h5>Description</h5><hr>
	               <p>project creator: <c:out value="${project.projectName}" /></p>
	               <p>project status: <c:out value="${project.projectStatus.name}" /></p>
	           </div>
	           <div class="span6" >
	               <h5>Duration</h5><hr>
	               <p>planed start date: <c:out value="${project.planedStartDate}" /></p>
	               <p>planed end date: <c:out value="${project.planedEndDate}" /></p>
	               <p>actual start date: <c:out value="${project.actualStartDate}" /></p>
	               <p>actual end date: <c:out value="${project.actualendDate}" /></p>
	           </div>
           </div>
          </div><!--/.well -->
        </div><!--/span-->
        <div class="span5">
		<form:form method="post" action="save.html" 
		        modelAttribute="uploadForm" enctype="multipart/form-data">
		
		    <p>Select files to upload. Press Add button to add more file inputs.</p>
		
		    <input id="addFile" type="button" value="Add File" />
		    <table id="fileTable">
		        <tr>
		            <td><input name="files[0]" type="file" /></td>
		        </tr>
		        <tr>
		            <td><input name="files[1]" type="file" /></td>
		        </tr>
		    </table>
		    <br/><input type="submit" value="Upload" />
		</form:form>
        </div>
        <div class="span9" style="float:right;">
          <div class="hero-unit">
            <h2 style="color:dimgrey">Tasks</h2>
            <c:if test="${!empty taskList}">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th style="width: 50px;">Id</th>
                        <th>Task Code</th>
                        <th>Task Summary</th>
                        <th>Current status</th>
                        <!-- <th>assignment</th>-->
                        <th>Start date</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="tasks" items="${taskList}">
                        <tr  onclick="location.href='detailtask.html?id=${tasks.taskId}'">
                            <td><c:out value="${tasks.taskId}" /></td>
                            <td><c:out value="${tasks.taskCode}" /></td>
                            <td><c:out value="${tasks.taskSuammary}" /></td>
                            <td><c:out value="${tasks.taskStatus.name}" /></td>
                           <!-- > <c:if test="${!empty assignment}">
                                <td><c:out value="${assignment.employee.firstName} ${assignment.employee.lastName}" /></td>
                            </c:if>
                            <c:if test="${empty assignment}">
                                <td><c:out value="not assigned"></c:out></td>
                            </c:if> -->
                            <td><c:out value="${tasks.startDate}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            </c:if>
            <c:if test="${empty taskList}">
                <h5>In this project, no tasks.</h5>
            </c:if>
          </div>
        </div><!--/span-->
      </div><!--/row-->

      <hr>

      <footer>
        <p>&copy; Abrosimau Pavel 2013</p>
      </footer>

    </div><!--/.fluid-container-->


</body>
</html>