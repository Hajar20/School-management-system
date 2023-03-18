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

@WebServlet("/displayEtd")
public class displayEtd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   private classEtdDAO etdDao;
       public void init(){
             etdDao = new classEtdDAO();
       }
      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int idf = Integer.parseInt(request.getParameter("idf"));
         String sp= request.getParameter("filiere");
         request.setAttribute("nameSp", sp);
         ArrayList<Utilisateur> un = etdDao.LesEtudiantsbyFiliere(idf);
         request.setAttribute("listEtds", un);
         RequestDispatcher dispatcher = request.getRequestDispatcher("Students.jsp");
         dispatcher.forward(request, response);
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
