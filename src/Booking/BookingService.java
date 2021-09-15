package Booking;

import Person.*;
import Resource.ResourceSelection;

/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:00
 */
public class BookingService {

//	public void m_BookingBuilder;

	private Person person;
	private ResourceSelection resource;
	private Booking booking;
	public BookingService(Person pers, ResourceSelection res){
		this.person=pers;
		this.resource=res;

	}

	public void finalize() throws Throwable {

	}


	public boolean createBooking(BookingType type){
		switch(type) {
			case GermanBooking:
				BookingBuilder gmbb = new GermanBookingBuilder();
				createGermanBooking(gmbb);
				this.booking=gmbb.getResult();
				break;

			case EnglishBooking:
				BookingBuilder engbb = new EnglishBookingBuilder();
				this.booking=engbb.getResult();
				createEnglishBooking(engbb);
				break;
		}
		booking.setPerson(person);
		booking.setResource(resource);
		return true;
	}

	public void createGermanBooking(BookingBuilder bookingBuilder){

		bookingBuilder.setHead("Buchung von"+ person.getName());
		bookingBuilder.setBody("Sie habe folgende Resource ausgewählt: "+resource.getLabel());
		bookingBuilder.setBody("Vielen Dank");
	}

	public void createEnglishBooking(BookingBuilder bookingBuilder) {
		bookingBuilder.setHead("Booking of "+ person.getName());
		bookingBuilder.setBody("You choosed the Resource: "+ resource.getLabel());
		bookingBuilder.setFooter("Regards ");
	}

	public Booking getBooking() {
		return booking;
	}
}//end BookingDirector