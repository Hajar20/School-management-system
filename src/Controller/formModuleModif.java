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
import DAOClasses.moduleDAO;
import DAOClasses.uniteDAO;
import Model.Module;
import Model.Unite;
import Model.Utilisateur;


@WebServlet("/formModuleModif")
public class formModuleModif extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private moduleDAO mdDao;
    private uniteDAO unDao;
    private classEnsDAO enDao;
	public void init(){
		mdDao = new moduleDAO();
		unDao = new uniteDAO();
		enDao = new classEnsDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	   	response.setContentType("text/html;charset=utf-8");
		
		int i = Integer.parseInt(request.getParameter("idMod"));
		String  nv = request.getParameter("nv");
		String prof = request.getParameter("prof");
		String uni = request.getParameter("uni");
		request.setAttribute("lvl", nv);
		
		Module md = mdDao.OneMod(i,prof,uni);
		request.setAttribute("Mod", md);
		int idff = Integer.parseInt(request.getParameter("idff"));
		request.setAttribute("idff", idff);
		
		int idClass = unDao.idClass(idff, nv);
   	    System.out.println("idClass : "+idClass);
   	    ArrayList<Utilisateur> ut = enDao.namesByClass(idClass);
   	    request.setAttribute("professeurs", ut);
   	    
   	    ArrayList<Unite> u = unDao.UnitesByLevel(idClass);
   	    request.setAttribute("unities", u);
		RequestDispatcher dispatcher = request.getRequestDispatcher("formMod.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
