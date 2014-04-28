public class dayItem{
	
	public dayItem(){
		ken11 = "";
		ken12 = "";
		ken13 = "";
		ken14 = "";
		ken15 = "";
		ken16 = "";
		ken21 = "";
		ken22 = "";
		ken23 = "";
		ken24 = "";
		ken25 = "";
		ken26 = "";
		ken27 = "";
		ken28 = "";
	}
	
	public dayItem(dayItem init){
		ken11 = init.ken11;
		ken12 = init.ken12;
		ken13 = init.ken13;
		ken14 = init.ken14;
		ken15 = init.ken15;
		ken16 = init.ken16;
		ken21 = init.ken21;
		ken22 = init.ken22;
		ken23 = init.ken23;
		ken24 = init.ken24;
		ken25 = init.ken25;
		ken26 = init.ken26;
		ken27 = init.ken27;
		ken28 = init.ken28;
	}
	
	public	String ken11 = "";
	public	String ken12 = "";
	public	String ken13 = "";
	public 	String ken14 = "";
	public 	String ken15 = "";
	public 	String ken16 = "";

	public 	String ken21 = "";
	public 	String ken22 = "";
	public 	String ken23 = "";
	public 	String ken24 = "";
	public 	String ken25 = "";
	public 	String ken26 = "";
	public 	String ken27 = "";
	public	String ken28 = "";
		
	public boolean isFull(){
		System.out.println("Is this dayItem full?");
		if(ken11 != "" && ken12 != "" && ken13 != "" && ken14 != "" && ken15 != "" && ken16 != ""
				 && ken21 != "" && ken22 != "" && ken23 != "" && ken24 != ""
				 && ken25 != "" && ken26 != "" && ken27 != "" && ken28 != ""){
			System.out.println("It is.");
			return true;
		}
		System.out.println("It is not.");
		return false;
	}
	public boolean isEmpty(){
		System.out.println("Is this dayItem empty?");
		if(ken11 == "" && ken12 == "" && ken13 == "" && ken14 == "" && ken15 == "" && ken16 == ""
				 && ken21 == "" && ken22 == "" && ken23 == "" && ken24 == ""
				 && ken25 == "" && ken26 == "" && ken27 == "" && ken28 == ""){
			System.out.println("It is.");
			return true;
		}
		System.out.println("It is not.");
		return false;
	}
}