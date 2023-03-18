package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.voirDateExmDAO;
import Model.Classe;
import Model.Examen;

@WebServlet("/voirDateEx")
public class voirDateEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private voirDateExmDAO exDAO;
    public void init(){
    	exDAO = new voirDateExmDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int idEt = Integer.parseInt(request.getParameter("idEt"));
	Classe cl = exDAO.levelIdF(idEt);
	
	if (cl.getNiveau().equals("1ere annee")){
	Examen ex = exDAO.dateEx("Passage",cl.getIdF());
	request.setAttribute("dateEx", ex);
	} else if (cl.getNiveau().equals("2eme annee")){
	Examen ex = exDAO.dateEx("National",cl.getIdF());
	request.setAttribute("dateEx", ex);
	}
	RequestDispatcher dispatcher = request.getRequestDispatcher("consulterDateEx.jsp");
    dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
