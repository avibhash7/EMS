import java.sql.*;
public class DbConnection {
	
	 static Connection con=null;
	 
	    public Connection getConn()
	    {
	    	String dbURL = "jdbc:mysql://localhost:3307/demo";
			String username = "root";
			String password = "AviHoney";
			
	        try
	        {
	            Class.forName("com.mysql.jdbc.Driver");
	            con=DriverManager.getConnection(dbURL, username, password);
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }

	        return con;        
	    }
}
