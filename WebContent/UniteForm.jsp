<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>L'ajout d'une nouvelle unité</title>
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
					     <c:if test="${uni != null }">
                          <h3 >Modifier l'unité</h3>
                      </c:if>
                      <c:if test="${uni == null }">
                          <h3 >Ajouter une nouvelle unité</h3>
                      </c:if>
                      <c:if test="${uni != null }">
                        <form action="<%=request.getContextPath()%>/updateUni" class="needs-validation" novalidate method="POST">
                      </c:if>
                      <c:if test="${uni == null }">
                        <form action="<%=request.getContextPath()%>/insertUni" class="needs-validation" novalidate method="POST">
                      </c:if>
                      <c:if test="${uni != null }">
                          <input type="hidden" name="idUnit" value="<c:out value="${uni.idUni }"/>" >
                          <input type="hidden" name="nveau" value="<c:out value="${lvl}"/>" >
                      </c:if>
                      <c:if test="${uni == null }">
                          <input type="hidden" name="idff" value="<c:out value="${idff}"/>" >
                          <input type="hidden" name="nveau" value="<c:out value="${nv}"/>" >
                      </c:if>
                        <fieldset class="form-group">
                            <label>Le nom de l'unité :</label> <input type="text" class="form-control" value="<c:out value="${uni.nomUni}" />" name="uniteN" required>
							<div class="invalid-feedback">
                             Vous n'avez pas remplis le champs!!
                         </div>
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Coefficient :</label> <input type="text" class="form-control" value="<c:out value="${uni.coeffUni}" />" name="coeffi" required>
							<div class="invalid-feedback">
                             Vous n'avez pas remplis le champs!!
                         </div>
                        </fieldset>
                        <c:if test="${uni != null }">
                        <input type="submit" class="btn btn-warning" value="Modifier" style="width:30%">
                      </c:if>
                      <c:if test="${uni == null }">
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