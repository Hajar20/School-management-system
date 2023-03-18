<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <title>Liste des enseignants</title>

    
  <link href="bt/css/bootstrap.min.css" rel="stylesheet">
    <link href="cssstyles/dashboard.css" rel="stylesheet">
	<script src="bt/icons/feather.min.js"></script>
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
		     <div class="container">
                    <h3 class="text-center">List des étudiants</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="new?roleEt=Etudiant" class="btn btn-success">Ajouter
                                nouvel étudiant</a>
                    </div>
                    <br>
                     <input class="form-control" id="myInput" type="text" placeholder="Rechercher un Etudiant...">
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Numéro</th>
                                <th>Le nom complet</th>
                                <th>Email</th>
                                <th>Matricule</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody id="myTable">
                        <c:forEach var="utilisateur" items="${Etd}">
                        <tr>
                            <td>
                                <c:out value="${utilisateur.idUser }"></c:out>
                            </td>
                             <td>
                                  <c:out value="${utilisateur.nom}"/> <c:out value="${utilisateur.prenom}"/>  
                             </td>		
                             <td>
                                  <c:out value="${utilisateur.email }"></c:out>     
                             </td>
                              <td>
                                  <c:out value="${utilisateur.matricule }"></c:out>    
                              </td>
                                    <td ><a href="modify?id=<c:out value="${utilisateur.idUser }" />&roleEt=Etudiant" class="btn btn-warning" >Modifier</a> 
                                     <a href="delete?id=<c:out value="${utilisateur.idUser }" />&roleEt=Etudiant" class="btn btn-danger">Supprimer </a> 
                                     <a href="detail?id=<c:out value="${utilisateur.idUser }" />" class="btn btn-info" >Details</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                        
                    </table>
                </div>
       
        </main>
      </div>
    </div>

  <%@ include file="footer.jsp" %>
 <script src="javascript/jvs.js"></script>
 <script src="javascript/search.js" ></script>
  </body>
</c:if>
  </html>