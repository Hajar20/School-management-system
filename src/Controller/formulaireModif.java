package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.uniteDAO;
import Model.Unite;

@WebServlet("/formulaireModif")
public class formulaireModif extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private uniteDAO uniDao;
	
	public void init(){
		uniDao = new uniteDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i = Integer.parseInt(request.getParameter("idU"));
		String  nv = request.getParameter("nv");  
		request.setAttribute("lvl", nv);
		Unite un = uniDao.unUnite(i);
		request.setAttribute("uni", un);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UniteForm.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
