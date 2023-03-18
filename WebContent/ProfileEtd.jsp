<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>
<meta charset="utf-8">
<link href="nv/css/bootstrap.min.css" rel="stylesheet">
<link href="nv/css/datepicker3.css" rel="stylesheet">
<link href="nv/css/styles.css" rel="stylesheet">

<link rel="stylesheet" href="nv/bootstrap/css/bootstrap.min.css" type="text/css" />
<link href="nv/css/bootstrap.min.css" rel="stylesheet">
<link href="nv/css/datepicker3.css" rel="stylesheet">
<link href="nv/css/styles.css" rel="stylesheet">

<script src="nv/js/lumino.glyphs.js"></script>
<script src="nv/js/lumino.glyphs.js"></script>
</head>
<c:if test="${empty login && empty password }">
      <c:redirect url = "Login.jsp"/>
      </c:if>
      <c:if test="${!empty login && !empty password }"> 
<body>
<%@ include file="listeMenu.jsp" %>
<div class="col-sm-8 col-sm-offset-3 col-lg-offset-2 main"> 
  <div class="col-md-7 ">

<div class="panel panel-default" style="width:150%">

  <div class="panel-heading">  <h4 >Votre Profile</h4></div><br><br>
   <div class="panel-body">
       
    <div class="box box-info" >
        
            <div class="box-body">
                     <div class="col-sm-6">
                     <div  align="center"> <img  src="pictures/<c:out value="${image }" />" name="imge" id="profile-image1" class="img-responsive" width="50%" height="30%" /> 
                     <a  href="modifyImgProfEtd?idEt=<c:out value="${student.idUser}" />" >Changer ta photo</a>
                       <div class="col-md-2" style="margin-left:135%;margin-top:-65%">
                        <a class="btn btn-warning" href="modifyProfEtd?idEt=<c:out value="${student.idUser}" />" >Changer le mot de pass</a>
                    </div>
               </div>
              <br><br><br>
            </div>
            <div class="col-sm-6">
            <span><h4 style="color:#00b1b1;"></h4></span>
           
            </div>
            <div class="clearfix"></div>
            <hr style="margin:5px 0 5px 0;">
            <div class="col-sm-5 col-xs-6 tital " ><b>Id :</b></div><div class="col-sm-7" id="info"> <c:out value="${student.idUser }" /></div>
  <div class="clearfix"></div>
<div class="bot-border"></div>
            
<div class="col-sm-5 col-xs-6 tital " ><b>Le nom complet :</b></div><div class="col-sm-7 col-xs-6 " id="info"><c:out value="${student.nom }" /> <c:out value="${dirct.prenom }" /></div>
     <div class="clearfix"></div>
<div class="bot-border"></div>

<div class="col-sm-5 col-xs-6 tital " ><b>Email :</b></div><div class="col-sm-7" id="info"> <c:out value="${student.email }" /></div>
  <div class="clearfix"></div>
<div class="bot-border"></div>

<div class="col-sm-5 col-xs-6 tital " ><b>Matricule :</b></div><div class="col-sm-7" id="info"> <c:out value="${student.matricule }" /></div>
  <div class="clearfix"></div>
<div class="bot-border"></div>

<div class="col-sm-5 col-xs-6 tital " ><b>Date de naissance :</b></div><div class="col-sm-7" id="info"><c:out value="${student.dateN }" /></div>

  <div class="clearfix"></div>
<div class="bot-border"></div>

<div class="col-sm-5 col-xs-6 tital " ><b>Lieu de naissance :</b></div><div class="col-sm-7" id="info"><c:out value="${student.lieu }" /></div>

  <div class="clearfix"></div>
<div class="bot-border"></div>

<div class="col-sm-5 col-xs-6 tital " ><b>Adresse :</b></div><div class="col-sm-7" id="info"><c:out value="${student.adresse }" /></div>

 <div class="clearfix"></div>
<div class="bot-border"></div>

<div class="col-sm-5 col-xs-6 tital " ><b>Login :</b></div><div class="col-sm-7" id="info"><c:out value="${student.login }" /></div>

 <div class="clearfix"></div>
<div class="bot-border"></div>
          </div>
        </div>  
    </div> 
    </div>
</div>  
</div>
</body>
</c:if>
</html>