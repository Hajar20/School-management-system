<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">

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
                <div class="card">
                    <div class="card-body">
 			          <c:if test="${userE != null }">
                        <form action="<%=request.getContextPath()%>/update" class="needs-validation" novalidate method="POST">
                      </c:if>
                      <c:if test="${userE == null }">
                        <form action="<%=request.getContextPath()%>/insert" class="needs-validation" novalidate method="POST">
                      </c:if>
                      
                      <c:if test="${userE != null }">
                          <h3 >Modifier l'étudiant</h3>
                      </c:if>
                      <c:if test="${userE == null }">
                          <h3 >Ajouter nouvel étudiant</h3>
                      </c:if>
                      
                      <c:if test="${userE != null }">
                          <input type="hidden" name="id" value="<c:out value="${userE.idUser }"/>" >
                      </c:if>
                          
                          <input type="hidden" value="Etudiant" name="role">
                        <fieldset class="form-group">
                            <label>Le nom :</label> <input type="text" class="form-control" name="nom" value="<c:out value="${userE.nom }" />" required>
							<div class="invalid-feedback">
                               Nom est invalide
                         </div>
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Le prénom :</label> <input type="text" class="form-control" name="prenom" value="<c:out value="${userE.prenom }" />" required>
							<div class="invalid-feedback">
                               prénom est invalide
                         </div>
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Email</label> <input type="email"  class="form-control" name="email" id="email" value="<c:out value="${userE.email }" />" required>
							<div class="invalid-feedback">
                            Email est invalide
                         </div>
                        </fieldset>
						
						<fieldset class="form-group">
                            <label>Matricule :</label> <input type="text"  class="form-control" name="matricule" value="<c:out value="${userE.matricule }" />" required>
							<div class="invalid-feedback">
                               Matricule est invalide
                             </div>
                        </fieldset>
						
						<fieldset class="form-group">
                            <label>La date de naissance :</label><input type="date"  class="form-control" name="DateN" value="<c:out value="${userE.dateN }" />" required>
							<div class="invalid-feedback">
                              Date de naissance est invalide
                             </div>
                        </fieldset>
                         
						 <fieldset class="form-group">
                            <label>Le lieu de naissance :</label> <input type="text"  class="form-control" name="lieu" value="<c:out value="${userE.lieu }" />" required>
							<div class="invalid-feedback">
                            Lieu est invalide
                             </div>
                        </fieldset>
						<fieldset class="form-group">
                            <label>L'adresse:</label> <input type="text"  class="form-control" name="adresse" value="<c:out value="${userE.adresse}" />" required>
							<div class="invalid-feedback">
                             L'adresse est invalide
                             </div>
                        </fieldset>
						<fieldset class="form-group">
                            <label>Le login :</label> <input type="email"  class="form-control" name="login" id="login" value="<c:out value="${userE.login }" />" required>
							<div class="invalid-feedback">
                             Login est invalide
                             </div>
                        </fieldset>
						<fieldset>
						 <label>Le mot de pass :</label> <input type="password"  class="form-control" name="password" value="<c:out value="${userE.password }" />" required>
							<div class="invalid-feedback">
                             Le mot de pass est invalide
                             </div>
                        </fieldset>
                       
						 <br>
						 <c:if test="${userE != null }">
                        <input type="submit" class="btn btn-warning" value="Modifier" style="width:30%">
                      </c:if>
                      <c:if test="${userE == null }">
                        <input type="submit" class="btn btn-success" value="Ajouter" style="width:30%">
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