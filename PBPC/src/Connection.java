import java.io.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;

public class Connection {

public static Statement stmt;
public static java.sql.Connection con;



public static boolean Connect(){

	 
	    try {
	      Class.forName("org.sqlite.JDBC");
	      con = DriverManager.getConnection("jdbc:sqlite:References/TeamGoogleIt.db");
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      return false;
	    }
	    
	    return true;

}

public static void Close()
{
	try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

}

