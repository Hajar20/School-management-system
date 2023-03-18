package DAOClasses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jdbc.connection.ConnectionJdbc;
import Model.Utilisateur;

import com.mysql.jdbc.PreparedStatement;

public class classEnsDAO {
	private final String insert = "insert into classens values(?,?)";
	private final String remove = "delete from classens where idUser = ?";

	private final String selectAll = "select utilisateur.idUser,Nom,Prenom,Matricule from utilisateur  inner join classens  ON utilisateur.idUser = classens.idUser where idClass = ? ";
	private final String selectAll1 = "select Distinct utilisateur.idUser,Nom,Prenom,Matricule from utilisateur  inner join classens  ON utilisateur.idUser = classens.idUser inner join classe ON classens.idClass =classe.idClass where idF = ? ";
    private final String selectIDEns = "select idUser from utilisateur where CONCAT(Nom,' ',Prenom)=?";
    private final String fullName = "select idUser,Nom,Prenom from utilisateur where   `role` =  'Enseignant'";
    
    private final String fullNames = "select  CONCAT(Nom,' ',Prenom) from utilisateur inner join classens  ON utilisateur.idUser = classens.idUser where idClass = ? ";
	
    private final String nomComplet = "select CONCAT(Nom,' ',Prenom) from utilisateur where idUser = ?"; 
    private final String idCls = "select idClass from classe where idF = ? and Niveau = ?";

    
    public String fullName(int id){
    	String nc = null;
    	try {
    		PreparedStatement pst =(PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(nomComplet);
    		pst.setInt(1, id);
    		ResultSet rs = pst.executeQuery();
    		if(rs.next())
    			nc = rs.getString(1);
    	} catch(SQLException e){
    		e.printStackTrace();
    	}
    	return nc;
    }
	
	    public int idEns(String fullName){
	    	int id = 0;
	    	try {
	    		PreparedStatement pst =(PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(selectIDEns);
	    		pst.setString(1, fullName);
	    		ResultSet rs = pst.executeQuery();
	    		if(rs.next())
	    			id = rs.getInt(1);
	    	} catch(SQLException e){
	    		e.printStackTrace();
	    	}
	    	return id;
	    }
        public ArrayList<Utilisateur> names(){
        	ArrayList<Utilisateur> lesNomes = new ArrayList<Utilisateur>();
        	try {
        		Statement st = ConnectionJdbc.getInstance().getCnx().createStatement();
        		ResultSet rs = st.executeQuery(fullName);
        		while(rs.next())
        			lesNomes.add(new Utilisateur(rs.getInt(1),rs.getString(2)+" "+rs.getString(3)));
        	} catch(SQLException e){e.printStackTrace();}
        	return lesNomes;
        }

	    public ArrayList<Utilisateur> LesEnseignantsbyFiliere(int idF){
	    	ArrayList<Utilisateur> list = new ArrayList<Utilisateur>();
	    	try {
	            PreparedStatement pst = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(selectAll1);
	            pst.setInt(1, idF);
	            ResultSet rs = pst.executeQuery();
	            while (rs.next())
	            	list.add(new Utilisateur (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
	    		
	    	} catch (SQLException e){e.printStackTrace(); }
	    	return list;
	    }

	    public int idClasse (int idf,String level){
	    	int id = 0;
	    	try {
	            PreparedStatement pst = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(idCls);
	            pst.setInt(1, idf);
	            pst.setString(2, level);
	            ResultSet rss = pst.executeQuery();
	            if (rss.next())
	            	id = rss.getInt(1);
	    		
	    	} catch (SQLException ex){ ex.printStackTrace(); }
	    	return id;
	    }

	    public ArrayList<Utilisateur> LesEnseignantsbyClass(int idClass){
	    	try{
	    		ArrayList<Utilisateur> list = new ArrayList<Utilisateur>();
	            PreparedStatement pst = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(selectAll);
	            pst.setInt(1, idClass);
	            ResultSet rs = pst.executeQuery();
	            while (rs.next())
	            	list.add(new Utilisateur (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
	    		
	            return list;
	    	} catch (SQLException ex){ex.printStackTrace();return null; }
	    }



	    public int addEnsClass (int idUser, int idClass){
		try {
	        PreparedStatement pst = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(insert);
			pst.setInt(1, idClass);
			pst.setInt(2, idUser);
			return pst.executeUpdate();
		} catch (SQLException e){ e.printStackTrace(); return -1; }
	}


	    public int del(int idUser){
		try{
	        PreparedStatement pst = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(remove);
	        pst.setInt(1, idUser);
	        return pst.executeUpdate();
		} catch (SQLException e){ e.printStackTrace();return -1; }
	    }

	    
	    public ArrayList<Utilisateur> namesByClass(int idClass){
        	ArrayList<Utilisateur> lesNomes = new ArrayList<Utilisateur>();
        	try {
        		PreparedStatement pst = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(fullNames);
	            pst.setInt(1, idClass);
        		ResultSet rs = pst.executeQuery();
        		while(rs.next())
        			lesNomes.add(new Utilisateur(0,rs.getString(1)));
        	} catch(SQLException e){e.printStackTrace();;}
        	return lesNomes;
        }
	    
	    
	    
}
