package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.ConContDAO;

/**
 * Servlet implementation class insertProgrammeCC
 */
@WebServlet("/insertProgrammeCC")
public class insertProgrammeCC extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private ConContDAO ProgCC;
		public void init(){
			ProgCC = new ConContDAO();
		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	   	response.setContentType("text/html;charset=utf-8;");
		 int idUser = Integer.parseInt(request.getParameter("idUser"));
		 int idClasse = Integer.parseInt(request.getParameter("idClasse"));
		// String NomModule = request.getParameter("noms");
		 String DateCC = request.getParameter("DateCC");
		// int idMod = ProgCC.selectidMod(NomModule);
		 int idMod =Integer.parseInt(request.getParameter("noms"));
			System.out.println("id calsse"+idClasse);
			System.out.println("id user"+idUser);
			System.out.println("id mod"+idMod);
			System.out.println("id date"+DateCC);
		
         ProgCC.addCC( idUser, idClasse,  idMod, DateCC);
		 response.sendRedirect("ProgrammeCC?idCLasse="+idClasse+"&idUser="+idUser+"");
	}

}
