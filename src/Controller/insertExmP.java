package Controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.examenDAO;
import Model.Examen;

@WebServlet("/insertExmP")
public class insertExmP extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private examenDAO exDAO;
	    public void init(){
	    	exDAO = new examenDAO();
	    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dateEx = request.getParameter("DateExP");
		String nameE = request.getParameter("nameE");
		Examen e = new Examen(nameE,dateEx,null);
		int etat = exDAO.addEx(e);
		System.out.println("etat : "+etat);
		response.sendRedirect("ExamPassage?nameE="+nameE+"");
	}

}
