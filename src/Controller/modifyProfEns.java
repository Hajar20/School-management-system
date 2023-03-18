package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.userDAO;
import Model.Utilisateur;

@WebServlet("/modifyProfEns")
public class modifyProfEns extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private userDAO uDao;
	    public void init(){
			uDao = new userDAO();
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idDir = Integer.parseInt(request.getParameter("idDir"));
	     request.setAttribute("idDir", idDir);
	     System.out.println("idDir : "+idDir);
	     Utilisateur directeur = uDao.selectUser(idDir);
	     request.setAttribute("dirct", directeur);
	     String img = uDao.photo(idDir);
	     request.setAttribute("imageDir", img);
	     String r = request.getParameter("role");
	     request.setAttribute("roleE", r);
	 	RequestDispatcher dispatcher = request.getRequestDispatcher("formProfileEts.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
