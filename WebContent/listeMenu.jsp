<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<MARQUEE LOOP="-1"><a class="navbar-brand" href="#"><span><strong> Révision des notes </strong></span></a> </MARQUEE>
			</div>		
		</div>
		</nav>
        <div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar"  style=" box-shadow: 0 10px 20px rgba(0,0,0,0.19), 0 6px 6px rgba(0,0,0,0.23);">
         <br>
     <ul class="nav menu">
			<li>  <a href="#"><div><img src="pictures/school.jpg" height="190" width="210"></div></a></li>
     			 <br><br>

			<li>  <a href="profileEtd?idEt=<c:out value="${idUser }" />&roleEt=Etudiant" ><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user" /></use></svg>
			     <strong> Mon Profil</strong></a></li>		

		    <li>  <a href="voirNote?idEt=<c:out value="${idUser }" />"><svg class="glyph stroked blank document"><use xlink:href="#stroked-blank-document"/></svg></use>
         		 <strong>Notes</strong> </a></li>

		    <li>  <a href="voirDateCc?idEt=<c:out value="${idUser }" />"><svg class="glyph stroked open folder"><use xlink:href="#stroked-open-folder"/></svg></use></svg>
			     <strong> Date des contrôles</strong> </a></li>
			
			<li>  <a href="voirDateEx?idEt=<c:out value="${idUser }" />"><svg class="glyph stroked open folder"><use xlink:href="#stroked-open-folder"/></svg></use></svg>
			     <strong> Date des examens</strong> </a></li>
		<!-- <li> 
				 <a href="voirCours?idEt=<c:out value="${idUser }" />"><svg class="glyph stroked open folder"><use xlink:href="#stroked-open-folder"/></svg></use></svg>
			     <strong> Les cours</strong> </a></li>
			 -->	     
			
			<li role="presentation" class="divider"></li>
			
			<li>  <a href="logout"><svg class="glyph stroked lock"><use xlink:href="#stroked-lock"/></svg></use></svg>
    			 <strong>Déconnecter </strong></a></li>
     </ul>
</div>
<br><br>