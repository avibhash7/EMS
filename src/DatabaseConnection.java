//Returns a Connection object
import java.sql.*;
public class DatabaseConnection {
	
	 static Connection con=null;
	 
	    public static Connection getConn()
	    {
	    	String dbURL = "jdbc:mysql://localhost:3307/demo";
			String username = "root";
			String password = "AviHoney";
			
	        try
	        {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con=DriverManager.getConnection(dbURL, username, password);
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }

	        return con;        
	    }
}
