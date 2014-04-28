public class dayItem{
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