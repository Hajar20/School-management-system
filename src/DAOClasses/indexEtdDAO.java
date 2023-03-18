package DAOClasses;

import java.sql.*;
import java.util.*;

import jdbc.connection.ConnectionJdbc;
import Model.SomeInfosEtd;

public class indexEtdDAO {
   private final String r = "select cc.idCc,Date_Cc,Nom_mod,Note from Note n inner join contrôlecontinu cc ON n.idCc = cc.idCc inner join module m ON m.idMod = cc.idMod inner join utilisateur u On u.idUser = n.idUser where u.idUser = ?";
   
   
   public ArrayList<SomeInfosEtd> grades(int idu){
 	  ArrayList<SomeInfosEtd> t = new ArrayList<SomeInfosEtd>();
 	  try {
 		  PreparedStatement st = ConnectionJdbc.getInstance().getCnx().prepareStatement(r);
 		  st.setInt(1, idu);
 		  ResultSet rs = st.executeQuery();
 		  while(rs.next())
 			  t.add(new SomeInfosEtd(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4)));
 	  } catch (SQLException e){
 		  System.out.println("Err sur methode grades : "+e.getMessage());
 	  }
		return t; 
   }
}
