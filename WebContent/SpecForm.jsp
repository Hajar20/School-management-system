<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <title>L'ajout d'une nouvelle spécialité</title>
    <meta charset="utf-8">
<link href="bt/css/bootstrap.min.css" rel="stylesheet">
    <link href="cssstyles/dashboard.css" rel="stylesheet">
	<script src="bt/icons/feather.min.js"></script>
	 <script src="javascript/validate.js"></script>
  <link href="cssstyles/valide.css">
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
  <br><br>
		      <div class="container col-md-7">
                <div class="card">
                    <div class="card-body">
					     <c:if test="${spct != null }">
                          <h3 >Modifier la spécialité</h3>
                      </c:if>
                      <c:if test="${spct == null }">
                          <h3 >Ajouter nouvelle spécialité</h3>
                      </c:if>
                      <c:if test="${spct != null }">
                        <form action="<%=request.getContextPath()%>/updateSpec" class="needs-validation" novalidate method="POST">
                      </c:if>
                      <c:if test="${spct == null }">
                        <form action="<%=request.getContextPath()%>/insertSpec" class="needs-validation" novalidate method="POST">
                      </c:if>
                      <c:if test="${spct != null }">
                          <input type="hidden" name="idspc" value="<c:out value="${spct.idSp }"/>" >
                      </c:if>
                        <fieldset class="form-group">
                            <label>Le nom de la spécialité :</label> <input type="text" class="form-control" value="<c:out value="${spct.nomSp}" />" name="specialite" required>
							<div class="invalid-feedback">
                             Vous n'avez pas remplis le champs!!
                         </div>
                        </fieldset>
                        
                        <c:if test="${spct != null }">
                        <input type="submit" class="btn btn-warning" value="Modifier" style="width:30%">
                      </c:if>
                      <c:if test="${spct == null }">
                          <input type="submit" class="btn btn-success" value="Ajouter" style="width:30%">
                      </c:if>
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