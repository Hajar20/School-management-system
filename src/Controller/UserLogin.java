package Controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOClasses.*;

import Model.*;


@WebServlet("/login")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private loginDAO lgDAO;
    private specialiteDAO spcDao;
    private accueilDAO accuDao;
    private indexEtdDAO accuEtdDao;
    public void init(){
    	lgDAO = new loginDAO();
    	spcDao = new specialiteDAO();
    	accuDao = new accueilDAO();
    	accuEtdDao = new indexEtdDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String login = request.getParameter("login");
	String password = request.getParameter("pwd");
    int id = lgDAO.idUser(login, password);
    
     
	Utilisateur user = new Utilisateur(login,password);
	
	HttpSession s = request.getSession();
	s.setAttribute("idUser", id);
	System.out.println(login+" "+password);
		if (lgDAO.validateForm(user)){
			
			s.setAttribute("login", login);
			s.setAttribute("password", password);
			
		if (lgDAO.role(login, password).equals("Directeur")){
			
			ArrayList<Specialite> liste = spcDao.displayAll();
			ArrayList<SomeInfos> listeEns = accuDao.teachers();
		    ArrayList<SomeInfos> listeStd = accuDao.students(); 
		 
		    
			s.setAttribute("listSp", liste);
			s.setAttribute("listeEns", listeEns);
		    s.setAttribute("listeStd", listeStd);
			 RequestDispatcher dispatcher = request.getRequestDispatcher("EspaceDirecteur.jsp");
             dispatcher.forward(request, response);
             
		} else if(lgDAO.role(login, password).equals("Enseignant")){
			ArrayList<Specialite> lista = spcDao.getClassEns(id);
		    ArrayList<Statistics> statistiques = accuDao.gradesExams();
			s.setAttribute("listS", lista);
			s.setAttribute("Statistics", statistiques);
			RequestDispatcher dispatcher = request.getRequestDispatcher("EspaceEnseignant.jsp");
            dispatcher.forward(request, response);
		
		} 
		
		else if (lgDAO.role(login, password).equals("Etudiant")){
			 ArrayList<SomeInfosEtd> notes = accuEtdDao.grades(id);
			 s.setAttribute("notes", notes);
			 
			RequestDispatcher dispatcher = request.getRequestDispatcher("EspaceEtudiant.jsp");
            dispatcher.forward(request, response);
		}
		
		} else {
			response.sendRedirect("Login.jsp");
		}
	
	}

}
