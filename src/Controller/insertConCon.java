package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.ConContDAO;
import DAOClasses.userDAO;

import Model.Utilisateur;


@WebServlet("/insertConCon")
public class insertConCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	
	private userDAO userDAO;
	private ConContDAO ccDAO;
	public void init(){
    	userDAO= new userDAO();
    	ccDAO=new ConContDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idUser = Integer.parseInt(request.getParameter("idUser"));
		int idCC = Integer.parseInt(request.getParameter("idCC"));
		
		System.out.println(idCC);
		int idClass = Integer.parseInt(request.getParameter("idClass"));
		System.out.println(idClass);

		ArrayList<Utilisateur> letudCC=userDAO.selectEtudClass(idClass);
		
		for(int i=0;i<letudCC.size();i++) {
			Float note=Float.parseFloat(request.getParameter(letudCC.get(i).getFullName()));
			ccDAO.addNote(letudCC.get(i).getIdUser(), idCC, note);
			//System.out.println(note);
			//System.out.println(idCC);
			//System.out.println(letudCC.get(i).getIdUser());
		}
		 response.sendRedirect("AfficherNoteCC?idCLasse="+idClass+"&idUser="+idUser+"");
		
		
	}

}
