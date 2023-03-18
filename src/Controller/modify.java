package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.userDAO;
import Model.Utilisateur;


@WebServlet("/modify")
public class modify extends HttpServlet {
	private static final long serialVersionUID = 1L;
private userDAO uDao;
	
	public void init(){
		uDao = new userDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rE = request.getParameter("roleE");
		String rEt = request.getParameter("roleEt");
		try {
			if (rE != null){
		int idE = Integer.parseInt(request.getParameter("id"));
		Utilisateur utilisExiste = uDao.selectUser(idE);
		request.setAttribute("userE", utilisExiste);
		RequestDispatcher dispatcher = request.getRequestDispatcher("addForm.jsp");
		dispatcher.forward(request, response);
		}
	    	if (rEt != null){
		int idE = Integer.parseInt(request.getParameter("id"));
		Utilisateur utilisExiste = uDao.selectUser(idE);
		request.setAttribute("userE", utilisExiste);
		RequestDispatcher dispatcher = request.getRequestDispatcher("FormEtud.jsp");
		dispatcher.forward(request, response);
		}
		}catch(Exception e) { System.out.println("Erreur : "+e.getMessage()); }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
