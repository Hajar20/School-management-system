<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des enseignants</title>
 <meta charset="utf-8">

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
        
         <br>
               <div class="row">
                <div class="container">
                    <h3 class="text-center">Les enseignants de <c:out value="${nameSp}" /> :</h3>
                    <hr>
                    <div class="container text-left"> </div>
                    <br>
                    <input class="form-control" id="myInput" type="text" placeholder="Rechercher un Enseignant...">
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Nom</th>
                                <th>Prénom</th>
								<th>Matricule</th>
							
                            </tr>
                        </thead>
                        
                        <tbody id="myTable">
                        <c:forEach var="teachers" items="${listEns}">
                                <tr>
                                    <td>
                                      <c:out value="${teachers.nom }" />
                                    </td>
									
                                    <td>
                                      <c:out value="${teachers.prenom  }" />
                                    </td>
                                    
                                    <td>
                                      <c:out value="${teachers.matricule }" />
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
  <script src="javascript/search.js" ></script>
  </body>
  	</c:if>
</html>