package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/formulaireAjout")
public class formulaireAjout extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	   	response.setContentType("text/html;charset=utf-8;"); 
		int idff = Integer.parseInt(request.getParameter("idff"));
   	  String nv = request.getParameter("niveau");
   	  request.setAttribute("idff", idff);
   	  request.setAttribute("nv", nv);
   	  
   	RequestDispatcher dispatcher = request.getRequestDispatcher("UniteForm.jsp");
 		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
