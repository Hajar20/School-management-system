package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.profilesDAO;



@WebServlet("/updatePasswordImage")
public class updatePasswordImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	  private profilesDAO prf;
		public void init(){
	
			prf = new profilesDAO();
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 request.setCharacterEncoding("UTF-8");
	 response.setContentType("text/html;charset=utf-8;");
	 
	 int id = Integer.parseInt(request.getParameter("idEt"));
     request.setAttribute("idEt", id);
	 String newP = request.getParameter("newPassword");
	 String confirmNP = request.getParameter("confirmNewPassword");

	 if (newP.equals("") || confirmNP.equals("")){ 
		 String help = "notEmpty";
		 request.setAttribute("help", help);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("formProfileEtd.jsp");
		 dispatcher.forward(request, response);
		 return;
	 }
	 if (!newP.equals(confirmNP)){ 
		 String help2 = "notEmpty";
		 request.setAttribute("help2", help2);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("formProfileEtd.jsp");
		 dispatcher.forward(request, response);
		 return;
	 }
	
	 int etat = prf. updateProfileEtd(newP,id);
	 System.out.print("etat : "+etat);
	 response.sendRedirect("profileEtd?roleEt=Etudiant&idEt="+id+"");
	}

}
