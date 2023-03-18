package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.profilesDAO;
import Model.Utilisateur;

@WebServlet("/profileEtd")
public class profileEtd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private profilesDAO prf;
	    public void init(){
			prf = new profilesDAO();
		}
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String role = request.getParameter("roleEt");
		int id = Integer.parseInt(request.getParameter("idEt"));
		Utilisateur etudiant = prf.getProfile(role,id);
		request.setAttribute("student", etudiant);
		String pic = prf.getPhoto(id);
		request.setAttribute("image", pic);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ProfileEtd.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
