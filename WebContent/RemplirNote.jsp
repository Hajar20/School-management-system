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
<title>Saisir les notes</title>
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
		     		<h3 class="text-center">Filiere :<c:out value="${filiere}" />     Annee:<c:out value="${anne}" /></h3>
		     		
		     
                    <h3 class="text-center">Module:<c:out value="${module}" /></h3>
                    <h3 class="text-center">Date de controle le:<c:out value="${DateCC}" /></h3>
                    <hr>
                 

                   <form action="<%=request.getContextPath()%>/insertConCon" class="needs-validation" novalidate method="POST">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Nom Prenom </th>
                                 <th>Note </th>
                            </tr>
                        </thead>
                        <tbody id="myTable">
                        <c:forEach var="letudclass" items="${letudclass}">
                        <tr>
                            <td>
                              <c:out value="${letudclass.fullName}" />
                            </td>
                             <td>
                                  <input  name="<c:out value="${letudclass.fullName}"/>"   required>
								
                    
                     
                                 
                             </td>	
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <input type="hidden" name="idCC" value="<c:out value="${idCC}"/>" >
                     <input type="submit" class="btn btn-success" value="enregistrer" style="width:30%">
		     		 <input type="hidden" name="idClass" value="<c:out value="${idClass}"/>" > <input type="hidden" name="idUser" value="<c:out value="${sessionScope.idUser}"/>" >
                    </form>
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








<html>
<head>

<meta charset="UTF-8">
<title>choisi CC pro</title>
</head>

</html>