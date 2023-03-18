package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOClasses.ConContDAO;
import Model.ConCont;
import Model.Module;


@WebServlet("/SaisiNoteCC")
public class SaisiNoteCC extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConContDAO ccDAO;
	 
    public void init(){
    	ccDAO= new ConContDAO();
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idClasse = Integer.parseInt(request.getParameter("idCLasse"));
		int idUser = Integer.parseInt(request.getParameter("idUser"));
		ArrayList<Module> lModEns=ccDAO.selectmoduleEnsei(idUser);
		ArrayList<Module> lModClass=ccDAO.selectmoduleclass(idClasse);
		ArrayList<Module> listModule = new ArrayList<Module>();
		for(int i=0;i<lModEns.size();i++)
		{
			for(int j=0;j<lModClass.size();j++)
			{
				if(lModEns.get(i).getNomMod().equalsIgnoreCase(lModClass.get(j).getNomMod())) {
					listModule.add(new Module(lModClass.get(j).getIdMod(),lModClass.get(j).getNomMod()));
				}
			}}

		//ArrayList<Module> lMod=ccDAO.selectmodule();
		ArrayList<ConCont> lCC=ccDAO.selectAllCC(idUser,idClasse);
		request.setAttribute("lcc" , lCC);
		request.setAttribute("lMod" , listModule);
		request.setAttribute("idUser" , idUser);
		request.setAttribute("idClasse" , idClasse);
		RequestDispatcher dispatcher = request.getRequestDispatcher("SaisiNoteCCPro.jsp");
		dispatcher.forward(request, response);}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
