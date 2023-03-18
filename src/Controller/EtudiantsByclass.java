package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAOClasses.classEtdDAO;
import Model.Utilisateur;

@WebServlet("/EtudiantsByclass")
public class EtudiantsByclass extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	  private classEtdDAO EtdDao;
		
		public void init(){
			EtdDao = new classEtdDAO();
		}
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
		   	response.setContentType("text/html;charset=utf-8;");
			int idf = Integer.parseInt(request.getParameter("idf"));
			String level =request.getParameter("nv");
			System.out.println("idF : "+idf+" level : "+level);
			request.setAttribute("idfiliere", idf);
			request.setAttribute("lvl", level);
			int idClass= EtdDao.idClasse(idf, level);
			ArrayList<Utilisateur> EtdL = EtdDao.LesEtudiantsbyClass(idClass);
			request.setAttribute("listEtdLv", EtdL);
			RequestDispatcher dispatcher = request.getRequestDispatcher("studentsByLevel.jsp");
			dispatcher.forward(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
