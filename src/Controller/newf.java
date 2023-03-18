package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/new")
public class newf extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rE = request.getParameter("roleE");
		String rEt = request.getParameter("roleEt");
		if (rE != null){
		RequestDispatcher dispatcher = request.getRequestDispatcher("addForm.jsp");
		dispatcher.forward(request, response);
		}
		if (rEt != null){
			RequestDispatcher dispatcher = request.getRequestDispatcher("FormEtud.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
