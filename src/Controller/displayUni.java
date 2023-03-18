package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.uniteDAO;
import Model.Unite;

@WebServlet("/displayUni")
public class displayUni extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private uniteDAO uniDao;
	
	public void init(){
		uniDao = new uniteDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idf = Integer.parseInt(request.getParameter("idf"));
		String sp= request.getParameter("filiere");
		request.setAttribute("nameSp", sp);
		ArrayList<Unite> un = uniDao.Unites(idf);
		request.setAttribute("listUn", un);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Unities.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
