<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Toutes les informations</title>
<link href="bt/css/bootstrap.min.css" rel="stylesheet">
    <link href="cssstyles/dashboard.css" rel="stylesheet">
	<script src="bt/icons/feather.min.js"></script>
	<link href="cssstyles/st.css" rel="stylesheet">
<style>
#myTabContent{
margin-top:20%;
}
.profile-head{
margin-top:18%;
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
        <div class="container emp-profile">
           
                <div class="row">
                    <div class="col-md-4">
                        <div class="profile-img">
                            <img src="pictures/<c:out value="${pic }" />"  style="width:50%;height:50%">
                            
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="profile-head">
                         <h5>
                          Les informations de <c:out value="${u.nom }" /> <c:out value="${u.prenom }" />
                         </h5>
                        </div>
                    </div>
                    <!--  
                    <div class="col-md-2" >
                        <a type="submit" class="btn btn-warning" href="list?roleE=<c:out value="${u.role}"/>&roleEt=<c:out value="${u.role}"/>" >Précédente page</a>
                    </div>
                    -->
                </div>
        <div class="row">
                    <div class="col-md-4">
                        <div class="profile-work">
                           
                        </div>
                    </div>
                    <div class="col-md-8" >
                        <div class="tab-content profile-tab" id="myTabContent" >
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab" style="margin-top:-18%">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Id</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p style="margin-left:-50%"><c:out value="${u.idUser }"/></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>le nom complet</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p style="margin-left:-50%"><c:out value="${u.nom }"/> <c:out value="${u.prenom }" /></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Email</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p style="margin-left:-50%"><c:out value="${u.email }"/></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Matricule</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p style="margin-left:-50%"><c:out value="${u.matricule }"/></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Date de naissance</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p style="margin-left:-50%"><c:out value="${u.dateN }"/></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Lieu de naissance</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p style="margin-left:-50%"><c:out value="${u.lieu }"/></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Adresse</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p style="margin-left:-50%"><c:out value="${u.adresse}"/></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Login</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p style="margin-left:-50%"><c:out value="${u.login}"/></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Le mot de pass</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p style="margin-left:-50%"><c:out value="${u.password}"/></p>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Le role</label>
                                            </div>
                                            <div class="col-md-6">
                                                <p style="margin-left:-50%"><c:out value="${u.role}"/></p>
                                            </div>
                                        </div>
                                       
                                 </div>
                                 </div>
               </div>
               </div>
                 
        </div>
	</div>
        </main>
      </div>
   
  <%@ include file="footer.jsp" %>
 <script src="javascript/jvs.js"></script>
</body>
</c:if>
</html>