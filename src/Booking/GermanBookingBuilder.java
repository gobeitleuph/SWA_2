package Booking;

public class GermanBookingBuilder implements BookingBuilder {


    private String footer;
    private String head;
    private String body;


    @Override
    public void setHead(String head) {
        this.head=head;
    }

    @Override
    public void setBody(String body) {
        this.body=body;
    }

    @Override
    public void setFooter(String footer) {
        this.footer=footer;
    }

    @Override
    public GermanBooking getResult() {
        return new GermanBooking(head,body,footer);

    }
}
