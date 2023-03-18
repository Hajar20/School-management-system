package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.moduleDAO;
import Model.Module;


@WebServlet("/displayModuleLevel")
public class displayModuleLevel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private moduleDAO modDao;
	public void init(){
		modDao = new moduleDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	   	response.setContentType("text/html;charset=utf-8;");
		int idf = Integer.parseInt(request.getParameter("idf"));
		String level =request.getParameter("nv");
		System.out.println("idF : "+idf+" level : "+level);
		request.setAttribute("idfiliere", idf);
		request.setAttribute("lvl", level);
		ArrayList<Module> m = modDao.modulesByFNv(idf,level);
		request.setAttribute("listMod", m);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ModulesByLevel.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
