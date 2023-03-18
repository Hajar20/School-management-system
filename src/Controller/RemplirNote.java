package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAOClasses.userDAO;

import Model.Utilisateur;

/**
 * Servlet implementation class RemplirNote
 */
@WebServlet("/RemplirNote")
public class RemplirNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private userDAO etudClassDAO;
	 
    public void init(){
    	etudClassDAO= new userDAO();
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idClasse = Integer.parseInt(request.getParameter("idClass"));
		int idCC = Integer.parseInt(request.getParameter("idCC"));
		String filiere = (request.getParameter("filiere"));
		String anne = (request.getParameter("anne"));
		String DateCC = (request.getParameter("DateCC"));
		String module = (request.getParameter("module"));
		
		
		
		
		ArrayList<Utilisateur> lEtudClass=etudClassDAO.selectEtudClass(idClasse);
		
		

		request.setAttribute("letudclass" , lEtudClass);
		request.setAttribute("filiere" , filiere);
		request.setAttribute("anne" , anne);
		request.setAttribute("DateCC" , DateCC);
		request.setAttribute("module" , module);
		request.setAttribute("idCC" , idCC);
		request.setAttribute("idClass" , idClasse);
		RequestDispatcher dispatcher = request.getRequestDispatcher("RemplirNote.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
