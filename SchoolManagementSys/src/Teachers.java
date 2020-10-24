import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Teachers {

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
  	  statement.executeUpdate("INSERT INTO teachers " + "VALUES (3, 'parker rey', 'PE')");
	  }
	  
}