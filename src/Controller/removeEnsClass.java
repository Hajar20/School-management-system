package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.classEnsDAO;


@WebServlet("/removeEnsClass")
public class removeEnsClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private classEnsDAO ensDao;
	
	public void init(){
		ensDao = new classEnsDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int idu = Integer.parseInt(request.getParameter("idEns"));
		 int idf = Integer.parseInt(request.getParameter("idf"));
		 ensDao.del(idu);
		 response.sendRedirect("EnseignantsByclass?idf="+idf+"&nv="+request.getParameter("nv")+"");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
