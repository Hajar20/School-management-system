package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.classEnsDAO;

import Model.Utilisateur;

@WebServlet("/displayEns")
public class displayEns extends HttpServlet {
	private static final long serialVersionUID = 1L;

       private classEnsDAO ensDao;
	           public void init(){
		             ensDao = new classEnsDAO();
	           }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idf = Integer.parseInt(request.getParameter("idf"));
		String sp= request.getParameter("filiere");
		request.setAttribute("nameSp", sp);
		ArrayList<Utilisateur> un = ensDao.LesEnseignantsbyFiliere(idf);
		request.setAttribute("listEns", un);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Teachers.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
