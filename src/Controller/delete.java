package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.userDAO;

@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
private userDAO uDao;
	
	public void init(){
		uDao = new userDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		uDao.deleteUser(id);
		String rE = request.getParameter("roleE");
		String rEt = request.getParameter("roleEt");
		if (rE != null)
		response.sendRedirect("list?roleE="+rE+"");
		
		if (rEt != null)
		response.sendRedirect("list?roleE="+rEt+"");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
