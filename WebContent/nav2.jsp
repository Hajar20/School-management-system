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
                <a class="nav-link " href="profile?roleD=Enseignant&idDir=<c:out value="${idUser }" />">
                  <span data-feather="home"></span>
                  Mon Profile 
                </a>
              </li>
                 <li class="nav-item">
              <a href="#notes" data-toggle="collapse" aria-expanded="false"  class="nav-link dropdown-toggle">
                  <span data-feather="file"></span>
                  Gestion des notes
                </a>

   				  <ul class="collapse list-unstyled" id="notes">
				 <a href="#Con" data-toggle="collapse" aria-expanded="false"  class="nav-link dropdown-toggle">
				 <span data-feather="file-plus"></span>
                   consulter la liste des notes 
                  </a>
                   <ul class="collapse list-unstyled" id="Con">
				     <c:forEach var="Fan" items="${sessionScope.listS }" >
   					 <li class="dropdown" >
                          <a class="nav-link"  href="AfficherNoteCC?idCLasse=<c:out value="${Fan.idNv}"/>&idUser=<c:out value="${sessionScope.idUser}" />">
                           <c:out value="${Fan.nomSp }" />  <c:out value="${Fan.niv }" /> 
                           </a>
                 
					
                     </li>
                    </c:forEach>
   				 </ul> 
   				 
				 <a href="#Sais" data-toggle="collapse" aria-expanded="false"  class="nav-link dropdown-toggle">
				 <span data-feather="file-plus"></span>
                     Saisie des notes 
                  </a>
                  <ul class="collapse list-unstyled" id="Sais">
				      <c:forEach var="Fan" items="${sessionScope.listS }" >
   					 <li class="dropdown" >
                         <a class="nav-link"  href="SaisiNoteCC?idCLasse=<c:out value="${Fan.idNv}"/>&idUser=<c:out value="${sessionScope.idUser}" />">
                            <c:out value="${Fan.nomSp }" />  <c:out value="${Fan.niv }" /> 
                         </a>
				
                    
                     </li>
                    </c:forEach>
   				 </ul> 
   				</ul> 
              </li>
            
              
			
			      <li class="nav-item">
              <a href="#CC" data-toggle="collapse" aria-expanded="false"  class="nav-link dropdown-toggle">
                  <span data-feather="file"></span>
                   Gestion des contrôles continus
                </a>
                
				 
   				 
   				  <ul class="collapse list-unstyled" id="CC">
				 <a href="#Prog" data-toggle="collapse" aria-expanded="false"  class="nav-link dropdown-toggle">
				 <span data-feather="file-plus"></span>
                  Programmer la date du contrôle continu
                  </a>
                   <ul class="collapse list-unstyled" id="Prog">
				      <c:forEach var="Fan" items="${sessionScope.listS}" >
   					 <li class="dropdown" >
                         <a class="nav-link"  href="ProgrammeCC?idCLasse=<c:out value="${Fan.idNv}"/>&idUser=<c:out value="${sessionScope.idUser}" />"> <c:out value="${Fan.nomSp }" />   <c:out value="${Fan.niv }" /></a>
                 
					
				
                     </li>
                    </c:forEach>
   				 </ul> 
   				 
				
   				</ul> 
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
                