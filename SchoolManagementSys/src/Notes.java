import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Notes {
	  public static void main(String[] args) throws SQLException {
		  
		  Connection connection = null;
		try {
			  String driverName = "org.mariadb.jdbc.Driver";
			  
			  Class.forName(driverName);
			 
			 
			  String serverName = "localhost";
			 
			  String schema = "school";
			 
			  String url = "jdbc:mariadb://" + serverName +  "/" + schema;
			 
			  String username = "root";
			 
			  String password = "1234";
			 
			  connection = DriverManager.getConnection(url, username, password);
			 
			   
			 
			  System.out.println("Successfully Connected to the database!");
			 
			   
			    } catch (ClassNotFoundException e) {
			 
			  System.out.println("Could not find the database driver " + e.getMessage());
			    } catch (SQLException e) {
			 
			  System.out.println("Could not connect to the database " + e.getMessage());
			    }
    	Statement statement = connection.createStatement();
    	
    	// If you want to learn someone else's avg note, just change the "elizaolsen"!
    	ResultSet rs = statement.executeQuery("SELECT avg(elizaolsen) from notes"); 
    	if(rs.next())
    	    System.out.println("Avg note is " + rs.getInt(1));
    	
    	// I chase the avg_note is 50, if you think that it's too much big or small you can change it anyway.
    	
    	int avg_note = 50;
    	if(rs.getInt(1) >= avg_note) {
    		System.out.println("Passed");
    	}else if(rs.getInt(1) <= avg_note) {
    		System.out.println("Failed");
    	}
	  }
	  

}
