package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.uniteDAO;

@WebServlet("/removeUni")
public class removeUni extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private uniteDAO uniDao;
	
	public void init(){
		uniDao = new uniteDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int idu = Integer.parseInt(request.getParameter("idU"));
		 int idF = uniDao.idFiliere(idu);
		 uniDao.supprimerUni(idu);
		 response.sendRedirect("displayUnibyLevel?idf="+idF+"&nv="+request.getParameter("nv")+"");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
