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
               <h3> Profile: <c:out value="${employee.firstName}" /> <c:out value="${employee.lastName}" /></h3>
           </div>
           <div class="row-fluid">
               <div class="span6" style="padding-left:10px;">
                   <h5>Details</h5><hr>
                  <!--  <p>Avatar: </p><img alt="avatar" src="img/employee.png" class="img-rounded"> -->
                   <p>Username: <c:out value="${employee.firstName}" /></p>
                   <p>Full Name: <c:out value="${employee.firstName}" /> <c:out value="${employee.lastName}" /></p>
               </div>
               <div class="span6" >
                   <h5>possition</h5><hr>
                   <p>position in company: <c:out value="${employee.positionInCompany.name}" /></p>
                   <p>role in the system: <c:forEach var="roles" items="${roles}"><c:out value="${roles.name}" />  </c:forEach></p>
               </div>
               <div class="span6" style="float:right;">
                   <h5>comments:</h5><hr>
               </div>
               <div class="span5" >
                   <h5>assignment:</h5><hr>
                   <c:if test="${!empty assignments}">
                        <table class="table table-condensed">
                            <thead>
                                <tr>
                                    <th style="width: 50px;">Id</th>
                                    <th>Task code</th>
                                    <th>Assignment date</th>
                                    <th>end date</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="assignments" items="${assignments}">
                                    <tr onclick="location.href='detailtask.html?id=${assignments.task.taskId}'">
                                        <td><c:out value="${assignments.assignmentId}" /></td>
                                        <td><c:out value="${assignments.task.taskCode}" /></td>
                                        <td><c:out value="${assignments.assignmentDate}" /></td>
                                        <td><c:out value="${assignments.endDate}" /></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                    <c:if test="${empty assignments}">
                        <h4>empty</h4>
                    </c:if>
               </div>
           </div>
          </div><!--/.well -->
        </div><!--/span-->
       
        </div>
        </div><!--/span-->
      </div><!--/row-->

    </div><!--/.fluid-container-->


</body>
</html>