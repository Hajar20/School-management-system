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
        
         <br>
               <div class="row">
                <div class="container">
                    <h3 class="text-center">Date d'examen de passage pour chaque année :</h3>
                    <hr>
                 
                    <div class="container text-left">
                        <a href="addExamPassageDate?nameE=Passage" class="btn btn-success">Ajouter la date de l'examen</a>  
                    </div>
                    
                    <br>
                   <table class="table table-bordered" style="margin-left:">
                        <thead>
                            <tr>
                                <th>Date de l'examen :</th>
                                <th>L'année scolaire</th>
								<th>Actions</th>
                            </tr>
                        </thead>
                       <tbody>
                        <c:forEach var="Exm" items="${listExm}">
                                <tr>
                                    <td>
                                      <c:out value="${Exm.dateEx}" />
                                    </td>
									
                                    <td>
                                      <c:out value="${Exm.schoolYear}" />
                                    </td>
                             
                                    <td>
                                    <a href="formulaireModifEx?idEx=<c:out value="${Exm.idEx}" />&nameE=Passage" class="btn btn-warning" >Modifier</a> 
                                    <a href="removeEx?idEx=<c:out value="${Exm.idEx}" />&nameE=Passage" class="btn btn-danger" >Supprimer</a> 
                                    </td>
                                </tr>
                         </c:forEach>
                        </tbody>
                    </table>
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