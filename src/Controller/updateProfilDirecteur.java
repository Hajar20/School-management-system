package Controller;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import DAOClasses.userDAO;
import Model.Utilisateur;

@WebServlet("/updateProfilDirecteur")
@MultipartConfig
public class updateProfilDirecteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private userDAO uDao;
	public void init(){
		uDao = new userDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			 request.setCharacterEncoding("UTF-8");
			 response.setContentType("text/html;charset=utf-8;");
		 int id = Integer.parseInt(request.getParameter("id"));
         request.setAttribute("idDir", id);
		 String nom = request.getParameter("nom");
		 String prenom = request.getParameter("prenom");
		 String email = request.getParameter("email");
		 String matricule = request.getParameter("matricule");
		 String date = request.getParameter("DateN");		 
		 String lieu =request.getParameter("lieu");
		 String adresse = request.getParameter("adresse");
		 String login = request.getParameter("login");
		 String password = request.getParameter("password");
		 String monImage = request.getParameter("picture");
	
		 String role = request.getParameter("role");
          //System.out.println("Role : "+role);
		 if (role.equals("Enseignant")){
			 Utilisateur u = new Utilisateur(id,nom,prenom,email,matricule,date,lieu,adresse,login,password,"Enseignant");
		 uDao.updateUser(u);
		 }
		 if(role.equals("Directeur")) {	 
			 Utilisateur u = new Utilisateur(id,nom,prenom,email,matricule,date,lieu,adresse,login,password,"Directeur");
			 uDao.updateUser(u);
		 }

		 if (monImage.equals("")){
		
		 } else {
			 uDao.updatePic(monImage, id);
		 }

		 if (role.equals("Enseignant")){
			 response.sendRedirect("profile?roleD=Enseignant&idDir="+id+"");
		 }
		if(role.equals("Directeur")){	
			 response.sendRedirect("profile?roleD=Directeur&idDir="+id+"");
		 }

	}

}
