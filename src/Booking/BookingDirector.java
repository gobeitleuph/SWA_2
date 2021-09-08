package Booking;


/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:00
 */
public class BookingDirector {

//	public void m_BookingBuilder;

	public BookingDirector(){

	}

	public void finalize() throws Throwable {

	}



	public void createBooking(GermanBooking booking){
		BookingBuilder.setHead("Deutsche Überschrift");
		BookingBuilder.setBody("Deutscher Inhalt");

	}

	public void createBooking(EnglishBookingBuilder builder) {
		BookingBuilder.setHead("Englische Überschrift");
		BookingBuilder.setBody("EnglischerInhalt");

	}
}//end BookingDirector