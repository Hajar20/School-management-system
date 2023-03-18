package DAOClasses;

import java.sql.*;
import java.util.ArrayList;

import Model.Utilisateur;

import com.mysql.jdbc.PreparedStatement;

import jdbc.connection.ConnectionJdbc;

public class classEtdDAO {

private final String insert = "insert into etudclass values(?,?)";

private final String remove = "delete from etudclass where idUser = ?";


private final String selectAll = "select utilisateur.idUser,Nom,Prenom,Matricule from utilisateur  inner join etudclass  ON utilisateur.idUser = etudclass.idUser where idClass = ? ";
private final String selectAll1 = "select Distinct utilisateur.idUser,Nom,Prenom,Matricule from utilisateur  inner join etudclass   ON utilisateur.idUser = etudclass.idUser inner join classe ON etudclass.idClass =classe.idClass where idF = ?  ";

private final String selectIDEtd = "select idUser from utilisateur where CONCAT(Nom,' ',Prenom)=?";
private final String fullName = "select idUser,Nom,Prenom from utilisateur where   `role` =  'Etudiant'";

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

    public int idEtd(String fullName){
    	int id = 0;
    	try {
    		PreparedStatement pst =(PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(selectIDEtd);
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
    	} catch(SQLException e){System.out.println("les nomes :"+e.getMessage());}
    	return lesNomes;
    }
    public ArrayList<Utilisateur> LesEtudiantsbyFiliere(int idF){
    	ArrayList<Utilisateur> list = new ArrayList<Utilisateur>();
    	try {
            PreparedStatement pst = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(selectAll1);
            pst.setInt(1, idF);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            	list.add(new Utilisateur (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
    		
    	} catch (SQLException e){System.out.println("probl etdFiliere :"+e.getMessage()); }
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
    		
    	} catch (SQLException ex){ System.out.println("id class problem :"+ex.getMessage()); }
    	return id;
    }

    public ArrayList<Utilisateur> LesEtudiantsbyClass(int idClass){
    	try{
    		ArrayList<Utilisateur> list = new ArrayList<Utilisateur>();
            PreparedStatement pst = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(selectAll);
            pst.setInt(1, idClass);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            	list.add(new Utilisateur (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
    		
            return list;
    	} catch (SQLException ex){ System.out.println("selection problm :"+ex.getMessage());return null; }
    }



    public int addEtdClass (int idUser, int idClass){
	try {
        PreparedStatement pst = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(insert);
		pst.setInt(1, idUser);
		pst.setInt(2, idClass);
		return pst.executeUpdate();
	} catch (SQLException e){ System.out.println("err:"+e.getMessage()); return -1; }
}


    public int del(int idUser){
	try{
        PreparedStatement pst = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(remove);
        pst.setInt(1, idUser);
        return pst.executeUpdate();
	} catch (SQLException e){ System.out.println("remove problm : "+e.getMessage());return -1; }
    }

 
}










