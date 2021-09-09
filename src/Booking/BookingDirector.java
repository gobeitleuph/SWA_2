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



	public boolean createGermanBooking(BookingBuilder bookingBuilder){
		bookingBuilder.setHead("Deutsche Überschrift");
		bookingBuilder.setBody("Deutscher Inhalt");
		return true;
	}

	public void createEnglishBooking(BookingBuilder bookingBuilder) {
		bookingBuilder.setHead("Englische Überschrift");
		bookingBuilder.setBody("EnglischerInhalt");

	}



}//end BookingDirector