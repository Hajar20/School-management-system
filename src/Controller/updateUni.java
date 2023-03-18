package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.uniteDAO;
import Model.Unite;

@WebServlet("/updateUni")
public class updateUni extends HttpServlet {
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
		int i = Integer.parseInt(request.getParameter("idUnit"));
		String nomuni = request.getParameter("uniteN");
		int c = Integer.parseInt(request.getParameter("coeffi"));
		String  nve = request.getParameter("nveau");
		uniDao.updateUni(new Unite(i,nomuni,c));
		int idF = uniDao.idFiliere(i);
		
		response.sendRedirect("displayUnibyLevel?idf="+idF+"&nv="+nve+"");
	}

}
