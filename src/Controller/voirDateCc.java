package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.voirDateCcDAO;
import DAOClasses.voirDateExmDAO;
import Model.Classe;
import Model.ControleContinueDates;

@WebServlet("/voirDateCc")
public class voirDateCc extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private voirDateCcDAO ccDAO;
    private voirDateExmDAO exDAO;
    public void init(){
    	ccDAO = new voirDateCcDAO();
    	exDAO = new voirDateExmDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int idEt = Integer.parseInt(request.getParameter("idEt"));
	Classe idClass = exDAO.levelIdF(idEt);
	ArrayList<ControleContinueDates> listCc = ccDAO.getModules(idClass.getIdClass());
	request.setAttribute("listCc", listCc);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("consulterDateCc.jsp");
    dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
