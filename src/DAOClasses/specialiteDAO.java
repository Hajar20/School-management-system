package DAOClasses;

import java.sql.*;
import java.util.ArrayList;

import Model.Specialite;
import jdbc.connection.ConnectionJdbc;

public class specialiteDAO {
  private final String insert = "insert into spécialité values (?,?)";
  private final String insert2 = "insert into classe values(?,?,?)";
  private final String remove = "delete from spécialité where idF = ?";

  private final String update = "Update spécialité set Nom = ? where idF = ?";
  private final String selectAll = "select * from spécialité";
  private final String selectOne = "select * from spécialité where idF = ?";
  private final String codeF = "select max(idF) from spécialité";
  private final String idClass = "select max(idClass) from classe";
  private final String selectOneEns = "select * from classens  where idUser = ?";
  
  
 public ArrayList<Specialite> getClassEns(int id){
	  ArrayList<Specialite> listFilieres = new ArrayList<Specialite>(); 
	  try {
        		    PreparedStatement ps = ConnectionJdbc.getInstance().getCnx().prepareStatement("select *  from classe  inner join  spécialité inner join classens where classe.idClass=classens.idClass and classe.idF= spécialité.idF and idUser=?");
					ps.setInt(1, id);
					ResultSet R = ps.executeQuery();
				 
				 while (R.next()) {
					
			 listFilieres.add(new Specialite(R.getInt(1),R.getInt(2),R.getString(5),R.getString(3)));}
	  } catch(SQLException e){
		 System.out.println("erreur displayAllEnsan : "+e.getMessage());
	  } 
	 
	  return listFilieres;
  } 
  
  public ArrayList<Specialite> displayAllEnsan(int id){
	  ArrayList<Specialite> listFilieres = new ArrayList<Specialite>(); 
	  try {
		  PreparedStatement pst = ConnectionJdbc.getInstance().getCnx().prepareStatement(selectOneEns);
			 pst.setInt(1, id);
			 ResultSet rs = pst.executeQuery();
			 while (rs.next()) {
				 PreparedStatement pst1 = ConnectionJdbc.getInstance().getCnx().prepareStatement("select * from classe where idClass=?");
				 pst1.setInt(1, rs.getInt(1));
				 ResultSet rs1 = pst1.executeQuery(); 
				 while (rs1.next()) {
					
			 listFilieres.add(new Specialite(rs1.getInt(2),rs1.getString(3)));}}
	  } catch(SQLException e){
		 System.out.println("erreur displayAllEnsan : "+e.getMessage());
	  }
	  return listFilieres;
  } 
  public ArrayList<Specialite> displayAllEns(int id){
	  ArrayList<Specialite> listFilieres = new ArrayList<Specialite>(); 
	  try {
		  PreparedStatement pst = ConnectionJdbc.getInstance().getCnx().prepareStatement(selectOneEns);
			 pst.setInt(1, id);
			 ResultSet rs = pst.executeQuery();
			 while (rs.next()) {
				 PreparedStatement pst1 = ConnectionJdbc.getInstance().getCnx().prepareStatement("SELECT * FROM classe INNER JOIN spécialité WHERE classe.idF = spécialité.idF and `idClass`=?");
				 pst1.setInt(1, rs.getInt(1));
				 ResultSet rs1 = pst1.executeQuery(); 
				 while (rs1.next()) {
					
			 listFilieres.add(new Specialite(rs1.getInt(2),rs1.getString("Nom"),rs1.getInt("idClass")));}}
	  } catch(SQLException e){
		 System.out.println("erreur : "+e.getMessage());
	  }
	  return listFilieres;
  } 
  public int addFiliere(Specialite sp){
	  try {
		  int ids;
		  Statement st = ConnectionJdbc.getInstance().getCnx().createStatement();
		  ResultSet rs = st.executeQuery(codeF);
		  if (rs.next())
			  ids = ( (rs.getInt(1)) + 1);
		  else
			  ids = 1;
		  PreparedStatement stp = ConnectionJdbc.getInstance().getCnx().prepareStatement(insert);
		  stp.setInt(1, ids);
		  stp.setString(2, sp.getNomSp());
		  
		  int idC;
		  Statement st1 = ConnectionJdbc.getInstance().getCnx().createStatement();
		  ResultSet rs1 = st1.executeQuery(idClass);
		  if (rs1.next())
			  idC = ( (rs1.getInt(1)) + 1);
		  else
			  idC = 1;
		  
		  PreparedStatement stp2 = ConnectionJdbc.getInstance().getCnx().prepareStatement(insert2);
		  stp2.setInt(1, idC);
		  stp2.setInt(2, ids);
		 stp2.setString(3, "1ere annee");
		 PreparedStatement stp3 = ConnectionJdbc.getInstance().getCnx().prepareStatement(insert2);
		 idC++ ;
		 stp3.setInt(1, idC);
		  stp3.setInt(2, ids);
		 stp3.setString(3, "2eme annee");
		  return stp.executeUpdate() + stp2.executeUpdate()+ stp3.executeUpdate();
	  } catch(SQLException e){
		  e.printStackTrace();
		  return -1;
	  }
  }
  
  public int removeFiliere(int idF){
	int p1=0;
	try {
	    PreparedStatement pst = ConnectionJdbc.getInstance().getCnx().prepareStatement(remove);
	    pst.setInt(1, idF);
	    p1 = pst.executeUpdate();  
		return p1;
	}  catch(SQLException e){
		e.printStackTrace();
	     System.out.println("p1 :"+p1);
		return -1;
	}
  }
  
  public int updateFiliere (Specialite sp){
	  try {
		  PreparedStatement pst = ConnectionJdbc.getInstance().getCnx().prepareStatement(update);
		  pst.setString(1, sp.getNomSp());
		  pst.setInt(2, sp.getIdSp());
		  return pst.executeUpdate();
	  } catch(SQLException e){
		  e.printStackTrace();
		  return -1;
	  }
  }
  
  public ArrayList<Specialite> displayAll(){
	  ArrayList<Specialite> listFilieres = new ArrayList<Specialite>(); 
	  try {
		 Statement st = ConnectionJdbc.getInstance().getCnx().createStatement();
		 ResultSet rs = st.executeQuery(selectAll);
		 while (rs.next())
			 listFilieres.add(new Specialite(rs.getInt(1),rs.getString(2)));
	  } catch(SQLException e){
		 System.out.println("erreur : "+e.getMessage());
	  }
	  return listFilieres;
  } 
  
  public Specialite displayOne(int idF){
	  Specialite spec = null; 
	  try {
		 PreparedStatement pst = ConnectionJdbc.getInstance().getCnx().prepareStatement(selectOne);
		 pst.setInt(1, idF);
		 ResultSet rs = pst.executeQuery();
		 if(rs.next())
			 spec = new Specialite(rs.getInt(1),rs.getString(2));
	  } catch(SQLException e){
		  e.printStackTrace();
	  }
	  return spec;
  }
  
  
}

