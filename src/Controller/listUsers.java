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

@WebServlet("/list")
public class listUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
private userDAO uDao;
	
	public void init(){
		uDao = new userDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rE = request.getParameter("roleE");
		String rEt = request.getParameter("roleEt");
		if(rEt != null){
			ArrayList<Utilisateur> listeEtudiants = uDao.selectAllUsers(rEt);
			request.setAttribute("Etd" , listeEtudiants);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listEtd.jsp");
			dispatcher.forward(request, response);
		}
		
		if (rE != null){
		ArrayList<Utilisateur> listeEnseignants = uDao.selectAllUsers(rE); 
		request.setAttribute("Ens" , listeEnseignants);
		//System.out.println("ens : "+listeEnseignants);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listEns.jsp");
		dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
}
