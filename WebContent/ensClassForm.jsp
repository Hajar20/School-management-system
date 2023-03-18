<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <title>Form</title>
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
					     
                     
                          <h3 >Ajouter un enseignant</h3>
                      
                        <form action="<%=request.getContextPath()%>/insertClassEns" class="needs-validation" novalidate method="POST">
                  
                      <input type="hidden" name="nveau" value="<c:out value="${nv}"/>" >
                       <input type="hidden" name="idff" value="<c:out value="${idff }"/>" >
                     
                        <fieldset class="form-group">
                            <label>L'enseignant :</label> 
                            <select name="noms" class="form-control" required> 
                             <option value="-1">Choisir un enseignant</option>
							<c:forEach var="name" items="${names }">
							      <option >
							         <c:out value="${name.fullName}" />
							      </option>
							</c:forEach>
							
							</select>
							<div class="invalid-feedback">
                             Choisir un enseignant!!
                         </div>
                        </fieldset>
                    
                          <input type="submit" class="btn btn-success" value="Ajouter" style="width:30%">
           
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