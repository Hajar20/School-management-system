package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.classEtdDAO;
import Model.Utilisateur;

@WebServlet("/formEtdClass")
public class formEtdClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private classEtdDAO etdDao;
	 public void init(){
	 etdDao = new classEtdDAO();
	     }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	   	response.setContentType("text/html;charset=utf-8;"); 
		int idff = Integer.parseInt(request.getParameter("idff"));
  	    String nv = request.getParameter("niveau");
  	    request.setAttribute("idff", idff);
  	    request.setAttribute("nv", nv);
  	    ArrayList<Utilisateur> names = etdDao.names();
  	    request.setAttribute("names", names);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("etdClassForm.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
