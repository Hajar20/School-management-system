<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Login Form</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
  <link href="assets/css/style.css" rel="stylesheet">
  <link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
  <script src="javascript/validate.js"></script>
  <link href="cssstyles/valide.css">
  <script src="bt/assets/js/vendor/jquery-slim.min.js"></script> 
<script src="bt/assets/js/vendor/popper.min.js"></script> 
<script src="bt/js/bootstrap.min.js"></script>
  <style>
         .container{
		     background:rgba(251,251,251,0.5);
			 width:55%;
			 height:62%; 
		 }
		 
		 form{
		     margin-left:24%;
		 }
		 .form-control{
		     width:60%;
			 border-radius: 18px;
		 }
		 .form-control{
		     width:60%;
			 border-radius: 18px;
		 }
		 .btn {
		      width:29.6%;
			  border-radius: 18px;
		 }
		 input[type="reset"]{
		     width:29.6%;
			 border-radius:18px;
			 background-color:white;
			 opacity:0.7
		 }
		 input[type="reset"]:hover {
		     opacity : 0.9;
		 }
	
  </style>
</head>
<body>
<section id="hero" style="height:100%">
    <div class="hero-container" >
      <div id="heroCarousel" class="carousel slide carousel-fade" data-ride="carousel">
        <div class="carousel-inner" role="listbox">
          <div class="carousel-item active">
            <div class="carousel-background"><img src="assets/img/graduate.jpg" ></div>
            <div class="carousel-container">
           <a  href="index.jsp" style="margin-top:-44%;margin-left:1%">
                  <span data-feather="home"></span>
                    <<
                </a>
                 <div class="container">
                     <br>
                 <h2 style="font-size:30px;margin-left:23%;color:black;align:center;">veuillez vous connecter</h2>

                 <form  action="<%=request.getContextPath()%>/login" method="POST" class="needs-validation" novalidate>
                     <div class="form-group">
                         <label for="email">Email :</label>
						
                         <input type="email" class="form-control" id="email" placeholder="Entrez votre email" name="login" required>
						<div class="invalid-feedback">
                              Email est invalide
                         </div>
                     </div>
                     <div class="form-group">
                         <label for="pwd">Mot de pass :</label>
                         <input type="password" class="form-control" id="pwd" placeholder="Entrez votre mot de pass" name="pwd" required>
						  <div class="invalid-feedback">
                           Enter le mot de pass
                       </div>
                     </div>
    
                         <input type="submit" class="btn btn-primary" value="Se connecter" >
	                     <input type="reset" class="btn btn-default" value="Effacer">
                 </form>
                 </div>
            
            </div>
          </div>
      </div>
    </div>
	</div>
  </section>
</body>
</html>