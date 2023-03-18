package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.voirNotesDAO;
import Model.NoteEtd;

@WebServlet("/voirNote")
public class voirNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private voirNotesDAO noteDAO;
	public void init(){
		noteDAO = new voirNotesDAO();
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int idu = Integer.parseInt(request.getParameter("idEt"));
	ArrayList<NoteEtd> grades = noteDAO.getGrades(idu);
	request.setAttribute("notes", grades);
	RequestDispatcher dispatcher = request.getRequestDispatcher("consulterNotes.jsp");
    dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
