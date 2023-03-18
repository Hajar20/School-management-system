package DAOClasses;

import java.sql.*;


import jdbc.connection.ConnectionJdbc;
import Model.Classe;
import Model.Examen;

public class voirDateExmDAO {
  private final String seeExamDate = "select nomEx,dateEx,anneeScolaire from examen e inner join examensp es ON e.idEx = es.idEx where idF =? and nomEx = ? and year(dateEx)= year(CURDATE())";
  private final String levelAndspec = "select classe.idClass,Niveau,idF from classe  inner join etudclass ec ON classe.idClass = ec.idClass where idUser = ?";
  
  
  
  public Classe levelIdF(int id){
	  Classe LF = null;
	  try {
		  PreparedStatement ps = ConnectionJdbc.getInstance().getCnx().prepareStatement(levelAndspec);
		  ps.setInt(1, id);
		  ResultSet rs = ps.executeQuery();
		  if(rs.next())
            LF = new Classe(rs.getInt(1),rs.getString(2),rs.getInt(3));
	  } catch(SQLException e){
		  System.out.println("err selecting levelIdF :"+e.getMessage());
	  }
	  return LF;
  }
  
  public Examen dateEx(String nom,int id){
	  Examen ex = null;
	  try {
		  PreparedStatement ps = ConnectionJdbc.getInstance().getCnx().prepareStatement(seeExamDate);
		  ps.setInt(1, id);
		  ps.setString(2, nom);
		  ResultSet rs = ps.executeQuery();
		  if(rs.next())
			  ex = new Examen(rs.getString(1),rs.getString(2),rs.getString(3));
	  } catch(SQLException e){
		  System.out.println("err selecting dateEx :"+e.getMessage());
	  }
	  return ex;
  }
}
