<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><title>Insert title here</title>

<link href="bt/css/bootstrap.min.css" rel="stylesheet">
    <link href="cssstyles/dashboard.css" rel="stylesheet">
	<script src="bt/icons/feather.min.js"></script>
  
</head>

<c:if test="${empty login && empty password }">
      <c:redirect url = "Login.jsp"/>
      </c:if>
   <c:if test="${!empty login && !empty password  }"> 
<body>
<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0" >
<a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#"><h2>BTS</h2></a>
    </nav>

    <div class="container-fluid">
      <div class="row">
       <%@ include file="nav2.jsp" %>
         <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4"> 
            <h1>erreur  car les notes n'ont pas existe</h1>
        </main>
        </div>
        </div>
 
     <%@ include file="footer.jsp" %>
        <script src="javascript/jvs.js"> </script>
</body>
</c:if>
</body>
</html>