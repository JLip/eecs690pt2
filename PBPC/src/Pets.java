import java.text.DecimalFormat;


public class Pets {
	
	private int ID;
	private String name;
	private String animal;
	private String size;
		
	//Get functions
	public int getID() { return ID; }
	public String getname() { return name; }
	public String getsize() { return size; }
	public String getanimal() { return animal; }
	
	
	//Set functions		
	public void setID(int id2) { ID = id2; }
	public void setitem(String itemName) { name = itemName; }
	public void setsize(String animalsize){ size = animalsize;}
	public void setanimal(String animaltype){animal = animaltype;}
	
	
	public Pets(int id2, String itemName)
	{
		ID = id2;
		name = itemName;
		
		
	}
	
	
	public Pets(String itemName)
	{
		name = itemName;		
		
	}
	
	
	
	public Pets(String itemName, int petID, String animalType, String animalSize)
	{
		name = itemName;
		ID = petID;
		animal = animalType;
		size = animalSize;
		
		
	}
	
	
	public String toString(){		
		String petName = name;
		return petName;
	}
	
	
}
