<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Examen de passage</title>
<link href="bt/css/bootstrap.min.css" rel="stylesheet">
    <link href="cssstyles/dashboard.css" rel="stylesheet">
	<script src="bt/icons/feather.min.js"></script>
	 <script src="javascript/validate.js"></script>
  <link href="cssstyles/valide.css">
 <style>
 .sidebar-sticky{
		position : fixed;
	}
 </style>
</head>
<c:if test="${empty login && empty password }">
      <c:redirect url = "Login.jsp"/>
      </c:if>
    <c:if test="${!empty login && !empty password }"> 
<body>
<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0" >
      <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#"><h2>BTS</h2></a>
    </nav>

    <div class="container-fluid">
      <div class="row">
      
       <%@ include file="nav.jsp" %>	
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4"> 
		 <div class="container col-md-6" >
		 <br><br>
                <div class="card">
                    <div class="card-body">
                    
                   <c:if test="${Ex != null }">
                        <form action="<%=request.getContextPath()%>/updateExmP" class="needs-validation" novalidate method="POST">
                          <h2>Modifier la date de l'examen de passage :</h2> 
                          <input type="hidden" name="nameE" value="<c:out value="${nameE}"/>">
                           <input type="hidden" name="idEx" value="<c:out value="${idEx}"/>">
                      </c:if>
                      <c:if test="${Ex == null }">
                        <form action="<%=request.getContextPath()%>/insertExmP" class="needs-validation" novalidate method="POST">
                        <h2>Entrez la date de l'examen de passage :</h2>
                        <input type="hidden" name="nameE" value="<c:out value="${nameE}"/>">
                      </c:if>
						<br>
						<fieldset>
						<legend>
						 <label>La date d'examen :</label> 
						 <input type="date"  class="form-control" name="DateExP" value="<c:out value="${Ex.dateEx }" />" required>
							<div class="invalid-feedback">
                             Date invalide !!
                             </div>
							 </legend>
                        </fieldset>
						 <br>
						 <c:if test="${Ex == null }">
                        <input type="submit" class="btn btn-success" value="Ajouter" style="width:30%">
                        </c:if>
                         <c:if test="${Ex != null }">
                        <input type="submit" class="btn btn-warning" value="Modifier" style="width:30%">
                        </c:if>
                        <input type="reset" class="btn btn-danger" value="Effacer" style="width:30%">
                        </form>
                 
                   </div>
                </div>
            </div>
      
        </main>
      </div>
    </div>
    <%@ include file="footer.jsp" %>
 <script src="javascript/jvs.js"></script>
    
</body>
</c:if>
</html>