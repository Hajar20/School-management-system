package DAOClasses;

import java.sql.*;
import java.util.ArrayList;

import jdbc.connection.ConnectionJdbc;
import Model.Unite;

public class uniteDAO {
	private final String uniteFiliere = "insert into unitespec values (?,?)";
	private final String uniteClasse = "insert into classeunite values (?,?)";
    private final String insert = "insert into unité values(?,?,?)";
    
    private final String delete = "delete from unité where idUni = ?";
    
    private final String update = "update unité set Nom_unite = ? , Coif_unité = ? where idUni=?";
    
    private final String selectAll = "select  DISTINCT unité.idUni,Nom_unite,Coif_unité from unité inner join unitespec on unité.idUni = unitespec.idUni where idF = ?";
    private final String selectOne = "select * from unité where idUni = ?";
    private final String selectAll2 = "select unité.idUni,Nom_unite,Coif_unité from unité inner join classeunite on unité.idUni = classeunite.idUni where idClass = ?";

    private final String selecIdF = "select idF from unitespec where idUni = ?";
    private final String selecIdClass = "select idClass from classe where idF = ? and Niveau = ?";
    
    private final String id = "select max(idUni) from unité";
     
     public boolean ajouterUni(Unite u,int idF,int idClass){
    	  int p1=0,p2=0,p3=0;
    	 try {
    		int idu;
    		Statement s = ConnectionJdbc.getInstance().getCnx().createStatement();
    		ResultSet r = s.executeQuery(id);
    		if (r.next()) 
    		idu = ((r.getInt(1)) + 1);
    		else
             idu = 1;
    		
            PreparedStatement pst = ConnectionJdbc.getInstance().getCnx().prepareStatement(insert);
            pst.setInt(1, idu);
            pst.setString(2, u.getNomUni());
            pst.setInt(3, u.getCoeffUni());
            
            PreparedStatement pst2 = ConnectionJdbc.getInstance().getCnx().prepareStatement(uniteFiliere);
            pst2.setInt(1, idu);
            pst2.setInt(2, idF);
            
            PreparedStatement pst3 = ConnectionJdbc.getInstance().getCnx().prepareStatement(uniteClasse);
            pst3.setInt(1, idClass);
            pst3.setInt(2, idu);
          
            p1 =  pst.executeUpdate();
            p2 =  pst2.executeUpdate();
            p3 =  pst3.executeUpdate();
            
    	} catch(SQLException e) {e.printStackTrace();}
    	 return p1>0 && p2>0 && p3>0;
    	
     }
	
     public int supprimerUni(int idU){
    	 try {
    		 PreparedStatement pst = ConnectionJdbc.getInstance().getCnx().prepareStatement(delete);
    		 pst.setInt(1, idU);
    		 return  pst.executeUpdate();
    		 
    	 } catch (SQLException e){e.printStackTrace();return -1;}
     }
     
     public int updateUni(Unite u){
    	 try {
    		 PreparedStatement pst = ConnectionJdbc.getInstance().getCnx().prepareStatement(update);
    		 pst.setString(1, u.getNomUni());
    		 pst.setInt(2, u.getCoeffUni());
    		 pst.setInt(3, u.getIdUni());
    		 return pst.executeUpdate();
    	 } catch (SQLException e) {e.printStackTrace();return -1; }
     }
     
     public ArrayList<Unite> Unites(int idF){
    	 ArrayList<Unite> unities = new ArrayList<Unite>();
    	 try {
    		 PreparedStatement st = ConnectionJdbc.getInstance().getCnx().prepareStatement(selectAll);
    		 st.setInt(1, idF);
    		 ResultSet rss = st.executeQuery();
    		 
    		 while (rss.next())
    			 unities.add(new Unite(rss.getInt(1),rss.getString(2),rss.getInt(3)));
    	 } catch (SQLException ex){ex.printStackTrace();}
    	 return unities;
     }
     public ArrayList<Unite> UnitesByLevel(int idClass){
    	 ArrayList<Unite> unities = new ArrayList<Unite>();
    	 try {
    		 PreparedStatement st = ConnectionJdbc.getInstance().getCnx().prepareStatement(selectAll2);
    		 st.setInt(1, idClass);
    		 ResultSet rss = st.executeQuery();
    		 while (rss.next()){ 
    			 unities.add(new Unite(rss.getInt(1),rss.getString(2),rss.getInt(3)));
    			 }
    	 } catch (SQLException ex){System.out.println("Expected error :"+ex.getMessage());}
    	 return unities;
     }
     public Unite unUnite(int idun){
    	 Unite unitie = null;
    	 try {
    		 PreparedStatement st = ConnectionJdbc.getInstance().getCnx().prepareStatement(selectOne);
    		 st.setInt(1, idun);
    		 ResultSet rss = st.executeQuery();
    		 
    		 if(rss.next())
    			unitie = new Unite(rss.getInt(1),rss.getString(2),rss.getInt(3));
    	 } catch (SQLException ex){ex.printStackTrace();}
    	 return unitie;
     }
     public int idClass(int idF,String niveau){
    	 int id=0;
    	 try {
    		 PreparedStatement st = ConnectionJdbc.getInstance().getCnx().prepareStatement(selecIdClass);
    		 st.setInt(1, idF);
    		 st.setString(2, niveau);
    		 ResultSet rss = st.executeQuery();
    		 if(rss.next())
    			id = rss.getInt(1);
    	 } catch (SQLException ex){ex.printStackTrace();}
    	 return id;
     }
     
     public int idFiliere(int idun){
    	 int id=0;
    	 try {
    		 PreparedStatement st = ConnectionJdbc.getInstance().getCnx().prepareStatement(selecIdF);
    		 st.setInt(1, idun);
    		 ResultSet rss = st.executeQuery();
    		 if(rss.next())
    			id = rss.getInt("idF");
    	 } catch (SQLException ex){ex.printStackTrace();}
    	 return id;
     }
}












