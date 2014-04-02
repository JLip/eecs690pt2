import java.sql.*;

import javax.swing.JOptionPane;

import org.sqlite.SQLiteDataSource;

public class SQLiteJDBC
{
  public static void main( String args[] )
  {
		if(Connection.Connect() == false) {
			JOptionPane.showMessageDialog(null, "Error connecting to the database.");	
			}
			else
			try {				
						Test();		
			}
		catch (Exception e)
		{
			e.printStackTrace();
			
		}
		
  }
 
  
public static void Test()
{
    java.sql.Connection c;
    Statement stmt;
    try {
        Class.forName("org.sqlite.JDBC");        
        stmt = Connection.con.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM Price;" );
        while ( rs.next() ) {           
           String  name = rs.getString("Service");           
           String  address = rs.getString("animal");
           double salary = rs.getDouble("Price");           
           System.out.println( "NAME = " + name );           
           System.out.println( "ADDRESS = " + address );
           System.out.println( "SALARY = " + salary );
           System.out.println();
        }
        rs.close();
        stmt.close();
        
      } catch ( Exception e ) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        JOptionPane.showMessageDialog(null,  e.getClass().getName() + ": " + e.getMessage() );	
        //System.exit(0);
      }
 
  }
}