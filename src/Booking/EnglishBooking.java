package Booking;


/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:00
 */
public class EnglishBooking extends Booking{

	private  String head;
	private  String body;
	private  String footer;

	public EnglishBooking(String head, String body, String footer){
		this.head=head;
		this.body=body;
		this.footer=footer;

	}
	public String print(){
		String info = "";
		info += "This is the Header:"+ head +"\n";
		info += "This is the body:"+ body +"\n";
		info += "This is the footer:"+ footer + "\n";
		return info;
	}



}//end EnglishBooking