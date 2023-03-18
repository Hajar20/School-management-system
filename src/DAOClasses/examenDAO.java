package DAOClasses;

import java.sql.*;
import java.util.*;

import jdbc.connection.ConnectionJdbc;
import Model.Examen;

public class examenDAO {
  
   private final String insert = "insert into examen values (?,?,?,Concat(year(?)-1,'/',year(?)))";
   private final String insert2 = "insert into examensp values (?,?)";
   
   private final String removeEx = "delete from examen where idEx=?";
  
   private final String update = "update examen set dateEx=?, anneeScolaire=Concat(year(dateEx)-1,'/',year(dateEx)) where idEx=?";
   
   private final String selectEx = "select * from examen where nomEx =?";
   private final String selectMaxId = "select max(idEx) from examen";
   private final String filieres = "select * from spécialité";
   private final String oneEx = "select * from examen where idEx =?";
   
   public Examen unEx(int id){
	   Examen ex = null;
	   try {
		   PreparedStatement pst = ConnectionJdbc.getInstance().getCnx().prepareStatement(oneEx);
		   pst.setInt(1,id);
		   ResultSet rs = pst.executeQuery();
		   while (rs.next())
			   ex = new Examen(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
	   }catch(SQLException e){
		   System.out.println("err selecting one exam : "+e.getMessage());
	   }
	   return ex;
   }
   
   
   public ArrayList<Integer> idSp(){
	   ArrayList<Integer> ids = new ArrayList<Integer>();
	   try {
		   Statement st = ConnectionJdbc.getInstance().getCnx().createStatement();
		   ResultSet rs = st.executeQuery(filieres);
		   while (rs.next())
			   ids.add(rs.getInt(1));
		   
	   } catch (SQLException e){
		   System.out.println("err recovering ids :"+e.getMessage());
	   }
	   return ids;
   }
   
   public int deleteEx(int idE){
	   int etat = 0;
	   try {

		   PreparedStatement pst2 = ConnectionJdbc.getInstance().getCnx().prepareStatement(removeEx);
		   pst2.setInt(1,idE);
		   
		   etat =  pst2.executeUpdate();
	   } catch(SQLException e){
		   System.out.println("err de la suppression : "+e.getMessage());
	   }
	   return etat;
   }
   
   public int updateEx(String dateE,int NumEx){
	   int etat = 0;
	   try {
		   PreparedStatement pst = ConnectionJdbc.getInstance().getCnx().prepareStatement(update);
		   pst.setString(1,dateE);
		   pst.setInt(2,NumEx);
		   
		   etat = pst.executeUpdate();
	   } catch (SQLException e){
		   System.out.println("err de l'update : "+e.getMessage());
	   }
	   
	   return etat;
   }
   
   public ArrayList<Examen> selectExs(String name){
	   ArrayList<Examen> list = new ArrayList<Examen>();
	   try {
		   PreparedStatement pst = ConnectionJdbc.getInstance().getCnx().prepareStatement(selectEx);
		   pst.setString(1,name);
		   ResultSet rs = pst.executeQuery();
		   while (rs.next())
			   list.add(new Examen(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
	   } catch(SQLException ex){
		   System.out.println("err de selectEx : "+ex);
	   }
	   return list;
   }
   
   public int addEx(Examen ex){
	   int etat =0;
	   try {
		   int id;
		   Statement st = ConnectionJdbc.getInstance().getCnx().createStatement();
		   ResultSet rss = st.executeQuery(selectMaxId);
		   if(rss.next())  
		   id = ((rss.getInt(1)) + 1);
		   else
		   id =1;
		   
		   PreparedStatement pst = ConnectionJdbc.getInstance().getCnx().prepareStatement(insert);
		   pst.setInt(1,id);
		   pst.setString(2, ex.getNomEx());
		   pst.setString(3, ex.getDateEx());
		   pst.setString(4, ex.getDateEx());
		   pst.setString(5, ex.getDateEx());
		   etat = pst.executeUpdate();
		   PreparedStatement ps = ConnectionJdbc.getInstance().getCnx().prepareStatement(insert2);
		   
		   ArrayList<Integer> idSp = idSp();
		   for (int i=0;i<idSp.size();i++){
			   ps.setInt(1,id);
			   ps.setInt(2, idSp.get(i));
			   etat += ps.executeUpdate();
		   }
	   } catch (SQLException e){
		   System.out.println("err de l'ajout :"+e.getMessage());
	   }
	   return etat;
   }
   
   
   
   
   
   
   
   
}
