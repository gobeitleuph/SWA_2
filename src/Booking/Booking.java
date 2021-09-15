package Booking;


import Person.Person;
import Resource.ResourceSelection;

public abstract class Booking {
    private Person person;
    private ResourceSelection resource;
    private String head;
    private String body;
    private String footer;    
    
    private String all;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ResourceSelection getResource() {
        return resource;
    }

    public void setResource(ResourceSelection resource) {
        this.resource = resource;
    }

    public abstract String print();
}


