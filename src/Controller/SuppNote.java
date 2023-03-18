package Controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.ConContDAO;
import Model.ConCont;

/**
 * Servlet implementation class SuppNote
 */
@WebServlet("/SuppNote")
public class SuppNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConContDAO ccDAO;
	 
    public void init(){
    	ccDAO= new ConContDAO();
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idClasse = Integer.parseInt(request.getParameter("idCLasse"));
		int idUser = Integer.parseInt(request.getParameter("idUser"));
		int idCC = Integer.parseInt(request.getParameter("idCC"));
		ArrayList<ConCont> LConCont=new ArrayList<ConCont>();
		LConCont=ccDAO.selectNoteCC(idCC);
		if (ccDAO.deleteNoteCC(idCC) ) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("AfficherNoteCC?idCLasse="+idClasse+"&idUser="+idUser);
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("erreur.jsp");
			dispatcher.forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
