package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.examenDAO;
import Model.Examen;

@WebServlet("/formulaireModifEx")
public class formulaireModifEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private examenDAO exDAO;
	    public void init(){
	    	exDAO = new examenDAO();
	    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nameE = request.getParameter("nameE");
		request.setAttribute("nameE", nameE);
		int idEx = Integer.parseInt(request.getParameter("idEx"));
		request.setAttribute("idEx", idEx);
		Examen e = exDAO.unEx(idEx);
		request.setAttribute("Ex", e);
		System.out.println("Examen : "+e);
		
		if (nameE.equals("Passage")){
		RequestDispatcher dispatcher = request.getRequestDispatcher("AddDateExP.jsp");
        dispatcher.forward(request, response);
		}
		if (nameE.equals("National")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("AddDateExN.jsp");
	        dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
