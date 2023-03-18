package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.specialiteDAO;
import Model.Specialite;

@WebServlet("/modifyForm")
public class modifyForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private specialiteDAO spcDao;
		
		public void init(){
			spcDao = new specialiteDAO();
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idS"));
        Specialite s = spcDao.displayOne(id);
        request.setAttribute("spct", s);
   	    RequestDispatcher dispatcher = request.getRequestDispatcher("SpecForm.jsp");
   	    dispatcher.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
