package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import DAOClasses.uniteDAO;
import Model.Unite;

@WebServlet("/displayUnibyLevel")
public class displayUnibyLevel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private uniteDAO uniDao;
	
	public void init(){
		uniDao = new uniteDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	   	response.setContentType("text/html;charset=utf-8;");
	   	
		int idf = Integer.parseInt(request.getParameter("idf"));
		String level =request.getParameter("nv");
		
		System.out.println("idF : "+idf+" level : "+level);
		request.setAttribute("idfiliere", idf);
		request.setAttribute("lvl", level);
		int idClass= uniDao.idClass(idf, level);
		ArrayList<Unite> unL = uniDao.UnitesByLevel(idClass);
		request.setAttribute("listUnL", unL);
		RequestDispatcher dispatcher = request.getRequestDispatcher("unitNiveau.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
