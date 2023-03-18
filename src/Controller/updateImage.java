package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAOClasses.userDAO;

@WebServlet("/updateImage")
public class updateImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private userDAO uDao;
		public void init(){
			uDao = new userDAO();
		} 
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idEt"));
	     request.setAttribute("idEt", id);
		String monImage = request.getParameter("picture");

		 if (monImage.equals("")){
		
		 } else {
			 uDao.updatePic(monImage, id);
		 }
		 
		 response.sendRedirect("profileEtd?roleEt=Etudiant&idEt="+id+"");
	}

}
