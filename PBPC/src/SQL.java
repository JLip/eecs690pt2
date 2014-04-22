import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;



public class SQL {

public static Connection connection;
public static Statement statement;


public static void ExecuteQuery(String query){
	
	java.sql.Connection c = Connection.con;
	java.sql.Statement stmt = Connection.stmt;
    
      try {
		stmt = c.createStatement();
		  stmt.executeQuery(query);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    

	
	
}

public static ResultSet ExecuteResultSet(String query){
	
	ResultSet rs = null;	
	java.sql.Connection c = Connection.con;
	java.sql.Statement stmt = Connection.stmt;
	
	 try {
			stmt = c.createStatement();
			  rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	 
	   
	return rs;
	
	
}

	public static void UpdateResultSet(String query){

		
		java.sql.Connection c = Connection.con;
		java.sql.Statement stmt = Connection.stmt;
	    
	      try {
			stmt = c.createStatement();
			  stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}


}