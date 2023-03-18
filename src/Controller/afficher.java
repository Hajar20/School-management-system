package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAOClasses.specialiteDAO;
import Model.Specialite;

@WebServlet("/afficher")
public class afficher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private specialiteDAO spcDao;
	
	public void init(){
		spcDao = new specialiteDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  ArrayList<Specialite> liste = spcDao.displayAll();
		  request.setAttribute("listSp", liste);

		     RequestDispatcher dispatcher = request.getRequestDispatcher("specialite.jsp");
			 dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
