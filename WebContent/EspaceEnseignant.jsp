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
          
            <br>
               <div class="row">
                <div class="container">
                    <h3 class="text-center">Listes des contrôles continus passés :</h3>
                    <hr>
                    <div class="container text-left"></div>
                    <br>
                    <input class="form-control" id="myInput" type="text" placeholder="Rechercher un contrôte ...">
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Date</th>
								<th>Filière</th>
								<th>Niveau</th>
								<th>Module</th>
								<th>Note maximale</th>
								<th>Note minimale</th>
                            </tr>
                        </thead>
                        
                        <tbody id="myTable">                        
                          <c:forEach var="note" items="${Statistics}">
                                <tr>
                                    <td>
                                      <c:out value="${note.idCc }" />
                                    </td>
									
                                    <td>
                                      <c:out value="${note.dateCc  }" />
                                    </td>
                                    
                                    <td>
                                      <c:out value="${note.major }" />
                                    </td>
                                    
                                    <td>
                                      <c:out value="${note.level }" />
                                    </td>
                                    
                                    <td>
                                      <c:out value="${note.subject }" />
                                    </td>
                               
                                    <td>
                                      <c:out value="${note.maxGrade }" />
                                    </td>
                                    
                                    <td>
                                      <c:out value="${note.minGrade }" />
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
        <script src="javascript/jvs.js"> </script>
         <script src="javascript/search.js" ></script>
</body>
</c:if>
</body>
</html>