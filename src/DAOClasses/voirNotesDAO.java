package DAOClasses;

import java.sql.*;
import java.util.*;
import com.mysql.jdbc.PreparedStatement;

import jdbc.connection.ConnectionJdbc;
import Model.NoteEtd;

public class voirNotesDAO {
      private final String selectGrades = "select Note,Nom_mod from note N inner join contrôlecontinu Cc ON N.idCc = Cc.idCc inner join module M ON M.idMod = Cc.idMod where N.idUser = ?";
      
      public ArrayList<NoteEtd> getGrades(int id){
    	  ArrayList<NoteEtd> etdGrades = new ArrayList<NoteEtd>();
    	  try {
    		  PreparedStatement pst = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(selectGrades);
    		  pst.setInt(1, id);
    		  ResultSet rss = pst.executeQuery();
    		  while(rss.next())
    			  etdGrades.add(new NoteEtd(rss.getFloat(1),rss.getString(2)));
    			  
    	  } catch (SQLException e){
    		  System.out.println("err sur getGrades : "+e.getMessage());
    	  }
    	  return etdGrades;
    	  
      }
}
