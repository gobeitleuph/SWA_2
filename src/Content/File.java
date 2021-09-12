package Content;


/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:00
 */
public class File extends Content {

	private String name;
	private Booking booking;
	private Payment payment;

	public File(String name){
		this.name = name;
	}

	public void setBooking (Booking booking){
		this.booking = booking;
	}

	public Booking getBooking(){
		return booking;
	}

	public void setPayment (Payment payment){
		this.payment = payment;
	}

	public Payment getPayment(){
		return payment;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return super.name;
	}

}//end File