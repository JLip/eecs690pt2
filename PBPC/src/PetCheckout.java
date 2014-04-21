import java.text.DecimalFormat;


public class PetCheckout {
	
	private int ID;
	private String item;
	private double price;
		
	//Get functions
	public int getID() { return ID; }
	public String getitem() { return item; }
	public double getprice() { return price;}
	
	//Set functions		
	public void setID(int id2) { ID = id2; }
	public void setitem(String itemName) { item = itemName; }
	public void setprice(double itemPrice) { price = itemPrice;}
	
	public PetCheckout(int id2, String itemName, double itemPrice)
	{
		ID = id2;
		item = itemName;
		price = itemPrice;
	}
	
	
	public PetCheckout(String itemName)
	{
		item = itemName;		
	}
	
	public PetCheckout(String itemName, double itemPrice)
	{
		item = itemName;
		price = itemPrice;		
	}
	
	
	public String toString(){
		String priceFormat =  new DecimalFormat("#.##").format(price);
		String ItemAndPrice = item + " - $" + priceFormat;
		return ItemAndPrice;
	}
	
	
}
