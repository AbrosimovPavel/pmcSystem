<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
  <head>
    <title>Login</title>
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
        <script src="http://code.jquery.com/jquery-latest.js" type="text/javascript"><!-- --></script>
  </head>

  <body onload="document.f.j_username.focus();" style="background: #f5f5f5;">
    
    <div class="container">
    
    <form class="form-signin" name="f" action="<c:url value='j_spring_security_check'/>" method="POST">
    <c:if test="${not empty error}">
        <div class="alert alert-error" style="border:2px solid #e9322d;background: #eed3d7;">
            ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
        </div>
    </c:if>    
      <h2 class="form-signin-heading">Authorization</h2>
      <input type="text" class="input-block-level" placeholder="Email address" name="j_username">
      <input type="password" class="input-block-level" placeholder="Password" name="j_password">
      <button class="btn btn-large btn-primary" type="submit">Login</button>
    </form>

    </div> <!-- /container -->
    
    
  </body>
</html>