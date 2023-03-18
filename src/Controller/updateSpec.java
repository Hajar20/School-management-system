package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOClasses.specialiteDAO;
import Model.Specialite;


@WebServlet("/updateSpec")
public class updateSpec extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private specialiteDAO spcDao;
	
	public void init(){
		spcDao = new specialiteDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int id = Integer.parseInt(request.getParameter("idspc"));
	     String nameF = request.getParameter("specialite");
	     spcDao.updateFiliere(new Specialite(id,nameF));
	     
	     ArrayList<Specialite> liste = spcDao.displayAll();	
			HttpSession s = request.getSession();
			s.setAttribute("listSp", liste);
	     
	     response.sendRedirect("afficher");
	}

}
