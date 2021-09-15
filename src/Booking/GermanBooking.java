package Booking;


import Person.Person;
import Resource.ResourceSelection;

/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:00
 */
public class GermanBooking extends Booking{
    private Person person;
    private ResourceSelection resource;
    private  String head;
    private  String body;
    private  String footer;
    private String all;

    public GermanBooking(String head, String footer, String body){
        this.head=head;
        this.body=body;
        this.footer=footer;

    }
    public String print(){
        String info = "";
        info += "Header:"+ head +"\n";
        info += "body:"+ body +"\n";
        info += "footer:"+ footer + "\n";
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


    public String getAll() {
        return all;
    }
}