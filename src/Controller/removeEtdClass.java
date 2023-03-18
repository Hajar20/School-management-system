package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.classEtdDAO;


@WebServlet("/removeEtdClass")
public class removeEtdClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private classEtdDAO etdDao;
	 public void init(){
	 etdDao = new classEtdDAO();
	     }
   
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int idu = Integer.parseInt(request.getParameter("idEtd"));
		 int idf = Integer.parseInt(request.getParameter("idf"));
		 etdDao.del(idu);
		 response.sendRedirect("EtudiantsByclass?idf="+idf+"&nv="+request.getParameter("nv")+"");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
