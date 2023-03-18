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

@WebServlet("/profile")
public class profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private profilesDAO prf;
    public void init(){
		prf = new profilesDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String role = request.getParameter("roleD");
				int id = Integer.parseInt(request.getParameter("idDir"));
				Utilisateur directeur = prf.getProfile(role,id);
				request.setAttribute("dirct", directeur);
				String pic = prf.getPhoto(id);	
				request.setAttribute("image", pic);
				if(role.equals("Enseignant")) {
					//request.setAttribute("Ens", role);
					RequestDispatcher dispatcher = request.getRequestDispatcher("MonProfileEns.jsp");
					dispatcher.forward(request, response);
					}
					if(role.equals("Directeur")) {
						//request.setAttribute("Dir", role);
						RequestDispatcher dispatcher = request.getRequestDispatcher("MonProfile.jsp");	
						dispatcher.forward(request, response);
					}
		        }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
   
}
