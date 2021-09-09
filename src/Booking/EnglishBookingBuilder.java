package Booking;

public class EnglishBookingBuilder implements BookingBuilder{
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

    public EnglishBooking getResult() {
        return new EnglishBooking(head,body,footer);

    }

}
