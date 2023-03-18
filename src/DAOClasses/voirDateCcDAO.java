package DAOClasses;

import java.sql.*;
import java.util.*;

import jdbc.connection.ConnectionJdbc;
import Model.ControleContinueDates;

public class voirDateCcDAO {
     private final String selectModules = "select Nom_mod,Date_Cc from module m inner join contrôlecontinu cc On m.idMod = cc.idMod inner join moduleclass mc ON m.idMod = mc.idMod where mc.idClass = ?";
     
     public ArrayList<ControleContinueDates> getModules(int idClass){
    	 ArrayList<ControleContinueDates>  cc = new ArrayList<ControleContinueDates>() ;
    	 try{
    		 PreparedStatement pst = ConnectionJdbc.getInstance().getCnx().prepareStatement(selectModules);
    		 pst.setInt(1, idClass);
    		 ResultSet rss = pst.executeQuery();
    		 while(rss.next())
    			 cc.add(new ControleContinueDates(rss.getString(1),rss.getString(2)));
    		 
    	 } catch(SQLException e){
    		 System.out.println("err getModules : "+e.getMessage());
    	 }
    	 return cc;
     }
}
