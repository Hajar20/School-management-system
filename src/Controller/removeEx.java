package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.examenDAO;

@WebServlet("/removeEx")
public class removeEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private examenDAO exDAO;
	    public void init(){
	    	exDAO = new examenDAO();
	    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idEx"));
		String nameE = request.getParameter("nameE");
		int etat = exDAO.deleteEx(id);
		System.out.println("etat : "+etat);
		
		if (nameE.equals("Passage"))
		response.sendRedirect("ExamPassage?nameE="+nameE+"");
		
		if (nameE.equals("National"))
			response.sendRedirect("ExamNational?nameE="+nameE+"");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
