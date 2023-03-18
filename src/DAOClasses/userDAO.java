package DAOClasses;

import java.sql.*;
import java.util.ArrayList;

import jdbc.connection.ConnectionJdbc;
import Model.Utilisateur;

public class userDAO {

	private final String idRequet = "select max(idUser) from utilisateur";
	private final String idCc = "select idCc from contrôlecontinu where idUser = ?";
	private final String insert = "insert into utilisateur (idUser,Nom,Prenom,Email,Matricule,DateNaissance,LieuNaissance,Adresse,Login,MotDePass,role) values (?,?,?,?,?,?,?,?,?,?,?)"; 
	
	private final String delete = "delete from utilisateur where idUser = ?";
	private final String updateImg = "update utilisateur set Image = ? where idUser= ? ";
	private final String update = "update utilisateur set Nom = ?,Prenom = ?,Email = ?,Matricule = ?,DateNaissance = ?,LieuNaissance = ?,Adresse = ?,Login = ?,MotDePass = ?,role = ? where idUser=?";
	private final String selectUser = "select * from utilisateur where idUser = ?";
	private final String selectAll = "select * from utilisateur where role = ?";
	private final String image = "select Image from utilisateur where idUser = ?";
	private final String selectEtudClass = "SELECT etudclass.idUser,concat(Nom,\" \",Prenom )from etudclass  INNER JOIN utilisateur where etudclass.idUser=utilisateur.idUser and idClass=?";
	
	
	
	public ArrayList<Utilisateur> selectEtudClass(int idClass){
		ArrayList<Utilisateur> listUsers = new ArrayList<Utilisateur>();
		try {
			PreparedStatement ps = ConnectionJdbc.getInstance().getCnx().prepareStatement(selectEtudClass);
			ps.setInt(1, idClass);
			ResultSet R = ps.executeQuery();
			while (R.next()){
				listUsers.add(new Utilisateur(R.getInt(1),R.getString(2)));
			}
			return listUsers;
		} catch (SQLException e) {System.out.println("Erreur : "+e.getMessage()); return null;}
		
	}
	public int idCc(int idU){
		int id=0;
		try {
			PreparedStatement pst = ConnectionJdbc.getInstance().getCnx().prepareStatement(idCc);
   	     pst.setInt(1,idU);
   	     ResultSet rs = pst.executeQuery();
   	     if (rs.next())
   	    	 id = rs.getInt(1);
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return id;
	}
	
	//changer une image
	 public int updatePic(String img,int idu){
		 try {
    		 PreparedStatement pst = ConnectionJdbc.getInstance().getCnx().prepareStatement(updateImg);
    	     pst.setString(1,img);
    	     pst.setInt(2, idu);

             return pst.executeUpdate();
    	 }catch (SQLException e){e.printStackTrace(); return -1;}
	 }
	
	//recupérer une image
     public String photo(int id){
    	 String picture=null;
    	 try {
    		 PreparedStatement pst = ConnectionJdbc.getInstance().getCnx().prepareStatement(image);
    	     pst.setInt(1,id);
    		 ResultSet r = pst.executeQuery();
    		 if (r.next())
    			 picture = r.getString("Image");
    	 }catch (SQLException e){e.printStackTrace();}
		 return picture;
     }
	
	//Method to add new user
	public boolean addUser(Utilisateur u){
		boolean et;
		try {
		Statement st = ConnectionJdbc.getInstance().getCnx().createStatement();
		ResultSet r = st.executeQuery(idRequet);
		int id;
		if (r.next())
			id = ((r.getInt(1)) + 1 );
	    else 
	    	id = 1;
		PreparedStatement ps = ConnectionJdbc.getInstance().getCnx().prepareStatement(insert);
		ps.setInt(1, id);
		ps.setString(2, u.getNom());
		ps.setString(3, u.getPrenom());
		ps.setString(4, u.getEmail());
		ps.setString(5, u.getMatricule());
		ps.setString(6, u.getDateN());
		ps.setString(7, u.getLieu());
		ps.setString(8, u.getAdresse());
		ps.setString(9, u.getLogin());
		ps.setString(10, u.getPassword());
		ps.setString(11	, u.getRole());
		et = ps.executeUpdate() > 0;
		return et;
		} catch (SQLException e) { e.printStackTrace(); return false;}
	}
	
	// Method to select one user
	public Utilisateur selectUser(int idUser){
		Utilisateur user = null;
		try {
			PreparedStatement ps = ConnectionJdbc.getInstance().getCnx().prepareStatement(selectUser);
			ps.setInt(1, idUser);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				int id = rs.getInt(1);
				String nom = rs.getString(2);
				String prenom = rs.getString(3);
				String email = rs.getString(4);
				String matricule = rs.getString(5);
				String DateN = rs.getString(6);
				String lieu = rs.getString(7);
				String Adresse = rs.getString(8);
				String login = rs.getString(9);
				String password = rs.getString(10);
				String role = rs.getString(12);
				user = new Utilisateur(id,nom,prenom,email,matricule,DateN,lieu,Adresse,login,password,role);
			}
		} catch (SQLException e) { e.printStackTrace(); }
		return user;
	}
	
	//Method to select all the users 
	public ArrayList<Utilisateur> selectAllUsers(String role){
		ArrayList<Utilisateur> listUsers = new ArrayList<Utilisateur>();
		try {
			PreparedStatement ps = ConnectionJdbc.getInstance().getCnx().prepareStatement(selectAll);
			ps.setString(1, role);
			ResultSet R = ps.executeQuery();
			while (R.next()){
				listUsers.add(new Utilisateur(R.getInt(1),R.getString(2),R.getString(3),R.getString(4),R.getString(5),R.getString(6),R.getString(7),R.getString(8),R.getString(9),R.getString(10),R.getString(12)));
			}
			return listUsers;
		} catch (SQLException e) {System.out.println("Erreur : "+e.getMessage()); return null;}
		
	}
	 
	//Method to remove an user
	public boolean deleteUser(int idUser){
		boolean i = false;
		try {
			PreparedStatement ps = ConnectionJdbc.getInstance().getCnx().prepareStatement(delete);
			ps.setInt(1, idUser);
			i =  ps.executeUpdate() > 0;
		} catch (SQLException e) { e.printStackTrace(); }
		return i;
	}
	
	//Method to update an user
	public boolean updateUser(Utilisateur user){
		boolean j=false;
		try {
			PreparedStatement ps = ConnectionJdbc.getInstance().getCnx().prepareStatement(update);
			ps.setString(1, user.getNom());
			ps.setString(2, user.getPrenom());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getMatricule());
			ps.setString(5, user.getDateN());
			ps.setString(6, user.getLieu());
			ps.setString(7, user.getAdresse());
			ps.setString(8, user.getLogin());
			ps.setString(9, user.getPassword());
			ps.setString(10, user.getRole());
			ps.setInt(11, user.getIdUser());
			j = ps.executeUpdate() > 0;
		} catch(SQLException ex) { ex.printStackTrace(); }
		return j;
	}	
	
	
	
	
	
		
	
}
