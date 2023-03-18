package DAOClasses;

import java.sql.*;

import jdbc.connection.ConnectionJdbc;
import Model.Utilisateur;

public class profilesDAO {
   private final String request = "select * from utilisateur where role = ? and idUser=?";
   private final String request2 = "select Image from utilisateur where idUser = ?";
   
   private final String updateEtd = "update utilisateur set MotDePass = ? where idUser = ?";
   
   public int updateProfileEtd(String psw,int idu){
	   int etat = 0;
	   try {
		   PreparedStatement pst = ConnectionJdbc.getInstance().getCnx().prepareStatement(updateEtd);		   
		   pst.setString(1, psw);
		   pst.setInt(2, idu);
		   etat = pst.executeUpdate();
		   
	   } catch (SQLException e){
		   e.printStackTrace();
	   }
	   return etat;
   }
   
   
   public Utilisateur getProfile(String r,int id){
	   Utilisateur u = null;
	   try{
			 PreparedStatement pst = ConnectionJdbc.getInstance().getCnx().prepareStatement(request);		   
			 pst.setString(1, r);
			 pst.setInt(2, id);
			 ResultSet rst = pst.executeQuery();
			 if (rst.next())
				 u = new Utilisateur(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8),rst.getString(9),rst.getString(10),rst.getString(12));
		   } catch(SQLException e){
			   e.printStackTrace();
		   }
		   return u;
   }
  public String getPhoto(int id){
	  String photo = null ;
	  try{
			 PreparedStatement pst = ConnectionJdbc.getInstance().getCnx().prepareStatement(request2);		   
			 pst.setInt(1, id);
			 ResultSet rst = pst.executeQuery();
			 if (rst.next())
				photo = rst.getString("Image");
		   } catch(SQLException e){
			   e.printStackTrace();
		   }
		   return photo;
  }  
}
