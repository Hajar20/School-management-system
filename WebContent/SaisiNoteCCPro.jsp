<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link href="bt/css/bootstrap.min.css" rel="stylesheet">
    <link href="cssstyles/dashboard.css" rel="stylesheet">
	<script src="bt/icons/feather.min.js"></script>
<meta charset="UTF-8">
<title>Programmer un contrôle continu</title>
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
      
       <%@ include file="nav2.jsp" %>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4"> 
		     <div class="container">
		     		<h3 class="text-center">Choisir CC deja programmer et effectuer</h3>
		     		
		     
                    <h3 class="text-center">List des controles  ont programme cliquer sur saiai note pour entrer les notes</h3>
                    <hr>
                   
                   
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Module</th>
                                <th>Date CC</th>
                                <th>Filiere</th>
                                <th>Annee</th>
                              	<th></th>
                            </tr>
                        </thead>
                        <tbody id="myTable">
                        <c:forEach var="lcc" items="${lcc}">
                        <tr>
                            <td>
                              <c:out value="${lcc.nomModCC}" />
                            </td>
                             <td>
                                  <c:out value="${lcc.dateCC}" />
                             </td>		
                             <td>
                                  <c:out value="${lcc.nomFCC}" />
                             </td>
                              <td>
                                <c:out value="${lcc.annCC}" />
                              </td>
                               <td>
                                <a href="RemplirNote?idClass=<c:out value="${lcc.idClasseCC}" />&idCC=<c:out value="${lcc.idCC}" />&filiere=<c:out value="${lcc.nomFCC}" />&anne=<c:out value="${lcc.annCC}" />&DateCC=<c:out value="${lcc.dateCC}" />&module=<c:out value="${lcc.nomModCC}" />" class="btn btn-warning">Saisi les notes</a>
                              </td>
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