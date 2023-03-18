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
 * Servlet implementation class AffModifNote
 */
@WebServlet("/AffModifNote")
public class AffModifNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ConContDAO ccDAO;
	 
    public void init(){
    	ccDAO= new ConContDAO();
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idClasse = Integer.parseInt(request.getParameter("idClass"));
		int idCC = Integer.parseInt(request.getParameter("idCC"));
		String filiere = (request.getParameter("filiere"));
		String anne = (request.getParameter("anne"));
		String DateCC = (request.getParameter("DateCC"));
		String module = (request.getParameter("module"));
		
		
		
		ArrayList<ConCont> lNoteCC= ccDAO.selectNoteCC(idCC);
		for(int i=0;i<lNoteCC.size();i++) {System.out.println(lNoteCC.get(i).getfullName());}
		
		if(lNoteCC.size()!=0) {
			
			request.setAttribute("lNoteCC" , lNoteCC);
		request.setAttribute("filiere" , filiere);
		request.setAttribute("anne" , anne);
		request.setAttribute("DateCC" , DateCC);
		request.setAttribute("module" , module);
		request.setAttribute("idCC" , idCC);
		request.setAttribute("idClass" , idClasse);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AffModifNote.jsp");
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
