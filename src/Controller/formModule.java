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
import DAOClasses.uniteDAO;
import Model.Unite;
import Model.Utilisateur;

@WebServlet("/formModule")
public class formModule extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private uniteDAO unities;
    private classEnsDAO professeurs;
    public void init(){
    	unities = new uniteDAO();
    	professeurs = new classEnsDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	   	response.setContentType("text/html;charset=utf-8;");
	   	int idff = Integer.parseInt(request.getParameter("idff"));
   	    String nv = request.getParameter("niveau");
   	    request.setAttribute("idff", idff);
	    request.setAttribute("nv", nv);
	    
   	    int idClass = unities.idClass(idff, nv);
   	    System.out.println("idClass : "+idClass);
   	    ArrayList<Utilisateur> ut = professeurs.namesByClass(idClass);
   	    request.setAttribute("professeurs", ut);
   	    
   	    ArrayList<Unite> u = unities.UnitesByLevel(idClass);
   	    request.setAttribute("unities", u);
   	    
   	    RequestDispatcher dispatcher = request.getRequestDispatcher("formMod.jsp");
 		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
