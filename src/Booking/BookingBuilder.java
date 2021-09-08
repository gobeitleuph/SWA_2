package Booking;


import Person.Person;
import Resource.Resource;

/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:00
 */
public interface BookingBuilder {

	static void setHead(String head);
	static void setBody(String body);
	void setFooter(String footer);


}