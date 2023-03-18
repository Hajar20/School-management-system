package DAOClasses;

import java.sql.*;
import java.util.*;

import com.mysql.jdbc.PreparedStatement;

import jdbc.connection.ConnectionJdbc;
import Model.Module;

public class moduleDAO {	
	private final String selectAllbyLevel = " SELECT module.idMod,Nom_mod,Coif_mod, Nom_unite ,CONCAT(Nom,' ',Prenom) FROM module  INNER JOIN unité un ON module.idUni = un.idUni INNER JOIN usermodule um ON module.idMod  = um.idMod INNER JOIN utilisateur u ON u.idUser = um.idUser INNER JOIN moduleclass mc ON mc.idMod = module.idMod  INNER JOIN classe cc ON cc.idClass = mc.idClass WHERE idF = ? and Niveau = ?";
	private final String selectAll = "SELECT module.idMod,Nom_mod, Coif_mod, Nom_unite FROM module  INNER JOIN unité u ON module.idUni = u.idUni INNER JOIN moduleclass mc ON module.idMod = mc.idMod INNER JOIN classe c ON c.idClass = mc.idClass WHERE idF = ? ";
	private final String selectOne = "select * from module where idMod = ?";

	private final String insert = "insert into module values(?,?,?,?)";
    private final String insert2 = "insert into moduleclass values(?,?)";
    private final String insert3 = "insert into usermodule values(?,?)";
	
    private final String update = "update module set Nom_mod=?,Coif_mod=?,idUni=? where idMod =?";
    private final String update2 = "update usermodule set idUser = ? where idMod=?";
    
    private final String remove = "delete from module where idMod = ?";
    
    private final String idMod = "select max(idMod) from module";
    private final String idUni = "select idUni from unité where Nom_unite = ?";
    private final String idClass = "select idClass from classe where idF = ? and Niveau =?";
    private final String idUser = "select idUser from utilisateur where CONCAT( Nom,' ',Prenom ) = ?";
    //private final String fullName = "select CONCAT( Nom,' ',Prenom ) from utilisateur where idUser = ?";
      
    public Module OneMod(int idMod,String prof,String u){
    	Module m = null;
    	try {
    		PreparedStatement pst = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(selectOne);
    		pst.setInt(1, idMod);
    		ResultSet rs = pst.executeQuery();
    		if (rs.next())
    			m = new Module(rs.getInt(1),rs.getString(3),rs.getInt(4),u,prof);
    		
    	} catch (SQLException e){ e.printStackTrace(); }
    	return m;
    }
    public int updateMod(Module mod){
    	int etat = 0;
    	try {
    		int idU =0;
    		int idUs =0;
    		
    		PreparedStatement pst1 = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(idUni);
    	    pst1.setString(1, mod.getUnite());
    	    ResultSet rst = pst1.executeQuery();
    	    if (rst.next())
    	    	idU = rst.getInt(1);
    	    
    	    System.out.println("id Unité :"+idU);
    		////
    	    PreparedStatement pst2 = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(idUser);
    	    pst2.setString(1, mod.getProfesseur());
    	    ResultSet rss = pst2.executeQuery();
    	    if (rss.next())
    	    	idUs = rss.getInt(1);
    	    
    	    System.out.println("id user :"+idUs);
    	    ////
    		PreparedStatement pst = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(update);
    		pst.setString(1, mod.getNomMod());
    		pst.setInt(2, mod.getCoiff());
    		pst.setInt(3, idU);
    		pst.setInt(4, mod.getIdMod());
    		
    		PreparedStatement ps = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(update2);
    		ps.setInt(1, idUs);
    		ps.setInt(2, mod.getIdMod());
    		if (idUs == 0 || idU == 0)
    		etat = pst.executeUpdate() ;
    		
    		etat = pst.executeUpdate()+ps.executeUpdate();
    	} catch (SQLException e){ e.printStackTrace(); }
    	
    	return etat;
    }
    
    public int  removeMod(int idMod){
    	int etat = 0;
    	try {
    		PreparedStatement pst = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(remove);
    		pst.setInt(1, idMod);
    		etat =  pst.executeUpdate();
    		
    	} catch (SQLException e){ e.printStackTrace(); }
    	return etat;
    }
    
    public int addMod(Module mod,int idF,String nv){
    	int etat = 0;
    	try {
    		int id;
    		int idU=0;
    		int idUs =0;
    		int idC =0;
    		Statement st = ConnectionJdbc.getInstance().getCnx().createStatement();
    		ResultSet rs = st.executeQuery(idMod);
    		
    		if (rs.next())
    		id = (rs.getInt(1) + 1 );
    		else
    		id = 1;
    		////
    		PreparedStatement ps = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(idClass);
    	    ps.setInt(1, idF);
    	    ps.setString(2, nv);
    	    ResultSet r = ps.executeQuery();
    	    if (r.next())
    	    	idC = r.getInt(1);
    		////
    		PreparedStatement pst = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(idUser);
    	    pst.setString(1, mod.getProfesseur());
    	    ResultSet rss = pst.executeQuery();
    	    if (rss.next())
    	    	idUs = rss.getInt(1);
    		////
    		PreparedStatement pst1 = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(idUni);
    	    pst1.setString(1, mod.getUnite());
    	    ResultSet rst = pst1.executeQuery();
    	    if (rst.next())
    	    	idU = rst.getInt(1);
    		////
    		PreparedStatement pst2 = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(insert);
    	    pst2.setInt(1, id);
    	    pst2.setInt(2, idU);
    	    pst2.setString(3, mod.getNomMod());
    	    pst2.setInt(4, mod.getCoiff());
    	    
    	    PreparedStatement pst3 = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(insert3);
    	    pst3.setInt(1, idUs);
    	    pst3.setInt(2, id);
    	    
    	    PreparedStatement pst4 = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(insert2);
    	    pst4.setInt(1, id);
    	    pst4.setInt(2, idC);
    	    
    	    etat = pst2.executeUpdate() + pst3.executeUpdate() + pst4.executeUpdate();
    	    
    	} catch (SQLException e){ e.printStackTrace(); }
    	return etat;
    }
    
    
    
    public ArrayList<Module> modulesByF(int idF){
    	ArrayList<Module> liste = new ArrayList<Module>();
    	try {
    		PreparedStatement pst = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(selectAll);
    		pst.setInt(1, idF);
    		ResultSet rst = pst.executeQuery();
    		while (rst.next())
    			liste.add(new Module(rst.getInt(1),rst.getString(2),rst.getInt(3),rst.getString(4),null));
    		
    	} catch (SQLException e){ e.printStackTrace();}
    	return liste;
    }
    
    public ArrayList<Module> modulesByFNv(int idF,String niveau){
    	ArrayList<Module> liste = new ArrayList<Module>();
    	try {
    		PreparedStatement pst = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(selectAllbyLevel);
    		pst.setInt(1, idF);
    		pst.setString(2, niveau);
    		ResultSet rst = pst.executeQuery();
    		while (rst.next())
    			liste.add(new Module(rst.getInt(1),rst.getString(2),rst.getInt(3),rst.getString(4),rst.getString(5)));
    		
    	} catch (SQLException e){ e.printStackTrace(); }
    	return liste;
    }
    
}
