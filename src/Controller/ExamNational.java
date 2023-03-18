package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.examenDAO;
import Model.Examen;

@WebServlet("/ExamNational")
public class ExamNational extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private examenDAO exDAO;
    public void init(){
    	exDAO = new examenDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomE = request.getParameter("nameE");
		ArrayList<Examen> ex = exDAO.selectExs(nomE);
		request.setAttribute("listExm", ex);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ExamNationale.jsp");
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
