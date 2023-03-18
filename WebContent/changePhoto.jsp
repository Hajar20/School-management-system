<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>
<meta charset="utf-8">
<link href="nv/css/bootstrap.min.css" rel="stylesheet">
<link href="nv/css/datepicker3.css" rel="stylesheet">
<link href="nv/css/styles.css" rel="stylesheet">

<link rel="stylesheet" href="nv/bootstrap/css/bootstrap.min.css" type="text/css" />
<link href="nv/css/bootstrap.min.css" rel="stylesheet">
<link href="nv/css/datepicker3.css" rel="stylesheet">
<link href="nv/css/styles.css" rel="stylesheet">

<script src="nv/js/lumino.glyphs.js"></script>
<script src="nv/js/lumino.glyphs.js"></script>

 <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
 <link rel="stylesheet" href="nv/assets/signup-form.css" type="text/css" />
</head>
<c:if test="${empty login && empty password }">
      <c:redirect url = "Login.jsp"/>
      </c:if>
      <c:if test="${!empty login && !empty password }"> 
<body>
<%@ include file="listeMenu.jsp" %>
<div class="col-sm-8 col-sm-offset-3 col-lg-offset-2 main"> 
  <div class="signup-form-container  " style=" box-shadow: 0 10px 20px rgba(0,0,0,0.19), 0 6px 6px rgba(0,0,0,0.23);" >
 
  <form action="<%=request.getContextPath()%>/updateImage" method="post" >
        
         <input type="hidden" name="idEt" value="<c:out value="${idEt}"/>" >      
         <div class="form-header " >
         	<h3 class="form-title"><i class="fa fa-photo icon"></i> Changer ta photo  </h3>
                      
         <div class="pull-right">
             <h3 class="form-title"><span class="glyphicon glyphicon-pencil"></span></h3>
         </div>
                      
         </div>
         <div class="form-body">     
             <div class="form-group" >
			
                   <div class="input-group">
                   <div class="input-group-addon"><span class="fa fa-file icon"></span></div>
                   <input name="picture"  class="form-control" type="file" >
                   </div>
                   <span class="help-block" id="error"></span>
              </div>
     
             <br> 
            <div class="form-footer">
                 <button type="submit" class="btn btn-info" name="btn">
                 <span class="glyphicon glyphicon-log-in"></span> Modifier
                 </button>
            </div>
       </div>        
     
                  
   </form> 
</div>
</div>
</body>
</c:if>
</html>