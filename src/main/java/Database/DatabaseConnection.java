package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	 private static Connection con = null;
	  
	    static
	    {
	    	String url = "jdbc:mysql://localhost:3306/beautyupclub";
	        String user = "root";
	        String pass = "password";
	       
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection(url, user, pass);
	            System.out.println("Database is connected.");
	        }
	        catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    public static Connection getConnection()
	    {
	        return con;
	    }
	

	
	
}
