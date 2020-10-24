import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Lessons {
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
		// You can add more columns.
		//We're adding columns because we need for lessons and we need lessons' ids. 
		Statement stmt = connection.createStatement();
		String query = "ALTER TABLE lessons ADD pyshics INT NOT NULL";
	      stmt.executeUpdate(query);
	      System.out.println("Column added successfully!");
	      PreparedStatement pstmt = connection.prepareStatement("UPDATE lessons SET pyshics = 9");
	      pstmt.executeUpdate();
	  }
}
