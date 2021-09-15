package ViewController;

import Booking.Booking;
import Booking.BookingService;
import Booking.BookingType;
import Person.Person;
import Resource.ResourceSelection;

public class BookingController implements CommandController{

    private Person person;
    private ResourceSelection resource;
    private BookingType bookingType;
    private Booking booking;

    public BookingController(Person person, ResourceSelection resource, BookingType bookingType) {
        this.person = person;
        this.resource = resource;
        this.bookingType = bookingType;
    }

    @Override
    public void execute(String command) {
        switch (command){
            case"creatBooking":{
                BookingService bookingService = new BookingService(person,resource);
                bookingService.createBooking(bookingType);
                this.booking = bookingService.getBooking();
            }
        }
    }

    public Booking getBooking(){
        return booking;
    }

}
