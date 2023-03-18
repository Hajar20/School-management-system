package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.examenDAO;


@WebServlet("/updateExmN")
public class updateExmN extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private examenDAO exDAO;
    public void init(){
    	exDAO = new examenDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dateEx = request.getParameter("DateExN");
		String nameE = request.getParameter("nameE");
		int idEx = Integer.parseInt(request.getParameter("idEx"));
		int etat = exDAO.updateEx(dateEx, idEx);
		System.out.println("etat : "+etat);
		response.sendRedirect("ExamNational?nameE="+nameE+"");
	}

}
