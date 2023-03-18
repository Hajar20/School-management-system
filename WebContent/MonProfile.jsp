<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile</title>
   <link href="bt/css/bootstrap.min.css" rel="stylesheet">
    <link href="cssstyles/dashboard.css" rel="stylesheet">
	<script src="bt/icons/feather.min.js"></script>
	<script src="bt/assets/js/vendor/jquery-slim.min.js"></script>
	<script src="bt/js/bootstrap.min.js"></script> 
	
    <style>
     input.hidden {
    position: absolute;
    left: -9999px;
}

#profile-image1 {
    cursor: pointer;
     width: 50%;
    height: 50%;
    margin-left:-60%;
    margin-top:-10%;
	border:2px solid #03b1ce ;}
	.tital{ font-size:16px; font-weight:500;}
	 .bot-border{ border-bottom:1px #f8f8f8 solid;  margin:5px 0  5px 0}

#info{
        margin-left:70%;
		margin-top:-4%;
}
#btnM{
    margin-left:70%;   
    
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
  <div class="col-md-7 ">

<div class="panel panel-default">

  <div class="panel-heading">  <h4 >Votre Profile</h4></div><br><br>
   <div class="panel-body">
       
    <div class="box box-info">
        
            <div class="box-body">
                     <div class="col-sm-6">
                     <div  align="center"> <img  src="pictures/<c:out value="${image }" />" name="imge" id="profile-image1" class="img-circle img-responsive" /> 
                <!-- 
                    <input id="profile-image-upload" class="hidden" type="file">
                      <div style="color:#999;" >
                           cliquer ici pour changer l'image
                      </div>
                 -->
                 <div class="col-md-2" style="margin-left:270%;margin-top:-40%">
                        <a class="btn btn-warning" href="modifyProf?idDir=<c:out value="${dirct.idUser }" />" >Mettre à jour le profile</a>
                    </div>
           </div>
              <br><br><br><br><br>
              <!-- /input-group -->
            </div>
            <div class="col-sm-6">
            <span><h4 style="color:#00b1b1;"></h4></span>
              <span><p>Vos informations :</p></span>            
            </div>
            <div class="clearfix"></div>
            <hr style="margin:5px 0 5px 0;">
            <div class="col-sm-5 col-xs-6 tital " >Id :</div><div class="col-sm-7" id="info"> <c:out value="${dirct.idUser }" /></div>
  <div class="clearfix"></div>
<div class="bot-border"></div>
            
<div class="col-sm-5 col-xs-6 tital " >Le nom complet :</div><div class="col-sm-7 col-xs-6 " id="info"><c:out value="${dirct.nom }" /> <c:out value="${dirct.prenom }" /></div>
     <div class="clearfix"></div>
<div class="bot-border"></div>

<div class="col-sm-5 col-xs-6 tital " >Email :</div><div class="col-sm-7" id="info"> <c:out value="${dirct.email }" /></div>
  <div class="clearfix"></div>
<div class="bot-border"></div>

<div class="col-sm-5 col-xs-6 tital " >Matricule :</div><div class="col-sm-7" id="info"> <c:out value="${dirct.matricule }" /></div>
  <div class="clearfix"></div>
<div class="bot-border"></div>

<div class="col-sm-5 col-xs-6 tital " >Date de naissance :</div><div class="col-sm-7" id="info"><c:out value="${dirct.dateN }" /></div>

  <div class="clearfix"></div>
<div class="bot-border"></div>

<div class="col-sm-5 col-xs-6 tital " >Lieu de naissance :</div><div class="col-sm-7" id="info"><c:out value="${dirct.lieu }" /></div>

  <div class="clearfix"></div>
<div class="bot-border"></div>

<div class="col-sm-5 col-xs-6 tital " >Adresse :</div><div class="col-sm-7" id="info"><c:out value="${dirct.adresse }" /></div>

 <div class="clearfix"></div>
<div class="bot-border"></div>

<div class="col-sm-5 col-xs-6 tital " >Login :</div><div class="col-sm-7" id="info"><c:out value="${dirct.login }" /></div>

 <div class="clearfix"></div>
<div class="bot-border"></div>
          </div>
        </div>  
    </div> 
    </div>
</div>  
    <script>
              $(function() {
    $('#profile-image1').on('click', function() {
        $('#profile-image-upload').click();
    });
});       
</script> 
              
              
        </main>
      </div>
    </div>
  <%@ include file="footer.jsp" %>
 <script src="javascript/jvs.js"></script>
</body>
</c:if>
</html>