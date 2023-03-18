package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.moduleDAO;

@WebServlet("/removeMod")
public class removeMod extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private moduleDAO modDao;
	public void init(){
		modDao = new moduleDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idM = Integer.parseInt(request.getParameter("idMod"));
		int idf = Integer.parseInt(request.getParameter("idff"));
		String level =request.getParameter("nv");
		modDao.removeMod(idM);
		response.sendRedirect("displayModuleLevel?idf="+idf+"&nv="+level+"");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
