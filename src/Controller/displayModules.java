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


@WebServlet("/displayModules")
public class displayModules extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private moduleDAO modDao;
		public void init(){
			modDao = new moduleDAO();
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idf = Integer.parseInt(request.getParameter("idf"));
		String sp= request.getParameter("filiere");
		request.setAttribute("nameSp", sp);
		ArrayList<Module> mod = modDao.modulesByF(idf);
		request.setAttribute("listMod", mod);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Modules.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
