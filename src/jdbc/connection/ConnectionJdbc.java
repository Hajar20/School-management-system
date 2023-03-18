package jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionJdbc {
	private Connection cnx;
    private static ConnectionJdbc c=null;
    public ConnectionJdbc(){
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
   		    cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/evaluations", "root", "");
   	 
    	} catch (ClassNotFoundException e){e.printStackTrace();}
    	catch (SQLException ex){ex.printStackTrace();}
    }
    public static ConnectionJdbc getInstance(){
    	if (c==null) c=new ConnectionJdbc();
    	return c;
    }
    public Connection getCnx(){
    	return cnx;
    }
}
