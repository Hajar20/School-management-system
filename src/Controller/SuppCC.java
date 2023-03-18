package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.ConContDAO;

/**
 * Servlet implementation class SuppCC
 */
@WebServlet("/SuppCC")
public class SuppCC extends HttpServlet {
	private static final long serialVersionUID = 1L;
private ConContDAO ccDAO;
	
	public void init(){
    	ccDAO= new ConContDAO();
    	
    }  
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idClasse = Integer.parseInt(request.getParameter("idClass"));
		int idCC = Integer.parseInt(request.getParameter("idCC"));
		int idUser = Integer.parseInt(request.getParameter("idUser"));
		ccDAO.deleteCC(idCC);
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ProgrammeCC?idCLasse="+idClasse+"&idUser="+idUser);
		dispatcher.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
