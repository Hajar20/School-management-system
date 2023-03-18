package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.classEnsDAO;



@WebServlet("/insertClassEns")
public class insertClassEns extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private classEnsDAO EnsDao;
	public void init(){
		EnsDao = new classEnsDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	   	response.setContentType("text/html;charset=utf-8;");
		 int idFil = Integer.parseInt(request.getParameter("idff"));
		 String nvClass = request.getParameter("nveau");
		 String nc = request.getParameter("noms");
		 int idu = EnsDao.idEns(nc);
		 int numClass = EnsDao.idClasse(idFil, nvClass);
         EnsDao.addEnsClass(idu, numClass);
		 response.sendRedirect("EnseignantsByclass?idf="+idFil+"&nv="+nvClass+"");
	}

}
