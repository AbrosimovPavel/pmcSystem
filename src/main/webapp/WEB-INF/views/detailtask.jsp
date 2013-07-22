<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

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
        <div class="span12">
          <div class="well sidebar-nav">
           <div class="nav nav-list">
               <h3>Task code: <c:out value="${task.taskCode}" /></h3>
           </div>
           <div class="row-fluid">
               <div class="span8" style="padding-left:35px;">
                   <h5>Details</h5><hr>
                   <p> Project Name: <c:out value="${task.project.projectName}"/></p>
                   <p>Task summary: <c:out value="${task.taskSuammary}" /></p>
                   <p>Task status: <c:out value="${task.taskStatus.name}" /></p>
               </div>
               <div class="span3" style="float:right;" >
                   <h5>People</h5><hr>
                   <p>Assignee: <c:out value="${assignment.employee.firstName}" /> <c:out value="${assignment.employee.lastName}" /> </p>
                   <p>Reporter: <c:out value="${task.taskCreator.firstName}" /> <c:out value="${task.taskCreator.lastName}" /></p>
               </div>
               <div class="span3" style="float:right;" >
                   <h5>Dates</h5><hr>
                   <p>Create:<c:out value="${task.creationDate}" /> </p>
                   <p>Start:<c:out value="${task.startDate}" /> </p>
                   <p>End:<c:out value="${task.endDate}" /> </p>
                   <p>Original Estimate:<c:out value="${task.originalEstimate}" /> </p>
               </div>
               <div class="span8" style="padding-left:35px;" >
                   <h5>Description</h5><hr>
                   <p><c:out value="${task.taskText}" /></p>
               </div>
               <div class="span8" >
                   <h5>Assignments</h5><hr>
                   <c:if test="${!empty assignments}">
		           <table class="table table-hover">
		                <thead>
		                    <tr>
		                        <th style="width: 50px;">Id</th>
		                        <th>Employee name</th>
		                        <th>Assignment date</th>
                                <th>end date</th>
		                    </tr>
		                </thead>
		                <tbody>
		                    <c:forEach var="assignments" items="${assignments}">
                                    <tr >
                                        <td><c:out value="${assignments.assignmentId}" /></td>
                                        <td><c:out value="${assignments.employee.firstName}" /> <c:out value="${assignments.employee.lastName}" /></td>
                                        <td><c:out value="${assignments.assignmentDate}" /></td>
                                        <td><c:out value="${assignments.endDate}" /></td>
                                    </tr>
                            </c:forEach>
		                </tbody>
		            </table>
	            </c:if>
	            <c:if test="${empty assignments}">
	                <h5>In this task, no assignments</h5>
	            </c:if>
                </div>  
               <div class="span3" style="float:right;" >
                   <h5>Activity</h5><hr>
                    <c:if test="${!empty activities}">
                    <table class="table table-condensed">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Employee name</th>
                                <th>Date</th>
                                <th>Duration</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="activities" items="${activities}">
                                    <tr >
                                        <td><c:out value="${activities.activityId}" /></td>
                                        <td><c:out value="${activities.assignment.employee.firstName}" /> <c:out value="${activities.assignment.employee.lastName}" /></td>
                                        <td><c:out value="${activities.date}" /></td>
                                        <td><c:out value="${activities.duration}" />h</td>
                                    </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    </c:if>
	                <c:if test="${empty activities}">
	                    <h5>no activities</h5>
	                </c:if>
               </div>            
               <div class="span8" >
                   <h5>attachment</h5><hr>
                
               </div> 
           </div>
          </div><!--/.well -->
          <a class="btn btn-small" href="<c:url value='task.html?id=${task.project.projectId}' />">Back to project</a>
        </div><!--/span-->
        
      </div><!--/row-->

      <hr>

      <footer>
        <p>&copy; Abrosimau Pavel 2013</p>
      </footer>

    </div><!--/.fluid-container-->


</body>
</html>