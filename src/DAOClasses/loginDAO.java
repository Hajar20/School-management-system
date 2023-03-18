package DAOClasses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.connection.ConnectionJdbc;
import Model.Utilisateur;

public class loginDAO {
	private final String login ="select * from utilisateur where Login = ? and MotDePass = ?";
	public boolean validateForm(Utilisateur user){
    	boolean etat = false;
    	try {
			PreparedStatement PS = ConnectionJdbc.getInstance().getCnx().prepareStatement(login);
			PS.setString(1, user.getLogin());
			PS.setString(2, user.getPassword());
			ResultSet rs = PS.executeQuery();
			etat = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return etat;
    }
	public int idUser(String l,String mdp){
		int idu = 0;
		try {
			PreparedStatement PS = ConnectionJdbc.getInstance().getCnx().prepareStatement(login);
			PS.setString(1, l);
			PS.setString(2, mdp);
			ResultSet rs = PS.executeQuery();
			while (rs.next())
				idu = rs.getInt(1);
		} catch(SQLException e){
			e.printStackTrace();
		}
		return idu;
	}
	public String role(String l,String mdp){
		String role = null;
		try {
			PreparedStatement PS = ConnectionJdbc.getInstance().getCnx().prepareStatement(login);
			PS.setString(1, l);
			PS.setString(2, mdp);
			ResultSet rs = PS.executeQuery();
			while (rs.next())
				role = rs.getString(12);
		} catch(SQLException e){
			e.printStackTrace();
		}
		return role;
	}
}
