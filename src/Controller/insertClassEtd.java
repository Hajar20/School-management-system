package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.classEtdDAO;

@WebServlet("/insertClassEtd")
public class insertClassEtd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private classEtdDAO etdDao;
	 public void init(){
	 etdDao = new classEtdDAO();
	     }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	   	response.setContentType("text/html;charset=utf-8;");
		 int idFil = Integer.parseInt(request.getParameter("idff"));
		 String nvClass = request.getParameter("nveau");
		 String nc = request.getParameter("noms");
		 int idu = etdDao.idEtd(nc);
		 int numClass = etdDao.idClasse(idFil, nvClass);
		 etdDao.addEtdClass(idu, numClass);
		 response.sendRedirect("EtudiantsByclass?idf="+idFil+"&nv="+nvClass+"");
	}

}
