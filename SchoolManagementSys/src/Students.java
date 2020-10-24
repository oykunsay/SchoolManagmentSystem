import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class Students {

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
    	
    	// You can duplicate it and add more data to your table!
    	
        statement.executeUpdate("INSERT INTO students " + "VALUES (4,'liza' , 'derrem', 'passed')");
}
}