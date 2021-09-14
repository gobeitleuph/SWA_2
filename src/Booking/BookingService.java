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
	public BookingService(Person pers, ResourceSelection res){
		this.person=pers;
		this.resource=res;

	}

	public void finalize() throws Throwable {

	}



	public boolean createGermanBooking(BookingBuilder bookingBuilder){
		bookingBuilder.setHead("Buchung von"+ person.getName());
		bookingBuilder.setBody("Deutscher Inhalt"+resource.getLabel());
		return true;
	}

	public boolean createEnglishBooking(BookingBuilder bookingBuilder) {
		bookingBuilder.setHead("Booking of"+ person.getName());
		bookingBuilder.setBody("EnglischerInhalt");
		bookingBuilder.setFooter(resource.getLabel());
		return true;
	}



}//end BookingDirector