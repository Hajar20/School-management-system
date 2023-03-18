package DAOClasses;


import java.sql.*;

import java.util.*;

import jdbc.connection.ConnectionJdbc;
import Model.*;

public class accueilDAO {
      private final String enseignants= "select CONCAT(u.Nom,' ',Prenom),Matricule,role,Niveau,s.Nom from utilisateur u inner join classens ce ON u.idUser = ce.idUser inner join classe c ON c.idClass = ce.idClass inner join spécialité s ON s.idF = c.idF";
      private final String etudiants= "select CONCAT(u.Nom,' ',Prenom),Matricule,role,Niveau,s.Nom from utilisateur u inner join etudclass ec ON u.idUser = ec.idUser inner join classe c ON c.idClass = ec.idClass inner join spécialité s ON s.idF = c.idF";
      private final String statistics = "SELECT cc.idCc,Date_Cc,Niveau,Nom,Nom_mod,max(Note),min(Note) "
      		+ "FROM contrôlecontinu cc "
      		+ "inner join classe c ON c.idClass = cc.idClass "
      		+ "inner join spécialité s ON s.idF = c.idF "
      		+ "inner join module m ON m.idMod = cc.idMod "
      		+ "inner join note n ON n.idCc = cc.idCc group by n.idCc";
      public ArrayList<SomeInfos> teachers(){
    	  ArrayList<SomeInfos> t = new ArrayList<SomeInfos>();
    	  try {
    		  Statement st = ConnectionJdbc.getInstance().getCnx().createStatement();
    		  ResultSet rs = st.executeQuery(enseignants);
    		  while(rs.next())
    			  t.add(new SomeInfos(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
    	  } catch (SQLException e){
    		  System.out.println("Err sur methode teachers : "+e.getMessage());
    	  }
		return t; 
      }
      public ArrayList<Statistics> gradesExams(){
    	  ArrayList<Statistics> t = new ArrayList<Statistics>();
    	  try {
    		  Statement st = ConnectionJdbc.getInstance().getCnx().createStatement();
    		  ResultSet rs = st.executeQuery(statistics);
    		  while(rs.next())
    			  t.add(new Statistics(rs.getInt(1),rs.getDate(2),rs.getString(4),rs.getString(3),rs.getString(5),rs.getFloat(6),rs.getFloat(7)));
    	  } catch (SQLException e){
    		  System.out.println("Err sur methode gradesExams : "+e.getMessage());
    	  }
		return t; 
      }
      public ArrayList<SomeInfos> students(){
    	  ArrayList<SomeInfos> t = new ArrayList<SomeInfos>();
    	  try {
    		  Statement st = ConnectionJdbc.getInstance().getCnx().createStatement();
    		  ResultSet rs = st.executeQuery(etudiants);
    		  while(rs.next())
    			  t.add(new SomeInfos(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
    	  } catch (SQLException e){
    		  System.out.println("Err sur methode students : "+e.getMessage());
    	  }
		return t; 
      }
      
      
}
