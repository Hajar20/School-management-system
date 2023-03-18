<script src="bt/assets/js/vendor/jquery-slim.min.js"></script> 
<script src="bt/assets/js/vendor/popper.min.js"></script> 
<script src="bt/js/bootstrap.min.js"></script>     
 <style>
 .dropdown:hover> .dropdown-menu{
	display : block;
	  margin-left:20%;
  margin-top:-10%;
}
 </style>
 <nav class="col-md-2 d-none d-md-block bg-light sidebar">
          <div class="sidebar-sticky" >
            <ul class="nav flex-column">
			<br><br>
              <li class="nav-item">
                <a class="nav-link " href="profile?roleD=Directeur&idDir=<c:out value="${idUser }" />">
                  <span data-feather="home"></span>
                  Mon Profile 
                  <!-- <span class="sr-only">(current)</span> -->
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="afficher">
                  <span data-feather="file"></span>
                  Gestion des specialit&eacute;s
                </a>
              </li>
              
              <li class="nav-item">
              <a href="#ajouteruser" data-toggle="collapse" aria-expanded="false"  class="nav-link dropdown-toggle">
                  <span data-feather="file"></span>
                  Gestion des classes
                </a>
                
				 <ul class="collapse list-unstyled" id="ajouteruser">
				 <a href="#Ens" data-toggle="collapse" aria-expanded="false"  class="nav-link dropdown-toggle">
				 <span data-feather="user-plus"></span>
                   Enseignants  
                  </a>
                   <ul class="collapse list-unstyled" id="Ens">
				      <c:forEach var="F" items="${listSp }" >
   					 <li class="dropdown" >
                         <a class="nav-link" href="displayEns?idf=<c:out value="${F.idSp}"/>&filiere=<c:out value="${F.nomSp}" />" >
                             <c:out value="${F.nomSp }" />
                         </a>
					<div class="dropdown-menu" >
                     <a class="dropdown-item"  href="EnseignantsByclass?idf=<c:out value="${F.idSp}"/>&nv=1ere annee">1ère année</a>
                     <a class="dropdown-item" href="EnseignantsByclass?idf=<c:out value="${F.idSp}"/>&nv=2eme annee">2ème année</a>
                     </div>
                     </li>
                    </c:forEach>
   				 </ul> 
   				 
				 <a href="#Etd" data-toggle="collapse" aria-expanded="false"  class="nav-link dropdown-toggle">
				 <span data-feather="user-plus"></span>
                     Etudiants 
                  </a>
                   <ul class="collapse list-unstyled" id="Etd">
				      <c:forEach var="F" items="${listSp }" >
   					 <li class="dropdown" >
                         <a class="nav-link" href="displayEtd?idf=<c:out value="${F.idSp}"/>&filiere=<c:out value="${F.nomSp}" />">
                             <c:out value="${F.nomSp }" />
                         </a>
					<div class="dropdown-menu" >
                     <a class="dropdown-item"  href="EtudiantsByclass?idf=<c:out value="${F.idSp}"/>&nv=1ere annee">1ère année</a>
                     <a class="dropdown-item" href="EtudiantsByclass?idf=<c:out value="${F.idSp}"/>&nv=2eme annee">2ème année</a>
                     </div>
                     </li>
                    </c:forEach>
   				 </ul> 
   				 
   				 </ul>
              </li>
              
             <li class="nav-item">
				<a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false"  class="nav-link dropdown-toggle">
                  <span data-feather="file"></span>
                  Gestion des unit&eacute;s
                </a>
				 <ul class="collapse list-unstyled" id="homeSubmenu">
				 <c:forEach var="F" items="${listSp }" >
   					 <li class="dropdown" >
                         <a class="nav-link" href="displayUni?idf=<c:out value="${F.idSp}"/>&filiere=<c:out value="${F.nomSp}" />">
                             <c:out value="${F.nomSp }" />
                         </a>
					<div class="dropdown-menu" >
                     <a class="dropdown-item"  href="displayUnibyLevel?idf=<c:out value="${F.idSp}"/>&nv=1ere annee">1ère année</a>
                     <a class="dropdown-item" href="displayUnibyLevel?idf=<c:out value="${F.idSp}"/>&nv=2eme annee">2ème année</a>
                     </div>
                     </li>
                    </c:forEach>
   				 </ul> 
               </li>
               <li class="nav-item">
				<a href="#Modules" data-toggle="collapse" aria-expanded="false"  class="nav-link dropdown-toggle">
                  <span data-feather="file"></span>
                  Gestion des modules
                </a>
                <ul class="collapse list-unstyled" id="Modules">
				 <c:forEach var="Fl" items="${listSp }" >
   					 <li class="dropdown" >
                         <a class="nav-link" href="displayModules?idf=<c:out value="${Fl.idSp}"/>&filiere=<c:out value="${Fl.nomSp}" />">
                             <c:out value="${Fl.nomSp }" />
                         </a>
					<div class="dropdown-menu" >
                     <a class="dropdown-item"  href="displayModuleLevel?idf=<c:out value="${Fl.idSp}"/>&nv=1ere annee">1ère année</a>
                     <a class="dropdown-item" href="displayModuleLevel?idf=<c:out value="${Fl.idSp}"/>&nv=2eme annee">2ème année</a>
                     </div>
                     </li>
                    </c:forEach>
   				 </ul> 
               </li>
			  <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
              <span>Gestion des examens</span>
            </h6>
              <li class="nav-item">
                <a class="nav-link" href="ExamPassage?nameE=Passage">
                  <span data-feather="book"></span>
                   Examens de passage
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="ExamNational?nameE=National">
                  <span data-feather="book"></span>
                  Examens nationale
                </a>
              </li>
       
            </ul>

            <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
              <span>Gestion des utilisateurs</span>
             
            </h6>
            <ul class="nav flex-column mb-2">
              <li class="nav-item">
                <a class="nav-link" href="list?roleE=Enseignant">
                  <span data-feather="user-plus"></span>
                  Enseignants
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="list?roleEt=Etudiant">
                  <span data-feather="user-plus"></span>
                  Etudiants
                </a>
              </li>
			        <li class="nav-item">
                <a class="nav-link" href="logout">
                  <span data-feather="log-out"></span>
                  D&eacute;connecter
                </a>
              </li>
            </ul>
          </div>
        </nav>
        