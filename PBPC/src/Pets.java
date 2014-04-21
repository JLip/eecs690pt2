import java.text.DecimalFormat;


public class Pets {
	
	private int ID;
	private String name;
	
		
	//Get functions
	public int getID() { return ID; }
	public String getname() { return name; }
	
	//Set functions		
	public void setID(int id2) { ID = id2; }
	public void setitem(String itemName) { name = itemName; }

	
	public Pets(int id2, String itemName)
	{
		ID = id2;
		name = itemName;
		
		
	}
	
	
	public Pets(String itemName)
	{
		name = itemName;		
		
	}
	
	
	
	public Pets(String itemName, int petID)
	{
		name = itemName;
		ID = petID;
		
		
	}
	
	
	public String toString(){		
		String ItemAndPrice = name;
		return ItemAndPrice;
	}
	
	
}
