package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.moduleDAO;

import Model.Module;


@WebServlet("/insertMod")
public class insertMod extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private moduleDAO modDao;
	public void init(){
		modDao = new moduleDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
	     response.setContentType("text/html;charset=utf-8;");
	     
		 String nomM = request.getParameter("nameMod");
		 int coeffM = Integer.parseInt(request.getParameter("coeffiMod"));
		 String unite = request.getParameter("nomsU");
		 String prof = request.getParameter("nomsE");
		 int idFil = Integer.parseInt(request.getParameter("idff"));
		 String nvClass = request.getParameter("nveau");
		 int numClass = modDao.addMod(new Module(nomM,coeffM,unite,prof),idFil,nvClass);
		 response.sendRedirect("displayModuleLevel?idf="+idFil+"&nv="+nvClass+"");
	}

}
