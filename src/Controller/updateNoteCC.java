package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.ConContDAO;

import Model.ConCont;


/**
 * Servlet implementation class updateNoteCC
 */
@WebServlet("/updateNoteCC")
public class updateNoteCC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private ConContDAO ccDAO;
	
	public void init(){
    	ccDAO= new ConContDAO();
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idUser = Integer.parseInt(request.getParameter("idUser"));
		int idCC = Integer.parseInt(request.getParameter("idCC"));
		
		System.out.println(idCC);
		int idClass = Integer.parseInt(request.getParameter("idClass"));
		System.out.println(idClass);

		ArrayList<ConCont> lNoteCC=ccDAO.selectNoteCC(idCC);
		
		for(int i=0;i<lNoteCC.size();i++) {
			Float note=Float.parseFloat(request.getParameter(lNoteCC.get(i).getfullName()));
			ccDAO.modifiNote(lNoteCC.get(i).getidUser(), idCC, note);
			System.out.println(note);
			System.out.println(idCC);
			System.out.println(lNoteCC.get(i).getidUser());
		}
		 response.sendRedirect("AfficherNoteCC?idCLasse="+idClass+"&idUser="+idUser+"");
		
		
	}
}


