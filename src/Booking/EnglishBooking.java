package Booking;


import Person.Person;
import Resource.ResourceSelection;

/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:00
 */
public class EnglishBooking extends Booking{
	private Person person;
	private ResourceSelection resource;
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
		info += "This is the Header:"+ head +"";
		info += "This is the body:"+ body +"";
		info += "This is the footer:"+ footer + "";
		return info;
	}

	@Override
	public Person getPerson() {
		return person;
	}

	@Override
	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public ResourceSelection getResource() {
		return resource;
	}

	@Override
	public void setResource(ResourceSelection resource) {
		this.resource = resource;
	}





}//end EnglishBooking