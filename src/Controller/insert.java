package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.userDAO;
import Model.Utilisateur;

@WebServlet("/insert")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private userDAO uDao;
	
	public void init(){
		uDao = new userDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String nom = request.getParameter("nom");
		 String prenom = request.getParameter("prenom");
		 String email = request.getParameter("email");
		 String matricule = request.getParameter("matricule");
		 String date = request.getParameter("DateN");		 
		 String lieu = request.getParameter("lieu");
		 String adresse = request.getParameter("adresse");
		 String login = request.getParameter("login");
		 String password = request.getParameter("password");
		 String role = request.getParameter("role");
		 Utilisateur u = new Utilisateur(nom,prenom,email,matricule,date,lieu,adresse,login,password,role);
		 uDao.addUser(u);
		 if (role.equals("Enseignant"))
		 response.sendRedirect("list?roleE="+role+"");
		 
		 if(role.equals("Etudiant"))
	     response.sendRedirect("list?roleEt="+role+"");
	}

}
