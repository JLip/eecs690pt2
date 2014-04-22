import java.sql.ResultSet;
import java.sql.SQLException;


public class Query {

	public static String ItemQuery(int id)
	{
		Connection.Connect();
		String commandText = "SELECT * from Price WHERE ItemID = " + id;
		ResultSet rs;
		String name = "";
		try{
			//Execute command
			rs = SQL.ExecuteResultSet(commandText); 
		
			while (rs.next()) {				
				name = rs.getString("Service");				
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	
		
		return name;
		
	}
	
	public static double PriceQuery(int id)
	{
		Connection.Connect();
		String commandText = "SELECT * from Price WHERE ItemID = " + id;
		ResultSet rs;
		double price = 0;
		try{
			//Execute command
			rs = SQL.ExecuteResultSet(commandText); 
		
			while (rs.next()) {				
				price = rs.getDouble("Price");
				
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return price;
		
	}
	
}
