public class dayItem{
	String ken11 = "";
	String ken12 = "";
	String ken13 = "";
	String ken14 = "";
	String ken15 = "";
	String ken16 = "";

	String ken21 = "";
	String ken22 = "";
	String ken23 = "";
	String ken24 = "";
	String ken25 = "";
	String ken26 = "";
	String ken27 = "";
	String ken28 = "";
		
	boolean isFull(){
		if(ken11 != "" && ken12 != "" && ken13 != "" && ken14 != "" && ken15 != "" && ken16 != ""
				 && ken21 != "" && ken22 != "" && ken23 != "" && ken24 != ""
				 && ken25 != "" && ken26 != "" && ken27 != "" && ken28 != ""){
			return true;
		}
		return false;
	}
	boolean isEmpty(){
		if(ken11 == "" && ken12 == "" && ken13 == "" && ken14 == "" && ken15 == "" && ken16 == ""
				 && ken21 == "" && ken22 == "" && ken23 == "" && ken24 == ""
				 && ken25 == "" && ken26 == "" && ken27 == "" && ken28 == ""){
			return true;
		}
		return false;
	}
}