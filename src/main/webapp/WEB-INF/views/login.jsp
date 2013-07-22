<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
  <head>
    <title>Login</title>
        <link href="${pageContext.request.contextPath}/web-resources/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet" />
	    <link href="${pageContext.request.contextPath}/web-resources/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
	    <link href="${pageContext.request.contextPath}/web-resources/bootstrap/css/main.css" type="text/css" rel="stylesheet" />
	    <link href="${pageContext.request.contextPath}/web-resources/bootstrap/css/bootstrap-responsive.css" type="text/css" rel="stylesheet" />
	    <link href="${pageContext.request.contextPath}/web-resources/bootstrap/css/bootstrap-responsive.min.css" type="text/css" rel="stylesheet" />
	    
	    <script src="${pageContext.request.contextPath}/web-resources/bootstrap/js/bootstrap.min.js"></script>
	    
	    <script src="http://code.jquery.com/jquery-latest.js" type="text/javascript"><!-- --></script>
	    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
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