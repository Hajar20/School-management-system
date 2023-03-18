package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.uniteDAO;
import Model.Unite;

@WebServlet("/insertUni")
public class insertUni extends HttpServlet {
	private static final long serialVersionUID = 1L;
private uniteDAO uniDao;
	
	public void init(){
		uniDao = new uniteDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	   	response.setContentType("text/html;charset=utf-8;");
		String nom = request.getParameter("uniteN");
		 int coeff = Integer.parseInt(request.getParameter("coeffi"));
		 int idFil = Integer.parseInt(request.getParameter("idff"));
		 String nvClass = request.getParameter("nveau");
		 int numClass = uniDao.idClass(idFil, nvClass);
		 uniDao.ajouterUni(new Unite(nom,coeff), idFil,numClass);
		 response.sendRedirect("displayUnibyLevel?idf="+idFil+"&nv="+nvClass+"");
	}

}
