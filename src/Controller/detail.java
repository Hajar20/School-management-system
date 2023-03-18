package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.userDAO;
import Model.Utilisateur;

@WebServlet("/detail")
public class detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
private userDAO uDao;
	
	public void init(){
		uDao = new userDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idu = Integer.parseInt(request.getParameter("id"));
		Utilisateur user = uDao.selectUser(idu);
		request.setAttribute("u", user);
		String img = uDao.photo(idu);
		request.setAttribute("pic", img);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Allinfos.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
