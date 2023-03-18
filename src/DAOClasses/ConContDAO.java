package DAOClasses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.mysql.jdbc.PreparedStatement;

import Model.ConCont;
import Model.Module;
import jdbc.connection.ConnectionJdbc;


public class ConContDAO {
	private final String selectModuleClass ="SELECT *FROM classeunite INNER JOIN module WHERE classeunite.idUni = module.idUni and idClass=?";

	private final String selectModuleEnsei ="SELECT *FROM usermodule INNER JOIN module WHERE usermodule.idMod = module.idMod and idUser=?";
	private final String selectidMod ="SELECT * FROM module where Nom_mod=?";
	private final String selectCC ="SELECT Nom_mod,Date_Cc,Nom,Niveau,contrôlecontinu.idCc FROM contrôlecontinu INNER JOIN module INNER JOIN classe INNER JOIN spécialité  WHERE  contrôlecontinu.idMod=module.idMod and   contrôlecontinu.idClass=classe.idClass and classe.idF=spécialité.idF  and idUser=? and contrôlecontinu.idClass =?";
	private final String selectAllCC ="SELECT  `contrôlecontinu`.idCc,`contrôlecontinu`.idClass,Date_Cc,Nom_mod,Niveau,Nom  FROM contrôlecontinu INNER JOIN module INNER JOIN classe INNER JOIN spécialité   WHERE  contrôlecontinu.idMod=module.idMod and   contrôlecontinu.idClass=classe.idClass and classe.idF=spécialité.idF and contrôlecontinu.idUser=? and contrôlecontinu.idClass =?";
	
	private final String selectNoteCC ="SELECT concat(Nom,\" \",Prenom),note.idUser,idCc,Note from note inner join Utilisateur where note.idUser=utilisateur.idUser and idCc=?";
	private final String deleteNoteCC ="delete  FROM `note` WHERE idCc= ?";
	private final String deleteCC ="DELETE FROM `contrôlecontinu` WHERE `contrôlecontinu`.`idCc` = ?";
	private final String modifiNote="update note set note=? where idUser=? and idCc=?";
	private final String insertNote1="INSERT INTO  `note`(`idUser` ,`idCc` ,Note)VALUES (?,? , ? );";
	
	private final String insertCC ="INSERT INTO  `evaluations`.`contrôlecontinu` (idUser ,idClass,idMod ,Date_Cc)VALUES( ? , ? , ? , ? );";
	private ArrayList<Module> listModuleclass;
	private ArrayList<Module> listModuleEns;
	

	public boolean addNote(int idUser,int idCC, Float Note) {
		try {
		PreparedStatement pst = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(insertNote1);
		pst.setInt(1, idUser);
		pst.setInt(2, idCC);
		pst.setFloat(3, Note);
		
		return  pst.executeUpdate()> 0 ;
		
		}catch(SQLException e){ System.out.println("Err select one module insert note 1:"+e.getMessage()); }
		return false;
	
	}
	public boolean modifiNote(int idUser,int idCC, Float Note) {
		try {
		PreparedStatement pst = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(modifiNote);
		pst.setInt(2, idUser);
		pst.setInt(3, idCC);
		pst.setFloat(1, Note);
		
		return  pst.executeUpdate()> 0 ;
		
		}catch(SQLException e){ System.out.println("Err select one module insert note 1:"+e.getMessage()); }
		return false;
	
	}
	
	public boolean addCC(int idUser,int idClasse, int idMod,String DateCC) {
		try {
		PreparedStatement pst = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(insertCC);
		pst.setInt(1, idUser);
		pst.setInt(2, idClasse);
		pst.setInt(3, idMod);
		pst.setString(4, DateCC);
		return  pst.executeUpdate()> 0 ;
		
		}catch(SQLException e){ System.out.println("Err select one module insert cc:"+e.getMessage()); }
		return false;
	
	}
	
	
	
	public ArrayList<ConCont> selectCC(int idUser,int idClass){ 
		
		ArrayList<ConCont>listModuleclass = new ArrayList<ConCont>();
		try {
		PreparedStatement pst = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(selectCC);
		pst.setInt(1, idUser);
		pst.setInt(2, idClass);
		ResultSet R = pst.executeQuery();
		while (R.next()) {
			
				listModuleclass.add(new ConCont(R.getString("Nom_mod"),R.getString("Date_Cc"), R.getString("Nom"),R.getString("Niveau"),R.getInt("idCc")));
					
			}
		return listModuleclass;
		}catch(SQLException e){ System.out.println("Err select one module select cc:"+e.getMessage()); }
		return null;
	}
	
public boolean deleteNoteCC(int idCC){ 
		
		
		try {
		PreparedStatement pst = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(deleteNoteCC);
		pst.setInt(1, idCC);
        return  pst.executeUpdate()> 0 ;
		
		}catch(SQLException e){ System.out.println("Err select one module delete note cc:"+e.getMessage()); }
		return false;

	}
public boolean deleteCC(int idCC){ 
	
	
	try {
	PreparedStatement pst = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(deleteCC);
	pst.setInt(1, idCC);
    return  pst.executeUpdate()> 0 ;
	
	}catch(SQLException e){ System.out.println("Err select one module delete cc:"+e.getMessage()); }
	return false;

}
	
public ArrayList<ConCont> selectNoteCC(int idCc){ 
	
	ArrayList<ConCont>listModuleclass = new ArrayList<ConCont>();
	try {
	PreparedStatement pst = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(selectNoteCC);
	pst.setInt(1, idCc);
	ResultSet R = pst.executeQuery();
	while (R.next()) {
		
			listModuleclass.add(new ConCont(R.getString(1),R.getInt(2), R.getInt(3),R.getFloat(4)));
				
		}
	return listModuleclass;
	}catch(SQLException e){ System.out.println("Err select one module select Note1 cc :"+e.getMessage()); }
	return null;
}	

	
	public ArrayList<ConCont> selectAllCC(int idUser,int idClass){ 
		
		ArrayList<ConCont>listModuleclass = new ArrayList<ConCont>();
		try {
		PreparedStatement pst = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(selectAllCC);
		pst.setInt(1, idUser);
		pst.setInt(2, idClass);
		ResultSet R = pst.executeQuery();
		while (R.next()) {
			
				listModuleclass.add(new ConCont(R.getString("Nom_mod"),R.getString("Date_Cc"), R.getString("Nom"),R.getString("Niveau"),R.getInt("idCc"),R.getInt("idClass")));
					
			}
		return listModuleclass;
		}catch(SQLException e){ System.out.println("Err select one module select all cc :"+e.getMessage()); }
		return null;
	}
	
	
	
	public int selectidMod(String NomModule) {
		try {
		PreparedStatement pst = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(selectidMod);
		pst.setString(1, NomModule);
		ResultSet R = pst.executeQuery();
		return R.getInt("idMod");
		}catch(SQLException e){ System.out.println("Err select one module :"+e.getMessage()); }
		return 0;
	}
	public ArrayList<Module> selectmoduleclass(int idClass){ 
		
		listModuleclass = new ArrayList<Module>();
		try {
		PreparedStatement pst = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(selectModuleClass);
		pst.setInt(1, idClass);
		ResultSet R = pst.executeQuery();
		while (R.next()) {
			
				listModuleclass.add(new Module(R.getInt("idMod"),R.getString("Nom_mod")));
					
			
		}
		return listModuleclass;
		}catch(SQLException e){ System.out.println("Err select one module :"+e.getMessage()); }
		return null;
	}
	public ArrayList<Module> selectmoduleEnsei(int idUserEnsei){ 
		
		listModuleEns = new ArrayList<Module>();
		try {
		PreparedStatement pst = (PreparedStatement) ConnectionJdbc.getInstance().getCnx().prepareStatement(selectModuleEnsei);
		pst.setInt(1, idUserEnsei);
		ResultSet R = pst.executeQuery();
		while (R.next()) {
			
				listModuleEns.add(new Module(R.getInt("idMod"),R.getString("Nom_mod")));
					
		}
		return listModuleEns;
		}catch(SQLException e){ System.out.println("Err select one module :"+e.getMessage()); }
		return null;
	}
	
	
public ArrayList<Module> selectmodule(){ 
	 ArrayList<Module> listModule = new ArrayList<Module>();
		for(int i=0;i<listModuleEns.size();i++)
		{
			for(int j=0;j<listModuleclass.size();j++)
			{
				if(listModuleEns.get(i).getNomMod().equalsIgnoreCase(listModuleclass.get(j).getNomMod())) {
					listModule.add(new Module(listModuleclass.get(j).getIdMod(),listModuleclass.get(j).getNomMod()));
				}
			}

		}
		return listModule;
	}

	
}
